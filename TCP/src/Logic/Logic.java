package Logic;

import tcpClasses.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;




import tcpClasses.TCPClient;
import GUI.AddNote;
import GUI.Container;
import JsonClasses.CalendarInfo;
import JsonClasses.ClientLogin;
import JsonClasses.ClientLogout;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.CreateNote;
import JsonClasses.GetDailyUpdate;
import JsonClasses.GetUsers;
import JsonClasses.RetrieveUserCalendar;
import JsonClasses.ShareCalendars;
import JsonClasses.UserEvent;
import JsonClasses.UserInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Logic {

	
		private Container container;

		TCPClient tcp = new TCPClient();
		Gson gson = new GsonBuilder().create();
		String stringSendToServer;
//		int week;
		
		
//		int year;
		
//		JSonClasses
		ClientLogin clientLogin = new ClientLogin();
		CreateCalendar createCalendar = new CreateCalendar();
		CreateEvent createEvent = new CreateEvent();
		GetDailyUpdate getDailyUpdate = new GetDailyUpdate();
		CreateNote createNote = new CreateNote();
		GetUsers getUsers = new GetUsers();
		ShareCalendars shareCalendar = new ShareCalendars();
		
		
		CalendarHandler cHandler;
		private String currentCalendar;
		private String currentEventId;
		private String currentUser;
		private String answer;
		private CalendarInfo thisWeeksInfo = new CalendarInfo();
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

				int currentWeek = container.getShowCalendar().getCurrentWeek();
			
				int currentYear = container.getShowCalendar().getCurrentYear();
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == container.getShowCalendar().getBtnAddCalendar()) {
					container.show(Container.CREATECALENDAR);
				}
				if (e.getSource() == container.getShowCalendar().getBtnAddEvent()) {
					
					container.show(Container.ADDEVENT);
					String [] dateInfo = container.getShowCalendar().getCh().getCellDate(	container.getShowCalendar().getSelectedColumn(), 
																							container.getShowCalendar().getSelectedRow(),
																							container.getShowCalendar().getCurrentYear(),
																							container.getShowCalendar().getCurrentWeek());
					container.getAddEvent().getTextFieldStartYear().setText(dateInfo[0]);
					container.getAddEvent().getTextFieldStartMonth().setText(dateInfo[1]);
					container.getAddEvent().getTextFieldStartDateDay().setText(dateInfo[2]);
					container.getAddEvent().getTextFieldStartHour().setText(dateInfo[3]);
					container.getAddEvent().getTextFieldEndYear().setText(dateInfo[0]);
					container.getAddEvent().getTextFieldEndMonth().setText(dateInfo[1]);
					container.getAddEvent().getTextFieldEndDateDay().setText(dateInfo[2]);
				}
				if (e.getSource() == container.getShowCalendar().getBtnAddNote()) {
					updateTableAddNote();
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
					updateCalendarTableShareCalendar();
					updateUserTableShareCalendar();
					container.show(Container.SHARECALENDAR);
				}
				if (e.getSource() == container.getShowCalendar().getBtnNext()) {
					
					
				
							if (currentWeek == 52) { // Foward one year
								container.getShowCalendar().setCurrentWeek(1);
								container.getShowCalendar().setCurrentYear(currentYear +=1);
							} else { // Foward one month
								container.getShowCalendar().setCurrentWeek(currentWeek +=1);

							}
							container.getShowCalendar().refreshCalendar(currentWeek, currentYear);
							setThisWeeksInfo(container.getShowCalendar().getCh().getWeekEvents(currentWeek, currentYear));
							updateTableAddNote();
					
					
					
				}
				if (e.getSource() == container.getShowCalendar().getBtnPrev()) {
					
					
					if (currentWeek == 0) { // Back one year
						
						container.getShowCalendar().setCurrentWeek(52);
						container.getShowCalendar().setCurrentYear(currentYear -=1);
					
					} else { // Back one month
						container.getShowCalendar().setCurrentWeek(currentWeek -=1);
					}
					container.getShowCalendar().refreshCalendar(currentWeek, currentYear);
					
					setThisWeeksInfo(container.getShowCalendar().getCh().getWeekEvents(currentWeek, currentYear));
					
					updateTableAddNote();
				if(e.getSource() == container.getShowCalendar().getCmbYear()) {
					
					if (container.getShowCalendar().getCmbYear().getSelectedItem() != null) {
						String b = container.getShowCalendar().getCmbYear().getSelectedItem().toString();
						container.getShowCalendar().setCurrentYear(Integer.parseInt(b));
						container.getShowCalendar().refreshCalendar(currentWeek, currentYear);
					}
				}
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
						
							
							String calendarName = container.getCreateCalendar().getTextName().getText();
							String privatePublic = container.getCreateCalendar().getTextPrivateOrPublic().getText();
							int pPublic = 0;
							if(privatePublic.equals("public")){pPublic = 1;}
							else if (privatePublic.equals("private")){pPublic = 0;}
							
							
							ArrayList<String>sharedUsers = new ArrayList<String>();
								
							String shareWith = container.getCreateCalendar().getTxtShare().getText();
							String createdBy = getCurrentUser();
							if(container.getCreateCalendar().getChckbxIfYesCheck().isSelected())
							{
						
							
							sharedUsers.add(shareWith);
							
							}else{
								sharedUsers.isEmpty();
							}	
							
							int isCbs = 0;
							createCalendar.setCalendarName(calendarName);
							createCalendar.setPublicOrPrivate(pPublic);
							createCalendar.setCreatedBy(createdBy);
							createCalendar.setSharedUsers(sharedUsers);
							createCalendar.setIsCBS(isCbs);
							
							
							System.out.println("getcurrentUser" + getCurrentUser());
							System.out.println("Check CreateCalendar cc for CU: " + createCalendar.getCreatedBy());
							
							stringSendToServer = gson.toJson(createCalendar);
							
							try {
								answer = tcp.TalkToServer(stringSendToServer);
//								cc = (CreateCalendar)gson.fromJson(answer, CreateCalendar.class);
								
								container.show(Container.SHOWCALENDAR);
							} catch (UnknownHostException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
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
						
							createEvent.setCalendarID(getCurrentCalendar());
							createEvent.setCreatedby(getCurrentUser());
							createEvent.setLocation(container.getAddEvent().getTextField_Location().getText());
							createEvent.setStart(container.getAddEvent().startDateTimeToString());
							createEvent.setEnd(container.getAddEvent().endDateTimeToString());
							createEvent.setTitle(container.getAddEvent().getTextField_Name().getText());
							createEvent.setText(container.getAddEvent().getTextField_Text().getText());
							createEvent.setType(container.getAddEvent().getTextField_Type().getText());
							
								stringSendToServer = gson.toJson(createEvent);
								
								
						}
				}
				}
				private class AddNoteActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getAddNote().getBtnBack()) {
						container.show(Container.SHOWCALENDAR);
					}
					if (e.getSource() == container.getAddNote().getBtnAddNote()) {
						
						String eventID = container.getAddNote().getTxtEventID().getText();
						String note = container.getAddNote().getTextFieldNote().getText();
						
						createNote.setCreatedBy(getCurrentUser());
						createNote.setEventID(eventID);
						createNote.setText(note);
						
						stringSendToServer = gson.toJson(createNote);
						
						try {
							answer = tcp.TalkToServer(stringSendToServer);

							
							container.show(Container.SHOWCALENDAR);
						} catch (UnknownHostException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					}

			}
				private class ChangeCalendarActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getChangeCalendar().getBtnBack()) {
						container.show(Container.SHOWCALENDAR);
					}
					if (e.getSource() == container.getChangeCalendar().getBtnChoose());
					
						setCurrentCalendar(container.getChangeCalendar().getName());
						
							System.out.println(getCurrentCalendar());	
							
							//hent events for den valgte kalender. DET MÅ FIKSES
							
							container.show(Container.SHOWCALENDAR);
							}

				}
				private class LoginPanelActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getLoginPanel().getBtnLogin()) {
					
						
						clientLogin.setEmail(container.getLoginPanel().getTextFieldUsername().getText());
						clientLogin.setPassWord(container.getLoginPanel().getTextFieldPassword().getText());
						stringSendToServer = gson.toJson(clientLogin);
						
						
						
						
						try {
							
							answer = tcp.TalkToServer(stringSendToServer);
							ClientLogin cl = (ClientLogin)gson.fromJson(answer, ClientLogin.class);
							System.out.println(cl.getEmail());
							System.out.println(clientLogin.getRole());
							System.out.println(clientLogin.getUserID());
							System.out.println(clientLogin.getCalendars());
							
							setCurrentUser(clientLogin.getEmail());
							
					
							
							
						stringSendToServer = gson.toJson(getDailyUpdate);
							answer = tcp.TalkToServer(stringSendToServer);
							getDailyUpdate = (GetDailyUpdate)gson.fromJson(answer, GetDailyUpdate.class);
							
							
							String celsius = getDailyUpdate.getCelsius();
							String desc = getDailyUpdate.getDesc();
							String qotd = getDailyUpdate.getQuote();
							
							
							
							
							container.getShowCalendar().getTxtQOTD().setText("DAGENS QUOTE: "+ qotd);
							container.getShowCalendar().getTxtForecast().setText("Dagens værutsikter:\n celsius: "+ celsius 
									+ "\nværbeskrivelse: " + desc);
							
							
							
							
							container.getShowCalendar().getCh().setCalendar(clientLogin.getCalendars());
							container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear());
							
							setThisWeeksInfo(container.getShowCalendar().getCh().getWeekEvents(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear()));
							updateTableAddNote();
							
							updateTableChangeCalendar();
							container.show(Container.CHANGECALENDAR);
							
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
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
					
						String calendarID = container.getShareCalendar().getTextFieldChooseCalendar().getText();						
						String shareEmail = container.getShareCalendar().getTextFieldChooseUser().getText();
						
						ArrayList<String>sharedUsers = new ArrayList<String>();
						
						if(calendarID != "" || shareEmail != ""){
							
							sharedUsers.add(shareEmail);
						}else{
							//feilmelding
						}
						
						shareCalendar.setCalendarID(calendarID);
						shareCalendar.setEmail(getCurrentUser());
						shareCalendar.setShareEmail(sharedUsers);
						
						stringSendToServer = gson.toJson(shareCalendar);
						
							try {
								answer = tcp.TalkToServer(stringSendToServer);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						container.show(Container.SHOWCALENDAR);
						
					}

					}

				}



				public void updateTableAddNote(){
					try{
						container.getAddNote().getModel().getDataVector().removeAllElements();

						
						for(UserEvent temp : thisWeeksInfo.getCalendars()){
							
							System.out.println("eventid: " + temp.getEventid() + "title: " +temp.getEventid());
							
							container.getAddNote().getModel().insertRow(container.getAddNote().getModel().getRowCount(), new Object[]{
								temp.getEventid(),temp.getText(),temp.getType()
								
								
							});
							
							
							}
						
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
					
				}
				public void updateTableChangeCalendar() {

					try{
					container.getChangeCalendar().getModel().getDataVector().removeAllElements();

					
					for(CalendarInfo c  : clientLogin.getCalendars()){
						
					System.out.println("somethingsomething: " + c.getCalenderName());

						
						container.getChangeCalendar().getModel().insertRow(container.getChangeCalendar().getModel().getRowCount(), new Object[]{
							c.getCalendarId(),c.getCalenderName()
							
						});
						
						
						}
					
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			
				public void updateUserTableShareCalendar(){
					try{
						GetUsers ue = new GetUsers();
						container.getShareCalendar().getModelUser().getDataVector().removeAllElements();
						stringSendToServer = gson.toJson(ue);
						answer = tcp.TalkToServer(stringSendToServer);
						GetUsers gu = (GetUsers)gson.fromJson(answer, GetUsers.class);
						for(UserInfo user  : gu.getUserArray()){
												
							container.getShareCalendar().getModelUser().insertRow(container.getShareCalendar().getModelUser().getRowCount(), new Object[]{
								user.getEmail(), user.getActive()
								
							});
						}						
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
					
				}
				public void updateCalendarTableShareCalendar(){
					try{
					RetrieveUserCalendar ru = new RetrieveUserCalendar();
					ru.setEmail(getCurrentUser());
					container.getShareCalendar().getModelCalendar().getDataVector().removeAllElements();
					stringSendToServer = gson.toJson(ru);
					answer =  tcp.TalkToServer(stringSendToServer);
					
					RetrieveUserCalendar r = (RetrieveUserCalendar)gson.fromJson(answer, RetrieveUserCalendar.class);
					for(CalendarInfo ci  : r.getUserCalendars()){
						
						container.getShareCalendar().getModelCalendar().insertRow(container.getShareCalendar().getModelCalendar().getRowCount(), new Object[]{
							ci.getCalendarId(),ci.getCalenderName()
							
						});
					}						
					}catch(Exception ex)
					{
						ex.printStackTrace();
					
				
			}
				}

				public String getCurrentUser() {
					return currentUser;
				}


				public void setCurrentUser(String currentUser) {
					this.currentUser = currentUser;
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
				public CalendarInfo getThisWeeksInfo() {
					return thisWeeksInfo;
				}


				public void setThisWeeksInfo(CalendarInfo thisWeeksInfo) {
					this.thisWeeksInfo = thisWeeksInfo;
				}
}
	
