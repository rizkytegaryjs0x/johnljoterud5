package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class LoginPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	
	public LoginPanel() {

		setSize(Container.SIZE);
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblLogin.setBounds(284, 53, 76, 38);
		add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUsername.setBounds(108, 152, 103, 39);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPassword.setBounds(108, 220, 103, 38);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(241, 159, 140, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 227, 140, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(241, 303, 117, 29);
		btnLogin.setSize(Container.BUTTON);
		add(btnLogin);
		
		
		
	}

}
