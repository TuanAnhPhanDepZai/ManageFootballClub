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
public class KeHoach {

    private int vongdau;
    private String diadiem;   // co phai san nha hay khong
    private String doithu;
    private String trangthai;   // da dau hay chua
    private String ngaydau;
    private String giaidau;

    public KeHoach(int vongdau, String giaidau, String ngaydau, String diadiem, String doithu, String trangthai) {
        this.vongdau = vongdau;
        this.diadiem = diadiem;
        this.doithu = doithu;
        this.trangthai = trangthai;
        this.ngaydau = ngaydau;
        this.giaidau = giaidau;
    }

    public int getVongdau() {
        return vongdau;
    }

    public void setVongdau(int vongdau) {
        this.vongdau = vongdau;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getDoithu() {
        return doithu;
    }

    public void setDoithu(String doithu) {
        this.doithu = doithu;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getNgaydau() {
        return ngaydau;
    }

    public void setNgaydau(String ngaydau) {
        this.ngaydau = ngaydau;
    }

    public String getGiaidau() {
        return giaidau;
    }

    public void setGiaidau(String giaidau) {
        this.giaidau = giaidau;
    }

  
}
