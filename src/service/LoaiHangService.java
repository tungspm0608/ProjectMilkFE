/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import model.LoaiHang;
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
public class LoaiHangService {
    String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<LoaiHang> getAll(){
        sql = "select * from LoaiHang";
        List<LoaiHang> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new LoaiHang(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public int insert (String t, String g) {
        sql = "Insert into LoaiHang values (?,?,1)";
        
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
    
     public SanPham CheckXoa(int MaLH) {
        sql = "select * from SanPham where maLoaiHang = ?";
        List<SanPham> list = new ArrayList<>();

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaLH);
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
     public int add(LoaiHang lh){
        sql = "insert into LoaiHang values (?,?,?)";
   
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, lh.getTenLoaiHang());
            ps.setObject(2, lh.getGhiChu());
            ps.setObject(3, lh.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }        
    }
    
    public int update(LoaiHang lh, int MaLH){
        sql = "Update LoaiHang SET tenLoaiHang = ?, GhiChu = ?,trangThai = ? where maLoaiHang = ?";
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, lh.getTenLoaiHang());
            ps.setObject(2, lh.getGhiChu());
            ps.setObject(3, lh.getTrangThai());
            ps.setObject(4, MaLH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete(int MaLH){
        sql = "Delete from LoaiHang where maLoaiHang = ?";
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaLH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public LoaiHang findByID(int id){
        sql = "select * from LoaiHang where maLoaiHang = ?";
        List<LoaiHang> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id );
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new LoaiHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
