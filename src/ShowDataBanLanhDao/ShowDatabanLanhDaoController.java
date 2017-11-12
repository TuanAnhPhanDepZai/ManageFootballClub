/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShowDataBanLanhDao;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class ShowDatabanLanhDaoController {
    
    private MainView mainView ;
    private Client client;
    private JButton showData;
    public ShowDatabanLanhDaoController(MainView mainView,Client client){
       this.mainView = mainView ;
       this.client = client ;
       showData = mainView.getChoiceView().getBtnLanhDao();
       setEvent();
    }

    private void setEvent() {
        showData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 client.getPw().println("show data banlanhdao");
                 client.getPw().flush();
            }
        });
    }
    
}
