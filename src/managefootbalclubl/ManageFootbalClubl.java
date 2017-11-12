package managefootbalclubl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer;

public class ManageFootbalClubl extends JFrame {
	
	private JMenuBar menuBar = new JMenuBar();
	public Thread threadSingin;
	public String username;
	private DemoDialog dialog = new DemoDialog(this);
	private JButton buttonLogin = dialog.getBtnSingIn();
	private JButton buttonCancel = dialog.getBtnCancel();
    private JMenuItem menuDangNhap = new JMenuItem(" Đăng nhập");
	public ManageFootbalClubl() {
		setTitle("Quan Li Bong Da");
		setLayout(new FlowLayout());

		add(createManuBarSimple());
        add(createMenuBarAdvance());
        add(createManuBarSimple().add(createMenuHelp())) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(800, 600);
		// pack();
		setEvent();

	}

	private JMenuItem createMenuItemDangNhap() {
		JMenuItem menuDangnhap = new JMenuItem("Đăng nhập");
		menuDangnhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});

		return menuDangnhap;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createMenuTaiKhoan());
		JMenu menuQuanLy = new JMenu("Quản Lý ");
		menuBar.add(menuQuanLy);
		JMenu menuTraCuu = new JMenu("Tra Cứu");
		menuBar.add(menuTraCuu);
		JMenu menuHienThi = new JMenu("Hiển Thị");
		menuBar.add(menuHienThi);
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		return menuBar;
	}

	private JMenu createMenuTaiKhoan() {
		JMenu menu = new JMenu("Tài Khoản");
		menu.add(createMenuItemDangNhap());
		menu.add(createMenuItemDangKi());
		menu.add(createMenuItemThayDoiTaiKhoan());
		menu.add(createMeneItemThoat());

		return menu;
	}

	private JPanel createMainPanel() {
		JPanel panel = new JPanel();
		panel.add(createImaginePanel(), BorderLayout.WEST);
		panel.add(createPanel());
		return panel;
	}

	private JPanel createImaginePanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon("F:\\icon project\\barcelona.jpg"));
		panel.add(label);
		return panel;
	}

	private JButton createButton(String name) {
		JButton btn = new JButton(name);
		return btn;
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.add(new JButton("phan tuan anh dep trai "));
		return panel;
	}

	private JMenuItem createMenuItemDangKi() {
		JMenuItem menuDangKi = new JMenuItem("Đăng kí");
		menuDangKi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DangKi();
			}
		});
		return menuDangKi;
	}

	private JMenuItem createMenuItemThayDoiTaiKhoan() {
		JMenuItem menuThaydoi = new JMenuItem("Thay đổi tài khoản ");
		menuThaydoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ChangeAccount();
			}
		});
		return menuThaydoi;
	}

	private JMenuItem createMeneItemThoat() {
		JMenuItem menuitem = new JMenuItem("Thoat");
		menuitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return menuitem;
	}

	private JMenuBar createManuBarSimple() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createMenuTaiKhoan());
		return menuBar;
	}

	private JMenuBar createMenuHelp() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Help");
		menubar.add(menu);
		return menubar;
	}

	private JMenuBar createMenuBarAdvance() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuQuanLy = new JMenu("Quản lý");
		menuBar.add(menuQuanLy);
		JMenu menuTraCuu = new JMenu("Tra Cứu");
		menuBar.add(menuTraCuu);
		JMenu menuHienThi = new JMenu("Hiển thị");
		menuBar.add(menuHienThi);
		menuBar.setVisible(false);
		return menuBar;
	}

	public void setEvent() {
		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String uersname = dialog.getUername();
				String password = dialog.getPassword();
				if (uersname.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(dialog, "Ban chưa nhập đầy đủ tên đăng nhập hoặc mật khẩu");
				} else { // khi da co day du ten dang nhap va mat khau thi thiet
							// lap ket noi toi co so su lieu de lay account
					ConnectToGetSingIn connectToGetSingIn = new ConnectToGetSingIn();
					connectToGetSingIn.connnect();
					if (connectToGetSingIn.isConnectToSingIn() == false) {
						JOptionPane.showMessageDialog(null, "Loi dang nhap ");
					} else {
						ResultSet rs = (ResultSet) connectToGetSingIn.getDataId(uersname);
						if (rs == null) {
							JOptionPane.showMessageDialog(null, " ten dang nhap khong dung ");
						} else {
							String s2 = null;
							String s3 = null;
							try {
								while (rs.next()) {
									s2 = rs.getString(1).trim();
									s3 = rs.getString(2).trim();
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}

							if (!(uersname.equals(s2)) || !(password.equals(s3))) {
								JOptionPane.showMessageDialog(null, "Mat khau hoac tai khoan khong dung ban nhe ");
							} else {
								JOptionPane.showMessageDialog(dialog, "dang nhap thanh cong  ");
								//createMenuBarAdvance().setVisible(true);
							}
						}
					}
				}

			}
		});

	}

}
