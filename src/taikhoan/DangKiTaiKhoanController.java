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
import javax.swing.JOptionPane;

/**
 *
 * @author phant
 */
public class DangKiTaiKhoanController {
    
    private Client client ;
    private DangKiTaiKhoanDialog dangKiTaiKhoanDialog ;
    private JButton btnDangKi ;
    
    public DangKiTaiKhoanController(Client client ,DangKiTaiKhoanDialog dangKiTaiKhoanDialog){
        this.client = client ;
        this.dangKiTaiKhoanDialog = dangKiTaiKhoanDialog ;
        btnDangKi = dangKiTaiKhoanDialog.getBtnDangKi();
        setEvent();
    }
    
    public void setEvent(){
        btnDangKi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = dangKiTaiKhoanDialog.getTfuser().getText().trim();
                String password = dangKiTaiKhoanDialog.getPwpassword().getText().trim();
                String confirmpass = dangKiTaiKhoanDialog.getPwconfirm().getText().trim();
                if (username.equals("") || password.equals("") || confirmpass .equals("")){
                    JOptionPane.showMessageDialog(null,"Nho dien day du cac truong du lieu ban nhe");
                }else if ( ! password.equals(confirmpass)){
                    JOptionPane.showMessageDialog(null, "Kiem  tra lai conFirPass Ban nhe");
                }else{
                    String massage = username+","+password+":dangkitaikhoan";
                    client.getPw().println(massage);
                    client.getPw().flush();
                    dangKiTaiKhoanDialog.setVisible(false);
                }
                
            }
        });
        
        
       
    }
}
