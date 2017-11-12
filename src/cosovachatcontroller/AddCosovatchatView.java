/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosovachatcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class AddCosovatchatView {

    private MainView mainView;
    private JButton btnAdd;
    private JPanel tablePanel ;
    private CosoVatChatPanel cosoVatChatPanel;
    public AddCosovatchatView(MainView mainView) {
        this.mainView= mainView ;
        btnAdd = mainView .getChoiceView().getBtnCosoVatChat();
        tablePanel = mainView.getTablePanel();
        cosoVatChatPanel = mainView.getCosoVatChatPanel();
        setEvent();
    }
    
    public void setEvent(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.removeAll();
                tablePanel.add(cosoVatChatPanel);
                tablePanel.validate();
                tablePanel.repaint();
            }
        });
    }
}
