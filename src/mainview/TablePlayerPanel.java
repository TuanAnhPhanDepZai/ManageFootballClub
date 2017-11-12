package mainview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import model.player;


@SuppressWarnings("serial")
public class TablePlayerPanel extends JPanel  {
	private JTable table;
	private JLabel lbName;
	private JScrollPane scroll;
	private JButton btNext,btBack;
	private int currentPage;
	private String[] columns = { "ID", "Họ tên","Vi tri", "Que Quan", "Tuoi","Luong"};

	public TablePlayerPanel() {
		setLayout(new BorderLayout(10, 0));
//		 setBorder(BorderFactory.createEtcheBorder(EtchedBorder.RAISED));
		 setBorder(BorderFactory.createEtchedBorder());
		
		
		
		setPreferredSize(new Dimension(500, 440));
		// create table
		table = new JTable();
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		loadData(table);

		// add table to scroll
		scroll = new JScrollPane();
		// scroll.setPreferredSize();
		scroll.setViewportView(table);
		add(namePanel(),BorderLayout.PAGE_START);
		add(scroll, BorderLayout.CENTER);
		btNext = new JButton("Trang sau");
		btBack = new JButton("Trang trước");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(btNext,BorderLayout.EAST);
		panel.add(btBack,BorderLayout.WEST);
		add(panel,BorderLayout.SOUTH);
                
	}

//	public JPanel createTablePanel() {
//		
//		panel.add(scroll, BorderLayout.CENTER);
//		return panel;
//
//	}
	
	private JPanel namePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(""));
		//create label
				lbName = new JLabel("DANH SÁCH Cau Thu");
				lbName.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lbName,BorderLayout.CENTER);
			
			return panel;
	}
	
	
	private void loadData(JTable table) {
		String[][] data = null;

		DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table.setModel(tableModel);

	}

	public void updateTable(List<player> list){
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
		String[][] data =  new String[list.size()][columns.length];
		for(int i=0;i<list.size();i++){
			player nv      =    list.get(i);
			data[i][0] 	= nv.getID();
                        data[i][1]      = nv.getName();
			data[i][2] 	= nv.getPosition();
			data[i][3]     =   nv.getAdress();
			data[i][4] 	=    String.valueOf(nv.getTuoi());
			data[i][5] 	=    String.valueOf(nv.getLuong());
			
	
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public JLabel getLbName() {
		return lbName;
	}

	public void setLbName(JLabel lbName) {
		this.lbName = lbName;
	}

	public JButton getBtNext() {
		return btNext;
	}

	public void setBtNext(JButton btNext) {
		this.btNext = btNext;
	}

	public JButton getBtBack() {
		return btBack;
	}

	public void setBtBack(JButton btBack) {
		this.btBack = btBack;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
        
        public static void main(String[] args) {
        new TablePlayerPanel().setVisible(true);
    }
}
