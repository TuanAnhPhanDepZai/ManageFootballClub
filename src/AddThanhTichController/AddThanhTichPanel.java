package AddThanhTichController;

import AddThanhTichView.ThanhTichPanel;
import client.Client;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mainview.MainView;
import mainview.PanelImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phant
 */
public class AddThanhTichPanel {

    private MainView mainView;
    private Client client;
    private JButton addThanhTichView;
    private JPanel tablePanel;
    private ThanhTichPanel thanhTichPanel;
    private PanelImage panelImage;
    
    public AddThanhTichPanel(MainView mainView) {
        this.mainView = mainView;
        addThanhTichView = mainView.getChoiceView().getBtnThanhTich();
        tablePanel = mainView.getTablePanel();
        thanhTichPanel = mainView.getThanhTichPanel();
        panelImage = mainView.getPanelImage();
        setEvent();
    }

    private void setEvent() {

        addThanhTichView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getFuncEmployeePanel().setVisible(false);
               
                
                
                mainView.setIsDisplayImage(true);
                tablePanel.removeAll();
                tablePanel.add(thanhTichPanel);
                tablePanel.validate();
                tablePanel.repaint();
            }
        });
    }
}
