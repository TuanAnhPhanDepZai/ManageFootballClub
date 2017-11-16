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
   // class Server chi lam nhiem vu mo cong ket noi 1997 , 
    // mo 1 vong lap vo han while de thiet lap cac ket noi tu client
    private ServerSocket serverSocket;
    private Socket socket;
    private ConnectDataBase cdb;
    private PrintWriter pw;
    private BufferedReader br;

    public Server(ConnectDataBase cdb) {
        this.cdb = cdb;
        serve();
    }

    public void serve() {   
        try {
            ServerSocket serverSocket = new ServerSocket(1997);
            System.out.println("Da mo cong ket noi cho Client");
            while (true){
                socket = serverSocket.accept();
                new ServerThread(socket, cdb);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
