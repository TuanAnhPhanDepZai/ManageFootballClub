/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ConnectDataBase.ConnectDataBase;

/**
 *
 * @author phant
 */
public class RunServer {
    public static void main(String[] args) {
        ConnectDataBase connectDataBase = new ConnectDataBase();
        new Server(connectDataBase);
    }
}
