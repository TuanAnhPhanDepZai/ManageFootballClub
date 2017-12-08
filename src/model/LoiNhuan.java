/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tuan Anh
 */
public class LoiNhuan {
    private int nam ;
    private int quy ;
    private String name ;
    private int giatri;

    public LoiNhuan(int nam, int quy, String name, int giatri) {
        this.nam = nam;
        this.quy = quy;
        this.name = name;
        this.giatri = giatri;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getQuy() {
        return quy;
    }

    public void setQuy(int quy) {
        this.quy = quy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGiatri() {
        return giatri;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
    }
    
    
}
