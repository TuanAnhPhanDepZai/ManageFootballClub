
package jfreechat;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author Tuan Anh
 */
public class ShowDataThongKeController {
    
    private MainView mainView;
    private Client client ;
    private JButton btnShowView ;
    private JButton btnShowMap ;
    public ShowDataThongKeController(MainView mainView , Client client ){
        this.mainView  = mainView ;
        this.client = client ;
        btnShowMap = mainView.getFunThongKe().getBtnShowMap();
        btnShowView = mainView.getFunThongKe().getBtnXemTatCa();
        setEvent();
    }
    
    public void setEvent(){
        btnShowView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               client.getPw().println("showloinhuan");
               client.getPw().flush();
            }
        });
        
        
        btnShowMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              client.getPw().println("show thongkedoanhthu");
              client.getPw().flush();
            }
        }
        );
    }
}
