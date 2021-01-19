package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

public class CalendarPanel extends JPanel {
	private final JTextField txtKalenderHer;
	private final JTextField txtEvtQotdHer;
	private final JButton btnDelKalender = new JButton("Del kalender");
	private final JButton btnTilfjNote = new JButton("Tilf\u00F8j note");
	private final JButton btnOpretKalender = new JButton("Opret kalender");
	private final JButton btnSkiftKalender = new JButton("Skift kalender");
	private final JButton btnOpretEvent = new JButton("Opret event");
	private final JButton btnLogud = new JButton("Logud");
	private final JLabel lblKalender = new JLabel("Kalender");
	
	public CalendarPanel() {

		setSize(Container.SIZE);
		setLayout(null);
		
		
		btnDelKalender.setBounds(489, 175, 117, 29);
		btnDelKalender.setSize(Container.BUTTON);
		add(btnDelKalender);
		
		
		btnTilfjNote.setBounds(489, 279, 117, 29);
		btnTilfjNote.setSize(Container.BUTTON);
		add(btnTilfjNote);
		
		
		btnOpretKalender.setBounds(489, 123, 117, 29);
		btnOpretKalender.setSize(Container.BUTTON);
		add(btnOpretKalender);
		
		
		btnSkiftKalender.setBounds(489, 71, 117, 29);
		btnSkiftKalender.setSize(Container.BUTTON);
		add(btnSkiftKalender);
		
		
		btnOpretEvent.setBounds(489, 227, 117, 29);
		btnOpretEvent.setSize(Container.BUTTON);
		add(btnOpretEvent);
		
		
		btnLogud.setBounds(489, 331, 117, 29);
		btnLogud.setSize(Container.BUTTON);
		add(btnLogud);
		
		txtKalenderHer = new JTextField();
		txtKalenderHer.setText("Kalender her!!");
		txtKalenderHer.setBounds(48, 69, 429, 302);
		add(txtKalenderHer);
		txtKalenderHer.setColumns(10);
		
		
		lblKalender.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblKalender.setBounds(88, 17, 117, 43);
		add(lblKalender);
		
		txtEvtQotdHer = new JTextField();
		txtEvtQotdHer.setText("evt. QOTD her?");
		txtEvtQotdHer.setBounds(48, 371, 429, 61);
		add(txtEvtQotdHer);
		txtEvtQotdHer.setColumns(10);
	}
	
	
	public JButton getBtnDelKalender(){
		return btnDelKalender;
	}
	public void addActionListener(ActionListener l) {
		btnDelKalender.addActionListener(l);
		btnOpretKalender.addActionListener(l);
		btnSkiftKalender.addActionListener(l);
		btnOpretEvent.addActionListener(l);
		btnLogud.addActionListener(l);
}
}
