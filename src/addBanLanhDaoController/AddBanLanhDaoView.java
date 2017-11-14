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
import mainview.FuncBanLanhDaoPanel;
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
    private JPanel smallPanel ;
    private FuncBanLanhDaoPanel funcBanLanhDaoPanel;
    
    public AddBanLanhDaoView(MainView mainView) {
        this.mainView = mainView;
        addView = mainView.getChoiceView().getBtnLanhDao();
        tablepanel = mainView.getTablePanel();
        banLanhDaoView = mainView.getBanLanhDaoView();
        smallPanel = mainView.getSmallPanel();
        funcBanLanhDaoPanel = mainView.getFuncBanLanhDaoPanel();
        
        setEvent();
    }
    
    public void setEvent(){
        addView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                tablepanel.removeAll();
                tablepanel.add(banLanhDaoView);
                tablepanel.validate();
                tablepanel.repaint();
                
                smallPanel.removeAll();
                smallPanel.add(funcBanLanhDaoPanel);
                smallPanel.validate();
                smallPanel.repaint();
            }
        });
    }
    
}
