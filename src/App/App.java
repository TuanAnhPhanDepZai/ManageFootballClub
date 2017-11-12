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

/**
 *
 * @author phant
 */
public class App {

    public static void main(String[] args) {
        Client client = new Client();
        ClientThread clientThread = new ClientThread(client.getBr(),new MainView());
        client.getPw().println("tuan anh");
        client.getPw().flush();
        Scanner scanner = new Scanner(System.in);
          while(true){
        String s = scanner.nextLine();
        client.getPw().println(s);
        client.getPw().flush();
    }
    }
}
