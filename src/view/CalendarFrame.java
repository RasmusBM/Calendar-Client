package view;
import java.awt.CardLayout;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;


import controller.ActionController;

public class CalendarFrame extends JFrame {

	//Declaration of global style constants
//	public static final int WITDH = 400;
//	public static final int HEIGHT = 400;
	
	//Declaration of attributes
	private ActionController actionController;
	private LoginPanel loginPanel;
	private DayPanel dayPanel;
	private WeekPanel weekPanel;
	private CalendarPanel calPanel;
	private EventPanel eventPanel;
	private JPanel contentPane;
	private CardLayout c;
	private GregorianCalendar selectedDay;
//	private MyCalendar cal;
	
	public static final String LOGINPANEL = "loginPanel";
	public static final String WEEKPANEL = "weekPanel";
	public static final String DAYPANEL = "dayPanel";
	public static final String CALPANEL = "calPanel";
	public static final String EVENTPANEL = "eventPanel";
	
	public CalendarFrame(){
		
		setSize(800, 300);
		setLocationRelativeTo(null);
		actionController = new ActionController(this);
//		selectedDay = cal.getSelectedDay();
		
		//instances of the JPanels 
		loginPanel = new LoginPanel(actionController);
		weekPanel = new WeekPanel(actionController);
		dayPanel = new DayPanel(actionController);
		calPanel = new CalendarPanel(actionController);
		eventPanel = new EventPanel(actionController);
		
		
		//adding the contentPane
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		c = (CardLayout) getContentPane().getLayout();
		
		contentPane.add(loginPanel, LOGINPANEL);
		contentPane.add(weekPanel, WEEKPANEL);
		contentPane.add(dayPanel, DAYPANEL);
		contentPane.add(calPanel, CALPANEL);
		contentPane.add(eventPanel, EVENTPANEL);
		
	}
	
	public void show(String card){
		
		c.show(getContentPane(), card);
	}
	
	public DayPanel getDaypanel(){
		return dayPanel;
	}
	
	public WeekPanel getWeekPanel(){
		return weekPanel;
	}
	
	public LoginPanel getLoginPanel(){
		return loginPanel;
	}
	
	public CalendarPanel getCalendarpanel(){
		return calPanel;
	}
	
	public EventPanel getEventPanel(){
		return eventPanel;
	}
	
}
