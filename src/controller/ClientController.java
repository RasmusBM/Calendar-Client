package controller;

import java.io.IOException;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Users;

public class ClientController {

	Users u = new Users();
	Gson gson = new GsonBuilder().create();
	ServerConnection sc = new ServerConnection();
	
	
	public String Login(String username, String password) throws Exception {
	
		System.out.println("login koerer");
		
		u.setEmail(username);
		u.setPassword(password);
		u.setActive(true);
		
		String gsonString = gson.toJson(u);
		
		System.out.println(gsonString);
		
		sc.Send(gsonString);
		
		return sc.recive();
		
	}
}
