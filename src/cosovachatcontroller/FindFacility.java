/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosovachatcontroller;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import mainview.MainView;

/**
 *
 * @author Tuan Anh
 */
public class FindFacility {
       
    private MainView mainView;
    private Client client;
    private JButton search;
    private JTable table;
    private JTextField textField;
    private JComboBox<String> comboBox;
    
    public FindFacility(Client client,MainView mainView){
        this.mainView = mainView ;
        this.client = client;
        textField = mainView .getFunCosoVatchatPanel().getTfSearch();
       
        search = mainView.getFunCosoVatchatPanel().getBtnTimKiem();
        
        setEvent();
        
        setKeyEvent();
    }
    
    public void setEvent(){
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "";
               
               
                    String diadiem = textField.getText().trim();
                    string += diadiem + ":find cosovatchat";
                    client.getPw().println(string);
                    client.getPw().flush();
              
 
            
            }

            
        });
    }
    
    public void setKeyEvent(){
       textField.addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {
              String string = "";
               
               
                    String diadiem = textField.getText().trim();
                    string = diadiem + ":find cosovatchat diadiem";
                    client.getPw().println(string);
                    client.getPw().flush();  
           }
           
               

           @Override
           public void keyPressed(KeyEvent e) {}

           @Override
           public void keyReleased(KeyEvent e) {}
       });
    }
}
