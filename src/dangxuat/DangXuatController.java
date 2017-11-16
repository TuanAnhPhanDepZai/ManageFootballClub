/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangxuat;

import App.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;
import taikhoan.DangNhapDialog;

/**
 *
 * @author phant
 */
public class DangXuatController {
    
    private MainView mainView ;
    private JButton btnDangXuat ;
    private DangNhapDialog dangNhapDialog ;
    private App app;
    public DangXuatController(MainView mainView){
        this.mainView  = mainView ;
        btnDangXuat = mainView .getChoiceView().getBtnDangXuat();
        setEvent();
    }
    
    
    public void setEvent(){
        btnDangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app = new App();
                mainView.setVisible(false);
            }
        });
    }
    
    
}
