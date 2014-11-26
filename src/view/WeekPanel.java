package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ActionController;

public class WeekPanel extends JPanel{

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
	private static int START_WEEK;
	private static int START_YEAR;
	
	//Declaration of panel constants
	public static final String PREVIOUS = "Previous";
	public static final String NEXT = "Next";
	

	
	public WeekPanel(ActionController actionController)
    {

		this.actionController = actionController;
		
//		cal.set(GregorianCalendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		
		START_WEEK = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		START_YEAR = cal.get(GregorianCalendar.YEAR);
		
//		setLayout(new GridLayout(7,7));
		setLayout(new BorderLayout());
        p1 = new JPanel(new GridLayout(0,7));
        p1.setBackground(Color.red);
        p1.setVisible(true);
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
        
        displayDate(START_WEEK,START_YEAR);

        p3 = new JPanel(new GridLayout(1,5));
        p3.setBackground(Color.green);
        p3.setVisible(true);
        //adding button
        back = new JButton("<< Previous");
        back.addActionListener(actionController);
        back.setActionCommand(PREVIOUS);
        p3.add(back);
        //adding label
        ugenr = new JLabel("Ugenr:");
        p3.add(ugenr);
        //adding textfield
        uge = new JTextField(""+ START_WEEK);
        p3.add(uge);
        //adding button
        go = new JButton("Go to week");
        p3.add(go);
        //adding button
        forward = new JButton("Next >>");
        forward.addActionListener(actionController);
        forward.setActionCommand(NEXT);
        p3.add(forward);
        //adding panel3
        add(p3, BorderLayout.SOUTH);
        
        
        
//        forward = new JButton("Next");
//        add(forward);
        

        
        
//        for(int i = 1; i <31; i++){
//            add(new JLabel("" + i));
//        }
		
//        JPanel daytimes = new JPanel(new BorderLayout());
//        daytimes.add(new JLabel("08.00"), BorderLayout.WEST);
//        daytimes.add(new JLabel("09.00"), BorderLayout.WEST);
//        daytimes.add(new JLabel("10.00"), BorderLayout.WEST);;
//        daytimes.add(new JLabel("11.00"), BorderLayout.WEST);;
//        add(daytimes);
//        
//		
//         setLayout(new BorderLayout());
//         setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
//  
//         for (int i =1; i<=(7); i++)
//          {
//             JButton pan = new JButton();
//             pan.setAlignmentY(LEFT_ALIGNMENT);
//             pan.setPreferredSize(new Dimension(30,30));
//             pan.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//             add(pan);
//           } 
         

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
    
    public void refreshDate(int newWeek){
    	
//    	int hej = START_WEEK += newWeek;
//    	String hej2 = String.valueOf(hej);
    	
    	displayDate(START_WEEK += newWeek,START_YEAR);
    	
//    	uge.setText(hej2);
    
    	
    }
    
}
