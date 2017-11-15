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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author phant
 */
public class DangNhapController {
    
    private DangNhapDialog dangNhapDialog ;
    private Client client ;
    private JButton btnDangNhap ;
    private JTextField textField;
    private JPasswordField passwordField;
    public DangNhapController(DangNhapDialog dangNhapDialog, Client client ){
        this.client = client ;
        this.dangNhapDialog = dangNhapDialog ;
        btnDangNhap = dangNhapDialog.getBtnDangNhap();
        textField = dangNhapDialog.getjTextField1();
        passwordField = dangNhapDialog.getPassword();
        setEvent();
    }
    
    public void setEvent(){
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String username = textField.getText();
              String password = passwordField.getText();
              String massage = username+","+password+":dangnhap";
              client.getPw().println(massage);
              client.getPw().flush();
            }
        });
    }
}
