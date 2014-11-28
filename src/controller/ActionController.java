package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import view.CalendarFrame;
import view.LoginPanel;
import view.WeekPanel;

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
				String reply = cc.Login(email, password);
				if(reply.equals("Login Successful")){
					cf.Show(cf.WEEKPANEL);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		
		else if(cmd.equals(WeekPanel.PREVIOUS)){
			
			cf.getWeekPanel().refreshDate(-1);
		}
		
		else if(cmd.equals(WeekPanel.NEXT)){
			cf.getWeekPanel().refreshDate(+1);
		}
		
		else{
			
			//getting text from button
			String currentDay = cmd;
			
			System.out.println(cmd);
			
			//getting selected month 
			int iMid = cmd.indexOf(cf.getWeekPanel().getMONTHDAYSEPARATOR());
			String monthString = currentDay.substring(0, iMid);
			
			//setting text from button to specfic month
			int iMonth = 0;
			if(monthString.equals("Jan")){
			iMonth = 0;
			}else if(monthString.equals("Feb")){
			iMonth = 1;
			}else if(monthString.equals("Mar")){
			iMonth = 2;
			}else if(monthString.equals("Apr")){
			iMonth = 3;
			}else if(monthString.equals("May")){
			iMonth = 4;
			}else if(monthString.equals("Jun")){
			iMonth = 5;
			}else if(monthString.equals("Jul")){
			iMonth = 6;
			}else if(monthString.equals("Aug")){
			iMonth = 7;
			}else if(monthString.equals("Sep")){
			iMonth = 8;
			}else if(monthString.equals("Oct")){
			iMonth = 9;
			}else if(monthString.equals("Nov")){
			iMonth = 10;
			}else if(monthString.equals("Dec")){
			iMonth = 11;
			}
			
			//setting selected 
			int sDay = Integer.parseInt(currentDay.substring(iMid+1, currentDay.length()));
			
			System.out.println(iMonth + "" + sDay);
		}
	}
}
