/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Helper.DBContext;
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
        sql = "SanPham.maSanPham, \n" +
"			tenSanPham, \n" +
"			LoaiHang.tenLoaiHang, \n" +
"			DongSanPham.tenDongSanPham,\n" +
"			SanPhamChiTiet.hanSuDung,\n" +
"			SanPhamChiTiet.soLuong,\n" +
"			SanPhamChiTiet.donGia,\n" +
"			XuatXu.tenXuatXu,\n" +
"			CONVERT(nvarchar,SanPhamChiTiet.khoiLuong) + SanPhamChiTiet.donViTinhKhoiLuong as'Khoi Luong',\n" +
"			DonViTinh.tenDonViTinh,\n" +
"			SanPhamChiTiet.barcode,\n" +
"			SanPham.ghiChu,\n" +
"			SanPhamChiTiet.AnhSanPham\n" +
"	from SanPham\n" +
"		join LoaiHang on SanPham.maLoaiHang = LoaiHang.maLoaiHang\n" +
"		join DongSanPham on DongSanPham.maDongSanPham = SanPham.maDongSanPham\n" +
"		join SanPhamChiTiet on SanPhamChiTiet.maSanPham = SanPham.maSanPham\n" +
"		join XuatXu on XuatXu.maXuatXu = SanPham.maXuatXu\n" +
"		join DonViTinh on SanPhamChiTiet.maDonViTinh = DonViTinh.maDonViTinh";
        List<SanPham> list = new ArrayList<>();
        
        try {
            con = DBContext.getConnection();
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
