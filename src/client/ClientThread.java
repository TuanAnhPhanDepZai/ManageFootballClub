package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jfreechat.Jfreechat;
import mainview.MainView;
import managefootbalclubl.run.Run;
import model.CoSoVatChat;
import model.KeHoach;
import model.LanhDao;
import model.LoiNhuan;
import model.ThanhTich;
import model.player;
import taikhoan.DangNhapDialog;

public class ClientThread extends Thread {

    private BufferedReader br;
    private MainView mainView;
    private DangNhapDialog dangNhapDialog;
    private Run run ;
    private Client client ;
    public ClientThread(Client client, MainView mainView, DangNhapDialog dangNhapDialog) {
//        this.br = br;
        this.client = client ;
        br = client.getBr();
        this.start();
        this.mainView = mainView;
        this.dangNhapDialog = dangNhapDialog;
    }

    public void run() {

        while (true) {
            try {
                System.out.println("da nhan data");
                String string = br.readLine();
//                    List<player> list = showDataFromServer(string);
//                    mainView.getTableEmployeePanel().updateTable(list);

                if (string.equals("insert sucess")) {
                    JOptionPane.showMessageDialog(null, "Insert thanh cong");
                } else if (string.equals("insert error")) {
                    JOptionPane.showMessageDialog(null, string);
                } else if (string.equals("delete sucess")) {
                    JOptionPane.showMessageDialog(null, "Xoa thanh cong");
                } else if (string.equals("delete error")) {
                    JOptionPane.showMessageDialog(null, "Xoa that bai");
                } else if (string.equals("update error")) {
                    JOptionPane.showMessageDialog(null, "update error");
                } else if (string.equals("update sucess")) {
                    JOptionPane.showMessageDialog(null, "Update thanh cong");
                }else if (string.equals("thay doi tai khoan thanh cong")) {
                    JOptionPane.showMessageDialog(null, "Cap nhat thanh cong");
                }else if (string.equals("thay doi tai khoan that bai")) {
                    JOptionPane.showMessageDialog(null, "Cap nhat that bai");
                }
                   else if (string.equals("dang nhap that bai")) {
                    JOptionPane.showMessageDialog(null, "dang nhap that bai");
                }else if (string.equals("dang ki that bai")) {
                    JOptionPane.showMessageDialog(null, "dang ki that bai");
                }else if (string.equals("dang ki thanh cong")) {
                    JOptionPane.showMessageDialog(null, "dang ki tai khoan thanh cong, dang nhap de vao he thong ban nhe");
                }else {

                    String[] data = processDataFromServer(string);
                    if (data[1].equals("showdataplayer")) {
                        List<player> list = showDataPlayerFromServer(data[0]);
                        mainView.getTableEmployeePanel().updateTable(list);
                    } else if (data[1].equals("showdatabanlanhdao")) {
                        List<LanhDao> list = showDataLanhDaoFromServer(data[0]);
                        mainView.getBanLanhDaoView().updateTable(list);
                    } else if (data[1].equals("showthanhtich")) {
                        List<ThanhTich> list = showDataThanhTichFromServer(data[0]);
                        mainView.getThanhTichPanel().updateTable(list);
                    } else if (data[1].equals("showkehoach")) {
                        List<KeHoach> list = showDataKeHoachFromServer(data[0]);
                        mainView.getKeHoachView().updateTable(list);
                    }
                     else if (data[1].equals("showdoanhthu")) {
//                        List<KeHoach> list = showDataKeHoachFromServer(data[0]);
//                        mainView.getKeHoachView().updateTable(list);
                          String [] doanhthuNam = getDataFromServer(data[0]);
                          new Jfreechat(doanhthuNam);
                          
                    }else if (data[1].equals("showcoso")){
                        List<CoSoVatChat> list = showDataCoSoVatChatFromServer(data[0]);
                        mainView.getCosoVatChatPanel().updateTable(list);
                    }else if (data[1].equals("showloinhuan")){
                        
                        
                        List<LoiNhuan> list = showDataLoiNhuanFromServer(data[0]);
                        mainView.getThongKeView().updateTable(list);
                    }else if (data[1].equals("showdataplayerlike")){
                        List<player> list = showDataPlayerFromServer(data[0]);
                        mainView.getTableEmployeePanel().updateTable(list);
                    }else if (data[1].equals("dang nhap thanh cong")){
                        String word[] = processData(data[0]);
                        String username = word[0];
                        String password = word[1];
                        JOptionPane.showMessageDialog(null, "dang nhap thanh cong ");
                    mainView.setVisible(true);
                    mainView.getChoiceView().getLbNameUser().setText("CHao "+username);
                    mainView.setUsername(username);
                    mainView.setPassword(password);
                    dangNhapDialog.setVisible(false);
                    run= new Run(mainView, client);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String[] getDataFromServer(String string) {
        String[] data = string.split("%");
        return data;
    }

    public String[] processData(String string) {
        String[] data = string.split(",");
        return data;
    }

    public List<player> showDataPlayerFromServer(String string) {
        List<player> list = new ArrayList<>();
        String[] data = getDataFromServer(string);
        for (int i = 0; i < data.length; i++) {
            String[] word = processData(data[i]);
            if (word.length == 6 ){
            String ID = word[0];
            String name = word[1];
            String position = word[2];
            String adress = word[3];
            int age = Integer.valueOf(word[4]);
            int luong = Integer.valueOf(word[5]);
            
            player player = new player(ID, name, position, adress, age, luong);
            list.add(player);
            }
        }

        return list;
    }

    public List<LanhDao> showDataLanhDaoFromServer(String string) {
        List<LanhDao> lanhdao = new ArrayList<>();
        String[] data = getDataFromServer(string);
        for (int i = 0; i < data.length; i++) {
            String[] word = processData(data[i]);
            String ID = word[0];
            String name = word[1];
            String position = word[2];
            int luong = Integer.valueOf(word[3]);

            LanhDao ld = new LanhDao(ID, name, position, luong);
            lanhdao.add(ld);
        }

        return lanhdao;
    }

    public List<ThanhTich> showDataThanhTichFromServer(String string) {
        List<ThanhTich> list = new ArrayList<>();
        String[] data = getDataFromServer(string);
        for (int i = 0; i < data.length; i++) {
            String[] word = processData(data[i]);
            int namThiDau = Integer.valueOf(word[0]);
            String giaiDau = word[1];
            String thanhTich = word[2];

            ThanhTich thanhtich = new ThanhTich(namThiDau, giaiDau, thanhTich);
            list.add(thanhtich);
        }
        return list;
    }

    public List<KeHoach> showDataKeHoachFromServer(String string) {
        List<KeHoach> list = new ArrayList<>();
        String[] data = getDataFromServer(string);
        for (int i = 0; i < data.length; i++) {
            String[] word = processData(data[i]);
            int vongdau;
            vongdau = Integer.valueOf(word[0]);
            String giaidau = word[1];
            String ngaydau = word[2];
            String diadiem = word[3];
            String doithu = word[4];
            String trangthai = word[5];

            KeHoach keHoach = new KeHoach(vongdau, giaidau, ngaydau, diadiem, doithu, trangthai);

            list.add(keHoach);
        }
        return list;
    }

    public List<CoSoVatChat> showDataCoSoVatChatFromServer(String string){
        List<CoSoVatChat> list = new ArrayList<>();
        String [] data = getDataFromServer(string);
        for (int i = 0 ;i < data.length; i++){
            String [] word = processData(data[i]);
            String name = word[0];
            String locate = word[1];
            CoSoVatChat coSoVatChat = new CoSoVatChat(name, locate);
            list.add(coSoVatChat);
        }
        return list ;
    }
    public String[] processDataFromServer(String string) {
        String[] data = null;
        data = string.split(":");
        return data;
    }
    
    public List<LoiNhuan> showDataLoiNhuanFromServer(String string){
        List<LoiNhuan> list = new ArrayList<>();
        String [] data = getDataFromServer(string);
        for (int i = 0 ;i < data.length; i++){
            String [] word = processData(data[i]);
            int nam  = Integer.valueOf(word[0]);
            int quy = Integer.valueOf(word[1]);
            String name = word[2];
            int giaTri  = Integer.valueOf(word[3]);
            
            
            LoiNhuan loiNhuan = new LoiNhuan(nam, quy, name, giaTri);
            list.add(loiNhuan);
        }
        return list ;
    }
}
