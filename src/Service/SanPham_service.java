/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.LoaiHang;
import Model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tung
 */
public class SanPham_service {
    String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<SanPham> getAll(){
        sql = "exec Select_SanPham";
        List<SanPham> list = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int maSanPham = rs.getInt(1);
                String tenSanPham = rs.getString(2);
                LoaiHang lh = new LoaiHang()
                list.add();
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
