/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import model.DongSanPham;
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
    
    public List<DongSanPham> getAll(){
        sql = "select * from DongSanPham";
        List<DongSanPham> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new DongSanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
