package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class ShareCalendar extends JPanel {
	private JTable chooseCalendar;
	private JTable chooseUser;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public ShareCalendar() {

		setSize(new Dimension(1366, 768));
		setLayout(null);
		

		
		JLabel lblShareCalendar = new JLabel("Share Calendar");
		lblShareCalendar.setBounds(669, 58, 116, 16);
		add(lblShareCalendar);
		
		
				String[] columnNames = { "ID", "Name"};
		
    	model = (DefaultTableModel)chooseCalendar.getModel();
    	model.setColumnIdentifiers(columnNames);
		chooseCalendar = new JTable();
		chooseCalendar.setBounds(103, 138, 327, 288);
		add(chooseCalendar);
		
				String[] columnNames2 = { "ID", "Email"};
		
    	model = (DefaultTableModel)chooseUser.getModel();
    	model.setColumnIdentifiers(columnNames2);
		chooseUser = new JTable();
		chooseUser.setBounds(572, 138, 327, 288);
		add(chooseUser);
		
		scrollPane = new JScrollPane(chooseCalendar);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				null));
		scrollPane.setBounds(149, 171, 500, 376);

		add(scrollPane);
		
		scrollPane = new JScrollPane(chooseUser);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				null));
		scrollPane.setBounds(800, 171, 500, 376);

		add(scrollPane);
		
		JButton btnChoosecalendar = new JButton("ChooseCalendar");
		btnChoosecalendar.setBounds(341, 600, 117, 29);
		add(btnChoosecalendar);
		
		JButton btnChooseuser = new JButton("ChooseUser");
		btnChooseuser.setBounds(992, 600, 117, 29);
		add(btnChooseuser);
		
		JButton btnShare = new JButton("Share");
		btnShare.setBounds(669, 635, 117, 29);
		add(btnShare);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(669, 688, 117, 29);
		add(btnBack);
		
		
	}
}
