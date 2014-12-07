package controller;

import java.io.IOException;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Calendar;
import shared.SimpleCall;
import shared.User;

public class ClientController {

	User currentUser = new User();
	Gson gson = new GsonBuilder().create();
	ServerConnection sc = new ServerConnection();
	SimpleCall sim = new SimpleCall();
	Calendar cal = new Calendar();
	
	
	public String Login(String username, String password){
	
		System.out.println("login koerer");
		
		currentUser.setEmail(username);
		currentUser.setPassword(password);
		
		String gsonString = gson.toJson(currentUser);
		
		sc.establishConnection();
		
		sc.Send(gsonString);

		
		return sc.recive();
		
	}
	
	public String getQuote() throws Exception{ 
		
		String gsonString = gson.toJson("getQuote");
		
		sc.Send(gsonString);
		
		
		return sc.recive();
	}
	
	public String getEvents(int userId){
		
		sim.setOverallID("getEvents");
		sim.setUserId(userId);
		
		String gsonString = gson.toJson(sim);
		sc.Send(gsonString);
		
		
		
		return sc.recive();
	}
	
	public String getCalendars(int userId){
		
		cal.setOverallID("getCalendars");
		cal.setUserid(userId);
		
		String gsonString = gson.toJson(cal);
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	public String getForecast(int month, int day){
		
		sim.setOverallID("getForecast");
		sim.setYear(2014);
		sim.setMonth(month);
		sim.setDay(day);
		
		String gsonString = gson.toJson(sim);
		
			sc.Send(gsonString);
			
			return sc.recive();
			
	}
	
	public String getNote(int id){
		
		sim.setOverallID("getNote");
		sim.setId(id);
		
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	public String createNote(int noteId, int id, int createdBy, String text){
		
		sim.setOverallID("createNote");
		sim.setNoteId(noteId);
		sim.setId(id);
		sim.setUserId(createdBy);
		sim.setText(text);
		
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	public String createCalendar(String title, int userID){
		
		cal.setOverallID("createCalendar");
		cal.setTitle(title);
		cal.setUserid(userID);
		
		String gsonString = gson.toJson(cal);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	public String deleteCalendar(int calId, int userId){
		
		cal.setOverallID("deleteCalendar");
		cal.setCalendarid(calId);
		cal.setUserid(userId);
		
		String gsonString = gson.toJson(cal);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	public String shareCalendar(int calId, int userId){
		
		sim.setOverallID("shareCalendar");
		sim.setCalendarId(calId);
		sim.setUserId(userId);
		
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
}
