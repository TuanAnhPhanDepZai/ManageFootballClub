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
import mainview.FunCosoVatchatPanel;
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
    private FunCosoVatchatPanel funCosoVatchatPanel;
    private JPanel smallPanel ;
    public AddCosovatchatView(MainView mainView) {
        this.mainView= mainView ;
        btnAdd = mainView .getChoiceView().getBtnCosoVatChat();
        tablePanel = mainView.getTablePanel();
        cosoVatChatPanel = mainView.getCosoVatChatPanel();
        smallPanel = mainView.getSmallPanel();
        funCosoVatchatPanel = mainView.getFunCosoVatchatPanel();
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
                
                  
                smallPanel.removeAll();
                smallPanel.add(funCosoVatchatPanel);
                smallPanel.validate();
                smallPanel.repaint();
            }
        });
    }
}
