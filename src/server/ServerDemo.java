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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phant
 */


public class ServerDemo {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private ConnectDataBase cdb;
    private PrintWriter pw;
    private BufferedReader br;
    public ServerDemo(ConnectDataBase cdb) {
        this.cdb = cdb;
        serve();
    }
    
    public void serve(){
        try {
            ServerSocket serverSocket = new ServerSocket(1997);
            System.out.println("Da mo cong ket noi cho Client");
             socket = serverSocket.accept();
             
             pw = new PrintWriter(socket.getOutputStream());
             br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
               String string = br.readLine();
               String word[] = processRequestFromClientStep1(string);
               if (word[1].equals("dangnhap")){
                   String data [] = processRequestFromClientStep2(word[0]);
                   String username = data[0];
                   String password = data[1];
                   int i = cdb.checkUserLogin(username, password);
                    if (i == 1 ){
                              pw.println("dang nhap thanh cong");
                              pw.flush();
                          }else{
                              pw.println("dang nhap that bai");
                              pw.flush();
                          }
               }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public int checkUserLogin(){
        int i = 0 ;
        return i ;
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
        ConnectDataBase connectDataBase = new ConnectDataBase();
        new ServerDemo(connectDataBase);
    }
}
