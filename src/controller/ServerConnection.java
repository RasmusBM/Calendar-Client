package controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServerConnection {
	
	private Socket clientSocket;
	private DataOutputStream outToServer;
	
	public void establishConnection(){
		
		
		try {
			clientSocket = new Socket("localhost", 8888);
			outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void Send(String gsonString) {

		System.out.println("send koerer");
		
		establishConnection();
		
		byte[]  encrypted = Encryption(gsonString);
		
		System.out.println(encrypted);
		
		try {
			outToServer.write(encrypted);
			outToServer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String recive(){
		
		
		System.out.println("recive koerer");
		BufferedReader inFromServer;
		try {
			inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String modifiedSentence = inFromServer.readLine();
			System.out.println("KIG JER"+modifiedSentence.getBytes());
			
			String answer =crypt(modifiedSentence.getBytes());
			
			System.out.println(answer);
			return answer;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return "null2";
	}
	
	public byte[] Encryption(String gsonString){
		
		
		byte[] input = gsonString.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++) 
			encrypted[i] = (byte) (encrypted[i] ^ key);
		
		System.out.println("KIG HER: "+ encrypted);
		
		return encrypted;
	}
	
	public String crypt(byte[] b)
	{
//		Defines the decryption value of the byte
		String crypKey = "3.1470";
		double keyAsDouble = Double.parseDouble(crypKey);
		byte ff = (byte) keyAsDouble;
//		Generates for loop containing decryption value
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
//		Generates new String without any white spaces following or leading
		String encrypted = new String(b).trim();
//		Returns decrypted String
		return encrypted;
	}
}
