
package taikhoan;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private JButton btnThoat ;
    private JTextField textField;
    private JPasswordField passwordField;
    public DangNhapController(DangNhapDialog dangNhapDialog, Client client ){
        this.client = client ;
        this.dangNhapDialog = dangNhapDialog ;
        btnDangNhap = dangNhapDialog.getBtnDangNhap();
        textField = dangNhapDialog.getjTextField1();
        passwordField = dangNhapDialog.getPassword();
        btnThoat = dangNhapDialog.getBtnThoat();
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
        
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dangNhapDialog.setVisible(false);
            }
        });
        
        
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
             if(e.getKeyCode() == KeyEvent.VK_ENTER){
              String username = textField.getText();
              String password = passwordField.getText();
              String massage = username+","+password+":dangnhap";
              client.getPw().println(massage);
              client.getPw().flush();
             }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
              String username = textField.getText();
              String password = passwordField.getText();
              String massage = username+","+password+":dangnhap";
              client.getPw().println(massage);
              client.getPw().flush();
             }}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
}
