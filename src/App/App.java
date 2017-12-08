/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import client.Client;
import client.ClientThread;
import dangxuat.DangXuatController;
import java.util.Scanner;
import mainview.MainView;
import taikhoan.DangKiTaiKhoanController;
import taikhoan.DangKiTaiKhoanDialog;
import taikhoan.DangNhapController;
import taikhoan.DangNhapDialog;
import taikhoan.ShowViewDangKi;
import thaydoitaikhoan.ShowThayDoiTaiKhoanView;

/**
 *
 * @author phant
 */
public class App {

    private Client client ;
    private DangNhapDialog dangNhapDialog; 
    private DangNhapController dangNhapController;
    private DangKiTaiKhoanController dangKiTaiKhoanController;
    private ClientThread clientThread;
    private MainView mainView ;
    private DangKiTaiKhoanDialog dangKiTaiKhoanDialog;
    private ShowViewDangKi showViewDangKi;
    private ShowThayDoiTaiKhoanView showThayDoiTaiKhoanView;
    public App(){
       client = new Client();
       mainView = new MainView();
       dangNhapDialog = new DangNhapDialog();
       dangNhapController = new DangNhapController(dangNhapDialog, client);
       //dangKiTaiKhoanController = new DangKiTaiKhoanController(client, dangKiTaiKhoanDialog);      
       showViewDangKi = new ShowViewDangKi(dangNhapDialog, client);
       clientThread = new ClientThread(client, mainView,dangNhapDialog);
       showThayDoiTaiKhoanView = new ShowThayDoiTaiKhoanView(mainView, client) ;
       DangXuatController dangXuatController = new DangXuatController(mainView);
    }
    public static void main(String[] args) {
        App app = new App();
    }
    
}
