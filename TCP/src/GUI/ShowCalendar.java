package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import JsonClasses.CalendarInfo;
import JsonClasses.UserEvent;
import Logic.CalendarHandler;
import Logic.CellModel;

public class ShowCalendar extends JPanel {
	private JLabel lblWeek, lblYear;
	private JButton btnPrev, btnNext;
	private JTable tblCalendar;
	private JComboBox cmbYear;
	private DefaultTableModel mtblCalendar; // Table model
	private JScrollPane stblCalendar; // The scrollpane
	private int realYear, realWeek, realDay, currentYear, currentWeek,
			currentDay;
	private JTextField txtTekstTilEvents;
	private JTextField txtForecast;
	private JLabel lblWeatherForecast;
	private JTextField txtQOTD;
	private JLabel lblQotd;
	private JButton btnLogout;
	private JButton btnChangeCalendar;
	private JButton btnShareCalendar;
	private JButton btnAddCalendar;
	private JButton btnAddEvent;
	private JButton btnAddNote;

	private CalendarHandler ch = new CalendarHandler();
	GregorianCalendar cal = new GregorianCalendar();
	ArrayList<String> dateArray = new ArrayList<String>();

	public ShowCalendar() {
		setLayout(null);// Create frame
		setSize(1366, 768); // Set size to 400x400 pixels

		// Create controls
		lblWeek = new JLabel("January");
		btnPrev = new JButton("<<");
		btnNext = new JButton(">>");
		mtblCalendar = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		tblCalendar = new JTable(mtblCalendar);
		tblCalendar.setFocusable(false);
		tblCalendar.setRowSelectionAllowed(false);
		stblCalendar = new JScrollPane(tblCalendar);
		tblCalendar.addMouseListener(new MouseAdapter() {
		       @Override
		       public void mouseClicked(MouseEvent evt) {
		          
		           int row = tblCalendar.getSelectedRow();
		           int col = tblCalendar.getSelectedColumn();

		           tblCalendar.getModel().getValueAt(row, col);
		           System.out.println("row: " + row + "col: "+col);
				
			}
		});

		// Set border
		setBorder(BorderFactory.createTitledBorder("Calendar"));
		setBounds(6, 6, 1354, 734);
		// Register action listeners

		// Add controls to pane

		add(lblWeek);
		add(btnPrev);
		add(btnNext);
		add(stblCalendar);

		// Set bounds

		lblWeek.setBounds(160 - lblWeek.getPreferredSize().width / 2, 25, 100,
				25);
		btnPrev.setBounds(10, 25, 50, 25);
		btnNext.setBounds(260, 25, 50, 25);

		stblCalendar.setBounds(10, 183, 1189, 451);

		// Make frame visible
		setVisible(true);

		// Get real month/year
		realDay = cal.get(GregorianCalendar.DAY_OF_WEEK); // Get day
		realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR); // Get month
		realYear = cal.get(GregorianCalendar.YEAR); // Get year
		cal.setFirstDayOfWeek(GregorianCalendar.MONDAY);
		cal.set(GregorianCalendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		
		currentDay = realDay;
		currentWeek = realWeek; // Match month and year
		currentYear = realYear;


		// No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		// Single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Set row/column count
		tblCalendar.setRowHeight(60);
		cmbYear = new JComboBox();
		cmbYear.setBounds(1063, 25, 136, 32);
		add(cmbYear);
		lblYear = new JLabel("Change year:");
		lblYear.setBounds(931, 21, 108, 32);
		add(lblYear);

		btnChangeCalendar = new JButton("Change calendar");
		btnChangeCalendar.setBounds(1218, 564, 117, 29);
		add(btnChangeCalendar);

		btnShareCalendar = new JButton("Share calendar");
		btnShareCalendar.setBounds(1218, 523, 117, 29);
		add(btnShareCalendar);

		btnAddCalendar = new JButton("Add calendar");
		btnAddCalendar.setBounds(1218, 482, 117, 29);
		add(btnAddCalendar);

		btnAddEvent = new JButton("Add event");
		btnAddEvent.setBounds(1218, 441, 117, 29);
		add(btnAddEvent);

		btnAddNote = new JButton("Add note");
		btnAddNote.setBounds(1218, 400, 117, 29);
		add(btnAddNote);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1218, 605, 117, 29);
		add(btnLogout);

		txtTekstTilEvents = new JTextField();
		txtTekstTilEvents.setBounds(6, 646, 1197, 82);
		add(txtTekstTilEvents);
		txtTekstTilEvents.setText("Tekst til events!");
		txtTekstTilEvents.setColumns(10);

		txtQOTD = new JTextField();
		txtQOTD.setBounds(83, 89, 400, 82);
		add(txtQOTD);
		txtQOTD.setColumns(10);

		lblQotd = new JLabel("QOTD");
		lblQotd.setBounds(23, 122, 61, 16);
		add(lblQotd);

		txtForecast = new JTextField();
		txtForecast.setBounds(799, 89, 400, 82);
		add(txtForecast);
		txtForecast.setColumns(10);

		lblWeatherForecast = new JLabel("Weather Forecast");
		lblWeatherForecast.setBounds(680, 122, 124, 16);
		add(lblWeatherForecast);
		
		
		
		
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(15);

		

		// Populate table
		for (int i = realYear - 5; i <= realYear + 25; i++) {
			cmbYear.addItem(String.valueOf(i));
		}

		// Refresh calendar

		refreshCalendar(realWeek, realYear); // Refresh calendar

	}

	public void addActionListener(ActionListener l) {

		btnAddCalendar.addActionListener(l);
		btnAddEvent.addActionListener(l);
		btnAddNote.addActionListener(l);
		btnChangeCalendar.addActionListener(l);
		btnLogout.addActionListener(l);
		btnShareCalendar.addActionListener(l);
		btnPrev.addActionListener(l);
		btnNext.addActionListener(l);
		cmbYear.addActionListener(l);

	}
	
	

	public JTextField getTxtForecast() {
		return txtForecast;
	}

	public void setTxtForecast(JTextField txtForecast) {
		this.txtForecast = txtForecast;
	}

	public JTextField getTxtQOTD() {
		return txtQOTD;
	}

	public void setTxtQOTD(JTextField txtQOTD) {
		this.txtQOTD = txtQOTD;
	}

	public JButton getBtnPrev() {
		return btnPrev;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnChangeCalendar() {
		return btnChangeCalendar;
	}

	public JButton getBtnShareCalendar() {
		return btnShareCalendar;
	}

	public JButton getBtnAddCalendar() {
		return btnAddCalendar;
	}

	public JButton getBtnAddEvent() {
		return btnAddEvent;
	}

	public JButton getBtnAddNote() {
		return btnAddNote;
	}

	public void refreshCalendar(int week, int year) {
		// Variables

		String[] weeks = { "0", "Week 1", "Week 2", "Week 3", "Week 4",
				"Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10",
				"Week 11", "Week 12", "Week 13", "Week 14", "Week 15",
				"Week 16", "Week 17", "Week 18", "Week 19", "Week 20",
				"Week 21", "Week 22", "Week 23", "Week 24", "Week 25",
				"Week 26", "Week 27", "Week 28", "Week 29", "Week 30",
				"Week 31", "Week 32", "Week 33", "Week 34", "Week 35",
				"Week 36", "Week 37", "Week 38", "Week 39", "Week 40",
				"Week 41", "Week 42", "Week 43", "Week 44", "Week 45",
				"Week 46", "Week 47", "Week 48", "Week 49", "Week 50",
				"Week 51", "Week 52" };
		// int nod, sow; //Number Of Days, Start Of Weeks

		// Allow/disallow buttons
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (week == 0 && year <= realYear - 10) {
			btnPrev.setEnabled(false);
		} // Too early
		if (week == 51 && year >= realYear + 100) {
			btnNext.setEnabled(false);
		} // Too late
		
		lblWeek.setText(weeks[week]); // Refresh the month label (at the top)
		lblWeek.setBounds(160 - lblWeek.getPreferredSize().width / 2, 25, 180,
				25); // Re-align label with calendar
		cmbYear.setSelectedItem(String.valueOf(year)); // Select the correct
		// year in the combo box

		// Clear table
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 7; j++) {
				mtblCalendar.setValueAt(null, i, j);
				
			}
		}

		// Add headers

		// All headers

		String[] headers = { "", "Mon ", "Tue ", "Wed ", "Thu ", "Fri ",
				"Sat ", "Sun " };
		dateArray = ch.YearAndWeekDates(week, year);
		for (int i = 0; i < 7; i++) {

			 tblCalendar.getColumnModel().getColumn(i).setHeaderValue(headers[i+1]);
			tblCalendar.setValueAt(dateArray.get(i), 0, i);
		}

		ArrayList <String> weekDates = ch.YearAndWeekDates(week, year);
		CalendarInfo we = ch.getWeekEvents(week, year);
		
	
		for (String date : weekDates){
			ArrayList <UserEvent> de = new ArrayList <UserEvent>();
			System.out.printf("Finding events for date %s...\n", date);
			for(UserEvent event : we.getCalendars()){			
							
				if(event.getStart().contains(date)){
					System.out.printf("Event with start %s added to date %s.\n", event.getStart(), date);
					de.add(event);
				}
			}
			int column = ch.getArrayWeekDay(date);
			System.out.printf("populating table for weekday %d...", ch.getWeekDay(date));
			System.out.println(de.size());
			PopulateTable(de, column);
			
		}
		
		

				 tblCalendar.setDefaultRenderer(Object.class, new MultiLineCellRenderer()); 
	}

//	private class btnPrev_Action implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			if (currentWeek == 0) { // Back one year
//				currentWeek = 52;
//				currentYear -= 1;
//			} else { // Back one month
//				currentWeek -= 1;
//			}
//			refreshCalendar(currentWeek, currentYear);
//		}
//	}
//
//	private class btnNext_Action implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//
//			if (currentWeek == 52) { // Foward one year
//				currentWeek = 1;
//				currentYear += 1;
//			} else { // Foward one month
//				currentWeek += 1;
//
//			}
//			refreshCalendar(currentWeek, currentYear);
//			
//		}
//	}
//
//	private class cmbYear_Action implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			if (cmbYear.getSelectedItem() != null) {
//				String b = cmbYear.getSelectedItem().toString();
//				currentYear = Integer.parseInt(b);
//				refreshCalendar(currentWeek, currentYear);
//			}
//		}cfrcfr
//	}
	 public void PopulateTable(ArrayList<UserEvent> dayEvents, int dayOfWeek){

		 if(!dayEvents.isEmpty()){
			 SimpleDateFormat sdf = new SimpleDateFormat("hh");
			 CellModel cm = new CellModel();
			 ArrayList <CellModel> alcm = new ArrayList <CellModel>();
			 
			 for(UserEvent de : dayEvents){
				 String hours = de.getStart().substring(de.getStart().indexOf(" ") + 1, de.getStart().indexOf(":"));

				 cm.setRowNumber(Integer.valueOf(hours) - 7);
				 cm.setText(
				 		de.getText()+ "\n" 
						 + de.getStart().substring(de.getStart().indexOf(" ") + 1, de.getStart().length()) + 
						 " to " + de.getEnd().substring(de.getStart().indexOf(" ") + 1, de.getEnd().length()));

				 alcm.add(cm);

				 
			 }
			 
			 
			 String newCell;
			 for (CellModel cmTemp : alcm){
				 
				 Object value = tblCalendar.getValueAt(cmTemp.getRowNumber(),dayOfWeek);
				 if(value != null){
						newCell = tblCalendar.getValueAt(cmTemp.getRowNumber(), dayOfWeek).toString().concat(cmTemp.getText());
					 	tblCalendar.setValueAt(newCell, cmTemp.getRowNumber(), dayOfWeek);
				 }
				 else{
						
						tblCalendar.setValueAt( cmTemp.getText(), cmTemp.getRowNumber(), dayOfWeek);
				 }
			 }
			 
		 }
	 }

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getCurrentWeek() {
		return currentWeek;
	}

	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}

	public JComboBox getCmbYear() {
		return cmbYear;
	}

	public void setCmbYear(JComboBox cmbYear) {
		this.cmbYear = cmbYear;
	}

	public CalendarHandler getCh() {
		return ch;
	}

	public void setCh(CalendarHandler ch) {
		this.ch = ch;
	}
	  
	class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {  
	  
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MultiLineCellRenderer() {  
	        setLineWrap(true);  
	        setWrapStyleWord(true);  
	        setOpaque(true);  
	        setEditable(false); //this line doesn't seem to be doing anything  
	    }  
	  
	    public Component getTableCellRendererComponent(JTable table, Object value,  
	        boolean isSelected, boolean hasFocus, int row, int column) {
	    	
	    	if (column == 5 || column == 6) { // Week-end
				table.setBackground(new Color(255, 220, 220));
			} else { // Week
				table.setBackground(new Color(220, 255, 220));
			}
			if(row == 0){
				table.setBackground(new Color(100, 255, 210));
			}
	        if (isSelected) {  
	            setForeground(table.getSelectionForeground());  
	            setBackground(table.getSelectionBackground());  
	        }  
	        else {  
	            setForeground(table.getForeground());  
	            setBackground(table.getBackground());  
	        }  
	        setFont(table.getFont());  
	        if (hasFocus) {  
	            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));  
	            if (table.isCellEditable(row, column)) {  
	                setForeground(UIManager.getColor("Table.focusCellForeground"));  
	                setBackground(UIManager.getColor("Table.focusCellBackground"));  
	            }  
	        }  
	        else {  
	            setBorder(new EmptyBorder(1, 2, 1, 2));  
	        }  
	        setText((value == null) ? "" : value.toString());  
	        
	        return this;  
	    }  
	}  
	
	
}
