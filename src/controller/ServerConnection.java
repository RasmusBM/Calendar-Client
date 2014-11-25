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
	
	public void establishConnection() throws Exception{
		
		clientSocket = new Socket("localhost", 8888);
		
		 outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		
	}
	
	
	public void Send(String gsonString) throws Exception{

		System.out.println("send koerer");
		
		establishConnection();
		
		byte[]  encrypted = Encryption(gsonString);
		
		System.out.println(encrypted);
		
		outToServer.write(encrypted);
		outToServer.flush();
	}
	
	public String recive() throws IOException{
		
		System.out.println("recive koerer");
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		String modifiedSentence = inFromServer.readLine();
		
		System.out.println(modifiedSentence);
		
		return modifiedSentence;
	}
	
	public byte[] Encryption(String gsonString){
		
		byte[] input = gsonString.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		
		
		return encrypted;
	}
}
