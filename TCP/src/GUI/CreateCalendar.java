package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
//import model.QueryBuild.QueryBuilder;



public class CreateCalendar extends JPanel {

	private JLabel lblHeader;
	private JButton btnBack;
	private JButton btnSubmit;
	private JLabel lblName;
	private JLabel lblShareWith;
	private JLabel lblPrivateOrPublic;
	private JTextField textName;
	private JTextField textPrivateOrPublic;
	private JTextField txtShare;
	private JCheckBox chckbxIfYesCheck;
	private DefaultTableModel model;

	private JLabel lblShareCalendar;
	
	public CreateCalendar() {
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		String[] columnNames = { "Email" };
		
		
		chckbxIfYesCheck = new JCheckBox("If yes, check this box");
		chckbxIfYesCheck.setBounds(737, 391, 167, 25);
		add(chckbxIfYesCheck);
		
		lblShareCalendar = new JLabel("Share this calendar?");
		lblShareCalendar.setForeground(new Color (0, 0, 0));
		lblShareCalendar.setFont(new Font("Arial", Font.BOLD, 26));
		lblShareCalendar.setBounds(476, 380, 260, 39);
		add(lblShareCalendar);
		lblShareWith = new JLabel("Share with:");
		lblShareWith.setForeground(new Color (0, 0, 0));
		lblShareWith.setFont(new Font("Arial", Font.BOLD, 26));
		lblShareWith.setBounds(476, 432, 147, 39);
		lblShareWith.setVisible(false);
		add(lblShareWith);
		
		txtShare = new JTextField();
		txtShare.setColumns(10);
		txtShare.setBounds(737, 437, 149, 28);
		txtShare.setVisible(false);
		add(txtShare);
		
		lblHeader = new JLabel("Add Calendar");
		lblHeader.setForeground(new Color (0, 0, 0));
		lblHeader.setFont(new Font("Arial", Font.BOLD, 78));
		lblHeader.setBounds(424, 81, 515, 90);
		add(lblHeader);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color (0, 0, 0));
		btnBack.setFont(new Font("Arial", Font.BOLD, 30));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnBack.setBounds(601, 590, 194, 50);
		add(btnBack);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color (0, 0, 0));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnSubmit.setBounds(601, 520, 194, 50);
		add(btnSubmit);
		
		lblName = new JLabel("Name:");
		lblName.setForeground(new Color (0, 0, 0));
		lblName.setFont(new Font("Arial", Font.BOLD, 26));
		lblName.setBounds(476, 271, 147, 39);
		add(lblName);
		
		lblPrivateOrPublic = new JLabel("Private or public:");
		lblPrivateOrPublic.setForeground(new Color (0, 0, 0));
		lblPrivateOrPublic.setFont(new Font("Arial", Font.BOLD, 26));
		lblPrivateOrPublic.setBounds(476, 328, 223, 39);
		add(lblPrivateOrPublic);
		
		textName = new JTextField();
		textName.setBounds(737, 280, 149, 28);
		add(textName);
		textName.setColumns(10);
		
		textPrivateOrPublic = new JTextField();
		textPrivateOrPublic.setBounds(737, 337, 149, 28);
		add(textPrivateOrPublic);
		textPrivateOrPublic.setColumns(10);
		
		lblShareWith.setVisible(true);
		txtShare.setVisible(true);
		}
	
	public void addActionListener(ActionListener l) {
		btnBack.addActionListener(l);
		btnSubmit.addActionListener(l);
	}
	
	public JCheckBox getChckbxIfYesCheck() {
		return chckbxIfYesCheck;
	}

	public void setChckbxIfYesCheck(JCheckBox chckbxIfYesCheck) {
		this.chckbxIfYesCheck = chckbxIfYesCheck;
	}

	public JLabel getLblShareWith() {
		return lblShareWith;
	}

	public void setLblShareWith(JLabel lblShareWith) {
		this.lblShareWith = lblShareWith;
	}


	public void setTxtShare(JTextField txtShare) {
		this.txtShare = txtShare;
	}

	public JButton getBtnBack() {
		return btnBack;
	}
	
	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JTextField getTxtShare() {
		return txtShare;
	}

	public JTextField getTextName() {
		return textName;
	}

	public JTextField getTextPrivateOrPublic() {
		return textPrivateOrPublic;
	}
}
