/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import model.SanPham;
import model.ThuongHieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung
 */
public class ThuongHieuService {
         String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<ThuongHieu> getAll(){
        sql = "select * from ThuongHieu";
        List<ThuongHieu> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new ThuongHieu(
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
        sql = "Insert into ThuongHieu values (?,?,1)";
        
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
    
    public SanPham CheckXoa(int MaTH) {
        sql = "select * from SanPham where maThuongHieu = ?";
        List<SanPham> list = new ArrayList<>();

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaTH);
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
     public int add(ThuongHieu th){
        sql = "insert into ThuongHieu values (?,?,?)";
   
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, th.getTenThuongHieu());
            ps.setObject(2, th.getGhiChu());
            ps.setObject(3, th.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }        
    }
    
    public int update(ThuongHieu th, int MaTH){
        sql = "Update ThuongHieu SET tenThuongHieu = ?, GhiChu = ?,trangThai = ? where maThuongHieu = ?";
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, th.getTenThuongHieu());
            ps.setObject(2, th.getGhiChu());
            ps.setObject(3, th.getTrangThai());
            ps.setObject(4, MaTH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete(int MaTH){
        sql = "Delete from ThuongHieu where maThuongHieu = ?";
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaTH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public List<ThuongHieu> getByName(String Name){
        sql = "Select * from ThuongHieu where tenThuongHieu like ?";
        List<ThuongHieu> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, Name + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ThuongHieu(
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
    
    public ThuongHieu findByID(int id){
        sql = "select * from ThuongHieu where maThuongHieu = ?";
        List<ThuongHieu> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id );
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new ThuongHieu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
}
