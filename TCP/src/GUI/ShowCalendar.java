package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tcpClasses.TCPClient;
import JsonClasses.CalendarInfo;
import JsonClasses.CreateNote;
import JsonClasses.DeleteEvent;
import JsonClasses.GetNotes;
import JsonClasses.UserEvent;
import Logic.CalendarHandler;
import Logic.CellModel;

import javax.swing.SwingConstants;

public class ShowCalendar extends JPanel {
	private JLabel lblWeek;
	private JButton btnPrev, btnNext;
	private JTable tblCalendar;
	
	private DefaultTableModel mtblCalendar; // Table model
	private JScrollPane stblCalendar; // The scrollpane
	private int realYear, realWeek, realDay, currentYear, currentWeek;
	private JLabel jLabelTekstTilEvents;
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
	private JButton btnDeleteEvent;
	private int selectedRow;
	private int selectedColumn;

	private CalendarHandler ch = new CalendarHandler();
	GregorianCalendar cal = new GregorianCalendar();
	ArrayList<String> dateArray = new ArrayList<String>();
	CalendarInfo weekEvents = new CalendarInfo();
	GetNotes weekNotes = new GetNotes();
	private JButton btnDeleteNote;



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
		    	   if(selectedRow != -1 && selectedColumn != -1){ 
		           selectedRow = tblCalendar.getSelectedRow();
		           selectedColumn = tblCalendar.getSelectedColumn();
		           
		           if(tblCalendar.getValueAt(selectedRow, selectedColumn) != null){
		           String [] celldates = ch.getCellDate(selectedColumn, selectedRow, currentYear, currentWeek);
		           String dateCheck = String.format("%s-%s-%s %s", celldates[0], celldates[1], celldates[2], celldates[3]);
		           
		           System.out.println("DateCheckString: " + dateCheck);
		           
		           ArrayList<CreateNote> notes = new ArrayList<CreateNote>();
		           ArrayList<UserEvent> array = new ArrayList<UserEvent>();
		           array = weekEvents.getCalendars();
	        	   
        		   notes = weekNotes.getNotes();
					   
	        	   String noteText = "<html>";
	        	   for (UserEvent ue : array){
	        		   if(ue.getStart().contains(dateCheck)){
	        			   for(CreateNote note : notes){
	        				   System.out.println("Note EventID: " + note.getEventID());
	        				   System.out.println("UE eventID: " + String.valueOf(ue.getEventid()));
	        				   if(note.getEventID() != null && String.valueOf(ue.getEventid()) != null && note.getEventID().equals(String.valueOf(ue.getEventid()))){
	        					   noteText += note.getText() + "- by: " + note.getCreatedBy() + "<br>";
	        				   }
	        			   }
	        		   }
	        	   }
	        	   noteText += "</html>";
	        	   System.out.println(noteText);
	        	   jLabelTekstTilEvents.setText(noteText);
//			        	   refreshCalendar(currentWeek, currentYear, 0);
			           }	        	
			}
		}});

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

		btnChangeCalendar = new JButton("Change Calendar");
		btnChangeCalendar.setContentAreaFilled(false);
		btnChangeCalendar.setForeground(new Color(0, 0, 0));
		btnChangeCalendar.setFont(new Font("Arial", Font.BOLD, 14));
		btnChangeCalendar.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnChangeCalendar.setBackground(Color.WHITE);
		btnChangeCalendar.setBounds(1211, 546, 129, 38);
		add(btnChangeCalendar);
		
		
		btnShareCalendar = new JButton("Share Calendar");
		btnShareCalendar.setContentAreaFilled(false);
		btnShareCalendar.setForeground(new Color(0, 0, 0));
		btnShareCalendar.setFont(new Font("Arial", Font.BOLD, 14));
		btnShareCalendar.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnShareCalendar.setBackground(Color.WHITE);
		btnShareCalendar.setBounds(1211, 496, 129, 38);
		add(btnShareCalendar);

		btnAddCalendar = new JButton("Add Calendar");
		btnAddCalendar.setContentAreaFilled(false);
		btnAddCalendar.setForeground(new Color(0, 0, 0));
		btnAddCalendar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddCalendar.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnAddCalendar.setBackground(Color.WHITE);
		btnAddCalendar.setBounds(1211, 246, 129, 38);
		add(btnAddCalendar);

		btnAddEvent = new JButton("Add Event");
		btnAddEvent.setContentAreaFilled(false);
		btnAddEvent.setForeground(new Color(0, 0, 0));
		btnAddEvent.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddEvent.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnAddEvent.setBackground(Color.WHITE);
		btnAddEvent.setBounds(1211, 296, 129, 38);
		add(btnAddEvent);

		btnAddNote = new JButton("Add Note");
		btnAddNote.setContentAreaFilled(false);
		btnAddNote.setForeground(new Color(0, 0, 0));
		btnAddNote.setFont(new Font("Arial", Font.BOLD, 14));
		btnAddNote.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnAddNote.setBackground(Color.WHITE);
		btnAddNote.setBounds(1213, 346, 129, 38);
		add(btnAddNote);

		btnLogout = new JButton("Logout");
		btnLogout.setContentAreaFilled(false);
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogout.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(1211, 596, 129, 38);
		add(btnLogout);

		jLabelTekstTilEvents = new JLabel("Event Notes!");
		jLabelTekstTilEvents.setBounds(55, 646, 1148, 82);
		add(jLabelTekstTilEvents);

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
		
		btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.setContentAreaFilled(false);
		btnDeleteEvent.setForeground(new Color(0, 0, 0));
		btnDeleteEvent.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeleteEvent.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnDeleteEvent.setBackground(Color.WHITE);
		btnDeleteEvent.setBounds(1211, 396, 129, 38);
		add(btnDeleteEvent);
		
		btnDeleteNote = new JButton("Delete Note");
		btnDeleteNote.setContentAreaFilled(false);
		btnDeleteNote.setForeground(new Color(0, 0, 0));
		btnDeleteNote.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeleteNote.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnDeleteNote.setBackground(Color.WHITE);
		btnDeleteNote.setBounds(1211, 446, 129, 38);
		add(btnDeleteNote);
		
		
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(15);

		



		// Refresh calendar

		refreshCalendar(realWeek, realYear, 0); // Refresh calendar

	}

	public void addActionListener(ActionListener l) {

		btnAddCalendar.addActionListener(l);
		btnAddEvent.addActionListener(l);
		btnAddNote.addActionListener(l);
		btnChangeCalendar.addActionListener(l);
		btnLogout.addActionListener(l);
		btnShareCalendar.addActionListener(l);
		btnDeleteEvent.addActionListener(l);
		btnDeleteNote.addActionListener(l);
		btnPrev.addActionListener(l);
		btnNext.addActionListener(l);


	}
	
	

	public JButton getBtnDeleteEvent() {
		return btnDeleteEvent;
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
	
	public JButton getBtnDeleteNote() {
		return btnDeleteNote;
	}

	public void refreshCalendar(int week, int year, int cId) {
		// Variables

		
		
		
		String[] weeks = { "Week 1", "Week 2", "Week 3", "Week 4",
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
		if (week == 1 && year <= realYear - 10) {
			btnPrev.setEnabled(false);
		} // Too early
		if (week == 51 && year >= realYear + 100) {
			btnNext.setEnabled(false);
		} // Too late
		
		lblWeek.setText(weeks[week-1]); // Refresh the month label (at the top)
		lblWeek.setBounds(160 - lblWeek.getPreferredSize().width / 2, 25, 180,
				25); // Re-align label with calendar

//		 Clear table
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 7; j++) {
				mtblCalendar.setValueAt(null, i, j);
				
			}
		}
		
		

		// All headers

		String[] headers = { "", "Mon ", "Tue ", "Wed ", "Thu ", "Fri ",
				"Sat ", "Sun " };
		dateArray = ch.YearAndWeekDates(week, year);
		for (int i = 0; i < 7; i++) {

			 tblCalendar.getColumnModel().getColumn(i).setHeaderValue(headers[i+1]);
			tblCalendar.setValueAt(dateArray.get(i), 0, i);
		}

		ArrayList <String> weekDates = ch.YearAndWeekDates(week, year);
		CalendarInfo we = ch.getWeekEvents(week, year, cId);
		setWeekEvents(we);
		setWeekNotes(ch.getNotes(we));
	
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

	 public void PopulateTable(ArrayList<UserEvent> dayEvents, int dayOfWeek){

		 if(!dayEvents.isEmpty()){
			 SimpleDateFormat sdf = new SimpleDateFormat("hh");

			 ArrayList <CellModel> alcm = new ArrayList <CellModel>();
			 
			 for(UserEvent de : dayEvents){
				 CellModel cm = new CellModel();
				 String hours = de.getStart().substring(de.getStart().indexOf(" ") + 1, de.getStart().indexOf(":"));

				 cm.setRowNumber(Integer.valueOf(hours) - 7);
				 cm.setText(
				 		de.getText()+ "\n" 
						 + de.getStart().substring(de.getStart().indexOf(" ") + 1, de.getStart().length()) + 
						 " to " + de.getEnd().substring(de.getStart().indexOf(" ") + 1, de.getEnd().length()) + "\n");

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

	public DefaultTableModel getMtblCalendar() {
		return mtblCalendar;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getSelectedColumn() {
		return selectedColumn;
	}

	public void setSelectedColumn(int selectedColumn) {
		this.selectedColumn = selectedColumn;
	}

	public CalendarInfo getWeekEvents() {
		return weekEvents;
	}

	public void setWeekEvents(CalendarInfo weekEvents) {
		this.weekEvents = weekEvents;
	}

	public GetNotes getWeekNotes() {
		return weekNotes;
	}

	public void setWeekNotes(GetNotes weekNotes) {
		this.weekNotes = weekNotes;
	}
	
}
