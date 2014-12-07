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
import javax.swing.JTextField;
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
	private JButton showNote;
	private JButton setNote;
	private JButton eventMenu;
	private JTextField noteField;
	public static final String BACK = "Back";
	public static final String FORECAST = "foreCast";
	public static final String SHOWNOTE = "showNote";
	public static final String SETNOTE = "setNote";
	public static final String EVENTMENU = "eventMenu";
	
	public DayPanel(ActionController actionController){
		
		setLayout(null);
		
		title = new JLabel("Label");
		title.setBounds(244, 6, 139, 16);
		add(title);
		
		back = new JButton("Back");
		back.setBounds(196, 247, 75, 29);
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
		
		forecast = new JButton("Forecast");
		forecast.setBounds(626, 81, 117, 29);
		forecast.addActionListener(actionController);
		forecast.setActionCommand(FORECAST);
		add(forecast);
		
		showNote = new JButton("Show Note");
		showNote.setBounds(626, 50, 111, 29);
		showNote.addActionListener(actionController);
		showNote.setActionCommand(SHOWNOTE);
		add(showNote);
		
		setNote = new JButton("Set Note");
		setNote.setBounds(626, 23, 105, 29);
		setNote.addActionListener(actionController);
		setNote.setActionCommand(SETNOTE);
		setNote.setVisible(false);
		add(setNote);
		
		noteField = new JTextField();
		noteField.setBounds(50, 50, 400, 100);
		noteField.setVisible(false);
		add(noteField);
		
		eventMenu = new JButton("EventMenu");
		eventMenu.setBounds(331, 247, 111, 29);
		eventMenu.addActionListener(actionController);
		eventMenu.setActionCommand(EVENTMENU);
		add(eventMenu);
		
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
	
	public void removeNotefield(){
		this.remove(noteField);
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

	public JButton getShowNote() {
		return showNote;
	}

	public void setShowNote(JButton showNote) {
		this.showNote = showNote;
	}

	public JTextField getNoteField() {
		return noteField;
	}

	public void setNoteField(JTextField noteField) {
		this.noteField = noteField;
	}

	public JButton getSetNote() {
		return setNote;
	}

	public void setSetNote(JButton setNote) {
		this.setNote = setNote;
	}
	
}
