/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addkehoachcontroller;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author Tuan Anh
 */
public class KeHoachController {
    
    private MainView mainView;
    private JButton showData;
    private Client client;

    public KeHoachController(MainView mainView, Client client) {
        this.mainView = mainView;
        this.client = client;
        showData = mainView.getFunKeHoachPanel().getBtnXemTatCa();
        setEvent();
    }

    public void setEvent() {
        showData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.getPw().println("show data kehoach");
                client.getPw().flush();
            }
        });
    }
}
