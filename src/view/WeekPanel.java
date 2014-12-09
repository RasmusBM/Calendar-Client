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
	private JLabel aar;
	private JTextField aarField;
	private JButton forward;
	private JButton back;
	private JTextField uge;
	private JButton go;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	private JPanel p6;
	private JButton calSet;
	private JButton delCal;
	private JButton shareCal;
	private JLabel qotd;
	private JLabel qotdTitle;
	public static int START_WEEK;
	public static int START_YEAR;
	public static String MONTHDAYSEPARATOR =" ";
	
	//Declaration of panel constants
	public static final String PREVIOUS = "Previous";
	public static final String NEXT = "Next";
	public static final String DATE = "Date";
	public static final String GETWEEK = "getWeek";
	public static final String CALSET = "calSet";
	public static final String DELCAL= "delCal";
	public static final String SHARECAL= "shareCal";
	
	

	
	public WeekPanel(ActionController actionController)
    {

		this.actionController = actionController;
		
		
		START_WEEK = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		START_YEAR = cal.get(GregorianCalendar.YEAR);
		
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(800, 300));
		
        p1 = new JPanel(new GridLayout(0,7));
        p1.setBackground(new Color(63, 89, 146));
        p1.setVisible(true);
        p1.setPreferredSize(new Dimension(10,35));
        add(p1, BorderLayout.NORTH);
		
		String[] headers = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
        for(int i = 0; i <7; i++){
        	JLabel l = new JLabel(("" + headers[i]), SwingConstants.CENTER);
        	p1.add(l, new GridLayout(2,7));
        }
        
        p2 = new JPanel(new GridLayout(0,7));
        p2.setBackground(new Color(63, 89, 146));
        p2.setVisible(true);
        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFocusPainted(false);
            p2.add(button[x]);
            
        }
        p2.setPreferredSize(new Dimension(800, 10) );
        add(p2, BorderLayout.CENTER);
        

        displayDate2(START_WEEK,START_YEAR);

        p3 = new JPanel(new FlowLayout());
        p3.setBackground(new Color(107, 106, 104));
        p3.setPreferredSize(new Dimension(800, 90));
        p3.setBorder(new EmptyBorder(0,0,0,0));
        p3.setVisible(true);
        add(p3, BorderLayout.SOUTH);
//        
        p4 = new JPanel(new GridLayout(1,5));
        p4.setBackground(new Color(107, 106, 104));
        p4.setVisible(true);
        //adding button
        back = new JButton("<< Previous");
        back.addActionListener(actionController);
        back.setActionCommand(PREVIOUS);
        p4.add(back);
        //adding label
        ugenr = new JLabel("Week Number:");
        p4.add(ugenr);
        //adding textfield
        uge = new JTextField(""+ START_WEEK);
        p4.add(uge);
        //adding label
        aar = new JLabel("Year: ");
        p4.add(aar);
        //adding textfield
        aarField = new JTextField(""+ START_YEAR);
        p4.add(aarField);
        //adding button
        go = new JButton("Go to week");
        go.addActionListener(actionController);
        go.setActionCommand(GETWEEK);
        p4.add(go);
        //adding button
        forward = new JButton("Next >>");
        forward.addActionListener(actionController);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        forward.setActionCommand(NEXT);
        p4.add(forward);
        p4.setPreferredSize(new Dimension(800,25));
        p3.add(p4);
        
        p5 = new JPanel(new GridLayout(1,3));
        p5.setBackground(new Color(107, 106, 104));
        p5.setPreferredSize(new Dimension(800,25));
        p5.setVisible(true);
        calSet = new JButton("Calendar Settings");
        calSet.addActionListener(actionController);
        calSet.setActionCommand(CALSET);
        p5.add(calSet);;
        p3.add(p5);
        
        p6 = new JPanel();
        p6.setBackground(new Color(236, 236, 233));
        p6.setPreferredSize(new Dimension(800, 25));
        p6.setLayout(null);
        qotd = new JLabel("QOTD");
        qotd.setBounds(0, 6, 38, 16);
        p6.add(qotd);
        qotdTitle = new JLabel("");
        qotdTitle.setBounds(50, 6, 744, 16);
        p6.add(qotdTitle);
        p6.setVisible(true);
        p3.add(p6);
        
         

    }
	
    
    public void displayDate2(int weekNumber, int yearNumber){
    	
     	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
    	cal.set(Calendar.YEAR, yearNumber);
    	
    	
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
    	
    	
    	START_WEEK =  START_WEEK + newWeek;
    	displayDate2(START_WEEK,START_YEAR);
    	
    	String stringNextWeek = String.valueOf(START_WEEK);
    	String stringNextYear = String.valueOf(START_YEAR);
    	
    	aarField.setText(stringNextYear);
    	uge.setText(stringNextWeek);
    	
    	
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


	public JLabel getQotdTitle() {
		return qotdTitle;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


	public JTextField getAarField() {
		return aarField;
	}


	public void setAarField(JTextField aarField) {
		this.aarField = aarField;
	}


	public JTextField getUge() {
		return uge;
	}


	public void setUge(JTextField uge) {
		this.uge = uge;
	}    
    
}
