/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ConnectDataBase.ConnectDataBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phant
 */
public class ServerThread extends Thread{
     private Socket socket ;
     private PrintWriter pw ;
     private BufferedReader br ;
     private ConnectDataBase cdb ;
     public ServerThread(Socket socket,ConnectDataBase cdb){
         try {
             this.socket = socket ;
             this.cdb = cdb ;
             pw = new PrintWriter(socket.getOutputStream());
             br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             this.start();
         } catch (IOException ex) {
             Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void run(){
          while (true) {

              try {
                  // phan tich yeu cau tu phia client
                  String string = br.readLine();
                  System.out.println(string);
                  if (string.equals("show data player")) {
                      String player = cdb.getDataplayerFromDatabase() + ":showdataplayer";
                      pw.println(player);
                      pw.flush();
                  } else if (string.equals("show data banlanhdao")) {
                      String banlanhdao = cdb.getDataLanhDaoFromDatabase() + ":showdatabanlanhdao";
                      pw.println(banlanhdao);
                      pw.flush();
                  } else if (string.equals("show thongkedoanhthu")) { 
                       String doanhthu = cdb.getDoanhThuYears() +":showdoanhthu";
                       pw.println(doanhthu);
                       pw.flush();
                  } else if (string.equals("show data thanhtich")) {
                      String thanhtich = cdb.getThanhTichFromDatabase() + ":showthanhtich";
                      pw.println(thanhtich);
                      pw.flush();
                  } else if (string.equals("show data kehoach")) {
                      String kehoach = cdb.getDataKeHoach() + ":showkehoach";
                      pw.println(kehoach);
                      pw.flush();
                  } else if (string.equals("show data cosovatchat")) {
                      String coso = cdb.getDataCosoVatChatFromDatabase() + ":showcoso";
                      pw.println(coso);
                      pw.flush();
                  } else {
                      System.out.println(string);
                      String[] data = processRequestFromClientStep1(string);
                      System.out.println(data[1]);
                      if (data[1].equals("insertplayer")) {
                          String[] word = processRequestFromClientStep2(data[0]);
                          int i = cdb.insertPlayerToDatabase(word);
                          if (i == 1) {
                              pw.println("insert sucess");
                              pw.flush();
                          } else {
                              pw.println("insert error");
                              pw.flush();
                          }
                      } else if (data[1].equals("deleteplayer")) {
                          int i = cdb.deletePlayerToDatabase(data[0]);
                          if (i == 1) {
                              pw.println("delete sucess");
                              pw.flush();
                          } else {
                              pw.println("delete error");
                              pw.flush();
                          }
                      }
                       else if (data[1].equals("deletekehoach")) {
                          String[] word = processRequestFromClientStep2(data[0]);
                          int i = cdb.deleteKeHoachToDatabase(word);
                          if (i == 1) {
                              pw.println("delete sucess");
                              pw.flush();
                          } else {
                              pw.println("delete error");
                              pw.flush();
                          }
                      }else if (data[1].equals("updateplayer")) {
                          String[] word = processRequestFromClientStep2(data[0]);
                          int i = cdb.updatePlayerToDatabase(word);
                          if (i == 0) {
                              pw.println("update error");
                              pw.flush();
                          } else {
                              pw.println("update sucess");
                              pw.flush();
                          }
                      } else if (data[1].equals("find player id")) {
                          String dat = cdb.getDataPlayerById(data[0]) + ":showdataplayer";
                          pw.println(dat);
                          pw.flush();
                      } else if (data[1].equals("find player name")) {
                          String dat = cdb.getDataPlayerByName(data[0]) + ":showdataplayer";
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("find player luong")) {
                          
                          String dat = cdb.getDataPlayerByLuong(data[0]) + ":showdataplayer";
                          pw.println(dat);
                          pw.flush();
                      }
                      else if (data[1].equals("find kehoach giaidau")) {
                          
                          String dat = cdb.getDataKeHoachByGiaiDau(data[0]) + ":showkehoach";
                          pw.println(dat);
                          pw.flush();
                      }
                      else if (data[1].equals("find kehoach vongdau")) {
                          
                          String dat = cdb.getDataKeHoachByVongDau(data[0]) + ":showkehoach";
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("find player like id")){
                          System.out.println(data[0]);
                          String dat = cdb.getDataPlayerLikeId(data[0])+":showdataplayer";
                          System.out.println(dat);
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("find player like name")){
                          System.out.println(data[0]);
                          String dat = cdb.getDataPlayerLikeName(data[0])+":showdataplayer";
                          System.out.println(dat);
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("find player less luong")){
                          System.out.println(data[0]);
                          String dat = cdb.getDataPlayerFollowLessSalary(data[0])+":showdataplayer";
                          System.out.println(dat);
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("find lanhdao id")){
                          System.out.println(data[0]);
                          String dat = cdb.getDataBanLanhDaoId(data[0])+":showdatabanlanhdao";
                          System.out.println(dat);
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("find lanhdao name")){
                          System.out.println(data[0]);
                          String dat = cdb.getDataBanLanhDaoName(data[0])+":showdatabanlanhdao";
                          System.out.println(dat);
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("find lanhdao less luong")){
                          
                          System.out.println(data[0]);
                          String dat = cdb.getDataBanLanhDaoFollowSalary(data[0])+":showdatabanlanhdao";
                          System.out.println(dat);
                          pw.println(dat);
                          pw.flush();
                      }else if (data[1].equals("insertBanLanhDao")){
                          String[] word = processRequestFromClientStep2(data[0]);
                          int i = cdb.insertBanLanhDaoToDatabase(word);
                          if (i == 1) {
                              pw.println("insert sucess");
                              pw.flush();
                          } else {
                              pw.println("insert error");
                              pw.flush();
                          }
                      }else if (data[1].equals("insertcosovatchat")){
                          String[] word = processRequestFromClientStep2(data[0]);
                          int i = cdb.insertFacility(word);
                          if (i == 1) {
                              pw.println("insert sucess");
                              pw.flush();
                          } else {
                              pw.println("insert error");
                              pw.flush();
                          }
                      }else if (data[1].equals("insert kehoach")){
                          String[] word = processRequestFromClientStep2(data[0]);
                          int i = cdb.insertKeHoachToDatabase(word);// chinh sua cho nay
                          if (i == 1) {
                              pw.println("insert sucess");
                              pw.flush();
                          } else {
                              pw.println("insert error");
                              pw.flush();
                          }
                      }else if (data[1].equals("updateBanLanhDao")){
                          String[] word = processRequestFromClientStep2(data[0]);
                          int i = cdb.updateBanLanhDaoToDatabase(word);
                          if (i == 1) {
                              pw.println("update sucess");
                              pw.flush();
                          } else {
                              pw.println("update error");
                              pw.flush();
                          }
                      }else if (data[1].equals("deletebanlanhdao")) {
                          int i = cdb.deleteBanlanhdaoToDatabase(data[0]);
                          if (i == 1) {
                              pw.println("delete sucess");
                              pw.flush();
                          } else {
                              pw.println("delete error");
                              pw.flush();
                          }
                      }
                      else if (data[1].equals("deletecosovatchat")) {
                          int i = cdb.deleteFacility(data[0]);
                          if (i == 1) {
                              pw.println("delete sucess");
                              pw.flush();
                          } else {
                              pw.println("delete error");
                              pw.flush();
                          }
                      }else if (data[1].equals("deletethanhtich")) {
                          int i = 0 ;
                          String[] word = processRequestFromClientStep2(data[0]);
                          String nam = word[0];
                          
                          String giaiDau = word[1];
                          System.out.println(nam +""+ giaiDau);
                          i = cdb.deleteThanhTichToDatabase(nam, giaiDau);
                          if (i == 1) {
                              pw.println("delete sucess");
                              pw.flush();
                          } else {
                              pw.println("delete error");
                              pw.flush();
                          }
                      }else if (data[1].equals("find thanhtich nam")) {
                          
                          String thanhtich = cdb.getDataThanhTichByNam(data[0])+":showthanhtich";
                          pw.println(thanhtich);
                          pw.flush();
                          
                      }else if (data[1].equals("find cosovatchat")) {
                          
                          String thanhtich = cdb.getDataCosoVatChatFromDatabaseByLocation(data[0])+":showcoso";
                          pw.println(thanhtich);
                          pw.flush();
                          
                      }else if (data[1].equals("find cosovatchat diadiem")) {
                          
                          String thanhtich = cdb.getDataCosoVatChatFromDatabaseLikeLocation(data[0])+":showcoso";
                          pw.println(thanhtich);
                          pw.flush();
                          
                      }else if (data[1].equals("find thanhtich name")) {
                          String thanhtich = cdb.getDataThanhTichByName(data[0])+":showthanhtich";
                          pw.println(thanhtich);
                          pw.flush();
                      }else if (data[1].equals("dangnhap")) {
                          
                          String [] word = processRequestFromClientStep2(data[0]);
                          String username = word[0];
                          String password = word[1];
                          
                          int i = cdb.checkUserLogin(username, password);
                          if (i == 1 ){
                              pw.println(username+","+password+":dang nhap thanh cong");
                              pw.flush();
                          }else{
                              pw.println("dang nhap that bai");
                              pw.flush();
                          }
                          
                      }else if (data[1].equals("dangkitaikhoan")) {                          
                          String [] word = processRequestFromClientStep2(data[0]);
                          String username = word[0];
                          String password = word[1];
                          
                          int i = cdb.addTaiKhoan(username, password) ;
                          if (i == 1 ){
                              pw.println("dang ki thanh cong");
                              pw.flush();
                          }else{
                              pw.println("dang ki that bai");
                              pw.flush();
                          }    
                      }else if (data[1].equals("updatetaikhoan")) {                          
                          String [] word = processRequestFromClientStep2(data[0]);
                          String username = word[0];
                          String password = word[1];
                          
                          int i = cdb.updateTaiKhoan(username, password) ;
                          if (i == 1 ){
                              pw.println("thay doi tai khoan thanh cong");
                              pw.flush();
                          }else{
                              pw.println("thay doi tai khoan that bai");
                              pw.flush();
                          }    
                      }
                  }
              } catch (IOException ex) {
                  Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
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

    public void showDataFromServer(String string) {
        String[] data = getDataFromServer(string);
        for (int i = 0; i < data.length; i++) {
            String[] word = processData(data[i]);
            for (int j = 0; j < word.length; i++) {
                System.out.print(word[i] + " ");
            }
        }
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public String[] processRequestFromClientStep1(String string) {
        String[] data = null;
        data = string.split(":");
        return data;
    }

    public String[] processRequestFromClientStep2(String string) {
        String[] data = null;
        data = string.split(",");
        return data;
    }

    public static void main(String[] args) {
        ConnectDataBase cdb = new ConnectDataBase();
        Server s = new Server(cdb);
        s.serve();
//        while(true){
//        s.getPw().println("tuan anh ");
//        s.getPw().flush();
//        }
    }

}
