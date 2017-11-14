/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddThanhTichController;

import AddThanhTichView.ThanhTichPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import mainview.FunThanhTichPanel;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class AddThanhTichPanel {
    private JPanel tablePanel ;
    private MainView mainView ;
    private JButton addThanhtich ;
    private ThanhTichPanel thanhTichPanel ;
    private JPanel smallPanel ;
    private FunThanhTichPanel funThanhTichPanel;
    public AddThanhTichPanel(MainView mainView ){
        this.mainView = mainView ;
        addThanhtich = mainView.getChoiceView().getBtnThanhTich();
        thanhTichPanel = mainView.getThanhTichPanel();
        smallPanel = mainView.getSmallPanel();
        funThanhTichPanel = mainView.getFunThanhTichPanel();
        tablePanel = mainView.getTablePanel();
        setEvent();
    }
    
    public void setEvent(){
        addThanhtich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                tablePanel.removeAll();
                tablePanel.add(thanhTichPanel);
                tablePanel.validate();
                tablePanel.repaint();
                
                smallPanel.removeAll();
                smallPanel.add(funThanhTichPanel);
                smallPanel.validate();
                smallPanel.repaint();
            }
        });
    }
}
