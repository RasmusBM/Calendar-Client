package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ActionController;

public class DayPanel extends JPanel {
	
	private ActionController actionController;
	private JLabel title;
	private JButton back;
	public static final String BACK = "Back";
	
	public DayPanel(ActionController actionController){
	
		
		setLayout(new GridLayout());
		
		title = new JLabel("");
		add(title);
		
		back = new JButton("Back");
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
		
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	
}
