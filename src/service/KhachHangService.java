/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.KhachHang;
import helper.DBContext;
import helper.XDate;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author dovan
 */
public class KhachHangService {

    public ArrayList<KhachHang> paging(int page, int limit, String sdt, String ten) {
        String sql = "select * from KhachHang where soDienThoai like ? and hoTen like ? order by maKhachHang"
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            pstm.setString(1,"%" + sdt + "%");
            pstm.setString(2,"%"+ ten + "%");
            ResultSet rs = pstm.executeQuery();
            ArrayList<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang x = new KhachHang();
                x.setMaKhachHang(rs.getInt(1));
                x.setTenKhachHang(rs.getString(2));
                x.setSoDienThoai(rs.getString(5));
                x.setNgaySinh(XDate.toString(rs.getDate(4), "dd-MM-yyyy"));
                x.setEmail(rs.getString(6));
                x.setGioiTinh(rs.getInt(3) == 1 ? "Nam" : "Nữ");
                x.setDiem(rs.getInt(7));
                x.setNgayTao(XDate.toString(rs.getDate(9), "dd-MM-yyyy"));
                x.setGhiChu(rs.getString(8));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insert(KhachHang x) {
        String sql = "INSERT INTO KhachHang (hoTen, gioiTinh, ngaySinh, soDienThoai, email, diem, ghiChu, ngayDangKy)\n"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTenKhachHang());
            pstm.setInt(2, x.getGioiTinh().equalsIgnoreCase("Nam") ? 1 : 0);
            pstm.setString(4, x.getSoDienThoai());
            pstm.setString(5, x.getEmail());
            pstm.setInt(6, x.getDiem());
            pstm.setString(7, x.getGhiChu());
            Date date = new Date(XDate.toDate(x.getNgaySinh(), "dd-MM-yyyy").getTime());
            pstm.setDate(3, date);
            date = new Date(XDate.toDate(x.getNgayTao(), "dd-MM-yyyy").getTime());
            pstm.setDate(8, date);
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer update(KhachHang x) {
        String sql = "update KhachHang set hoTen=?, gioiTinh=?, ngaySinh=?, soDienThoai=?, email=?, diem=?, ghiChu=?, ngayDangKy=? "
                + " where maKhachHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTenKhachHang());
            pstm.setInt(2, x.getGioiTinh().equalsIgnoreCase("Nam") ? 1 : 0);
            Date date = new Date(XDate.toDate(x.getNgaySinh(), "dd-MM-yyyy").getTime());
            pstm.setDate(3, date);
            pstm.setString(4, x.getSoDienThoai());
            pstm.setString(5, x.getEmail());
            pstm.setInt(6, x.getDiem());
            date = new Date(XDate.toDate(x.getNgayTao(), "dd-MM-yyyy").getTime());
            pstm.setDate(8, date);
            pstm.setString(7, x.getGhiChu());
            pstm.setInt(9, x.getMaKhachHang());
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer delete(String key) {
        String sql = "delete KhachHang where maKhachHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, key);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
