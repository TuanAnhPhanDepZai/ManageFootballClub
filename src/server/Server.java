package server;

import ConnectDataBase.ConnectDataBase;
import datafromserver.Message;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author phant
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private ConnectDataBase cdb;
    private PrintWriter pw;
    private BufferedReader br;

    public Server(ConnectDataBase cdb) {
        this.cdb = cdb;
    }

    public void serve() {

        try {
            ServerSocket serverSocket = new ServerSocket(1997);
            Socket socket = serverSocket.accept();
            pw = new PrintWriter(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {

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
                    } else if (data[1].equals("updateplayer")) {
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
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
