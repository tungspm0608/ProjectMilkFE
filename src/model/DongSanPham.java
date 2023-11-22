/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tung
 */
public class DongSanPham {
    private int maDongSanPham;
    private String tenDongSanPham;
    private String ghiChu;
    private boolean trangThai;

    public DongSanPham() {
    }

    public DongSanPham(int maDongSanPham, String tenDongSanPham, String ghiChu, boolean trangThai) {
        this.maDongSanPham = maDongSanPham;
        this.tenDongSanPham = tenDongSanPham;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getMaDongSanPham() {
        return maDongSanPham;
    }

    public void setMaDongSanPham(int maDongSanPham) {
        this.maDongSanPham = maDongSanPham;
    }

    public String getTenDongSanPham() {
        return tenDongSanPham;
    }

    public void setTenDongSanPham(String tenDongSanPham) {
        this.tenDongSanPham = tenDongSanPham;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
