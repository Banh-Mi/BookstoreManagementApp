
package gui;

import com.toedter.calendar.JDateChooser;
import connectDB.ConnectDB;
import dao.KhachHangDAO;
import entity.Customer;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VONG VINH LOI
 */
public class JPannelCustomer extends javax.swing.JPanel {

    private ButtonGroup btgroup;
    private AbstractButton radNormal;
    private DefaultTableModel modelKhachHang;
    private KhachHangDAO khdao;
    String radio="";

    public JPannelCustomer() throws SQLException {
        initComponents();
        svgAdd.setSvgImage("add.svg", 30, 30);
        svgEdit.setSvgImage("edit.svg", 25, 25);
        svgDelete.setSvgImage("delete.svg", 30, 30);
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
        svgExcel.setSvgImage("excel.svg", 30, 30);
        svgExcel1.setSvgImage("excel.svg", 30, 30);
        svgPdf.setSvgImage("pdf.svg", 25, 30);
        svgSearch.setSvgImage("search.svg", 35, 35);
        ConnectDB.getInstance().connect();
        modelKhachHang = (DefaultTableModel) tablekh.getModel();
        loadData();
    }
    private void loadData() {
        khdao = new KhachHangDAO();
        for (Customer kh : khdao.getAllKh()) {
            Object[] row = {kh.getCustomer_id(),kh.getFullName(),kh.getPhone(),kh.getEmail(),kh.getGender(),kh.getTotal_spending(),kh.getDayOfBirth(),kh.getAddress(),kh.getCountry()};
            modelKhachHang.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbEmployeeManagerment = new javax.swing.JLabel();
        lblEmployeeID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablekh = new javax.swing.JTable();
        jpExcel = new customLib.JPanelRounded();
        jbExcel = new javax.swing.JLabel();
        svgExcel = new customLib.SVGImage();
        jpExcel1 = new customLib.JPanelRounded();
        jbExcel1 = new javax.swing.JLabel();
        svgExcel1 = new customLib.SVGImage();
        jpPdf = new customLib.JPanelRounded();
        jbPdf = new javax.swing.JLabel();
        svgPdf = new customLib.SVGImage();
        jPanelSearch = new javax.swing.JPanel();
        jLabelSearchByNameOrByCode = new javax.swing.JLabel();
        txtmakh = new javax.swing.JTextField();
        jLabelSearchByNameOrByCode1 = new javax.swing.JLabel();
        txthtkh = new javax.swing.JTextField();
        jLabelSearchByNameOrByCode2 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabelSearchByNameOrByCode3 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabelSearchByNameOrByCode4 = new javax.swing.JLabel();
        txtngaysinh = new com.toedter.calendar.JDateChooser();
        jbStatus = new javax.swing.JLabel();
        radnu = new javax.swing.JRadioButton();
        jLabelSearchByNameOrByCode5 = new javax.swing.JLabel();
        txttongchi = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        jLabelSearchByNameOrByCode6 = new javax.swing.JLabel();
        jPanelSort = new javax.swing.JPanel();
        jComboBoxSortSelection = new javax.swing.JComboBox<>();
        jComboBoxSortSelection1 = new javax.swing.JComboBox<>();
        btgroup = new ButtonGroup();
        radNormal1 = new javax.swing.JRadioButton();
        radLock1 = new javax.swing.JRadioButton();
        btgroup = new ButtonGroup();
        radNormal3 = new javax.swing.JRadioButton();
        radLock2 = new javax.swing.JRadioButton();
        jLabelSearchByNameOrByCode7 = new javax.swing.JLabel();
        txtgoiyten = new javax.swing.JTextField();
        txttongchiden = new javax.swing.JTextField();
        jLabelSearchByNameOrByCode8 = new javax.swing.JLabel();
        jLabelSearchByNameOrByCode9 = new javax.swing.JLabel();
        txttongchitu = new javax.swing.JTextField();
        jpSearch = new customLib.JPanelRounded();
        jbSearch = new javax.swing.JLabel();
        svgSearch = new customLib.SVGImage();
        btgroup = new ButtonGroup();
        radnam = new javax.swing.JRadioButton();
        jpAdd = new customLib.JPanelRounded();
        jbAdd = new javax.swing.JLabel();
        svgAdd = new customLib.SVGImage();
        jpDelete = new customLib.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new customLib.SVGImage();
        jpEdit = new customLib.JPanelRounded();
        jbEdit = new javax.swing.JLabel();
        svgEdit = new customLib.SVGImage();
        jpRefresh = new customLib.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new customLib.SVGImage();
        jLabelSearchByNameOrByCode10 = new javax.swing.JLabel();
        txtqg = new javax.swing.JTextField();

        jbEmployeeManagerment.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbEmployeeManagerment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbEmployeeManagerment.setText("THÔNG TIN KHÁCH HÀNG");

        lblEmployeeID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeID.setText("Số lượng khách hàng:");

        jLabel1.setText(".");

        tablekh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ Tên KH", "SĐT", "Email", "Phái", "Tổng chi", "Ngày Sinh", "Địa chỉ", "Quốc gia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablekh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablekhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablekh);
        if (tablekh.getColumnModel().getColumnCount() > 0) {
            tablekh.getColumnModel().getColumn(0).setHeaderValue("Mã KH");
            tablekh.getColumnModel().getColumn(1).setHeaderValue("Họ Tên KH");
            tablekh.getColumnModel().getColumn(2).setHeaderValue("SĐT");
            tablekh.getColumnModel().getColumn(3).setHeaderValue("Email");
            tablekh.getColumnModel().getColumn(4).setHeaderValue("Phái");
            tablekh.getColumnModel().getColumn(5).setHeaderValue("Tổng chi");
            tablekh.getColumnModel().getColumn(6).setHeaderValue("Ngày Sinh");
            tablekh.getColumnModel().getColumn(7).setHeaderValue("Địa chỉ");
            tablekh.getColumnModel().getColumn(8).setHeaderValue("Quốc gia");
        }

        jpExcel.setBackground(new java.awt.Color(255, 255, 255));
        jpExcel.setRoundedBottomLeft(10);
        jpExcel.setRoundedBottomRight(10);
        jpExcel.setRoundedTopLeft(10);
        jpExcel.setRoundedTopRight(10);
        jpExcel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbExcel.setText("Xuất Excel");
        jpExcel.add(jbExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 0, 90, 40));

        svgExcel.setText(" ");
        jpExcel.add(svgExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpExcel1.setBackground(new java.awt.Color(255, 255, 255));
        jpExcel1.setRoundedBottomLeft(10);
        jpExcel1.setRoundedBottomRight(10);
        jpExcel1.setRoundedTopLeft(10);
        jpExcel1.setRoundedTopRight(10);
        jpExcel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbExcel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbExcel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbExcel1.setText("Nhập Excel");
        jpExcel1.add(jbExcel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 0, 90, 40));

        svgExcel1.setText(" ");
        jpExcel1.add(svgExcel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpPdf.setBackground(new java.awt.Color(255, 255, 255));
        jpPdf.setRoundedBottomLeft(10);
        jpPdf.setRoundedBottomRight(10);
        jpPdf.setRoundedTopLeft(10);
        jpPdf.setRoundedTopRight(10);
        jpPdf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbPdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbPdf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbPdf.setText("Xuất PDF");
        jpPdf.add(jbPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 110, 40));

        svgPdf.setText(" ");
        jpPdf.add(svgPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NHẬP THÔNG TIN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanelSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSearchByNameOrByCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode.setText("Mã KH:");
        jPanelSearch.add(jLabelSearchByNameOrByCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        txtmakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakhActionPerformed(evt);
            }
        });
        jPanelSearch.add(txtmakh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, 30));

        jLabelSearchByNameOrByCode1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode1.setText("Họ Tên KH:");
        jPanelSearch.add(jLabelSearchByNameOrByCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        txthtkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthtkhActionPerformed(evt);
            }
        });
        jPanelSearch.add(txthtkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 210, 30));

        jLabelSearchByNameOrByCode2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode2.setText("SĐT:");
        jPanelSearch.add(jLabelSearchByNameOrByCode2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        txtsdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtActionPerformed(evt);
            }
        });
        jPanelSearch.add(txtsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 210, 30));

        jLabelSearchByNameOrByCode3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode3.setText("Email:");
        jPanelSearch.add(jLabelSearchByNameOrByCode3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        jPanelSearch.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 210, 30));

        jLabelSearchByNameOrByCode4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode4.setText("Ngày sinh:");
        jPanelSearch.add(jLabelSearchByNameOrByCode4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));
        jPanelSearch.add(txtngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 210, 30));

        jbStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbStatus.setText("Phái:");
        jPanelSearch.add(jbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 30));

        radnu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radnu.setText("Nữ");
        radnu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radnuMouseClicked(evt);
            }
        });
        jPanelSearch.add(radnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, 30));

        jLabelSearchByNameOrByCode5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode5.setText("Tổng chi:");
        jPanelSearch.add(jLabelSearchByNameOrByCode5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 100, 30));

        txttongchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongchiActionPerformed(evt);
            }
        });
        jPanelSearch.add(txttongchi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 170, 30));

        txtdiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachiActionPerformed(evt);
            }
        });
        jPanelSearch.add(txtdiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 170, 30));

        jLabelSearchByNameOrByCode6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode6.setText("Địa chỉ:");
        jPanelSearch.add(jLabelSearchByNameOrByCode6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 60, 30));

        jPanelSort.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanelSort.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxSortSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelSort.add(jComboBoxSortSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 310, 30));

        jComboBoxSortSelection1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelSort.add(jComboBoxSortSelection1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 310, 30));

        btgroup.add(radnu);
        btgroup.add(radNormal);
        radNormal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNormal1.setText("Nam");
        radNormal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNormal1ActionPerformed(evt);
            }
        });
        jPanelSort.add(radNormal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 30));

        radLock1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radLock1.setText("Nữ");
        jPanelSort.add(radLock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, 30));

        btgroup.add(radnu);
        btgroup.add(radNormal);
        radNormal3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNormal3.setText("Nam");
        radNormal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNormal3ActionPerformed(evt);
            }
        });
        jPanelSort.add(radNormal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, 30));

        radLock2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radLock2.setText("Nữ");
        jPanelSort.add(radLock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));

        jLabelSearchByNameOrByCode7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode7.setText("Gợi ý tên:");
        jPanelSort.add(jLabelSearchByNameOrByCode7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 30));

        txtgoiyten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgoiytenActionPerformed(evt);
            }
        });
        jPanelSort.add(txtgoiyten, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 210, 30));

        txttongchiden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongchidenActionPerformed(evt);
            }
        });
        jPanelSort.add(txttongchiden, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 80, 30));

        jLabelSearchByNameOrByCode8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode8.setText("Tổng chi đến:");
        jPanelSort.add(jLabelSearchByNameOrByCode8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 100, 30));

        jLabelSearchByNameOrByCode9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode9.setText("Tổng chi từ:");
        jPanelSort.add(jLabelSearchByNameOrByCode9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        txttongchitu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongchituActionPerformed(evt);
            }
        });
        jPanelSort.add(txttongchitu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 80, 30));

        jpSearch.setBackground(new java.awt.Color(255, 255, 255));
        jpSearch.setRoundedBottomLeft(10);
        jpSearch.setRoundedBottomRight(10);
        jpSearch.setRoundedTopLeft(10);
        jpSearch.setRoundedTopRight(10);
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbSearch.setText("Tìm");
        jpSearch.add(jbSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgSearch.setText(" ");
        jpSearch.add(svgSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanelSort.add(jpSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jPanelSearch.add(jPanelSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 410, 300));

        btgroup.add(radnam);
        btgroup.add(radnu);
        radnam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radnam.setText("Nam");
        radnam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radnamMouseClicked(evt);
            }
        });
        radnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radnamActionPerformed(evt);
            }
        });
        jPanelSearch.add(radnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 30));

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

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAdd.setText("Thêm");
        jpAdd.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgAdd.setText(" ");
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanelSearch.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 40));

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

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDelete.setText("Xoá");
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgDelete.setText(" ");
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanelSearch.add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 100, 40));

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

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbEdit.setText("Sửa");
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanelSearch.add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 100, 40));

        jpRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jpRefresh.setRoundedBottomLeft(10);
        jpRefresh.setRoundedBottomRight(10);
        jpRefresh.setRoundedTopLeft(10);
        jpRefresh.setRoundedTopRight(10);
        jpRefresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setText("Làm mới");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgRefresh.setText(" ");
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanelSearch.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 110, 40));

        jLabelSearchByNameOrByCode10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode10.setText("Quốc gia");
        jPanelSearch.add(jLabelSearchByNameOrByCode10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 70, 30));

        txtqg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqgActionPerformed(evt);
            }
        });
        jPanelSearch.add(txtqg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 170, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbEmployeeManagerment, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jpExcel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbEmployeeManagerment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jpExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jpPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtmakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakhActionPerformed

    private void txthtkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthtkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthtkhActionPerformed

    private void txtsdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txttongchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongchiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongchiActionPerformed

    private void txtdiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiActionPerformed

    private void radNormal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNormal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNormal1ActionPerformed

    private void radnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radnamActionPerformed

    private void radNormal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNormal3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNormal3ActionPerformed

    private void txtgoiytenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgoiytenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgoiytenActionPerformed

    private void txttongchidenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongchidenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongchidenActionPerformed

    private void txttongchituActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongchituActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongchituActionPerformed

    private void tablekhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablekhMouseClicked
     int rowindex = tablekh.getSelectedRow();
        if (rowindex >= 0) {
            String customer_id = modelKhachHang.getValueAt(rowindex, 0).toString();
            String fullName = modelKhachHang.getValueAt(rowindex, 1).toString();
            String phone = modelKhachHang.getValueAt(rowindex, 2).toString();
            String email = modelKhachHang.getValueAt(rowindex, 3).toString();
            String gender = modelKhachHang.getValueAt(rowindex, 4).toString();
            Integer total_spending = Integer.parseInt(modelKhachHang.getValueAt(rowindex, 5).toString()) ;
            Date dayOfBirth = (Date) modelKhachHang.getValueAt(rowindex, 6);
            String address = modelKhachHang.getValueAt(rowindex, 7).toString();
            String country =  modelKhachHang.getValueAt(rowindex, 8).toString();
            show(customer_id, fullName, phone, email,gender, total_spending+"", dayOfBirth, address, country);
        }
    }//GEN-LAST:event_tablekhMouseClicked

    private void txtqgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqgActionPerformed

    private void radnamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radnamMouseClicked
        radio="Nam";
    }//GEN-LAST:event_radnamMouseClicked

    private void radnuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radnuMouseClicked
        radio="Nữ";
    }//GEN-LAST:event_radnuMouseClicked

    private void jpAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddMouseClicked
        if(radnam.isSelected())
        {
            radio="Nam";
        }
        else 
        {
            radio="Nữ";
        }
        khdao = new KhachHangDAO();      
        String customer_id = this.txtmakh.getText();
        String fullName = this.txthtkh.getText();
        String phone = this.txtsdt.getText();
        String email = this.txtemail.getText();
        String gender = radio;
        Integer total_spending =Integer.parseInt(this.txttongchi.getText()); 
        java.sql.Date sqldate1 = new java.sql.Date(txtngaysinh.getDate().getTime());
        String address = this.txtdiachi.getText();
        String country =  this.txtqg.getText();   
        Customer kh = new Customer(customer_id, fullName, phone, email, gender, total_spending, sqldate1, address, country);
        khdao.insert(kh);
        Object[] row = {customer_id, fullName, phone, email, gender, total_spending, sqldate1, address, country};
        modelKhachHang.addRow(row);
        show("", "", "", "", "", "", null, "", "");
        radnam.setSelected(false);
        radnu.setSelected(false);
    }//GEN-LAST:event_jpAddMouseClicked

    private void jpEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEditMouseClicked
        int rowindex = tablekh.getSelectedRow();
        if (rowindex < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa");
             show("", "", "", "", "", "", null, "", "");
             radnam.setSelected(false);
             radnu.setSelected(false);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa dòng này không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                 if(radnam.isSelected())
                    {
                         radio="Nam";
                    }
                 else 
                    {
                         radio="Nữ";
                    }
                khdao = new KhachHangDAO();      
                String customer_id = this.txtmakh.getText();
                String fullName = this.txthtkh.getText();
                String phone = this.txtsdt.getText();
                String email = this.txtemail.getText();
                String gender = radio;
                Integer total_spending =Integer.parseInt(this.txttongchi.getText()); 
                java.sql.Date sqldate1 = new java.sql.Date(txtngaysinh.getDate().getTime());
                String address = this.txtdiachi.getText();
                String country =  this.txtqg.getText();   
                Customer kh = new Customer(customer_id, fullName, phone, email, gender, total_spending, sqldate1, address, country);
                khdao.update(kh);
                modelKhachHang.removeRow(rowindex);
                Object[] row = {customer_id, fullName, phone, email, gender, total_spending, sqldate1, address, country};
                modelKhachHang.insertRow(rowindex, row);
                show("", "", "", "", "", "", null, "", "");
                radnam.setSelected(false);
                radnu.setSelected(false);
            }
        }
    }//GEN-LAST:event_jpEditMouseClicked

    private void jpDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDeleteMouseClicked
        int rowindex = tablekh.getSelectedRow();
        if (rowindex == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xóa");
            show("", "", "", "", "", "", null, "", "");
            radnam.setSelected(false);
            radnu.setSelected(false);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                khdao.delete(txtmakh.getText());
                modelKhachHang.removeRow(rowindex);
                show("", "", "", "", "", "", null, "", "");
                radnam.setSelected(false);
                radnu.setSelected(false);
            }

        }
    }//GEN-LAST:event_jpDeleteMouseClicked

    public void show(String txtmakh,String txthtkh,String txtsdt,String txtemail,String radio, String txttongchi,Date txtngaysinh,String txtdiachi, String txtqg) {
        this.txtdiachi.setText(txtdiachi);
        this.txtemail.setText(txtemail);
        this.txthtkh.setText(txthtkh);
        this.txtmakh.setText(txtmakh); 
        this.txtngaysinh.setDate(txtngaysinh);
        this.txtqg.setText(txtqg); 
        this.txtsdt.setText(txtsdt); 
        this.txttongchi.setText(txttongchi+""); 
        if(radio.equals("Nam"))
        {
            radnam.setSelected(true);
        }
        else if(radio.equals("Nữ"))
        {
            radnu.setSelected(true);
        }
        else 
        {
            radnam.setSelected(false);
            radnu.setSelected(false);
        }
    }
    
  

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBoxSortSelection;
    private javax.swing.JComboBox<String> jComboBoxSortSelection1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSearchByNameOrByCode;
    private javax.swing.JLabel jLabelSearchByNameOrByCode1;
    private javax.swing.JLabel jLabelSearchByNameOrByCode10;
    private javax.swing.JLabel jLabelSearchByNameOrByCode2;
    private javax.swing.JLabel jLabelSearchByNameOrByCode3;
    private javax.swing.JLabel jLabelSearchByNameOrByCode4;
    private javax.swing.JLabel jLabelSearchByNameOrByCode5;
    private javax.swing.JLabel jLabelSearchByNameOrByCode6;
    private javax.swing.JLabel jLabelSearchByNameOrByCode7;
    private javax.swing.JLabel jLabelSearchByNameOrByCode8;
    private javax.swing.JLabel jLabelSearchByNameOrByCode9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JPanel jPanelSort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbEmployeeManagerment;
    private javax.swing.JLabel jbExcel;
    private javax.swing.JLabel jbExcel1;
    private javax.swing.JLabel jbPdf;
    private javax.swing.JLabel jbRefresh;
    private javax.swing.JLabel jbSearch;
    private javax.swing.JLabel jbStatus;
    private customLib.JPanelRounded jpAdd;
    private customLib.JPanelRounded jpDelete;
    private customLib.JPanelRounded jpEdit;
    private customLib.JPanelRounded jpExcel;
    private customLib.JPanelRounded jpExcel1;
    private customLib.JPanelRounded jpPdf;
    private customLib.JPanelRounded jpRefresh;
    private customLib.JPanelRounded jpSearch;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JRadioButton radLock1;
    private javax.swing.JRadioButton radLock2;
    private javax.swing.JRadioButton radNormal1;
    private javax.swing.JRadioButton radNormal3;
    private javax.swing.JRadioButton radnam;
    private javax.swing.JRadioButton radnu;
    private customLib.SVGImage svgAdd;
    private customLib.SVGImage svgDelete;
    private customLib.SVGImage svgEdit;
    private customLib.SVGImage svgExcel;
    private customLib.SVGImage svgExcel1;
    private customLib.SVGImage svgPdf;
    private customLib.SVGImage svgRefresh;
    private customLib.SVGImage svgSearch;
    private javax.swing.JTable tablekh;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtgoiyten;
    private javax.swing.JTextField txthtkh;
    private javax.swing.JTextField txtmakh;
    private com.toedter.calendar.JDateChooser txtngaysinh;
    private javax.swing.JTextField txtqg;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttongchi;
    private javax.swing.JTextField txttongchiden;
    private javax.swing.JTextField txttongchitu;
    // End of variables declaration//GEN-END:variables
}
