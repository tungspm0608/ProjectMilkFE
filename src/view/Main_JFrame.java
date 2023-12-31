/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import helper.DialogHelper;
import helper.XDate;
import service.Auth;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;

/**
 *
 * @author phungvantung
 */
public class Main_JFrame extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main_JFrame() {
        this.setUndecorated(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        double width = toolkit.getScreenSize().getWidth();
        double height = toolkit.getScreenSize().getHeight();
        System.out.println(width);
        System.out.println(height);
        
        initComponents();
        this.getContentPane().setBackground(new Color(37, 108, 205));
        JPTitle.setBackground(new Color(37, 108, 205));
        JPContent.setBackground(new Color(37, 108, 205));
        JPFeature.setBackground(new Color(37, 108, 205));
        JPPanelContainer.setBackground(new Color(37, 108, 205));
        
        if (Auth.HDH == 1) {
            this.setSize((int) width, (int) height);
        } else {
            this.setSize((int) width-480, (int) height-170);
        }
        setLocation(0, 0);
        setLocationRelativeTo(null);
        
        lblTenNhanVien.setText(Auth.user.getTenNhanVien());
        lblVaiTro.setText(Auth.user.getVaiTro());
        lblThoiGianVao.setText(XDate.toString(XDate.now(), "HH:mm dd/MM/yyyy"));
        if (Auth.user.getVaiTro().equalsIgnoreCase("Nhân Viên")) {
            jButton15.setEnabled(false);
            jButton15.setBackground(Color.LIGHT_GRAY);
        }
        
        //dong ho
        this.dongHo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTBActivity = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton9 = new javax.swing.JButton();
        JPTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbldongHo = new javax.swing.JLabel();
        JPContent = new javax.swing.JPanel();
        JPFeature = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblThoiGianVao = new javax.swing.JLabel();
        lblVaiTro = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JPPanelContainer = new javax.swing.JPanel();
        JTPMain = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTBActivity.setBorder(null);
        JTBActivity.setRollover(true);
        JTBActivity.setPreferredSize(new java.awt.Dimension(1440, 50));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/Exit.png"))); // NOI18N
        jButton1.setText("Đăng xuất");
        jButton1.setBorder(null);
        jButton1.setBounds(new java.awt.Rectangle(0, 0, 50, 50));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        JTBActivity.add(jButton1);

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/Blue key.png"))); // NOI18N
        jButton2.setText("Đổi mật khẩu");
        jButton2.setBorder(null);
        jButton2.setBounds(new java.awt.Rectangle(0, 5, 0, 5));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        JTBActivity.add(jButton2);

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/Stop sign.png"))); // NOI18N
        jButton3.setText("Kết thúc");
        jButton3.setBorder(null);
        jButton3.setBounds(new java.awt.Rectangle(0, 5, 0, 5));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        JTBActivity.add(jButton3);
        JTBActivity.add(jSeparator1);

        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/Box.png"))); // NOI18N
        jButton4.setText("Combo Sản phẩm");
        jButton4.setBorder(null);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        JTBActivity.add(jButton4);

        jButton5.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/User group.png"))); // NOI18N
        jButton5.setText("Khách hàng");
        jButton5.setBorder(null);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        JTBActivity.add(jButton5);

        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/List.png"))); // NOI18N
        jButton6.setText("Hoá đơn");
        jButton6.setBorder(null);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        JTBActivity.add(jButton6);

        jButton7.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/Basket.png"))); // NOI18N
        jButton7.setText("Sản phẩm");
        jButton7.setBorder(null);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        JTBActivity.add(jButton7);
        JTBActivity.add(jSeparator2);

        jButton8.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/Card file.png"))); // NOI18N
        jButton8.setText("Hướng dẫn sử dụng");
        jButton8.setBorder(null);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JTBActivity.add(jButton8);
        JTBActivity.add(jSeparator3);

        jButton9.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/IconSystem/icon 2/Info.png"))); // NOI18N
        jButton9.setText("Giới thiệu sản phẩm");
        jButton9.setBorder(null);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JTBActivity.add(jButton9);

        JPTitle.setBackground(new java.awt.Color(0, 204, 204));
        JPTitle.setPreferredSize(new java.awt.Dimension(1440, 40));

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(172, 214, 255));
        jLabel1.setText("Phần mềm bán sữa MilkFE");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/iconSystem/close.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/iconSystem/minus.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        lbldongHo.setForeground(new java.awt.Color(204, 204, 204));
        lbldongHo.setText("Giờ hiện tại : ");

        javax.swing.GroupLayout JPTitleLayout = new javax.swing.GroupLayout(JPTitle);
        JPTitle.setLayout(JPTitleLayout);
        JPTitleLayout.setHorizontalGroup(
            JPTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldongHo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(470, 470, 470)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        JPTitleLayout.setVerticalGroup(
            JPTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(JPTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldongHo))
                .addContainerGap())
        );

        JPContent.setBackground(new java.awt.Color(0, 204, 204));
        JPContent.setForeground(new java.awt.Color(51, 255, 255));
        JPContent.setPreferredSize(new java.awt.Dimension(1440, 0));

        JPFeature.setBackground(new java.awt.Color(0, 204, 204));
        JPFeature.setPreferredSize(new java.awt.Dimension(260, 820));

        jButton11.setBackground(new java.awt.Color(172, 214, 255));
        jButton11.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton11.setText("Bán hàng");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(172, 214, 255));
        jButton12.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton12.setText("Hoá đơn");
        jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(172, 214, 255));
        jButton13.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton13.setText("Sản phẩm");
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(172, 214, 255));
        jButton14.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton14.setText("Khuyến mãi");
        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(172, 214, 255));
        jButton15.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton15.setText("Khách hàng");
        jButton15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(172, 214, 255));
        jButton16.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton16.setText("Thống kê");
        jButton16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(172, 214, 255));
        jButton17.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jButton17.setText("Nhân Viên");
        jButton17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(172, 214, 255));

        jLabel3.setText("Nhân viên :");

        jLabel5.setText("Vai trò :");

        jLabel7.setText("TG đăng nhập :");

        lblThoiGianVao.setText("02:40 30/01/2023");

        lblVaiTro.setText("Chủ cửa hàng");

        lblTenNhanVien.setText("Phùng Văn Tùng");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/image/MilkFE_63-5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblThoiGianVao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVaiTro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTenNhanVien)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTenNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaiTro)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblThoiGianVao))
                .addContainerGap())
        );

        javax.swing.GroupLayout JPFeatureLayout = new javax.swing.GroupLayout(JPFeature);
        JPFeature.setLayout(JPFeatureLayout);
        JPFeatureLayout.setHorizontalGroup(
            JPFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPFeatureLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPFeatureLayout.setVerticalGroup(
            JPFeatureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPFeatureLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(13, 13, 13)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16)
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        JPFeatureLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton11, jButton12, jButton13, jButton14, jButton15, jButton16, jButton17});

        JPPanelContainer.setBackground(new java.awt.Color(0, 204, 204));
        JPPanelContainer.setPreferredSize(new java.awt.Dimension(1100, 820));

        JTPMain.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        javax.swing.GroupLayout JPPanelContainerLayout = new javax.swing.GroupLayout(JPPanelContainer);
        JPPanelContainer.setLayout(JPPanelContainerLayout);
        JPPanelContainerLayout.setHorizontalGroup(
            JPPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPanelContainerLayout.createSequentialGroup()
                .addComponent(JTPMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPPanelContainerLayout.setVerticalGroup(
            JPPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPPanelContainerLayout.createSequentialGroup()
                .addComponent(JTPMain, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JPContentLayout = new javax.swing.GroupLayout(JPContent);
        JPContent.setLayout(JPContentLayout);
        JPContentLayout.setHorizontalGroup(
            JPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContentLayout.createSequentialGroup()
                .addComponent(JPFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JPContentLayout.setVerticalGroup(
            JPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContentLayout.createSequentialGroup()
                .addGroup(JPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JPTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(JTBActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTBActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPContent, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        boolean check = DialogHelper.confirm(this, "Bạn có chắc chắn muốn kết thúc phiên làm việc không ?");
        if (check == true) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
//        JTPMain.setSelectedIndex(JTPMain.getSe);
        int tabSelect = checkTabSelect("Bán hàng");
        if (tabSelect >= 0) {
            JTPMain.setSelectedIndex(tabSelect);
        } else {
            BanHang_JPanel newtab = new BanHang_JPanel();
            JTPMain.addTab("Bán hàng", newtab);
            int tabSelected = JTPMain.getTabCount();
            JTPMain.setSelectedIndex(tabSelected - 1);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DoiMatKhau_JDialog dmk = new DoiMatKhau_JDialog(this, rootPaneCheckingEnabled);
        dmk.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        this.moKhachHang();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        int tabSelect = checkTabSelect("Nhân viên");
        if (tabSelect >= 0) {
            JTPMain.setSelectedIndex(tabSelect);
        } else {
            NhanVien_JPanel newtab = new NhanVien_JPanel();
            JTPMain.addTab("Nhân viên", newtab);
            int tabSelected = JTPMain.getTabCount();
            JTPMain.setSelectedIndex(tabSelected - 1);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        int tabSelect = checkTabSelect("Thống kê");
        if (tabSelect >= 0) {
            JTPMain.setSelectedIndex(tabSelect);
        } else {
            ThongKe_JPanel newtab = new ThongKe_JPanel();
            JTPMain.addTab("Thống kê", newtab);
            int tabSelected = JTPMain.getTabCount();
            JTPMain.setSelectedIndex(tabSelected - 1);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        this.moSanPham();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        this.moHoaDon();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
//        ComboSP_JFrame newFrame = new ComboSP_JFrame();
//        newFrame.setVisible(true);
//        newFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        int tabSelect = checkTabSelect("Khuyến mãi");
        if (tabSelect >= 0) {
            JTPMain.setSelectedIndex(tabSelect);
        } else {
            KhuyenMai_JPanel newtab = new KhuyenMai_JPanel();
            JTPMain.addTab("Khuyến mãi", newtab);
            int tabSelected = JTPMain.getTabCount();
            JTPMain.setSelectedIndex(tabSelected - 1);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean check = DialogHelper.confirm(this, "Bạn có chắc chắn muốn đăng xuất không ?");
        if (check == true) {
            Auth.clear();
            this.dispose();
            //trường hợp mở các form khác nữa thì chưa dispose hết
            DangNhap_JFrame newFrame = new DangNhap_JFrame();
            newFrame.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        boolean check = DialogHelper.confirm(this, "Bạn có chắc chắn muốn kết thúc phiên làm việc không ?");
        if (check == true) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.moKhachHang();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.moHoaDon();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.moSanPham();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void moKhachHang () {
        int tabSelect = checkTabSelect("Khách hàng");
        if (tabSelect >= 0) {
            JTPMain.setSelectedIndex(tabSelect);
        } else {
            KhachHangThanThiet_JPanel newtab = new KhachHangThanThiet_JPanel();
            JTPMain.addTab("Khách hàng", newtab);
            int tabSelected = JTPMain.getTabCount();
            JTPMain.setSelectedIndex(tabSelected - 1);
        }
    }
    
    private void moHoaDon () {
        int tabSelect = checkTabSelect("Hoá đơn");
        if (tabSelect >= 0) {
            JTPMain.setSelectedIndex(tabSelect);
        } else {
            HoaDon_JPanel newtab = new HoaDon_JPanel();
            JTPMain.addTab("Hoá đơn", newtab);
            int tabSelected = JTPMain.getTabCount();
            JTPMain.setSelectedIndex(tabSelected - 1);
        }
    }
    
    private void moSanPham() {
        int tabSelect = checkTabSelect("Sản phẩm");
        if (tabSelect >= 0) {
            JTPMain.setSelectedIndex(tabSelect);
        } else {
            SanPham_JPanel newtab = new SanPham_JPanel();
            JTPMain.addTab("Sản phẩm", newtab);
            int tabSelected = JTPMain.getTabCount();
            JTPMain.setSelectedIndex(tabSelected - 1);
        }
    }
    
    private int checkTabSelect(String tabName) {
        int countTab = JTPMain.getTabCount();
        for (int i = 0; i < countTab; i++) {
            if (JTPMain.getTitleAt(i).equalsIgnoreCase(tabName)) {
                return i;
            }
        }
        return -1;
    }
    
    private void dongHo() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                lbldongHo.setText(XDate.toString(XDate.now(),"EEE, dd MMM yyyy HH:mm:ss 'GMT'XX"));
            }
        };
        int period = 1000;
        Timer timer = new Timer("Dong ho");
        timer.schedule(timerTask, 0, period);
    }
    
    public JButton getBTNdangXuat() {
        return jButton1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPContent;
    private javax.swing.JPanel JPFeature;
    private javax.swing.JPanel JPPanelContainer;
    private javax.swing.JPanel JPTitle;
    private javax.swing.JToolBar JTBActivity;
    private javax.swing.JTabbedPane JTPMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblThoiGianVao;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JLabel lbldongHo;
    // End of variables declaration//GEN-END:variables
}
