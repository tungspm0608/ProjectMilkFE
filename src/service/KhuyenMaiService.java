package service;

import helper.DBContext;
import helper.XDate;
import model.KhuyenMai;
import model.KhuyenMaiChiTiet;
import model.SanPhamChiTiet;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KhuyenMaiService {

    public ArrayList<KhuyenMai> paging(int page, int limit, String ten,String trangThai,String ngayBatDau,String ngayKetThuc) {
        String sql = "select * from KhuyenMai \n"
                + "where tenChuongTrinh like ? and trangThai like ? and ngayBatDau >= ? and ngayKetThuc<= ?  order by maKhuyenMai "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, '%' + ten + "%");
            pstm.setString(2, trangThai + "%" );
            pstm.setObject(3, ngayBatDau);
            pstm.setObject(4, ngayKetThuc);
            pstm.setInt(5, (page - 1) * limit);
            pstm.setInt(6, limit);
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

    public ArrayList<KhuyenMaiChiTiet> getAllKMCT() {
        ArrayList<KhuyenMaiChiTiet> list = new ArrayList<>();
        String sql = "select * from KhuyenMaiSanPham";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhuyenMaiChiTiet kmct = new KhuyenMaiChiTiet();
                kmct.setMaKhuyenMaiChiTiet(rs.getInt("maKhuyenMaiSanPham"));
                kmct.setMaKhuyenMai(rs.getString("maKhuyenMai"));
                kmct.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                list.add(kmct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
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

    public KhuyenMaiChiTiet searchByMaSPCT(int maSPCT, String maKm) {
        ArrayList<KhuyenMaiChiTiet> list = new ArrayList<>();
        String sql = "select * from KhuyenMaiSanPham where maSanPhamChiTiet=? and maKhuyenMai=?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, maSPCT);
            pstm.setString(2, maKm );
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhuyenMaiChiTiet kmct = new KhuyenMaiChiTiet();
                kmct.setMaKhuyenMaiChiTiet(rs.getInt("maKhuyenMaiSanPham"));
                kmct.setMaKhuyenMai(rs.getString("maKhuyenMai"));
                kmct.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                list.add(kmct);
            }
            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<KhuyenMai> seachByDate(String ngayBD, String ngayKT) {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select * from  KhuyenMai \n"
                + "where ngayBatDau >= ? and ngayKetThuc<= ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, ngayBD);
            pstm.setString(2, ngayKT);
            ResultSet rs = pstm.executeQuery();
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
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
     public KhuyenMaiChiTiet CheckMaSPCTinKM(int maSPCT){
        ArrayList<KhuyenMaiChiTiet> list=new ArrayList<>();
        String sql="select * from KhuyenMaiSanPham where maSanPhamChiTiet = ? ";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, maSPCT);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhuyenMaiChiTiet kmct = new KhuyenMaiChiTiet();
                kmct.setMaKhuyenMaiChiTiet(rs.getInt("maKhuyenMaiSanPham"));
                kmct.setMaKhuyenMai(rs.getString("maKhuyenMai"));
                kmct.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                list.add(kmct);
            }
            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<SanPhamChiTiet> listSP(String maKM) {
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "select SanPhamChiTiet.maSanPham,SanPhamChiTiet.maSanPhamChiTiet,donGia,"
                + "soLuong,khoiLuong,hanSuDung from KhuyenMaiSanPham\n"
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
                sp.setMaSanPham(rs.getString("maSanPham"));
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
        String sql = "INSERT INTO KhuyenMai (maKhuyenMai,tenChuongTrinh,"
                + " ngayBatDau, ngayKetThuc, moTa, trangThai,"
                + " giaTriGiam, donViGiam)\n"
                + "VALUES(?,?,?,?,?,?,?,?) ";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, km.getMaKhuyenMai());
            pstm.setString(2, km.getTenChuongTrinh());
            Date dateBD = new Date(XDate.toDate(km.getNgayBatDau(), "").getTime());
            pstm.setDate(3, dateBD);
            Date dateKT = new Date(XDate.toDate(km.getNgayKetThuc(), "").getTime());
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
        String sql = "INSERT INTO KhuyenMaiSanPham(maKhuyenMai, maSanPhamChiTiet,trangThai) VALUES (?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, kmct.getMaKhuyenMai());
            pstm.setInt(2, kmct.getMaSanPhamChiTiet());
            pstm.setInt(3, kmct.getTrangThai());
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer updateKm(KhuyenMai km) {
        Integer row = null;
        String sql = "UPDATE  KhuyenMai set tenChuongTrinh=?,"
                + "ngayBatDau=?,ngayKetThuc=?,moTa=?,donViGiam=?,"
                + "giaTriGiam=? ,trangThai=?\n"
                + "where maKhuyenMai=?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, km.getTenChuongTrinh());
            Date dateBD = new Date(XDate.toDate(km.getNgayBatDau(), "dd-MM-yyyy").getTime());
            pstm.setDate(2, dateBD);
            Date dateKT = new Date(XDate.toDate(km.getNgayKetThuc(), "dd-MM-yyyy").getTime());
            pstm.setDate(3, dateKT);
            pstm.setString(4, km.getMoTa());
            pstm.setString(5, km.getDonViGiam());
            pstm.setInt(6, km.getGiatriGiam());
            pstm.setInt(7, km.getTrangThai());
            pstm.setString(8, km.getMaKhuyenMai());
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer updateKMCT(KhuyenMaiChiTiet kmct, KhuyenMai km) {
        updateKm(km);
        Integer row = null;
        String sql = "update KhuyenMaiSanPham set trangThai=? "
                + "where maKhuyenMaiSanPham = ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, kmct.getTrangThai());
            pstm.setInt(2, kmct.getMaKhuyenMaiChiTiet());
            row = pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    

    public KhuyenMai searchKMofSP(int maSanPhamChiTiet) {
        String sql = "select * from KhuyenMai\n"
                + "inner join KhuyenMaiSanPham on KhuyenMaiSanPham.maKhuyenMai = KhuyenMai.maKhuyenMai\n"
                + " where maSanPhamChiTiet = ? and KhuyenMai.trangThai=1 and KhuyenMaiSanPham.trangThai=1\n"
                + " and (? between KhuyenMai.ngayBatDau and KhuyenMai.ngayKetThuc)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maSanPhamChiTiet);
            Date date1 = new Date(XDate.toDate(XDate.toString(XDate.now(), "dd-MM-yyyy"), "dd-MM-yyyy").getTime());
            System.out.println(date1);
            pstm.setDate(2, date1);
            ResultSet rs = pstm.executeQuery();
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
                return km;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public KhuyenMai searchKMofAllSP(int maSanPhamChiTiet) {
        String sql = "select * from KhuyenMai\n"
                + "inner join KhuyenMaiSanPham on KhuyenMaiSanPham.maKhuyenMai = KhuyenMai.maKhuyenMai\n"
                + " where maSanPhamChiTiet = ?\n";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maSanPhamChiTiet);
            ResultSet rs = pstm.executeQuery();
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
                return km;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
