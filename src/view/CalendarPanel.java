package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ActionController;

public class CalendarPanel extends JPanel {
	
	private ActionController actionController;
	private JLabel title;
	private JButton back;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private JButton createCal;
	private JButton deleteCal;
	private JButton shareCal;
	public static final String BACK = "Back";
	public static final String CREATECAL = "createCal";
	public static final String DELTECAL = "deleteCal";
	public static final String SHARECAL = "shareCal";
	
	
	public CalendarPanel(ActionController actionController){
		
		setLayout(null);
		
		title = new JLabel("Label");
		title.setBounds(244, 6, 139, 16);
		add(title);
		
		back = new JButton("Back");
		back.setBounds(196, 247, 75, 29);
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
		
		
		createCal = new JButton("createCal");
		createCal.setBounds(626, 78, 111, 29);
		createCal.addActionListener(actionController);
		createCal.setActionCommand(CREATECAL);
		add(createCal);
		
		deleteCal = new JButton("deleteCal");
		deleteCal.setBounds(626, 50, 111, 29);
		deleteCal.addActionListener(actionController);
		deleteCal.setActionCommand(DELTECAL);
		add(deleteCal);
		
		shareCal = new JButton("Share cal");
		shareCal.setBounds(626, 19, 105, 29);
		shareCal.addActionListener(actionController);
		shareCal.setActionCommand(SHARECAL);
		add(shareCal);
		
	}

	
	
	
	public void removeTable(){
		this.remove(resultTable);
		this.remove(scrollPane);
	}
	
	
	public void addTable(Object[][] data,String[] columnNames){
		
		if(resultTable!=null){
		this.remove(resultTable);
		this.remove(scrollPane);
		}
		 resultTable = new JTable(data, columnNames);
		 resultTable.setPreferredScrollableViewportSize(new Dimension(800,70));
		 resultTable.setFillsViewportHeight(true);
		 
		 scrollPane = new JScrollPane(resultTable);
		 scrollPane.setBounds(30, 30, 600, 200);
		 add(scrollPane);	
	}
}
