package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ActionController;
import java.awt.Font;

public class LoginPanel extends JPanel {

	private ActionController actionController;
	private JTextField txtremail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel title;
	
	
	public static final String LOGINSUBMIT  = "loginSubmit";
	
	
	public LoginPanel(ActionController actionController){
		
		this.actionController = actionController;
		setLayout(null);
		
		txtremail = new JTextField();
		txtremail.setBounds(278, 68, 250, 29);
		add(txtremail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(278, 109, 250, 29);
		add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(346, 150, 117, 29);
		add(btnLogin);
		btnLogin.addActionListener(actionController);
		btnLogin.setActionCommand(LOGINSUBMIT);
		
		title = new JLabel("Calendar v2");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		title.setBounds(308, 30, 155, 26);
		add(title);
		
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
