package controller;

//import java.io.IOException;
//import java.net.UnknownHostException;
import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Calendar;
import shared.Event;
import shared.Note;
import shared.SimpleCall;
import shared.User;

public class ClientController {

	User currentUser = new User();
	Gson gson = new GsonBuilder().create();
	ServerConnection sc = new ServerConnection();
	SimpleCall sim = new SimpleCall();
	Calendar cal = new Calendar();
	Event event = new Event();
	Note note = new Note();
	
	
	public String Login(String username, String password){
	
		System.out.println("login koerer");
		
		currentUser.setEmail(username);
		currentUser.setPassword(password);
		
		String gsonString = gson.toJson(currentUser);
		
		sc.establishConnection();
		
		sc.Send(gsonString);

		
		return sc.recive();
		
	}
	
	public String getQuote(){ 
		
		sim.setOverallID("getQuote");
		String gsonString = gson.toJson(sim);
		
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
	
	public String getForecast(int month, int day, int year){
		
		sim.setOverallID("getForecast");
		sim.setYear(year);
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
	
	public String createNote(int id, int createdBy, String text){
		
		
		note.setOverallID("createNote");
		note.setCreatedBy(createdBy);
		note.setEventID(id);
		note.setText(text);
		
		String gsonString = gson.toJson(note);
		
		System.out.println(gsonString);
		
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
	
	public String createEvent(int createdBy, String title, String description, String location, int calendarId, Timestamp start, Timestamp end){
		
		event.setOverallID("createEvent");
		event.setCreatedby(createdBy);
		event.setTitle(title);
		event.setDescription(description);
		event.setLocation(location);
		event.setCalendarId(calendarId);
		event.setStartTimestamp(start);
		event.setEndTimestamp(end);
		
		String gsonString = gson.toJson(event);
		
		sc.Send(gsonString);
		
		
		return sc.recive();
	}
	
	public String deleteEvent(int eventId){
		
		sim.setId(eventId);
		
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
}
