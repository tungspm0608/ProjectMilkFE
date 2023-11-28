package view;

import helper.XDate;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DonHang;
import model.DonHangChiTiet;
import model.HoaDon;
import model.SanPham;
import model.SanPhamChiTiet;
import service.DonHangService;
import service.DonViTinh_service;
//import service.HoaDonService;
import service.SanPhamChiTietService;

/**
 *
 * @author phungvantung
 */
public class HoaDon_JPanel extends javax.swing.JPanel {

    DefaultTableModel mol = new DefaultTableModel();
    DefaultTableModel mol1 = new DefaultTableModel();
    DonHangService hdsv = new DonHangService();
    SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietService();
    DonViTinh_service donViTinhService = new DonViTinh_service();

    DonHangChiTiet dhct;
    DonHang dh;
    ArrayList<DonHang> hDList = new ArrayList<>();
    ArrayList<DonHangChiTiet> dHCTList = new ArrayList<>();
    int row = -1, page = 1;
    DecimalFormat decimalFormat = new DecimalFormat("#,### VND");

    public HoaDon_JPanel() {
        initComponents();
        this.setBackground(new Color(37, 108, 205));
        mol = (DefaultTableModel) tblHoaDon.getModel();
        mol1 = (DefaultTableModel) tbl_dhct.getModel();
        this.fillTableDH();
    }

    void fillTableDH() {
        mol.setRowCount(0);
        hDList = hdsv.getAllHD(page, 10);
        int viti = 1;
        if (page != 1) {
            viti = page * 10;
        }
        for (DonHang h : hDList) {
            mol.addRow(new Object[]{viti, h.getMaNhanVien(), h.getMaKhachHang(), h.getTienGiam(), h.getTongTien(), h.getNgayTao(),
                h.getLoaiDonHang() == 2 ? "Đặt hàng" : h.getLoaiDonHang() == 4 ? "Tại quầy" : "Đã hủy"});
            viti++;
        }
    }

    void Loc() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String d1 = XDate.toString(dateDau.getDate(), "");
        Date date1 = dateDau.getDate();
        String d1 = sdf.format(date1);
        System.out.println(d1);
        Date date2 = dateCuoi.getDate();
        String d2 = sdf.format(date2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLoc = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dateDau = new com.toedter.calendar.JDateChooser();
        dateCuoi = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_dhct = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        vitri = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel9.setText("Từ");

        jLabel10.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel10.setText("Đến");

        btnLoc.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/Wizard.png"))); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDau, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(btnLoc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblHoaDon.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Mã khách hàng ", "Tiền giảm", "Tổng tiền", "Ngày lập", "Loại HD"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        tbl_dhct.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        tbl_dhct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "ĐVT", "Khối lượng", "Đơn giá", "Số lượng", "Thành tiền", "Trả lại"
            }
        ));
        tbl_dhct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dhctMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_dhct);

        jButton2.setText("Prev");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Next");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        vitri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vitri.setForeground(new java.awt.Color(255, 255, 255));
        vitri.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(9, 9, 9)
                        .addComponent(vitri)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(vitri))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        this.Loc();
    }//GEN-LAST:event_btnLocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.fillTableDH();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_dhctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dhctMouseClicked
        // TODO add your handling code here:
        row = tbl_dhct.getSelectedRow();
        dhct = dHCTList.get(row);
    }//GEN-LAST:event_tbl_dhctMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        page++;
        vitri.setText(String.valueOf(page));
        fillTableDH();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (page > 1) {
            page--;
        }
        vitri.setText(String.valueOf(page));
        fillTableDH();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        row = tblHoaDon.getSelectedRow();
        dh = hDList.get(row);
        fillTableDHCT();
    }//GEN-LAST:event_tblHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoc;
    private com.toedter.calendar.JDateChooser dateCuoi;
    private com.toedter.calendar.JDateChooser dateDau;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tbl_dhct;
    private javax.swing.JLabel vitri;
    // End of variables declaration//GEN-END:variables

    private void fillTableDHCT() {
        mol1.setRowCount(0);
        dHCTList = hdsv.getAllDHCT(dh.getMaDonHang());
        int vitri = 1;
        if (page != 1) {
            vitri = page * 10;
        }
        for (DonHangChiTiet dhct : dHCTList) {
            SanPhamChiTiet spct = sanPhamChiTietService.searchByIdSPCT(dhct.getMaSanPhamChiTiet());
            SanPham sp = sanPhamChiTietService.searchByIdSP(spct.getMaSanPham());
            String formattedAmount = decimalFormat.format(dhct.getGiaGiam());
            String formattedAmount1 = decimalFormat.format(dhct.getTongGia());
            mol1.addRow(new Object[]{
                vitri, sp.getTenSanPham(), donViTinhService.findByID(spct.getMaDonViTinh()).toString(),
                spct.getKhoiLuong() + " " + spct.getDonViTinhKhoiLuong(), formattedAmount, dhct.getSoLuong(),
                formattedAmount1, dhct.getTraHang()
            });
            vitri++;
        }
    }
}
