package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class ChangeCalendar extends JPanel {

	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JButton btnChoose;
	private JButton btnBack;
	private JLabel lblChooseCalendar;

	public ChangeCalendar() {

		setSize(new Dimension(1366, 768));
		setLayout(null);

		String[] columnNames = { "ID", "Email" };
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		// Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				null));
		scrollPane.setBounds(425, 240, 553, 315);

		// Add the scroll pane to this panel.
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
	public JButton getBtnChoose() {
		return btnChoose;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	
}
