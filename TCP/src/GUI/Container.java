package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.CalendarHandler;

public class Container extends JFrame {

	
	private JPanel contentPane;
	private final LoginPanel loginPanel = new LoginPanel();
	private final ShowCalendar showCalendar  = new ShowCalendar();
	private final AddEvent addEvent = new AddEvent();
	private final AddNote addNote = new AddNote();
	private final ChangeCalendar changeCalendar = new ChangeCalendar();
	private final CreateCalendar createCalendar = new CreateCalendar();
	private final ShareCalendar shareCalendar = new ShareCalendar();
	CardLayout c;
	


	public final static Dimension SIZE = new Dimension(1366,768);
	public final static Dimension FRAMESIZE = new Dimension(1366,768);
	public final static Dimension BUTTON = new Dimension(118, 29);
	public final static Dimension MAINBUTTON = new Dimension(225, 70);
	 
	public static final String LOGINPANEL = "LOGIN";
	public static final String SHOWCALENDAR = "SHOWCALENDAR";
	public static final String ADDEVENT = "ADDEVENT";
	public static final String ADDNOTE = "ADDNOTE";
	public static final String CHANGECALENDAR = "CHANGECALENDAR";
	public static final String CREATECALENDAR = "CREATECALENDAR";
	public static final String SHARECALENDAR = "SHARECALENDAR";
	
	
	
	public Container() {
		setTitle("CBS CALENDAR");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAMESIZE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0,0));
		
		
		contentPane.add(loginPanel, "LOGIN");
		
		contentPane.add(showCalendar, "SHOWCALENDAR");

		contentPane.add(addEvent, "ADDEVENT");
	
		contentPane.add(addNote, "ADDNOTE");
		
		contentPane.add(changeCalendar, "CHANGECALENDAR");
		
		contentPane.add(createCalendar, "CREATECALENDAR");
		
		contentPane.add(shareCalendar, "SHARECALENDAR");
		
		c = (CardLayout) getContentPane().getLayout();
		
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public ShowCalendar getShowCalendar() {
		return showCalendar;
	}
	public AddEvent getAddEvent() {
		return addEvent;
	}
	public AddNote getAddNote() {
		return addNote;
	}
	public ChangeCalendar getChangeCalendar() {
		return changeCalendar;
	}
	public CreateCalendar getCreateCalendar() {
		return createCalendar;
	}
	public ShareCalendar getShareCalendar() {
		return shareCalendar;
	}
	public void show(String card) {
		c.show(getContentPane(),  card);
}

	public CalendarHandler getCalendarHandler() {
		return calendarHandler;
	}
}