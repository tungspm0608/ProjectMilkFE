/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import model.DongSanPham;
import model.SanPham;
import model.XuatXu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung
 */
public class DongSanPhamService {

    String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<DongSanPham> getAll() {
        sql = "select * from DongSanPham";
        List<DongSanPham> list = new ArrayList<>();

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new DongSanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (String t, String g) {
        sql = "Insert into DongSanPham values (?,?,1)";
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, t);
            ps.setObject(2, g);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public SanPham CheckXoa(int MaDSP) {
        sql = "select * from SanPham where maDongSanPham = ?";
        List<SanPham> list = new ArrayList<>();

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaDSP);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SanPham(rs.getString("maSanPham")));
            }

            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int add(DongSanPham dsp) {
        sql = "insert into DongSanPham values (?,?,?)";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dsp.getTenDongSanPham());
            ps.setObject(2, dsp.getGhiChu());
            ps.setObject(3, dsp.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(DongSanPham dsp, int MaDSP) {
        sql = "Update DongSanPham SET tenDongSanPham = ?, GhiChu = ?,trangThai = ? where maDongSanPham = ?";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dsp.getTenDongSanPham());
            ps.setObject(2, dsp.getGhiChu());
            ps.setObject(3, dsp.getTrangThai());
            ps.setObject(4, MaDSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int MaDSP) {
        sql = "Delete from DongSanPham where maDongSanPham = ?";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaDSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public DongSanPham findByID(int id) {
        sql = "select * from DongSanPham where maDongSanPham = ?";
        List<DongSanPham> list = new ArrayList<>();

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new DongSanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }

            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
