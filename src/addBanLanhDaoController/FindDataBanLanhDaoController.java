/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addBanLanhDaoController;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class FindDataBanLanhDaoController {
    
    private MainView mainView;
    private Client client;
    private JButton search;
    private JTable table;
    private JTextField textField;
    private JComboBox<String> comboBox;
    
    public FindDataBanLanhDaoController(Client client,MainView mainView){
        this.mainView = mainView ;
        this.client = client;
        textField = mainView .getFuncBanLanhDaoPanel().getTfSearch();
        comboBox = mainView .getFuncBanLanhDaoPanel().getCbType();
        search = mainView.getFuncBanLanhDaoPanel().getBtnTimKiem();
        
        setEvent();
    }
    
    public void setEvent(){
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "";
                String typeSearch = comboBox.getSelectedItem().toString();
                if (typeSearch.equals("ID")) {
                    String id = textField.getText().trim();
                    string = id + ":find lanhdao id";
                    client.getPw().println(string);
                    client.getPw().flush();
                } else if (typeSearch.equals("Họ tên")) {
                    String name = textField.getText().trim();
                    string = name + ":find lanhdao name";
                    client.getPw().println(string);
                    client.getPw().flush();
                } else if (typeSearch.equals("Lương")) {
                    String luong = String.valueOf(textField.getText().trim());

                    try {
                        int i = Integer.valueOf(luong);
                        string = luong + ":find lanhdao less luong";
                        client.getPw().println(string);
                        client.getPw().flush();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Kieu du lieu nhap vao khong hop le");
                    }
 
            
            }

            }
        });
    }
}
