package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;



public class Logic {

	public class GUILogic {
		private Container container;
		private String action;
		private int loggedIn;
	
		public Logic(){
			container = new Container();
			
			container.getLoginPanel().addActionListener(new LoginPanelActionListener());
			container.getCalendarPanel().addActionListener(new CalendarPanelActionListener());
			
		}
	
		
		public void run() {

			container.show(Container.LOGINPANEL);
			container.setVisible(true);
		}
		private class LoginPanelActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {

					action = e.getActionCommand();

					String userName = container.getLoginPanel().getTextFieldUsername()
							.getText().trim();
					char[] pass = container.getLoginPanel().getTextFieldPassword()
							.getPassword();
					String password = String.valueOf(pass);
					
					if ((action.equals("btnLogin"))) {
						System.out.println("hit1");
						//mangler auth.
						//loggedIn = auth.authenticate(userName, password, true);
						System.out.println("hit2");

						if (loggedIn == 0)

						{

							container.show(Container.CALENDARPANEL);

						}

						else if (loggedIn != 0) {
							JOptionPane.showMessageDialog(null,
									"\nLogin failed, error: " + loggedIn,
									"Error message", JOptionPane.PLAIN_MESSAGE);
						}

					}
				}catch (Exception e3) {
				}
			
		
		private class CalendarPanelActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == container.getCalendarPanel().getBtnDelKalender()) {
						container.show(Container.//class);
					}
					if (e.getSource() == container.getCalendarPanel().getBtnOpretKalender()) {
						container.show(Container.//class);
					}
					
			
		
	
			}
	}
}

							
	
