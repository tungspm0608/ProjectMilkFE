/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
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
public class XuatXuService {
    String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<XuatXu> getAll(){
        sql = "select * from XuatXu";
        List<XuatXu> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new XuatXu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public List<XuatXu> getByName(String Name){
        sql = "select * from XuatXu where tenXuatXu like ?";
        List<XuatXu> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, Name + "%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new XuatXu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public XuatXu findByID(int id){
        sql = "select * from XuatXu where maXuatXu = ?";
        List<XuatXu> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id );
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new XuatXu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public int update(XuatXu xx, int MaXX){
        sql = "Update XuatXu SET trangThai = ? where maXuatXu = ?";
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xx.getTrangThai());
            ps.setObject(2, MaXX);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int insert(String t, String g) {
        sql = "Insert into XuatXu values (?,?,1)";
        
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
}
