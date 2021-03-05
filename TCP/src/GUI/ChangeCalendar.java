package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class ChangeCalendar extends JPanel {

	private JTable chooseCalendar;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JButton btnChoose;
	private JButton btnBack;
	private JLabel lblChooseCalendar;
	
	
	public ChangeCalendar() {

		setSize(new Dimension(1366, 768));
		setLayout(null);
		
				String[] columnNames2 = { "ID", "Email"};
		
    	model = (DefaultTableModel)chooseCalendar.getModel();
    	model.setColumnIdentifiers(columnNames2);
		chooseCalendar = new JTable();
		chooseCalendar.setBounds(572, 138, 327, 288);
		add(chooseCalendar);
		
		scrollPane = new JScrollPane(chooseCalendar);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				null));
		scrollPane.setBounds(450, 171, 500, 376);

		add(scrollPane);
		
		lblChooseCalendar = new JLabel("Choose Calendar");
		lblChooseCalendar.setBounds(639, 84, 131, 16);
		add(lblChooseCalendar);
		
		btnChoose = new JButton("Choose");
		btnChoose.setBounds(628, 612, 117, 29);
		add(btnChoose);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(628, 669, 117, 29);
		add(btnBack);
		
	}
	public void addActionListener(ActionListener l) {
		btnChoose.addActionListener(l);
		btnBack.addActionListener(l);
	}
}
