package tcpClasses;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import JsonClasses.CalendarInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TCPClient {
	private Socket connectionSocketConected;
	private CalendarInfo CI = new CalendarInfo();
	private ByteCoder byteCryp = new ByteCoder();
	private String incomingJson;
	private EncryptionAES cryp =  new EncryptionAES();
	
//	public String TalkToServer (String StringFromClient) throws UnknownHostException, IOException, Exception{
//		EncryptionAES cryp = new EncryptionAES();
//		String modifiedSentence;
//
//		String gsonString = cryp.encrypt(StringFromClient);
//
//		Socket clientSocket = new Socket("localhost", 8888);
//		DataOutputStream outToServer = new DataOutputStream(
//				clientSocket.getOutputStream());
//		byte[] input = gsonString.getBytes();
//		byte key = (byte) 3.1470;
//		byte[] encrypted = input;
//		for (int i = 0; i < encrypted.length; i++)
//			encrypted[i] = (byte) (encrypted[i] ^ key);
//
//		outToServer.write(encrypted);
//		outToServer.flush();
//		DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
////		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
////				clientSocket.getInputStream()));
//		modifiedSentence = cryp.decrypt(inFromServer.readLine());
//		System.out.println("FROM SERVER: " + modifiedSentence);
//		clientSocket.close();
//		return modifiedSentence;
//	}
	
	public String TalkToServer (String StringFromClient) throws UnknownHostException, IOException, Exception{
		
	String ny = "";	
		String modifiedSentence;
		Gson gson = new GsonBuilder().create();

		Socket clientSocket = new Socket("localhost", 8888);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		byte[] input = StringFromClient.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		System.out.println(encrypted);
		outToServer.write(encrypted);
		outToServer.flush();
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		modifiedSentence = inFromServer.readLine();
		System.out.println(modifiedSentence);
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	
	return ny;
	}
	
	
}