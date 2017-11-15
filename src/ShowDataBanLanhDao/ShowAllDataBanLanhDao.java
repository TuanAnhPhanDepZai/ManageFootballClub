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
public class ShowAllDataBanLanhDao {
    private Client client ;
    private MainView mainView ;
    private JButton btnShow ;
   
    public ShowAllDataBanLanhDao(Client client, MainView mainView ){
        this.client = client ;
        this.mainView = mainView ;
        btnShow = mainView .getFuncBanLanhDaoPanel().getBtnXemTatCa();
        setEvent();
    }
    
    public void setEvent(){
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                 client.getPw().println("show data banlanhdao");
                 client.getPw().flush();
            }
            
        });
}
}
