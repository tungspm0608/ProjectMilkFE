/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Tung
 */
public class SanPhamChiTiet {
    

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int maSanPhamChiTiet, int maSanPham, int maDonViTinh, String anhSanPham, Date hanSuDung, int soLuong, float giaNhap, float donGia, float khoiLuong, String donViTinhKhoiLuong, Date ngaySanXuat, String barcode, boolean trangThai) {
        this.maSanPhamChiTiet = maSanPhamChiTiet;
        this.maSanPham = maSanPham;
        this.maDonViTinh = maDonViTinh;
        this.anhSanPham = anhSanPham;
        this.hanSuDung = hanSuDung;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.donGia = donGia;
        this.khoiLuong = khoiLuong;
        this.donViTinhKhoiLuong = donViTinhKhoiLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.barcode = barcode;
        this.trangThai = trangThai;
    }

    public int getMaSanPhamChiTiet() {
        return maSanPhamChiTiet;
    }

    public void setMaSanPhamChiTiet(int maSanPhamChiTiet) {
        this.maSanPhamChiTiet = maSanPhamChiTiet;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaDonViTinh() {
        return maDonViTinh;
    }

    public void setMaDonViTinh(int maDonViTinh) {
        this.maDonViTinh = maDonViTinh;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(float khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getDonViTinhKhoiLuong() {
        return donViTinhKhoiLuong;
    }

    public void setDonViTinhKhoiLuong(String donViTinhKhoiLuong) {
        this.donViTinhKhoiLuong = donViTinhKhoiLuong;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
