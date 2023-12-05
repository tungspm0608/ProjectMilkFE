/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import helper.FileChoose;
import helper.ImportExcell;
import helper.XDate;
import model.DonViTinh;
import model.DongSanPham;
import model.LoaiHang;
import model.SanPham;
import model.SanPhamChiTiet;
import model.ThuongHieu;
import model.XuatXu;
import service.DonViTinh_service;
import service.DongSanPhamService;
import service.LoaiHangService;
import service.SanPhamChiTietService;
import service.SanPhamService;
import service.ThuongHieuService;
import service.XuatXuService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import helper.StringFormat;
import helper.DialogHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.Auth;
import service.KhuyenMaiService;

/**
 *
 * @author dovan
 */
public class SanPham_JPanel extends javax.swing.JPanel {

    LoaiHangService lhsv = new LoaiHangService();
    DonViTinh_service dvtsv = new DonViTinh_service();
    ThuongHieuService thsv = new ThuongHieuService();
    DongSanPhamService dspsv = new DongSanPhamService();
    XuatXuService xxsv = new XuatXuService();

    SanPhamService spservice = new SanPhamService();
    SanPhamChiTietService spctservice = new SanPhamChiTietService();
    KhuyenMaiService khuyenMaiService = new KhuyenMaiService();

    String path = "";
    String path1 = "";

    DefaultTableModel mol = new DefaultTableModel();
    DefaultComboBoxModel<String> comboboxdvt = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboboxdsp = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboboxth = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboboxlh = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboboxxx = new DefaultComboBoxModel<>();

    int page = 1, index = -1;
    String ten = "", trangThaiString = "";
    ArrayList<SanPhamChiTiet> list = new ArrayList<>();
    int row = -1;
    SanPhamChiTiet spct;

    /**
     * Creates new form SanPhamView
     */
    public SanPham_JPanel() {
        initComponents();
        this.setBackground(new Color(37, 108, 205));
        this.init();

        if (Auth.HDH == 1) {
            path = "./asset/AnhSanPham/";
        } else {
            path = ".\\asset\\AnhSanPham\\";
        }
        fillCombox();
        mol = (DefaultTableModel) tbl_sp.getModel();
        loadDataToTable();
    }

    void fillCombox() {
        comboboxlh = (DefaultComboBoxModel<String>) cboLoaiSP.getModel();
        comboboxlh.removeAllElements();
        for (LoaiHang x : lhsv.getAll()) {
            comboboxlh.addElement(x.getTenLoaiHang());
        }
        comboboxdsp = (DefaultComboBoxModel<String>) cboDongSP.getModel();
        comboboxdsp.removeAllElements();
        for (DongSanPham x : dspsv.getAll()) {
            if (x.getTrangThai()) {
                comboboxdsp.addElement(x.getTenDongSanPham());
            }
        }
        comboboxdvt = (DefaultComboBoxModel<String>) cboDonViTinh.getModel();
        comboboxdvt.removeAllElements();
        for (DonViTinh x : dvtsv.getAll()) {
            if (x.getTrangThai()) {
                comboboxdvt.addElement(x.getTenDonViTinh());
            }
        }
        comboboxxx = (DefaultComboBoxModel<String>) cboXuatXu.getModel();
        comboboxxx.removeAllElements();
        for (XuatXu x : xxsv.getAll()) {
            if (x.getTrangThai()) {
                comboboxxx.addElement(x.getTenXuatXu());
            }
        }
        comboboxth = (DefaultComboBoxModel<String>) cboThuongHieu.getModel();
        comboboxth.removeAllElements();
        for (ThuongHieu x : thsv.getAll()) {
            if (x.getTrangThai()) {
                comboboxth.addElement(x.getTenThuongHieu());
            }
        }
    }

    void init() {
        this.fillDonViTinh();
        this.fillDongSanPham();
        this.fillLoaiHang();
        this.fillThuongHieu();
        this.fillXuatXu(xxsv.getAll());
    }

    void fillDonViTinh() {
        DefaultTableModel mol1 = new DefaultTableModel();
        mol1 = (DefaultTableModel) tblDonViTinh.getModel();
        mol1.setRowCount(0);
        for (DonViTinh dvt : dvtsv.getAll()) {
            mol1.addRow(new Object[]{dvt.getMaDonViTinh(), dvt.getTenDonViTinh(), dvt.getGhiChu(), dvt.getTrangThai()});
        }
    }

    void fillThuongHieu(List<ThuongHieu> list1) {
        DefaultTableModel mol4 = new DefaultTableModel();
        mol4 = (DefaultTableModel) tblThuongHieu.getModel();
        mol4.setRowCount(0);
        for (ThuongHieu th : list1) {
            mol4.addRow(new Object[]{th.getMaThuongHieu(), th.getTenThuongHieu(), th.getTrangThai(), th.getGhiChu()});
        }
    }

    void fillDongSanPham() {
        DefaultTableModel mol2 = new DefaultTableModel();
        mol2 = (DefaultTableModel) tblDongSP.getModel();
        mol2.setRowCount(0);
        for (DongSanPham dsp : dspsv.getAll()) {
            mol2.addRow(new Object[]{dsp.getMaDongSanPham(), dsp.getTenDongSanPham(), dsp.getGhiChu(), dsp.getTrangThai()});
        }
    }

    void fillLoaiHang() {
        DefaultTableModel mol3 = new DefaultTableModel();
        mol3 = (DefaultTableModel) tblLoaiHang.getModel();
        mol3.setRowCount(0);
        for (LoaiHang lh : lhsv.getAll()) {
            mol3.addRow(new Object[]{lh.getMaLoaiHang(), lh.getTenLoaiHang(), lh.getGhiChu()});
        }
    }

    void fillThuongHieu() {
        DefaultTableModel mol4 = new DefaultTableModel();
        mol4 = (DefaultTableModel) tblThuongHieu.getModel();
        mol4.setRowCount(0);
        for (ThuongHieu th : thsv.getAll()) {
            mol4.addRow(new Object[]{th.getMaThuongHieu(), th.getTenThuongHieu(), th.getTrangThai(), th.getGhiChu()});
        }
    }

    void fillXuatXu(List<XuatXu> list) {
        DefaultTableModel mol5 = new DefaultTableModel();
        mol5 = (DefaultTableModel) tblXuatXu.getModel();
        mol5.setRowCount(0);
        for (XuatXu xx : list) {
            mol5.addRow(new Object[]{xx.getMaXuatXu(), xx.getTenXuatXu(), xx.getTrangThai()});
        }
    }

    void showformDVT() {
        DonViTinh dvt = dvtsv.getAll().get(row);
        txtMaDVT.setText(String.valueOf(dvt.getMaDonViTinh()));
        txtTenDVT.setText(dvt.getTenDonViTinh());
        txtGhiChuDVT.setText(dvt.getGhiChu());
    }

    DonViTinh readformDVT() {
        DonViTinh dvt = new DonViTinh();
        dvt.setTenDonViTinh(txtTenDVT.getText());
        dvt.setGhiChu(txtGhiChuDVT.getText());
        dvt.setTrangThai(true);

        return dvt;
    }

    void showformDSP() {
        DongSanPham dsp = dspsv.getAll().get(row);
        txtMaDSP.setText(String.valueOf(dsp.getMaDongSanPham()));
        txtTenDSP.setText(dsp.getTenDongSanPham());
        txtGhiChuDSP.setText(dsp.getGhiChu());
    }

    DongSanPham readformDSP() {
        DongSanPham dsp = new DongSanPham();
        dsp.setTenDongSanPham(txtTenDSP.getText());
        dsp.setGhiChu(txtGhiChuDSP.getText());
        dsp.setTrangThai(true);
        return dsp;
    }

    void showformLH() {
        LoaiHang lh = lhsv.getAll().get(row);

        txtTenLH.setText(lh.getTenLoaiHang());
        txtGhiChuLH.setText(lh.getGhiChu());
    }

    LoaiHang readformLH() {
        LoaiHang lh = new LoaiHang();
        lh.setTenLoaiHang(txtTenLH.getText());
        lh.setGhiChu(txtGhiChuLH.getText());
        lh.setTrangThai(true);
        return lh;
    }

    XuatXu readformXX() {
        XuatXu xx = new XuatXu();
        boolean trangThai = (boolean) tblXuatXu.getValueAt(row, 2);
        xx.setTrangThai(trangThai);
        return xx;
    }

    void TimKiemXX() {
        String Name = txtTimKiemXX.getText();
        this.fillXuatXu(xxsv.getByName(Name));
    }

    void showformTH() {
        ThuongHieu th = thsv.getAll().get(row);
        txtTenTH.setText(th.getTenThuongHieu());
        txtGhiChuTH.setText(th.getGhiChu());
        if (th.getTrangThai() == true) {
            rdoDangHT.setSelected(true);
        } else {
            rdoNgungHT.setSelected(true);
        }
    }

    ThuongHieu readformTH() {
        ThuongHieu th = new ThuongHieu();
        th.setTenThuongHieu(txtTenTH.getText());
        th.setGhiChu(txtGhiChuTH.getText());
        th.setTrangThai(true);
        return th;
    }

    boolean checkDVT() {
        if (txtTenDVT.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập tên đơn vị tính");
            txtTenDVT.requestFocus();
            return false;
        } else if (txtGhiChuDVT.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập ghi chú cho don vi tinh");
            txtGhiChuDVT.requestFocus();
            return false;
        }
        return true;
    }

    boolean checkTH() {
        if (txtTenTH.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập tên thương hiệu");
            txtTenTH.requestFocus();
            return false;
        } else if (txtGhiChuTH.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập ghi chú cho thương hiệu");
            txtGhiChuTH.requestFocus();
            return false;
        }
        return true;
    }

    boolean checkDSP() {
        if (txtTenDSP.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập tên dòng sản phẩm");
            txtTenDSP.requestFocus();
            return false;
        } else if (txtGhiChuDSP.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập ghi chú cho dòng sản phẩm");
            txtGhiChuDSP.requestFocus();
            return false;
        }
        return true;
    }

    boolean checkLH() {
        if (txtTenLH.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập tên loại hàng");
            txtTenLH.requestFocus();
            return false;
        } else if (txtGhiChuLH.getText().isEmpty()) {
            DialogHelper.alert(this, "Cần nhập ghi chú cho loại hàng");
            txtGhiChuLH.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_hansd = new javax.swing.JTextField();
        cboDongSP = new javax.swing.JComboBox<>();
        cboLoaiSP = new javax.swing.JComboBox<>();
        txt_ngayxk = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_sl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_dongia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboXuatXu = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboDonViTinh = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboThuongHieu = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_barcode = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_tk = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        lbl_HinhAnh = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        rdo_tiep = new javax.swing.JRadioButton();
        rdo_stop = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sp = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txt_gianhap = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_kl = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbo_dvkl = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        phanTrang = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtMaDVT = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtTenDVT = new javax.swing.JTextField();
        btnThem1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDonViTinh = new javax.swing.JTable();
        btnSua1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnMoi1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtGhiChuDVT = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblXuatXu = new javax.swing.JTable();
        jButton30 = new javax.swing.JButton();
        txtTimKiemXX = new javax.swing.JTextField();
        btnTimKiemXX = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtMaDSP = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtTenDSP = new javax.swing.JTextField();
        btnThemDSP = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDongSP = new javax.swing.JTable();
        btnSuaDSP = new javax.swing.JButton();
        btnXoaDSP = new javax.swing.JButton();
        btnMoiDSP = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtGhiChuDSP = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChuLH = new javax.swing.JTextArea();
        txtTenLH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLoaiHang = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        rdoDangHT = new javax.swing.JRadioButton();
        rdoNgungHT = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        txtTenTH = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtGhiChuTH = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtTimKiemTH = new javax.swing.JTextField();
        btnTimKiemTH = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblThuongHieu = new javax.swing.JTable();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton10.setText("Thêm");

        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton11.setText("Mới");

        setBackground(new java.awt.Color(0, 204, 204));
        setPreferredSize(new java.awt.Dimension(1100, 820));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1100, 866));

        jPanel2.setBackground(new java.awt.Color(37, 108, 205));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 820));

        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã sản phẩm: ");

        txt_ma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        txt_ten.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên sản phẩm: ");

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dòng sản phẩm: ");

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Loại sản phẩm: ");

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày sản xuất:");

        jLabel6.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hạn sử dụng: ");

        txt_hansd.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_hansd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hansdActionPerformed(evt);
            }
        });

        cboDongSP.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cboDongSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboLoaiSP.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_ngayxk.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Số lượng: ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_sl.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Đơn giá:");

        txt_dongia.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_dongia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dongiaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Xuất xứ:");

        cboXuatXu.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cboXuatXu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Đơn vị tính: ");

        cboDonViTinh.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cboDonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Thương hiệu");

        cboThuongHieu.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cboThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Barcode: ");

        txt_barcode.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_barcodeActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Cập nhật");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Mới");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton8.setText("Thêm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton12.setText("Thêm");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton15.setText("Thêm");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton16.setText("Thêm");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Phân loại: ");

        jLabel15.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tìm kiếm:");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txt_tk.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N

        jButton18.setText("Tìm kiếm");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18)))
        );

        lbl_HinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lbl_HinhAnh.setForeground(new java.awt.Color(255, 255, 255));
        lbl_HinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jButton19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton19.setText("Thêm");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup4.add(rdo_tiep);
        rdo_tiep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdo_tiep.setText("Đang kinh doanh");
        rdo_tiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_tiepActionPerformed(evt);
            }
        });

        buttonGroup4.add(rdo_stop);
        rdo_stop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdo_stop.setText("Ngừng kinh doanh");
        rdo_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdo_tiep, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdo_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_tiep)
                    .addComponent(rdo_stop))
                .addContainerGap())
        );

        tbl_sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Thương hiệu", "Loại hàng", "Dòng sản phẩm", "ĐVT", "Hạn sử dụng", "SL", "Đơn giá", "Xuất xứ", "Khối lượng", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_spMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sp);
        if (tbl_sp.getColumnModel().getColumnCount() > 0) {
            tbl_sp.getColumnModel().getColumn(0).setMaxWidth(40);
            tbl_sp.getColumnModel().getColumn(1).setMinWidth(200);
            tbl_sp.getColumnModel().getColumn(1).setMaxWidth(200);
            tbl_sp.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        jLabel16.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Giá nhập:");

        txt_gianhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gianhapActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Khối lương: ");

        txt_kl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Đơn vị KL: ");

        jButton9.setText("<<");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton13.setText(">>");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("ImportExcel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbo_dvkl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lít", "ml", "g", "kg" }));

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton14.setText("Xóa");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        phanTrang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phanTrang.setForeground(new java.awt.Color(255, 255, 255));
        phanTrang.setText("1");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/iconSystem/Sync.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/iconSystem/Sync.png"))); // NOI18N

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/iconSystem/Sync.png"))); // NOI18N

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/iconSystem/Sync.png"))); // NOI18N

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/iconSystem/Sync.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Trang số:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phanTrang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_hansd)
                                    .addComponent(txt_sl, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(cboLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_ngayxk)
                                    .addComponent(cboDongSP, 0, 177, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbo_dvkl, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_kl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDonViTinh, 0, 202, Short.MAX_VALUE)
                            .addComponent(cboXuatXu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_dongia)
                            .addComponent(cboThuongHieu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_gianhap, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_barcode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17)
                            .addComponent(jButton28)
                            .addComponent(jButton29))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(262, 262, 262))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(429, 429, 429))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton8)
                                .addComponent(cboDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel11))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_ngayxk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_hansd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(cbo_dvkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton16))
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton15))
                                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton12))
                                        .addGap(15, 15, 15)
                                        .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_kl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel31)))
                                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel16)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton4)
                    .addComponent(jButton14))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton13)
                    .addComponent(phanTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(101, 101, 101))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel2);

        jPanel3.setBackground(new java.awt.Color(37, 108, 205));
        jPanel3.setPreferredSize(new java.awt.Dimension(1100, 726));

        jLabel27.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Đơn vị tính: ");

        jPanel10.setBackground(new java.awt.Color(172, 214, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel28.setText("Mã DVT:");

        txtMaDVT.setEditable(false);
        txtMaDVT.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtMaDVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDVTActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel29.setText("Tên DVT: ");

        txtTenDVT.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTenDVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDVTActionPerformed(evt);
            }
        });

        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        tblDonViTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn vị tính", "Tên đơn vị tính", "Ghi chú", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDonViTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonViTinhMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblDonViTinh);
        if (tblDonViTinh.getColumnModel().getColumnCount() > 0) {
            tblDonViTinh.getColumnModel().getColumn(0).setHeaderValue("Mã đơn vị tính");
        }

        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnMoi1.setText("Mới");
        btnMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi1ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel36.setText("Ghi chú:");

        txtGhiChuDVT.setColumns(20);
        txtGhiChuDVT.setRows(5);
        jScrollPane10.setViewportView(txtGhiChuDVT);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaDVT, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txtTenDVT))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnThem1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua1)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa1)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoi1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtMaDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtTenDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem1)
                    .addComponent(btnSua1)
                    .addComponent(btnXoa1)
                    .addComponent(btnMoi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel30.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Xuất xứ: ");

        jPanel11.setBackground(new java.awt.Color(172, 214, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));

        tblXuatXu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã quốc gia", "Tên quốc gia", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblXuatXu);

        jButton30.setText("Cập nhật");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        btnTimKiemXX.setText("Tìm kiếm");
        btnTimKiemXX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemXXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtTimKiemXX, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiemXX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtTimKiemXX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiemXX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButton30)
                        .addGap(110, 110, 110))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jLabel33.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Dòng sản phẩm: ");

        jPanel12.setBackground(new java.awt.Color(172, 214, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel34.setText("Mã DSP:");

        txtMaDSP.setEditable(false);
        txtMaDSP.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtMaDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDSPActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel35.setText("Tên DSP: ");

        txtTenDSP.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTenDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDSPActionPerformed(evt);
            }
        });

        btnThemDSP.setText("Thêm");
        btnThemDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDSPActionPerformed(evt);
            }
        });

        tblDongSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dòng sản phẩm", "Tên dòng sản phẩm", "Ghi chú", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDongSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDongSPMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblDongSP);
        if (tblDongSP.getColumnModel().getColumnCount() > 0) {
            tblDongSP.getColumnModel().getColumn(0).setHeaderValue("Mã dòng sản phẩm");
        }

        btnSuaDSP.setText("Sủa");
        btnSuaDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDSPActionPerformed(evt);
            }
        });

        btnXoaDSP.setText("Xóa");
        btnXoaDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDSPActionPerformed(evt);
            }
        });

        btnMoiDSP.setText("Mới");
        btnMoiDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiDSPActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel38.setText("Ghi chú:");

        txtGhiChuDSP.setColumns(20);
        txtGhiChuDSP.setRows(5);
        jScrollPane12.setViewportView(txtGhiChuDSP);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenDSP, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(txtMaDSP)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnThemDSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaDSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaDSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoiDSP)))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane9)
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtMaDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtTenDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDSP)
                    .addComponent(btnSuaDSP)
                    .addComponent(btnXoaDSP)
                    .addComponent(btnMoiDSP))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel30))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 168, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thuộc tính sản phẩm", jPanel3);

        jPanel1.setBackground(new java.awt.Color(37, 108, 205));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 685));

        jLabel17.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Loại hàng");

        jLabel19.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ghi chú: ");

        txtGhiChuLH.setColumns(20);
        txtGhiChuLH.setRows(5);
        jScrollPane3.setViewportView(txtGhiChuLH);

        txtTenLH.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTenLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLHActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tên loại hàng: ");

        tblLoaiHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhóm hàng", "Tên nhóm hàng", "Ghi chú"
            }
        ));
        tblLoaiHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblLoaiHang);

        jButton20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton20.setText("Thêm");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton21.setText("Cập nhật");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton22.setText("Xóa");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton23.setText("Mới");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Thương hiệu");

        jLabel22.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Phân loại: ");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(rdoDangHT);
        rdoDangHT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDangHT.setSelected(true);
        rdoDangHT.setText("Đang hợp tác");

        buttonGroup1.add(rdoNgungHT);
        rdoNgungHT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNgungHT.setText("Ngừng hợp tác");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoDangHT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoNgungHT, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDangHT)
                    .addComponent(rdoNgungHT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tên thương hiệu:");

        txtTenTH.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTenTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTHActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Ghi chú: ");

        txtGhiChuTH.setColumns(20);
        txtGhiChuTH.setRows(5);
        jScrollPane5.setViewportView(txtGhiChuTH);

        jLabel26.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tìm kiếm: ");

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        txtTimKiemTH.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        txtTimKiemTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemTHActionPerformed(evt);
            }
        });

        btnTimKiemTH.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        btnTimKiemTH.setText("Tìm kiếm");
        btnTimKiemTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemTHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemTH, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiemTH)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemTH))
                .addContainerGap())
        );

        tblThuongHieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thương hiệu", "Tên thương hiệu", "Trạng thái", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuongHieuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblThuongHieu);

        jButton24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton24.setText("Thêm");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton25.setText("Cập nhật");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton26.setText("Xóa");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton27.setText("Mới");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton22)
                                        .addGap(15, 15, 15)
                                        .addComponent(jButton23))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenLH, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenTH, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel25)
                                .addGap(74, 74, 74)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel26)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton26)
                                        .addGap(15, 15, 15)
                                        .addComponent(jButton27))
                                    .addComponent(jScrollPane6))))))
                .addGap(20, 42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(txtTenLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton23)
                    .addComponent(jButton22)
                    .addComponent(jButton21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtTenTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jButton27)
                    .addComponent(jButton26)
                    .addComponent(jButton25))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh mục sản phẩm", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenLHActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        txtGhiChuLH.setText(null);
        txtTenLH.setText(null);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void txtTenTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTHActionPerformed

    private void txtTimKiemTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemTHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemTHActionPerformed

    private void btnTimKiemTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemTHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemTHActionPerformed

    private void txtMaDVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDVTActionPerformed

    private void txtTenDVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDVTActionPerformed

    private void txtMaDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDSPActionPerformed

    private void txtTenDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDSPActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (index == -1) {
            DialogHelper.alert(null, "Mời chọn sản phẩm muốn cập nhật");
            return;
        }
        if (!checkForm()) {
            return;
        }
        if (readFormSPCT() == null) {
            return;
        }
        SanPham sp = readFormSP();
        SanPhamChiTiet spct1 = readFormSPCT();
        spct1.setMaSanPhamChiTiet(spct.getMaSanPhamChiTiet());
        spct1.setTrangThai((boolean) tbl_sp.getValueAt(index, 11));
        Integer chon = JOptionPane.showConfirmDialog(null, "Bạn Muốn cập nhật chứ?");
        if (chon != 0) {
            return;
        }
        Integer kq = spctservice.updateSPCT(sp, spct1);
        if (kq != null) {
            DialogHelper.alert(null, "Cập nhật thành công");
            loadDataToTable();
        } else
            DialogHelper.alert(null, "Cập nhật thất bại");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_barcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_barcodeActionPerformed

    private void txt_dongiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dongiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dongiaActionPerformed

    private void txt_hansdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hansdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hansdActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        ThemDonViTinh_JFrame jFrame = new ThemDonViTinh_JFrame();
        jFrame.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ThemDongSp_JFrame newFrame = new ThemDongSp_JFrame();
        newFrame.setVisible(true);
        fillCombox();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        ThemThuongHieu_JFrame newFrame = new ThemThuongHieu_JFrame();
        newFrame.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        ThemXuatXu_JFrame newFrame = new ThemXuatXu_JFrame();
        newFrame.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ThemLoaiHang_JFrame newFrame = new ThemLoaiHang_JFrame();
        newFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblDonViTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonViTinhMouseClicked
        // TODO add your handling code here:
        row = tblDonViTinh.getSelectedRow();
        this.showformDVT();
    }//GEN-LAST:event_tblDonViTinhMouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
        if (this.checkDVT() == true) {
            DonViTinh dvt = this.readformDVT();
            dvtsv.add(dvt);
            this.fillDonViTinh();
            DialogHelper.alert(this, "Them thanh cong");
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi1ActionPerformed
        // TODO add your handling code here:
        txtMaDVT.setText(null);
        txtGhiChuDVT.setText(null);
        txtTenDVT.setText(null);
    }//GEN-LAST:event_btnMoi1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        // TODO add your handling code here:      
        if (checkDVT() == true) {
            row = tblDonViTinh.getSelectedRow();
            int MaDVT = (int) tblDonViTinh.getValueAt(row, 0);
            DonViTinh dvt = this.readformDVT();
            boolean trangThai = (boolean) tblDonViTinh.getValueAt(row, 3);
            dvt.setTrangThai(trangThai);
            dvtsv.update(dvt, MaDVT);
            fillDonViTinh();
            DialogHelper.alert(this, "Sửa thành công");
        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        // TODO add your handling code here:
        row = tblDonViTinh.getSelectedRow();
        int MaDVT = (int) tblDonViTinh.getValueAt(row, 0);
        if (dvtsv.CheckXoa(MaDVT) == null) {
            dvtsv.delete(MaDVT);
            this.fillDonViTinh();
            DialogHelper.alert(this, "Xóa thành công");
            txtGhiChuDVT.setText(null);
            txtTenDVT.setText(null);
        } else
            DialogHelper.alert(this, "Chỉ được xóa mềm dòng này!!!");
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnThemDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDSPActionPerformed
        // TODO add your handling code here:
        if (this.checkDSP() == true) {
            DongSanPham dsp = this.readformDSP();
            dspsv.add(dsp);
            this.fillDongSanPham();
            DialogHelper.alert(this, "Them thanh cong");
        }
    }//GEN-LAST:event_btnThemDSPActionPerformed

    private void btnSuaDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDSPActionPerformed
        // TODO add your handling code here:
        if (checkDSP() == true) {
            row = tblDongSP.getSelectedRow();
            int MaDSP = (int) tblDongSP.getValueAt(row, 0);
            DongSanPham dsp = this.readformDSP();
            boolean trangThai = (boolean) tblDongSP.getValueAt(row, 3);
            dsp.setTrangThai(trangThai);
            dspsv.update(dsp, MaDSP);
            fillDongSanPham();
            DialogHelper.alert(this, "Sửa thành công");
        }
    }//GEN-LAST:event_btnSuaDSPActionPerformed

    private void btnXoaDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDSPActionPerformed
        // TODO add your handling code here:
        row = tblDongSP.getSelectedRow();
        int MaDSP = (int) tblDongSP.getValueAt(row, 0);
        if (dspsv.CheckXoa(MaDSP) == null) {
            dspsv.delete(MaDSP);
            this.fillDongSanPham();
            DialogHelper.alert(this, "Xóa thành công");
            txtGhiChuDSP.setText(null);
            txtTenDSP.setText(null);
        } else
            DialogHelper.alert(this, "Chỉ được xóa mềm dòng này!!!");
    }//GEN-LAST:event_btnXoaDSPActionPerformed

    private void btnMoiDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiDSPActionPerformed
        txtTenDSP.setText(null);
        txtGhiChuDSP.setText(null);
    }//GEN-LAST:event_btnMoiDSPActionPerformed

    private void tblDongSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDongSPMouseClicked
        // TODO add your handling code here:
        row = tblDongSP.getSelectedRow();
        this.showformDSP();
    }//GEN-LAST:event_tblDongSPMouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        if (this.checkLH() == true) {
            LoaiHang lh = this.readformLH();
            lhsv.add(lh);
            this.fillLoaiHang();
            DialogHelper.alert(this, "Them thanh cong");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        row = tblLoaiHang.getSelectedRow();
        int MaLH = (int) tblLoaiHang.getValueAt(row, 0);
        LoaiHang lh = this.readformLH();
        lhsv.update(lh, MaLH);
        fillLoaiHang();
        DialogHelper.alert(this, "Sửa thành công");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void tblLoaiHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiHangMouseClicked
        // TODO add your handling code here:
        row = tblLoaiHang.getSelectedRow();
        this.showformLH();
    }//GEN-LAST:event_tblLoaiHangMouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        row = tblLoaiHang.getSelectedRow();
        int MaLH = (int) tblLoaiHang.getValueAt(row, 0);
        if (lhsv.CheckXoa(MaLH) == null) {
            lhsv.delete(MaLH);
            this.fillLoaiHang();
            DialogHelper.alert(this, "Xóa thành công");
            txtGhiChuLH.setText(null);
            txtTenLH.setText(null);
        } else
            DialogHelper.alert(this, "Chỉ được xóa mềm dòng này!!!");
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        row = tblXuatXu.getSelectedRow();
        int MaXX = (int) tblXuatXu.getValueAt(row, 0);
        XuatXu xx = this.readformXX();
        xxsv.update(xx, MaXX);
        fillXuatXu(xxsv.getAll());
        DialogHelper.alert(this, "Sửa thành công");
        fillCombox();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void btnTimKiemXXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemXXActionPerformed
        // TODO add your handling code here:
        this.TimKiemXX();
    }//GEN-LAST:event_btnTimKiemXXActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        if (checkTH() == true) {
            ThuongHieu th = this.readformTH();
            thsv.add(th);
            this.fillThuongHieu(thsv.getAll());
            DialogHelper.alert(this, "Them thanh cong");
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        if (checkTH() == true) {
            row = tblThuongHieu.getSelectedRow();
            int MaTH = (int) tblThuongHieu.getValueAt(row, 0);
            ThuongHieu th = this.readformTH();
            boolean trangThai = (boolean) tblThuongHieu.getValueAt(row, 2);
            th.setTrangThai(trangThai);
            thsv.update(th, MaTH);
            fillThuongHieu(thsv.getAll());
            DialogHelper.alert(this, "Sửa thành công");
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        row = tblThuongHieu.getSelectedRow();
        int MaTH = (int) tblThuongHieu.getValueAt(row, 0);
        if (thsv.CheckXoa(MaTH) == null) {
            thsv.delete(MaTH);
            this.fillThuongHieu(thsv.getAll());
            DialogHelper.alert(this, "Xóa thành công");
            txtGhiChuTH.setText(null);
            txtTenTH.setText(null);
        } else
            DialogHelper.alert(this, "Chỉ được xóa mềm dòng này!!!");
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        txtGhiChuTH.setText(null);
        txtTenTH.setText(null);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        ten = txt_tk.getText();
        trangThaiString = "";
        loadDataToTable();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void tbl_spMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_spMouseClicked
        // TODO add your handling code here:
        index = tbl_sp.getSelectedRow();
        spct = list.get(index);
        showdetail();
        setEditter();
    }//GEN-LAST:event_tbl_spMouseClicked

    private void txt_gianhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gianhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gianhapActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (!checkForm()) {
            return;
        }
        SanPham sp = readFormSP();
        SanPhamChiTiet spct = readFormSPCT();
        Integer rs = spctservice.insertSPCT(sp, spct);
        if (rs != null) {
            DialogHelper.alert(null, "Thêm thành công");
            qrcode(sp, spct);
            loadDataToTable();
        } else
            DialogHelper.alert(null, "Thêm thất bại");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        index = -1;
        ten = "";
        trangThaiString = "";
        newForm();
        setEditter();
        loadDataToTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (page > 1) {
            page--;
        }
        phanTrang.setText(String.valueOf(page));
        loadDataToTable();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        page++;
        phanTrang.setText(String.valueOf(page));
        loadDataToTable();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ArrayList<SanPham> x = ImportExcell.importExcelDataSP(selectedFile);
            ArrayList<SanPhamChiTiet> spct = ImportExcell.importExcelDataSPCT(selectedFile);
//            System.out.println(x.get(0).getMaXuatXu());
//            // Do something with the imported data (data List)
//            System.out.println(x.get(0).getMaSanPham());
//            System.out.println(x.get(0).getTenSanPham());
//            System.out.println(x.get(0).getMaThuongHieu());
//            System.out.println(x.get(0).getMaDongSanPham());
//            System.out.println(x.get(0).getMaLoaiHang());
//            System.out.println(spct.get(0).getAnhSanPham());
//            System.out.println(spct.get(0).getMaDonViTinh());
            System.out.println(spct);
            try {
                int ind = 0;
                Integer rs = null;
                for (SanPhamChiTiet spct1 : spct) {
                    SanPham sp = x.get(ind);
                    rs = spctservice.insertSPCT(sp, spct1);
                    qrcode(sp, spct1);
                    ind++;
                }
                if (rs != null) {
                    DialogHelper.alert(null, "Thêm thành công");
                    loadDataToTable();
                } else {
                    DialogHelper.alert(null, "Thêm thất bại");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        path1 = FileChoose.chooseFile();
        java.awt.Image orImage = new ImageIcon(path + path1).getImage();
        java.awt.Image resize = orImage.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        lbl_HinhAnh.setIcon(new ImageIcon(resize));
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if (index == -1) {
            DialogHelper.alert(null, "Mời chọn sản phẩm muốn xóa");
            return;
        }
        SanPhamChiTiet spct1 = spctservice.checkSPCTinDH(spct.getMaSanPhamChiTiet());
        KhuyenMai km1 = khuyenMaiService.searchKMofAllSP(spct.getMaSanPhamChiTiet());
        if (spct1 != null || km1 != null) {
            DialogHelper.alert(null, "Sản phẩm đã trong đơn hàng hoặc khuyến mãi");
            SanPham sp = new SanPham();
            spct.setTrangThai(false);
            spctservice.updateSPCT(sp, spct);
            loadDataToTable();
            DialogHelper.alert(null, "Đã chuyển trạng thái sản phẩm");
        } else {
            Integer chon = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa chứ");
            if (chon != 0) {
                return;
            }
            Integer rs = spctservice.deleteSPCT(spct.getMaSanPhamChiTiet());
            if (rs != null) {
                DialogHelper.alert(null, "Xóa thành công");
                loadDataToTable();
            }
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void rdo_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_stopActionPerformed
        // TODO add your handling code here:
        ten = "";
        trangThaiString = rdo_stop.isSelected() ? "0" : "1";
        loadDataToTable();
    }//GEN-LAST:event_rdo_stopActionPerformed

    private void rdo_tiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_tiepActionPerformed
        // TODO add your handling code here:
        ten = "";
        trangThaiString = rdo_stop.isSelected() ? "0" : "1";
        loadDataToTable();
    }//GEN-LAST:event_rdo_tiepActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        fillCombox();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tblThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuongHieuMouseClicked
        // TODO add your handling code here:
        row = tblThuongHieu.getSelectedRow();
        this.showformTH();
    }//GEN-LAST:event_tblThuongHieuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi1;
    private javax.swing.JButton btnMoiDSP;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnSuaDSP;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnThemDSP;
    private javax.swing.JButton btnTimKiemTH;
    private javax.swing.JButton btnTimKiemXX;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXoaDSP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cboDonViTinh;
    private javax.swing.JComboBox<String> cboDongSP;
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JComboBox<String> cboXuatXu;
    private javax.swing.JComboBox<String> cbo_dvkl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_HinhAnh;
    private javax.swing.JLabel phanTrang;
    private javax.swing.JRadioButton rdoDangHT;
    private javax.swing.JRadioButton rdoNgungHT;
    private javax.swing.JRadioButton rdo_stop;
    private javax.swing.JRadioButton rdo_tiep;
    private javax.swing.JTable tblDonViTinh;
    private javax.swing.JTable tblDongSP;
    private javax.swing.JTable tblLoaiHang;
    private javax.swing.JTable tblThuongHieu;
    private javax.swing.JTable tblXuatXu;
    private javax.swing.JTable tbl_sp;
    private javax.swing.JTextArea txtGhiChuDSP;
    private javax.swing.JTextArea txtGhiChuDVT;
    private javax.swing.JTextArea txtGhiChuLH;
    private javax.swing.JTextArea txtGhiChuTH;
    private javax.swing.JTextField txtMaDSP;
    private javax.swing.JTextField txtMaDVT;
    private javax.swing.JTextField txtTenDSP;
    private javax.swing.JTextField txtTenDVT;
    private javax.swing.JTextField txtTenLH;
    private javax.swing.JTextField txtTenTH;
    private javax.swing.JTextField txtTimKiemTH;
    private javax.swing.JTextField txtTimKiemXX;
    private javax.swing.JTextField txt_barcode;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_gianhap;
    private javax.swing.JTextField txt_hansd;
    private javax.swing.JTextField txt_kl;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngayxk;
    private javax.swing.JTextField txt_sl;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_tk;
    // End of variables declaration//GEN-END:variables
private void loadDataToTable() {
        mol.setRowCount(0);
        list = spctservice.pagingByTen(page, 10, ten, trangThaiString);
        int vitri = 1;
        if (page != 1) {
            vitri = (page - 1) * 10 + 1;
        }
        for (SanPhamChiTiet spct : list) {
            SanPham sp = spctservice.searchByIdSP(spct.getMaSanPham());
            DecimalFormat decimalFormat = new DecimalFormat("#,### VND");

            // Định dạng số và in ra
            String formattedAmount = decimalFormat.format(spct.getDonGia());
            mol.addRow(new Object[]{
                vitri, sp.getTenSanPham(),
                thsv.findByID(sp.getMaThuongHieu()).getTenThuongHieu(),
                lhsv.findByID(sp.getMaLoaiHang()).getTenLoaiHang(),
                dspsv.findByID(sp.getMaDongSanPham()).getTenDongSanPham(),
                dvtsv.findByID(spct.getMaDonViTinh()).getTenDonViTinh(),
                spct.getHanSuDung(),
                spct.getSoLuong(),
                formattedAmount,
                xxsv.findByID(sp.getMaXuatXu()).getTenXuatXu(),
                spct.getKhoiLuong() + " " + spct.getDonViTinhKhoiLuong(),
                spct.getTrangThai(),
                spct.getAnhSanPham()
            });
            vitri++;
        }
    }

    public void showdetail() {
        SanPham sp = spctservice.searchByIdSP(spct.getMaSanPham());
        txt_barcode.setText(spct.getBarcode());
        DecimalFormat decimalFormat = new DecimalFormat("#,### VND");

        // Định dạng số và in ra
        String formattedAmount = decimalFormat.format(spct.getDonGia());
        txt_dongia.setText(formattedAmount);
        txt_hansd.setText(spct.getHanSuDung());
        txt_ma.setText(spct.getMaSanPham());
        txt_ngayxk.setText(spct.getNgaySanXuat());
        txt_sl.setText(String.valueOf(spct.getSoLuong()));
        txt_ten.setText(sp.getTenSanPham());
        txt_kl.setText(String.valueOf(spct.getKhoiLuong()));
        cbo_dvkl.setSelectedItem(spct.getDonViTinhKhoiLuong());
        formattedAmount = decimalFormat.format(spct.getGiaNhap());
        txt_gianhap.setText(formattedAmount);
        comboboxdsp.setSelectedItem(mol.getValueAt(index, 4));
        comboboxdvt.setSelectedItem(mol.getValueAt(index, 5));
        comboboxlh.setSelectedItem(mol.getValueAt(index, 3));
        comboboxth.setSelectedItem(mol.getValueAt(index, 2));
        comboboxxx.setSelectedItem(mol.getValueAt(index, 9));
        java.awt.Image orImage = new ImageIcon(path + spct.getAnhSanPham()).getImage();
        java.awt.Image resize = orImage.getScaledInstance(210, 200, java.awt.Image.SCALE_SMOOTH);
        lbl_HinhAnh.setIcon(new ImageIcon(resize));
    }

    public SanPham readFormSP() {

        SanPham x = new SanPham();
        x.setMaSanPham(txt_ma.getText());
        x.setTenSanPham(txt_ten.getText());
        x.setMoTa("");
        x.setMaThuongHieu(thsv.getByName(cboThuongHieu.getSelectedItem() + "").get(0).getMaThuongHieu());
        x.setMaLoaiHang(cboLoaiSP.getSelectedIndex() + 1);
        x.setMaDongSanPham(cboDongSP.getSelectedIndex() + 1);
        x.setMaXuatXu(xxsv.getByName(cboXuatXu.getSelectedItem() + "").get(0).getMaXuatXu());
        return x;
    }

    public SanPhamChiTiet readFormSPCT() {
        SanPhamChiTiet x = new SanPhamChiTiet();
        x.setMaSanPham(txt_ma.getText());
        x.setMaDonViTinh(cboDonViTinh.getSelectedIndex() + 1);
        x.setAnhSanPham(path1);
        x.setHanSuDung(txt_hansd.getText());
        try {
            x.setSoLuong(Integer.valueOf(txt_sl.getText()));
        } catch (Exception e) {
            DialogHelper.alert(null, "Số lượng sai định dạng");
            return null;
        }
        String cleanAmount = txt_gianhap.getText().replaceAll("[^\\d.]", "");
        x.setGiaNhap(Float.valueOf(cleanAmount));
        cleanAmount = txt_dongia.getText().replaceAll("[^\\d.]", "");
        x.setDonGia(Float.valueOf(cleanAmount));
        x.setKhoiLuong(Float.valueOf(txt_kl.getText()));
        x.setDonViTinhKhoiLuong(cbo_dvkl.getSelectedItem() + "");
        x.setNgaySanXuat(txt_ngayxk.getText());
        x.setBarcode(txt_barcode.getText());

        if (index != -1) {
            x.setTrangThai((boolean) tbl_sp.getValueAt(index, 11));
            x.setAnhSanPham(list.get(index).getAnhSanPham());
        }
        return x;
    }

    private void newForm() {
        SanPhamChiTiet spct = new SanPhamChiTiet();
        SanPham sp = new SanPham();
        txt_barcode.setText(spct.getBarcode());
        txt_dongia.setText(String.valueOf(spct.getDonGia()));
        txt_hansd.setText(spct.getHanSuDung());
        txt_ma.setText(String.valueOf(spct.getMaSanPhamChiTiet()));
        txt_ngayxk.setText(spct.getNgaySanXuat());
        txt_sl.setText(String.valueOf(spct.getSoLuong()));
        txt_ten.setText(sp.getTenSanPham());
        txt_kl.setText(String.valueOf(spct.getKhoiLuong()));
        cbo_dvkl.setSelectedItem(spct.getDonViTinhKhoiLuong());

        txt_gianhap.setText(String.valueOf(spct.getGiaNhap()));
        comboboxdsp.setSelectedItem("");
        comboboxdvt.setSelectedItem("");
        comboboxlh.setSelectedItem("");
        comboboxth.setSelectedItem("");
        comboboxxx.setSelectedItem("");
        lbl_HinhAnh.setIcon(new ImageIcon());
    }

    public boolean checkValidate() {
        if (txt_ma.getText().isEmpty() || txt_ten.getText().isEmpty() || txt_dongia.getText().isEmpty()
                || txt_gianhap.getText().isEmpty() || txt_kl.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private void setEditter() {
        if (index != -1) {
            txt_ma.setEditable(false);
        } else {
            txt_ma.setEditable(true);
        }
    }

    public void qrcode(SanPham sp, SanPhamChiTiet spct) {
        int size = 200; // Kích thước của mã QR code
        String text = spct.getBarcode();
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, size, size);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

            // Đường dẫn mặc định là ổ C và tên tệp là "QRCode.png"
            String defaultDirectory = ".\\asset\\AnhQRcodeSanPham\\";
            if (Auth.HDH == 1) {
                path = "./asset/AnhQRcodeSanPham/";
            }
            String fileName = sp.getTenSanPham() + spct.getKhoiLuong() + spct.getDonViTinhKhoiLuong() + ".png";
            File outputFile = new File(defaultDirectory, fileName);

            ImageIO.write(image, "PNG", outputFile);

            System.out.println(outputFile);
        } catch (WriterException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean checkForm() {
        String maSp = txt_ma.getText().trim();
        if (maSp.isEmpty()) {
            DialogHelper.alert(this, "Mã sản phẩm không được để trống");
            return false;
        }
        if(!maSp.matches("^SP0\\d+$")){
             DialogHelper.alert(this, "Mã sản phẩm sai định dạng");
            return false;
        }
        String tenSp = txt_ten.getText().trim();
        if (tenSp.isEmpty()) {
            DialogHelper.alert(this, "Tên sản phẩm không được để trống");
            return false;
        }
        String ngayXk = txt_ngayxk.getText().trim();
        if (ngayXk.isEmpty()) {
            DialogHelper.alert(this, "Ngày sản xuất không được để trống");
            return false;
        }
        if(!XDate.isValidDateRange(ngayXk)){
            JOptionPane.showMessageDialog(null,"Ngày sinh sai định dạng");
            return false;
        }
        String hanSd = txt_hansd.getText().trim();
        if (hanSd.isEmpty()) {
            DialogHelper.alert(this, "Hạn sử dụng không được để trống");
            return false;
        }
        if (!XDate.isValidExpiryDate(hanSd)) {
            DialogHelper.alert(this, "Hạn sử dụng sai định dạng");
            return false;
        }
        String sl = txt_sl.getText().trim();
        if (sl.isEmpty()) {
            DialogHelper.alert(this, "Số lượng không được để trống");
            return false;
        }
        if (!StringFormat.isValidNumberFormat(sl)) {
            DialogHelper.alert(null, "Số lượng sai định dạng");
            return false;
        }
        String donGia = txt_dongia.getText().trim();
        if (donGia.isEmpty()) {
            DialogHelper.alert(this, "Đơn giá không được để trống");
            return false;
        }
        if (!StringFormat.isValidMoneyFormat(donGia) && !StringFormat.isValidNumberFormat(donGia)) {
            DialogHelper.alert(null, "Đơn giá sai định dạng");
            return false;
        }
        String giaNhap = txt_gianhap.getText().trim();
        if (giaNhap.isEmpty()) {
            DialogHelper.alert(this, "Giá nhập không được để trống");
            return false;
        }
        if (!StringFormat.isValidMoneyFormat(giaNhap) && !StringFormat.isValidNumberFormat(giaNhap)) {
            DialogHelper.alert(null, "Giá nhập sai định dạng");
            return false;
        }
        String kl = txt_kl.getText().trim();
        if (kl.isEmpty()) {
            DialogHelper.alert(this, "Khối lượng không được để trống");
            return false;
        }
        if (!StringFormat.isValidNumberFormat(kl)) {
            DialogHelper.alert(null, "Khối lượng sai định dạng");
            return false;
        }
        
        return true;
    }
}
