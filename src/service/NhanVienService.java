/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.NhanVien;
import helper.DBContext;
import helper.XDate;
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
            pstm.setString(2, "%" + ten + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                NhanVien x = new NhanVien();
                x.setMaNhanVien(rs.getString(1));
                x.setMatKhau(rs.getString(2));
                x.setTenNhanVien(rs.getString(3));
                x.setGioiTinh(rs.getInt(4) == 1 ? "Nam" : "Nữ");
                x.setNgaySinh(XDate.toString(rs.getDate(5), "dd-MM-yyyy"));
                x.setSoDienThoai(rs.getString(6));
                x.setEmail(rs.getString(7));
                x.setAnhNhanVien(rs.getString(8));
                x.setVaiTro(rs.getInt(9) == 1 ? "Quản lý" : "Nhân Viên");
                x.setTrangThai(rs.getInt(10) == 1 ? "Đang làm" : "Nghỉ việc");
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
        String sql = "insert into NhanVien(maNhanVien,matKhau,hoTen,hinhAnh,soDienThoai,"
                + "ngaySinh,gioiTinh,email,vaiTro,trangThai,ghiChu) values(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getMaNhanVien());
            pstm.setString(2, x.getMatKhau());
            pstm.setString(3, x.getTenNhanVien());
            pstm.setString(4, x.getAnhNhanVien());
            pstm.setString(5, x.getSoDienThoai());
            Date date = new Date(XDate.toDate(x.getNgaySinh(), "dd-MM-yyyy").getTime());
            pstm.setDate(6, date);
            pstm.setInt(7, x.getGioiTinh().equalsIgnoreCase("nam") ? 1 : 0);
            pstm.setString(8, x.getEmail());
            pstm.setInt(9, x.getVaiTro().equalsIgnoreCase("Quản lý") ? 1 : 0);
            pstm.setInt(10, x.getTrangThai().equalsIgnoreCase("Đang làm") ? 1 : 0);
            pstm.setString(11, x.getGhiChu());
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    public Integer update(NhanVien x) {
        String sql = "update NhanVien set matKhau=?,hoTen=?,hinhAnh=?,soDienThoai=?,"
                + "ngaySinh=?,gioiTinh=?,email=?,vaiTro=?,trangThai=?,ghiChu=? where maNhanVien=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(11, x.getMaNhanVien());
            pstm.setString(1, x.getMatKhau());
            pstm.setString(2, x.getTenNhanVien());
            pstm.setString(3, x.getAnhNhanVien());
            pstm.setString(4, x.getSoDienThoai());
            Date date = new Date(XDate.toDate(x.getNgaySinh(), "dd-MM-yyyy").getTime());
            pstm.setDate(5, date);
            pstm.setInt(6, x.getGioiTinh().equalsIgnoreCase("nam") ? 1 : 0);
            pstm.setString(7, x.getEmail());
            pstm.setInt(8, x.getVaiTro().equalsIgnoreCase("Quản lý") ? 1 : 0);
            pstm.setInt(9, x.getTrangThai().equalsIgnoreCase("Đang làm") ? 1 : 0);
            pstm.setString(10, x.getGhiChu());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int dangNhap(String taiKhoan, String matKhau) {
        String checkTK = "select * from NhanVien where maNhanVien = ?";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(checkTK);
            pstm.setString(1, taiKhoan);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Dung tai khoan");
                //Dung tai khoan
                if (matKhau.equalsIgnoreCase(rs.getString(2))) {
                    // Dung mat khau
                    System.out.println("Dung mat khau");
                    if (rs.getInt(10) == 1) {
                        //Trang thai dang lam viec
                        NhanVien x = new NhanVien();
                        x.setMaNhanVien(rs.getString(1));
                        x.setMatKhau(rs.getString(2));
                        x.setTenNhanVien(rs.getString(3));
                        x.setGioiTinh(rs.getInt(4) == 1 ? "Nam" : "Nữ");
                        x.setNgaySinh(XDate.toString(rs.getDate(5), "dd-MM-yyyy"));
                        x.setSoDienThoai(rs.getString(6));
                        x.setEmail(rs.getString(7));
                        x.setAnhNhanVien(rs.getString(8));
                        x.setVaiTro(rs.getInt(9) == 1 ? "Quản lý" : "Nhân Viên");
                        x.setTrangThai(rs.getInt(10) == 1 ? "Đang làm" : "Nghỉ việc");
                        x.setGhiChu(rs.getString(11));
                        Auth.user = x;
                        //Dang nhap thanh cong
                        return 3;
                    } else {
                        //Trang thai nghi viec
                        System.out.println("nghi vc");
                        return 2;
                    }
                }
                System.out.println("sai mat khau");
                return 1;
//                Sai mat khau
            } else {
                System.out.println("sai tai khoan");
                return 0;
                //Sai tai khoan
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("chua chay ma da dang nhap");
        return 3;
    }

    public NhanVien searchNVByMaNV(String maNV) {
        String checkTK = "select * from NhanVien where maNhanVien = ?";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement pstm = con.prepareStatement(checkTK);
            pstm.setString(1, maNV);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien x = new NhanVien();
                x.setMaNhanVien(rs.getString(1));
                x.setMatKhau(rs.getString(2));
                x.setTenNhanVien(rs.getString(3));
                x.setGioiTinh(rs.getInt(4) == 1 ? "Nam" : "Nữ");
                x.setNgaySinh(XDate.toString(rs.getDate(5), "dd-MM-yyyy"));
                x.setSoDienThoai(rs.getString(6));
                x.setEmail(rs.getString(7));
                x.setAnhNhanVien(rs.getString(8));
                x.setVaiTro(rs.getInt(9) == 1 ? "Quản lý" : "Nhân Viên");
                x.setTrangThai(rs.getInt(10) == 1 ? "Đang làm" : "Nghỉ việc");
                x.setGhiChu(rs.getString(11));
                return x;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int doiMatKhau(String maNhanVien, String matKhau) {
        String sql = "update NhanVien set matKhau = ? where maNhanVien = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, matKhau);
            pstm.setString(2, maNhanVien);
            int res = pstm.executeUpdate();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
