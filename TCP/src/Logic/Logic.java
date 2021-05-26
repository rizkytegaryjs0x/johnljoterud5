package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import tcpClasses.TCPClient;
import GUI.Container;
import JsonClasses.CalendarInfo;
import JsonClasses.ClientLogin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Logic {

	
		private Container container;

		TCPClient tcp = new TCPClient();
		Gson gson = new GsonBuilder().create();
		String stringSendToServer;
//		int week;
		
		
//		int year;
		ClientLogin cl = new ClientLogin();
		
		private String currentCalendar;
		private String currentEventId;
		private String answer;
		public Logic(){
			
		
			container = new Container();
			
//			container.getLoginPanel().addActionListener(new LoginPanelActionListener());
			container.getShowCalendar().addActionListener(new ShowCalendarActionListener());
			container.getAddEvent().addActionListener(new AddEventActionListener());
			container.getAddNote().addActionListener(new AddNoteActionListener());
			container.getChangeCalendar().addActionListener(new ChangeCalendarActionListener());
			container.getCreateCalendar().addActionListener(new CreateCalendarActionListener());
			container.getLoginPanel().addActionListener(new LoginPanelActionListener());
			container.getShareCalendar().addActionListener(new ShareCalendarActionListener());
			
			
		}
	
		
		public void run() {
//			container.getShowCalendar().refreshCalendar(week, year);
			container.show(Container.LOGINPANEL);
			container.setVisible(true);
		}
		
		
		private class ShowCalendarActionListener implements ActionListener{

			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == container.getShowCalendar().getBtnAddCalendar()) {
					container.show(Container.CREATECALENDAR);
				}
				if (e.getSource() == container.getShowCalendar().getBtnAddEvent()) {
					container.show(Container.ADDEVENT);
				}
				if (e.getSource() == container.getShowCalendar().getBtnAddNote()) {
					container.show(Container.ADDNOTE);
				}
				if (e.getSource() == container.getShowCalendar().getBtnChangeCalendar()) {
					updateTableChangeCalendar();
					container.show(Container.CHANGECALENDAR);
				}
				if (e.getSource() == container.getShowCalendar().getBtnLogout()) {
					container.show(Container.LOGINPANEL);
				}
				if (e.getSource() == container.getShowCalendar().getBtnShareCalendar()) {
					container.show(Container.SHARECALENDAR);
				}
				if (e.getSource() == container.getShowCalendar().getBtnNext()) {
					
				}
				if (e.getSource() == container.getShowCalendar().getBtnPrev()) {
					
				}
				}
//				if (e.getSource() == container.getShowCalendar().getBtnNext()){
//					week = container.getShowCalendar().getCurrentWeek();
//					year = container.getShowCalendar().getCurrentYear();
//					if (week == 52) { // Foward one year
//						container.getShowCalendar().setCurrentWeek(1);
//						container.getShowCalendar().setCurrentYear(year += 1);
//					} else { // Foward one month
//						container.getShowCalendar().setCurrentWeek(week +=1);
//					}
//					container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear());
//					System.out.println(("current week: " + week + "\n current year: " + year));
//				
//					
//				}
			}
				private class CreateCalendarActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == container.getCreateCalendar().getBtnSubmit()) {
						//mangler
							
						}
						if (e.getSource() == container.getCreateCalendar().getBtnBack()) {
							container.show(Container.SHOWCALENDAR);
						}
				}
				}
				private class AddEventActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == container.getAddEvent().getBtnBack()) {
							container.show(Container.SHOWCALENDAR);
						}
						if (e.getSource() == container.getAddEvent().getBtnSubmit()) {
						//mangler
							
						}
				}
				}
				private class AddNoteActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getAddNote().getBtnBack()) {
						container.show(Container.SHOWCALENDAR);
					}
					if (e.getSource() == container.getAddNote().getBtnAddNote()) {
						//mangler
					}
					}

			}
				private class ChangeCalendarActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getChangeCalendar().getBtnBack()) {
						container.show(Container.SHOWCALENDAR);
					}
					if (e.getSource() == container.getChangeCalendar().getBtnChoose());
					//mangler
					}

				}
				private class LoginPanelActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getLoginPanel().getBtnLogin()) {
					
						
						cl.setEmail(container.getLoginPanel().getTextFieldUsername().getText());
						cl.setPassWord(container.getLoginPanel().getTextFieldPassword().getText());
						stringSendToServer = gson.toJson(cl);
						try {
							
							answer = tcp.TalkToServer(stringSendToServer);
							cl = (ClientLogin)gson.fromJson(answer, ClientLogin.class);
							container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear());
							System.out.println("cweek: " + container.getShowCalendar().getCurrentWeek() + " cyear: " +  container.getShowCalendar().getCurrentYear());
							container.show(Container.SHOWCALENDAR);
							
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}
					}

				}
				private class ShareCalendarActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getShareCalendar().getBtnBack()) {
						container.show(Container.SHOWCALENDAR);
					}
					if (e.getSource() == container.getShareCalendar().getBtnShare()) {
					//mangler
					}
					if (e.getSource() == container.getShareCalendar().getBtnChooseCalendar()) {
					//mangler	
					}
					if (e.getSource() == container.getShareCalendar().getBtnChooseUser()) {
					//mangler
					}
					}

				}


				
			
		

				
				
				

				
				
			
			
		
		
		
	

//		private class LoginPanelActionListener implements ActionListener {
//			public void actionPerformed(ActionEvent e) {
//				try {
//
//					action = e.getActionCommand();
//
//					String userName = container.getLoginPanel().getTextFieldUsername()
//							.getText().trim();
//					String pass = container.getLoginPanel().getTextFieldPassword()
//							.getText();
//										
//					if ((action.equals("btnLogin"))) {
//						System.out.println("hit1");
//						
						//Creates object of jsonClasses.ClientLogin
						//Sets login information
//						cl.setEmail(userName);
//						cl.setPassWord(pass);
//						//Converts object to jsonString
////						String gsonString = gson.toJson(cl);
//						//Sends object to server using tcpClient.TCPClient and receives response as string serverResponse
//						String serverResponse = tcp.TalkToServer(gsonString);
//						System.out.println("hit2");
//						
//						//Uses serveResponse as a check for login confirmation
//						if (serverResponse != "")
//
//						{
//
//							container.show(Container.CALENDARPANEL);
//
//						}
//
//						else if (loggedIn != 0) {
//							JOptionPane.showMessageDialog(null,
//									"\nLogin failed, error: " + loggedIn,
//									"Error message", JOptionPane.PLAIN_MESSAGE);
//						}
//					
//					}
//				}catch (Exception e3) {
//				}
//			}	
		

	
//	}

				public void updateTableChangeCalendar() {

					try{
					container.getChangeCalendar().getModel().getDataVector().removeAllElements();

					
					for(CalendarInfo c  : cl.getCalendars()){
						System.out.println(c.getCalenderName());
					

						
						container.getChangeCalendar().getModel().insertRow(container.getChangeCalendar().getModel().getRowCount(), new Object[]{
							c.getCalenderName()
							
						});
						
						
						}
					
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}


				public String getCurrentCalendar() {
					return currentCalendar;
				}


				public void setCurrentCalendar(String currentCalendar) {
					this.currentCalendar = currentCalendar;
				}


				public String getCurrentEventId() {
					return currentEventId;
				}


				public void setCurrentEventId(String currentEventId) {
					this.currentEventId = currentEventId;
				}
	
}
	
