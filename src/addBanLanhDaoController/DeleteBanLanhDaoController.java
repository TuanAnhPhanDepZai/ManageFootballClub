/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addBanLanhDaoController;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainview.MainView;
import javax.swing.JButton ;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author phant
 */


public class DeleteBanLanhDaoController {
    
    private Client client ;
    private MainView mainView ;
    private JButton btnDeleteData ;
    private JTable tableData;
    public DeleteBanLanhDaoController(Client client , MainView mainView ){
        this.client = client ;
        this.mainView = mainView ;
        btnDeleteData = mainView.getFuncBanLanhDaoPanel().getBtnXoa();
        tableData = mainView.getBanLanhDaoView().getTable();
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
                         String ID = String.valueOf(tableData.getValueAt(index, 0));
                         client.getPw().println(ID+":deletebanlanhdao");
                         client.getPw().flush();
                    }
                     
                 }
            }
        });
    }
}
