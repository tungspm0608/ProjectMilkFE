//
//package service;
//
//import helper.DBContext;
//import model.HoaDon;
//import java.util.ArrayList;
//import java.sql.*;
//import java.text.SimpleDateFormat;
//import java.util.List;
///**
// *
// * @author Admin
// */
//public class HoaDonService {
//    String sql = null;
//    Connection con = null;
//    PreparedStatement ps = null;
//    ResultSet rs = null;
//    
//    public List<HoaDon> getAllHD(){
//        ArrayList<HoaDon> list =new ArrayList<>();
//        sql="select maDonHang, maNhanVien, maKhachHang, tongTien, ngayTao, ghiChu, trangThai from DonHang";
//        
//        try {
//            con =DBContext.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                HoaDon h = new HoaDon();
//                h.setMaDonHang(rs.getInt(1));
//                h.setMaNhanVien(rs.getString(2));
//                h.setMaKhachHang(rs.getInt(3));
//                h.setTongTien(rs.getFloat(4));
//                h.setNgayTao(rs.getDate(5));
//                h.setGhiChu(rs.getString(6));
//                h.setTrangThai(rs.getBoolean(7));
//                list.add(h);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    

