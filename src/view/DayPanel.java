package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import controller.ActionController;

public class DayPanel extends JPanel {
	
	private ActionController actionController;
	private JLabel title;
	private JButton back;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private JButton forecast;
	public static final String BACK = "Back";
	public static final String FORECAST = "foreCast"; 
	
	public DayPanel(ActionController actionController){
		
		setLayout(null);
		
		title = new JLabel("Label");
		title.setBounds(168, 11, 139, 16);
		add(title);
		
		back = new JButton("Back");
		back.setBounds(168, 150, 75, 29);
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
		
		forecast = new JButton("Forecast");
		forecast.setBounds(440, 94, 117, 29);
		forecast.addActionListener(actionController);
		forecast.setActionCommand(FORECAST);
		add(forecast);
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
//				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
//						255), new Color(0, 0, 205), new Color(255, 255, 255)),
//				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
//		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
//				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
//						255), new Color(0, 0, 205), new Color(255, 255, 255)),
//				null));
//		scrollPane.setBounds(26, 30, 398, 120);
//
//		// Add the scroll pane to this panel.
//		add(scrollPane);
		
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
		 scrollPane.setBounds(26, 30, 398, 120);
		 add(scrollPane);	
	}
	
	public void removeTable(){
		this.remove(resultTable);
		this.remove(scrollPane);
	}
	
	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getResultTable() {
		return resultTable;
	}

	public void setResultTable(JTable resultTable) {
		this.resultTable = resultTable;
	}
	
}
