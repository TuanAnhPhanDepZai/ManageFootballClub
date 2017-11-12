/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author phant
 */
public class player {
    private String ID ;
    private String name ;
    private String adress ;
    private String position;
    private int tuoi ;
    private int  luong ;

    public player(String ID, String name, String position, String adress, int tuoi, int  luong) {
        this.ID = ID;
        this.name = name;
        this.adress = adress;
        this.position = position;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int  luong) {
        this.luong = luong;
    }
    
    
}
