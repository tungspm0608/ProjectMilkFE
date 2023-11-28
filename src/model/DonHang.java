/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author dovan
 */
public class DonHang {
    private int maDonHang;
    private int maKhachHang;
    private String maNhanVien;
    private int maHHTT;
    private int trangThai;
    private String ghiChu;
    private String ngayTao;
    private float phiKhac;
    private float tienGiam;
    private float tienHang;
    private float tongTien;
    private int loaiDonHang;
    private String dienThoai;
    private String diaChi;

    public DonHang() {
    }

    public DonHang(int maDonHang, int maKhachHang, String maNhanVien, int maHHTT, int trangThai, String ghiChu, String ngayTao, float phiKhac, float tienGiam, float tienHang, float tongTien, int loaiDonHang, String dienThoai, String diaChi) {
        this.maDonHang = maDonHang;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maHHTT = maHHTT;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.phiKhac = phiKhac;
        this.tienGiam = tienGiam;
        this.tienHang = tienHang;
        this.tongTien = tongTien;
        this.loaiDonHang = loaiDonHang;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
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

    public int getMaHHTT() {
        return maHHTT;
    }

    public void setMaHHTT(int maHHTT) {
        this.maHHTT = maHHTT;
    }

    public int isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getPhiKhac() {
        return phiKhac;
    }

    public void setPhiKhac(float phiKhac) {
        this.phiKhac = phiKhac;
    }

    public int isLoaiDonHang() {
        return loaiDonHang;
    }

    public void setLoaiDonHang(int loaiDonHang) {
        this.loaiDonHang = loaiDonHang;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(float tienGiam) {
        this.tienGiam = tienGiam;
    }

    public float getTienHang() {
        return tienHang;
    }

    public void setTienHang(float tienHang) {
        this.tienHang = tienHang;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getLoaiDonHang() {
        return loaiDonHang;
    }
    
}
