
import AddThanhTichView.ThanhTichPanel;
import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import mainview.MainView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phant
 */
public class AddThanhTichController {

    private MainView mainView;
    private Client client;
    private JButton addThanhTichView;
    private JPanel tablePanel;
    private ThanhTichPanel thanhTichPanel;

    public AddThanhTichController(MainView mainView,Client client) {
        this.mainView = mainView;
        this.client = client;
        addThanhTichView = mainView.getChoiceView().getBtnThanhTich();
        tablePanel = mainView.getTablePanel();
        thanhTichPanel = mainView.getThanhTichPanel();
        setEvent();
    }

    private void setEvent() {

        addThanhTichView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.removeAll();
                tablePanel.add(thanhTichPanel);
                tablePanel.validate();
                tablePanel.repaint();
            }
        });
    }
}
