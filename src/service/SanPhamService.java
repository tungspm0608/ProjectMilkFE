/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import helper.XDate;
import model.LoaiHang;
import model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung
 */
public class SanPhamService {

    String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
     public SanPham searchById(String masp) {
        String sql = "select * from SanPham where maSanPham = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, masp);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSanPham(rs.getString("maSanPham"));
                x.setTenSanPham(rs.getString("tenSanPham"));
                x.setMoTa(rs.getString("moTa"));
                x.setMaThuongHieu(rs.getInt("maThuongHieu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setMaDongSanPham(rs.getInt("maDongSanPham"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SanPham> pagingByTen(int page, int limit, String ten, String trangThai) {
        String sql = "select * from SanPham "
                + "inner join SanPhamChiTiet on SanPham.maSanPham = SanPhamChiTiet.maSanPham "
                + "where tenSanPham like ? and SanPhamChiTiet.trangThai like ? order by SanPham.maSanPham "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ten + "%");
            pstm.setString(2, trangThai + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSanPham(rs.getString("maSanPham"));
                x.setTenSanPham(rs.getString("tenSanPham"));
                x.setMoTa(rs.getString("moTa"));
                x.setMaThuongHieu(rs.getInt("maThuongHieu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setMaDongSanPham(rs.getInt("maDongSanPham"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
