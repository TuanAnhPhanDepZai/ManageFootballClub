package managefootbalclubl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class DangKi extends JDialog{
   
    private JLabel labeluser = new JLabel("     User");
    private JLabel labelpass = new JLabel("     Pass Word");
    private JLabel labelconfirm = new JLabel("    Confirm");
    
    private JTextField textuser = new JTextField(20);
    private JPasswordField password = new JPasswordField(20);
    private JPasswordField confirmpass = new JPasswordField(20); 
    
    public DangKi(){
        setTitle("Đăng kí­");
        setLayout(new BorderLayout());
        add(createPanelButton(), BorderLayout.PAGE_END);
        add(createPanelInput(), BorderLayout.PAGE_START);
        this.setVisible(true);
        setLocationRelativeTo(null);
        pack();
    }
    
    private JPanel createPanelInput(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,2,2));
        panel.add(labeluser);
        panel.add(textuser);
        panel.add(labelpass);
        panel.add(password);
        panel.add(labelconfirm);
        panel.add(confirmpass);
        panel.setBorder( new EmptyBorder(10, 20, 10, 10));
        return panel ;
    }
    
    private JButton createButtonSingUp( ){
        JButton btn= new JButton("Đăng kí");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // dung sau, cu de day da 
            }
        });
        return btn ;
    }
    
    private JButton createButtonCancel(){
        JButton btn = new JButton("Cancel");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textuser.setText("");
                password.setText("");
                confirmpass.setText("");
            }
        });
        return btn ;
    }
    
    private JPanel createPanelButton(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2,20,20));
        panel.add(createButtonSingUp());
        panel.add(createButtonCancel());
        panel.setBorder(new EmptyBorder(10, 60, 10, 60));
        return panel ;
    }
    public static void main(String[] args) {
        new DangKi();
    }
}
