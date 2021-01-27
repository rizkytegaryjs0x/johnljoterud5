package newCalendar;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NewCalendar{
    static JLabel lblWeek, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static int realYear, realWeek, realDay, currentYear, currentWeek;
    private static JTextField txtTekstTilEvents;
    private static JTextField textField_1;
    private static JLabel lblWeatherForecast;
    private static JTextField textField_2;
    private static JLabel lblQotd;
    private static JButton btnLogout;
    private static JButton btnChangeCalendar;
    private static JButton btnShareCalendar;
    private static JButton btnAddCalendar;
    private static JButton btnAddEvent;
    private static JButton btnAddNote;
    
    public static void main (String args[]){
        //Look and feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        //Prepare frame
        frmMain = new JFrame ("Calendar"); //Create frame
        frmMain.setSize(1366, 768); //Set size to 400x400 pixels
        pane = frmMain.getContentPane(); //Get content pane
        pane.setLayout(null); //Apply null layout
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked
        
        //Create controls
        lblWeek = new JLabel ("January");
        btnPrev = new JButton ("<<");
        btnNext = new JButton (">>");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        
        //Add controls to pane
        pane.add(pnlCalendar);
        pnlCalendar.add(lblWeek);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        
        //Set bounds
        pnlCalendar.setBounds(6, 6, 1354, 734);
        lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2, 25, 100, 25);
        btnPrev.setBounds(10, 25, 50, 25);
        btnNext.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 183, 1189, 451);
        
        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_WEEK); //Get day
        realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentWeek = realWeek; //Match month and year
        currentYear = realYear;
        
        //Add headers
        String[] headers = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(60);
        cmbYear = new JComboBox();
        cmbYear.setBounds(1063, 25, 136, 32);
        pnlCalendar.add(cmbYear);
        lblYear = new JLabel ("Change year:");
        lblYear.setBounds(931, 21, 108, 32);
        pnlCalendar.add(lblYear);
        
        btnChangeCalendar = new JButton("Change calendar");
        btnChangeCalendar.setBounds(1218, 564, 117, 29);
        pnlCalendar.add(btnChangeCalendar);
        
        btnShareCalendar = new JButton("Share calendar");
        btnShareCalendar.setBounds(1218, 523, 117, 29);
        pnlCalendar.add(btnShareCalendar);
        
        btnAddCalendar = new JButton("Add calendar");
        btnAddCalendar.setBounds(1218, 482, 117, 29);
        pnlCalendar.add(btnAddCalendar);
        
        btnAddEvent = new JButton("Add event");
        btnAddEvent.setBounds(1218, 441, 117, 29);
        pnlCalendar.add(btnAddEvent);
        
        btnAddNote = new JButton("Add note");
        btnAddNote.setBounds(1218, 400, 117, 29);
        pnlCalendar.add(btnAddNote);
        
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(1218, 605, 117, 29);
        pnlCalendar.add(btnLogout);
        
        txtTekstTilEvents = new JTextField();
        txtTekstTilEvents.setBounds(6, 646, 1197, 82);
        pnlCalendar.add(txtTekstTilEvents);
        txtTekstTilEvents.setText("Tekst til events!");
        txtTekstTilEvents.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(83, 89, 400, 82);
        pnlCalendar.add(textField_2);
        textField_2.setColumns(10);
        
        lblQotd = new JLabel("QOTD");
        lblQotd.setBounds(23, 122, 61, 16);
        pnlCalendar.add(lblQotd);
        
        textField_1 = new JTextField();
        textField_1.setBounds(799, 89, 400, 82);
        pnlCalendar.add(textField_1);
        textField_1.setColumns(10);
        
        lblWeatherForecast = new JLabel("Weather Forecast");
        lblWeatherForecast.setBounds(680, 122, 124, 16);
        pnlCalendar.add(lblWeatherForecast);
        cmbYear.addActionListener(new cmbYear_Action());
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(14);
        
        //Populate table
        for (int i=realYear-100; i<=realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (realWeek, realYear); //Refresh calendar
        
        
        
    }
    
    public static void refreshCalendar(int week, int year){
        //Variables
        String[] weeks =  {"Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11", "Week 12", "Week 13", "Week 14", "Week 15", "Week 16", "Week 17", "Week 18", "Week 19", "Week 20", "Week 21", "Week 22", "Week 23", "Week 24", "Week 25", "Week 26", "Week 27", "Week 28", "Week 29", "Week 30", "Week 31", "Week 32", "Week 33", "Week 34", "Week 35", "Week 36", "Week 37", "Week 38", "Week 39", "Week 40", "Week 41", "Week 42", "Week 43", "Week 44", "Week 45", "Week 46", "Week 47", "Week 48", "Week 49", "Week 50", "Week 51", "Week 52"};
//        int nod, sow; //Number Of Days, Start Of Weeks
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (week == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
        if (week == 51 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
        lblWeek.setText(weeks[week]); //Refresh the month label (at the top)
        lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //Clear table
        for (int i=0; i<14; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
//        //Get first day of month and number of days
//        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
//        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
//        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
//        
//        //Draw calendar
//        for (int i=1; i<=nod; i++){
//            int row = new Integer((i+som-2)/7);
//            int column  =  (i+som-2)%7;
//            mtblCalendar.setValueAt(i, row, column);
//        }
//        
//            
          
    
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
  
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 5 || column == 6){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(220, 255, 220));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentWeek == realWeek && currentYear == realYear){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 0){ //Back one year
                currentWeek = 51;
                currentYear -= 1;
            }
            else{ //Back one month
                currentWeek -= 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 51){ //Foward one year
                currentWeek = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentWeek += 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentWeek, currentYear);
            }
        }
    }
}
