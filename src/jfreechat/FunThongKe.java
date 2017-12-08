package jfreechat;

import mainview.*;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FunThongKe extends JPanel implements ActionListener{
	private JButton btnXemTatCa;
	private JButton btnShowMap;
	
	public FunThongKe() {
		
		setLayout(new BorderLayout(10,10));
		setBorder(BorderFactory.createTitledBorder("Chức năng"));
		add(createSearchPanel(),BorderLayout.NORTH);
		add(createActionPanel(),BorderLayout.CENTER);
               
	}
	

	private JPanel createSearchPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(20,0));
		
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new BorderLayout(20,0));
		
		
		
		
		
		panel.add(panelBtn,BorderLayout.EAST);
		return panel;
	}
	
	private JPanel createActionPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(1, 4, 10, 10));
		
		btnXemTatCa = createButtons("XEM TẤT CẢ");
		btnShowMap  = createButtons("Thong Ke Theo Bieu Đồ");
		
		
		panel.add(btnXemTatCa);
		panel.add(btnShowMap);

		return panel;
	}
	
	public JButton createButtons(String name){
		JButton button = new JButton(name);
		button.addActionListener(this);
		return button;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public JButton getBtnXemTatCa() {
		return btnXemTatCa;
	}


	public void setBtnXemTatCa(JButton btnXemTatCa) {
		this.btnXemTatCa = btnXemTatCa;
	}

    public JButton getBtnShowMap() {
        return btnShowMap;
    }

    public void setBtnShowMap(JButton btnShowMap) {
        this.btnShowMap = btnShowMap;
    }


	   public static void main(String[] args) {
              JFrame frame = new JFrame();
              frame.setVisible(true);
              frame.add(new FunThongKe());
              frame.pack();
    }

}
