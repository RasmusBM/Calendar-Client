package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	private JTextField txtremail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	
	
	public LoginPanel(){
		
		setLayout(null);
		
		txtremail = new JTextField("Insert your CBS-EMAIL adress");
		txtremail.setBounds(8, 111, 250, 29);
		add(txtremail);
		
		passwordField = new JPasswordField("Password");
		passwordField.setBounds(8, 147, 250, 29);
		add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(74, 217, 117, 29);
		add(btnLogin);
//		btnLogin.addActionListener(actionController);
//		btnLogin.setActionCommand(LOGINSUBMIT);
		
	}
}
