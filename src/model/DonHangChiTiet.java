/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dovan
 */
public class DonHangChiTiet {

    private int maDonHangChiTiet;
    private int maDonHang;
    private int maSanPhamChiTiet;
    private int soLuong;
    private float donGia;
    private float giaTriGiam;
    private String donViGiam;
    private float giaGiam;
    private float tongGia;
    private boolean trangThai;
    private int traHang;

    public DonHangChiTiet() {
    }

    public DonHangChiTiet(int maDonHangChiTiet, int maDonHang, int maSanPhamChiTiet, int soLuong, float donGia, float giaTriGiam, String donViGiam, float giaGiam, float tongGia, boolean trangThai) {
        this.maDonHangChiTiet = maDonHangChiTiet;
        this.maDonHang = maDonHang;
        this.maSanPhamChiTiet = maSanPhamChiTiet;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.giaTriGiam = giaTriGiam;
        this.donViGiam = donViGiam;
        this.giaGiam = giaGiam;
        this.tongGia = tongGia;
        this.trangThai = trangThai;
    }

    public int getMaDonHangChiTiet() {
        return maDonHangChiTiet;
    }

    public void setMaDonHangChiTiet(int maDonHangChiTiet) {
        this.maDonHangChiTiet = maDonHangChiTiet;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getMaSanPhamChiTiet() {
        return maSanPhamChiTiet;
    }

    public void setMaSanPhamChiTiet(int maSanPhamChiTiet) {
        this.maSanPhamChiTiet = maSanPhamChiTiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(float giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }

    public String getDonViGiam() {
        return donViGiam;
    }

    public void setDonViGiam(String donViGiam) {
        this.donViGiam = donViGiam;
    }

    public float getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(float giaGiam) {
        this.giaGiam = giaGiam;
    }

    public float getTongGia() {
        return tongGia;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getTraHang() {
        return traHang;
    }

    public void setTraHang(int traHang) {
        this.traHang = traHang;
    }
    
    
}
