package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

public class CalendarPanel extends JPanel {
	private JTextField txtKalenderHer;
	private JTextField txtEvtQotdHer;

	
	public CalendarPanel() {

		setSize(Container.SIZE);
		setLayout(null);
		
		JButton btnDelKalender = new JButton("Del kalender");
		btnDelKalender.setBounds(489, 175, 117, 29);
		btnDelKalender.setSize(Container.BUTTON);
		add(btnDelKalender);
		
		JButton btnTilfjNote = new JButton("Tilf\u00F8j note");
		btnTilfjNote.setBounds(489, 279, 117, 29);
		btnTilfjNote.setSize(Container.BUTTON);
		add(btnTilfjNote);
		
		JButton btnOpretKalender = new JButton("Opret kalender");
		btnOpretKalender.setBounds(489, 123, 117, 29);
		btnOpretKalender.setSize(Container.BUTTON);
		add(btnOpretKalender);
		
		JButton btnSkiftKalender = new JButton("Skift kalender");
		btnSkiftKalender.setBounds(489, 71, 117, 29);
		btnSkiftKalender.setSize(Container.BUTTON);
		add(btnSkiftKalender);
		
		JButton btnOpretEvent = new JButton("Opret event");
		btnOpretEvent.setBounds(489, 227, 117, 29);
		btnOpretEvent.setSize(Container.BUTTON);
		add(btnOpretEvent);
		
		JButton btnLogud = new JButton("Logud");
		btnLogud.setBounds(489, 331, 117, 29);
		btnLogud.setSize(Container.BUTTON);
		add(btnLogud);
		
		txtKalenderHer = new JTextField();
		txtKalenderHer.setText("Kalender her!!");
		txtKalenderHer.setBounds(48, 69, 429, 302);
		add(txtKalenderHer);
		txtKalenderHer.setColumns(10);
		
		JLabel lblKalender = new JLabel("Kalender");
		lblKalender.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblKalender.setBounds(88, 17, 117, 43);
		add(lblKalender);
		
		txtEvtQotdHer = new JTextField();
		txtEvtQotdHer.setText("evt. QOTD her?");
		txtEvtQotdHer.setBounds(48, 371, 429, 61);
		add(txtEvtQotdHer);
		txtEvtQotdHer.setColumns(10);
		
	}

}
