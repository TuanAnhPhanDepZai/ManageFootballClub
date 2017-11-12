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
public class LanhDao {
    private String ID ;
    private String name ;
    private int tuoi ;
    private String position ;
    private int luong ;

    public LanhDao(String ID, String name, String position, int luong) {
        this.ID = ID;
        this.name = name;
      
        this.position = position;
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

    
   

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
    
}
