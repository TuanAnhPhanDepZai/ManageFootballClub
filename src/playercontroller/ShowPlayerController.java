/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playercontroller;

import ConnectDataBase.ConnectDataBase;
import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import mainview.MainView;
import model.player;

/**
 *
 * @author phant
 */
public class ShowPlayerController {

    private JButton btnShowPlayer ;
    private MainView mainView ;
    private ConnectDataBase cd ;
    private Client client ;
    private String string ;
    public ShowPlayerController(MainView mainView,Client client) {
        this.mainView = mainView ;
        this.cd = cd ;
        this.client = client ;
        
        btnShowPlayer = mainView.getFuncEmployeePanel().getBtnXemTatCa();
        
        setEvent();
    }
    
    
    public void setEvent(){
        btnShowPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 client.getPw().println("show data player");
                 client.getPw().flush();
                //string = client.abc();
//                List<player> list = client.showDataFromServer(string);
//                mainView.getTableEmployeePanel().updateTable(list);
            }
        });
    }
}
