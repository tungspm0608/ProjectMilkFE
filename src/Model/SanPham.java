/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tung
 */
public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private String moTa;// kinh doanh or ngung kinh doanh
    private int maThuongHieu;
    private int maLoaiHang;
    private int maDongSanPham;
    private int maXuatXu;
    private String ghiChu;
    private int maSanPhamChiTiet;
    private int maDonViTinh;
    private String anhSanPham;
    private String hanSuDung;
    private int soLuong;
    private float giaNhap;
    private float donGia;
    private float khoiLuong;
    private String donViTinhKhoiLuong;
    private String ngaySanXuat;
    private String barcode;
    private String trangThai;

    public SanPham() {
    }

    public SanPham(int maSanPham, String tenSanPham, String moTa, int maThuongHieu, int maLoaiHang, int maDongSanPham, int maXuatXu, String ghiChu, int maSanPhamChiTiet, int maDonViTinh, String anhSanPham, String hanSuDung, int soLuong, float giaNhap, float donGia, float khoiLuong, String donViTinhKhoiLuong, String ngaySanXuat, String barcode, String trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.maThuongHieu = maThuongHieu;
        this.maLoaiHang = maLoaiHang;
        this.maDongSanPham = maDongSanPham;
        this.maXuatXu = maXuatXu;
        this.ghiChu = ghiChu;
        this.maSanPhamChiTiet = maSanPhamChiTiet;
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

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(int maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public int getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(int maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public int getMaDongSanPham() {
        return maDongSanPham;
    }

    public void setMaDongSanPham(int maDongSanPham) {
        this.maDongSanPham = maDongSanPham;
    }

    public int getMaXuatXu() {
        return maXuatXu;
    }

    public void setMaXuatXu(int maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaSanPhamChiTiet() {
        return maSanPhamChiTiet;
    }

    public void setMaSanPhamChiTiet(int maSanPhamChiTiet) {
        this.maSanPhamChiTiet = maSanPhamChiTiet;
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

    public String getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
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

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
}
