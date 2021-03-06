package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tcpClasses.TCPClient;
import GUI.Container;
import JsonClasses.CalendarInfo;
import JsonClasses.ClientLogin;
import JsonClasses.ClientLogout;
import JsonClasses.CreateCalendar;
import JsonClasses.CreateEvent;
import JsonClasses.CreateNote;
import JsonClasses.DeleteEvent;
import JsonClasses.DeleteNote;
import JsonClasses.GetDailyUpdate;
import JsonClasses.GetNotes;
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
		
//		JSonClasses
		ClientLogin clientLogin = new ClientLogin();
		CreateCalendar createCalendar = new CreateCalendar();
		CreateEvent createEvent = new CreateEvent();
		GetDailyUpdate getDailyUpdate = new GetDailyUpdate();
		CreateNote createNote = new CreateNote();
		GetUsers getUsers = new GetUsers();
		ShareCalendars shareCalendar = new ShareCalendars();
		DeleteEvent deleteEvent = new DeleteEvent();
		ClientLogout clientLogOut = new ClientLogout();
		DeleteNote deleteNote = new DeleteNote();
		
		
		
		CalendarHandler cHandler;
		private int currentCalendar;
		private String currentEventId;
		private String currentUser;
		private String answer;
		int currentWeek;
		int currentYear;
		String password;
		private CalendarInfo thisWeeksInfo = new CalendarInfo();
		public Logic(){
			
		
			container = new Container();
			
			

			container.getShowCalendar().addActionListener(new ShowCalendarActionListener());
			container.getAddEvent().addActionListener(new AddEventActionListener());
			container.getAddNote().addActionListener(new AddNoteActionListener());
			container.getChangeCalendar().addActionListener(new ChangeCalendarActionListener());
			container.getCreateCalendar().addActionListener(new CreateCalendarActionListener());
			container.getLoginPanel().addActionListener(new LoginPanelActionListener());
			container.getShareCalendar().addActionListener(new ShareCalendarActionListener());
			container.getEventList().addActionlistener(new EventListActionListener());
			container.getNoteList().addActionlistener(new NoteListActionListener());
			
		}
	
		
		public void run() {

			container.show(Container.LOGINPANEL);
			container.setVisible(true);
		}
		
		//Contains actionlisteners and logic for the different buttons in calendar view
		private class ShowCalendarActionListener implements ActionListener{

				
			
			public void actionPerformed(ActionEvent e) {
				
				
				currentWeek = container.getShowCalendar().getCurrentWeek();
				currentYear = container.getShowCalendar().getCurrentYear();
				
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
				if (e.getSource() == container.getShowCalendar().getBtnDeleteEvent()){
					
					updateTableEventList();
					
					container.show(Container.EVENTLIST);
					
				}
				
				if (e.getSource() == container.getShowCalendar().getBtnLogout()) {
					
					clientLogOut.setEmail(getCurrentUser());
					stringSendToServer = gson.toJson(clientLogOut);
					try {
						tcp.TalkToServer(stringSendToServer);
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
					
					container.show(Container.LOGINPANEL);
				}
				if (e.getSource() == container.getShowCalendar().getBtnShareCalendar()) {
					updateCalendarTableShareCalendar();
					updateUserTableShareCalendar();
					container.show(Container.SHARECALENDAR);
				}
				if (e.getSource() == container.getShowCalendar().getBtnDeleteNote()){
					
				
				updateTableNoteList();
				
				container.show(Container.NOTELIST);
				
				}
				if (e.getSource() == container.getShowCalendar().getBtnNext()) {
					
					
				
							if (currentWeek == 52) { // Foward one year
								container.getShowCalendar().setCurrentWeek(1);
								container.getShowCalendar().setCurrentYear(currentYear +=1);
							} else { // Foward one month
								container.getShowCalendar().setCurrentWeek(currentWeek +=1);

							}
							container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
							setThisWeeksInfo(container.getShowCalendar().getCh().getWeekEvents(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar()));
							updateTableAddNote();
					
					
					
				}
				if (e.getSource() == container.getShowCalendar().getBtnPrev()) {
					
					
					if (currentWeek == 1) { // Back one year
						
						container.getShowCalendar().setCurrentWeek(52);
						container.getShowCalendar().setCurrentYear(currentYear -=1);
					
					} else { // Back one month
						container.getShowCalendar().setCurrentWeek(currentWeek -=1);
					}
					container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(),getCurrentCalendar());
					
					setThisWeeksInfo(container.getShowCalendar().getCh().getWeekEvents(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(),getCurrentCalendar()));
					
					updateTableAddNote();
				
				}
				}
			}
		//Contains actionlisteners and logic for the different elements of eventList view 		
		private class EventListActionListener implements ActionListener{
		

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == container.getEventList().getBtnDelete()){
					
					setCurrentEventId(container.getEventList().getEventId());
					
					deleteEvent.setEventId(getCurrentEventId()); 
					deleteEvent.setEmail(getCurrentUser());
					
					
					stringSendToServer = gson.toJson(deleteEvent);
					
					try {
						tcp.TalkToServer(stringSendToServer);
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
					updateTableEventList();
					container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
					container.show(Container.SHOWCALENDAR);
					
				}
				if (e.getSource() == container.getEventList().getBtnBack()){
					
					container.show(Container.SHOWCALENDAR);
				}
		
		
			}
		
		}
		//Contains actionlisteners and logic for noteList view
		private class NoteListActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == container.getNoteList().getBtnBack()){
					
					container.show(Container.SHOWCALENDAR);
				}
				if (e.getSource() == container.getNoteList().getBtnDelete()){
					
					String nId = container.getNoteList().getEventId();
					
					deleteNote.setNoteID(nId);
					deleteNote.setEmail(getCurrentUser());
					
					stringSendToServer = gson.toJson(deleteNote);
					
					try {
						tcp.TalkToServer(stringSendToServer);
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
					
					updateTableNoteList();
				}
				
			}
			
		}
		//Contains actionlisteners and logic for create calendar view
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
							String email = getCurrentUser();
							if(container.getCreateCalendar().getChckbxIfYesCheck().isSelected())
							{
								
							
							sharedUsers.add(shareWith);
							
							}else{
								sharedUsers.isEmpty();
							}	
							
							int isCbs = 0;
							createCalendar.setCalendarName(calendarName);
							createCalendar.setPublicOrPrivate(pPublic);
							createCalendar.setEmail(email);
							createCalendar.setSharedUsers(sharedUsers);
							createCalendar.setIsCBS(isCbs);
							
							
							stringSendToServer = gson.toJson(createCalendar);
							
							try {
								answer = tcp.TalkToServer(stringSendToServer);
//								
								
								clientLogin.setEmail(getCurrentUser());
								clientLogin.setPassWord(getPassword());
								
								stringSendToServer = gson.toJson(clientLogin);									
								answer = tcp.TalkToServer(stringSendToServer);
								clientLogin = (ClientLogin)gson.fromJson(answer, ClientLogin.class);
								setCurrentUser(clientLogin.getEmail());
								setPassword(clientLogin.getPassWord());
								container.getShowCalendar().getCh().setCalendar(clientLogin.getCalendars());
				
							} catch (UnknownHostException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							container.show(Container.SHOWCALENDAR);
							
						}
						if (e.getSource() == container.getCreateCalendar().getBtnBack()) {
							container.show(Container.SHOWCALENDAR);
						}
				}
				}
		//Contains actionlisteners and logic for add event view
		private class AddEventActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == container.getAddEvent().getBtnBack()) {
							container.show(Container.SHOWCALENDAR);
						}
						if (e.getSource() == container.getAddEvent().getBtnSubmit()) {
						
							if(getCurrentCalendar() == 0){
								
								JOptionPane.showMessageDialog(null,
										"\nYou have to choose a specific calendar to create an event!",
										"Error message", JOptionPane.PLAIN_MESSAGE);
								
								container.show(Container.CHANGECALENDAR);
							}else{
							createEvent.setCalendarID(String.valueOf(getCurrentCalendar()));
							createEvent.setCreatedby(getCurrentUser());
							createEvent.setLocation(container.getAddEvent().getTextField_Location().getText());
							createEvent.setStart(container.getAddEvent().startDateTimeToString());
							createEvent.setEnd(container.getAddEvent().endDateTimeToString());
							createEvent.setTitle(container.getAddEvent().getTextField_Name().getText());
							createEvent.setText(container.getAddEvent().getTextField_Text().getText());
							createEvent.setType(container.getAddEvent().getTextField_Type().getText());
							
								stringSendToServer = gson.toJson(createEvent);
								
								try {
									tcp.TalkToServer(stringSendToServer);
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
								JOptionPane.showMessageDialog(null,
										"\nEvent has been added to the calendar", "", JOptionPane.PLAIN_MESSAGE);
								
								
								
								//sender clientLogin p? nytt, for ? f? oppdatert informasjon
								System.out.println("THE PASSWORD USED: " + getPassword());
								ClientLogin cl = new ClientLogin();
								cl.setEmail(getCurrentUser());
								cl.setPassWord(getPassword());
								stringSendToServer = gson.toJson(cl);
								try {
									answer = tcp.TalkToServer(stringSendToServer);
									 cl = (ClientLogin)gson.fromJson(answer, ClientLogin.class);
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
								
								container.getShowCalendar().getCh().setCalendar(cl.getCalendars());
								container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
								
								container.show(Container.SHOWCALENDAR);
						}
						}
				}
				}
		//Contains actionlisteners and logic for add note view
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

							container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
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
		//Contains actionlisteners and logic for change calendar view
		private class ChangeCalendarActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getChangeCalendar().getBtnChooseAll()) {
						setCurrentCalendar(0);
						container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
						container.show(Container.SHOWCALENDAR);
					}
					 if (e.getSource() == container.getChangeCalendar().getBtnChoose()){
					
						 
					
					int cid = Integer.valueOf(container.getChangeCalendar().getCalId());
					

						setCurrentCalendar(cid);
						
						container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
							
							container.show(Container.SHOWCALENDAR);
							
					 }
					 }

				}
		//Contains actionlisteners and logic for Login panel view
		private class LoginPanelActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource() == container.getLoginPanel().getBtnLogin()) {
					
						
						clientLogin.setEmail(container.getLoginPanel().getTextFieldUsername().getText());
						clientLogin.setPassWord(container.getLoginPanel().getTextFieldPassword().getText());
						
						
						
						
						stringSendToServer = gson.toJson(clientLogin);
						
						setCurrentUser(clientLogin.getEmail());
						setPassword(clientLogin.getPassWord());
						
						
						try {
							
							answer = tcp.TalkToServer(stringSendToServer);
							 clientLogin = (ClientLogin)gson.fromJson(answer, ClientLogin.class);
							
							
							if(clientLogin.isLoggedIn()){

							
							
							
							
						stringSendToServer = gson.toJson(getDailyUpdate);
							answer = tcp.TalkToServer(stringSendToServer);
							getDailyUpdate = (GetDailyUpdate)gson.fromJson(answer, GetDailyUpdate.class);
							
							
							String celsius = getDailyUpdate.getCelsius();
							String desc = getDailyUpdate.getDesc();
							String qotd = getDailyUpdate.getQuote();
							
							
							
							
							container.getShowCalendar().getTxtQOTD().setText("DAGENS QUOTE: "+ qotd);
							container.getShowCalendar().getTxtForecast().setText("Dagens vejrudsigter: \n celsius: "+ celsius 
									+ "\n - vvejrbeskrivelse: " + desc);
							
							
							
							
							container.getShowCalendar().getCh().setCalendar(clientLogin.getCalendars());
							
							container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
							
							setThisWeeksInfo(container.getShowCalendar().getCh().getWeekEvents(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(),getCurrentCalendar()));
							updateTableAddNote();
							
							updateTableChangeCalendar();
							container.show(Container.CHANGECALENDAR);
							}
							else{
								
								JOptionPane.showMessageDialog(null,
										"\nBad login information! Try again.", "error message", JOptionPane.PLAIN_MESSAGE);
							}
						
							
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
		//Contains actionlisteners and logic for share calendar view
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


				//Method for updating the table in the add note view
				public void updateTableAddNote(){
					try{
						container.getAddNote().getModel().getDataVector().removeAllElements();

						
						for(UserEvent temp : thisWeeksInfo.getCalendars()){
							
							if(temp.getCalendarID() == getCurrentCalendar()){
							container.getAddNote().getModel().insertRow(container.getAddNote().getModel().getRowCount(), new Object[]{
								temp.getEventid(),temp.getText(),temp.getType()
								
								
							});
							
							}
							}
						
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
					container.getShowCalendar().refreshCalendar(container.getShowCalendar().getCurrentWeek(), container.getShowCalendar().getCurrentYear(), getCurrentCalendar());
				}
				//Updates table in the change calendar view
				public void updateTableChangeCalendar() {

					try{
					container.getChangeCalendar().getModel().getDataVector().removeAllElements();

					
					for(CalendarInfo c  : clientLogin.getCalendars()){
						
					

						
						container.getChangeCalendar().getModel().insertRow(container.getChangeCalendar().getModel().getRowCount(), new Object[]{
							c.getCalendarId(),c.getCalenderName()
							
						});
						
						
						}
					
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				//Updates table in the event list view
				public void updateTableEventList(){
					
					try{
						
						container.getEventList().getModel().getDataVector().removeAllElements();
						
					ArrayList< UserEvent> myEvents = container.getShowCalendar().getCh().getCalendarEvents(getCurrentCalendar());
						
						for(UserEvent events : myEvents){
							
							
							
							container.getEventList().getModel().insertRow(container.getEventList().getModel().getRowCount(), new Object[]{
								
								events.getEventid(), events.getType(), events.getTitle(), events.getText(), events.getStart(), events.getEnd()
								
							});
						}
						
						
	
						
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
				//Updates table containing users in the share calendar view
				public void updateUserTableShareCalendar(){
					try{
						GetUsers ue = new GetUsers();
						container.getShareCalendar().getModelUser().getDataVector().removeAllElements();
						stringSendToServer = gson.toJson(ue);
						answer = tcp.TalkToServer(stringSendToServer);
						ue = (GetUsers)gson.fromJson(answer, GetUsers.class);
						for(UserInfo user  : ue.getUserArray()){
												
							container.getShareCalendar().getModelUser().insertRow(container.getShareCalendar().getModelUser().getRowCount(), new Object[]{
								user.getEmail(), user.getActive()
								
							});
						}						
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
					
				}
				//Updates table containing calendars in share calendar view
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
				//Updates table in note list view
				public void updateTableNoteList(){
					try{
						
					container.getNoteList().getModel().getDataVector().removeAllElements();	
					
					GetNotes  notes = container.getShowCalendar().getWeekNotes();
					ArrayList<CreateNote> noteArray = notes.getNotes();
					for(CreateNote note : noteArray){
						System.out.println("Checking note: " + note.getNoteID());
						if(note.getCreatedBy().equals(getCurrentUser())){
							System.out.println("Note has been added to table.");
							container.getNoteList().getModel().insertRow(container.getNoteList().getModel().getRowCount(), new Object[]{
								 note.getNoteID(), note.getEventID(), note.getText()
								
							});
						}	
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


				public int getCurrentCalendar() {
					return currentCalendar;
				}


				public void setCurrentCalendar(int currentCalendar) {
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


				public String getPassword() {
					return password;
				}


				public void setPassword(String password) {
					this.password = password;
				}
				
					
}

	
