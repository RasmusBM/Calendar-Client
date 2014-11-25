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

import controller.ActionController;

public class WeekPanel extends JPanel{

	private WeekPanel wk;
	private String quote =  "Im a cop you idiot";
	private ActionController actionController;
	private CalendarFrame calendarframe;
	GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
	GregorianCalendar cal2;
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	JButton[] button = new JButton[7];
	JLabel l2 = new JLabel("", JLabel.CENTER);
//	private GregorianCalendar selectedDay;
	
	public WeekPanel(ActionController actionController)
    {

		this.actionController = actionController;
		
		cal.set(GregorianCalendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		
		
		String[] headers = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(0,7));
		
		setLayout(new GridLayout(0,7));
		
        for(int i = 0; i <7; i++){
        	JLabel l = new JLabel(("" + headers[i]));
//        	l.setHorizontalTextPosition(l.RIGHT);
//        	label.setHorizontalAlignment(JLabel.RIGHT);
//            p1.add(l, BorderLayout.NORTH);
        	add(l,BorderLayout.NORTH);
        }
        
//        p1.setVisible(true);
        
//        JPanel p2 = new JPanel(new GridLayout(1, 7));
        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFocusPainted(false);
            button[x].setBackground(Color.red);
            add(button[x]);
            
        }

        displayDate();
        
        
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
	
    public void displayDate(){
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
    	int k = Integer.parseInt(String.valueOf(cal.getTime().getDate()));
    	for (int x = 0; x < button.length; x++) {
       
        	
        	button[x].setText(String.valueOf(k));
        	k++;
//        	for(int x2 = 0; x < k+7; x2++ ){
//        		System.out.println("lol");
//        	}
        			
        }
    }
}
