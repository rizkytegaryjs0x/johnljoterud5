package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class LoginPanel extends JPanel {

	private final JLabel lblLogin = new JLabel("Login");
	private final JLabel lblUsername = new JLabel("Username:");
	private final JLabel lblPassword = new JLabel("Password:");
	private final JTextField textFieldUsername = new JTextField();
	private final JTextField textFieldPassword = new JTextField();
	private final JButton btnLogin = new JButton("Login");
	
	public LoginPanel() {

		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		
		lblLogin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblLogin.setBounds(284, 53, 76, 38);
		add(lblLogin);
		
		
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUsername.setBounds(108, 152, 103, 39);
		add(lblUsername);
		
		
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPassword.setBounds(108, 220, 103, 38);
		add(lblPassword);
		
		
		textFieldUsername.setBounds(241, 159, 140, 28);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		
		textFieldPassword.setBounds(241, 227, 140, 28);
		add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		
		btnLogin.setBounds(241, 303, 117, 29);
		btnLogin.setSize(Container.BUTTON);
		add(btnLogin);
		
		
	}


	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}
	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public void addActionListener(ActionListener l) {
		btnLogin.addActionListener(l);
	
}
}
