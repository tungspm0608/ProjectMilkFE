/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Helper.DBContext;
import Helper.XDate;
import Model.SanPham;
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
    
    public ArrayList<SanPhamChiTiet> pagingByTen(int page, int limit, String ten, String trangThai) {
        String sql = "select * from SanPhamChiTiet "
                + "inner join SanPham on SanPham.maSanPham = SanPhamChiTiet.maSanPham "
                + "where SanPham.tenSanPham like ? and SanPhamChiTiet.trangThai like ? order by SanPham.maSanPham "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ten + "%");
            pstm.setString(2, trangThai + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPhamChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSanPham(rs.getInt("maSanPham"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setMaDonViTinh(rs.getInt("maDonViTinh"));
                x.setAnhSanPham(rs.getString("AnhSanPham"));
                x.setHanSuDung(XDate.toString(rs.getDate("hanSuDung"),"dd-MM-yyyy"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setDonGia(rs.getFloat("donGia"));
                x.setKhoiLuong(rs.getFloat("khoiLuong"));
                x.setDonViTinhKhoiLuong(rs.getString("donViTinhKhoiLuong"));
                x.setNgaySanXuat(XDate.toString(rs.getDate("ngaySanXuat"), "dd-MM-yyyy"));
                x.setBarcode(rs.getString("barcode"));
                x.setTrangThai(rs.getInt("trangThai")==1?true:false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
