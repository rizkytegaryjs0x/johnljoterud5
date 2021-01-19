package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Container extends JFrame {

	
	private JPanel contentPane;
	private final LoginPanel loginPanel = new LoginPanel();
	private final CalendarPanel calendarPanel = new CalendarPanel();
	CardLayout c;
	


	public final static Dimension SIZE = new Dimension(650,450);
	public final static Dimension FRAMESIZE = new Dimension(670,470);
	public final static Dimension BUTTON = new Dimension(140, 40);
	public final static Dimension MAINBUTTON = new Dimension(225, 70);
	
	public static final String LOGINPANEL = "hejsa";
	public static final String CALENDARPANEL = "hej";

	
	
	public Container() {
		setTitle("CBS CALENDAR");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAMESIZE);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		loginPanel.getBtnLogin().setContentAreaFilled(false);
		contentPane.add(loginPanel, "hejsa");
		contentPane.add(calendarPanel, "hej");
		

		
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}
	public CalendarPanel getCalendarPanel() {
		return calendarPanel;
	}
	public void show(String card) {
		c.show(getContentPane(),  card);
}
}