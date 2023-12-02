/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import model.DonViTinh;
import model.SanPham;
import model.XuatXu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tung
 */
public class DonViTinh_service {
     String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<DonViTinh> getAll(){
        sql = "select * from DonViTinh";
        List<DonViTinh> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new DonViTinh(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getBoolean(4)));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (String t, String g) {
        sql = "Insert into DonViTinh values (?,?,1)";
        
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
    
    public SanPham CheckXoa(int MaDVT) {
        sql = "select * from SanPham \n"
                + "join SanPhamChiTiet on SanPham.maSanPham = SanPhamChiTiet.maSanPham\n"
                + "join DonViTinh on SanPhamChiTiet.maDonViTinh = DonViTinh.maDonViTinh\n"
                + "where DonViTinh.maDonViTinh =?";
        List<SanPham> list = new ArrayList<>();

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaDVT);
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

    public DonViTinh getByID(int ID) {
        sql = "select * from DonViTinh where maDonViTinh = ?";
        List<DonViTinh> list = new ArrayList<>();

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new DonViTinh(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4)));
            }

            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int add(DonViTinh dvt) {
        sql = "insert into DonViTinh values (?,?,?)";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dvt.getTenDonViTinh());
            ps.setObject(2, dvt.getGhiChu());
            ps.setObject(3, dvt.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(DonViTinh dvt, int MaDVT) {
        sql = "Update DonViTinh SET tenDonViTinh = ?, GhiChu = ?,trangThai = ? where maDonViTinh = ?";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dvt.getTenDonViTinh());
            ps.setObject(2, dvt.getGhiChu());
            ps.setObject(3, dvt.getTrangThai());
            ps.setObject(4, MaDVT);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int MaDVT) {
        sql = "Delete from DonViTinh where maDonViTinh = ?";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaDVT);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public DonViTinh findByID(int id){
        sql = "select * from DonViTinh where maDonViTinh = ?";
        List<DonViTinh> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id );
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new DonViTinh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    
}
