/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import helper.XDate;
import model.SanPham;
import model.SanPhamChiTiet;
import java.sql.Connection;
import java.sql.Date;
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
            pstm.setString(1,"%"+ ten + "%");
            pstm.setString(2, trangThai + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPhamChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSanPham(rs.getString("maSanPham"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setMaDonViTinh(rs.getInt("maDonViTinh"));
                x.setAnhSanPham(rs.getString("AnhSanPham"));
                x.setHanSuDung(XDate.toString(rs.getDate("hanSuDung"), "dd-MM-yyyy"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setDonGia(rs.getFloat("donGia"));
                x.setKhoiLuong(rs.getFloat("khoiLuong"));
                x.setDonViTinhKhoiLuong(rs.getString("donViTinhKhoiLuong"));
                x.setNgaySanXuat(XDate.toString(rs.getDate("ngaySanXuat"), "dd-MM-yyyy"));
                x.setBarcode(rs.getString("barcode"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<SanPhamChiTiet> searchSPCTByKM(int page, int limit, String ten, String trangThai) {
        String sql = "select * from SanPhamChiTiet "
                + "inner join SanPham on SanPham.maSanPham = SanPhamChiTiet.maSanPham "
                + "where SanPham.tenSanPham like ? and SanPhamChiTiet.trangThai like ?"
                + " and maSanPhamChiTiet not in (select maSanPhamChiTiet from KhuyenMaiSanPham) order by SanPhamChiTiet.maSanPhamChiTiet "
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
                x.setMaSanPham(rs.getString("maSanPham"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setMaDonViTinh(rs.getInt("maDonViTinh"));
                x.setAnhSanPham(rs.getString("AnhSanPham"));
                x.setHanSuDung(XDate.toString(rs.getDate("hanSuDung"), "dd-MM-yyyy"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setDonGia(rs.getFloat("donGia"));
                x.setKhoiLuong(rs.getFloat("khoiLuong"));
                x.setDonViTinhKhoiLuong(rs.getString("donViTinhKhoiLuong"));
                x.setNgaySanXuat(XDate.toString(rs.getDate("ngaySanXuat"), "dd-MM-yyyy"));
                x.setBarcode(rs.getString("barcode"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertSP(SanPham x) {
        String sql = "INSERT INTO SanPham (maSanPham,tenSanPham, moTa, trangThai, maThuongHieu, maLoaiHang, maDongSanPham, maXuatXu) \n"
                + "VALUES(?,?,?, ?, ?, ?, ?, ?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getMaSanPham());
            pstm.setString(2, x.getTenSanPham());
            pstm.setString(3, x.getMoTa());
            pstm.setInt(4, 1);
            pstm.setInt(5, x.getMaThuongHieu());
            pstm.setInt(6, x.getMaLoaiHang());
            pstm.setInt(7, x.getMaDongSanPham());
            pstm.setInt(8, x.getMaXuatXu());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateSP(SanPham x) {
        String sql = "update SanPham set tenSanPham=?, moTa=?, trangThai=?, maThuongHieu=?, maLoaiHang=?, maDongSanPham=?, maXuatXu=? \n"
                + "where maSanPham = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(8, x.getMaSanPham());
            pstm.setString(1, x.getTenSanPham());
            pstm.setString(2, x.getMoTa());
            pstm.setInt(3, 1);
            pstm.setInt(4, x.getMaThuongHieu());
            pstm.setInt(5, x.getMaLoaiHang());
            pstm.setInt(6, x.getMaDongSanPham());
            pstm.setInt(7, x.getMaXuatXu());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertSPCT(SanPham sp, SanPhamChiTiet spct) {
        if (searchByIdSP(spct.getMaSanPham()) == null) {
            insertSP(sp);
        }
        String sql = "INSERT INTO SanPhamChiTiet (maSanPham, maDonViTinh, AnhSanPham, hanSuDung, soLuong, giaNhap, donGia, khoiLuong, donViTinhKhoiLuong, ngaySanXuat, barcode, trangThai)\n"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?, ?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setString(1, sp.getMaSanPham());
            pstm.setInt(2, spct.getMaDonViTinh());
            pstm.setString(3, spct.getAnhSanPham());
            Date date = new Date(XDate.toDate(spct.getHanSuDung(), "dd-MM-yyyy").getTime());
            pstm.setDate(4, date);
            pstm.setInt(5, spct.getSoLuong());
            pstm.setFloat(6, spct.getGiaNhap());
            pstm.setFloat(7, spct.getDonGia());
            pstm.setFloat(8, spct.getKhoiLuong());
            pstm.setString(9, spct.getDonViTinhKhoiLuong());
            date = new Date(XDate.toDate(spct.getNgaySanXuat(), "dd-MM-yyyy").getTime());
            pstm.setDate(10, date);
            pstm.setString(11, spct.getBarcode());
            pstm.setInt(12, 1);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateSPCT(SanPham sp, SanPhamChiTiet spct) {
        if (sp.getMaSanPham() != null) {
            updateSP(sp);
        }
        String sql = "update SanPhamChiTiet set maDonViTinh=?, AnhSanPham=?, hanSuDung=?, soLuong=?, giaNhap=?,"
                + " donGia=?, khoiLuong=?, donViTinhKhoiLuong=?, ngaySanXuat=?, barcode=?, trangThai=? \n"
                + " where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setInt(12, spct.getMaSanPhamChiTiet());
            pstm.setInt(1, spct.getMaDonViTinh());
            pstm.setString(2, spct.getAnhSanPham());
            Date date = new Date(XDate.toDate(spct.getHanSuDung(), "dd-MM-yyyy").getTime());
            pstm.setDate(3, date);
            pstm.setInt(4, spct.getSoLuong());
            pstm.setFloat(5, spct.getGiaNhap());
            pstm.setFloat(6, spct.getDonGia());
            pstm.setFloat(7, spct.getKhoiLuong());
            pstm.setString(8, spct.getDonViTinhKhoiLuong());
            date = new Date(XDate.toDate(spct.getNgaySanXuat(), "dd-MM-yyyy").getTime());
            pstm.setDate(9, date);
            pstm.setString(10, spct.getBarcode());
            pstm.setInt(11, spct.getTrangThai() ? 1 : 0);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer deleteSPCT(int maspct) {
        String sql = "delete SanPhamChiTiet where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maspct);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham searchByIdSP(String masp) {
        String sql = "select * from SanPham where maSanPham = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, masp);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSanPham(rs.getString("maSanPham"));
                x.setTenSanPham(rs.getString("tenSanPham"));
                x.setMoTa(rs.getString("moTa"));
                x.setMaThuongHieu(rs.getInt("maThuongHieu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setMaDongSanPham(rs.getInt("maDongSanPham"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                list.add(x);
            }
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPhamChiTiet searchByIdBarcode(String barcode) {
        String sql = "select * from SanPhamChiTiet where barcode = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, barcode);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSanPham(rs.getString("maSanPham"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setMaDonViTinh(rs.getInt("maDonViTinh"));
                x.setAnhSanPham(rs.getString("AnhSanPham"));
                x.setHanSuDung(XDate.toString(rs.getDate("hanSuDung"), "dd-MM-yyyy"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setDonGia(rs.getFloat("donGia"));
                x.setKhoiLuong(rs.getFloat("khoiLuong"));
                x.setDonViTinhKhoiLuong(rs.getString("donViTinhKhoiLuong"));
                x.setNgaySanXuat(XDate.toString(rs.getDate("ngaySanXuat"), "dd-MM-yyyy"));
                x.setBarcode(rs.getString("barcode"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPhamChiTiet searchByIdSPCT(int maspct) {
        String sql = "select * from SanPhamChiTiet where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maspct);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSanPham(rs.getString("maSanPham"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setMaDonViTinh(rs.getInt("maDonViTinh"));
                x.setAnhSanPham(rs.getString("AnhSanPham"));
                x.setHanSuDung(XDate.toString(rs.getDate("hanSuDung"), "dd-MM-yyyy"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setDonGia(rs.getFloat("donGia"));
                x.setKhoiLuong(rs.getFloat("khoiLuong"));
                x.setDonViTinhKhoiLuong(rs.getString("donViTinhKhoiLuong"));
                x.setNgaySanXuat(XDate.toString(rs.getDate("ngaySanXuat"), "dd-MM-yyyy"));
                x.setBarcode(rs.getString("barcode"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public SanPhamChiTiet checkSPCTinDH(int maspct) {
        String sql = "select * from DonHangChiTiet where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maspct);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                return x;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
