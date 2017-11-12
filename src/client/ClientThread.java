package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mainview.MainView;
import model.CoSoVatChat;
import model.KeHoach;
import model.LanhDao;
import model.ThanhTich;
import model.player;

public class ClientThread extends Thread {

    private BufferedReader br;
    private MainView mainView;

    public ClientThread(BufferedReader br, MainView mainView) {
        this.br = br;
        this.start();
        this.mainView = mainView;
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
                    JOptionPane.showMessageDialog(null, "update thanh cong ");
                } else {

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
                    }else if (data[1].equals("showcoso")){
                        List<CoSoVatChat> list = showDataCoSoVatChatFromServer(data[0]);
                        mainView.getCosoVatChatPanel().updateTable(list);
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
}
