package mainview;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleContext;
import javax.swing.Action;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

@SuppressWarnings("serial")
public class ChoiceView extends JPanel {

    private JButton btnPlayer;
    private JButton btnLanhDao;
    private JButton btnThanhTich;
    private JButton btnKeHoach;
    private JButton btnCosoVatChat;
    private JButton btnThongKe;
    private JButton btnDoiTaiKhoan ;
    private JButton btnDangXuat ;
    public ChoiceView() {
        setLayout(new GridLayout(8, 1, 10, 10));
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setBorder(BorderFactory.createTitledBorder("Danh mục"));

        btnPlayer = new JButton("Player");
        btnLanhDao = new JButton("Lanh dao");
        btnThanhTich = new JButton("thanh tich");
        btnKeHoach = new JButton("Ke Hoach");
        btnCosoVatChat = new JButton("Co So Vat Chat");
        btnThongKe = new JButton("Thong Ke");
        btnDoiTaiKhoan = new JButton("Doi Tai Khoan");
        btnDangXuat = new JButton("Dang Xuat");
        add(btnPlayer);
        add(btnLanhDao);
        add(btnThanhTich);
        add(btnKeHoach);
        add(btnCosoVatChat);
        add(btnThongKe);
        add(btnDoiTaiKhoan);
        add(btnDangXuat);
        this.setBorder(new EmptyBorder(30, 10, 30, 10));
        // setEvent();
    }

    public JButton getBtnPlayer() {
        return btnPlayer;
    }

    public void setBtnPlayer(JButton btnPlayer) {
        this.btnPlayer = btnPlayer;
    }

    public JButton getBtnLanhDao() {
        return btnLanhDao;
    }

    public void setBtnLanhDao(JButton btnLanhDao) {
        this.btnLanhDao = btnLanhDao;
    }

    public JButton getBtnThanhTich() {
        return btnThanhTich;
    }

    public void setBtnThanhTich(JButton btnThanhTich) {
        this.btnThanhTich = btnThanhTich;
    }

    public JButton getBtnKeHoach() {
        return btnKeHoach;
    }

    public void setBtnKeHoach(JButton btnKeHoach) {
        this.btnKeHoach = btnKeHoach;
    }

    public JButton getBtnCosoVatChat() {
        return btnCosoVatChat;
    }

    public void setBtnCosoVatChat(JButton btnCosoVatChat) {
        this.btnCosoVatChat = btnCosoVatChat;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public void setEvent() {
        btnPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "sdsdsd");
            }
        });
    }
}
