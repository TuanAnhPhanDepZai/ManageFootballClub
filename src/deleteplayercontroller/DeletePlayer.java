/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deleteplayercontroller;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import mainview.MainView;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author phant
 */
public class DeletePlayer {

    public MainView mainView;
    public Client client;
    public JButton btnDeletePlayer;
    private JTable table;

    public DeletePlayer(MainView mainView, Client client) {
        this.mainView = mainView;
        this.client = client;
        btnDeletePlayer = mainView.getFuncEmployeePanel().getBtnXoa();
        table = mainView .getTableEmployeePanel().getTable();
        setEvent();
    }

    public void setEvent() {
        btnDeletePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 int index = table.getSelectedRow();
                 if (index < 0 ){
                     JOptionPane.showMessageDialog(null, "Ban chua chon dong nao de xoa");
                 }else {
                    int select =  JOptionPane.showOptionDialog(null, "Ban co thuc su muon xoa khong?","Xoa", 0, JOptionPane.YES_NO_OPTION, null, null, 1);
                     
                    if (select == 0 ){
                         String ID = String.valueOf(table.getValueAt(index, 0));
                         client.getPw().println(ID+":deleteplayer");
                         client.getPw().flush();
                    }
                     
                 }
            }
        });
    }
}
