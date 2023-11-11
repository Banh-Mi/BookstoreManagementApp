package gui;

import com.toedter.calendar.JDateChooser;
import dao.KhachHangDAO;
import entity.KhachHang;
import static gui.GiaoDienDangNhap.ngonNgu;
import java.util.Date;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class JPanel_KhachHang extends javax.swing.JPanel {

    private DefaultTableModel modelKhachHang;
    private KhachHangDAO khachHangDao;

    public JPanel_KhachHang() {
        initComponents();
        if (ngonNgu == 2) {
            ChuyenDoiNN();
        }
        svgAdd.setSvgImage("add.svg", 40, 40);
        svgEdit.setSvgImage("edit.svg", 35, 35);
        svgDelete.setSvgImage("delete.svg", 40, 40);
        svgRefresh.setSvgImage("refresh.svg", 35, 35);
        modelKhachHang = (DefaultTableModel) tableCustomer.getModel();
        loadData();
        DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tableCustomer.setSelectionModel(selectionModel);
        tableCustomer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRowIndex = tableCustomer.getSelectedRow();
                if (selectedRowIndex >= 0) {
                    String maKH = tableCustomer.getValueAt(selectedRowIndex, 0).toString();
                    String hoTen = tableCustomer.getValueAt(selectedRowIndex, 1).toString();
                    String SDT = tableCustomer.getValueAt(selectedRowIndex, 2).toString();
                    String Email = tableCustomer.getValueAt(selectedRowIndex, 3).toString();
                    Date ngaySinh = (Date) tableCustomer.getValueAt(selectedRowIndex, 4);
                    String diaChi = tableCustomer.getValueAt(selectedRowIndex, 5).toString();
                    String gioiTinh = tableCustomer.getValueAt(selectedRowIndex, 6).toString();
                    String theVip = tableCustomer.getValueAt(selectedRowIndex, 7).toString();
                    Date ngayDangKy = (Date) tableCustomer.getValueAt(selectedRowIndex, 8);

                    if (gioiTinh.equals("Nam")) {
                        radnam.setSelected(true);
                    } else {
                        radnu.setSelected(true);
                    }
                    txtmaKhachHang.setText(maKH);
                    txtHoTen.setText(hoTen);
                    txtSDT.setText(SDT);
                    txtEmail.setText(Email);
                    txtNgaySinh.setDate(ngaySinh);
                    txtDiaChi.setText(diaChi);
                    cboboxthe.setSelectedItem(theVip);
                    txtNgayDangKy.setDate(ngayDangKy);
                }

            }
        });

    }

    public void ChuyenDoiNN() {
        lblCustomerID.setText("Customer ID:");
        lblFullName.setText("Full Name:");
        lblDob.setText("Date:");
        lblAddress.setText("Address:");
        lblGender.setText("Card:");
        lblPhone.setText("Phone:");
        lblGender2.setText("Gender:");
        lblGender1.setText("Registration Date:");
        jbCustomerManagerment.setText("CUSTOMER MANAGERMENT");
        jbAdd.setText("Add");
        jbDelete.setText("Delete");
        jbRefresh.setText("Refresh");
        jbEdit.setText("Edit");
    }

    private void loadData() {
        khachHangDao = new KhachHangDAO();
        modelKhachHang.setRowCount(0);
        for (KhachHang kh : khachHangDao.getAllKhachHang()) {
            Object[] row = {kh.getMaKH(), kh.getTenKH(), kh.getSoDienThoai(), kh.getEmail(), kh.getNgaySinh(), kh.getDiaChi(), kh.getGioiTinh(), kh.getTheVip(), kh.getNgayDangKy()};
            modelKhachHang.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gioiTinh = new javax.swing.ButtonGroup();
        jpTitle = new javax.swing.JPanel();
        jbCustomerManagerment = new javax.swing.JLabel();
        jpFunction = new javax.swing.JPanel();
        lblCustomerID = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        radnu = new javax.swing.JRadioButton();
        radnam = new javax.swing.JRadioButton();
        lblPhone = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtmaKhachHang = new javax.swing.JTextField();
        txtNgayDangKy = new com.toedter.calendar.JDateChooser();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
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
        lblGender1 = new javax.swing.JLabel();
        cboboxthe = new javax.swing.JComboBox<>();
        lblGender2 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanelCustomerDetail = new javax.swing.JPanel();
        scrollCustomer = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1040, 760));
        setLayout(new java.awt.BorderLayout());

        jpTitle.setLayout(new java.awt.BorderLayout());

        jbCustomerManagerment.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jbCustomerManagerment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbCustomerManagerment.setText("QUẢN LÝ KHÁCH HÀNG");
        jbCustomerManagerment.setPreferredSize(new java.awt.Dimension(409, 70));
        jpTitle.add(jbCustomerManagerment, java.awt.BorderLayout.CENTER);

        add(jpTitle, java.awt.BorderLayout.PAGE_START);

        jpFunction.setPreferredSize(new java.awt.Dimension(1010, 350));
        jpFunction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCustomerID.setText("Mã khách hàng:");
        jpFunction.add(lblCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 40));

        lblFullName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFullName.setText("Họ và tên:");
        jpFunction.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 40));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpFunction.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 310, 40));

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender.setText("Thẻ TV:");
        jpFunction.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, 40));

        gioiTinh.add(radnu);
        radnu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radnu.setText("Nữ");
        radnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radnuActionPerformed(evt);
            }
        });
        jpFunction.add(radnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 50, 40));

        gioiTinh.add(radnam);
        radnam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radnam.setSelected(true);
        radnam.setText("Nam");
        radnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radnamActionPerformed(evt);
            }
        });
        jpFunction.add(radnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 70, 40));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhone.setText("SĐT:");
        jpFunction.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, 40));

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDob.setText("Ngày sinh:");
        jpFunction.add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 40));

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpFunction.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 340, 40));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAddress.setText("Địa chỉ:");
        jpFunction.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, 40));

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        jpFunction.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 240, 40));

        txtmaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtmaKhachHang.setEnabled(false);
        txtmaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaKhachHangActionPerformed(evt);
            }
        });
        jpFunction.add(txtmaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 220, 40));

        txtNgayDangKy.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpFunction.add(txtNgayDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 230, 40));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email:");
        jpFunction.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpFunction.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 240, 40));

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
        jbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAddMouseClicked(evt);
            }
        });
        jpAdd.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgAdd.setText(" ");
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpFunction.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, 50));

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setRoundedBottomLeft(10);
        jpEdit.setRoundedBottomRight(10);
        jpEdit.setRoundedTopLeft(10);
        jpEdit.setRoundedTopRight(10);
        jpEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEditMouseClicked(evt);
            }
        });
        jpEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbEdit.setText("Sửa");
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpFunction.add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 50));

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
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgDelete.setText(" ");
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpFunction.add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 150, 50));

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
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpFunction.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 150, 50));

        lblGender1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender1.setText("Ngày đăng ký:");
        jpFunction.add(lblGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, 40));

        cboboxthe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboboxthe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đồng", "Bạc", "Vàng", "Kim cương", "Ruby", " " }));
        cboboxthe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboboxtheActionPerformed(evt);
            }
        });
        jpFunction.add(cboboxthe, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 170, 40));

        lblGender2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender2.setText("Giới tính:");
        jpFunction.add(lblGender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, -1, 40));

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpFunction.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 240, 40));

        add(jpFunction, java.awt.BorderLayout.CENTER);

        jPanelCustomerDetail.setPreferredSize(new java.awt.Dimension(458, 490));
        jPanelCustomerDetail.setLayout(new java.awt.BorderLayout());

        scrollCustomer.setPreferredSize(new java.awt.Dimension(452, 460));
        if(ngonNgu==2)
        {
            tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã khách hàng", "Tên", "SĐT", "Email", "Ngày sinh", "Địa chỉ", "Giới tính", "Thẻ thành viên", "Ngày Đăng ký"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        else
        {
            tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã khách hàng", "Tên", "SĐT", "Email", "Ngày sinh", "Địa chỉ", "Giới tính", "Thẻ thành viên", "Ngày Đăng ký"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });

        }

        if(ngonNgu==2)
        {
            tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Customer ID", "Full Name", "Phone", "Email", "Date", "Address", "Gender", "Card", "Registration Date"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        else
        {
            tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã khách hàng", "Tên", "SĐT", "Email", "Ngày sinh", "Địa chỉ", "Giới tính", "Thẻ thành viên", "Ngày Đăng ký"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });

        }
        scrollCustomer.setViewportView(tableCustomer);

        jPanelCustomerDetail.add(scrollCustomer, java.awt.BorderLayout.CENTER);

        add(jPanelCustomerDetail, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void radnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radnuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radnuActionPerformed

    private void radnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radnamActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtmaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaKhachHangActionPerformed

    private void cboboxtheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboboxtheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboboxtheActionPerformed

    private void jpAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddMouseClicked
        if (kiemtra()) {
            String maKH = txtmaKhachHang.getText();
            String hoTen = txtHoTen.getText();
            String SDT = txtSDT.getText();
            String Email = txtEmail.getText();
            String diaChi = txtDiaChi.getText();
            String gioiTinh = radnam.isSelected() ? "Nam" : "Nữ";
            String theVip = cboboxthe.getSelectedItem().toString();
            Date ngaysinh = txtNgaySinh.getDate();
            Date ngaydangky = txtNgayDangKy.getDate();
            KhachHang kh = new KhachHang(maKH, hoTen, SDT, Email, ngaysinh, diaChi, gioiTinh, theVip, ngaydangky);
            khachHangDao = new KhachHangDAO();
            khachHangDao.insertKhachHang(kh);
            loadData();
            settext();
            if(ngonNgu==2)
            {
                 showmess("Data added successfully!");
            }
            else 
            {
               showmess("Thêm dữ liệu thành công!"); 
            }
            
        }
    }//GEN-LAST:event_jpAddMouseClicked

    private void jpEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEditMouseClicked
        if (ngonNgu == 2) {
            int index = tableCustomer.getSelectedRow();
            if (index >= 0) {
                if (kiemtra()) {
                    String maKH = txtmaKhachHang.getText();
                    String hoTen = txtHoTen.getText();
                    String SDT = txtSDT.getText();
                    String Email = txtEmail.getText();
                    String diaChi = txtDiaChi.getText();
                    String gioiTinh = radnam.isSelected() ? "Nam" : "Nữ";
                    String theVip = cboboxthe.getSelectedItem().toString();
                    Date ngaysinh = txtNgaySinh.getDate();
                    Date ngaydangky = txtNgayDangKy.getDate();
                    KhachHang kh = new KhachHang(maKH, hoTen, SDT, Email, ngaysinh, diaChi, gioiTinh, theVip, ngaydangky);
                    khachHangDao = new KhachHangDAO();
                    khachHangDao.updateKhachHang(kh);
                    loadData();
                    settext();
                    showmess("Data updated successfully!");
                }
            } else {
                showmess("Please select a row to update");
            }
        } else {
            int index = tableCustomer.getSelectedRow();
            if (index >= 0) {
                if (kiemtra()) {
                    String maKH = txtmaKhachHang.getText();
                    String hoTen = txtHoTen.getText();
                    String SDT = txtSDT.getText();
                    String Email = txtEmail.getText();
                    String diaChi = txtDiaChi.getText();
                    String gioiTinh = radnam.isSelected() ? "Nam" : "Nữ";
                    String theVip = cboboxthe.getSelectedItem().toString();
                    Date ngaysinh = txtNgaySinh.getDate();
                    Date ngaydangky = txtNgayDangKy.getDate();
                    KhachHang kh = new KhachHang(maKH, hoTen, SDT, Email, ngaysinh, diaChi, gioiTinh, theVip, ngaydangky);
                    khachHangDao = new KhachHangDAO();
                    khachHangDao.updateKhachHang(kh);
                    loadData();
                    settext();
                    showmess("Sửa dữ liệu thành công!");
                }
            } else {
                showmess("Vui lòng chọn dòng muốn sửa");
            }
        }
    }//GEN-LAST:event_jpEditMouseClicked

    private void jpDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDeleteMouseClicked
        if (ngonNgu == 2) {
            int[] selectedrows = tableCustomer.getSelectedRows();
            if (selectedrows.length > 0) {
                khachHangDao = new KhachHangDAO();
                DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
                for (int i = selectedrows.length - 1; i >= 0; i--) {
                    int selectedrow = selectedrows[i];
                    String ma = tableCustomer.getValueAt(selectedrow, 0).toString();
                    khachHangDao.deleteKhachHang(ma);
                }
                loadData();
                showmess("Deletion successful!");
            } else {
                showmess("Please select the row(s) you want to delete");
            }
        } else {
            int[] selectedrows = tableCustomer.getSelectedRows();
            if (selectedrows.length > 0) {
                khachHangDao = new KhachHangDAO();
                DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
                for (int i = selectedrows.length - 1; i >= 0; i--) {
                    int selectedrow = selectedrows[i];
                    String ma = tableCustomer.getValueAt(selectedrow, 0).toString();
                    khachHangDao.deleteKhachHang(ma);
                }
                loadData();
                showmess("Xóa thành công!");
            } else {
                showmess("Vui lòng chọn dòng muốn xóa");
            }
        }
    }//GEN-LAST:event_jpDeleteMouseClicked

    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked
        settext();
        loadData();
    }//GEN-LAST:event_jpRefreshMouseClicked

    private void jbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAddMouseClicked
    private boolean kiemtra() {
        if (ngonNgu == 2) {
            Boolean kiemtra = true;
            try {
                String maKH = txtmaKhachHang.getText();
                String hoTen = txtHoTen.getText();
                String SDT = txtSDT.getText();
                String Email = txtEmail.getText();
                String diaChi = txtDiaChi.getText();
                String gioiTinh = "";
                String theVip = cboboxthe.getSelectedItem().toString();
                if (hoTen.equals("") || diaChi.equals("") || Email.equals("") || SDT.equals("")) {
                    showmess("Please enter all required information.");
                    kiemtra = false;
                } else if (!SDT.matches("(84|0)[35789][0-9]{8}")) {
                    showmess("Phone number must have 10 digits and start with 84 or 0, followed by 3, 5, 7, 8, 9.");
                    kiemtra = false;
                } else if (!Email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    showmess("Email should not contain special characters!");
                    kiemtra = false;
                } else if (isDateRangeValid(txtNgaySinh) == false) {
                    showmess("Birthdate must be before today!");
                    kiemtra = false;
                } else if (isDateRangeValid(txtNgayDangKy) == false) {
                    showmess("Registration date must be before today!");
                    kiemtra = false;
                }

            } catch (Exception e) {
                showmess("Birthdate or registration date is not in the correct format or is empty.");
                kiemtra = false;
            }
            return kiemtra;
        } else {
            Boolean kiemtra = true;
            try {
                String maKH = txtmaKhachHang.getText();
                String hoTen = txtHoTen.getText();
                String SDT = txtSDT.getText();
                String Email = txtEmail.getText();
                String diaChi = txtDiaChi.getText();
                String gioiTinh = "";
                String theVip = cboboxthe.getSelectedItem().toString();
                if (hoTen.equals("") || diaChi.equals("") || Email.equals("") || SDT.equals("")) {
                    showmess("Vui lòng nhập đầy đủ thông tin.");
                    kiemtra = false;
                } else if (!SDT.matches("(84|0)[35789][0-9]{8}")) {
                    showmess("Số điện thoại gồm 10 số bắt đầu là 84 hoặc 0 tiếp theo là 3,5,7,8,9");
                    kiemtra = false;
                } else if (!Email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    showmess("Email không có kí tự đặc biệt!");
                    kiemtra = false;
                } else if (isDateRangeValid(txtNgaySinh) == false) {
                    showmess("Ngày sinh phải trước ngày hôm nay!");
                    kiemtra = false;
                } else if (isDateRangeValid(txtNgayDangKy) == false) {
                    showmess("Ngày đăng ký phải trước ngày hôm nay!");
                    kiemtra = false;
                }

            } catch (Exception e) {
                showmess("Ngày sinh hoặc ngày đăng ký không đúng định dạng hoặc rỗng ");
                kiemtra = false;
            }
            return kiemtra;
        }
    }

    private void showmess(String ma) {
        JOptionPane.showMessageDialog(null, ma);
    }

    private void settext() {
        txtmaKhachHang.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtNgaySinh.setDate(null);
        txtDiaChi.setText("");
        radnam.setSelected(true);
        cboboxthe.setSelectedItem("Đồng");
        txtSDT.setText("");
        txtNgayDangKy.setDate(null);
        txtHoTen.requestFocus();
        cboboxthe.setSelectedItem("Đồng");
    }

    private boolean isDateRangeValid(JDateChooser startDateChooser) {
        java.util.Date startDate = startDateChooser.getDate();
        Date currentDate = new Date();
        // Kiểm tra xem ngày bắt đầu có trước ngày kết thúc
        if (startDate.after(currentDate)) {
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboboxthe;
    private javax.swing.ButtonGroup gioiTinh;
    private javax.swing.JPanel jPanelCustomerDetail;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbCustomerManagerment;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jpAdd;
    private util.JPanelRounded jpDelete;
    private util.JPanelRounded jpEdit;
    private javax.swing.JPanel jpFunction;
    private util.JPanelRounded jpRefresh;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblGender2;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JRadioButton radnam;
    private javax.swing.JRadioButton radnu;
    private javax.swing.JScrollPane scrollCustomer;
    private util.SVGImage svgAdd;
    private util.SVGImage svgDelete;
    private util.SVGImage svgEdit;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private com.toedter.calendar.JDateChooser txtNgayDangKy;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtmaKhachHang;
    // End of variables declaration//GEN-END:variables
}
