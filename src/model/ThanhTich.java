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
public class ThanhTich {
    
    private int nam ;
    private String giaidau ;
    private String thanhtich ;

    public ThanhTich(int nam, String giaidau, String thanhtich) {
        this.nam = nam;
        this.giaidau = giaidau;
        this.thanhtich = thanhtich;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getGiaidau() {
        return giaidau;
    }

    public void setGiaidau(String giaidau) {
        this.giaidau = giaidau;
    }

    public String getThanhtich() {
        return thanhtich;
    }

    public void setThanhtich(String thanhtich) {
        this.thanhtich = thanhtich;
    }
    
    
}
