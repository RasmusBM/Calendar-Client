package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

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
import view.EventPanel;
import view.LoginPanel;
import view.WeekPanel;

/**
 * Handels the action events from the GUI 
 * @author RasmusM
 *
 */

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
	private int selectedEvent;
	

	public ActionController(CalendarFrame cf){
		
		this.cf = cf;
	}
	
	/**
	 * This method handels all the action events activated from the JPanels Uses
	 * the method getActionCommand to differentiate between the various action
	 * commands
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(LoginPanel.LOGINSUBMIT)){
			
			String email = cf.getLoginPanel().getTxtremail().getText();
			String password = cf.getLoginPanel().getPasswordField().getText();
			
			
			
			System.out.println(email + password);
			
			
				String reply = cc.Login(email, password);
				
				
				//If user is logged in 
				if(!reply.equals("invalid")){
					
					currentUser = (User) gson.fromJson(reply, User.class);
										
					cf.setTitle("Week view");
					cf.show(cf.WEEKPANEL);
					
					//fetching events
					refreshEvents();

					//fetching calendars
					refreshCalendars();
					
					String qotd = cc.getQuote();
					cf.getWeekPanel().getQotdTitle().setText(qotd);
					
					
					
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
			cf.getDaypanel().getNoteLbl().setText("");;
			cf.getEventPanel().clearFields();
			cf.getDaypanel().getUpdateNote().setVisible(false);
			cf.getDaypanel().getSetNote().setVisible(false);
			
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
				
				cf.getCalendarpanel().removeTable();
				cf.getCalendarpanel().repaint();
				JOptionPane.showMessageDialog(null, "Calendar created");
			}
			refreshCalendars();
			showTable2();
			cf.getCalendarpanel().repaint();
		}
		
		else if(cmd.equals(CalendarPanel.DELTECAL)){
			String callIdString = JOptionPane.showInputDialog(null, "Insert ID", null);
			int calIdInt = Integer.parseInt(callIdString);
			if(cc.deleteCalendar(calIdInt, currentUser.getUserId()).equals("calendar deleted")){
				cf.getCalendarpanel().removeTable();
				cf.getCalendarpanel().repaint();
				JOptionPane.showMessageDialog(null, "Calendar deleted");
				
			}
			refreshCalendars();
			showTable2();
			cf.getCalendarpanel().repaint();
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
		
		else if(cmd.equals(DayPanel.EVENTMENU)){
			
			cf.show(cf.EVENTPANEL);
		}
		
		else if(cmd.equals(EventPanel.CREATE)){
			
			//setting startTime
			Date startDate = new Date();
			startDate.setYear(cf.getWeekPanel().START_YEAR);
			startDate.setMonth(selectedMonth);
			startDate.setDate(selectedDay);
			startDate.setHours(Integer.parseInt(cf.getEventPanel().getStartHourField().getText()));
			startDate.setMinutes(Integer.parseInt(cf.getEventPanel().getStartMinuteField().getText()));
			Timestamp startTimestamp = new Timestamp(startDate.getTime());
			
			System.out.println(startDate.getDay());
			
			//setting endTime
			Date endDate = new Date();
			endDate.setYear(cf.getWeekPanel().START_YEAR);
			endDate.setMonth(selectedMonth);
			endDate.setDate(selectedDay);
			endDate.setHours(Integer.parseInt(cf.getEventPanel().getEndHourField().getText()));
			endDate.setMinutes(Integer.parseInt(cf.getEventPanel().getEndMinuteField().getText()));
			Timestamp endTimestamp = new Timestamp(endDate.getTime());
			
			
			cc.createEvent(currentUser.getUserId(), cf.getEventPanel().getTitleField().getText(), cf.getEventPanel().getDescField().getText(), cf.getEventPanel().getLocationField().getText(), Integer.parseInt(cf.getEventPanel().getCalField().getText()), startTimestamp, endTimestamp);
			
			refreshEvents();
			cf.getEventPanel().clearFields();
			
			cf.show(cf.WEEKPANEL);
			
		}
		
		else if(cmd.equals(EventPanel.DELETE)){
			
			String eventIdString = JOptionPane.showInputDialog(null, "Insert EventID", null);
			int eventIdInt = Integer.parseInt(eventIdString);
			
			cc.deleteEvent(eventIdInt);
			
			refreshEvents();
			cf.getEventPanel().clearFields();
			
			cf.show(cf.WEEKPANEL);
			JOptionPane.showMessageDialog(null, "Event deleted");
			
		}
		
		
		else if(cmd.equals(DayPanel.SHOWNOTE)){
			
			cf.getDaypanel().removeTable();
			cf.getDaypanel().repaint();
			
			String stringEventId = JOptionPane.showInputDialog(null, "Insert Event ID", null);
			
			selectedEvent = Integer.parseInt(stringEventId); 
			
			String result = cc.getNote(selectedEvent);
			
			Note n = gson.fromJson(result, Note.class);
			
			cf.getDaypanel().getTitle().setText("Note for the Event");
			
			cf.getDaypanel().getSetNote().setVisible(true);
			
			cf.getDaypanel().getNoteLbl().setVisible(true);
			
			cf.getDaypanel().getNoteLbl().setText(n.getText());
			
			cf.getDaypanel().repaint();
			
		}
		
		else if(cmd.equals(DayPanel.SETNOTE)){
			cf.getDaypanel().removeTable();
			cf.getDaypanel().repaint();
			

			String newNote = JOptionPane.showInputDialog(null, "Insert Note", null);
			
			cc.createNote(selectedEvent, currentUser.getUserId(), newNote);
			
			cf.getDaypanel().repaint();
			;
			cf.getDaypanel().getNoteLbl().setText(newNote);
			
			
			cf.getDaypanel().repaint();
						
		}
		
		else if(cmd.equals(DayPanel.DELETENOTE)){
			
			
			cc.createNote(selectedEvent, currentUser.getUserId(), "");
			cf.getDaypanel().getNoteLbl().setText("");
			JOptionPane.showMessageDialog(null, "Calendar deleted");
		}
		
		else if(cmd.equals(DayPanel.UPDATENOTE)){
			
			cf.getDaypanel().getNoteField().setVisible(false);
			cf.getDaypanel().getUpdateNote().setVisible(false);
			
			String newNote = cf.getDaypanel().getNoteField().getText();
			
			cf.getDaypanel().getNoteLbl().setText(newNote);
			
			cc.createNote(selectedEvent, currentUser.getUserId(), newNote);
			
			
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
			
			
			int selectedYear = cf.getWeekPanel().START_YEAR;
			String result = cc.getForecast(selectedMonth+1, selectedDay, selectedYear );
			
			Forecast fc = gson.fromJson(result, Forecast.class);
			
			
			if(fc != null){
				cf.getDaypanel().getTemp().setText("Temp: " + fc.getCelsius());
				
				cf.getDaypanel().getWeater().setText("Weater: " + fc.getDesc());	
				
				cf.setTitle(cmd);
				cf.show(cf.DAYPANEL);
			}else{
				cf.getDaypanel().getTemp().setText("Temp: " + "N/A");
				
				cf.getDaypanel().getWeater().setText("Weater: " + "N/A");
				cf.setTitle(cmd);
				cf.show(cf.DAYPANEL);
			}
			
			
		}
	}
	/**
	 * Gets the events for the specfic user
	 */
	public void refreshEvents(){
		
		events.removeAll(events);
		
		String result = cc.getEvents(currentUser.getUserId());
		
		Event[] event = gson.fromJson(result, Event[].class);
		
		for(int i = 0; i < event.length; i++) {
			
			System.out.println("Event added");
			events.add(event[i]);
		}
	}
	
	/**
	 * Gets the calendars for the specfic user
	 */
	public void refreshCalendars(){
		
		calendars.removeAll(calendars);
		
		String response = cc.getCalendars(currentUser.getUserId());
		
		Calendar[] calendar = gson.fromJson(response, Calendar[].class);
		
		for(int i = 0; i < calendar.length; i++){
			
			calendars.add(calendar[i]);
		}
	}
	/**
	 * Adds the events for the selected day to the JTable for the day view
	 * @param iMonth is the clicked month
	 * @param sDay is the clicked day
	 */
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

		// adding the data to the JTable
		cf.getDaypanel().addTable(data, columnNames);

	}//end showTable
	
	/**
	 * Adds the calendars for the given User
	 */
	public void showTable2(){
		
		String[] columnNames = { "ID", "Title", "CreatedBy"};
		
		Object[][] data = new Object[calendars.size()][3];
		int l = 0;
		
		for(int i = 0; i < calendars.size(); i++){
			
			data[l][0] = calendars.get(i).getCalendarid();
			data[l][1] =  calendars.get(i).getTitle();
			data[l][2] = calendars.get(i).getUserid();
			
			l++;
		}
		
		cf.getCalendarpanel().addTable(data, columnNames);
		
	}
}
