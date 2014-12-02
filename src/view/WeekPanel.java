package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ActionController;

public class WeekPanel extends JPanel implements ActionListener{

	private WeekPanel wk;
	private ActionController actionController;
	private CalendarFrame calendarframe;
	GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
	GregorianCalendar cal2;
	private JButton[] button = new JButton[7];
	private JLabel ugenr;
	private JButton forward;
	private JButton back;
	private JTextField uge;
	private JButton go;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	private JLabel qotd;
	private static int START_WEEK;
	private static int START_YEAR;
	public static String MONTHDAYSEPARATOR =" ";
	
	//Declaration of panel constants
	public static final String PREVIOUS = "Previous";
	public static final String NEXT = "Next";
	public static final String DATE = "Date";
	

	
	public WeekPanel(ActionController actionController)
    {

		this.actionController = actionController;
		
//		cal.set(GregorianCalendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		
		START_WEEK = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		START_YEAR = cal.get(GregorianCalendar.YEAR);
		
		
		setLayout(new BorderLayout());
        p1 = new JPanel(new GridLayout(0,7));
        p1.setBackground(Color.red);
        p1.setVisible(true);
        p1.setPreferredSize(new Dimension(10,35));
        add(p1, BorderLayout.NORTH);
		
		String[] headers = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
        for(int i = 0; i <7; i++){
        	JLabel l = new JLabel(("" + headers[i]), SwingConstants.CENTER);
        	p1.add(l, new GridLayout(2,7));
//        	add(l,BorderLayout.NORTH);
        }
        
        p2 = new JPanel(new GridLayout(0,7));
        p2.setBackground(Color.yellow);
        p2.setVisible(true);
        add(p2, BorderLayout.CENTER);
        
        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFocusPainted(false);
            button[x].setBackground(Color.red);
            p2.add(button[x], new GridLayout(2,7));
            
        }
        
//        displayDate(START_WEEK,START_YEAR);
        displayDate2(START_WEEK,START_YEAR);

        p3 = new JPanel();
        p3.setBackground(Color.pink);
        p3.setPreferredSize(new Dimension(100,60));
        p3.setBorder(new EmptyBorder(0,0,0,0));
        p3.setVisible(true);
        add(p3, BorderLayout.SOUTH);
//        
        p4 = new JPanel(new GridLayout(1,5));
        p4.setBackground(Color.green);
        p4.setVisible(true);
        //adding button
        back = new JButton("<< Previous");
        back.addActionListener(actionController);
        back.setActionCommand(PREVIOUS);
        p4.add(back);
        //adding label
        ugenr = new JLabel("Ugenr:");
        p4.add(ugenr);
        //adding textfield
        uge = new JTextField(""+ START_WEEK);
        p4.add(uge);
        //adding button
        go = new JButton("Go to week");
        p4.add(go);
        //adding button
        forward = new JButton("Next >>");
        forward.addActionListener(actionController);
        forward.setActionCommand(NEXT);
        p4.add(forward);
        //adding panel3
        p3.add(p4, BorderLayout.NORTH);
//        add(p4, BorderLayout.SOUTH);
        
        p5 = new JPanel(new GridLayout(1,5));
        p5.setBackground(Color.orange);
        p5.setPreferredSize(new Dimension(600,20));
        p5.setVisible(true);
        qotd = new JLabel();
        p5.add(qotd);
        p3.add(p5, BorderLayout.SOUTH);
//        add(p4, BorderLayout.SOUTH);
        
         

    }
	
	
    public void displayDate(int weekNumber, int yearNumber){
//    	for (int x = 0; x < button.length; x++)
//            button[x].setText("lol");
//    java.util.Calendar cal = java.util.Calendar.getInstance();
//    cal.set(year, month, 1);
//    
//    int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
//    int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
//    System.out.println(cal.get(java.util.Calendar.DATE));
//    System.out.println(daysInMonth);
//    
//    for (int x = 0 + dayOfWeek, day = 1; day <= dayOfWeek; x++, day++)
//            button[x].setText("" + day);
//    l2.setText(sdf.format(cal.getTime()));
    	
    	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
		cal.set(Calendar.YEAR, yearNumber);
    	
     	
    	for (int x = 0; x < button.length; x++) {
       
    		int k = Integer.parseInt(String.valueOf(cal.getTime().getDate()));
    		cal.add(Calendar.DATE, 1);
        	button[x].setText(String.valueOf(k));
        	
//        	for(int x2 = 0; x < k+7; x2++ ){
//        		System.out.println("lol");
//        	}
        			
        }
    }
    
    public void displayDate2(int weekNumber, int yearNumber){
    	
//    	cal.setFirstDayOfWeek(Calendar.TUESDAY);
//    	cal.set(Calendar.WEEK_OF_YEAR, START_WEEK);
//    	cal.set(Calendar.YEAR, START_YEAR);
     	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
    	cal.set(Calendar.YEAR, yearNumber);
    	
    	
//    	int weekday = cal.get(Calendar.DAY_OF_WEEK);
//    	cal.add(Calendar.DATE,1 - weekday);
    	int iMonth, iDay;
    	
    	for (int x = 0; x <  button.length; x++){
    		iMonth =  cal.get(Calendar.MONTH);
    		iDay = cal.get(Calendar.DAY_OF_MONTH);
    		switch(iMonth){
    		case 0: button[x].setText("Jan" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 1:button[x].setText("Feb" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 2:button[x].setText("Mar" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 3:button[x].setText("Apr" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 4:button[x].setText("Maj" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 5:button[x].setText("Jun" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 6:button[x].setText("Jul" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 7:button[x].setText("Aug" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 8:button[x].setText("Sep" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 9:button[x].setText("Okt" + MONTHDAYSEPARATOR + (iDay) );break;
    		case 10:button[x].setText("Nov" + MONTHDAYSEPARATOR + (iDay) );;break;
    		case 11:button[x].setText("Dec" + MONTHDAYSEPARATOR + (iDay) );break;
    		}
    		cal.add(Calendar.DATE, 1);
    		
    		button[x].addActionListener(actionController);
    	}
    	
    }

    
    public void refreshDate(int newWeek){
    	
//    	int nextWeek = START_WEEK += newWeek;
    	
    	START_WEEK =  START_WEEK + newWeek;
    	displayDate2(START_WEEK,START_YEAR);
    	
//    	if(START_WEEK < 53){
    		
//    	displayDate2(START_WEEK += newWeek,START_YEAR);
//    	}
//    	else{
//    		START_WEEK = 1;
//    		displayDate2(START_WEEK,START_YEAR);
//    	}
    	String stringNextWeek = String.valueOf(START_WEEK);
    	
    	uge.setText(stringNextWeek);
    	
    	
    
//    	nextWeek = START_WEEK -= newWeek;
    	
    }


	public JButton[] getButton() {
		return button;
	}


	public void setButton(JButton[] button) {
		this.button = button;
	}


	public static String getMONTHDAYSEPARATOR() {
		return MONTHDAYSEPARATOR;
	}


	public static void setMONTHDAYSEPARATOR(String mONTHDAYSEPARATOR) {
		MONTHDAYSEPARATOR = mONTHDAYSEPARATOR;
	}


	public JLabel getQotd() {
		return qotd;
	}


	public void setQotd(JLabel qotd) {
		this.qotd = qotd;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
    
    
}
