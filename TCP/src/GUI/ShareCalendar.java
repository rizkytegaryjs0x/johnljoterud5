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

public class ShareCalendar extends JPanel {
	private JTable tableCalendar;
	private JTable tableUser;
	private DefaultTableModel modelCalendar;
	private DefaultTableModel modelUser;
	private JScrollPane scrollPaneCalendar;
	private JScrollPane scrollPaneUser;
	private JButton btnChooseCalendar;
	private JButton btnChooseUser;
	private JButton btnShare;
	private JButton btnBack;
	private JLabel lblShareCalendar;

	/**
	 * Create the panel.
	 */
	public ShareCalendar() {

		setSize(new Dimension(1366, 768));
		setLayout(null);
		

		

		
		
				String[] columnNames = { "ID", "Name"};
		
				String[] columnNames2 = { "CalendarID", "Name", "Active", "CreatedBy",
						"PrivatePublic","IsCBS" };
			
				
				
				tableUser = new JTable();
				modelUser = (DefaultTableModel) tableUser.getModel();
				modelUser.setColumnIdentifiers(columnNames2);
				tableUser.setSurrendersFocusOnKeystroke(true);
				tableUser.setPreferredScrollableViewportSize(new Dimension(500, 100));
				tableUser.setFillsViewportHeight(true);
				tableUser.setRowSelectionAllowed(true);



				// Create the scroll pane and add the table to it.
				scrollPaneUser = new JScrollPane(tableCalendar);
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
		
		btnChooseCalendar = new JButton("Choose Calendar");
		btnChooseCalendar.setForeground(new Color (0, 0, 0));
		btnChooseCalendar.setFont(new Font("Arial", Font.BOLD, 30));
		btnChooseCalendar.setContentAreaFilled(false);
		btnChooseCalendar.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnChooseCalendar.setBounds(249, 600, 266, 50);
		add(btnChooseCalendar);
		
		btnChooseUser = new JButton("Choose User");
		btnChooseUser.setForeground(new Color (0, 0, 0));
		btnChooseUser.setFont(new Font("Arial", Font.BOLD, 30));
		btnChooseUser.setContentAreaFilled(false);
		btnChooseUser.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnChooseUser.setBounds(876, 600, 266, 50);
		add(btnChooseUser);
		
		btnShare = new JButton("Share");
		btnShare.setForeground(new Color (0, 0, 0));
		btnShare.setFont(new Font("Arial", Font.BOLD, 30));
		btnShare.setContentAreaFilled(false);
		btnShare.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnShare.setBounds(598, 600, 194, 50);
		add(btnShare);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color (0, 0, 0));
		btnBack.setFont(new Font("Arial", Font.BOLD, 30));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnBack.setBounds(598, 673, 194, 50);
		add(btnBack);
		
		lblShareCalendar = new JLabel("Share Calendar");
		lblShareCalendar.setForeground(new Color (0, 0, 0));
		lblShareCalendar.setFont(new Font("Arial", Font.BOLD, 78));
		lblShareCalendar.setBounds(393, 83, 667, 90);
		add(lblShareCalendar);
		
		
	}
	public void addActionListener(ActionListener l) {
		btnChooseCalendar.addActionListener(l);
		btnShare.addActionListener(l);
		btnChooseUser.addActionListener(l);
		btnBack.addActionListener(l);
	}
	public JButton getBtnChooseCalendar() {
		return btnChooseCalendar;
	}
	public JButton getBtnChooseUser() {
		return btnChooseUser;
	}
	public JButton getBtnShare() {
		return btnShare;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	
}