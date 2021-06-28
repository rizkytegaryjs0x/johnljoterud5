package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class AddNote extends JPanel { 

private JButton btnAddNote;
private JTextField textFieldText;
private JLabel lblNote;
private JLabel lblAddUser;
private JButton btnBack;

private JTable table;
private DefaultTableModel model;
private JScrollPane scrollPane;

private int row;
private JTextField textField;

public AddNote(){
	
	setPreferredSize(new Dimension(1366, 768));
	setSize(new Dimension(1366, 768));
	setLayout(null);
	
	String[] columnNames = { "EventID", "Name"};
	
	table = new JTable();
	model = (DefaultTableModel)table.getModel();
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
			


			}
		}
	});
	scrollPane = new JScrollPane(table);
	scrollPane.setBorder(new CompoundBorder(new BevelBorder(
			BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
					255), new Color(0, 0, 205), new Color(255, 255, 255)),
			new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
	scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
			BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
					255), new Color(0, 0, 205), new Color(255, 255, 255)),
			null));
	scrollPane.setBounds(512, 138, 357, 221);

	// Add the scroll pane to this panel.
	add(scrollPane);

	lblAddUser = new JLabel("Add note");
	lblAddUser.setForeground(new Color(0, 0, 0));
	lblAddUser.setFont(new Font("Arial", Font.BOLD, 78));
	lblAddUser.setBounds(502, 35, 464, 90);
	add(lblAddUser);
	
	lblNote = new JLabel("Note:");
	lblNote.setForeground(new Color(0, 0, 0));
	lblNote.setFont(new Font("Arial", Font.BOLD, 26));
	lblNote.setBounds(403, 458, 105, 31);
	add(lblNote);
	
	textFieldText = new JTextField();
	textFieldText.setBounds(520, 458, 349, 122);
	add(textFieldText);
	textFieldText.setColumns(10);
	
	btnAddNote = new JButton("Add note");
	btnAddNote.setContentAreaFilled(false);
	btnAddNote.setForeground(new Color(0, 0, 0));
	btnAddNote.setFont(new Font("Arial", Font.BOLD, 30));
	btnAddNote.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
	btnAddNote.setBackground(Color.WHITE);
	btnAddNote.setBounds(591, 601, 194, 50);
	add(btnAddNote);
	
	btnBack = new JButton("Back");
	btnBack.setContentAreaFilled(false);
	btnBack.setForeground(new Color(0, 0, 0));
	btnBack.setFont(new Font("Arial", Font.BOLD, 30));
	btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
	btnBack.setBackground(Color.WHITE);
	btnBack.setBounds(591, 675, 194, 50);
	add(btnBack);
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(522, 382, 136, 50);
	add(textField);
	
	JLabel lblChoose = new JLabel("Click on specified event");
	lblChoose.setForeground(Color.BLACK);
	lblChoose.setFont(new Font("Arial", Font.BOLD, 26));
	lblChoose.setBounds(193, 217, 307, 31);
	add(lblChoose);
	
	JLabel lblEventId = new JLabel("Event ID");
	lblEventId.setForeground(Color.BLACK);
	lblEventId.setFont(new Font("Arial", Font.BOLD, 26));
	lblEventId.setBounds(387, 398, 112, 31);
	add(lblEventId);
	}

public void addActionListener(ActionListener l) {
	textFieldText.addActionListener(l);
	btnAddNote.addActionListener(l);
	btnBack.addActionListener(l);
	
}
public JButton getBtnAddNote() {
	return btnAddNote;
}
public JTextField getTextFieldText() {
	return textFieldText;
}
public JButton getBtnBack() {
	return btnBack;
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

}
