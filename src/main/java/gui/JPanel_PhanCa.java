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
import static gui.GiaoDienDangNhap.ngonNgu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static util.Validator.checkNull;

/**
 *
 * @author BanhMi88
 */
public class JPanel_PhanCa extends javax.swing.JPanel {

    private final DefaultTableModel modelPhanCa;
    private PhanCaLamViecDAO phanCaLamViecDAO;
    private NhanVienDAO nhanVienDAO;

    public JPanel_PhanCa() {
        initComponents();
        if(ngonNgu==2)
        {
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
    }
     public void ChuyenDoiNN()
    {
        lblMaNhanVien.setText("Employee ID:");
        lblTenNV.setText("Employee Name:");
        lblNgayLam.setText("Day of work:");
        lblMaNhanVien1.setText("shift:");
        jLabel3.setText("(*) Shift 1: From 9am - 4pm / Shift 2: From 4pm - 10pm");
        lblPhanCa.setText("WORK SHIFTS");
        jbAdd.setText("Shift");
        jbDelete.setText("Delete");
        jbRefresh.setText("Refresh");        
    }

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

    private void lamMoi() {
        loadData();
        setValue(cbMaNhanVien.getItemAt(0), "", cbCa.getItemAt(0));
        setName();
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
        jdNgayLam = new com.toedter.calendar.JDateChooser();
        lblNgayLam = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        cbMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaNhanVienActionPerformed(evt);
            }
        });
        panelChucNang.add(cbMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 150, 40));

        lblTenNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenNV.setText("Tên nhân viên:");
        panelChucNang.add(lblTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 40));

        lblHienTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelChucNang.add(lblHienTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 290, 40));

        lblMaNhanVien1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaNhanVien1.setText("Ca:");
        panelChucNang.add(lblMaNhanVien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 110, 40));

        cbCa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca 1", "Ca 2" }));
        cbCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaActionPerformed(evt);
            }
        });
        panelChucNang.add(cbCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 130, 40));
        panelChucNang.add(jdNgayLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 190, 40));

        lblNgayLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNgayLam.setText("Ngày làm:");
        panelChucNang.add(lblNgayLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("(*) Ca 1: Từ 9h - 16h / Ca 2: Từ 16h - 22h ");
        panelChucNang.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 390, 40));

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
        phanCaLamViecDAO = new PhanCaLamViecDAO();
        String maNV = (String) cbMaNhanVien.getSelectedItem();
        String maCa = cbCa.getSelectedIndex() == 0 ? "CA001" : "CA002";

        if (!checkNull(jdNgayLam.getDate())) {
            java.sql.Date ngayHienTai = new java.sql.Date(System.currentTimeMillis());
            java.sql.Date ngayLam = new java.sql.Date(jdNgayLam.getDate().getTime());
            if (ngayLam.after(ngayHienTai)) {
                PhanCaLamViec phanCa = new PhanCaLamViec(maNV, maCa, ngayLam);
                int kiemTra = phanCaLamViecDAO.phanCaLamViec(phanCa);

                switch (kiemTra) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Phân ca thất bại");
                        break;
                    case 1:
                        lamMoi();
                        JOptionPane.showMessageDialog(null, "Phân ca thành công");
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Ca làm việc này đã được phân cho nhân viên khác");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Nhân viên đã có ca làm việc ngày hôm đó");
                        break;
                    default:
                        throw new AssertionError();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ngày làm phải lớn hơn ngày hiện tại");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày làm");
        }
    }//GEN-LAST:event_jbPhanCaMouseClicked

    private void jbLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiMouseClicked
        lamMoi();
    }//GEN-LAST:event_jbLamMoiMouseClicked

    private void cbMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaNhanVienActionPerformed
        setName();        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaNhanVienActionPerformed

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
    }//GEN-LAST:event_jbXoaMouseClicked

    private void cbCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCa;
    private javax.swing.JComboBox<String> cbMaNhanVien;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel lblNgayLam;
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
