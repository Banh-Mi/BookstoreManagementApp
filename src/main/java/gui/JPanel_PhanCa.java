/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhanVienDAO;
import dao.PhanCaLamViecDAO;
import entity.NhanVien;
import entity.PhanCaLamViec;
import entity.ThongTinPhanCaLamViec;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
import java.awt.Button;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BanhMi88
 */
public class JPanel_PhanCa extends javax.swing.JPanel {

    private final DefaultTableModel modelPhanCa;
    private PhanCaLamViecDAO phanCaLamViecDAO;
    private NhanVienDAO nhanVienDAO;
    protected Date ngay1, ngay2, ngay3, ngay4, ngay5, ngay6, ngay7;
    protected boolean ngayThuNhat = false, ngayThuHai = false, ngayThuBa = false, ngayThuTu = false, ngayThuNam = false, ngayThuSau = false, ngayThuBay = false;
    Date currentDate = new Date();
    Calendar calendar = Calendar.getInstance();

    SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    ArrayList<java.sql.Date> danhSachNgay = new ArrayList<>();

    public JPanel_PhanCa() {
        initComponents();
        if (ngonNgu == 2) {
            ChuyenDoiNN();
        }
        svgPhanCa.setSvgImage("add.svg", 40, 40);
        svgDelete.setSvgImage("delete.svg", 40, 40);
        svgRefresh.setSvgImage("refresh.svg", 35, 35);
        modelPhanCa = (DefaultTableModel) tablePhanCa.getModel();
        loadData();
        nhanVienDAO = new NhanVienDAO();
        for (NhanVien nv : nhanVienDAO.getAllNhanVien()) {
            cbMaNhanVien.addItem(nv.getMaNV());
        }
        setName();
        loadDateOfWeeks();
        setButton();
    }

    public void ChuyenDoiNN() {
        lblMaNhanVien.setText("Employee ID:");
        lblTenNV.setText("Employee Name:");
        lblMaNhanVien1.setText("shift:");
        jLabel3.setText("(*) Shift 1: From 9am - 4pm / Shift 2: From 4pm - 10pm");
        lblPhanCa.setText("WORK SHIFTS");
        jbAdd.setText("Shift");
        jbDelete.setText("Delete");
        jbRefresh.setText("Refresh");
    }

    private void setName() {
        String selectedItem = (String) cbMaNhanVien.getSelectedItem();
        nhanVienDAO = new NhanVienDAO();
        NhanVien nhanVien = nhanVienDAO.searchEmployee(selectedItem);
        lblHienTen.setText(nhanVien.getTenNV());
    }

    private void loadData() {
        phanCaLamViecDAO = new PhanCaLamViecDAO();
        modelPhanCa.setRowCount(0);
        for (ThongTinPhanCaLamViec ttCa : phanCaLamViecDAO.getTatCaThongTin()) {
            Object row[] = {ttCa.getMaNV(), ttCa.getTenNV(), ttCa.getSoDienThoai(), ttCa.getTenCa(), ttCa.getThoiGianVao(), ttCa.getThoiGianRa(), ttCa.getNgay()};
            modelPhanCa.addRow(row);
        }
    }

    public java.sql.Date transformDate(java.util.Date ngay) {
        return new java.sql.Date(ngay.getTime());
    }

    private void loadDateOfWeeks() {
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        ngay1 = calendar.getTime();
        btnN1.setText(dayFormat.format(ngay1));
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        ngay2 = calendar.getTime();
        btnN2.setText(dayFormat.format(ngay2));
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        ngay3 = calendar.getTime();
        btnN3.setText(dayFormat.format(ngay3));
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        ngay4 = calendar.getTime();
        btnN4.setText(dayFormat.format(ngay4));
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        ngay5 = calendar.getTime();
        btnN5.setText(dayFormat.format(ngay5));
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        ngay6 = calendar.getTime();
        btnN6.setText(dayFormat.format(ngay6));
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        ngay7 = calendar.getTime();
        btnN7.setText(dayFormat.format(ngay7));

    }

    private void buttonEnable(Date ngay, JButton btn) {
        if (phanCaLamViecDAO.checkPhanCa(new PhanCaLamViec(cbMaNhanVien.getSelectedItem().toString(), cbCa.getSelectedItem().toString().equalsIgnoreCase("Ca 1") == true ? "CA001" : "CA002", transformDate(ngay))) == 1) {
            btn.setEnabled(true);
        } else {
            btn.setEnabled(false);
        }
    }

    private void setButtonSelected(JButton btn) {
        btn.setSelected(false);
    }

    private void setButton() {
        setButtonSelected(btnN1);
        setButtonSelected(btnN2);
        setButtonSelected(btnN3);
        setButtonSelected(btnN4);
        setButtonSelected(btnN5);
        setButtonSelected(btnN6);
        setButtonSelected(btnN7);
        buttonEnable(this.ngay1, btnN1);
        buttonEnable(this.ngay2, btnN2);
        buttonEnable(this.ngay3, btnN3);
        buttonEnable(this.ngay4, btnN4);
        buttonEnable(this.ngay5, btnN5);
        buttonEnable(this.ngay6, btnN6);
        buttonEnable(this.ngay7, btnN7);
        ngayThuNhat = setChooser(true, btnN1, ngay1);
        ngayThuHai = setChooser(true, btnN2, ngay2);
        ngayThuBa = setChooser(true, btnN3, ngay3);
        ngayThuTu = setChooser(true, btnN4, ngay4);
        ngayThuNam = setChooser(true, btnN5, ngay5);
        ngayThuSau = setChooser(true, btnN6, ngay6);
        ngayThuBay = setChooser(true, btnN7, ngay7);

    }

    private boolean setChooser(boolean item, JButton btn, Date ngay) {
        if (btn.isEnabled()) {
            item = !item;
            if (item) {
                danhSachNgay.add(transformDate(ngay));
                btn.setBackground(Color.blue);
                btn.setForeground(Color.white);
                jdNgayLam.setDate(ngay);
                buttonEnable(ngay, btn);
            } else {
                danhSachNgay.remove(new java.sql.Date(ngay.getTime()));
                btn.setBackground(Color.white);
                btn.setForeground(Color.black);
                jdNgayLam.setDate(null);
                buttonEnable(ngay, btn);
            }
        }
        return item;
    }

    private void lamMoi() {
        loadData();
        setName();
        setButton();
        cbCa.setSelectedIndex(0);
        cbMaNhanVien.setSelectedIndex(0);
        jdNgayLam.setDate(null);
        danhSachNgay.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPhanCaLamViec = new javax.swing.JPanel();
        lblPhanCa = new javax.swing.JLabel();
        panelChucNang = new javax.swing.JPanel();
        jbPhanCa = new util.JPanelRounded();
        jbAdd = new javax.swing.JLabel();
        svgPhanCa = new util.SVGImage();
        jbXoa = new util.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        jbLamMoi = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();
        lblMaNhanVien = new javax.swing.JLabel();
        cbMaNhanVien = new javax.swing.JComboBox<>();
        lblTenNV = new javax.swing.JLabel();
        lblHienTen = new javax.swing.JLabel();
        lblMaNhanVien1 = new javax.swing.JLabel();
        cbCa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnN1 = new javax.swing.JButton();
        btnN2 = new javax.swing.JButton();
        btnN3 = new javax.swing.JButton();
        btnN4 = new javax.swing.JButton();
        btnN5 = new javax.swing.JButton();
        btnN6 = new javax.swing.JButton();
        btnN7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdNgayLam = new com.toedter.calendar.JDateChooser();
        panelDanhSachPhanCa = new javax.swing.JPanel();
        scrollPhanCa = new javax.swing.JScrollPane();
        tablePhanCa = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1020, 950));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1040, 950));
        setLayout(new java.awt.BorderLayout());

        panelPhanCaLamViec.setPreferredSize(new java.awt.Dimension(333, 75));
        panelPhanCaLamViec.setLayout(new java.awt.BorderLayout());

        lblPhanCa.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblPhanCa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhanCa.setText("PHÂN CA LÀM VIỆC");
        lblPhanCa.setPreferredSize(new java.awt.Dimension(333, 75));
        panelPhanCaLamViec.add(lblPhanCa, java.awt.BorderLayout.PAGE_START);

        add(panelPhanCaLamViec, java.awt.BorderLayout.PAGE_START);

        panelChucNang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelChucNang.setMinimumSize(new java.awt.Dimension(1020, 150));
        panelChucNang.setVerifyInputWhenFocusTarget(false);
        panelChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbPhanCa.setBackground(new java.awt.Color(255, 255, 255));
        jbPhanCa.setRoundedBottomLeft(10);
        jbPhanCa.setRoundedBottomRight(10);
        jbPhanCa.setRoundedTopLeft(10);
        jbPhanCa.setRoundedTopRight(10);
        jbPhanCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPhanCaMouseClicked(evt);
            }
        });
        jbPhanCa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbAdd.setText("Phân ca");
        jbPhanCa.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 50));

        svgPhanCa.setText(" ");
        jbPhanCa.add(svgPhanCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        panelChucNang.add(jbPhanCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 50));

        jbXoa.setBackground(new java.awt.Color(255, 255, 255));
        jbXoa.setRoundedBottomLeft(10);
        jbXoa.setRoundedBottomRight(10);
        jbXoa.setRoundedTopLeft(10);
        jbXoa.setRoundedTopRight(10);
        jbXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbXoaMouseClicked(evt);
            }
        });
        jbXoa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbDelete.setText("Xoá");
        jbXoa.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 70, 50));

        svgDelete.setText(" ");
        jbXoa.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        panelChucNang.add(jbXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 120, 50));

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

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbRefresh.setText("Làm mới");
        jbLamMoi.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgRefresh.setText(" ");
        jbLamMoi.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        panelChucNang.add(jbLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 150, 50));

        lblMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaNhanVien.setText("Mã nhân viên:");
        panelChucNang.add(lblMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 40));

        cbMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMaNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMaNhanVienMouseClicked(evt);
            }
        });
        cbMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaNhanVienActionPerformed(evt);
            }
        });
        panelChucNang.add(cbMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 170, 40));

        lblTenNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenNV.setText("Tên nhân viên:");
        panelChucNang.add(lblTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 40));

        lblHienTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelChucNang.add(lblHienTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 250, 40));

        lblMaNhanVien1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaNhanVien1.setText("Ca:");
        panelChucNang.add(lblMaNhanVien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 50, 40));

        cbCa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca 1", "Ca 2" }));
        cbCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaActionPerformed(evt);
            }
        });
        panelChucNang.add(cbCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 130, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("(*) Ca 1: Từ 9h - 16h / Ca 2: Từ 16h - 22h ");
        panelChucNang.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 280, 40));

        btnN1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnN1MouseClicked(evt);
            }
        });
        panelChucNang.add(btnN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 60, 40));

        btnN2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnN2MouseClicked(evt);
            }
        });
        panelChucNang.add(btnN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 60, 40));

        btnN3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnN3MouseClicked(evt);
            }
        });
        panelChucNang.add(btnN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 60, 40));

        btnN4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnN4MouseClicked(evt);
            }
        });
        panelChucNang.add(btnN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 60, 40));

        btnN5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnN5MouseClicked(evt);
            }
        });
        panelChucNang.add(btnN5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 60, 40));

        btnN6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnN6MouseClicked(evt);
            }
        });
        panelChucNang.add(btnN6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 60, 40));

        btnN7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnN7MouseClicked(evt);
            }
        });
        panelChucNang.add(btnN7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, 60, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("7 ngày tiếp theo:");
        panelChucNang.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 160, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Ngày:");
        panelChucNang.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 60, 40));

        jdNgayLam.setEnabled(false);
        jdNgayLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        panelChucNang.add(jdNgayLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 260, 40));

        add(panelChucNang, java.awt.BorderLayout.CENTER);

        panelDanhSachPhanCa.setPreferredSize(new java.awt.Dimension(1050, 560));
        panelDanhSachPhanCa.setLayout(new java.awt.BorderLayout());

        tablePhanCa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        if(ngonNgu==2)
        {
            tablePhanCa.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String [] {
                    "Employee ID", "Employee Name", "Phone", "Shift", "Time to enter", "Time out", "Day"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        else
        {
            tablePhanCa.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String [] {
                    "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Ca làm việc", "Giờ vào", "Giờ ra", "Ngày "
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        tablePhanCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePhanCaMouseClicked(evt);
            }
        });
        scrollPhanCa.setViewportView(tablePhanCa);

        panelDanhSachPhanCa.add(scrollPhanCa, java.awt.BorderLayout.CENTER);

        add(panelDanhSachPhanCa, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPhanCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPhanCaMouseClicked

        if (danhSachNgay.size() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày cần phân ca");
        } else {
            int loi = 0;
            for (java.sql.Date ngay : danhSachNgay) {
                try {
                    phanCaLamViecDAO.phanCaLamViec(new PhanCaLamViec(cbMaNhanVien.getSelectedItem().toString(), cbCa.getSelectedItem().toString().equalsIgnoreCase("Ca 1") == true ? "CA001" : "CA002", transformDate(ngay)));

                } catch (Exception e) {
                    loi++;
                    System.out.println(e);
                }
            }
            danhSachNgay.clear();
            if (loi == 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                lamMoi();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
                lamMoi();
            }

        }


    }//GEN-LAST:event_jbPhanCaMouseClicked

    private void jbLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiMouseClicked
        lamMoi();
    }//GEN-LAST:event_jbLamMoiMouseClicked

    private void cbMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaNhanVienActionPerformed
        setName();
        if (cbMaNhanVien.getItemCount() > 0 && ngay1 != null && ngay2 != null && ngay3 != null && ngay4 != null && ngay5 != null && ngay6 != null && ngay7 != null) {
            setButton();
        }
    }//GEN-LAST:event_cbMaNhanVienActionPerformed
    private void setValue(String indexMa, String ngayLam, String indexCa) {
        cbMaNhanVien.setSelectedItem(indexMa);
        cbCa.setSelectedItem(indexCa);
        if (ngayLam.trim().equals("")) {
            jdNgayLam.setDate(null);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date defaultDate;
            try {
                defaultDate = new java.sql.Date(dateFormat.parse(ngayLam).getTime());
                jdNgayLam.setDate(defaultDate);
            } catch (ParseException ex) {
                Logger.getLogger(JPanel_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void tablePhanCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePhanCaMouseClicked
        int rowIndex = tablePhanCa.getSelectedRow();
        if (rowIndex >= 0) {
            String maNV = modelPhanCa.getValueAt(rowIndex, 0).toString();
            String caLam = modelPhanCa.getValueAt(rowIndex, 3).toString();
            String ngayLam = modelPhanCa.getValueAt(rowIndex, 6).toString();
            setValue(maNV, ngayLam, caLam);

        }
    }//GEN-LAST:event_tablePhanCaMouseClicked

    private void jbXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbXoaMouseClicked
        if (ngonNgu == 2) {
            int[] selectedrows = tablePhanCa.getSelectedRows();
            if (selectedrows.length > 0) {
                phanCaLamViecDAO = new PhanCaLamViecDAO();
                DefaultTableModel model = (DefaultTableModel) tablePhanCa.getModel();
                int count = 0;
                for (int i = selectedrows.length - 1; i >= 0; i--) {
                    int selectedrow = selectedrows[i];
                    String maNV = modelPhanCa.getValueAt(selectedrow, 0).toString();
                    String caLam = modelPhanCa.getValueAt(selectedrow, 3).toString().equals("Ca 1") ? "CA001" : "CA002";
                    String ngayLam = modelPhanCa.getValueAt(selectedrow, 6).toString();
                    setValue(maNV, ngayLam, caLam);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.sql.Date defaultDate;

                    try {
                        defaultDate = new java.sql.Date(dateFormat.parse(ngayLam).getTime());
                        PhanCaLamViec phanCa = new PhanCaLamViec(maNV, caLam, defaultDate);
                        if (phanCaLamViecDAO.deleteCaLamViec(phanCa)) {
                            count++;
                        }
                    } catch (ParseException ex) {
                        System.out.println(ex);
                    }
                }

                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "Deletion failed");
                } else {
                    lamMoi();
                    JOptionPane.showMessageDialog(null, "Deletion successful!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please select the row you want to delete");
            }
        } else {
            int[] selectedrows = tablePhanCa.getSelectedRows();
            if (selectedrows.length > 0) {
                phanCaLamViecDAO = new PhanCaLamViecDAO();
                DefaultTableModel model = (DefaultTableModel) tablePhanCa.getModel();
                int count = 0;
                for (int i = selectedrows.length - 1; i >= 0; i--) {
                    int selectedrow = selectedrows[i];
                    String maNV = modelPhanCa.getValueAt(selectedrow, 0).toString();
                    String caLam = modelPhanCa.getValueAt(selectedrow, 3).toString().equals("Ca 1") ? "CA001" : "CA002";
                    String ngayLam = modelPhanCa.getValueAt(selectedrow, 6).toString();
                    setValue(maNV, ngayLam, caLam);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.sql.Date defaultDate;

                    try {
                        defaultDate = new java.sql.Date(dateFormat.parse(ngayLam).getTime());
                        PhanCaLamViec phanCa = new PhanCaLamViec(maNV, caLam, defaultDate);
                        if (phanCaLamViecDAO.deleteCaLamViec(phanCa)) {
                            count++;
                        }
                    } catch (ParseException ex) {
                        System.out.println(ex);
                    }
                }

                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                } else {
                    lamMoi();
                    JOptionPane.showMessageDialog(null, "Xóa thành công !");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xoá");
            }
        }
    }//GEN-LAST:event_jbXoaMouseClicked

    private void cbCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaActionPerformed
        setButton();
    }//GEN-LAST:event_cbCaActionPerformed

    private void jbXoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbXoaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbXoaMouseEntered

    private void btnN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnN1MouseClicked
        ngayThuNhat = setChooser(ngayThuNhat, btnN1, ngay1);
    }//GEN-LAST:event_btnN1MouseClicked

    private void btnN2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnN2MouseClicked
        ngayThuHai = setChooser(ngayThuHai, btnN2, ngay2);
    }//GEN-LAST:event_btnN2MouseClicked

    private void btnN3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnN3MouseClicked
        ngayThuBa = setChooser(ngayThuBa, btnN3, ngay3);
    }//GEN-LAST:event_btnN3MouseClicked

    private void btnN4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnN4MouseClicked
        ngayThuTu = setChooser(ngayThuTu, btnN4, ngay4);
    }//GEN-LAST:event_btnN4MouseClicked

    private void btnN5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnN5MouseClicked
        ngayThuNam = setChooser(ngayThuNam, btnN5, ngay5);
    }//GEN-LAST:event_btnN5MouseClicked

    private void btnN7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnN7MouseClicked
        ngayThuBay = setChooser(ngayThuBay, btnN7, ngay7);
    }//GEN-LAST:event_btnN7MouseClicked

    private void btnN6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnN6MouseClicked
        ngayThuSau = setChooser(ngayThuSau, btnN6, ngay6);
    }//GEN-LAST:event_btnN6MouseClicked

    private void cbMaNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMaNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaNhanVienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnN1;
    private javax.swing.JButton btnN2;
    private javax.swing.JButton btnN3;
    private javax.swing.JButton btnN4;
    private javax.swing.JButton btnN5;
    private javax.swing.JButton btnN6;
    private javax.swing.JButton btnN7;
    private javax.swing.JComboBox<String> cbCa;
    private javax.swing.JComboBox<String> cbMaNhanVien;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private util.JPanelRounded jbLamMoi;
    private util.JPanelRounded jbPhanCa;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jbXoa;
    private com.toedter.calendar.JDateChooser jdNgayLam;
    private javax.swing.JLabel lblHienTen;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMaNhanVien1;
    private javax.swing.JLabel lblPhanCa;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JPanel panelChucNang;
    private javax.swing.JPanel panelDanhSachPhanCa;
    private javax.swing.JPanel panelPhanCaLamViec;
    private javax.swing.JScrollPane scrollPhanCa;
    private util.SVGImage svgDelete;
    private util.SVGImage svgPhanCa;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tablePhanCa;
    // End of variables declaration//GEN-END:variables

}
