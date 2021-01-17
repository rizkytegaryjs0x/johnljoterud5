package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Container extends JFrame {

	
	private JPanel contentPane;
	private LoginPanel loginPanel;
	private CalendarPanel calendarPanel;
	
	


	public final static Dimension SIZE = new Dimension(650,450);
	public final static Dimension FRAMESIZE = new Dimension(670,470);
	public final static Dimension BUTTON = new Dimension(50, 30);
	public final static Dimension MAINBUTTON = new Dimension(225, 70);
	
	
	
	
	public Container() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CBS Calendar");
		setSize(FRAMESIZE);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
