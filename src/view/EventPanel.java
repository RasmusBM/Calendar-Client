package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ActionController;

import java.awt.FlowLayout;

import javax.swing.JTextField;

public class EventPanel extends JPanel {
	
	private JLabel calId;
	private JLabel startTime;
	private JLabel endTime;
	private JLabel title;
	private JLabel description;
	private JLabel location;
	private JLabel startMinuteTime;
	private JLabel endMinuteTime;
	private JTextField calField;
	private JTextField startHourField;
	private JTextField startMinuteField;
	private JTextField endHourField;
	private JTextField endMinuteField;
	private JTextField titleField;
	private JTextField descField;
	private JTextField locationField;
	private JButton createEvent;
	private JButton delteEvent;
	private JButton backBtn;
	
	public static final String CREATE = "create";
	public static final String DELETE = "delete";
	public static final String BACK = "Back";
	
	public EventPanel(ActionController actionController){
		setLayout(null);
		
		calId = new JLabel("calId");
		calId.setBounds(168, 25, 30, 16);
		add(calId);
		
		startTime = new JLabel("Start Hour");
		startTime.setBounds(168, 136, 71, 16);
		add(startTime);
		
		endTime = new JLabel("End Hour");
		endTime.setBounds(168, 173, 71, 16);
		add(endTime);
		
		title = new JLabel("title");
		title.setBounds(168, 52, 25, 16);
		add(title);
		
		description = new JLabel("description");
		description.setBounds(168, 80, 71, 16);
		add(description);
		
		location = new JLabel("location");
		location.setBounds(168, 108, 51, 16);
		add(location);
		
		calField = new JTextField();
		calField.setBounds(251, 19, 51, 28);
		add(calField);
		calField.setColumns(10);
		
		startHourField = new JTextField("");
		startHourField.setBounds(231, 130, 71, 28);
		add(startHourField);
		startHourField.setColumns(10);
		
		startMinuteField = new JTextField("");
		startMinuteField.setBounds(395, 134, 51, 20);
		add(startMinuteField);
		startMinuteField.setColumns(10);
		
		startMinuteTime = new JLabel("Start Minute");
		startMinuteTime.setBounds(314, 136, 86, 16);
		add(startMinuteTime);
		
		
		endHourField = new JTextField("");
		endHourField.setBounds(231, 167, 71, 28);
		add(endHourField);
		endHourField.setColumns(10);
		
		endMinuteField = new JTextField("");
		endMinuteField.setBounds(395, 166, 51, 30);
		add(endMinuteField);
		endMinuteField.setColumns(10);
		
		endMinuteTime = new JLabel("End Minute");
		endMinuteTime.setBounds(314,167,71,28);
		add(endMinuteTime);
		
		titleField = new JTextField();
		titleField.setBounds(251, 46, 96, 28);
		add(titleField);
		titleField.setColumns(10);
		
		descField = new JTextField();
		descField.setBounds(251, 74, 96, 28);
		add(descField);
		descField.setColumns(10);
		
		locationField = new JTextField();
		locationField.setBounds(251, 102, 96, 28);
		add(locationField);
		locationField.setColumns(10);
		
		createEvent = new JButton("Create Event");
		createEvent.setBounds(268, 236, 117, 29);
		createEvent.addActionListener(actionController);
		createEvent.setActionCommand(CREATE);
		add(createEvent);
		
		delteEvent = new JButton("Delete Event");
		delteEvent.setBounds(503, 236, 117, 29);
		delteEvent.addActionListener(actionController);
		delteEvent.setActionCommand(DELETE);
		add(delteEvent);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(100, 236, 117, 29);
		backBtn.addActionListener(actionController);
		backBtn.setActionCommand(BACK);
		add(backBtn);
		

		
	}
	
	public void clearFields(){
		
		calField.setText("");
		titleField.setText("");
		descField.setText("");
		locationField.setText("");
		startHourField.setText("");
		startMinuteField.setText("");
		endHourField.setText("");
		endMinuteField.setText("");
		
		
	}

	public JTextField getCalField() {
		return calField;
	}

	public void setCalField(JTextField calField) {
		this.calField = calField;
	}

	public JTextField getStartHourField() {
		return startHourField;
	}

	public void setStartHourField(JTextField startHourField) {
		this.startHourField = startHourField;
	}

	public JTextField getStartMinuteField() {
		return startMinuteField;
	}

	public void setStartMinuteField(JTextField startMinuteField) {
		this.startMinuteField = startMinuteField;
	}

	public JTextField getEndHourField() {
		return endHourField;
	}

	public void setEndHourField(JTextField endHourField) {
		this.endHourField = endHourField;
	}

	public JTextField getEndMinuteField() {
		return endMinuteField;
	}

	public void setEndMinuteField(JTextField endMinuteField) {
		this.endMinuteField = endMinuteField;
	}

	public JTextField getTitleField() {
		return titleField;
	}

	public void setTitleField(JTextField titleField) {
		this.titleField = titleField;
	}

	public JTextField getDescField() {
		return descField;
	}

	public void setDescField(JTextField descField) {
		this.descField = descField;
	}

	public JTextField getLocationField() {
		return locationField;
	}

	public void setLocationField(JTextField locationField) {
		this.locationField = locationField;
	}

}
