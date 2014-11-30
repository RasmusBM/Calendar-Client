package controller;

import java.io.IOException;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.User;

public class ClientController {

	User u = new User();
	Gson gson = new GsonBuilder().create();
	ServerConnection sc = new ServerConnection();
	
	
	public String Login(String username, String password) throws Exception {
	
		System.out.println("login koerer");
		
		u.setEmail(username);
		u.setPassword(password);
		
		String gsonString = gson.toJson(u);
		
		System.out.println(gsonString);
		
		sc.Send(gsonString);
		
		return sc.recive();
		
	}
	
	public String getQuote() throws Exception{ 
		
		String gsonString = gson.toJson("getQuote");
		
		sc.Send(gsonString);
		
		
		return sc.recive();
	}
}
