/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class KhuyenMai {
    private String maKhuyenMai ;
    private String tenChuongTrinh ;
    private String ngayBatDau ;
    private String ngayKetThuc;
    private String moTa ;
    private int trangThai;
    private String donViGiam;
    private int giatriGiam;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKhuyenMai, String tenChuongTrinh, String ngayBatDau, String ngayKetThuc, String moTa, int trangThai, String donViGiam, int giatriGiam) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenChuongTrinh = tenChuongTrinh;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.donViGiam = donViGiam;
        this.giatriGiam = giatriGiam;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getDonViGiam() {
        return donViGiam;
    }

    public void setDonViGiam(String donViGiam) {
        this.donViGiam = donViGiam;
    }

    public int getGiatriGiam() {
        return giatriGiam;
    }

    public void setGiatriGiam(int giatriGiam) {
        this.giatriGiam = giatriGiam;
    }

    public String TrangThai(){
        if (getTrangThai() == 1) {
            return "Cho phép hoạt động";
        } else  {
            return "Ngừng hoạt động";
        }
    }
//    public String getStatusTrangThai(){
//         if (getTrangThai() == 1) {
//            return "Đang hoạt động";
//        } else if(getTrangThai() == 0)  {
//            return "Đã kết thúc";
//        }else{
//            return "Chưa diễn ra";
//        }
//    }
}
