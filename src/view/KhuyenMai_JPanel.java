package view;

import helper.XDate;
import model.KhuyenMai;
import model.KhuyenMaiChiTiet;
import model.SanPham;
import model.SanPhamChiTiet;
import service.KhuyenMaiService;
import service.SanPhamChiTietService;
import service.SanPhamService;
import java.awt.Color;
import java.sql.Date;
//import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dovan
 */
public class KhuyenMai_JPanel extends javax.swing.JPanel {

    DefaultTableModel modelKM = new DefaultTableModel();
    DefaultTableModel modelSP = new DefaultTableModel();
    KhuyenMaiService serKM = new KhuyenMaiService();
    SanPhamService serSP = new SanPhamService();
    SanPhamChiTietService serSPCT = new SanPhamChiTietService();
    ArrayList<KhuyenMai> list;
    ArrayList<Integer> list1=new ArrayList<>();
    ArrayList<SanPhamChiTiet> listSP;
    int index;
    int page = 1;
    String ten = "";
    String trangThai = "";
    String maKM;
    boolean trangThaiSP;

    public KhuyenMai_JPanel() {
        initComponents();
        this.setBackground(new Color(37, 108, 205));
        loadDataToTableKhuyenMai();
        loadDataToSanPham();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_MaKhuyenMai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_TenChuongTrinh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_GiatriGiam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_NgayBatDau = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_NgayKetThuc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_MoTa = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        txt_NgayBatDauTimKiem = new javax.swing.JTextField();
        txt_NgayKetThucTimKiem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btn_Loc = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_TimKiem = new javax.swing.JTextField();
        btn_TimTen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_KhuyenMai = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        btn_Moi = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_SanPham = new javax.swing.JTable();
        btn_CNTrangThai = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_DonViGiam = new javax.swing.JTextField();
        btn_ResetBang = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dòng sản phẩm");

        jTextField5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 204, 204));

        jLabel6.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Giảm icon: ");

        jTextField6.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 204, 204));

        setBackground(new java.awt.Color(0, 204, 204));
        setPreferredSize(new java.awt.Dimension(1100, 820));

        jPanel1.setBackground(new java.awt.Color(37, 108, 205));

        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã khuyến mãi: ");

        txt_MaKhuyenMai.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_MaKhuyenMai.setForeground(new java.awt.Color(0, 204, 204));

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên chương trình");

        txt_TenChuongTrinh.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_TenChuongTrinh.setForeground(new java.awt.Color(0, 204, 204));

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giảm giá");

        txt_GiatriGiam.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_GiatriGiam.setForeground(new java.awt.Color(0, 204, 204));

        jLabel7.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bắt đầu: ");

        txt_NgayBatDau.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_NgayBatDau.setForeground(new java.awt.Color(0, 204, 204));

        jLabel8.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mô tả:");

        txt_NgayKetThuc.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_NgayKetThuc.setForeground(new java.awt.Color(0, 204, 204));

        jLabel9.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kết thúc:");

        txt_MoTa.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_MoTa.setForeground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setViewportView(txt_MoTa);

        jLabel14.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Phân loại: ");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Còn hạn");

        jLabel10.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Từ");

        txt_NgayBatDauTimKiem.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_NgayBatDauTimKiem.setForeground(new java.awt.Color(0, 204, 204));

        txt_NgayKetThucTimKiem.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_NgayKetThucTimKiem.setForeground(new java.awt.Color(0, 204, 204));

        jLabel11.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Đến");

        btn_Loc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Loc.setText("Lọc");
        btn_Loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_NgayBatDauTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_NgayKetThucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Loc)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jLabel10)
                        .addComponent(txt_NgayBatDauTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txt_NgayKetThucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        jLabel15.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tìm kiếm :");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        txt_TimKiem.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_TimKiem.setForeground(new java.awt.Color(0, 204, 204));

        btn_TimTen.setText("Tìm kiếm tên");
        btn_TimTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_TimTen, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        tbl_KhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mại", "Tên chương trinh", "Giảm giá", "Bắt đầu", "Kết thúc", "Trạng thái", "Ghi chú"
            }
        ));
        tbl_KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_KhuyenMai);

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_CapNhat.setText("Cập nhật");
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });

        btn_Moi.setText("Mới");
        btn_Moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiActionPerformed(evt);
            }
        });

        tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Khối lượng", "Số lượng", "Hạn sử dụng", "Khuyến mại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_SanPham);

        btn_CNTrangThai.setText("Cập nhật trạng thái");
        btn_CNTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CNTrangThaiActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Đơn vị giảm");

        txt_DonViGiam.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txt_DonViGiam.setForeground(new java.awt.Color(0, 204, 204));

        btn_ResetBang.setText("Reset Bảng Sản Phẩm");
        btn_ResetBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetBangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_GiatriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_TenChuongTrinh, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_MaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Them)
                                .addGap(18, 18, 18)
                                .addComponent(btn_CapNhat)
                                .addGap(49, 49, 49)
                                .addComponent(btn_CNTrangThai)
                                .addGap(35, 35, 35)
                                .addComponent(btn_Moi)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_NgayKetThuc)
                                    .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(txt_DonViGiam))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8)
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btn_ResetBang))))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_MaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TenChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_GiatriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(txt_DonViGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them)
                            .addComponent(btn_CapNhat)
                            .addComponent(btn_CNTrangThai)
                            .addComponent(btn_Moi)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_ResetBang)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_KhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhuyenMaiMouseClicked
        // TODO add your handling code here:
        index = tbl_KhuyenMai.getSelectedRow();
        showKhuyenMai();
        loadDataToSanPham();
    }//GEN-LAST:event_tbl_KhuyenMaiMouseClicked

    private void btn_MoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_MoiActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        if (checkForm()) {
            Integer chon=null;
            for (Integer i : list1) {
                 KhuyenMaiChiTiet kmct=new KhuyenMaiChiTiet();
                 kmct.setMaSanPhamChiTiet(i);
                 kmct.setMaKhuyenMai(getKM().getMaKhuyenMai());
                chon= serKM.addKMSP( kmct, getKM());
            }
            if (chon != null) {
                JOptionPane.showMessageDialog(this, "Them Thanh cong");
                loadDataToTableKhuyenMai();
            } else {
                JOptionPane.showMessageDialog(this, "Them That bai");
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        // TODO add your handling code here:
        if (checkForm()) {
            if (serKM.updateKMCT(getKMCT(), getKM())>0) {
                JOptionPane.showMessageDialog(this, "Sua thanh cong");
                loadDataToTableKhuyenMai();
            } else {
                JOptionPane.showMessageDialog(this, "Sua that bai");
            }
        }
        
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void btn_CNTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CNTrangThaiActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_CNTrangThaiActionPerformed

    private void btn_TimTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimTenActionPerformed
        // TODO add your handling code here:

        ten = txt_TimKiem.getText();
        loadDataToTableKhuyenMai();

    }//GEN-LAST:event_btn_TimTenActionPerformed

    private void btn_ResetBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetBangActionPerformed
        // TODO add your handling code here:
        list1.removeAll(list1);
        modelSP = (DefaultTableModel) tbl_SanPham.getModel();
        modelSP.setRowCount(0);
        listSP = serSPCT.pagingByTen(page, 8, ten, trangThai);
        for (SanPhamChiTiet spct : serSPCT.pagingByTen(page, 8, ten, trangThai)) {
            SanPham sp=new SanPham();
            modelSP.addRow(new Object[]{
                spct.getMaSanPhamChiTiet(),
                sp.getTenSanPham(),
                spct.getDonGia(),
                spct.getSoLuong(),
                spct.getKhoiLuong(),
                spct.getHanSuDung()
            });
        }
    }//GEN-LAST:event_btn_ResetBangActionPerformed

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        // TODO add your handling code here:
        index = tbl_SanPham.getSelectedRow();
        trangThaiSP = (boolean) tbl_SanPham.getValueAt(index, 6);
        addSPCT();
    }//GEN-LAST:event_tbl_SanPhamMouseClicked

    private void tbl_SanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_SanPhamMouseEntered

    private void btn_LocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LocActionPerformed
        // TODO add your handling code here:
        Date now=Date.valueOf(LocalDate.now());
        
        if (now.after(Date.valueOf(txt_NgayBatDau.getText()))
                || now.before(Date.valueOf(txt_NgayKetThuc.getText()))
                ) {
           loadDataToTableKhuyenMai();
        } 
    }//GEN-LAST:event_btn_LocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CNTrangThai;
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_Loc;
    private javax.swing.JButton btn_Moi;
    private javax.swing.JButton btn_ResetBang;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimTen;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tbl_KhuyenMai;
    private javax.swing.JTable tbl_SanPham;
    private javax.swing.JTextField txt_DonViGiam;
    private javax.swing.JTextField txt_GiatriGiam;
    private javax.swing.JTextField txt_MaKhuyenMai;
    private javax.swing.JTextPane txt_MoTa;
    private javax.swing.JTextField txt_NgayBatDau;
    private javax.swing.JTextField txt_NgayBatDauTimKiem;
    private javax.swing.JTextField txt_NgayKetThuc;
    private javax.swing.JTextField txt_NgayKetThucTimKiem;
    private javax.swing.JTextField txt_TenChuongTrinh;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTableKhuyenMai() {
        modelKM = (DefaultTableModel) tbl_KhuyenMai.getModel();
        modelKM.setRowCount(0);
        list = serKM.paging(page, 10, ten);
        for (KhuyenMai km : list) {
            modelKM.addRow(new Object[]{
                km.getMaKhuyenMai(),
                km.getTenChuongTrinh(),
                km.getGiatriGiam(),
                km.getNgayBatDau(),
                km.getNgayKetThuc(),
                km.TrangThai(),
                km.getMoTa()
            });
        }
    }

    private void showKhuyenMai() {
        KhuyenMai kmct=serKM.paging(page, 10, ten).get(index);
        txt_MaKhuyenMai.setText(tbl_KhuyenMai.getValueAt(index, 0).toString());
        txt_TenChuongTrinh.setText(tbl_KhuyenMai.getValueAt(index, 1).toString());
        txt_GiatriGiam.setText(tbl_KhuyenMai.getValueAt(index, 2).toString());
        txt_NgayBatDau.setText(tbl_KhuyenMai.getValueAt(index, 3).toString());
        txt_NgayKetThuc.setText(tbl_KhuyenMai.getValueAt(index, 4).toString());
        txt_MoTa.setText(tbl_KhuyenMai.getValueAt(index, 6).toString());
        txt_DonViGiam.setText(String.valueOf(serKM.paging(page, 10, ten).get(index).getDonViGiam()));
    }

    private void clearForm() {
        txt_MaKhuyenMai.setText("");
        txt_TenChuongTrinh.setText("");
        txt_GiatriGiam.setText("");
        txt_NgayBatDau.setText("");
        txt_NgayKetThuc.setText("");
        txt_MoTa.setText("");
    }

    private void loadDataToSanPham() {
        modelSP = (DefaultTableModel) tbl_SanPham.getModel();
        modelSP.setRowCount(0);
        trangThaiSP=true;
        maKM =  (String) tbl_KhuyenMai.getValueAt(index, 0);
         listSP = serKM.listSP(maKM);
        for (SanPhamChiTiet spct : listSP) {
            SanPham sp=new SanPham();
            modelSP.addRow(new Object[]{
                spct.getMaSanPhamChiTiet(),
               sp.getTenSanPham(),
                spct.getDonGia(),
                spct.getSoLuong(),
                spct.getKhoiLuong(),
                spct.getHanSuDung(),
                trangThaiSP 
            });
        }
    }

    public KhuyenMaiChiTiet getKMCT() {
        KhuyenMaiChiTiet kmct = new KhuyenMaiChiTiet();
        kmct.setMaKhuyenMai(txt_MaKhuyenMai.getText());
        
        return kmct;
    }

    public KhuyenMai getKM() {
        KhuyenMai km = new KhuyenMai();
        km.setMaKhuyenMai(txt_MaKhuyenMai.getText());
        km.setTenChuongTrinh(txt_TenChuongTrinh.getText());
        km.setNgayBatDau(txt_NgayBatDau.getText());
        km.setNgayKetThuc(txt_NgayKetThuc.getText());
        km.setMoTa(txt_MoTa.getText());
        km.setDonViGiam(txt_DonViGiam.getText());
        km.setGiatriGiam(Integer.valueOf(txt_GiatriGiam.getText()));
        
//        Date now=Date.valueOf(LocalDate.now());
//        
//        if (now.after(Date.valueOf(txt_NgayBatDau.getText()))
//                || now.before(Date.valueOf(txt_NgayKetThuc.getText()))
//                ) {
//            km.setTrangThai(1);
//        } else {
//            km.setTrangThai(0);
//        }
        return km;
    }

    public boolean checkForm() {
        String maKM = txt_MaKhuyenMai.getText().trim();
        if (maKM.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ma khuyen mai khonh duoc de trong");
            return false;
        }
        String tenKM = txt_TenChuongTrinh.getText().trim();
        if (tenKM.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ten khuyen mai khonh duoc de trong");
            return false;
        }
        String giaTriGiam = txt_GiatriGiam.getText().trim();
        if (giaTriGiam.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gia tri giam khonh duoc de trong");
            return false;
        }
        String donViGiam = txt_DonViGiam.getText().trim();
        if (donViGiam.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Don vi giam khonh duoc de trong");
            return false;
        }
        String ngayBatDau = txt_NgayBatDau.getText().trim();
        if (ngayBatDau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngay bat dau khonh duoc de trong");
            return false;
        }
        String ngayKetThuc = txt_NgayKetThuc.getText().trim();
        if (ngayKetThuc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngay ket thuc khonh duoc de trong");
            return false;
        }
        String moTa = txt_MoTa.getText().trim();
        if (moTa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mo ta khonh duoc de trong");
            return false;
        }

        return true;
    }

    private void addSPCT() {
       trangThaiSP =(boolean) tbl_SanPham.getValueAt(index, 6);
        if (trangThaiSP) {
            System.out.println(index);
            list1.add(listSP.get(index).getMaSanPhamChiTiet());
        } else {
            list1.remove(tbl_SanPham.getValueAt(index, 0));
        }
    }

}