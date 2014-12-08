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
	private JLabel noteLbl;
	private JLabel temp;
	private JLabel weater;
	private JLabel preview;
	private JButton back;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private JButton showNote;
	private JButton setNote;
	private JButton eventMenu;
	private JButton updateNote;
	private JButton deleteNote;
	private JTextField noteField;
	public static final String BACK = "Back";
	public static final String SHOWNOTE = "showNote";
	public static final String SETNOTE = "setNote";
	public static final String UPDATENOTE = "updateNote";
	public static final String DELETENOTE = "deleteNote";
	public static final String EVENTMENU = "eventMenu";
	
	public DayPanel(ActionController actionController){
		
		setLayout(null);
		
		title = new JLabel("Label");
		title.setBounds(244, 6, 139, 16);
		add(title);
		
		noteLbl = new JLabel();
		noteLbl.setBounds(142, 66, 279, 66);
		add(noteLbl);
		
		temp = new JLabel();
		temp.setBounds(636, 180, 123, 37);
		add(temp);
		
		back = new JButton("Back");
		back.setBounds(196, 247, 75, 29);
		back.addActionListener(actionController);
		back.setActionCommand(BACK);
		add(back);
		
		
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
		
		deleteNote = new JButton("Delete Note");
		deleteNote.setBounds(626, 81, 111, 29);
		deleteNote.addActionListener(actionController);
		deleteNote.setActionCommand(DELETENOTE);
		add(deleteNote);
		
		updateNote = new JButton("Update Note");
		updateNote.setBounds(238, 144, 111, 29);
		updateNote.addActionListener(actionController);
		updateNote.setActionCommand(UPDATENOTE);
		updateNote.setVisible(false);
		add(updateNote);
		
		noteField = new JTextField();
		noteField.setBounds(96, 44, 400, 100);
		noteField.setVisible(false);
		add(noteField);
		
		eventMenu = new JButton("EventMenu");
		eventMenu.setBounds(331, 247, 111, 29);
		eventMenu.addActionListener(actionController);
		eventMenu.setActionCommand(EVENTMENU);
		add(eventMenu);
		
		weater = new JLabel();
		weater.setBounds(636, 220, 159, 37);
		add(weater);
		
		preview = new JLabel("Weater for the day:");
		preview.setBounds(639, 149, 123, 37);
		add(preview);
		
		
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

	public JLabel getNoteLbl() {
		return noteLbl;
	}

	public void setNoteLbl(JLabel noteLbl) {
		this.noteLbl = noteLbl;
	}

	public JButton getUpdateNote() {
		return updateNote;
	}

	public void setUpdateNote(JButton updateNote) {
		this.updateNote = updateNote;
	}

	public JLabel getTemp() {
		return temp;
	}

	public void setTemp(JLabel temp) {
		this.temp = temp;
	}

	public JLabel getWeater() {
		return weater;
	}

	public void setWeater(JLabel weater) {
		this.weater = weater;
	}
}
