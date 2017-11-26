/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosovachatcontroller;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author Tuan Anh
 */
public class ShowdataFacility {
     private MainView mainView ;
    private Client client;
    private JButton btnShow ;
    
    public ShowdataFacility(MainView mainView, Client client){
        this.mainView = mainView ;
        this.client = client;
        btnShow = mainView .getFunCosoVatchatPanel().getBtnXemTatCa();
        setEvent();
    }
    
    public void setEvent(){
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.getPw().println("show data cosovatchat");
                client.getPw().flush();
            }
        });
    }
}
