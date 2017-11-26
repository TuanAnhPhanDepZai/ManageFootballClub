/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addkehoachcontroller;

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
public class FindKeHoachController {
     private MainView mainView;
    private Client client;
    private JButton search;
    private JTable table;
    private JTextField textField;
    private JComboBox<String> comboBox;
    
    public FindKeHoachController(Client client,MainView mainView){
        this.mainView = mainView ;
        this.client = client;
        textField = mainView .getFunKeHoachPanel().getTfSearch();
        comboBox = mainView .getFunKeHoachPanel().getCbType();
        search = mainView.getFunKeHoachPanel().getBtnTimKiem();
        
        setEvent();
        
        setKeyEvent();
    }
    
    public void setEvent(){
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "";
                String typeSearch = comboBox.getSelectedItem().toString();
                if (typeSearch.equals("Vong Dau")) {
                    String id = textField.getText().trim();
                    try{
                        int i = Integer.valueOf(id);
                        string = id + ":find kehoach vongdau";
                    client.getPw().println(string);
                    client.getPw().flush();
                    }catch (Exception ex){JOptionPane.showMessageDialog(null, "Kieu du lieu khong hop le");}
                    
                } else if (typeSearch.equals("Giai Dau")) {
                    String name = textField.getText().trim();
                    string = name + ":find kehoach giaidau";
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
                if (typeSearch.equals("Vong Dau")) {
                    String id = textField.getText().trim();
                    string = id + ":find kehoach vongdau";
                    client.getPw().println(string);
                    client.getPw().flush();
                } else if (typeSearch.equals("Giai Dau")) {
                    String name = textField.getText().trim();
                    string = name + ":find kehoach giaidau";
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
