/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddThanhTichController;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class FindThanhTichController {
    private MainView mainView;
    private Client client;
    private JButton search;
    private JTable table;
    private JTextField textField;
    private JComboBox<String> comboBox;
    
    public FindThanhTichController(MainView mainView , Client client){
        this.mainView = mainView ;
        this.client = client;
        textField = mainView .getFunThanhTichPanel().getTfSearch();
        comboBox = mainView .getFunThanhTichPanel().getCbType();
        search = mainView.getFunThanhTichPanel().getBtnTimKiem();
        
        setEvent();
        
        setKeyEvent();
    }
    
    public void setEvent(){
         search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "";
                String typeSearch = comboBox.getSelectedItem().toString();
                if (typeSearch.equals("Nam")) {
                    String nam = textField.getText().trim();
                    string = nam + ":find thanhtich nam";
                    client.getPw().println(string);
                    client.getPw().flush();
                } else if (typeSearch.equals("Thanh Tich")) {
                    String thanhtich = textField.getText().trim();
                    string = thanhtich + ":find thanhtich name";
                    client.getPw().println(string);
                    client.getPw().flush();
                } 
            }
        });
    }
    
    public void setKeyEvent(){
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER){
                    String string = "";
                String typeSearch = comboBox.getSelectedItem().toString();
                if (typeSearch.equals("Nam")) {
                    String nam = textField.getText().trim();
                    string = nam + ":find thanhtich nam";
                    client.getPw().println(string);
                    client.getPw().flush();
                } else if (typeSearch.equals("Thanh Tich")) {
                    String thanhtich = textField.getText().trim();
                    string = thanhtich + ":find thanhtich name";
                    client.getPw().println(string);
                    client.getPw().flush();
                } 
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
}
