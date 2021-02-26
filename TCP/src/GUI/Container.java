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
	private final ShowCalendar showCalendar  = new ShowCalendar();
	CardLayout c;
	


	public final static Dimension SIZE = new Dimension(1366,768);
	public final static Dimension FRAMESIZE = new Dimension(1366,768);
	public final static Dimension BUTTON = new Dimension(118, 29);
	public final static Dimension MAINBUTTON = new Dimension(225, 70);
	
	public static final String LOGINPANEL = "LOGIN";
	public static final String SHOWCALENDAR = "SHOWCALENDAR";
	
	
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

		
		c = (CardLayout) getContentPane().getLayout();
		
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public ShowCalendar getShowCalendar() {
		return showCalendar;
	}

	public void show(String card) {
		c.show(getContentPane(),  card);
}
}