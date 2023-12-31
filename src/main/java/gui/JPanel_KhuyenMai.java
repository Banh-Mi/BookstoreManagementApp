package gui;

import com.toedter.calendar.JDateChooser;
import dao.KhachHangDAO;
import dao.KhuyenMaiDAO;
import entity.KhuyenMai;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class JPanel_KhuyenMai extends javax.swing.JPanel {

    private DefaultTableModel modelKhuyenMai;
    private KhuyenMaiDAO khuyenMaiDAO;
    private JPanel_KhuyenMai jpnkm;

    public JPanel_KhuyenMai() {

        initComponents();
        if (ngonNgu == 2) {
            ChuyenDoiNN();
        }
        svgAdd.setSvgImage("add.svg", 40, 40);
        svgEdit.setSvgImage("edit.svg", 35, 35);
        svgDelete.setSvgImage("delete.svg", 40, 40);
        svgRefresh.setSvgImage("refresh.svg", 35, 35);
        modelKhuyenMai = (DefaultTableModel) tableDiscount.getModel();
        loadData();
        DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tableDiscount.setSelectionModel(selectionModel);
        tableDiscount.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRowIndex = tableDiscount.getSelectedRow();
                if (selectedRowIndex >= 0) {
                    String maKhuyenMai = tableDiscount.getValueAt(selectedRowIndex, 0).toString();
                    String tenChuongTrinh = tableDiscount.getValueAt(selectedRowIndex, 1).toString();
                    float phanTramKhuyenMai = Float.parseFloat(tableDiscount.getValueAt(selectedRowIndex, 2).toString());
                    Date ngayBatDau = (Date) tableDiscount.getValueAt(selectedRowIndex, 3);
                    Date ngayKetThuc = (Date) tableDiscount.getValueAt(selectedRowIndex, 4);
                    String moTa = tableDiscount.getValueAt(selectedRowIndex, 5).toString();
                    txtmakm.setText(maKhuyenMai);
                    txttenchuongtrinh.setText(tenChuongTrinh);
                    txtphamtramgiam.setText(String.valueOf(phanTramKhuyenMai));
                    txtngaybatdau.setDate(ngayBatDau);
                    txtngayketthuc.setDate(ngayKetThuc);
                    txtmota.setText(moTa);
                }

            }
        });
    }

    public void ChuyenDoiNN() {
        lblDiscountID.setText("Discount ID:");
        lblNameProgram.setText("Name Program:");
        lblPercent.setText("Percent:");
        lblDob.setText("Start day:");
        lblDescribe.setText("Describe:");
        lblDob1.setText("End day:");
        jbAdd.setText("Add");
        jbDelete.setText("Delete");
        jbRefresh.setText("Refresh");
        jbEdit.setText("Edit");
        jbDiscountManagerment.setText("DISCOUNT MANAGERMENT");
    }

    private void loadData() {
        khuyenMaiDAO = new KhuyenMaiDAO();
        modelKhuyenMai.setRowCount(0);
        for (KhuyenMai km : khuyenMaiDAO.getAllKhuyenMai()) {
            Object[] row = {km.getMaKhuyenMai(), km.getTenChuongTrinh(), km.getPhanTramKhuyenMai(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getMoTa()};
            modelKhuyenMai.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gioiTinh = new javax.swing.ButtonGroup();
        jpTitle = new javax.swing.JPanel();
        jbDiscountManagerment = new javax.swing.JLabel();
        jpFunction = new javax.swing.JPanel();
        lblDiscountID = new javax.swing.JLabel();
        lblNameProgram = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        txtmota = new javax.swing.JTextField();
        lblDescribe = new javax.swing.JLabel();
        txttenchuongtrinh = new javax.swing.JTextField();
        txtmakm = new javax.swing.JTextField();
        txtngaybatdau = new com.toedter.calendar.JDateChooser();
        lblPercent = new javax.swing.JLabel();
        txtphamtramgiam = new javax.swing.JTextField();
        jpAdd = new util.JPanelRounded();
        jbAdd = new javax.swing.JLabel();
        svgAdd = new util.SVGImage();
        jpEdit = new util.JPanelRounded();
        jbEdit = new javax.swing.JLabel();
        svgEdit = new util.SVGImage();
        jpDelete = new util.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        jpRefresh = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();
        lblDob1 = new javax.swing.JLabel();
        txtngayketthuc = new com.toedter.calendar.JDateChooser();
        jPanelDiscountDetail = new javax.swing.JPanel();
        scrollDiscount = new javax.swing.JScrollPane();
        tableDiscount = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1040, 760));
        setLayout(new java.awt.BorderLayout());

        jpTitle.setLayout(new java.awt.BorderLayout());

        jbDiscountManagerment.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jbDiscountManagerment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbDiscountManagerment.setText("QUẢN LÝ KHUYẾN MÃI");
        jbDiscountManagerment.setPreferredSize(new java.awt.Dimension(438, 70));
        jpTitle.add(jbDiscountManagerment, java.awt.BorderLayout.CENTER);

        add(jpTitle, java.awt.BorderLayout.PAGE_START);

        jpFunction.setPreferredSize(new java.awt.Dimension(1010, 350));
        jpFunction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpFunctionKeyPressed(evt);
            }
        });
        jpFunction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDiscountID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDiscountID.setText("Mã khuyến mãi:");
        jpFunction.add(lblDiscountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 40));

        lblNameProgram.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNameProgram.setText("Tên chương trình:");
        jpFunction.add(lblNameProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 40));

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDob.setText("Ngày bắt đầu:");
        jpFunction.add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 40));

        txtmota.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtmota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmotaActionPerformed(evt);
            }
        });
        jpFunction.add(txtmota, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 270, 40));

        lblDescribe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDescribe.setText("Mô tả:");
        jpFunction.add(lblDescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 130, 40));

        txttenchuongtrinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txttenchuongtrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenchuongtrinhActionPerformed(evt);
            }
        });
        jpFunction.add(txttenchuongtrinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 250, 40));

        txtmakm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtmakm.setEnabled(false);
        txtmakm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakmActionPerformed(evt);
            }
        });
        jpFunction.add(txtmakm, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 190, 40));

        txtngaybatdau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpFunction.add(txtngaybatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 190, 40));

        lblPercent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPercent.setText("Phần trăm:");
        jpFunction.add(lblPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 40));

        txtphamtramgiam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtphamtramgiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphamtramgiamActionPerformed(evt);
            }
        });
        jpFunction.add(txtphamtramgiam, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 180, 40));

        jpAdd.setBackground(new java.awt.Color(255, 255, 255));
        jpAdd.setRoundedBottomLeft(10);
        jpAdd.setRoundedBottomRight(10);
        jpAdd.setRoundedTopLeft(10);
        jpAdd.setRoundedTopRight(10);
        jpAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpAddMouseClicked(evt);
            }
        });
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbAdd.setText("Thêm");
        jpAdd.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        svgAdd.setText(" ");
        svgAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgAddMouseClicked(evt);
            }
        });
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 40, 40));

        jpFunction.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, 50));
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        // Liên kết phím tắt với hành động
        jpAdd.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "addAction");
        jpAdd.getActionMap().put("addAction", action);

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setRoundedBottomLeft(10);
        jpEdit.setRoundedBottomRight(10);
        jpEdit.setRoundedTopLeft(10);
        jpEdit.setRoundedTopRight(10);
        jpEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbEdit.setText("Sửa");
        jbEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEditMouseClicked(evt);
            }
        });
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 40, 40));

        jpFunction.add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 130, 50));
        KeyStroke keyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        // Liên kết phím tắt với hành động
        jpEdit.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke1, "addAction1");
        jpEdit.getActionMap().put("addAction1", action1);

        jpDelete.setBackground(new java.awt.Color(255, 255, 255));
        jpDelete.setRoundedBottomLeft(10);
        jpDelete.setRoundedBottomRight(10);
        jpDelete.setRoundedTopLeft(10);
        jpDelete.setRoundedTopRight(10);
        jpDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpDeleteMouseClicked(evt);
            }
        });
        jpDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbDelete.setText("Xoá");
        jbDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbDeleteMouseClicked(evt);
            }
        });
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        svgDelete.setText(" ");
        svgDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgDeleteMouseClicked(evt);
            }
        });
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 40, 40));

        jpFunction.add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 130, 50));
        KeyStroke keyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        // Liên kết phím tắt với hành động
        jpDelete.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke2, "addAction2");
        jpDelete.getActionMap().put("addAction2", action2);

        jpRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jpRefresh.setRoundedBottomLeft(10);
        jpRefresh.setRoundedBottomRight(10);
        jpRefresh.setRoundedTopLeft(10);
        jpRefresh.setRoundedTopRight(10);
        jpRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpRefreshMouseClicked(evt);
            }
        });
        jpRefresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbRefresh.setText("Làm mới");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgRefresh.setText(" ");
        svgRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgRefreshMouseClicked(evt);
            }
        });
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpFunction.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 150, 50));
        KeyStroke keyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        // Liên kết phím tắt với hành động
        jpRefresh.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke3, "addAction3");
        jpRefresh.getActionMap().put("addAction3", action3);

        lblDob1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDob1.setText("Ngày kết thúc:");
        jpFunction.add(lblDob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, -1, 40));

        txtngayketthuc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpFunction.add(txtngayketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 210, 40));

        add(jpFunction, java.awt.BorderLayout.CENTER);

        jPanelDiscountDetail.setPreferredSize(new java.awt.Dimension(458, 520));
        jPanelDiscountDetail.setLayout(new java.awt.BorderLayout());

        scrollDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollDiscountMouseClicked(evt);
            }
        });
        if(ngonNgu==2)
        {
            tableDiscount.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Discount ID", "Name Program", "Percent", "Start day", "End day", "Describe"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        else
        {
            tableDiscount.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã khuyến mãi", "Tên chương trình", "Phần trăm giảm", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }

        scrollDiscount.setViewportView(tableDiscount);

        jPanelDiscountDetail.add(scrollDiscount, java.awt.BorderLayout.CENTER);

        add(jPanelDiscountDetail, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void txttenchuongtrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenchuongtrinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenchuongtrinhActionPerformed

    private void txtmakmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakmActionPerformed

    private void txtphamtramgiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphamtramgiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphamtramgiamActionPerformed

    private void txtmotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmotaActionPerformed
    //them
    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (kiemTra()) {
                String tenchuongtrinh = txttenchuongtrinh.getText();
                Float phantram = Float.parseFloat(txtphamtramgiam.getText());
                String mota = txtmota.getText();
                Date ngaybatdau = txtngaybatdau.getDate();
                Date ngayketthuc = txtngayketthuc.getDate();
                KhuyenMai km = new KhuyenMai("a", tenchuongtrinh, phantram, ngaybatdau, ngayketthuc, mota);
                khuyenMaiDAO = new KhuyenMaiDAO();
                khuyenMaiDAO.insertKhuyenMai(km);
                loadData();
                settext();
                showmess("Thêm dữ liệu thành công!");
            }
        }
    };

    //sua
    Action action1 = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = tableDiscount.getSelectedRow();
            if (index >= 0) {
                if (kiemTra()) {
                    String makm = txtmakm.getText();
                    String tenchuongtrinh = txttenchuongtrinh.getText();
                    Float phantram = Float.parseFloat(txtphamtramgiam.getText());
                    String mota = txtmota.getText();
                    Date ngaybatdau = txtngaybatdau.getDate();
                    Date ngayketthuc = txtngayketthuc.getDate();
                    KhuyenMai km = new KhuyenMai(makm, tenchuongtrinh, phantram, ngaybatdau, ngayketthuc, mota);
                    khuyenMaiDAO = new KhuyenMaiDAO();
                    khuyenMaiDAO.updatekhuyenmai(km);
                    loadData();
                    settext();
                    showmess("Sửa dữ liệu thành công!");
                }
            } else {
                showmess("Vui lòng chọn dòng muốn sửa");
            }
        }
    };

    //xoa
    Action action2 = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] selectedrows = tableDiscount.getSelectedRows(); // lay ra ds cac chi muc đc ch
            if (selectedrows.length > 0) {
                khuyenMaiDAO = new KhuyenMaiDAO();
                for (int i = 0; i < selectedrows.length - 1; i++) {
                    int selectedrow = selectedrows[i];
                    String ma = tableDiscount.getValueAt(selectedrow, 0).toString();
                    khuyenMaiDAO.deletekhuyenmai(ma);
                    loadData();
                }

                showmess("Xóa thành công!");
            } else {
                showmess("Vui lòng chọn dòng muốn xóa");
            }
        }

    };
    //lammoi
    Action action3 = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            settext();
            txttenchuongtrinh.requestFocus();
            loadData();
        }
    };
    private void jpAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddMouseClicked
        if (kiemTra()) {
            String tenchuongtrinh = txttenchuongtrinh.getText();
            Float phantram = Float.parseFloat(txtphamtramgiam.getText());
            String mota = txtmota.getText();
            Date ngaybatdau = txtngaybatdau.getDate();
            Date ngayketthuc = txtngayketthuc.getDate();
            KhuyenMai km = new KhuyenMai("a", tenchuongtrinh, phantram, ngaybatdau, ngayketthuc, mota);
            khuyenMaiDAO = new KhuyenMaiDAO();
            khuyenMaiDAO.insertKhuyenMai(km);
            loadData();
            settext();
            if (ngonNgu == 2) {
                showmess("Data added successfully!");
            } else {
                showmess("Thêm dữ liệu thành công!");
            }

        }

    }//GEN-LAST:event_jpAddMouseClicked

    private void jbEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditMouseClicked
        if (ngonNgu == 2) {
            int index = tableDiscount.getSelectedRow();
            if (index >= 0) {
                if (kiemTra()) {
                    String makm = txtmakm.getText();
                    String tenchuongtrinh = txttenchuongtrinh.getText();
                    Float phantram = Float.parseFloat(txtphamtramgiam.getText());
                    String mota = txtmota.getText();
                    Date ngaybatdau = txtngaybatdau.getDate();
                    Date ngayketthuc = txtngayketthuc.getDate();
                    KhuyenMai km = new KhuyenMai(makm, tenchuongtrinh, phantram, ngaybatdau, ngayketthuc, mota);
                    khuyenMaiDAO = new KhuyenMaiDAO();
                    khuyenMaiDAO.updatekhuyenmai(km);
                    loadData();
                    settext();
                    showmess("Data updated successfully!");
                }
            } else {
                showmess("Please select a row to update");
            }
        } else {
            int index = tableDiscount.getSelectedRow();
            if (index >= 0) {
                if (kiemTra()) {
                    String makm = txtmakm.getText();
                    String tenchuongtrinh = txttenchuongtrinh.getText();
                    Float phantram = Float.parseFloat(txtphamtramgiam.getText());
                    String mota = txtmota.getText();
                    Date ngaybatdau = txtngaybatdau.getDate();
                    Date ngayketthuc = txtngayketthuc.getDate();
                    KhuyenMai km = new KhuyenMai(makm, tenchuongtrinh, phantram, ngaybatdau, ngayketthuc, mota);
                    khuyenMaiDAO = new KhuyenMaiDAO();
                    khuyenMaiDAO.updatekhuyenmai(km);
                    loadData();
                    settext();
                    showmess("Sửa dữ liệu thành công!");
                }
            } else {
                showmess("Vui lòng chọn dòng muốn sửa");
            }
        }
    }//GEN-LAST:event_jbEditMouseClicked

    private void svgDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgDeleteMouseClicked

    }//GEN-LAST:event_svgDeleteMouseClicked

    private void scrollDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollDiscountMouseClicked

    }//GEN-LAST:event_scrollDiscountMouseClicked

    private void jbDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbDeleteMouseClicked
        if (ngonNgu == 2) {
            int[] selectedrows = tableDiscount.getSelectedRows();
            if (selectedrows.length > 0) {
                khuyenMaiDAO = new KhuyenMaiDAO();
                for (int i = selectedrows.length - 1; i >= 0; i--) {
                    int selectedrow = selectedrows[i];
                    String ma = tableDiscount.getValueAt(selectedrow, 0).toString();
                    khuyenMaiDAO.deletekhuyenmai(ma);
                }
                loadData();
                showmess("Deletion successful!");
                tableDiscount.clearSelection();
            } else {
                showmess("Please select rows to delete");
            }
        } else {
            int[] selectedrows = tableDiscount.getSelectedRows();
            if (selectedrows.length > 0) {
                khuyenMaiDAO = new KhuyenMaiDAO();
                for (int i = selectedrows.length - 1; i >= 0; i--) {
                    int selectedrow = selectedrows[i];
                    String ma = tableDiscount.getValueAt(selectedrow, 0).toString();
                    khuyenMaiDAO.deletekhuyenmai(ma);
                }
                loadData();
                showmess("Xóa thành công!");
                tableDiscount.clearSelection();
            } else {
                showmess("Vui lòng chọn dòng muốn xóa");
            }
        }
    }//GEN-LAST:event_jbDeleteMouseClicked

    private void svgRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgRefreshMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_svgRefreshMouseClicked

    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked
        settext();
        txttenchuongtrinh.requestFocus();
        loadData();
    }//GEN-LAST:event_jpRefreshMouseClicked

    private void svgAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_svgAddMouseClicked

    private void jpFunctionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpFunctionKeyPressed

    }//GEN-LAST:event_jpFunctionKeyPressed

    private void jpDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDeleteMouseClicked

    }//GEN-LAST:event_jpDeleteMouseClicked
    // kiểm tra
    private boolean kiemTra() {
        if (ngonNgu == 2) {
            boolean kiemtra = true;
            try {
                String makm = txtmakm.getText();
                String tenchuongtrinh = txttenchuongtrinh.getText();
                String phantram = txtphamtramgiam.getText();
                String mota = txtmota.getText();
                if (txttenchuongtrinh.getText().equals("") || txtphamtramgiam.getText().equals("") || txtmota.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all required information.");
                    kiemtra = false;
                } else if (Float.parseFloat(phantram) < 1 || Float.parseFloat(phantram) > 50) {
                    JOptionPane.showMessageDialog(null, "Discount percentage must be between 1% and 50%.");
                    kiemtra = false;
                } else if (!isDateRangeValid(txtngaybatdau, txtngayketthuc)) {
                    JOptionPane.showMessageDialog(null, "Start date must be before the end date.");
                    kiemtra = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please check the discount percentage.");
                kiemtra = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Start date or end date is not in the correct format or is empty.");
                kiemtra = false;
            }
            return kiemtra;
        } else {
            boolean kiemtra = true;
            try {
                String makm = txtmakm.getText();
                String tenchuongtrinh = txttenchuongtrinh.getText();
                String phantram = txtphamtramgiam.getText();
                String mota = txtmota.getText();
                if (txttenchuongtrinh.getText().equals("") || txtphamtramgiam.getText().equals("") || txtmota.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
                    kiemtra = false;
                } else if (Float.parseFloat(phantram) < 1 || Float.parseFloat(phantram) > 50) {
                    JOptionPane.showMessageDialog(null, "Phần trăm giảm phải từ 1% đến 50%");
                    kiemtra = false;
                } else if (!isDateRangeValid(txtngaybatdau, txtngayketthuc)) {
                    JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải trước ngày kết thúc.");
                    kiemtra = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại phần trăm giảm.");
                kiemtra = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu hoặc ngày kết thúc không đúng định dạng hoặc rỗng.");
                kiemtra = false;
            }
            return kiemtra;
        }

    }

    private boolean isDateRangeValid(JDateChooser startDateChooser, JDateChooser endDateChooser) {
        java.util.Date startDate = startDateChooser.getDate();
        java.util.Date endDate = endDateChooser.getDate();
        // Kiểm tra xem ngày bắt đầu có trước ngày kết thúc
        if (startDate.after(endDate)) {
            return false;
        }
        return true;
    }

    private void showmess(String ma) {
        JOptionPane.showMessageDialog(null, ma);
    }

    private void settext() {
        txtmakm.setText("");
        txtmota.setText("");
        txtphamtramgiam.setText("");
        txttenchuongtrinh.setText("");
        txtngaybatdau.setDate(null);
        txtngayketthuc.setDate(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gioiTinh;
    private javax.swing.JPanel jPanelDiscountDetail;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbDiscountManagerment;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jpAdd;
    private util.JPanelRounded jpDelete;
    private util.JPanelRounded jpEdit;
    private javax.swing.JPanel jpFunction;
    private util.JPanelRounded jpRefresh;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblDescribe;
    private javax.swing.JLabel lblDiscountID;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblDob1;
    private javax.swing.JLabel lblNameProgram;
    private javax.swing.JLabel lblPercent;
    private javax.swing.JScrollPane scrollDiscount;
    private util.SVGImage svgAdd;
    private util.SVGImage svgDelete;
    private util.SVGImage svgEdit;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableDiscount;
    private javax.swing.JTextField txtmakm;
    private javax.swing.JTextField txtmota;
    private com.toedter.calendar.JDateChooser txtngaybatdau;
    private com.toedter.calendar.JDateChooser txtngayketthuc;
    private javax.swing.JTextField txtphamtramgiam;
    private javax.swing.JTextField txttenchuongtrinh;
    // End of variables declaration//GEN-END:variables
}
