/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Helper.DBContext;
import Model.ThuongHieu;
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
        sql = "exec Select_SanPham";
        List<ThuongHieu> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new ThuongHieu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(3)));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
