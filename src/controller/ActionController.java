package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import view.CalendarFrame;
import view.LoginPanel;

public class ActionController implements ActionListener{

	private CalendarFrame cf;
	ClientController cc = new ClientController();
	
	public ActionController(CalendarFrame cf){
		
		this.cf = cf;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(LoginPanel.LOGINSUBMIT)){
			
			String email = cf.getLoginPanel().getTxtremail().getText();
			String password = cf.getLoginPanel().getPasswordField().getText();
			
			//HUSK at encrypt til password!
			
			System.out.println(email + password);
			
			try {
				cc.Login(email, password);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		
		else if(cmd.equals(null)){
			
		}
	}
}
