package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeekPanel extends JPanel {

	private WeekPanel wk;
	private String quote =  "Im a cop you idiot";
	
	public WeekPanel()
    {

		
		setLayout(new GridLayout(0, 7));
		
		
		String[] headers = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
        for(int i = 0; i <7; i++){
            add(new JLabel(("" + headers[i])));
        }
        
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
         for (int i =1; i<=(7); i++)
          {
             JPanel pan = new JPanel();
             pan.setAlignmentY(LEFT_ALIGNMENT);
             pan.setPreferredSize(new Dimension(30,30));
             pan.setBorder(BorderFactory.createLineBorder(Color.GRAY));
             add(pan);
           } 

    } 
}
