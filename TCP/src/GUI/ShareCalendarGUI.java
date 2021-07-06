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
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class ShareCalendarGUI extends JPanel {
	private JTable tableCalendar;
	private JTable tableUser;
	private DefaultTableModel modelCalendar;
	private DefaultTableModel modelUser;
	private JScrollPane scrollPaneCalendar;
	private JScrollPane scrollPaneUser;
	private JButton btnShare;
	private JButton btnBack;
	private JLabel lblShareCalendar;
	private JLabel lblChooseACalendar;
	private JLabel lblChooseAUser;
	private JTextField textFieldChooseCalendar;
	private JTextField textFieldChooseUser;
	private int row;

	/**
	 * Create the panel.
	 */
	public ShareCalendarGUI() {

		setSize(new Dimension(1366, 768));
		setLayout(null);
				String[] columnNames = { "Email", "Active"};
		
				String[] columnNames2 = { "CalendarID", "Name"};
			
				
				
				tableUser = new JTable();
				modelUser = (DefaultTableModel) tableUser.getModel();
				modelUser.setColumnIdentifiers(columnNames);
				tableUser.setSurrendersFocusOnKeystroke(true);
				tableUser.setPreferredScrollableViewportSize(new Dimension(500, 100));
				tableUser.setFillsViewportHeight(true);
				tableUser.setRowSelectionAllowed(true);
				tableUser.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						row = tableUser.getSelectedRow();
						if(row != -1){
						
						String email = tableUser.getValueAt(row, 0).toString();
						
						textFieldChooseUser.setText(email);

						}
					}
				});


				// Create the scroll pane and add the table to it.
				scrollPaneUser = new JScrollPane(tableUser);
				scrollPaneUser.setBorder(new CompoundBorder(new BevelBorder(
						BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
								255), new Color(0, 0, 205), new Color(255, 255, 255)),
						new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
				scrollPaneUser.setViewportBorder(new CompoundBorder(new BevelBorder(
						BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
								255), new Color(0, 0, 205), new Color(255, 255, 255)),
						null));
				scrollPaneUser.setBounds(186, 241, 432, 315);

				// Add the scroll pane to this panel.
				add(scrollPaneUser);
				
				
				tableCalendar = new JTable();
				modelCalendar = (DefaultTableModel) tableCalendar.getModel();
				modelCalendar.setColumnIdentifiers(columnNames2);
				tableCalendar.setSurrendersFocusOnKeystroke(true);
				tableCalendar.setPreferredScrollableViewportSize(new Dimension(500, 100));
				tableCalendar.setFillsViewportHeight(true);
				tableCalendar.setRowSelectionAllowed(true);
				tableCalendar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						row = tableCalendar.getSelectedRow();
						if(row != -1){
						
						String calendarID = tableCalendar.getValueAt(row, 0).toString();
						
						textFieldChooseCalendar.setText(calendarID);

						}
					}
				});



				// Create the scroll pane and add the table to it.
				scrollPaneCalendar = new JScrollPane(tableCalendar);
				scrollPaneCalendar.setBorder(new CompoundBorder(new BevelBorder(
						BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
								255), new Color(0, 0, 205), new Color(255, 255, 255)),
						new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
				scrollPaneCalendar.setViewportBorder(new CompoundBorder(new BevelBorder(
						BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
								255), new Color(0, 0, 205), new Color(255, 255, 255)),
						null));
				scrollPaneCalendar.setBounds(764, 241, 432, 315);

				// Add the scroll pane to this panel.
				add(scrollPaneCalendar);
		
		btnShare = new JButton("Share");
		btnShare.setForeground(new Color (0, 0, 0));
		btnShare.setFont(new Font("Arial", Font.BOLD, 30));
		btnShare.setContentAreaFilled(false);
		btnShare.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnShare.setBounds(811, 603, 194, 50);
		add(btnShare);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color (0, 0, 0));
		btnBack.setFont(new Font("Arial", Font.BOLD, 30));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnBack.setBounds(811, 666, 194, 50);
		add(btnBack);
		
		lblShareCalendar = new JLabel("Share Calendar");
		lblShareCalendar.setForeground(new Color (0, 0, 0));
		lblShareCalendar.setFont(new Font("Arial", Font.BOLD, 78));
		lblShareCalendar.setBounds(393, 83, 667, 90);
		add(lblShareCalendar);
		
		lblChooseACalendar = new JLabel("Choose a calendar:");
		lblChooseACalendar.setForeground(Color.BLACK);
		lblChooseACalendar.setFont(new Font("Arial", Font.BOLD, 25));
		lblChooseACalendar.setBounds(294, 593, 257, 60);
		add(lblChooseACalendar);
		
		lblChooseAUser = new JLabel("Choose a user to share with:");
		lblChooseAUser.setForeground(Color.BLACK);
		lblChooseAUser.setFont(new Font("Arial", Font.BOLD, 25));
		lblChooseAUser.setBounds(186, 656, 349, 60);
		add(lblChooseAUser);
		
		textFieldChooseCalendar = new JTextField();
		textFieldChooseCalendar.setBounds(563, 608, 210, 39);
		add(textFieldChooseCalendar);
		textFieldChooseCalendar.setColumns(10);
		
		textFieldChooseUser = new JTextField();
		textFieldChooseUser.setColumns(10);
		textFieldChooseUser.setBounds(563, 661, 210, 39);
		add(textFieldChooseUser);
		
		
	}
	public void addActionListener(ActionListener l) {
	
		btnShare.addActionListener(l);
		btnBack.addActionListener(l);
	}
	
	
	public JTextField getTextFieldChooseCalendar() {
		return textFieldChooseCalendar;
	}
	public JTextField getTextFieldChooseUser() {
		return textFieldChooseUser;
	}
	public JTable getTableCalendar() {
		return tableCalendar;
	}
	public void setTableCalendar(JTable tableCalendar) {
		this.tableCalendar = tableCalendar;
	}
	public JTable getTableUser() {
		return tableUser;
	}
	public void setTableUser(JTable tableUser) {
		this.tableUser = tableUser;
	}
	public DefaultTableModel getModelCalendar() {
		return modelCalendar;
	}
	public void setModelCalendar(DefaultTableModel modelCalendar) {
		this.modelCalendar = modelCalendar;
	}
	public DefaultTableModel getModelUser() {
		return modelUser;
	}
	public void setModelUser(DefaultTableModel modelUser) {
		this.modelUser = modelUser;
	}

	public JButton getBtnShare() {
		return btnShare;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	
}