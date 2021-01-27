package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;







import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import bizcal.common.Bundle;
import javax.swing.JSplitPane;

public class CalendarPanel extends JPanel {
	private JButton btnCalendar;
	private JButton btnAddNote;
	private JButton btnAddCalendar;
	private JButton btnChangeCalendar;
	private JButton btnAddEvent;
	private JButton btnLogOut;
	private JLabel lblCalendar;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	
	public static void main(String[]args){
	
	}
	
	
	
	public CalendarPanel() {

		setSize(new Dimension(1366, 768));
		

		String[] columnNames = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

		for (int i=0; i<7; i++){

            model.addColumn(columnNames[i]);

        }
		
		table = new JTable();
    	model = (DefaultTableModel)table.getModel();
    	model.setColumnIdentifiers(columnNames);
    	setLayout(null);
		
    	table.setSurrendersFocusOnKeystroke(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);

		// Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(80, 100, 1000, 600);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				null));

		// Add the scroll pane to this panel.
		add(scrollPane);
		

		
		btnCalendar = new JButton("Share calendar");
		btnCalendar.setBounds(1117, 630, 118, 29);
		btnCalendar.setOpaque(true);
		btnCalendar.setForeground(new Color(0, 0, 205));
		btnCalendar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		add(btnCalendar);
		
		
		btnAddNote = new JButton("Add note");
		btnAddNote.setBounds(1117, 507, 118, 29);
		btnAddNote.setOpaque(true);
		btnAddNote.setForeground(new Color(0, 0, 205));
		btnAddNote.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		add(btnAddNote);
		
		btnAddCalendar = new JButton("Add calendar");
		btnAddCalendar.setBounds(1117, 548, 118, 29);
		btnAddCalendar.setOpaque(true);
		btnAddCalendar.setForeground(new Color(0, 0, 205));
		btnAddCalendar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		add(btnAddCalendar);
		
		btnChangeCalendar = new JButton("Change calendar");
		btnChangeCalendar.setBounds(1117, 589, 118, 29);
		btnChangeCalendar.setOpaque(true);
		btnChangeCalendar.setForeground(new Color(0, 0, 205));
		btnChangeCalendar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		add(btnChangeCalendar);
		
		btnAddEvent = new JButton("Add event");
		btnAddEvent.setBounds(1117, 466, 118, 29);
		btnAddEvent.setOpaque(true);
		btnAddEvent.setForeground(new Color(0, 0, 205));
		btnAddEvent.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		add(btnAddEvent);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(1117, 671, 118, 29);
		btnLogOut.setOpaque(true);
		btnLogOut.setForeground(new Color(0, 0, 205));
		btnLogOut.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		add(btnLogOut);
		
		lblCalendar = new JLabel("Calendar");
		lblCalendar.setBounds(88, 17, 117, 43);
		lblCalendar.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		add(lblCalendar);
	
	}
	
	
	
	
	public void addActionListener(ActionListener l) {
		btnCalendar.addActionListener(l);
		btnAddCalendar.addActionListener(l);
		btnChangeCalendar.addActionListener(l);
		btnAddEvent.addActionListener(l);
		btnLogOut.addActionListener(l);
}
}
