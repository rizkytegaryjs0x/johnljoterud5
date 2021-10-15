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
	
	public String TalkToServer (String StringFromClient) throws UnknownHostException, IOException, Exception{
		
		String ny = "";
		String encryptedString = cryp.encrypt(StringFromClient);
		String modifiedSentence;
		// opretter et socket til porten 8888
		Socket clientSocket = new Socket("localhost", 8888);
		// outputsteam oprettes
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		// data krypteres
		byte[] encrypted = byteCryp.encrypt(encryptedString);
		System.out.println(encrypted);
		// data sendes
		outToServer.write(encrypted);
		outToServer.flush();
		// inputsteam oprettes
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		modifiedSentence = inFromServer.readLine();
		System.out.println(modifiedSentence);
		System.out.println("FROM SERVER: " + modifiedSentence);
		ny = modifiedSentence;
		clientSocket.close();
	
	return ny;
	}
	
	
}