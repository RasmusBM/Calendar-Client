package controller;

import java.io.IOException;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.SimpleCall;
import shared.User;

public class ClientController {

	User currentUser = new User();
	Gson gson = new GsonBuilder().create();
	ServerConnection sc = new ServerConnection();
	SimpleCall sim = new SimpleCall();
	
	
	public String Login(String username, String password) throws Exception {
	
		System.out.println("login koerer");
		
		currentUser.setEmail(username);
		currentUser.setPassword(password);
		
		String gsonString = gson.toJson(currentUser);
		
		sc.Send(gsonString);

		
		return sc.recive();
		
	}
	
	public String getQuote() throws Exception{ 
		
		String gsonString = gson.toJson("getQuote");
		
		sc.Send(gsonString);
		
		
		return sc.recive();
	}
	
	public String getEvents(int userId) throws Exception{
		
		sim.setOverallID("getEvents");
		sim.setUserId(userId);
		
		String gsonString = gson.toJson(sim);
		sc.Send(gsonString);
		
		
		
		return sc.recive();
	}
	
	public String getForecast(int month, int day) throws Exception{
		
		sim.setOverallID("getForecast");
		sim.setYear(2014);
		sim.setMonth(month);
		sim.setDay(day);
		
		String gsonString = gson.toJson(sim);
		
			sc.Send(gsonString);
			
			return sc.recive();
			
	}
	
}
