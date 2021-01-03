import java.io.*;
import java.net.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Client
{
 public static void main(String argv[]) throws Exception
 {
  String sentence;
  String modifiedSentence;
  BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
  Socket clientSocket = new Socket("172.17.157.128", 6789);
  
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  sentence = ("connecting to server...");
  
  outToServer.writeBytes(sentence + '\n');
  
  modifiedSentence = inFromServer.readLine();

  System.out.println("FROM SERVER: " + modifiedSentence);
  clientSocket.close();
 }
}

