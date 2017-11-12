/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.player;

/**
 *
 * @author phant
 */
public class Client {

    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private String string;

    public Client() {
        connect();
    }

    public void connect() {

        try {
            Socket socket = new Socket("localhost", 1997);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }
    public String[] split(String string) {
        String[] data = string.split(",");
        return data;
    }

    public void showData(String[] string) {
        for (int i = 0; i < string.length; i++) {
            System.out.println(string[i]);
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

    public List<player> showDataFromServer(String string) {
        List<player> list = new ArrayList<>();
        String[] data = getDataFromServer(string);
        for (int i = 0; i < data.length; i++) {
            String[] word = processData(data[i]);
            String ID = word[0];
            String name = word[1];
            String position = word[2];
            String adress = word[3];
            int age = Integer.valueOf(word[4]);
            int luong = Integer.valueOf(word[5]);

            player player = new player(ID, name, position, adress, age, luong);
            list.add(player);
        }

        return list;
    }

    public String abc() {
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public void sendCommand(String string) {
        pw.println(string);
        pw.flush();
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.getPw().println("tuan anh");
        c.getPw().flush();
        System.out.println("da gui du lieu");
        c.getPw().println("tuan anh");
        c.getPw().flush();
        c.getPw().println("tuan anh");
        c.getPw().flush();
        c.getPw().println("tuan anh");
        c.getPw().flush();
        Scanner scanner = new Scanner(System.in);
        
        while(true){
        String s = scanner.nextLine();
        c.getPw().println(s);
        c.getPw().flush();
//        System.out.println("da gui thong tin den server");
    }
    }
}
