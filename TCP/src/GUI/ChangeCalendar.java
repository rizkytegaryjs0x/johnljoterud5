package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class ChangeCalendar extends JPanel {

	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JButton btnChoose;
	private JButton btnBack;
	private JLabel lblChooseCalendar;
	private int row;
	private String name;

	public ChangeCalendar() {

		setSize(new Dimension(1366, 768));
		setLayout(null);

		String[] columnNames = { "CalendarID","Name" };
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				row = table.getSelectedRow();
				if(row != -1){
				name = table.getValueAt(row, 0).toString();
				setName(name);
				

				}
			}
		});

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
		lblChooseCalendar.setForeground(new Color(0, 0, 0));
		lblChooseCalendar.setFont(new Font("Arial", Font.BOLD, 78));
		lblChooseCalendar.setBounds(381, 90, 680, 91);
		add(lblChooseCalendar);

		btnChoose = new JButton("Add note");
		btnChoose.setContentAreaFilled(false);
		btnChoose.setForeground(new Color(0, 0, 0));
		btnChoose.setFont(new Font("Arial", Font.BOLD, 30));
		btnChoose.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnChoose.setBackground(Color.WHITE);
		btnChoose.setBounds(616, 610, 194, 50);
		add(btnChoose);
		
		btnBack = new JButton("Back");
		btnBack.setContentAreaFilled(false);
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Arial", Font.BOLD, 30));
		btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(616, 691, 194, 50);
		add(btnBack);
		

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public DefaultTableModel getModel() {
		return model;
	}


	public void setModel(DefaultTableModel model) {
		this.model = model;
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
