package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogic {

	private Container container;
	
	public GUILogic() {

		container = new Container();
		container.getAddEvent().addActionListener(new AddEventActionListener());
		container.getAddNote().addActionListener(new AddNoteActionListener());
		container.getChangeCalendar().addActionListener(new ChangeCalendarActionListener());
		container.getCreateCalendar().addActionListener(new CreateCalendarActionListener());
		container.getLoginPanel().addActionListener(new LoginPanelActionListener());
		container.getShareCalendar().addActionListener(new ShareCalendarActionListener());
		container.getShowCalendar().addActionListener(new ShowCalendarActionListener());
		
		
		
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
		//mangler	
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
	private class ShowCalendarActionListener implements ActionListener {
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

	}
}