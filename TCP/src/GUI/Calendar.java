package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import GUI.ShowCalendar.tblCalendarRenderer;

public class Calendar extends JPanel{
	
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JTable table;

	public Calendar(){
		String[] columnNames = { "EventID", "Type", "Location", "CreatedBy",
				"Start", "End", "Name", "Text","CalendarID", "Active"};


		model = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		model.setColumnCount(7);
		model.setRowCount(14);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		table.getParent().setBackground(table.getBackground()); 
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);

		// Single cell selection
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Set row/column count
		table.setRowHeight(60);
		table.setDefaultRenderer(table.getColumnClass(0),
				new tableCalendarRenderer());
	}
	
	public void updateTable(){
		String[] weeks = { "Week 1", "Week 2", "Week 3", "Week 4", "Week 5",
				"Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11",
				"Week 12", "Week 13", "Week 14", "Week 15", "Week 16",
				"Week 17", "Week 18", "Week 19", "Week 20", "Week 21",
				"Week 22", "Week 23", "Week 24", "Week 25", "Week 26",
				"Week 27", "Week 28", "Week 29", "Week 30", "Week 31",
				"Week 32", "Week 33", "Week 34", "Week 35", "Week 36",
				"Week 37", "Week 38", "Week 39", "Week 40", "Week 41",
				"Week 42", "Week 43", "Week 44", "Week 45", "Week 46",
				"Week 47", "Week 48", "Week 49", "Week 50", "Week 51",
				"Week 52" };
		
		
	}
	
	
	private class tableCalendarRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean selected, boolean focused, int row,
				int column) {
			super.getTableCellRendererComponent(table, value, selected,
					focused, row, column);
			if (column == 5 || column == 6) { // Week-end
				setBackground(new Color(255, 220, 220));
			} else { // Week
				setBackground(new Color(220, 255, 220));
			}
//			if (value != null) {
//					&& currentWeek == realWeek && currentYear == realYear) { // Today
//					setBackground(new Color(220, 220, 255));
//						if (Integer.parseInt(value.toString()) == realDay
//			}
//			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}
}
