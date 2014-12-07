package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ActionController;

public class LoginPanel extends JPanel {

	private ActionController actionController;
	private JTextField txtremail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	
	
	public static final String LOGINSUBMIT  = "loginSubmit";
	
	
	public LoginPanel(ActionController actionController){
		
		this.actionController = actionController;
		setLayout(null);
		
		txtremail = new JTextField("dafr13ab@student.cbs.dk");
		txtremail.setBounds(278, 31, 250, 29);
		add(txtremail);
		
		passwordField = new JPasswordField("123456");
		passwordField.setBounds(278, 71, 250, 29);
		add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(348, 112, 117, 29);
		add(btnLogin);
		btnLogin.addActionListener(actionController);
		btnLogin.setActionCommand(LOGINSUBMIT);
		
	}


	public JTextField getTxtremail() {
		return txtremail;
	}


	public void setTxtremail(JTextField txtremail) {
		this.txtremail = txtremail;
	}


	public JPasswordField getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
}
