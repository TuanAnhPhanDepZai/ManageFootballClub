/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taikhoan;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author phant
 */
public class ShowViewDangKi {
    private DangNhapDialog dangNhapDialog ;
    private JButton btnShowView ;
    private DangKiTaiKhoanDialog dangKiTaiKhoanDialog;
    private Client client ;
    public ShowViewDangKi(DangNhapDialog dangNhapDialog, Client client ){
        this.client = client ;
       this.dangNhapDialog = dangNhapDialog;
       btnShowView = dangNhapDialog.getBtnDangki();
       setEvent();
    }
    
    public void setEvent(){
        btnShowView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dangKiTaiKhoanDialog = new DangKiTaiKhoanDialog() ;
                DangKiTaiKhoanController dangKiTaiKhoanController = new DangKiTaiKhoanController(client, dangKiTaiKhoanDialog);
                dangNhapDialog.setVisible(false);
            }
        });
    }
}
