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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author phant
 */
public class ThayDoiTaiKhoanController {
    private ThayDoiTaiKhoanDialog thayDoiTaiKhoanDialog;
    private JButton btnThayDoi;
    private Client client ;
    private String textUser ;
    private String pass ;
    private String newpass;
    
    private String username ;
    private String password ;
    
    public ThayDoiTaiKhoanController(ThayDoiTaiKhoanDialog thayDoiTaiKhoanDialog, Client client ){
        this.thayDoiTaiKhoanDialog = thayDoiTaiKhoanDialog ;
        this.client =client ;
        btnThayDoi = thayDoiTaiKhoanDialog.getBtnDoiTiaKhoan();
        
        textUser = thayDoiTaiKhoanDialog.getTfUsername().getText().trim();
        pass = thayDoiTaiKhoanDialog.getPassWordField().getText().trim();
        newpass = thayDoiTaiKhoanDialog.getNewPassField().getText().trim();
        
        
        username = thayDoiTaiKhoanDialog.getUsername();
        password = thayDoiTaiKhoanDialog.getPassword();
        
       // setEvent();
    }
    
    public void setEvent(){
        btnThayDoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // thuc hien thao tac Check 
                if (textUser.equals("") || pass.equals("")  || newpass.equals("")){
                    JOptionPane.showMessageDialog(null,"Nho dien het cac truong du lieu ban nhe");
                    JOptionPane.showMessageDialog(null, textUser+pass+newpass);
                }else if (! username.equals(textUser)  || !password.equals(pass)){
                    JOptionPane.showMessageDialog(null,"Ban phai du nguyen cac truong du lieu cua chung toi");
                }
                else {
                    String massage = textUser+","+newpass+":updatetaikhoan";
                    client.getPw().println(massage);
                    client.getPw().flush();
                }                        
            }
        });
    }
}
