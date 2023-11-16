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
    private String moTa;
    private boolean trangThai; // kinh doanh or ngung kinh doanh
    private int maThuongHieu;
    private int maLoaiHang;
    private int maDongSanPham;
    private int maXuatXu;

    public SanPham() {
    }

    public SanPham(int maSanPham, String tenSanPham, String moTa, boolean trangThai, int maThuongHieu, int maLoaiHang, int maDongSanPham, int maXuatXu) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.maThuongHieu = maThuongHieu;
        this.maLoaiHang = maLoaiHang;
        this.maDongSanPham = maDongSanPham;
        this.maXuatXu = maXuatXu;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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
    
    
}
