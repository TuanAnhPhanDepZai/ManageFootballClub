/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddThanhTichController;

import ShowDataBanLanhDao.*;
import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class DeleteThanhTich {
    private Client client ;
    private MainView mainView ;
    private JButton btnDeleteData ;
    private JTable tableData;
    
     public DeleteThanhTich(Client client , MainView mainView ){
        this.client = client ;
        this.mainView = mainView ;
        btnDeleteData = mainView.getFunThanhTichPanel().getBtnXoa();
        tableData = mainView.getThanhTichPanel().getTable();
        setEvent();
    }
     
     public void setEvent(){
          btnDeleteData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tableData.getSelectedRow();
                 if (index < 0 ){
                     JOptionPane.showMessageDialog(null, "Ban chua chon dong nao de xoa");
                 }else {
                    int select =  JOptionPane.showOptionDialog(null, "Ban co thuc su muon xoa du lieu khong?","Xoa", 0, JOptionPane.YES_NO_OPTION, null, null, 1);
                     
                    if (select == 0 ){
                         String nam= String.valueOf(tableData.getValueAt(index, 0));
                         String giaiDau = String.valueOf(tableData.getValueAt(index, 1));
                         client.getPw().println(nam+","+giaiDau+":deletethanhtich");
                         client.getPw().flush();
                    }
                     
                 }
            }
        });
     }
}
