package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class LoginPanel extends JPanel {

	private final JLabel lblCreate;
	private final JLabel lblUsername;
	private final JLabel lblPassword;
	private final JTextField textFieldUsername;
	private final JTextField textFieldPassword;
	private final JButton btnLogin;
	
	public LoginPanel() {

		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		
		lblCreate = new JLabel("Login");
		lblCreate.setForeground(new Color(0, 0, 0));
		lblCreate.setFont(new Font("Arial", Font.BOLD, 78));
		lblCreate.setBounds(451, 90, 466, 91);
		add(lblCreate);
		
		
		lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Arial", Font.BOLD, 26));
		lblUsername.setBounds(381, 328, 149, 30);
		add(lblUsername);
		
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 26));
		lblPassword.setBounds(381, 401, 149, 30);
		add(lblPassword);
		
		
		textFieldUsername = new JTextField();
		textFieldUsername.setForeground(SystemColor.controlDkShadow);
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(558, 330, 202, 34);
		add(textFieldUsername);
		
		
		textFieldPassword = new JTextField();
		textFieldPassword.setForeground(SystemColor.controlDkShadow);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(558, 403, 202, 34);
		add(textFieldPassword);
		
		
		btnLogin = new JButton("Login");
		btnLogin.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,
						0), new Color(255, 255, 255), new Color(0, 0, 0)),
				new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255),
						new Color(0, 0, 0), new Color(255, 255, 255),
						new Color(0, 0, 0))));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBounds(451, 600, 194, 50);
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
