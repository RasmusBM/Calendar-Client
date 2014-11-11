package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CalendarFrame;
import view.LoginPanel;

public class ActionController implements ActionListener{

	private CalendarFrame cf;
	
	public ActionController(CalendarFrame cf){
		
		this.cf = cf;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(LoginPanel.LOGINSUBMIT)){
			
			System.out.println("hej");
			
			cf.Show(cf.WEEKPANEL);
		}
		
		else if(cmd.equals(null)){
			
		}
	}
}
