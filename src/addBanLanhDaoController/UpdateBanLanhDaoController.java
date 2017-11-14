/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addBanLanhDaoController;

import AddPlayer.UpdatePlayerDialog;
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
public class UpdateBanLanhDaoController {
    private MainView mainView;
    private JButton btnUpdateBanLanhDao;
    private JTable table;
    private Client client;
    private UpdataBanLanhDaoDialog updataBanLanhDaoDialog; 

    public UpdateBanLanhDaoController(MainView mainView, Client client) {
        this.mainView = mainView;
        this.client = client;
        btnUpdateBanLanhDao = mainView.getFuncBanLanhDaoPanel().getBtnSua();
        table = mainView.getBanLanhDaoView().getTable();
        setEvent();
    }

    public void setEvent() {
        btnUpdateBanLanhDao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null, "Ban chua chon dong de cap nhat", "Loi cap nhat", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ID = String.valueOf(table.getValueAt(row, 0));
                    String name = String.valueOf(table.getValueAt(row, 1));
                    String position = String.valueOf(table.getValueAt(row, 2));                
                    String luong = String.valueOf(table.getValueAt(row, 3));

                    System.out.println(ID + name + position + luong);
                    updataBanLanhDaoDialog = new UpdataBanLanhDaoDialog(ID, name, position, luong, client);
                    updataBanLanhDaoDialog.setVisible(true);

                }
                
                
            }
        });
    }
}
