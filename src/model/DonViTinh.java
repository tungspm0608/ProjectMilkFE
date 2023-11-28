/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tung
 */
public class DonViTinh {
    private int maDonViTinh;
    private String tenDonViTinh;
    private String ghiChu;
    private boolean trangThai;

    public DonViTinh() {
    }

    public DonViTinh(int maDonViTinh, String tenDonViTinh, String ghiChu, boolean trangThai) {
        this.maDonViTinh = maDonViTinh;
        this.tenDonViTinh = tenDonViTinh;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getMaDonViTinh() {
        return maDonViTinh;
    }

    public void setMaDonViTinh(int maDonViTinh) {
        this.maDonViTinh = maDonViTinh;
    }

    public String getTenDonViTinh() {
        return tenDonViTinh;
    }

    public void setTenDonViTinh(String tenDonViTinh) {
        this.tenDonViTinh = tenDonViTinh;
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

    @Override
    public String toString() {
        return tenDonViTinh;
    }
    
    
}
