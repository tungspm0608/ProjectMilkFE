/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import helper.DialogHelper;
import helper.StringFormat;
import helper.XDate;
import java.awt.Color;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.DongSanPham;
import model.LoaiHang;
import model.ThuongHieu;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.Auth;

import service.DongSanPhamService;
import service.LoaiHangService;
import service.ThongKeService;
import service.ThuongHieuService;

/**
 *
 * @author Admin
 */
public class ThongKe_JPanel extends javax.swing.JPanel {

    ThongKeService tksv = new ThongKeService();
    DefaultTableModel mol = new DefaultTableModel();
    ThuongHieuService thsv = new ThuongHieuService();
    DongSanPhamService dspsv = new DongSanPhamService();
    LoaiHangService lhsv = new LoaiHangService();
    ChartPanel chartPanel2;
    ChartPanel chartPanel4;
    boolean jp1TrangThaiLoc;

    /**
     * Creates new form ThongKe_JPanel
     */
    public ThongKe_JPanel() {
        initComponents();
        this.setBackground(new Color(37, 108, 205));
        jTabbedPane1.setSelectedIndex(0);
        this.setUpjpsanPham();
        
    }

    private void setUpjpsanPham() {
        jp1DongSanPham.removeAllItems();
        jp1LoaiSanPham.removeAllItems();
        jp1ThuongHieu.removeAllItems();

        for (ThuongHieu th : thsv.getAll()) {
            jp1ThuongHieu.addItem(th.getTenThuongHieu());
        }
        for (DongSanPham dsp : dspsv.getAll()) {
            jp1DongSanPham.addItem(dsp.getTenDongSanPham());
        }
        for (LoaiHang lh : lhsv.getAll()) {
            jp1LoaiSanPham.addItem(lh.getTenLoaiHang());
        }

        jp1DongSanPham.addItem("Tất cả");
        jp1LoaiSanPham.addItem("Tất cả");
        jp1ThuongHieu.addItem("Tất cả");

        jp1DongSanPham.setSelectedIndex(jp1DongSanPham.getItemCount() - 1);
        jp1LoaiSanPham.setSelectedIndex(jp1LoaiSanPham.getItemCount() - 1);
        jp1ThuongHieu.setSelectedIndex(jp1ThuongHieu.getItemCount() - 1);
        
        jp1NgayBatDau.setDate(XDate.toDate("2022-1-1", "yyyy-MM-dd"));
        LocalDate currentDate = LocalDate.now();
        jp1NgayKetThuc.setDate(new Date(currentDate.getYear() - 1900, currentDate.getMonthValue() - 1, currentDate.getDayOfMonth()));
        String ngayBatDau = XDate.toString(jp1NgayBatDau.getDate(), "yyyy-MM-dd");
        String ngayKetThuc = XDate.toString(jp1NgayKetThuc.getDate(), "yyyy-MM-dd");
        
        mol = (DefaultTableModel) jp1SanPhamTheoLuotBan.getModel();
        mol.setRowCount(0);
        for (Object[] objects : tksv.sanPhamTheoLuotBan(null, null, null, ngayBatDau, ngayKetThuc)) {
            mol.addRow(objects);
        }
        jp1TrangThaiLoc = true;
    }

    private void setUpjpdoanhThu() {
        Object[] o = tksv.ThongKeTheoNgay();
        jp2tienDoanhThuHomNay.setText(StringFormat.changeMoneyFormat(String.valueOf(o[0])));
        jp2donHangDaBanHomNay.setText(String.valueOf(o[1]));
        jp2donHangBiHuyHomNayGT.setText(String.valueOf(o[2]));
        Object[] o1 = tksv.ThongKeTheoThang();
        jp2tienDoanhThuThangNay.setText(StringFormat.changeMoneyFormat(String.valueOf(o1[0])));
        jp2donHangDaBanThang.setText(String.valueOf(o1[1]));
        jp2donHangBiHuyThang.setText(String.valueOf(o1[2]));

        mol = (DefaultTableModel) jp2doanhThutheoThangChiTiet.getModel();
        mol.setRowCount(0);
        for (Object[] objects : tksv.ThongKeTheoThangChiTiet(2023)) {
            mol.addRow(objects);
        }
        jp2YearChooser.setYear(2023);
        chartPanel2 = new ChartPanel(tksv.createDoanhThuChiTietChart(2023));
        jp2chartContainer.add(chartPanel2);
        chartPanel2.setSize(new java.awt.Dimension(1180, 500));
    }

    private void setUpjpkhachHang() {
        ChartPanel chartDoTuoi = new ChartPanel(tksv.createKhachHangTheoDoTuoiChart());
        jp3KhachHangTheoDoTuoi.add(chartDoTuoi);
        chartDoTuoi.setSize(new java.awt.Dimension(400, 400));
        ChartPanel chartGioiTInh = new ChartPanel(tksv.createKhachHangTheoGioiTinhChart());
        jp3KhachHangTheoGioiTInh.add(chartGioiTInh);
        chartGioiTInh.setSize(new java.awt.Dimension(400, 400));
    }

    private void setUpjpdonHang() {
        jp4YearChooser.setYear(2023);
        chartPanel4 = new ChartPanel(tksv.createDonHangTheoThangChart(2023, 1));
        jp4chartContainer.add(chartPanel4);
        chartPanel4.setSize(new java.awt.Dimension(1150, 600));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpsanPham = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jp1LoaiSanPham = new javax.swing.JComboBox<>();
        jp1DongSanPham = new javax.swing.JComboBox<>();
        jp1ThuongHieu = new javax.swing.JComboBox<>();
        jp1NgayBatDau = new com.toedter.calendar.JDateChooser();
        jp1NgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jp1SanPhamTheoLuotBan = new javax.swing.JTable();
        jpdoanhThu = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp2tienDoanhThuHomNay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jp2donHangDaBanHomNay = new javax.swing.JLabel();
        jp2donHangBiHuyHomNayT = new javax.swing.JLabel();
        jp2donHangBiHuyHomNayGT = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jp2tienDoanhThuThangNay = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jp2donHangDaBanThang = new javax.swing.JLabel();
        jp2donHangBiHuyThang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jp2tableContainer = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jp2doanhThutheoThangChiTiet = new javax.swing.JTable();
        jp2chartContainer = new javax.swing.JPanel();
        jp2YearChooser = new com.toedter.calendar.JYearChooser();
        jpkhachHang = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jp3KhachHangTheoGioiTInh = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jp3KhachHangTheoDoTuoi = new javax.swing.JPanel();
        jpdonHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jp4nutHienThiNgang = new javax.swing.JRadioButton();
        jp4nutHienThiDoc = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jp4chartContainer = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jp4YearChooser = new com.toedter.calendar.JYearChooser();

        setBackground(new java.awt.Color(0, 204, 204));
        setPreferredSize(new java.awt.Dimension(1100, 820));

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jpsanPham.setBackground(new java.awt.Color(37, 108, 205));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc sản phẩm"));

        jButton2.setText("Lọc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Export to excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jp1LoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jp1LoaiSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jp1LoaiSanPhamItemStateChanged(evt);
            }
        });

        jp1DongSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jp1DongSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jp1DongSanPhamItemStateChanged(evt);
            }
        });

        jp1ThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jp1ThuongHieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jp1ThuongHieuItemStateChanged(evt);
            }
        });

        jp1NgayBatDau.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jp1NgayBatDauInputMethodTextChanged(evt);
            }
        });
        jp1NgayBatDau.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jp1NgayBatDauPropertyChange(evt);
            }
        });

        jp1NgayKetThuc.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jp1NgayKetThucInputMethodTextChanged(evt);
            }
        });
        jp1NgayKetThuc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jp1NgayKetThucPropertyChange(evt);
            }
        });

        jLabel8.setText("Loại hàng");

        jLabel9.setText("Dòng sản phẩm");

        jLabel11.setText("Thương hiệu");

        jLabel14.setText("Ngày bắt đầu");

        jLabel15.setText("Ngày kết thúc");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jp1LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1DongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jp1NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jp1LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jp1DongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jp1ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(jp1NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp1SanPhamTheoLuotBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Lượt bán", "Mã sản phẩm", "Tên sản phẩm", "Loại hàng", "Dòng sản phẩm", "Thương hiệu", "Đơn vị tính", "Số lượng", "Đơn giá", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jp1SanPhamTheoLuotBan);

        javax.swing.GroupLayout jpsanPhamLayout = new javax.swing.GroupLayout(jpsanPham);
        jpsanPham.setLayout(jpsanPhamLayout);
        jpsanPhamLayout.setHorizontalGroup(
            jpsanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpsanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpsanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpsanPhamLayout.setVerticalGroup(
            jpsanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpsanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jpsanPham);

        jpdoanhThu.setBackground(new java.awt.Color(37, 108, 205));

        jPanel10.setBackground(new java.awt.Color(51, 102, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Doanh thu hôm nay :");

        jp2tienDoanhThuHomNay.setText("100.000 VND");

        jLabel6.setText("Đơn hàng đã bán :");

        jp2donHangDaBanHomNay.setText("5");

        jp2donHangBiHuyHomNayT.setText("Đơn hàng bị huỷ :");

        jp2donHangBiHuyHomNayGT.setText("10");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jp2tienDoanhThuHomNay)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp2donHangDaBanHomNay))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jp2donHangBiHuyHomNayT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp2donHangBiHuyHomNayGT)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp2tienDoanhThuHomNay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jp2donHangDaBanHomNay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jp2donHangBiHuyHomNayT)
                    .addComponent(jp2donHangBiHuyHomNayGT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(102, 255, 102));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setText("Doanh thu tháng này :");

        jp2tienDoanhThuThangNay.setText("100.000 VND");

        jLabel12.setText("Đơn hàng thành công :");

        jLabel13.setText("Đơn hàng bị huỷ :");

        jp2donHangDaBanThang.setText("jLabel7");

        jp2donHangBiHuyThang.setText("jLabel8");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp2donHangDaBanThang))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp2donHangBiHuyThang))
                    .addComponent(jp2tienDoanhThuThangNay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp2tienDoanhThuThangNay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jp2donHangDaBanThang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jp2donHangBiHuyThang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Năm :");

        jButton4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/Wizard.png"))); // NOI18N
        jButton4.setText("Lọc");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jp2doanhThutheoThangChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tháng", "Số đơn", "Doanh thu", "Doanh thu trung bình ngày"
            }
        ));
        jScrollPane6.setViewportView(jp2doanhThutheoThangChiTiet);

        javax.swing.GroupLayout jp2tableContainerLayout = new javax.swing.GroupLayout(jp2tableContainer);
        jp2tableContainer.setLayout(jp2tableContainerLayout);
        jp2tableContainerLayout.setHorizontalGroup(
            jp2tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
            .addGroup(jp2tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE))
        );
        jp2tableContainerLayout.setVerticalGroup(
            jp2tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(jp2tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Bảng", jp2tableContainer);

        javax.swing.GroupLayout jp2chartContainerLayout = new javax.swing.GroupLayout(jp2chartContainer);
        jp2chartContainer.setLayout(jp2chartContainerLayout);
        jp2chartContainerLayout.setHorizontalGroup(
            jp2chartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
        );
        jp2chartContainerLayout.setVerticalGroup(
            jp2chartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Biểu đồ", jp2chartContainer);

        javax.swing.GroupLayout jpdoanhThuLayout = new javax.swing.GroupLayout(jpdoanhThu);
        jpdoanhThu.setLayout(jpdoanhThuLayout);
        jpdoanhThuLayout.setHorizontalGroup(
            jpdoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpdoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
                    .addGroup(jpdoanhThuLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp2YearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpdoanhThuLayout.setVerticalGroup(
            jpdoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdoanhThuLayout.createSequentialGroup()
                .addGroup(jpdoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpdoanhThuLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jpdoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpdoanhThuLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpdoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jp2YearChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Doanh Thu", jpdoanhThu);

        jpkhachHang.setBackground(new java.awt.Color(37, 108, 205));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Thống kê độ tuổi khách hàng");

        jp3KhachHangTheoGioiTInh.setBackground(new java.awt.Color(37, 108, 205));

        javax.swing.GroupLayout jp3KhachHangTheoGioiTInhLayout = new javax.swing.GroupLayout(jp3KhachHangTheoGioiTInh);
        jp3KhachHangTheoGioiTInh.setLayout(jp3KhachHangTheoGioiTInhLayout);
        jp3KhachHangTheoGioiTInhLayout.setHorizontalGroup(
            jp3KhachHangTheoGioiTInhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        jp3KhachHangTheoGioiTInhLayout.setVerticalGroup(
            jp3KhachHangTheoGioiTInhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Thống kê theo giới tính khách hàng");

        jp3KhachHangTheoDoTuoi.setBackground(new java.awt.Color(37, 108, 205));

        javax.swing.GroupLayout jp3KhachHangTheoDoTuoiLayout = new javax.swing.GroupLayout(jp3KhachHangTheoDoTuoi);
        jp3KhachHangTheoDoTuoi.setLayout(jp3KhachHangTheoDoTuoiLayout);
        jp3KhachHangTheoDoTuoiLayout.setHorizontalGroup(
            jp3KhachHangTheoDoTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        jp3KhachHangTheoDoTuoiLayout.setVerticalGroup(
            jp3KhachHangTheoDoTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpkhachHangLayout = new javax.swing.GroupLayout(jpkhachHang);
        jpkhachHang.setLayout(jpkhachHangLayout);
        jpkhachHangLayout.setHorizontalGroup(
            jpkhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpkhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                .addGroup(jpkhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jp3KhachHangTheoGioiTInh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
            .addGroup(jpkhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpkhachHangLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jp3KhachHangTheoDoTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(578, Short.MAX_VALUE)))
        );
        jpkhachHangLayout.setVerticalGroup(
            jpkhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpkhachHangLayout.createSequentialGroup()
                .addGroup(jpkhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpkhachHangLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addGroup(jpkhachHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(jp3KhachHangTheoGioiTInh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(jpkhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpkhachHangLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jp3KhachHangTheoDoTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(181, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Khách Hàng thân thiết", jpkhachHang);

        jpdonHang.setBackground(new java.awt.Color(37, 108, 205));

        jLabel2.setText("Thời gian :");

        jLabel5.setText("Kiểu biểu đồ :");

        buttonGroup2.add(jp4nutHienThiNgang);
        jp4nutHienThiNgang.setSelected(true);
        jp4nutHienThiNgang.setText("Ngang");
        jp4nutHienThiNgang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jp4nutHienThiNgangActionPerformed(evt);
            }
        });

        buttonGroup2.add(jp4nutHienThiDoc);
        jp4nutHienThiDoc.setText("Dọc");
        jp4nutHienThiDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jp4nutHienThiDocActionPerformed(evt);
            }
        });

        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp4chartContainerLayout = new javax.swing.GroupLayout(jp4chartContainer);
        jp4chartContainer.setLayout(jp4chartContainerLayout);
        jp4chartContainerLayout.setHorizontalGroup(
            jp4chartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp4chartContainerLayout.setVerticalGroup(
            jp4chartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );

        jButton7.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/Wizard.png"))); // NOI18N
        jButton7.setText("Export to JPEG");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpdonHangLayout = new javax.swing.GroupLayout(jpdonHang);
        jpdonHang.setLayout(jpdonHangLayout);
        jpdonHangLayout.setHorizontalGroup(
            jpdonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpdonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp4chartContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpdonHangLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp4YearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp4nutHienThiNgang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp4nutHienThiDoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jpdonHangLayout.setVerticalGroup(
            jpdonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdonHangLayout.createSequentialGroup()
                .addGroup(jpdonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpdonHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpdonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jp4nutHienThiNgang)
                            .addComponent(jp4nutHienThiDoc)
                            .addComponent(jButton1)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpdonHangLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jp4YearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp4chartContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Đơn hàng", jpdonHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // Doi nam o trong bang doanh thu và lọc bảng doanh thu
        int year = jp2YearChooser.getYear();
        if (!XDate.checkDataYear(year)) {
            return;
        }
        mol = (DefaultTableModel) jp2doanhThutheoThangChiTiet.getModel();
        mol.setRowCount(0);
        for (Object[] objects : tksv.ThongKeTheoThangChiTiet(year)) {
            mol.addRow(objects);
        }
        chartPanel2.setChart(tksv.createDoanhThuChiTietChart(year));
        DialogHelper.alert(this, "Đã hoàn tất lọc");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        //Mở bàng đơn hàng
        this.setUpjpdonHang();
        this.setUpjpdoanhThu();
        this.setUpjpkhachHang();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Lọc bảng đơn hàng
        int year = jp4YearChooser.getYear();
        if (!XDate.checkDataYear(year)) {
            return;
        }
        if (jp4nutHienThiNgang.isSelected()) {
            chartPanel4.setChart(tksv.createDonHangTheoThangChart(year, 1));
        } else {
            chartPanel4.setChart(tksv.createDonHangTheoThangChart(year, 0));
        }
        DialogHelper.alert(this, "Đã hoàn tất lọc");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jp4nutHienThiDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jp4nutHienThiDocActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_jp4nutHienThiDocActionPerformed

    private void jp4nutHienThiNgangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jp4nutHienThiNgangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jp4nutHienThiNgangActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // bấm bút lọc sản phẩm ở jp1
        jp1TrangThaiLoc = true;
        if (jp1NgayBatDau.getDate().after(jp1NgayKetThuc.getDate())) {
            DialogHelper.alert(this,"Ngày bắt đầu không được nhỏ hơn ngày kết thúc");
            return;
        }
        int chonLoaiHang = jp1LoaiSanPham.getSelectedIndex();
        Integer loaiHang = chonLoaiHang == jp1LoaiSanPham.getItemCount() - 1 ? null : lhsv.getAll().get(chonLoaiHang).getMaLoaiHang();

        int chonDongSanPham = jp1DongSanPham.getSelectedIndex();
        Integer dongSanPham = chonDongSanPham == jp1DongSanPham.getItemCount() - 1 ? null : dspsv.getAll().get(chonDongSanPham).getMaDongSanPham();

        int chonThuongHieu = jp1ThuongHieu.getSelectedIndex();
        Integer thuongHieu = chonThuongHieu == jp1ThuongHieu.getItemCount() - 1 ? null : thsv.getAll().get(chonThuongHieu).getMaThuongHieu();

       if (jp1NgayBatDau.getDate() == null || !XDate.checkDataDay(jp1NgayBatDau.getDate())) {
            jp1NgayBatDau.setDate(new Date(2022 - 1900, 0, 1));
        }
        String ngayBatDau = XDate.toString(jp1NgayBatDau.getDate(), "yyyy-MM-dd");
        if (jp1NgayKetThuc.getDate() == null || !XDate.checkDataDay(jp1NgayKetThuc.getDate())) {
            jp1NgayKetThuc.setDate(XDate.now());
        } 
        String ngayKetThuc = XDate.toString(jp1NgayKetThuc.getDate(), "yyyy-MM-dd");
        mol = (DefaultTableModel) jp1SanPhamTheoLuotBan.getModel();
        mol.setRowCount(0);
        for (Object[] objects : tksv.sanPhamTheoLuotBan(loaiHang, dongSanPham, thuongHieu, ngayBatDau, ngayKetThuc)) {
            mol.addRow(objects);
        }
        DialogHelper.alert(this, "Đã hoàn tất lọc");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // export anh bieu đồ đơn hàng
        tksv.saveDonHangTheoThangChart(chartPanel4.getChart());
        DialogHelper.alert(this, "Export thành công, file nằm ở thư mục asset\thongKeDonHang");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // export excel bảng sản phẩm theo filter đã chọn
        if (!jp1TrangThaiLoc) {
            DialogHelper.alert(this, "Bạn vừa thay đổi giá trị ở ô lọc\n Vui lòng bấm lọc lại trước khi xuất");
            return;
        }
        //Kiêrm tra xem có dùng filer lọc sản phẩm không bang cách check vị trí có trùng với chỗ tất cả không 
        int chonLoaiHang = jp1LoaiSanPham.getSelectedIndex();
        String loaiHang = chonLoaiHang == jp1LoaiSanPham.getItemCount() - 1 ? "" : "Loại hàng : " + String.valueOf(jp1LoaiSanPham.getSelectedItem());

        int chonDongSanPham = jp1DongSanPham.getSelectedIndex();
        String dongSanPham = chonDongSanPham == jp1DongSanPham.getItemCount() - 1 ? "" : "Dòng sản phẩm : " + String.valueOf(jp1DongSanPham.getSelectedItem());

        int chonThuongHieu = jp1ThuongHieu.getSelectedIndex();
        String thuongHieu = chonThuongHieu == jp1ThuongHieu.getItemCount() - 1 ? "" : "Thương hiệu : " + String.valueOf(jp1ThuongHieu.getSelectedItem());
        
        if (jp1NgayBatDau.getDate() == null) {
            jp1NgayBatDau.setDate(new Date(2022 - 1900, 0, 1));
        }
        String ngayBatDau = "từ ngày " + XDate.toString(jp1NgayBatDau.getDate(), "");
        if (jp1NgayKetThuc.getDate() == null) {
            jp1NgayKetThuc.setDate(XDate.now());
        } 
        String ngayKetThuc = " đến ngày " + XDate.toString(jp1NgayKetThuc.getDate(), "");
        
        mol = (DefaultTableModel) jp1SanPhamTheoLuotBan.getModel();
        //Bat dau tao file excel
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet 1");

            // Đầu tiên tạo title cho sheet
            String title = "Thống kê sản phẩm " + ngayBatDau + ngayKetThuc;
            int titleRowIndex = 0;
            Row titleRow = sheet.createRow(titleRowIndex);
            Cell cellTitle = titleRow.createCell(0);
            cellTitle.setCellValue(title);

            //Liệt kê các trường đã thống kê 
            if (!loaiHang.isEmpty()) {
                titleRowIndex++;
                Row filterRow1 = sheet.createRow(titleRowIndex);
                Cell cellFilter1 = filterRow1.createCell(0);
                cellFilter1.setCellValue(loaiHang);
            }
            if (!dongSanPham.isEmpty()) {
                titleRowIndex++;
                Row filterRow1 = sheet.createRow(titleRowIndex);
                Cell cellFilter1 = filterRow1.createCell(0);
                cellFilter1.setCellValue(dongSanPham);
            }
            if (!thuongHieu.isEmpty()) {
                titleRowIndex++;
                Row filterRow1 = sheet.createRow(titleRowIndex);
                Cell cellFilter1 = filterRow1.createCell(0);
                cellFilter1.setCellValue(thuongHieu);
            }

            // Đầu tiên, tạo dòng cho tiêu đề (tên cột)
            titleRowIndex++;
            Row headerRow = sheet.createRow(titleRowIndex);
            for (int col = 0; col < mol.getColumnCount(); col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(mol.getColumnName(col));
            }

            // Sau đó, đi qua từng dòng của JTable và tạo dòng tương ứng trong Excel
            for (int row = titleRowIndex; row < mol.getRowCount()+titleRowIndex; row++) {
                Row excelRow = sheet.createRow(row + 1); // Bắt đầu từ dòng 1 để tránh ghi đè tiêu đề

                for (int col = 0; col < mol.getColumnCount(); col++) {
                    Object value = mol.getValueAt(row - titleRowIndex, col);
                    Cell cell = excelRow.createCell(col);

                    // Điều chỉnh kiểu dữ liệu tùy thuộc vào kiểu dữ liệu của cột trong JTable
                    if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Number) {
                        cell.setCellValue(((Number) value).doubleValue());
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    } else {
                        cell.setCellValue(value + "");
                    }
                }
            }

            // Ghi Workbook xuống tệp
            String today = XDate.toString(XDate.now(), "HH'h'-mm'm'-ss's' dd-MM-yyyy");
            String filePath = Auth.HDH == 1 ? "asset/ThongKeSanPham/" : "asset\\ThongKeSanPham\\";
            try (FileOutputStream fileOut = new FileOutputStream(filePath + "Thống kê sản phẩm " + today + ".xlsx")) {
                workbook.write(fileOut);
                DialogHelper.alert(this, "Xuất Excel thành công!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Đóng Workbook để giải phóng tài nguyên
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jp1LoaiSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jp1LoaiSanPhamItemStateChanged
        // TODO add your handling code here:
        jp1TrangThaiLoc = false;
    }//GEN-LAST:event_jp1LoaiSanPhamItemStateChanged

    private void jp1DongSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jp1DongSanPhamItemStateChanged
        // TODO add your handling code here:
        jp1TrangThaiLoc = false;
    }//GEN-LAST:event_jp1DongSanPhamItemStateChanged

    private void jp1ThuongHieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jp1ThuongHieuItemStateChanged
        // TODO add your handling code here:
        jp1TrangThaiLoc = false;
    }//GEN-LAST:event_jp1ThuongHieuItemStateChanged

    private void jp1NgayBatDauInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jp1NgayBatDauInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jp1NgayBatDauInputMethodTextChanged

    private void jp1NgayKetThucInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jp1NgayKetThucInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jp1NgayKetThucInputMethodTextChanged

    private void jp1NgayBatDauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jp1NgayBatDauPropertyChange
        // TODO add your handling code here:
        if (jp1NgayBatDau.getDate().compareTo(new Date(2022 - 1900, 0, 1)) != 0) {
            jp1TrangThaiLoc = false;
        }
    }//GEN-LAST:event_jp1NgayBatDauPropertyChange

    private void jp1NgayKetThucPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jp1NgayKetThucPropertyChange
        // TODO add your handling code here:
        LocalDate currentDate = LocalDate.now();
        if (jp1NgayKetThuc.getDate().compareTo(new Date(currentDate.getYear() - 1900, currentDate.getMonthValue() - 1, currentDate.getDayOfMonth())) != 0) {
            jp1TrangThaiLoc = false;
        }
    }//GEN-LAST:event_jp1NgayKetThucPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JComboBox<String> jp1DongSanPham;
    private javax.swing.JComboBox<String> jp1LoaiSanPham;
    private com.toedter.calendar.JDateChooser jp1NgayBatDau;
    private com.toedter.calendar.JDateChooser jp1NgayKetThuc;
    private javax.swing.JTable jp1SanPhamTheoLuotBan;
    private javax.swing.JComboBox<String> jp1ThuongHieu;
    private com.toedter.calendar.JYearChooser jp2YearChooser;
    private javax.swing.JPanel jp2chartContainer;
    private javax.swing.JTable jp2doanhThutheoThangChiTiet;
    private javax.swing.JLabel jp2donHangBiHuyHomNayGT;
    private javax.swing.JLabel jp2donHangBiHuyHomNayT;
    private javax.swing.JLabel jp2donHangBiHuyThang;
    private javax.swing.JLabel jp2donHangDaBanHomNay;
    private javax.swing.JLabel jp2donHangDaBanThang;
    private javax.swing.JPanel jp2tableContainer;
    private javax.swing.JLabel jp2tienDoanhThuHomNay;
    private javax.swing.JLabel jp2tienDoanhThuThangNay;
    private javax.swing.JPanel jp3KhachHangTheoDoTuoi;
    private javax.swing.JPanel jp3KhachHangTheoGioiTInh;
    private com.toedter.calendar.JYearChooser jp4YearChooser;
    private javax.swing.JPanel jp4chartContainer;
    private javax.swing.JRadioButton jp4nutHienThiDoc;
    private javax.swing.JRadioButton jp4nutHienThiNgang;
    private javax.swing.JPanel jpdoanhThu;
    private javax.swing.JPanel jpdonHang;
    private javax.swing.JPanel jpkhachHang;
    private javax.swing.JPanel jpsanPham;
    // End of variables declaration//GEN-END:variables
}
