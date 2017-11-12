/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddPlayer;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class AddPlayerController {

    private MainView mainView;
    private Client client;
    private JButton btnAddPlayer;

    public AddPlayerController(MainView mainView, Client client) {
        this.mainView = mainView;
        this.client = client;
        btnAddPlayer = mainView.getFuncEmployeePanel().getBtnThem();
        setEvent();
    }

    public void setEvent() {
        btnAddPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // client gui thong diep den server
                new InsertPlayer(client).setVisible(true);
            }
        });
    }
}
