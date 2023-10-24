/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.NhanVien;
import entity.TaiKhoan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import static util.Validator.*;

import static util.Validator.checkDate;

/**
 *
 * @author pc
 */
public class JPanel_NhanVien extends javax.swing.JPanel {

    private final DefaultTableModel modelNhanVien;
    private NhanVienDAO nhanVienDao;
    private TaiKhoanDAO taiKhoanDao;

    public JPanel_NhanVien() {
        initComponents();
        svgAdd.setSvgImage("add.svg", 30, 30);
        svgEdit.setSvgImage("edit.svg", 25, 25);
        svgDelete.setSvgImage("delete.svg", 30, 30);
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
        modelNhanVien = (DefaultTableModel) tableNhanVien.getModel();
        nhanVienDao = new NhanVienDAO();
        setValue(nhanVienDao.taoMaNhanVien(), "", "", "", "", "", radNam, "Nhân Viên bán hàng", "Đang làm");
        txtMaNV.setEditable(false);
        loadData();
    }

    private void setValue(String maNV, String tenNV, String soDienThoai, String email, String ngaySinh, String diaChi, JRadioButton gioiTinh, String chucVu, String trangThai) {

        txtMaNV.setText(maNV);
        txtTenNV.setText(tenNV);
        txtSoDienThoai.setText(soDienThoai);
        txtEmail.setText(email);
        txtDiaChi.setText(diaChi);
        if (ngaySinh.trim().equals("")) {
            jdNgaySinh.setDate(null);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            java.sql.Date defaultDate;
            try {
                defaultDate = new java.sql.Date(dateFormat.parse(ngaySinh).getTime());
                jdNgaySinh.setDate(defaultDate);
            } catch (ParseException ex) {
                Logger.getLogger(JPanel_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        gioiTinh.setSelected(true);
        cbChucVu.setSelectedItem(chucVu);
        cbTrangThai.setSelectedItem(trangThai);

    }

    private void loadData() {
        nhanVienDao = new NhanVienDAO();
        modelNhanVien.setRowCount(0);
        for (NhanVien nv : nhanVienDao.getAllNhanVien()) {
            Object[] row = {nv.getMaNV(), nv.getTenNV(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSoDienThoai(), nv.getEmail(), nv.getChucVu(), nv.getTrangThai()};
            modelNhanVien.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGioiTinh = new javax.swing.ButtonGroup();
        jpTitle = new javax.swing.JPanel();
        jbEmployeeManagerment = new javax.swing.JLabel();
        jpFunction = new javax.swing.JPanel();
        lblEmployeeID = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        radNu = new javax.swing.JRadioButton();
        radNam = new javax.swing.JRadioButton();
        lblPhone = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        cbTrangThai = new javax.swing.JComboBox<>();
        lblPosition = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jdNgaySinh = new com.toedter.calendar.JDateChooser();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jpThem = new util.JPanelRounded();
        jbAdd = new javax.swing.JLabel();
        svgAdd = new util.SVGImage();
        jbSua = new util.JPanelRounded();
        jbEdit = new javax.swing.JLabel();
        svgEdit = new util.SVGImage();
        jbXoa = new util.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        jbLamMoi = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();
        cbChucVu = new javax.swing.JComboBox<>();
        comboboxPosition2 = new javax.swing.JComboBox<>();
        jPanelEmployeeDetail = new javax.swing.JPanel();
        scrollEmployee = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1040, 760));
        setLayout(new java.awt.BorderLayout());

        jpTitle.setLayout(new java.awt.BorderLayout());

        jbEmployeeManagerment.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbEmployeeManagerment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbEmployeeManagerment.setText("QUẢN LÝ NHÂN VIÊN");
        jpTitle.add(jbEmployeeManagerment, java.awt.BorderLayout.CENTER);

        add(jpTitle, java.awt.BorderLayout.PAGE_START);

        jpFunction.setPreferredSize(new java.awt.Dimension(1010, 350));
        jpFunction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmployeeID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeID.setText("Mã nhân viên:");
        jpFunction.add(lblEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 30));

        lblFullName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFullName.setText("Họ và tên:");
        jpFunction.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 220, 30));

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGender.setText("Giới tính");
        jpFunction.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, 30));

        btnGroupGioiTinh.add(radNu);
        radNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNu.setText("Nữ");
        jpFunction.add(radNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, -1, 30));

        btnGroupGioiTinh.add(radNam);
        radNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNam.setSelected(true);
        radNam.setText("Nam");
        jpFunction.add(radNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, -1, 30));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhone.setText("Số điện thoại:");
        jpFunction.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 100, 30));

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus.setText("Trang thái:");
        jpFunction.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 30));

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDob.setText("Ngày sinh:");
        jpFunction.add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, 30));

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 300, 30));

        cbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Đã nghĩ" }));
        jpFunction.add(cbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 180, 30));

        lblPosition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPosition.setText("Chức vụ:");
        jpFunction.add(lblPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 30));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAddress.setText("Địa chỉ:");
        jpFunction.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, 30));

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 180, 30));

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 180, 30));
        jpFunction.add(jdNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 180, 30));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("Email:");
        jpFunction.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 50, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 220, 30));

        jpThem.setBackground(new java.awt.Color(255, 255, 255));
        jpThem.setRoundedBottomLeft(10);
        jpThem.setRoundedBottomRight(10);
        jpThem.setRoundedTopLeft(10);
        jpThem.setRoundedTopRight(10);
        jpThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpThemMouseClicked(evt);
            }
        });
        jpThem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAdd.setText("Thêm");
        jpThem.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgAdd.setText(" ");
        jpThem.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 40));

        jbSua.setBackground(new java.awt.Color(255, 255, 255));
        jbSua.setRoundedBottomLeft(10);
        jbSua.setRoundedBottomRight(10);
        jbSua.setRoundedTopLeft(10);
        jbSua.setRoundedTopRight(10);
        jbSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSuaMouseClicked(evt);
            }
        });
        jbSua.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbEdit.setText("Sửa");
        jbSua.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgEdit.setText(" ");
        jbSua.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jbSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 100, 40));

        jbXoa.setBackground(new java.awt.Color(255, 255, 255));
        jbXoa.setRoundedBottomLeft(10);
        jbXoa.setRoundedBottomRight(10);
        jbXoa.setRoundedTopLeft(10);
        jbXoa.setRoundedTopRight(10);
        jbXoa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDelete.setText("Xoá");
        jbXoa.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgDelete.setText(" ");
        jbXoa.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jbXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 100, 40));

        jbLamMoi.setBackground(new java.awt.Color(255, 255, 255));
        jbLamMoi.setRoundedBottomLeft(10);
        jbLamMoi.setRoundedBottomRight(10);
        jbLamMoi.setRoundedTopLeft(10);
        jbLamMoi.setRoundedTopRight(10);
        jbLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLamMoiMouseClicked(evt);
            }
        });
        jbLamMoi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setText("Làm mới");
        jbLamMoi.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgRefresh.setText(" ");
        jbLamMoi.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jbLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 110, 40));

        cbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên bán hàng", "Quản lý" }));
        jpFunction.add(cbChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 180, 30));

        comboboxPosition2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxPosition2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jpFunction.add(comboboxPosition2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 180, 30));

        add(jpFunction, java.awt.BorderLayout.CENTER);

        jPanelEmployeeDetail.setPreferredSize(new java.awt.Dimension(458, 450));
        jPanelEmployeeDetail.setLayout(new java.awt.BorderLayout());

        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên", "Giới tính", "Ngày sinh", "Địa chỉ", "SĐT", "Email", "Chức vụ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNhanVienMouseClicked(evt);
            }
        });
        scrollEmployee.setViewportView(tableNhanVien);

        jPanelEmployeeDetail.add(scrollEmployee, java.awt.BorderLayout.CENTER);

        add(jPanelEmployeeDetail, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jpThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThemMouseClicked
        nhanVienDao = new NhanVienDAO();
        String maNV = txtMaNV.getText();
        if (maNV.equals(nhanVienDao.taoMaNhanVien())) {
            String tenNV = txtTenNV.getText();
            String trangThai = (String) cbTrangThai.getSelectedItem();
            String diaChi = txtDiaChi.getText();
            String email = txtEmail.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String gioiTinh = radNam.isSelected() ? "Nam" : "Nữ";
            String chucVu = (String) cbChucVu.getSelectedItem();

            if (!checkEmpty(tenNV) && !checkEmpty(diaChi) && !checkEmpty(soDienThoai) && !checkEmpty(email) && !checkNull(jdNgaySinh.getDate())) {

                java.sql.Date ngaySinh = new java.sql.Date(jdNgaySinh.getDate().getTime());
                taiKhoanDao = new TaiKhoanDAO();
                TaiKhoan taiKhoan = new TaiKhoan(taiKhoanDao.taMaTK(), maNV, "1111", "User", "Đang hoạt động");

                if (checkText(tenNV, "Tên nhân viên không hợp lệ") && checkPhone(soDienThoai, "Số điện thoại không hợp lệ") && checkName(diaChi, "Địa chỉ không hợp lệ") && checkDate(ngaySinh, "Chưa đủ 18 tuổi") && checkMail(email, "Email không hợp lệ")) {
                    if (taiKhoanDao.insert(taiKhoan)) {
                        NhanVien nhanVien = new NhanVien(maNV, tenNV, soDienThoai, email, ngaySinh, null, taiKhoan.getMaTK(), diaChi, gioiTinh, chucVu, trangThai);
                        if (nhanVienDao.themNhanVien(nhanVien)) {
                            loadData();
                            JOptionPane.showMessageDialog(this, "Thêm thành công");
                            setValue(nhanVienDao.taoMaNhanVien(), "", "", "", "", "", radNam, "Nhân Viên bán hàng", "Đang làm");
                        } else {
                            JOptionPane.showMessageDialog(this, "Thêm không thành công");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không được để dữ liệu bị trống");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại");
        }
    }//GEN-LAST:event_jpThemMouseClicked

    private void jbLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiMouseClicked
        setValue(nhanVienDao.taoMaNhanVien(), "", "", "", "", "", radNam, "Nhân Viên bán hàng", "Đang làm");
        loadData();
    }//GEN-LAST:event_jbLamMoiMouseClicked

    private void tableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhanVienMouseClicked
        int rowIndex = tableNhanVien.getSelectedRow();
        if (rowIndex >= 0) {
            String maNV = modelNhanVien.getValueAt(rowIndex, 0).toString();
            String tenNV = modelNhanVien.getValueAt(rowIndex, 1).toString();
            String gioiTinh = modelNhanVien.getValueAt(rowIndex, 2).toString();
            String ngaySinh = modelNhanVien.getValueAt(rowIndex, 3).toString();
            String diaChi = modelNhanVien.getValueAt(rowIndex, 4).toString();
            String soDienThoai = modelNhanVien.getValueAt(rowIndex, 5).toString();
            String email = modelNhanVien.getValueAt(rowIndex, 6).toString();
            String chucVu = modelNhanVien.getValueAt(rowIndex, 7).toString();
            String trangThai = modelNhanVien.getValueAt(rowIndex, 8).toString();
            setValue(maNV, tenNV, soDienThoai, email, ngaySinh, diaChi, gioiTinh.equals("Nam") ? radNam : radNu, chucVu, trangThai);
        }
    }//GEN-LAST:event_tableNhanVienMouseClicked

    private void jbSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSuaMouseClicked
        int rowIndex = tableNhanVien.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa");
            setValue(nhanVienDao.taoMaNhanVien(), "", "", "", "", "", radNam, "Nhân Viên bán hàng", "Đang làm");
        } else {
            String maNV = txtMaNV.getText();
            if (!maNV.equals(nhanVienDao.taoMaNhanVien())) {
                String tenNV = txtTenNV.getText();
                String trangThai = (String) cbTrangThai.getSelectedItem();
                String diaChi = txtDiaChi.getText();
                String email = txtEmail.getText();
                String soDienThoai = txtSoDienThoai.getText();
                String gioiTinh = radNam.isSelected() ? "Nam" : "Nữ";
                String chucVu = (String) cbChucVu.getSelectedItem();

                if (!checkEmpty(tenNV) && !checkEmpty(diaChi) && !checkEmpty(soDienThoai) && !checkEmpty(email) && !checkNull(jdNgaySinh.getDate())) {
                    java.sql.Date ngaySinh = new java.sql.Date(jdNgaySinh.getDate().getTime());
                    if (checkText(tenNV, "Tên nhân viên không hợp lệ") && checkPhone(soDienThoai, "Số điện thoại không hợp lệ") && checkName(diaChi, "Địa chỉ không hợp lệ") && checkDate(ngaySinh, "Chưa đủ 18 tuổi") && checkMail(email, "Email không hợp lệ")) {
                        NhanVien nhanVien = new NhanVien(maNV, tenNV, soDienThoai, email, ngaySinh, diaChi, gioiTinh, chucVu, trangThai);
                        if (nhanVienDao.capNhatNhanVien(nhanVien)) {
                            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa dòng này không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                                loadData();
                                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                                setValue(nhanVienDao.taoMaNhanVien(), "", "", "", "", "", radNam, "Nhân Viên bán hàng", "Đang làm");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Không được để dữ liệu bị trống");
                }
            }
        }
    }//GEN-LAST:event_jbSuaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private javax.swing.JComboBox<String> cbChucVu;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JComboBox<String> comboboxPosition2;
    private javax.swing.JPanel jPanelEmployeeDetail;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbEmployeeManagerment;
    private util.JPanelRounded jbLamMoi;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jbSua;
    private util.JPanelRounded jbXoa;
    private com.toedter.calendar.JDateChooser jdNgaySinh;
    private javax.swing.JPanel jpFunction;
    private util.JPanelRounded jpThem;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JScrollPane scrollEmployee;
    private util.SVGImage svgAdd;
    private util.SVGImage svgDelete;
    private util.SVGImage svgEdit;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
