/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.DBContext;
import helper.StringFormat;
import helper.XDate;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author phungvantung
 */
public class ThongKeService {

    Connection con = null;

    // --------------------------------------JP2
    public Object[] ThongKeTheoNgay() {
        try {
            String callStatement = "{call dbo.doanhThuTheoNgay(?, ?, ?)}";
            con = DBContext.getConnection();

            CallableStatement cstmt = con.prepareCall(callStatement);
            cstmt.registerOutParameter(1, Types.DOUBLE); // @doanhThu
            cstmt.registerOutParameter(2, Types.INTEGER); // @donHangThanhCong
            cstmt.registerOutParameter(3, Types.INTEGER); // @donHangThatBai
            cstmt.execute();
            // Lấy giá trị của các tham số đầu ra
            double doanhThu = cstmt.getDouble(1);
            System.out.println(doanhThu);
            int donHangThanhCong = cstmt.getInt(2);
            int donHangThatBai = cstmt.getInt(3);
            return new Object[]{
                doanhThu, donHangThanhCong, donHangThatBai
            };
        } catch (Exception e) {
            System.out.println("loi thong ke theo ngay");
            return null;
        }
    }

    public Object[] ThongKeTheoThang() {
        try {
            String callStatement = "{call dbo.doanhThuTheoThang(?, ?, ?)}";
            con = DBContext.getConnection();

            CallableStatement cstmt = con.prepareCall(callStatement);
            cstmt.registerOutParameter(1, Types.FLOAT); // @doanhThu
            cstmt.registerOutParameter(2, Types.INTEGER); // @donHangThanhCong
            cstmt.registerOutParameter(3, Types.INTEGER); // @donHangThatBai
            cstmt.execute();
            // Lấy giá trị của các tham số đầu ra
            float doanhThu = cstmt.getFloat(1);
            int donHangThanhCong = cstmt.getInt(2);
            int donHangThatBai = cstmt.getInt(3);
            return new Object[]{
                doanhThu, donHangThanhCong, donHangThatBai
            };
        } catch (Exception e) {
            System.out.println("loi thong ke theo thang");
            return null;
        }
    }

    public List<Object[]> ThongKeTheoThangChiTiet(int year) {
        List<Object[]> list = new ArrayList<>();
        con = DBContext.getConnection();
        try {
            CallableStatement statement = con.prepareCall("{call doanhThuTheoThangChiTiet(?)}");
            statement.setInt(1, year);

            // Thực thi stored procedure
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int month = resultSet.getInt("Thang");
                float doanhThu = resultSet.getFloat("DoanhThu");
                int soDonHang = resultSet.getInt("SoDonHang");
                float doanhThuTrungBinh = resultSet.getFloat("DoanhThuTrungBinh");
                Object[] o = new Object[]{
                    month, soDonHang,StringFormat.changeMoneyFormat(String.valueOf(doanhThu)),
                     StringFormat.changeMoneyFormat(String.valueOf(doanhThuTrungBinh))
                };
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            System.out.println("loi thong ke theo thang chi tiet");
            return null;
        }
    }

    public JFreeChart createDoanhThuChiTietChart(int year) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Thống kê doanh thu chi tiết",
                "tháng", "Số lượng",
                this.createDoanhThuChiTietDataset(year), PlotOrientation.VERTICAL, true, true, false);
        return lineChart;
    }

    private CategoryDataset createDoanhThuChiTietDataset(int year) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Object[] o : this.ThongKeTheoThangChiTiet(year)) {
            dataset.addValue(Float.valueOf(String.valueOf(o[2]).replaceAll("[^\\d]", "")), "Doanh thu", "T" + String.valueOf(o[0]));
            dataset.addValue(Float.valueOf(String.valueOf(o[3]).replaceAll("[^\\d]","")), "Doanh thu trung bình", "T" + String.valueOf(o[0]));
        }
        return dataset;
    }

    //--------------------------------JP4
    public List<Object[]> donHangTheoThang(int year) {
        List<Object[]> list = new ArrayList<>();
        con = DBContext.getConnection();
        try {
            CallableStatement statement = con.prepareCall("{call donHangTheoThang(?)}");
            statement.setInt(1, year);
            // Thực thi stored procedure
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int month = resultSet.getInt("Thang");
                int taiQuayThanhCong = resultSet.getInt("TaiQuayThanhCong");
                int datHangThanhCong = resultSet.getInt("OnlineThanhCong");
                int biHuy = resultSet.getInt("BiHuy");
                Object[] o = new Object[]{
                    month, taiQuayThanhCong, datHangThanhCong, biHuy
                };
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            System.out.println("loi don hang theo thang");
            return null;
        }
    }

    public JFreeChart createDonHangTheoThangChart(int year, int view) {
        JFreeChart lineChart = ChartFactory.createBarChart(
                "Thống kê đơn hàng năm " + String.valueOf(year),
                "tháng", "Số lượng",
                this.createDonHangTheoThangDataset(year),
                view == 0 ? PlotOrientation.HORIZONTAL : PlotOrientation.VERTICAL,
                true, true, false);
        return lineChart;
    }

    private CategoryDataset createDonHangTheoThangDataset(int year) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Object[] o : this.donHangTheoThang(year)) {
            dataset.addValue(Integer.valueOf(String.valueOf(o[1])), "Đơn hàng tại quầy thành công", "T" + String.valueOf(o[0]));
            dataset.addValue(Integer.valueOf(String.valueOf(o[2])), "Đơn đặt hàng thành công", "T" + String.valueOf(o[0]));
            dataset.addValue(Integer.valueOf(String.valueOf(o[3])), "Đơn hàng bị huỷ", "T" + String.valueOf(o[0]));
        }
        return dataset;
    }

    public void saveDonHangTheoThangChart(JFreeChart chart) {
        int width = 930;
        /* Width of the image */
        int height = 700;
        /* Height of the image */
        String today = XDate.toString(XDate.now(), "HH'h'-mm'm'-ss's' dd-MM-yyyy");
        String filePath = Auth.HDH == 1 ? "asset/ThongKeDonHang/" : "asset\\ThongKeDonHang\\";
        String title = chart.getTitle().getText() +" "+today;
        File Chart = new File(filePath + title + ".jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(Chart, chart, width, height);
        } catch (IOException ex) {
            Logger.getLogger(ThongKeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //----------------------------------JP1 San pham
    public List<Object[]> sanPhamTheoLuotBan(Integer loaiHang, Integer dongSanPham, Integer thuongHieu, String ngayBatDau, String ngayKetThuc) {
        List<Object[]> list = new ArrayList<>();
        con = DBContext.getConnection();

        try {
            CallableStatement statement = con.prepareCall("{call SanPhamTheoLuotBan(?,?,?,?,?)}");
            statement.setObject(1, loaiHang);
            statement.setObject(2, dongSanPham);
            statement.setObject(3, thuongHieu);
            statement.setObject(4, ngayBatDau);
            statement.setObject(5, ngayKetThuc);

            // Thực thi stored procedure
            statement.execute();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int maSanPhamChiTiet = resultSet.getInt("MaSanPhamChiTiet");
                String tenSanPham = resultSet.getString("TenSanPham");
                String donViTinh = resultSet.getString("TenDonViTinh");
                String trangThai = "";
                if (resultSet.getBoolean("TrangThai")) {
                    trangThai = "Đang bán";
                } else {
                    trangThai = "Ngừng bán";
                };
                int soLuong = resultSet.getInt("SoLuong");
                String loaiHang1 = resultSet.getString("TenLoaiHang");
                String dongSanPham1 = resultSet.getString("TenDongSanPham");
                String thuongHieu1 = resultSet.getString("TenThuongHieu");
                int luotBan = resultSet.getInt("LuotBan");
                float donGia = resultSet.getFloat("DonGia");
                Object[] o = new Object[]{
                    luotBan, maSanPhamChiTiet, tenSanPham, loaiHang1, dongSanPham1, thuongHieu1, donViTinh, soLuong, donGia, trangThai
                };
                list.add(o);
            }
            System.out.println("Số sản phẩm có trong bảng : " + list.size());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // Đóng connection khi đã sử dụng xong
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("loi thong ke san pham theo luot ban");
                e.printStackTrace();
            }
        }
    }

    //-------------------jp3 khach hang
    //----------------
    public Object[] KhachHangTheoDoTuoi() {
        con = DBContext.getConnection();
        try {

            String callStatement = "{call dbo.KhachHangTheoDoTuoi()}";
            CallableStatement cstmt = con.prepareCall(callStatement);
            // Lấy giá trị của các tham số đầu ra
            cstmt.execute();

            // Lấy kết quả từ ResultSet
            ResultSet resultSet = cstmt.getResultSet();
            int tu18Den30 = 0;
            int tu30Den50 = 0;
            int tu50TroLen = 0;
            if (resultSet.next()) {
                tu18Den30 = resultSet.getInt(1);
                tu30Den50 = resultSet.getInt("tu30den50");
                tu50TroLen = resultSet.getInt("tu50trolen");
            }

            return new Object[]{
                tu18Den30, tu30Den50, tu50TroLen
            };
        } catch (Exception e) {
            System.out.println("loi thong ke theo khach hang theo do tuoi");
            e.printStackTrace();
            return null;
        }
    }

    public JFreeChart createKhachHangTheoDoTuoiChart() {
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Thống kê khách hàng theo độ tuổi",
                this.createKhachHangTheoDoTuoiDataset(),
                true, true, false);
        return pieChart;
    }

    private PieDataset createKhachHangTheoDoTuoiDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Object[] o = this.KhachHangTheoDoTuoi();
        dataset.setValue("Từ 18 đến 30", Double.valueOf(String.valueOf(o[0])));
        dataset.setValue("Từ 30 đến 50", Double.valueOf(String.valueOf(o[1])));
        dataset.setValue("Từ 50 đến ++", Double.valueOf(String.valueOf(o[2])));

        return dataset;
    }

    //-----------------------
    public Object[] KhachHangTheoGioiTinh() {
        con = DBContext.getConnection();
        try {
            String callStatement = "{call dbo.KhachHangTheoGioiTinh()}";
            CallableStatement cstmt = con.prepareCall(callStatement);
            cstmt.execute();

            // Lấy kết quả từ ResultSet
            ResultSet resultSet = cstmt.getResultSet();
            // Lấy giá trị của các tham số đầu ra
            int slNam = 0;
            int slNu = 0;
            if (resultSet.next()) {
                slNam = resultSet.getInt("SLNam");
                slNu = resultSet.getInt("SLNu");
            }

            return new Object[]{
                slNam, slNu
            };
        } catch (Exception e) {
            System.out.println("loi thong ke theo khach hang theo gioi tinh");
            e.printStackTrace();
            return null;
        }
    }

    public JFreeChart createKhachHangTheoGioiTinhChart() {
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Thống kê khách hàng theo giới tính",
                this.createKhachHangTheoGioiTinhDataset(),
                true, true, false);
        return pieChart;
    }

    private PieDataset createKhachHangTheoGioiTinhDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Object[] o = this.KhachHangTheoGioiTinh();
        dataset.setValue("Nam", Double.valueOf(String.valueOf(o[0])));
        dataset.setValue("Nữ", Double.valueOf(String.valueOf(o[1])));

        return dataset;
    }

}
