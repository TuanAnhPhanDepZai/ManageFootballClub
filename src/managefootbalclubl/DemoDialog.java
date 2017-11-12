package managefootbalclubl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.api.mysqla.result.Resultset;
import com.sun.java.swing.plaf.windows.resources.windows;

public class DemoDialog extends JDialog {

	private final JLabel labelUersname = new JLabel("     Uers name ");
	private final JLabel labelPassword = new JLabel("     Pass word");
	private final JTextField tfuser = new JTextField(20);
	private JPasswordField ps = new JPasswordField(20);
	private JButton btnSingIn = new JButton("Sing In");
	private JButton btnCancel = new JButton("Cancel");
	public static boolean IsSinginSucess;
	private ManageFootbalClubl manageFootbalClubl;
	public static boolean pressSingIn = false;

	// public boolean IsPressSignIn = false ;
	public DemoDialog(ManageFootbalClubl manageFootbalClubl) {
		this.manageFootbalClubl = manageFootbalClubl;
		this.setTitle("Đăng nhập");
		this.setLayout(new BorderLayout());
		this.add(createPanelInput(), BorderLayout.PAGE_START);
		this.add(createPanelButton(), BorderLayout.PAGE_END);
		this.setVisible(false );
		this.setResizable(false);
		// this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pack();
	}

	private JPanel createPanelInput() {
		JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
		panel.add(labelUersname);
		panel.add(tfuser);
		panel.add(labelPassword);
		panel.add(ps);
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		return panel;
	}

	private JPanel createPanelButton() {
		JPanel panel = new JPanel(new GridLayout(1, 2, 5, 5));
		panel.add(createButtonSIngIn());
		panel.add(createButtonCancel());
		panel.setBorder(new EmptyBorder(5, 40, 5, 40));
		return panel;
	}

	private JButton createButtonSIngIn() {

		JButton button = new JButton("Sing In");
		
		return button;
	}

	private JButton createButtonCancel() {
		JButton button = new JButton("Cancel");
		return button;
	}

	public JButton getBtnSingIn() {
	      return btnSingIn ;
	}

	public void setBtnSingIn(JButton btnSingIn) {
		
		this.btnSingIn = btnSingIn;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public String getUername() {
		return tfuser.getText();
	}

	public String getPassword() {
		return ps.getText().toString().trim();
	}
 
}
