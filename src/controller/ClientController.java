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
	
	/**
	 * The method sends the given username and password and check if the user can login
	 * @param the username that the user entered 
	 * @param the password that the user entered
	 * @return the response from the server
	 */
	public String Login(String username, String password){
	
		System.out.println("login koerer");
		
		currentUser.setEmail(username);
		currentUser.setPassword(password);
		
		String gsonString = gson.toJson(currentUser);
		
		sc.establishConnection();
		
		sc.Send(gsonString);

		
		return sc.recive();
		
	}
	
	/**
	 * Getting the Quote 
	 * @return the quote from the database
	 */
	public String getQuote(){ 
		
		sim.setOverallID("getQuote");
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		
		return sc.recive();
	}
	
	/**
	 * Take the given userId and sends the case "getEvents" to the server
	 * @param the userId from the currentUser
	 * @return response from the server
	 */
	public String getEvents(int userId){
		
		sim.setOverallID("getEvents");
		sim.setUserId(userId);
		
		String gsonString = gson.toJson(sim);
		sc.Send(gsonString);
		
		
		
		return sc.recive();
	}
	
	/**
	 * Take the given userId and sends the case "getCalendars" to the server
	 * @param the userId from the currentUser
	 * @return response from the server
	 */
	public String getCalendars(int userId){
		
		cal.setOverallID("getCalendars");
		cal.setUserid(userId);
		
		String gsonString = gson.toJson(cal);
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	/**
	 * Sends the case "getForecast" to the server
	 * @param the month for the given day 
	 * @param  the day for the given day 
	 * @param the year for the given day 
	 * @return response from the server 
	 */
	public String getForecast(int month, int day, int year){
		
		sim.setOverallID("getForecast");
		sim.setYear(year);
		sim.setMonth(month);
		sim.setDay(day);
		
		String gsonString = gson.toJson(sim);
		
			sc.Send(gsonString);
			
			return sc.recive();
			
	}
	
	/**
	 * Sends the case "getNote" to the server
	 * @param the id for the given Event
	 * @return response from the server 
	 */
	public String getNote(int id){
		
		sim.setOverallID("getNote");
		sim.setId(id);
		
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	/**
	 * Sends the case "createNote" to the server
	 * @param the id for the given Event
	 * @param createdBy is the id of the user created the note
	 * @param text is the text for the note
	 * @return response from the server 
	 */
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
	
	/**
	 * Sends the case "createCalendar" to the server 
	 * @param title is the title for the new calendar
	 * @param userID is the userId for the creator of the calendar
	 * @return response from the server 
	 */
	public String createCalendar(String title, int userID){
		
		cal.setOverallID("createCalendar");
		cal.setTitle(title);
		cal.setUserid(userID);
		
		String gsonString = gson.toJson(cal);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	/**
	 * Sends the case "deleteCalendar" to the server
	 * @param calId is the calId for the deleted calendar
	 * @param userId is the for user requesting the delete
	 * @return response from the server
	 */
	public String deleteCalendar(int calId, int userId){
		
		cal.setOverallID("deleteCalendar");
		cal.setCalendarid(calId);
		cal.setUserid(userId);
		
		String gsonString = gson.toJson(cal);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	/**
	 * Sends the case "shareCalendar" to the server 
	 * @param calId is the calId you to share
	 * @param userId is the userId you want to share with
	 * @return response from the server
	 */
	public String shareCalendar(int calId, int userId){
		
		sim.setOverallID("shareCalendar");
		sim.setCalendarId(calId);
		sim.setUserId(userId);
		
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
	
	/**
	 * Creates an event with the given variables
	 * @param createdBy
	 * @param title
	 * @param description
	 * @param location
	 * @param calendarId
	 * @param start
	 * @param end
	 * @return response from the server
	 */
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
	
	/**
	 * Deletes an event 
	 * @param eventId is the id of the event you want to delete
	 * @return response from the server
	 */
	public String deleteEvent(int eventId){
		
		sim.setOverallID("deleteEvent");
		sim.setId(eventId);
		
		String gsonString = gson.toJson(sim);
		
		sc.Send(gsonString);
		
		return sc.recive();
	}
}
