package BanLanhDaoView;

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
import model.LanhDao;



@SuppressWarnings("serial")
public class BanLanhDaoView extends JPanel  {
	private JTable table;
	private JScrollPane scroll;
	private JButton btNext,btBack;
	private JLabel lbName;
	
	private int currentPage;
	private String[] columns = { "ID", "Ten", "Vi Tri","Luong" };

	public BanLanhDaoView() {
		setLayout(new BorderLayout(10, 0));
		// setBorder(BorderFactory.createEtcheBorder(EtchedBorder.RAISED));
		// setBorder(BorderFactory.createEtchedBorder());
	
		// create table
		setPreferredSize(new Dimension(500, 440));
		table = new JTable();
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		loadData(table);

		// add tabel to scroll
		scroll = new JScrollPane();
		scroll.setViewportView(table);
		
		
		add(namePanel(),BorderLayout.NORTH);
		
		btNext = new JButton("Trang sau");
		btBack = new JButton("Trang trước");
		
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(btNext,BorderLayout.EAST);
		panel1.add(btBack,BorderLayout.WEST);
		
		add(panel1,BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
                
                this.setVisible(true);
	}

	private JPanel namePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(""));
		//create label
				lbName = new JLabel("DANH SÁCH BAN LANH DAO");
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

	public void updateTable(List<LanhDao> list){
		@SuppressWarnings("unused")
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
		String[][] data =  new String[list.size()][columns.length];
		for(int i=0;i<list.size();i++){
			LanhDao nv = list.get(i);
			data[i][0] = nv.getID();  
			data[i][1] =nv.getName();
			data[i][2] =nv.getPosition();
                        data[i][3]= String.valueOf(nv.getLuong());
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

	public JLabel getLbName() {
		return lbName;
	}

	public void setLbName(JLabel lbName) {
		this.lbName = lbName;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
        public static void main(String[] args) {
        new BanLanhDaoView();
    }

}
