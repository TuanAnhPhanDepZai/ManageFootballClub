/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddThanhTichController;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class ShowDataThanhTichCOntroller {
    
    private MainView mainView ;
    private Client client ;
    private JButton btnShowData ;
    
    public ShowDataThanhTichCOntroller(MainView mainView, Client client){
        this.mainView = mainView;
        this.client = client ;
        btnShowData = mainView .getChoiceView().getBtnThanhTich();
        setEvent();
    }

    private void setEvent() {
       btnShowData.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               client.getPw().println("show data thanhtich");
               client.getPw().flush();
           }
       });
    
    }
}
