/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;



/**
 *
 * @author Admin
 */
public class HoaDon {
    private int  maDonHang;
    private int maKhachHang ;
    private String maNhanVien ;
    private int maHinhThucThanhToan ;
    private boolean trangThai;
    private String ghiChu;
    private Date ngayTao;
    private float phiKhac;
    private float tongTien;
    private String loaiDonHang;
    private int soDienThoai;
    private String DiaChi;

    public HoaDon() {
    }

    public HoaDon(int maDonHang, int maKhachHang, String maNhanVien, int maHinhThucThanhToan, boolean trangThai, String ghiChu, Date ngayTao, float phiKhac, float tongTien, String loaiDonHang, int soDienThoai, String DiaChi) {
        this.maDonHang = maDonHang;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maHinhThucThanhToan = maHinhThucThanhToan;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.phiKhac = phiKhac;
        this.tongTien = tongTien;
        this.loaiDonHang = loaiDonHang;
        this.soDienThoai = soDienThoai;
        this.DiaChi = DiaChi;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaHinhThucThanhToan() {
        return maHinhThucThanhToan;
    }

    public void setMaHinhThucThanhToan(int maHinhThucThanhToan) {
        this.maHinhThucThanhToan = maHinhThucThanhToan;
    }

    public String isTrangThai() {
        if(trangThai ==true) return "Đã thanh toán";
        else return "Hủy đơn hàng";
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getPhiKhac() {
        return phiKhac;
    }

    public void setPhiKhac(float phiKhac) {
        this.phiKhac = phiKhac;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getLoaiDonHang() {
        return loaiDonHang;
    }

    public void setLoaiDonHang(String loaiDonHang) {
        this.loaiDonHang = loaiDonHang;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

}
