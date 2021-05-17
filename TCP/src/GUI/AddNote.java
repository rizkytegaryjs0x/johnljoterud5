package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
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

public AddNote(){
	
	setPreferredSize(new Dimension(1366, 768));
	setSize(new Dimension(1366, 768));
	setLayout(null);

	lblAddUser = new JLabel("Add note");
	lblAddUser.setForeground(new Color(0, 0, 0));
	lblAddUser.setFont(new Font("Arial", Font.BOLD, 78));
	lblAddUser.setBounds(509, 107, 464, 90);
	add(lblAddUser);
	
	lblNote = new JLabel("Note:");
	lblNote.setForeground(new Color(0, 0, 0));
	lblNote.setFont(new Font("Arial", Font.BOLD, 26));
	lblNote.setBounds(473, 312, 105, 31);
	add(lblNote);
	
	textFieldText = new JTextField();
	textFieldText.setBounds(576, 305, 231, 119);
	add(textFieldText);
	textFieldText.setColumns(10);
	
	btnAddNote = new JButton("Add note");
	btnAddNote.setContentAreaFilled(false);
	btnAddNote.setForeground(new Color(0, 0, 0));
	btnAddNote.setFont(new Font("Arial", Font.BOLD, 30));
	btnAddNote.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
	btnAddNote.setBackground(Color.WHITE);
	btnAddNote.setBounds(591, 483, 194, 50);
	add(btnAddNote);
	
	btnBack = new JButton("Back");
	btnBack.setContentAreaFilled(false);
	btnBack.setForeground(new Color(0, 0, 0));
	btnBack.setFont(new Font("Arial", Font.BOLD, 30));
	btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
	btnBack.setBackground(Color.WHITE);
	btnBack.setBounds(591, 558, 194, 50);
	add(btnBack);
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
}
