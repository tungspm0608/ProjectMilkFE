/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tung
 */
public class LoaiHang {
    private int maLoaiHang;
    private String tenLoaiHang;
    private String ghiChu;
    private int trangThai;

    public LoaiHang() {
    }

    public LoaiHang(int maLoaiHang, String tenLoaiHang, String ghiChu, int trangThai) {
        this.maLoaiHang = maLoaiHang;
        this.tenLoaiHang = tenLoaiHang;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(int maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public String getTenLoaiHang() {
        return tenLoaiHang;
    }

    public void setTenLoaiHang(String tenLoaiHang) {
        this.tenLoaiHang = tenLoaiHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
