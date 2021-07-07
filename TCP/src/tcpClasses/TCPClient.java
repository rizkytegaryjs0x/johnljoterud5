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
	
	public String TalkToServer (String StringFromClient){
		
		
		String ny = "";
	try{
		DataOutputStream outToClient = new DataOutputStream(connectionSocketConected.getOutputStream());
		String returnSvar = StringFromClient;		
		outToClient.writeBytes(cryp.encrypt(returnSvar) + "\n");
		System.out.println("besked sendt");
		System.out.println("forbindelse Oprettet!");
		//BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		byte[] b = new byte[500000];
		int count = connectionSocketConected.getInputStream().read(b);
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		DataInputStream inFromClient = new DataInputStream(connectionSocketConected.getInputStream());		
		//Creates an object of the data which is to be send back to the client, via the connectionSocket

		System.out.println("Outtoclient oprettet!");

		ny = cryp.decrypt(byteCryp.decrypt(b));
		
	
		System.out.println("Besked modtaget!");
		System.out.println("Received: " + ny);
		
		

	}catch(Exception exception){
		System.err.print(exception);
	} 
	return ny;
	}
	
	
}