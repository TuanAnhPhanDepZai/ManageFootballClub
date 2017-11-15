/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import client.Client;
import client.ClientThread;
import java.util.Scanner;
import mainview.MainView;
import taikhoan.DangKiTaiKhoanController;
import taikhoan.DangKiTaiKhoanDialog;
import taikhoan.DangNhapController;
import taikhoan.DangNhapDialog;

/**
 *
 * @author phant
 */
public class App {

    private Client client ;
    private DangNhapDialog dangNhapDialog; 
    private DangNhapController dangNhapController;
    private DangKiTaiKhoanController dangKiTaiKhoanController;
    
    public App(){
        client = new Client();
        dangNhapDialog = new DangNhapDialog();
        dangNhapController = new DangNhapController(dangNhapDialog, client);
        dangKiTaiKhoanController = new DangKiTaiKhoanController();
    }
    public static void main(String[] args) {
        App app = new App();
    }
    
}
