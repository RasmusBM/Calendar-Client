package controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServerConnection {
	
	private DataOutputStream outToServer;
	private Socket clientSocket;
	
	public void establishConnection(){

		try {
			clientSocket = new Socket("localhost", 8888);
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void Send(String gsonString) {
		
		establishConnection();
		
		byte[]  encrypted = Encryption(gsonString);
		
		
		try {
			outToServer.write(encrypted);
			outToServer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String recive(){
		
		
		System.out.println("recive koerer");
		BufferedReader inFromServer = null;
		
		try {
			inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			
			String modifiedSentence = inFromServer.readLine();
			
			String answer =crypt(modifiedSentence.getBytes());
			
			System.out.println(answer);
			return answer;
		} catch (IOException e) {
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
