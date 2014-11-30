package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class CreateEventPanel extends JPanel {
	
	private JLabel calId;
	private JLabel startTime;
	private JLabel endTime;
	private JLabel title;
	private JLabel description;
	private JLabel location;
	
	public CreateEventPanel(){
		setLayout(null);
		
		calId = new JLabel("calId");
		calId.setBounds(6, 52, 30, 16);
		add(calId);
		
		startTime = new JLabel("startTime");
		startTime.setBounds(98, 52, 60, 16);
		add(startTime);
		
		endTime = new JLabel("endTime");
		endTime.setBounds(167, 5, 54, 16);
		add(endTime);
		
		title = new JLabel("title");
		title.setBounds(226, 5, 25, 16);
		add(title);
		
		description = new JLabel("description");
		description.setBounds(256, 5, 71, 16);
		add(description);
		
		location = new JLabel("location");
		location.setBounds(332, 5, 51, 16);
		add(location);
		
		
		
	}
}
