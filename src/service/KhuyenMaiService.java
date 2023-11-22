package service;

import helper.DBContext;
import helper.XDate;
import model.KhuyenMai;
import model.KhuyenMaiChiTiet;
import model.SanPham;
import model.SanPhamChiTiet;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhuyenMaiService {

    public ArrayList<KhuyenMai> paging(int page, int limit, String ten) {
        String sql = "select * from KhuyenMai \n"
                + "where tenChuongTrinh like ? order by maKhuyenMai "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, '%' + ten + "%");
            pstm.setInt(2, (page - 1) * limit);
            pstm.setInt(3, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<KhuyenMai> list = new ArrayList<>();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKhuyenMai(rs.getString("maKhuyenMai"));
                km.setTenChuongTrinh(rs.getString("tenChuongTrinh"));
                km.setNgayBatDau(XDate.toString(rs.getDate("ngayBatDau"), "dd-MM-yyyy"));
                km.setNgayKetThuc(XDate.toString(rs.getDate("ngayKetThuc"), "dd-MM-yyyy"));
                km.setMoTa(rs.getString("moTa"));
                km.setTrangThai(rs.getInt("trangThai"));
                km.setDonViGiam(rs.getString("donViGiam"));
                km.setGiatriGiam(rs.getInt("giaTriGiam"));
                list.add(km);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhuyenMai searchById(String makm) {
        String sql = "select * from KhuyenMai where maKhuyenMai=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, makm);
            ResultSet rs = pstm.executeQuery();
            ArrayList<KhuyenMai> list = new ArrayList<>();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKhuyenMai(rs.getString("maKhuyenMai"));
                km.setTenChuongTrinh(rs.getString("tenChuongTrinh"));
                km.setNgayBatDau(XDate.toString(rs.getDate("ngayBatDau"), "dd-MM-yyyy"));
                km.setNgayKetThuc(XDate.toString(rs.getDate("ngayKetThuc"), "dd-MM-yyyy"));
                km.setMoTa(rs.getString("moTa"));
                km.setTrangThai(rs.getInt("trangThai"));
                km.setGiatriGiam(rs.getInt("giaTriGiam"));
                km.setDonViGiam(rs.getString("donViGiam"));
                list.add(km);
            }
            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SanPhamChiTiet> listSP(String maKM) {
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "select SanPhamChiTiet.maSanPhamChiTiet,donGia,soLuong,khoiLuong,hanSuDung from KhuyenMaiSanPham\n"
                + "inner join SanPhamChiTiet on KhuyenMaiSanPham.maSanPhamChiTiet=SanPhamChiTiet.maSanPhamChiTiet\n"
                + "inner join SanPham on SanPhamChiTiet.maSanPham=SanPham.maSanPham\n"
                + "where maKhuyenMai = ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, maKM);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet sp = new SanPhamChiTiet();
                sp.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                sp.setDonGia(rs.getFloat("donGia"));
                sp.setSoLuong(rs.getInt("soLuong"));
                sp.setKhoiLuong(rs.getFloat("khoiLuong"));
                sp.setHanSuDung(XDate.toString(rs.getDate("hanSuDung"), "dd-MM-yyyy"));
                list.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Integer addKM(KhuyenMai km) {
        Integer row = null;
        String sql = "INSERT INTO KhuyenMai (maKhuyenMai,tenChuongTrinh, ngayBatDau, ngayKetThuc, moTa, trangThai, giaTriGiam, donViGiam)\n"
                + "VALUES(?,?,?,?,?,?,?,?) ";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, km.getMaKhuyenMai());
            pstm.setString(2, km.getTenChuongTrinh());
            Date dateBD = new Date(XDate.toDate(km.getNgayBatDau(), "dd-MM-yyyy").getTime());
            pstm.setDate(3, dateBD);
            Date dateKT = new Date(XDate.toDate(km.getNgayKetThuc(), "dd-MM-yyyy").getTime());
            pstm.setDate(4, dateKT);
            pstm.setString(5, km.getMoTa());
            pstm.setInt(6, km.getTrangThai());
            pstm.setInt(7, km.getGiatriGiam());
            pstm.setString(8, km.getDonViGiam());
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer addKMSP(KhuyenMaiChiTiet kmct, KhuyenMai km) {
        if (searchById(kmct.getMaKhuyenMai()) == null) {
            addKM(km);
        }
        Integer row = null;
        String sql = "INSERT INTO KhuyenMaiSanPham(maKhuyenMai, maSanPhamChiTiet) VALUES (?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, kmct.getMaKhuyenMai());
            pstm.setInt(2, kmct.getMaSanPhamChiTiet());
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer updateKm(KhuyenMai km) {
        Integer row = null;
        String sql = "UPDATE  KhuyenMai set tenChuongTrinh=?,ngayBatDau=?,ngayKetThuc=?,moTa=?,donViGiam=?,giaTriGiam=? ,trangThai=?\n"
                + "where maKhuyenMai=?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer updateKMCT(KhuyenMaiChiTiet kmct,KhuyenMai km) {
        updateKm(km);
        Integer row = null;
        String sql = "update KhuyenMaiSanPham set maSanPhamChiTiet=?"
                + " where maKhuyenMaiSanPham=?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer deleteKM(int ma) {
        Integer row = null;
        String sql = "delete from KhuyenMaiSanPham where maKhuyenMai=?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, ma);
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
