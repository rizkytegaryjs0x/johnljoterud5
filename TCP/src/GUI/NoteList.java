
	package GUI;

	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.ListSelectionModel;
	import javax.swing.border.BevelBorder;
	import javax.swing.border.CompoundBorder;
	import javax.swing.border.MatteBorder;
	import javax.swing.table.DefaultTableModel;

	public class NoteList extends JPanel{

		private JTable table;
		private DefaultTableModel model;
		private JScrollPane scrollPane;
		private JButton btnDelete;
		private JButton btnBack;
		private JLabel lblChooseNote;
		private int row;
		private String eventId;


		public NoteList() {
			
		

			setSize(new Dimension(1366, 768));
			setLayout(null);

			String[] columnNames = { "EventID","Type", "Name" ,"Text"};
			table = new JTable();
			model = (DefaultTableModel) table.getModel();
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
					eventId = table.getValueAt(row, 0).toString();
					setEventId(eventId);

					}
				}
			});

			// Create the scroll pane and add the table to it.
			scrollPane = new JScrollPane(table);
			scrollPane.setBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
			scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
							255), new Color(0, 0, 205), new Color(255, 255, 255)),
					null));
			scrollPane.setBounds(425, 240, 553, 315);

			// Add the scroll pane to this panel.
			add(scrollPane);
			
			lblChooseNote = new JLabel("Choose note");
			lblChooseNote.setForeground(new Color(0, 0, 0));
			lblChooseNote.setFont(new Font("Arial", Font.BOLD, 78));
			lblChooseNote.setBounds(447, 81, 680, 91);
			add(lblChooseNote);

			btnDelete = new JButton("Delete");
			btnDelete.setContentAreaFilled(false);
			btnDelete.setForeground(new Color(0, 0, 0));
			btnDelete.setFont(new Font("Arial", Font.BOLD, 30));
			btnDelete.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
			btnDelete.setBackground(Color.WHITE);
			btnDelete.setBounds(616, 617, 194, 50);
			add(btnDelete);
			
			btnBack = new JButton("Back");
			btnBack.setContentAreaFilled(false);
			btnBack.setForeground(new Color(0, 0, 0));
			btnBack.setFont(new Font("Arial", Font.BOLD, 30));
			btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
			btnBack.setBackground(Color.WHITE);
			btnBack.setBounds(616, 691, 194, 50);
			add(btnBack);
			

		}

		public JButton getBtnBack() {
			return btnBack;
		}

		public void setBtnBack(JButton btnBack) {
			this.btnBack = btnBack;
		}

		public DefaultTableModel getModel() {
			return model;
		}

		public void setModel(DefaultTableModel model) {
			this.model = model;
		}

		public void addActionlistener(ActionListener l){
			
			btnBack.addActionListener(l);
			btnDelete.addActionListener(l);
		}

		public JButton getBtnDelete() {
			return btnDelete;
		}


		public void setBtnDelete(JButton btnDelete) {
			this.btnDelete = btnDelete;
		}


		public String getEventId() {
			return eventId;
		}


		public void setEventId(String eventId) {
			this.eventId = eventId;
		}
		

	

}
