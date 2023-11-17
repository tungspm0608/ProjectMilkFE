/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Helper.DBContext;
import Model.SanPhamChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung
 */
public class SanPhamChiTietService {
         String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<SanPhamChiTiet> getAll(){
        sql = "select * from SanPhamChiTiet";
        List<SanPhamChiTiet> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                list.add(new SanPhamChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getString(10), rs.getDate(11), rs.getString(12), rs.getInt(13)));
            }           
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
