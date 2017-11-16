/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaydoitaikhoan;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class ShowThayDoiTaiKhoanView {
    
    private MainView mainView ;
    private Client  client ;
    private JButton btnThayDoiTaiKhoan ;
    public ShowThayDoiTaiKhoanView(MainView mainView,Client client){
        this.mainView = mainView ;
        this.client = client;
        btnThayDoiTaiKhoan = mainView.getChoiceView().getBtnDoiTaiKhoan();
        setEvent();
    }
    
    public void setEvent(){
        btnThayDoiTaiKhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ThayDoiTaiKhoanDialog thayDoiTaiKhoanDialog= new ThayDoiTaiKhoanDialog(mainView,client);
               //ThayDoiTaiKhoanController thayDoiTaiKhoanController = new ThayDoiTaiKhoanController(thayDoiTaiKhoanDialog, client);
            }
        });
    }
}
