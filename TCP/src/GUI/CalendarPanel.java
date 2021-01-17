package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CalendarPanel extends JPanel {
	private JTextField txtKalenderHer;

	
	public CalendarPanel() {

		setSize(Container.SIZE);
		setLayout(null);
		
		JButton btnDelKalender = new JButton("Del kalender");
		btnDelKalender.setBounds(500, 195, 117, 29);
		add(btnDelKalender);
		
		JButton btnTilfjNote = new JButton("Tilf\u00F8j note");
		btnTilfjNote.setBounds(500, 275, 117, 29);
		add(btnTilfjNote);
		
		JButton btnOpretKalender = new JButton("Opret kalender");
		btnOpretKalender.setBounds(500, 154, 117, 29);
		add(btnOpretKalender);
		
		JButton btnSkiftKalender = new JButton("Skift kalender");
		btnSkiftKalender.setBounds(500, 117, 117, 29);
		add(btnSkiftKalender);
		
		JButton btnOpretEvent = new JButton("Opret event");
		btnOpretEvent.setBounds(500, 234, 117, 29);
		add(btnOpretEvent);
		
		JButton btnLogud = new JButton("Logud");
		btnLogud.setBounds(500, 316, 117, 29);
		add(btnLogud);
		
		txtKalenderHer = new JTextField();
		txtKalenderHer.setText("Kalender her!!");
		txtKalenderHer.setBounds(48, 69, 387, 302);
		add(txtKalenderHer);
		txtKalenderHer.setColumns(10);
		
	}

}
