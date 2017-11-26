/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosovachatcontroller;

import addkehoachcontroller.AddKeHoachDialog;
import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author Tuan Anh
 */
public class AddFacilityController {
     private Client client;
    private MainView mainView;
    private JButton add;

    public AddFacilityController(Client client, MainView mainView) {
             this.mainView = mainView ;
             this.client = client ;
             add = mainView.getFunCosoVatchatPanel().getBtnThem();
             setEvent();
    }
    
    public void setEvent(){
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFacilityDialog(client).setVisible(true);
            }
        });
    }
}
