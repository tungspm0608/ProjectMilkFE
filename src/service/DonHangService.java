/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.barcodelib.barcode.a.f.c;
import helper.DBContext;
import helper.XDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.DonHang;
import model.DonHangChiTiet;
import model.HoaDon;
import model.SanPhamChiTiet;
import org.apache.poi.ss.formula.functions.DGet;

/**
 *
 * @author dovan
 */
public class DonHangService {

    public ArrayList<DonHang> getAllDH(int trangThai, int loaiDH) {
        String sql = "select * from DonHang where trangThai like ? or loaiDonHang like ? or loaiDonHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, String.valueOf(trangThai) + "%");
            pstm.setString(2, String.valueOf(trangThai) + "%");
            pstm.setInt(3, 1);

            ResultSet rs = pstm.executeQuery();
            ArrayList<DonHang> list = new ArrayList<>();
            while (rs.next()) {
                DonHang x = new DonHang();
                x.setMaDonHang(rs.getInt("maDonHang"));
                x.setMaKhachHang(rs.getInt("maKhachHang"));
                x.setMaNhanVien(rs.getString("maNhanVien"));
                x.setMaHHTT(rs.getInt("maHinhThucThanhToan"));
                x.setTrangThai(rs.getInt("trangThai"));
                x.setGhiChu(rs.getString("ghiChu"));
                x.setNgayTao(XDate.toString(rs.getDate("ngayTao"), "dd-MM-yyyy"));
                x.setPhiKhac(rs.getFloat("phiKhac"));
                x.setTienHang(rs.getFloat("tienHang"));
                x.setLoaiDonHang(rs.getInt("loaiDonHang"));
                x.setDienThoai(rs.getString("dienThoai"));
                x.setDiaChi(rs.getString("diaChi"));
                x.setTienGiam(rs.getFloat("tienGiam"));
                x.setTongTien(rs.getFloat("tongTien"));

                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DonHangChiTiet> getAllDHCT(int maDH) {
        String sql = "select * from DonHangChiTiet where maDonHang = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maDH);
            ResultSet rs = pstm.executeQuery();
            ArrayList<DonHangChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                DonHangChiTiet x = new DonHangChiTiet();
                x.setMaDonHang(rs.getInt("maDonHang"));
                x.setMaDonHangChiTiet(rs.getInt("maDonHangChitiet"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setDonGia(rs.getFloat("donGia"));
                x.setGiaTriGiam(rs.getFloat("giaTriGiam"));
                x.setDonViGiam(rs.getString("donViGiam"));
                x.setGiaGiam(rs.getFloat("giaGiam"));
                x.setTongGia(rs.getFloat("tongGia"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                x.setTraHang(rs.getInt("traHang"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertDH(DonHang dh) {
        String sql = "insert into DonHang(maNhanVien,trangThai,ngayTao,tienHang,loaiDonHang) values(?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, dh.getMaNhanVien());
            pstm.setInt(2, dh.isTrangThai());
            java.sql.Date date = new java.sql.Date(XDate.toDate(dh.getNgayTao(), "dd-MM-yyyy").getTime());
            pstm.setDate(3, date);
            pstm.setFloat(4, dh.getTienHang());
            pstm.setInt(5, dh.isLoaiDonHang());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertDHCT(DonHangChiTiet dhct) {
        String sql = "insert into DonHangChiTiet(maDonHang,maSanPhamChiTiet,soLuong,donGia,giaTriGiam,donViGiam,giaGiam,tongGia,trangThai)"
                + " values(?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, dhct.getMaDonHang());
            pstm.setInt(2, dhct.getMaSanPhamChiTiet());
            pstm.setInt(3, dhct.getSoLuong());
            pstm.setFloat(4, dhct.getDonGia());
            pstm.setFloat(5, dhct.getGiaTriGiam());
            pstm.setString(6, dhct.getDonViGiam());
            pstm.setFloat(7, dhct.getGiaGiam());
            pstm.setFloat(8, dhct.getTongGia());
            pstm.setInt(9, 1);

            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DonHangChiTiet searchSPCTFromDH(int madh, int maspct) {
        String sql = "select * from DonHangChiTiet\n"
                + " where maDonHang=? and maSanPhamChiTiet=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, madh);
            pstm.setInt(2, maspct);
            ResultSet rs = pstm.executeQuery();
            ArrayList<DonHang> list = new ArrayList<>();
            while (rs.next()) {
                DonHangChiTiet x = new DonHangChiTiet();
                x.setMaDonHang(rs.getInt("maDonHang"));
                x.setMaDonHangChiTiet(rs.getInt("maDonHangChitiet"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setDonGia(rs.getFloat("donGia"));
                x.setGiaTriGiam(rs.getFloat("giaTriGiam"));
                x.setDonViGiam(rs.getString("donViGiam"));
                x.setGiaGiam(rs.getFloat("giaGiam"));
                x.setTongGia(rs.getFloat("tongGia"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                return x;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateDHCT(DonHangChiTiet dhct) {
        String sql = "update DonHangChiTiet set soLuong=?,tongGia=?,trangThai=?,traHang=? where maDonHangChiTiet=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, dhct.getSoLuong());
            pstm.setFloat(2, (dhct.getSoLuong() - dhct.getTraHang()) * dhct.getGiaGiam());
            pstm.setInt(3, dhct.isTrangThai() ? 1 : 0);
            pstm.setInt(4, dhct.getTraHang());
            pstm.setInt(5, dhct.getMaDonHangChiTiet());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateDH(DonHang dh) {
        String sql = "update DonHang set maKhachHang=?,trangThai=?,tienHang=?,tienGiam=?,tongTien=?,"
                + "dienThoai=?,diaChi=?,phiKhac=?,maHinhThucThanhToan=?,loaiDonHang=? where maDonHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setObject(1, dh.getMaKhachHang() == 0 ? null : dh.getMaKhachHang());
            pstm.setInt(2, dh.isTrangThai());
            pstm.setFloat(3, tongTienDH(dh.getMaDonHang()));
            pstm.setFloat(4, dh.getTienGiam());
            pstm.setFloat(5, tongTienDH(dh.getMaDonHang()) + dh.getPhiKhac() - dh.getTienGiam());
            pstm.setString(6, dh.getDienThoai());

            pstm.setString(7, dh.getDiaChi());
            pstm.setFloat(8, dh.getPhiKhac());
            pstm.setObject(9, dh.getMaHHTT() == 0 ? null : dh.getMaHHTT());
            pstm.setInt(10, dh.isLoaiDonHang());
            pstm.setInt(11, dh.getMaDonHang());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public float tongTienDH(int maDH) {
        String sql = "select SUM(tongGia) from DonHangChiTiet where maDonHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maDH);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer deleteDHCT(int madhct) {
        String sql = "delete DonHangChiTiet where maDonHangChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, madhct);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer deleteAllDHCT(int madh) {
        String sql = "delete DonHangChiTiet where maDonHang = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, madh);
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DonHang> getAllHD(int page, int limit) {
        String sql = "select * from DonHang where trangThai like ? and (loaiDonHang like ? or loaiDonHang=? or loaiDonHang=?) order by maDonHang "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, 1);
            pstm.setInt(2, 2);
            pstm.setInt(3, 3);
            pstm.setInt(4, 4);
            pstm.setInt(5, (page - 1) * limit);
            pstm.setInt(6, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<DonHang> list = new ArrayList<>();
            while (rs.next()) {
                DonHang x = new DonHang();
                x.setMaDonHang(rs.getInt("maDonHang"));
                x.setMaKhachHang(rs.getInt("maKhachHang"));
                x.setMaNhanVien(rs.getString("maNhanVien"));
                x.setMaHHTT(rs.getInt("maHinhThucThanhToan"));
                x.setTrangThai(rs.getInt("trangThai"));
                x.setGhiChu(rs.getString("ghiChu"));
                x.setNgayTao(XDate.toString(rs.getDate("ngayTao"), "dd-MM-yyyy"));
                x.setPhiKhac(rs.getFloat("phiKhac"));
                x.setTienHang(rs.getFloat("tienHang"));
                x.setLoaiDonHang(rs.getInt("loaiDonHang"));
                x.setDienThoai(rs.getString("dienThoai"));
                x.setDiaChi(rs.getString("diaChi"));
                x.setTienGiam(rs.getFloat("tienGiam"));
                x.setTongTien(rs.getFloat("tongTien"));
                
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DonHang> getByDate(String d1, String d2) {
        String sql = "select * from DonHang where ngayTao between ? and ? ";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setObject(1, d1);
            pstm.setObject(2, d2);
            ResultSet rs = pstm.executeQuery();
            ArrayList<DonHang> list = new ArrayList<>();
            while (rs.next()) {
                DonHang x = new DonHang();
                x.setMaDonHang(rs.getInt("maDonHang"));
                x.setMaKhachHang(rs.getInt("maKhachHang"));
                x.setMaNhanVien(rs.getString("maNhanVien"));
                x.setMaHHTT(rs.getInt("maHinhThucThanhToan"));
                x.setTrangThai(rs.getInt("trangThai"));
                x.setGhiChu(rs.getString("ghiChu"));
                x.setNgayTao(XDate.toString(rs.getDate("ngayTao"), "dd-MM-yyyy"));
                x.setPhiKhac(rs.getFloat("phiKhac"));
                x.setTienHang(rs.getFloat("tienHang"));
                x.setLoaiDonHang(rs.getInt("loaiDonHang"));
                x.setDienThoai(rs.getString("dienThoai"));
                x.setDiaChi(rs.getString("diaChi"));
                x.setTienGiam(rs.getFloat("tienGiam"));
                x.setTongTien(rs.getFloat("tongTien"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
