/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thongkedoanhthu;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author Tuan Anh
 */
public class ThongKeController {
    
    private JButton btnThongKe;
    private MainView mainView;
    private Client client ;
    
    public ThongKeController(MainView mainView, Client client){
        this.mainView = mainView;
        this.client = client;
        btnThongKe = mainView.getChoiceView().getBtnThongKe();
        setEvent();
    }
    
    public void setEvent(){
        btnThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.getPw().println("show thongkedoanhthu");
                client.getPw().flush();
            }
        });
    }
    
}
      
