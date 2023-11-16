/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import Until.DBContext;
import Until.XDate;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author dovan
 */
public class NhanVienService {

    public ArrayList<NhanVien> paging(int page, int limit, String sdt, String ten) {
        String sql = "select * from NhanVien where soDienThoai like ? and hoTen like ? order by maNhanVien "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, sdt + "%");
            pstm.setString(2, ten + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                NhanVien x = new NhanVien();
                x.setMaNhanVien(rs.getString(1));
                x.setMatKhau(rs.getString(2));
                x.setTenNhanVien(rs.getString(3));
                x.setGioiTinh(rs.getInt(4)==1?"Nam":"Nữ");
                x.setNgaySinh(XDate.toString(rs.getDate(5),"dd-MM-yyyy"));
                x.setSoDienThoai(rs.getString(6));
                x.setEmail(rs.getString(7));
                x.setAnhNhanVien(rs.getString(8));
                x.setVaiTro(rs.getInt(9)==1?"Quản lý":"Nhân Viên");
                x.setTrangThai(rs.getInt(10)==1?"Đang làm":"Nghỉ việc");
                x.setGhiChu(rs.getString(11));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insert(NhanVien x) {
        String sql = "insert into NhanVien(maNhanVien,matKhau,tenNhanVien,anhNhanVien,soDienThoai,"
                + "ngaySinh,gioiTinh,diaChi,email,vaiTro,trangThai,ngayTao) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getMaNhanVien());
            pstm.setString(2, x.getMatKhau());
            pstm.setString(3, x.getTenNhanVien());
            pstm.setString(4, x.getAnhNhanVien());
            pstm.setString(5, x.getSoDienThoai());
            pstm.setString(6, x.getNgaySinh());
            pstm.setInt(7, x.getGioiTinh().equalsIgnoreCase("nam") ? 1 : 0);
            
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
    }

    public Integer update(NhanVien x) {
        String sql = "update NhanVien set matKhau=?,tenNhanVien=?,anhNhanVien=?,soDienThoai=?,"
                + "ngaySinh=?,gioiTinh=?,diaChi=?,email=?,vaiTro=?,trangThai=? where maNhanVien=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(11, x.getMaNhanVien());
            pstm.setString(1, x.getMatKhau());
            pstm.setString(2, x.getTenNhanVien());
            pstm.setString(3, x.getAnhNhanVien());
            pstm.setString(4, x.getSoDienThoai());
           
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer delete(String key) {
        String sql = "delete NhanVien where maNhanVien=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, key);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
