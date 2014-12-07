package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Calendar;
import shared.Event;
import shared.Forecast;
import shared.Note;
import shared.User;
import view.CalendarFrame;
import view.CalendarPanel;
import view.DayPanel;
import view.LoginPanel;
import view.WeekPanel;

public class ActionController implements ActionListener{

	private CalendarFrame cf;
	User currentUser = new User();
	ClientController cc = new ClientController();
	Gson gson = new GsonBuilder().create();
	ArrayList<Event> events = new ArrayList<Event>();
	ArrayList<Calendar> calendars = new ArrayList<Calendar>();
	Event eventOb = new Event();
	private int selectedDay;
	private int selectedMonth;
	private String encryptpass;
	

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
			
			
				String reply = cc.Login(email, password);
				
				
				//If user is logged in 
				if(!reply.equals("invalid")){
					
					currentUser = (User) gson.fromJson(reply, User.class);
										
					cf.setTitle("Week view");
					cf.show(cf.WEEKPANEL);
					
					//fetching events
					String result = cc.getEvents(currentUser.getUserId());
					
					Event[] event = gson.fromJson(result, Event[].class);
					
					for(int i = 0; i < event.length; i++) {
						
						events.add(event[i]);
					}
					
					//fetching calendars 
					String response = cc.getCalendars(currentUser.getUserId());
					System.out.println(response);
					
					Calendar[] calendar = gson.fromJson(response, Calendar[].class);
					
					for(int i = 0; i < calendar.length; i++){
						
						calendars.add(calendar[i]);
					}
					
					
				}			
			
		}
		
		else if(cmd.equals(WeekPanel.PREVIOUS)){
			
			if(cf.getWeekPanel().START_WEEK <= 1){
				cf.getWeekPanel().START_WEEK = 52;
				cf.getWeekPanel().START_YEAR--;
				cf.getWeekPanel().refreshDate(0);
			}else{
				
				cf.getWeekPanel().refreshDate(-1);	
			}
		}
		
		else if(cmd.equals(WeekPanel.NEXT)){
			
			if(cf.getWeekPanel().START_WEEK >= 52){
				cf.getWeekPanel().START_WEEK = 1;
				cf.getWeekPanel().START_YEAR++;
				cf.getWeekPanel().refreshDate(0);
			}else{
				cf.getWeekPanel().refreshDate(+1);
			}
		}
		
		else if(cmd.equals(DayPanel.BACK)){
			cf.show(cf.WEEKPANEL);
			cf.setTitle("Week view");
			cf.getDaypanel().removeNotefield();
			
		}
		
		else if(cmd.equals(WeekPanel.GETWEEK)){
			int selectedYear = Integer.parseInt(cf.getWeekPanel().getAarField().getText());
			int selectedWeek = Integer.parseInt(cf.getWeekPanel().getUge().getText());
			
			cf.getWeekPanel().displayDate2(selectedWeek, selectedYear);
			cf.getWeekPanel().START_WEEK = selectedWeek;
			cf.getWeekPanel().START_YEAR = selectedYear;
			
		}
		
		else if(cmd.equals(WeekPanel.CALSET)){

			cf.show(cf.CALPANEL);
			showTable2();
			
		}
		
		else if(cmd.equals(CalendarPanel.CREATECAL)){
			String calTitle = JOptionPane.showInputDialog(null, "Title", null);
			if(cc.createCalendar(calTitle, currentUser.getUserId()).equals("calendar added")){
				System.out.println("saadan");
			}else{
				System.out.println("WHAT?");
			}
		}
		
		else if(cmd.equals(CalendarPanel.DELTECAL)){
			String callIdString = JOptionPane.showInputDialog(null, "Insert ID", null);
			int calIdInt = Integer.parseInt(callIdString);
			if(cc.deleteCalendar(calIdInt, currentUser.getUserId()).equals("calendar deleted")){
				System.out.println("deleted");
			}
		}
		
		else if(cmd.equals(CalendarPanel.SHARECAL)){
			String callIdString = JOptionPane.showInputDialog(null, "Insert Calendar-ID", null);
			String userIdString = JOptionPane.showInputDialog(null, "Insert User-ID", null);
			
			int calIdInt = Integer.parseInt(callIdString);
			int userIdInt = Integer.parseInt(userIdString);
			
			if(cc.shareCalendar(calIdInt, userIdInt).equals("calendar_shared")){
				JOptionPane.showMessageDialog(null, "Calendar shared");
				
			}
			
		}
		
		else if(cmd.equals(DayPanel.FORECAST)){
		
			cf.getDaypanel().removeTable();
			cf.getDaypanel().repaint();
//			cf.getDaypanel().getTitle().setText("Forecast for the day");
			
				String result = cc.getForecast(selectedMonth+1, selectedDay);
				
				Forecast fc = gson.fromJson(result, Forecast.class);
				
				cf.getDaypanel().getTitle().setText(fc.getCelsius());
			
			
		}
		
		else if(cmd.equals(DayPanel.SHOWNOTE)){
			
			cf.getDaypanel().removeTable();
			cf.getDaypanel().repaint();
			
			String stringNoteId = JOptionPane.showInputDialog(null, "Insert ID", null);
			
			int noteId = Integer.parseInt(stringNoteId); 
			
			String result = cc.getNote(noteId);
			
			Note n = gson.fromJson(result, Note.class);
			
			cf.getDaypanel().getTitle().setText(n.getText());
			cf.getDaypanel().getSetNote().setVisible(true);
			
		}
		
		else if(cmd.equals(DayPanel.SETNOTE)){
			cf.getDaypanel().removeTable();
			cf.getDaypanel().repaint();
			
			cf.getDaypanel().getNoteField().setVisible(true);
			cf.getDaypanel().getNoteField().setText(cf.getDaypanel().getTitle().getText());
			
			System.out.println("ID: "+currentUser.getUserId() );
			
			String result = cc.createNote(1337, 42, 1, cf.getDaypanel().getNoteField().getText());
			
			System.out.println(result);
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
			
			
			showTable(iMonth, sDay);
			
			cf.getDaypanel().getTitle().setText("Events for the day");
			cf.setTitle(cmd);
			cf.show(cf.DAYPANEL);
			
		}
	}
	
	public void showTable(int iMonth, int sDay) {

		int space = 0;
		
		for (int i = 0; i < events.size(); i++){
			
			if(events.get(i).getStartTimestamp().getMonth() == iMonth && events.get(i).getStartTimestamp().getDate() == sDay){
				space++;
			}
		}
		
		// creates an object with the column names
		String[] columnNames = { "Start", "End", "Cal ID", "Event ID", "Title",
				"Description", "Location" };
		
		
		// Set the data from the transactions array
		Object[][] data = new Object[space][7];
		int l = 0;
		
		for (int i = 0; i < events.size(); i++){
			
			if(events.get(i).getStartTimestamp().getMonth() == iMonth && events.get(i).getStartTimestamp().getDate() == sDay){
				
				System.out.println("if koerer"+""+"l: "+l);
				
				String start =  events.get(i).getStartTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();
				String end = events.get(i).getEndTimestamp().getHours() + ":" + events.get(i).getStartTimestamp().getMinutes();
				
				data[l][0] =  start;
				data[l][1] = end;
				data[l][2] = events.get(i).getCalendarId();
				data[l][3] = events.get(i).getId();
				data[l][4] = events.get(i).getTitle();
				data[l][5] = events.get(i).getDescription();
				data[l][6] = events.get(i).getLocation();
				l++;
			}
		
		}

		// adding the data to the JTable in ShowTransactions
		cf.getDaypanel().addTable(data, columnNames);

	}//end showTable
	
	public void showTable2(){
		
		String[] columnNames = { "ID", "Title", "CreatedBy", "Active"};
		
		Object[][] data = new Object[calendars.size()][4];
		int l = 0;
		
		for(int i = 0; i < calendars.size(); i++){
			
			data[l][0] = calendars.get(i).getCalendarid();
			data[l][1] =  calendars.get(i).getTitle();
			data[l][2] = calendars.get(i).getUserid();
			data[l][3] = calendars.get(i).isActive();
			
			l++;
		}
		
		cf.getCalendarpanel().addTable(data, columnNames);
		
		
	}
}
