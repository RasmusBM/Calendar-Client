package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Event;
import shared.Forecast;
import shared.User;
import view.CalendarFrame;
import view.DayPanel;
import view.LoginPanel;
import view.WeekPanel;

public class ActionController implements ActionListener{

	private CalendarFrame cf;
	User currentUser = new User();
	ClientController cc = new ClientController();
	Gson gson = new GsonBuilder().create();
	ArrayList<Event> events = new ArrayList<Event>();
	Event eventOb = new Event();
	private int selectedDay;
	private int selectedMonth;
	

	public ActionController(CalendarFrame cf){
		
		this.cf = cf;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(LoginPanel.LOGINSUBMIT)){
			
			String email = cf.getLoginPanel().getTxtremail().getText();
			String password = cf.getLoginPanel().getPasswordField().getText();
			
			//HUSK at encrypt til password!
			
			System.out.println(email + password);
			
			try {
				
				
				String reply = cc.Login(email, password);
				
				
				//If user is logged in 
				if(!reply.equals("invalid")){
					
					
					currentUser = (User) gson.fromJson(reply, User.class);
					
					cf.setTitle("Week view");
					cf.show(cf.WEEKPANEL);
					
					//getting quote and displaying it
//					String quote = cc.getQuote();
//					cf.getWeekPanel().getQotd().setText("QOTD: " + quote);
					
					//fetching calendars and events
					String result = cc.getEvents(currentUser.getUserId());
					
					Event[] event = gson.fromJson(result, Event[].class);
					
					for(int i = 0; i < event.length; i++) {
						
						events.add(event[i]);
						System.out.println("Event added");
						
					}
					
					
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		
		else if(cmd.equals(WeekPanel.PREVIOUS)){
			
			cf.getWeekPanel().refreshDate(-1);
		}
		
		else if(cmd.equals(WeekPanel.NEXT)){
			cf.getWeekPanel().refreshDate(+1);
		}
		
		else if(cmd.equals(DayPanel.BACK)){
			cf.show(cf.WEEKPANEL);
			cf.setTitle("Week view");
			
		}
		
		else if(cmd.equals(DayPanel.FORECAST)){
		
			cf.getDaypanel().removeTable();
			cf.getDaypanel().repaint();
//			cf.getDaypanel().getTitle().setText("Forecast for the day");
			
			System.out.println(selectedMonth + ""+selectedDay);
			
			try {
				
				String result = cc.getForecast(selectedMonth+1, selectedDay);
				
				Forecast fc = gson.fromJson(result, Forecast.class);
				
				cf.getDaypanel().getTitle().setText(fc.getCelsius());
				
			}
			catch (IOException e1){
				e1.printStackTrace();
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		else{
			
			//getting text from button
			String currentDay = cmd;
			
			//getting selected month 
			int iMid = cmd.indexOf(cf.getWeekPanel().getMONTHDAYSEPARATOR());
			String monthString = currentDay.substring(0, iMid);
			
			//setting text from button to specfic month
			int iMonth = 0;
			if(monthString.equals("Jan")){
			iMonth = 0;
			}else if(monthString.equals("Feb")){
			iMonth = 1;
			}else if(monthString.equals("Mar")){
			iMonth = 2;
			}else if(monthString.equals("Apr")){
			iMonth = 3;
			}else if(monthString.equals("May")){
			iMonth = 4;
			}else if(monthString.equals("Jun")){
			iMonth = 5;
			}else if(monthString.equals("Jul")){
			iMonth = 6;
			}else if(monthString.equals("Aug")){
			iMonth = 7;
			}else if(monthString.equals("Sep")){
			iMonth = 8;
			}else if(monthString.equals("Oct")){
			iMonth = 9;
			}else if(monthString.equals("Nov")){
			iMonth = 10;
			}else if(monthString.equals("Dec")){
			iMonth = 11;
			}
			
			//setting selected 
			int sDay = Integer.parseInt(currentDay.substring(iMid+1, currentDay.length()));
			
			selectedDay = sDay;
			selectedMonth = iMonth;
			
			System.out.println(iMonth + "" + sDay);
			
//			Object[][] data = new Object[events.size()][7];
//			
//			String[] columnNames = { "Start", "End", "Cal ID", "Event ID", "Title",
//					"Description", "Location" };
//			
//			
//			for (int i = 0; i < events.size(); i++){
//								
//				if(events.get(i).getStartTimestamp().getMonth() == iMonth && events.get(i).getStartTimestamp().getDate() == sDay){
//					
//					System.out.println(events.get(i).getId());
//					
//					String start =  events.get(i).getStartTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();
//					String end = events.get(i).getEndTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();
//					
//					data[i][0] =  start;
//					data[i][1] = end;
//					data[i][2] = events.get(i).getCalendarId();
//					data[i][3] = events.get(i).getId();
//					data[i][4] = events.get(i).getTitle();
//					data[i][5] = events.get(i).getDescription();
//					data[i][6] = events.get(i).getLocation();
//				}
//			
//			}
//			
//			JTable table = new JTable(data, columnNames);
//			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
//			table.setFillsViewportHeight(true);
//			table.setRowSelectionAllowed(true);
//			cf.getDaypanel().getScrollPane().getViewport().add(table);
			
			
			showTable(iMonth, sDay);
			
			cf.getDaypanel().getTitle().setText("Events for the day");
			cf.setTitle(cmd);
			cf.show(cf.DAYPANEL);
			
		}
	}
	
	public void showTable(int iMonth, int sDay) {

		// creates an object with the column names
		String[] columnNames = { "Start", "End", "Cal ID", "Event ID", "Title",
				"Description", "Location" };
		
		// Set the data from the transactions array
		Object[][] data = new Object[events.size()][7];
		for (int i = 0; i < events.size(); i++){
			
			if(events.get(i).getStartTimestamp().getMonth() == iMonth && events.get(i).getStartTimestamp().getDate() == sDay){
				
				System.out.println(events.get(i).getId());
				
				String start =  events.get(i).getStartTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();
				String end = events.get(i).getEndTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();
				
				data[i][0] =  start;
				data[i][1] = end;
				data[i][2] = events.get(i).getCalendarId();
				data[i][3] = events.get(i).getId();
				data[i][4] = events.get(i).getTitle();
				data[i][5] = events.get(i).getDescription();
				data[i][6] = events.get(i).getLocation();
			}
		
		}

		// adding the data to the JTable in ShowTransactions
		cf.getDaypanel().addTable(data, columnNames);

	}//end showTransaction
}
