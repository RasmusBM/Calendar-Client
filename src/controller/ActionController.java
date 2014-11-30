package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import view.CalendarFrame;
import view.DayPanel;
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
					cf.setTitle("Week view");
					cf.show(cf.WEEKPANEL);
					String quote = cc.getQuote();
					cf.getWeekPanel().getQotd().setText("QOTD: " + quote);
					
					
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
		
		else if(cmd.equals(DayPanel.BACK)){
			cf.show(cf.WEEKPANEL);
			cf.setTitle("Week view");
			
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
			iMonth = 1;
			}else if(monthString.equals("Feb")){
			iMonth = 2;
			}else if(monthString.equals("Mar")){
			iMonth = 3;
			}else if(monthString.equals("Apr")){
			iMonth = 4;
			}else if(monthString.equals("May")){
			iMonth = 5;
			}else if(monthString.equals("Jun")){
			iMonth = 6;
			}else if(monthString.equals("Jul")){
			iMonth = 7;
			}else if(monthString.equals("Aug")){
			iMonth = 8;
			}else if(monthString.equals("Sep")){
			iMonth = 9;
			}else if(monthString.equals("Oct")){
			iMonth = 10;
			}else if(monthString.equals("Nov")){
			iMonth = 11;
			}else if(monthString.equals("Dec")){
			iMonth = 12;
			}
			
			//setting selected 
			int sDay = Integer.parseInt(currentDay.substring(iMid+1, currentDay.length()));
			
			System.out.println(iMonth + "" + sDay);
			
			
			
			cf.setTitle(cmd);
			cf.show(cf.DAYPANEL);
			
		}
	}
}
