/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfreechat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import mainview.MainView;

/**
 *
 * @author Tuan Anh
 */
public class ShowViewThongKeContrlloer {
    
    private MainView mainView;
    private JButton btnShowView ;
    private ThongKeView thongKeView;
    private FunThongKe funThongKe;
    private JPanel panelFunction ;
    private JPanel panelTable ;
    public ShowViewThongKeContrlloer(MainView mainView){
        this.mainView = mainView;
        btnShowView = mainView.getChoiceView().getBtnThongKe();
        thongKeView = mainView.getThongKeView();
        funThongKe = mainView.getFunThongKe();
        panelFunction = mainView.getSmallPanel();
        panelTable= mainView.getTablePanel();
        setEvent();
    }
    
    public void setEvent(){
        btnShowView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelFunction.removeAll();
               panelFunction.add(funThongKe);
               panelFunction.validate();
               panelFunction.repaint();
               
               
               panelTable.removeAll();
               panelTable.add(thongKeView);
               panelTable.validate();
               panelTable.repaint();
            }
        });
    }
}
