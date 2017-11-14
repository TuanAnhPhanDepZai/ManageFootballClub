package AddPlayer;

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

public class FindPlayerController {

    private MainView mainView;
    private Client client;
    private JButton search;
    private JTable table;
    private JTextField textField;
    private JComboBox<String> comboBox;
    public FindPlayerController(MainView mainView, Client client) {
        this.mainView = mainView;
        this.client = client;
        search = mainView.getFuncEmployeePanel().getBtnTimKiem();
        textField = mainView.getFuncEmployeePanel().getTfSearch();
        comboBox = mainView.getFuncEmployeePanel().getCbType();
        setEvent();
        setEventType();
    }

    public void setEvent() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "";
                String typeSearch = comboBox.getSelectedItem().toString();
                if (typeSearch.equals("ID")) {
                    String id = textField.getText().trim();
                    string = id + ":find player id";
                    client.getPw().println(string);
                    client.getPw().flush();
                } else if (typeSearch.equals("Họ tên")) {
                    String name = textField.getText().trim();
                    string = name + ":find player name";
                    client.getPw().println(string);
                    client.getPw().flush();
                } else if (typeSearch.equals("Lương")) {
                    String luong = String.valueOf(textField.getText().trim());

                    try {
                        int i = Integer.valueOf(luong);
                        string = luong + ":find player luong";
                        client.getPw().println(string);
                        client.getPw().flush();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Kieu du lieu nhap vao khong hop le");
                    }

                }

            }
        });
    }
    
    public void setEventType(){
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String string = "";
                String typeSearch = comboBox.getSelectedItem().toString();
                
                if (typeSearch.equals("ID")) {
                    String id = textField.getText().trim();
                    if (!id.equals("")){
                    string = id + ":find player like id";
                    client.getPw().println(string);
                    client.getPw().flush();
                    }
                } else if (typeSearch.equals("Họ tên")) {
                    String name = textField.getText().trim();
                    if (!name.equals("")){
                    string = name + ":find player like name";
                    client.getPw().println(string);
                    client.getPw().flush();
                    }
                } else if (typeSearch.equals("Lương")) {
                    String luong = String.valueOf(textField.getText().trim());

                    try {
                        int i = Integer.valueOf(luong);
                        string = luong + ":find player luong";
                        client.getPw().println(string);
                        client.getPw().flush();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Kieu du lieu nhap vao khong hop le");
                    }
 
            
            }
            }
            @Override
            public void keyPressed(KeyEvent e) {
//             String string = "";
//                String typeSearch = comboBox.getSelectedItem().toString();
//                if (typeSearch.equals("ID")) {
//                    String id = textField.getText().trim();
//                    string = id + ":find player like id";
//                    client.getPw().println(string);
//                    client.getPw().flush();
//                } else if (typeSearch.equals("Họ tên")) {
//                    String name = textField.getText().trim();
//                    string = name + ":find player like name";
//                    client.getPw().println(string);
//                    client.getPw().flush();
//                } else if (typeSearch.equals("Lương")) {
//                    String luong = String.valueOf(textField.getText().trim());
//
//                    try {
//                        int i = Integer.valueOf(luong);
//                        string = luong + ":find player luong";
//                        client.getPw().println(string);
//                        client.getPw().flush();
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(null, "Kieu du lieu nhap vao khong hop le");
//                    }
// 
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                  String string = "";
//                String typeSearch = comboBox.getSelectedItem().toString();
//                if(typeSearch.equals("")){}else{
//                if (typeSearch.equals("ID")) {
//                    String id = textField.getText().trim();
//                    string = id + ":find player like id";
//                    client.getPw().println(string);
//                    client.getPw().flush();
//                } else if (typeSearch.equals("Họ tên")) {
//                    String name = textField.getText().trim();
//                    string = name + ":find player like name";
//                    client.getPw().println(string);
//                    client.getPw().flush();
//                } else if (typeSearch.equals("Lương")) {
//                    String luong = String.valueOf(textField.getText().trim());
//
//                    try {
//                        int i = Integer.valueOf(luong);
//                        string = luong + ":find player luong";
//                        client.getPw().println(string);
//                        client.getPw().flush();
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(null, "Kieu du lieu nhap vao khong hop le");
//                    }
// 
            
            
            }
        
        });
    }
}
