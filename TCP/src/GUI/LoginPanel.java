package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	
	public LoginPanel() {

		setSize(Container.SIZE);
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(305, 53, 61, 16);
		add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(93, 165, 76, 16);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(93, 216, 76, 16);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(232, 159, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 210, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(242, 319, 117, 29);
		add(btnLogin);
		
		
		
	}

}
