/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addBanLanhDaoController;

import BanLanhDaoView.BanLanhDaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class AddBanLanhDaoView {

    private JButton addView;
    private MainView mainView;
    private JPanel tablepanel;
    private BanLanhDaoView banLanhDaoView ;
    
    public AddBanLanhDaoView(MainView mainView) {
        this.mainView = mainView;
        addView = mainView.getChoiceView().getBtnLanhDao();
        tablepanel = mainView.getTablePanel();
        banLanhDaoView = mainView.getBanLanhDaoView();
        setEvent();
    }
    
    public void setEvent(){
        addView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getFuncEmployeePanel().setVisible(false);
                tablepanel.removeAll();
                tablepanel.add(banLanhDaoView);
                tablepanel.validate();
                tablepanel.repaint();
            }
        });
    }
    
}
