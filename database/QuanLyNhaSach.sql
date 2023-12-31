USE master
DROP DATABASE IF EXISTS "QuanLyNhaSach"
CREATE DATABASE	QuanLyNhaSach
GO

USE QuanLyNhaSach
GO
CREATE TABLE NhaCungCap
(
	maNhaCC varchar(50) PRIMARY KEY,
	tenNhaCC nvarchar(50) NULL,
	trangThai bit NOT NULL,
	diaChi nvarchar(255) NULL,
	email varchar(50) NULL,
	soDienThoai varchar(12) NULL,
	tenNguoiLienHe nvarchar(50) NULL
) 
GO

CREATE TABLE SanPham
(
	maSanPham varchar(13) PRIMARY KEY,
	tenSanPham nvarchar(255) NULL,
	danhMuc nvarchar(255) NULL,
	maNhaCC varchar(50) NULL,
	gia float NOT NULL,
	donViTinh nvarchar(20) NULL,
	soLuong int NOT NULL,
	tacGia nvarchar(50) NULL,
	soTrang int NULL,
	namXuatBan int NULL,
	nhaXuatBan nvarchar(100) NULL,
	hinhAnh varchar(255) NULL,
	trangThai bit NULL,
	moTa nvarchar(255) NULL,

	CONSTRAINT FK_NhaCungCap_SanPham FOREIGN KEY (maNhaCC) REFERENCES NhaCungCap(maNhaCC)
)
GO

CREATE TABLE CaLamViec (
    maCaLamViec VARCHAR(10) PRIMARY KEY,
    tenCa NVARCHAR(50) NOT NULL,
    thoiGianVao TIME NOT NULL,
    thoiGianRa TIME NOT NULL
);

GO

CREATE TABLE KhuyenMai
(
	maKhuyenMai varchar(50) PRIMARY KEY,
	tenChuongTrinh nvarchar(255) NULL,
	phanTramKhuyenMai float NULL,
	ngayBatDau date NULL,
	ngayKetThuc date NULL,
	moTa nvarchar(255) NULL,
)
GO

CREATE TABLE KhachHang
(
	maKH varchar(50) PRIMARY KEY,
	tenKH nvarchar(255) NULL,
	soDienThoai varchar(12) NULL,
	email varchar(50) NULL,
	ngaySinh date NULL,
	diaChi nvarchar(255) NULL,
	gioiTinh nvarchar(10) NULL,
	theVip nvarchar(30)NULL,
	ngayDangKy date NULL,
)
GO

Create TABLE TaiKhoan
(
	maTK varchar(50) PRIMARY KEY,
	tenDangNhap varchar(100) NULL,
	matKhau varchar(255) NULL,
	quyen varchar(50) NULL,
	trangThaiTaiKhoan nvarchar(50) NULL,
)
GO

Create TABLE NhanVien
(
	maNV varchar(50) PRIMARY KEY,
	tenNV nvarchar(255) NULL,
	soDienThoai varchar(12) NULL,
	email varchar(50) NULL,
	ngaySinh date NULL,
	maTK varchar(50) NULL,
	diaChi nvarchar(255) NULL,
	gioiTinh nvarchar(10) NULL,
	chucVu nvarchar(50) NULL,
	trangThai nvarchar(50) NULL,
	ngayVaoLam date NULL,
	Luong INT NULL,
	CONSTRAINT FK_TaiKhoan_NhanVien FOREIGN KEY (maTK) REFERENCES TaiKhoan(maTK),
)
GO
CREATE TABLE LichLamViec (
    maNV varchar(50) REFERENCES NhanVien(maNV),
    maCaLamViec  VARCHAR(10) REFERENCES CaLamViec(MaCaLamViec),
    ngay date,
    PRIMARY KEY (maNV, maCaLamViec, ngay)
);
GO
CREATE TABLE DonDatHang
(
	maDonHang varchar(50) PRIMARY KEY,
	maKH varchar(50) NULL,
	maNV varchar(50) NULL,
	maKhuyenMai varchar(50) NULL,
	ngayDatHang date NULL,
	soDienThoai varchar(12) NULL,
	trangThai nvarchar(50) NULL,
	ghiChu nvarchar(255) NULL

	
	CONSTRAINT FK_KhachHang_DonDatHang FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
	CONSTRAINT FK_NhanVien_DonDatHang FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
	CONSTRAINT FK_KhuyenMai_DonDatHang FOREIGN KEY (maKhuyenMai) REFERENCES KhuyenMai(maKhuyenMai)

)
GO

CREATE TABLE ChiTietDonDatHang
(
	maDonHang varchar(50),
	maSanPham varchar(13),
	soLuong int NOT NULL,
	gia float NOT NULL,

	PRIMARY KEY(maDonHang, maSanPham),
	CONSTRAINT FK_DatHang_ChiTietDonDatHang FOREIGN KEY (maDonHang) REFERENCES DonDatHang(maDonHang),
	CONSTRAINT FK_SanPham_ChiTietDonDatHang FOREIGN KEY (maSanPham) REFERENCES SanPham(maSanPham)
) 
GO

CREATE TABLE HoaDon
(
	maHoaDon varchar(50) PRIMARY KEY,
	maKH varchar(50) NULL,
	maNV varchar(50) NULL,
	maKhuyenMai varchar(50) NULL,
	phuongThucThanhToan nvarchar(255) NULL,
	ngayLapHoaDon date NULL,
	soDienThoai varchar(12) NULL,
	trangThai nvarchar(50) NULL,
	ghiChu nvarchar(255) NULL

	
	CONSTRAINT FK_KhachHang_HoaDon FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
	CONSTRAINT FK_NhanVien_HoaDon FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
	CONSTRAINT FK_KhuyenMai_HoaDon FOREIGN KEY (maKhuyenMai) REFERENCES KhuyenMai(maKhuyenMai)

)
GO

CREATE TABLE ChiTietHoaDon
(
	maHoaDon varchar(50),
	maSanPham varchar(13),
	soLuong int NOT NULL,
	gia float NOT NULL,

	PRIMARY KEY(maHoaDon, maSanPham),
	CONSTRAINT FK_HoaDon_ChiTietHoaDon FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon),
	CONSTRAINT FK_SanPham_ChiTietHoaDon FOREIGN KEY (maSanPham) REFERENCES SanPham(maSanPham)
) 








-- Chèn dữ liệu
GO

INSERT INTO NhaCungCap (maNhaCC, tenNhaCC, trangThai, diaChi, email, soDienThoai, tenNguoiLienHe)
VALUES ('NCC001', N'Công ty A', 1, N'Địa chỉ A', 'emaila@example.com', '123456789', N'Người A'),
       ('NCC002', N'Công ty B', 1, N'Địa chỉ B', 'emailb@example.com', '987654321', N'Người B'),
	   ('NCC003', N'Công ty 21', 1, N'Địa chỉ C', 'email21@example.com', '123456789', N'Người 21'),
	   ('NCC004', N'Công ty 22', 1, N'Huỳnh Khương An', 'email22@example.com', '123456789', N'Người 22'),
	   ('NCC005', N'Công ty 23', 1, N'Địa chỉ 23', 'email23@example.com', '123456789', N'Người 23');
GO

INSERT INTO SanPham (maSanPham, tenSanPham, danhMuc, maNhaCC, gia, donViTinh, soLuong, moTa, tacGia, soTrang, namXuatBan, nhaXuatBan, hinhAnh, trangThai)
VALUES ('9781234567890', N'Đệ nhất kiếm tiền',                             N'Sách',       'NCC005', 800000, N'Quyển', 10, N'Có làm thì mới có ăn', N'Huấn hoa hồng', 200, 2020, N'NXB SG', 'src/main/resources/images/light/deNhatKiemTien.png', 1),
       ('9786049201417', N'Phương pháp luận Nghiên cứu Khoa học',          N'Sách',       'NCC002', 35000, N'Quyển', 200, N'Giáo trình', N'Nguyễn Thị Thu Trang', 194, 2021, N'Đại Học Công Nghiệp TPHCM', 'src/main/resources/images/light/pplnckh.jpg', 0),
	   ('9786048878627', N'Đắc nhân tâm',                                  N'Sách',       'NCC001', 82000, N'Quyển', 200, N'Sách phát triển bản thân', N'Dale Carnegie', 486, 1936, N'Dân Trí', 'src/main/resources/images/light/dacNhanTam.png', 1),
	   ('9786041004757', N'Cho tôi xin một vé đi tuổi thơ',		           N'Sách',       'NCC001', 80000, N'Quyển', 20, N'Sách tuổi thơ', N'Nguyễn Nhật Ánh', 208, 2018, N'Trẻ', 'src/main/resources/images/light/choToiXinMotVeDiTuoiTho.jpg', 1),
	   ('9786040039460', N'Tiếng Việt thực hành',				           N'Sách',       'NCC002', 55000, N'Quyển', 69, N'Giáo trình', N'Bùi Minh Toán', 280, 2014, N'Giáo dục Việt Nam', 'src/main/resources/images/light/tiengVietThucHanh.png', 1),
	   ('9780747544074', N'Harry Potter and the Sorcerer''s Stone',        N'Sách',       'NCC001', 734500, N'Quyển', 50, N'Harry Potter series - Book 1', N'J.K. Rowling', 320, 1997, N'Scholastic', 'src/main/resources/images/light/harryPotter.jpg ', 1),
	   ('9780007123827', N'Lord of the Rings: The Fellowship of the Ring', N'Sách',       'NCC002', 239000, N'Quyển', 100, N'Lord of the Rings series - Book 1', N'J.R.R. Tolkien', 432, 1954, N'Houghton Mifflin Harcourt', 'src/main/resources/images/light/lordOfTheRing.png', 1),
	   ('9781234567892', N'To Kill a Mockingbird',                         N'Sách',       'NCC003', 638000, N'Quyển', 70, N'Classic American Novel', N'Harper Lee', 281, 1960, N'J.B. Lippincott & Co.', ' ', 0),
	   ('9786049201419', N'The Great Gatsby',                              N'Sách',       'NCC004', 1179000, N'Quyển', 90, N'F. Scott Fitzgerald''s Masterpiece', N'F. Scott Fitzgerald', 218, 1925, N'Scribner', ' ', 0),
	   ('9781234567893', N'Pride and Prejudice',                           N'Sách',       'NCC003', 1129000, N'Quyển', 60, N'Classic English Literature', N'Jane Austen', 432, 1813, N'T. Egerton', ' ', 0),
	   ('9786049201420', N'1984',                                          N'Sách',       'NCC001', 1351000, N'Quyển', 110, N'Dystopian Novel', N'George Orwell', 328, 1949, N'Secker and Warburg', ' ', 0),
	   ('8935001800347', N'Bút bi Thiên Long TL-027 Mực xanh',	N'Dụng cụ học tập',      'NCC002', 4000, N'Cái', 269, N'Bút bi quốc dân', NULL, NULL, NULL, NULL, 'src/main/resources/images/light/butBiThienLongXanh.jpg', 1),
	   ('8935001853231', N'Dập Ghim Deli 316 - Màu Đen',		 N'Văn phòng phẩm',      'NCC002', 85500, N'Cái', 50, N'Dập ghim cao cấp', NULL, NULL, NULL, NULL, 'src/main/resources/images/light/dapGhimDeli316.jpg', 1),
	   ('8935001847231', N'Rubik3x3 8733-5',							N'Đồ chơi',      'NCC003', 42000, N'Cục', 50, N'Rubik quay tay', NULL, NULL, NULL, NULL, 'src/main/resources/images/light/rubik3x3_8733-5.jpg', 1),
	   ('8935002913231', N'Bình Nước Học Sinh Có Vòi Phun 700 ml',	N'Quà lưu niệm',     'NCC004', 196000, N'Bình', 20, N'Frozen Elsa - HooHooHaHa GDH03-2604', NULL, NULL, NULL, NULL, 'src/main/resources/images/light/binhNuocHocSinh.jpg', 1);
GO   

-- Thêm ca làm việc Sáng
INSERT INTO CaLamViec (maCaLamViec, tenCa, thoiGianVao, thoiGianRa)
VALUES ('CA001', 'Ca 1', '09:00:00', '16:00:00'),
		('CA002', 'Ca 2', '16:00:00', '22:00:00');
GO

INSERT INTO KhuyenMai (maKhuyenMai, tenChuongTrinh, phanTramKhuyenMai, ngayBatDau, ngayKetThuc, moTa)
VALUES ('KM001', N'Khuyến mãi A', 10, '2023-10-11', '2023-10-20', N'Khuyến mãi đầu thu'),
	   ('KM002', N'Khuyến mãi B', 15, '2023-10-14', '2023-10-23', N'Khuyến mãi cuối thu'),
	   ('KM003', N'Khuyến mãi C', 20, '2023-10-15', '2023-10-24', N'Khuyến mãi cuối năm'),
	   ('KM004', N'Khuyến mãi D', 12, '2023-10-16', '2023-10-25', N'Khuyến mãi đầu năm');
GO

INSERT INTO KhachHang (maKH, tenKH, soDienThoai, email, ngaySinh, diaChi, gioiTinh, theVip, ngayDangKy)
VALUES ('KH000', N'Khách hàng bán lẻ', '', '', NULL, '', '','',NULL),
	   ('KH001', N'Nguyễn Thành Thuận', '0337969324', 'longkim223300@gmail.com', '2003-01-01', N'Địa chỉ khách hàng 1', N'Nam',N'Đồng','2019-01-01'),
       ('KH002', N'Nguyễn Thanh Nhứt', '0901407421', 'thanhnhutcu@gmail.com', '2003-03-15', N'Địa chỉ khách hàng 2', N'Nữ',N'Bạc','2020-02-01'),
	   ('KH003', N'Vòng Vĩnh Lợi', '0343098508', 'loivinh759@gmail.com', '2003-05-10', N'Địa chỉ khách hàng 3', N'Nam',N'Vàng','2021-03-01'),
	   ('KH004', N'Khách hàng 4', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Kim cương','2022-04-01'),
	   ('KH005', N'Khách hàng 5', '555555555', 'kh5@example.com', '1997-08-21', N'Địa chỉ khách hàng 5', N'Nam',N'Ruby','2022-05-01'),
	   ('KH006', N'Khách hàng 6', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Kim cương','2022-06-01'),
	   ('KH007', N'Khách hàng 7', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Vàng','2022-07-01'),
	   ('KH008', N'Khách hàng 8', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Vàng','2022-08-01'),
	   ('KH009', N'Khách hàng 9', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Bạc','2022-09-01'),
	   ('KH010', N'Khách hàng 10', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Bạc','2022-10-01'),
	   ('KH011', N'Khách hàng 11', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Kim cương','2023-01-01'),
	   ('KH012', N'Khách hàng 12', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Bạc','2023-02-01'),
	   ('KH013', N'Khách hàng 13', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Vàng','2023-02-01'),
	   ('KH014', N'Khách hàng 14', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Kim cương','2023-03-01');
GO

INSERT INTO TaiKhoan (maTK, tenDangNhap, matKhau, quyen, trangThaiTaiKhoan)
VALUES ('TK001', 'NV001', 'B59C67BF196A4758191E42F76670CEBA', N'User', N'Đang hoạt động'),
       ('TK002', 'NV002', 'B59C67BF196A4758191E42F76670CEBA', N'User', N'Tạm khóa'),
	   ('TK003', 'NV003', 'B59C67BF196A4758191E42F76670CEBA', N'User', N'Đang hoạt động'),
	   ('TK004', 'NV004', 'B59C67BF196A4758191E42F76670CEBA', N'User', N'Đang hoạt động'),
	   ('TK005', 'NV005', 'B59C67BF196A4758191E42F76670CEBA', N'User', N'Đang hoạt động');
GO
INSERT INTO NhanVien (maNV, tenNV, soDienThoai, email, ngaySinh, maTK, diaChi, gioiTinh, chucVu, trangThai,ngayVaoLam,Luong)
VALUES ('NV001', N'Nguyễn Văn A', '0324568123', 'nguyenvana@example.com', '1990-02-15', 'TK001', N'Gò Vấp', N'Nam', N'Quản lý', N'Đang làm','2020-02-15',7000),
	   ('NV002', N'Phạm Thị B', '0987654321', 'phamthib@example.com', '1995-07-20', 'TK002', N'Bình Thạnh', N'Nữ', N'Nhân viên kinh doanh', N'Đã nghĩ','2021-02-15',8000),
	   ('NV003', N'Lê Thị C', '0369874512', 'lethic@example.com', '1988-11-10', 'TK003', N'Tân Bình', N'Nữ', N'Kế toán', N'Đang làm','2022-02-15',9000),
       ('NV004', N'Huỳnh Thị D', '0932145678', 'huynhthid@example.com', '1992-04-25', 'TK004', N'Quận 1', N'Nữ', N'Nhân viên IT', N'Đang làm','2023-02-15',6000),
       ('NV005', N'Trần Thị E', '0765432109', 'tranthie@example.com', '1998-08-30', 'TK005', N'Quận 3', N'Nữ', N'Nhân viên marketing', N'Đang làm','2020-07-15',6500)

GO

INSERT INTO HoaDon (maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon, soDienThoai, trangThai, ghiChu)
VALUES ('HD001', 'KH001', 'NV001', 'KM001', N'Tiền mặt', '2023-10-11', NULL, N'Đã thanh toán', ''),
       ('HD002', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2023-10-12', '0901407421', N'Đã thanh toán', ''),
	   ('HD003', 'KH003', 'NV003', 'KM002', N'Tiền mặt', '2023-10-16', NULL, N'Đã thanh toán', ''),
	   ('HD004', 'KH004', 'NV004', 'KM003', N'Thẻ tín dụng', '2023-10-17', '0808150888', N'Đã thanh toán', ''),
	   ('HD005', 'KH005', 'NV005', 'KM004', N'Tiền mặt', '2023-10-18', NULL, N'Đã thanh toán', ''),
	   ('HD006', 'KH001', 'NV001', 'KM001', N'Tiền mặt', '2021-01-19', NULL, N'Đã thanh toán', ''),
	   ('HD007', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2021-02-20', '0987654321', N'Đã thanh toán', ''),
	   ('HD008', 'KH003', 'NV003', NULL, N'Tiền mặt', '2021-03-21', NULL, N'Đã thanh toán', ''),
	   ('HD009', 'KH004', 'NV004', 'KM002', N'Thẻ tín dụng', '2021-04-22', '0343098508', N'Đã thanh toán', ''),
	   ('HD010', 'KH005', 'NV005', 'KM003', N'Tiền mặt', '2021-05-23', NULL, N'Đã thanh toán', ''),
	   ('HD011', 'KH001', 'NV001', 'KM004', N'Tiền mặt', '2022-06-19', NULL, N'Đã thanh toán', ''),
	   ('HD012', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2022-07-20', '0909123212', N'Đã thanh toán', ''),
	   ('HD013', 'KH003', 'NV003', NULL, N'Tiền mặt', '2022-08-21', NULL, N'Đã thanh toán', ''),
	   ('HD014', 'KH004', 'NV004', 'KM001', N'Thẻ tín dụng', '2022-09-22', '0343098508', N'Đã thanh toán', ''),
	   ('HD015', 'KH005', 'NV005', 'KM002', N'Tiền mặt', '2022-10-23', NULL, N'Đã thanh toán', ''),
	   ('HD016', 'KH001', 'NV001', 'KM004', N'Tiền mặt', '2023-05-10', NULL, N'Đã thanh toán', ''),
	   ('HD017', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2023-06-15', '0977553323', N'Đã thanh toán', ''),
	   ('HD018', 'KH003', 'NV003', NULL, N'Tiền mặt', '2023-07-20', NULL, N'Đã thanh toán', ''),
	   ('HD019', 'KH004', 'NV004', 'KM001', N'Thẻ tín dụng', '2023-08-25', '0376543321', N'Đã thanh toán', ''),
	   ('HD020', 'KH005', 'NV005', 'KM002', N'Tiền mặt', '2023-09-30', NULL, N'Chờ thanh toán', ''),
	   ('HD021', 'KH001', 'NV001', 'KM003', N'Thẻ tín dụng', '2023-10-05', '0343098508', N'Đã hủy', '');
GO
INSERT INTO HoaDon (maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon, trangThai, ghiChu)
VALUES ('HD022', 'KH006', 'NV001', 'KM002', N'Tiền mặt', '2023-10-11', N'Đã thanh toán', ''),
	   ('HD023', 'KH007', 'NV002', 'KM003', N'Tiền mặt', '2023-09-12', N'Đã thanh toán', ''),
	   ('HD024', 'KH008', 'NV003', 'KM002', N'Tiền mặt', '2023-09-11', N'Đã thanh toán', ''),
	   ('HD025', 'KH009', 'NV004', 'KM001', N'Tiền mặt', '2023-06-16', N'Đã thanh toán', ''),
	   ('HD026', 'KH010', 'NV005', 'KM004', N'Tiền mặt', '2023-05-17', N'Đã thanh toán', ''),
	   ('HD027', 'KH011', 'NV005', 'KM003', N'Tiền mặt', '2023-04-13', N'Đã thanh toán', ''),
	   ('HD028', 'KH012', 'NV005', 'KM004', N'Tiền mặt', '2023-03-02', N'Đã thanh toán', ''),
	   ('HD029', 'KH013', 'NV003', 'KM004', N'Tiền mặt', '2023-02-11', N'Đã thanh toán', ''),
	   ('HD030', 'KH014', 'NV003', 'KM002', N'Tiền mặt', '2023-01-12', N'Đã thanh toán', ''),
	   ('HD031', 'KH012', 'NV003', 'KM002', N'Tiền mặt', '2022-01-15', N'Đã thanh toán', ''),
	   ('HD032', 'KH013', 'NV002', 'KM001', N'Tiền mặt', '2022-11-15', N'Đã thanh toán', ''),
	   ('HD033', 'KH013', 'NV002', 'KM001', N'Tiền mặt', '2022-12-15', N'Đã thanh toán', ''),
	   ('HD034', 'KH014', 'NV002', 'KM003', N'Tiền mặt', '2022-06-15', N'Đã thanh toán', ''),
	   ('HD035', 'KH009', 'NV001', 'KM003', N'Tiền mặt', '2022-05-15', N'Đã thanh toán', ''),
	   ('HD036', 'KH008', 'NV002', 'KM003', N'Tiền mặt', '2022-04-15', N'Đã thanh toán', ''),
	   ('HD037', 'KH007', 'NV002', 'KM002', N'Tiền mặt', '2022-03-15', N'Đã thanh toán', ''),
	   ('HD038', 'KH006', 'NV001', 'KM002', N'Tiền mặt', '2022-02-15', N'Đã thanh toán', '');
GO

INSERT INTO ChiTietHoaDon (maHoaDon, maSanPham, soLuong, gia)
VALUES ('HD001', '9781234567890', 10, 800000),
('HD001', '9786049201417', 2, 35000),
('HD001', '9786048878627', 3, 82000),

('HD002', '9786041004757', 1, 80000),
('HD002', '9786040039460', 5, 55000),
('HD002', '9780747544074', 6, 734500),
('HD002', '9780007123827', 3, 239000),

('HD003', '8935001800347', 2, 4000),

('HD004', '8935001853231', 4, 85500),
('HD004', '8935001847231', 4, 42000),
('HD004', '8935002913231', 3, 196000),

('HD005', '9781234567890', 1, 800000),
('HD005', '9786049201417', 2, 35000),
('HD005', '9786048878627', 2, 82000),

('HD006', '9786041004757', 1, 80000),
('HD006', '9786040039460', 2, 55000),
('HD006', '9780747544074', 2, 734500),
('HD006', '9780007123827', 4, 239000),

('HD007', '9781234567892', 2, 638000),
('HD007', '9786049201419', 2, 1179000),
('HD007', '9781234567893', 3, 1129000),
('HD007', '9786049201420', 1, 1351000),
('HD007', '8935001800347', 4, 4000),

('HD008', '8935001853231', 2, 85500),
('HD008', '8935001847231', 4, 42000),
('HD008', '8935002913231', 3, 196000),

('HD009', '9781234567890', 2, 800000),
('HD009', '9786049201417', 2, 35000),
('HD009', '9786048878627', 3, 82000),

('HD010', '9786041004757', 20, 80000),
('HD010', '9786040039460', 4, 55000),
('HD010', '9780747544074', 6, 734500),
('HD010', '9780007123827', 4, 239000),

('HD011', '9781234567892', 3, 638000),
('HD011', '9786049201419', 2, 1179000),
('HD011', '9781234567893', 3, 1129000),
('HD011', '9786049201420', 3, 1351000),
('HD011', '8935001800347', 2, 4000),

('HD012', '8935001853231', 2, 85500),
('HD012', '8935001847231', 3, 42000),
('HD012', '8935002913231', 20, 196000),

('HD013', '9781234567890', 2, 800000),
('HD013', '9786049201417', 10, 35000),
('HD013', '9786048878627', 9, 82000),

('HD014', '9786041004757', 9, 80000),
('HD014', '9786040039460', 6, 55000),
('HD014', '9780747544074', 7, 734500),
('HD014', '9780007123827', 1, 239000),

('HD015', '9781234567892', 3, 638000),
('HD015', '9786049201419', 3, 1179000),
('HD015', '9781234567893', 2, 1129000),
('HD015', '9786049201420', 1, 1351000),
('HD015', '8935001800347', 3, 4000),

('HD016', '9781234567890', 10, 800000),

('HD017', '9786041004757', 20, 80000),
('HD017', '9786040039460', 3, 55000),
('HD017', '9780747544074', 1, 734500),

('HD018', '9780007123827', 3, 239000),
('HD018', '9781234567892', 2, 638000),

('HD019', '9781234567893', 1, 1129000),
('HD019', '9786049201420', 3, 1351000),
('HD019', '8935001800347', 1, 4000),

('HD020', '8935002913231', 20, 196000),
('HD021', '9780747544074', 7, 734500),
('HD022', '9780007123827', 1, 239000),
--
('HD022', '9786041004757', 9, 80000),
('HD022', '9786040039460', 6, 55000),
('HD023', '9780747544074', 7, 734500),
('HD024', '9780007123827', 1, 239000),

('HD025', '9781234567892', 3, 638000),
('HD025', '9786049201419', 3, 1179000),
('HD026', '9781234567893', 2, 1129000),
('HD026', '9786049201420', 1, 1351000),
('HD026', '8935001800347', 3, 4000),

('HD027', '9781234567890', 10, 800000),

('HD027', '9786041004757', 20, 80000),
('HD027', '9786040039460', 3, 55000),
('HD028', '9780747544074', 1, 734500),

('HD028', '9780007123827', 3, 239000),
('HD028', '9781234567892', 2, 638000),

('HD028', '9781234567893', 1, 1129000),
('HD029', '9786049201420', 3, 1351000),
('HD029', '8935001800347', 1, 4000),

('HD030', '8935002913231', 20, 196000),
('HD031', '9786049201417', 2, 35000),
('HD031', '9786048878627', 3, 82000),

('HD032', '9786041004757', 1, 80000),
('HD032', '9786040039460', 5, 55000),
('HD032', '9780747544074', 6, 734500),
('HD032', '9780007123827', 3, 239000),

('HD033', '8935001800347', 2, 4000),

('HD034', '8935001853231', 4, 85500),
('HD034', '8935001847231', 4, 42000),
('HD034', '8935002913231', 3, 196000),

('HD035', '9781234567890', 1, 800000),
('HD035', '9786049201417', 2, 35000),
('HD035', '9786048878627', 2, 82000),

('HD036', '9786041004757', 1, 80000),
('HD036', '9786040039460', 2, 55000),
('HD036', '9780747544074', 2, 734500),
('HD036', '9780007123827', 4, 239000),

('HD037', '9781234567892', 2, 638000),
('HD037', '9786049201419', 2, 1179000),
('HD037', '9781234567893', 3, 1129000),
('HD037', '9786049201420', 1, 1351000),
('HD037', '8935001800347', 4, 4000),

('HD038', '8935001853231', 2, 85500),
('HD038', '8935001847231', 4, 42000),
('HD038', '8935002913231', 3, 196000);
GO
CREATE PROCEDURE InsertProduct
    @maSanPham varchar(13),
    @tenSanPham nvarchar(255),
    @danhMuc nvarchar(255),
    @tenNhaCC varchar(50),
    @gia float,
    @donViTinh nvarchar(20),
    @soLuong int,
    @hinhAnh varchar(255),
    @trangThai bit,
    @moTa nvarchar(255),
	@soTrang int,
    @namXuatBan int,
    @nhaXuatBan nvarchar(100),
	@tacGia nvarchar(50),
	@thongBao int output
AS
BEGIN
    -- Kiểm tra xem mã sản phẩm đã tồn tại chưa
    IF EXISTS (SELECT 1 FROM SanPham WHERE maSanPham = @maSanPham)
    BEGIN
        SET @thongBao = 1;
        RETURN;
    END;

    -- Kiểm tra xem mã nhà cung cấp có tồn tại không
    IF NOT EXISTS (SELECT 1 FROM NhaCungCap WHERE tenNhaCC LIKE '%'+@tenNhaCC+'%')
    BEGIN
        SET @thongBao = 2;
        RETURN;
    END;
	Declare @maNCC varchar(10);
	SELECT @maNCC = maNhaCC FROM NhaCungCap WHERE tenNhaCC LIKE '%Công ty A%';
    -- Thêm sản phẩm mới
    INSERT INTO SanPham (
        maSanPham, 
        tenSanPham, 
        danhMuc, 
        maNhaCC, 
        gia, 
        donViTinh, 
        soLuong, 
        tacGia, 
        soTrang, 
        namXuatBan, 
        nhaXuatBan, 
        hinhAnh, 
        trangThai, 
        moTa
    )
    VALUES (
        @maSanPham, 
        @tenSanPham, 
        @danhMuc, 
        @maNCC, 
        @gia, 
        @donViTinh, 
        @soLuong, 
        @tacGia, 
        @soTrang, 
        @namXuatBan, 
        @nhaXuatBan, 
        @hinhAnh, 
        @trangThai, 
        @moTa
    )

     SET @thongBao = 3;
END;
GO
CREATE TRIGGER updateTaiKhoan_NhanVien
ON NhanVien
AFTER UPDATE
AS
BEGIN
    IF UPDATE (trangThai)
    BEGIN
        -- Cập nhật trạng thái tài khoản thành 'Tạm Khoá' nếu trạng thái nhân viên là 'Đã Nghỉ'
        UPDATE TaiKhoan
        SET trangThaiTaiKhoan = N'Tạm khoá'
        FROM TaiKhoan
        INNER JOIN inserted ON TaiKhoan.maTK = inserted.maTK
        INNER JOIN deleted ON TaiKhoan.maTK = deleted.maTK
        WHERE inserted.trangThai = N'Đã nghĩ' AND deleted.trangThai <> N'Đã nghĩ';
        
        -- Cập nhật trạng thái tài khoản thành 'Bình Thường' nếu trạng thái nhân viên là 'Đang làm'
        UPDATE TaiKhoan
        SET trangThaiTaiKhoan = N'Đang hoạt động'
        FROM TaiKhoan
        INNER JOIN inserted ON TaiKhoan.maTK = inserted.maTK
        INNER JOIN deleted ON TaiKhoan.maTK = deleted.maTK
        WHERE inserted.trangThai = N'Đang làm' AND deleted.trangThai <> N'Đang làm';
    END;
END;
GO
CREATE PROCEDURE CheckLogin(@maNV NVARCHAR(50), @result int output)
AS
BEGIN
    -- Kiểm tra xem nhân viên có phải là quản lý hay không
    IF EXISTS (
        SELECT *
        FROM [NhanVien]
        WHERE [maNV] LIKE @maNV AND chucVu LIKE N'Quản lý'
    )
    BEGIN
       SET @result = 1 -- Nếu là quản lý, trả về 1
    END
    ELSE -- Nếu không phải quản lý, kiểm tra lịch làm việc
    BEGIN
        DECLARE @CurrentDateTime DATETIME = GETDATE();
        DECLARE @Ngay AS DATE = CAST(@CurrentDateTime AS DATE);
        DECLARE @Gio AS TIME = CAST(@CurrentDateTime AS TIME);

        -- Kiểm tra lịch làm việc của nhân viên
        IF EXISTS (
            SELECT 1
            FROM [LichLamViec] AS llv
            JOIN [CaLamViec] AS clv ON llv.[maCaLamViec] = clv.[maCaLamViec]
            WHERE [maNV] = @maNV
              AND [ngay] = @Ngay
              AND @Gio BETWEEN [thoiGianVao] AND [thoiGianRa]
        )
        BEGIN
            SET @result = 1 -- Nếu tìm thấy, trả về 1
        END
        ELSE
        BEGIN
            SET @result = 0 -- Nếu không tìm thấy, trả về 0
        END
    END
END;

GO
CREATE PROCEDURE DoanhThuTuyChinh
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT
			HD.maHoaDon,
			NV.tenNV,
			KH.tenKH,
			HD.ngayLapHoaDon,
			SUM((CH.soLuong * SP.gia)) As TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS TongThanhTien
			
		FROM
			HoaDon HD
			JOIN NhanVien NV ON HD.maNV = NV.maNV
			JOIN KhachHang KH ON HD.maKH = KH.maKH
			JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
			JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
			LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
		GROUP BY
			HD.maHoaDon, NV.tenNV, KH.tenKH, HD.ngayLapHoaDon;
	END;
	ELSE
	BEGIN
		SELECT
			HD.maHoaDon,
			NV.tenNV,
			KH.tenKH,
			HD.ngayLapHoaDon,
			SUM((CH.soLuong * SP.gia)) As TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS TongThanhTien
		FROM
			HoaDon HD
			JOIN NhanVien NV ON HD.maNV = NV.maNV
			JOIN KhachHang KH ON HD.maKH = KH.maKH
			JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
			JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
			LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
		WHERE HD.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
		GROUP BY
			HD.maHoaDon, NV.tenNV, KH.tenKH, HD.ngayLapHoaDon;
	END;
END;

GO
CREATE PROCEDURE DoanhThuThangNam
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
        SELECT
			HD.maHoaDon,
			NV.tenNV,
			KH.tenKH,
			HD.ngayLapHoaDon,
			SUM((CH.soLuong * SP.gia)) As TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS TongTien
		FROM
			HoaDon HD
			JOIN NhanVien NV ON HD.maNV = NV.maNV
			JOIN KhachHang KH ON HD.maKH = KH.maKH
			JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
			JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
			LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
	
        WHERE YEAR(HD.ngayLapHoaDon) = @Year
        GROUP BY
			HD.maHoaDon, NV.tenNV, KH.tenKH, HD.ngayLapHoaDon;
    END
    ELSE
    BEGIN
        SELECT
			HD.maHoaDon,
			NV.tenNV,
			KH.tenKH,
			HD.ngayLapHoaDon,
			
			SUM((CH.soLuong * SP.gia)) As TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS TongTien
		FROM
			HoaDon HD
			JOIN NhanVien NV ON HD.maNV = NV.maNV
			JOIN KhachHang KH ON HD.maKH = KH.maKH
			JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
			JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
			LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
		
        WHERE MONTH(HD.ngayLapHoaDon) = @Month AND YEAR(HD.ngayLapHoaDon) = @Year
        GROUP BY
			HD.maHoaDon, NV.tenNV, KH.tenKH, HD.ngayLapHoaDon;
    END
END;
GO
CREATE PROCEDURE TimNhaCungCap
    @maNhaCC varchar(50) = NULL,
    @tenNhaCC nvarchar(50) = NULL,
	@email varchar(50) = NULL,
    @soDienThoai varchar(12) = NULL,
    @trangThai INT = NULL
AS
BEGIN
    SELECT *
    FROM NhaCungCap
    WHERE 
        (@maNhaCC IS NULL OR maNhaCC LIKE '%'+@maNhaCC+'%')
        AND (@tenNhaCC IS NULL OR tenNhaCC LIKE '%'+@tenNhaCC+'%')
		 AND (@email IS NULL OR email LIKE '%'+@email+'%' )
        AND (@soDienThoai IS NULL OR soDienThoai LIKE '%'+@soDienThoai+'%' )
        AND (@trangThai IS NULL OR trangThai = @trangThai);
END;

GO
CREATE PROCEDURE TimNhanVien
    @maNhanVien varchar(50) = NULL,
    @tenNhanVien nvarchar(50) = NULL,
	@email varchar(50) = NULL,
    @soDienThoai varchar(12) = NULL,
	@gioiTinh nvarchar(5) = NULL,
	@chucVu nvarchar(20) = NULL,
    @trangThai nvarchar(50) = NULL
AS
BEGIN
    SELECT *
    FROM NhanVien
    WHERE 
        (@maNhanVien IS NULL OR maNV LIKE '%'+@maNhanVien+'%')
        AND (@tenNhanVien IS NULL OR tenNV LIKE '%'+@tenNhanVien+'%')
		 AND (@email IS NULL OR email LIKE '%'+@email+'%' )
        AND (@soDienThoai IS NULL OR soDienThoai LIKE '%'+@soDienThoai+'%' )
		 AND (@gioiTinh IS NULL OR gioiTinh LIKE '%'+@gioiTinh+'%' )
		 AND (@chucVu IS NULL OR chucVu LIKE '%'+@chucVu+'%' )
        AND (@trangThai IS NULL OR trangThai LIKE '%'+@trangThai+'%');
END;
GO


CREATE PROCEDURE PhanCa
    @MaNV varchar(50),
    @MaCaLamViec varchar(50),
    @Ngay date,
	@ThongBao int output
AS
BEGIN
    -- Kiểm tra xem nhân viên đã có ca làm việc trong ngày hôm đó hay chưa
    IF NOT EXISTS (SELECT * FROM LichLamViec WHERE maNV = @MaNV AND ngay = @Ngay)
    BEGIN
        -- Kiểm tra xem ca làm việc đã được phân cho nhân viên khác trong ngày đó hay chưa
        IF NOT EXISTS (SELECT * FROM LichLamViec WHERE maCaLamViec = @MaCaLamViec AND ngay = @Ngay)
        BEGIN
            -- Chưa có ca làm việc cho nhân viên và ca làm việc trong ngày đó
            -- Thêm thông tin phân ca làm việc mới
            INSERT INTO LichLamViec (maNV, maCaLamViec, ngay)
            VALUES (@MaNV, @MaCaLamViec, @Ngay);
           SET @ThongBao = 1
        END
        ELSE
        BEGIN
            SET @ThongBao = 2
        END
    END
    ELSE
    BEGIN
       SET @ThongBao = 3
    END
END;

GO


CREATE PROCEDURE TimSanPham
    @maSanPham VARCHAR(50) = NULL,
    @tenSanPham NVARCHAR(255) = NULL,
    @danhMuc NVARCHAR(255) = NULL,
    @trangThai INT = NULL,
    @gia FLOAT = NULL,
    @nhaXuatBan NVARCHAR(255) = NULL,
    @soTrang INT = NULL,
    @namXuatBan INT = NULL,
    @tacGia NVARCHAR(255) = NULL
AS
BEGIN
	SELECT
		[maSanPham],
		[tenSanPham],
		[danhMuc],
		[maNhaCC],
		[gia],
		[donViTinh],
		[soLuong],
		[tacGia],
		[soTrang],
		[namXuatBan],
		[nhaXuatBan],
		[hinhAnh],
		[trangThai],
		[moTa]
	FROM
		SanPham
	WHERE
		(@maSanPham IS NULL OR [maSanPham] LIKE '%'+@maSanPham+'%')
		AND (@tenSanPham IS NULL OR [tenSanPham] LIKE '%'+@tenSanPham+'%')
		AND ( @danhMuc IS NULL OR  danhMuc LIKE '%'+@danhMuc+'%' )
		AND (@trangThai IS NULL OR [trangThai] = @trangThai)
		AND (@gia IS NULL OR [gia] = @gia OR @gia = 0)
		AND (@nhaXuatBan IS NULL OR [nhaXuatBan] LIKE '%'+@nhaXuatBan+'%')
		AND (@soTrang IS NULL OR [soTrang] = @soTrang OR @soTrang = 0)
		AND (@namXuatBan IS NULL OR [namXuatBan] = @namXuatBan OR @namXuatBan = 0)
		AND (@tacGia IS NULL OR [tacGia] LIKE '%' + @tacGia + '%');
		

END;

GO
CREATE PROCEDURE [dbo].[DoanhThuNhanVienThangNam]
    @Option INT = NULL,
    @maNV VARCHAR(10) = NULL,
    @Month INT = NULL,
    @Year INT = NULL
AS
BEGIN
    IF (@Option = 0)
    BEGIN
        SELECT
            NV.maNV,
            NV.tenNV,
            COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
            SUM((CH.soLuong * SP.gia)) AS TongTien,
            SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
            SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
        FROM
            HoaDon HD
            JOIN NhanVien NV ON HD.maNV = NV.maNV
            JOIN KhachHang KH ON HD.maKH = KH.maKH
            JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
            JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
            LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
		WHERE NV.maNV LIKE '%' + @maNV + '%'
              AND ((@Month = 0 AND YEAR(HD.ngayLapHoaDon) = @Year)
               OR (MONTH(HD.ngayLapHoaDon) = @Month AND YEAR(HD.ngayLapHoaDon) = @Year))
        GROUP BY
            NV.maNV, NV.tenNV
    END;

    IF (@Option = 1)
    BEGIN
        -- Lấy top 5 doanh thu theo nhân viên và tháng năm, sắp xếp giảm dần
        SELECT TOP 5
            NV.maNV,
            NV.tenNV,
            COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
            SUM((CH.soLuong * SP.gia)) AS TongTien,
            SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
            SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
        FROM
            HoaDon HD
            JOIN NhanVien NV ON HD.maNV = NV.maNV
            JOIN KhachHang KH ON HD.maKH = KH.maKH
            JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
            JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
            LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
       	WHERE ((@Month = 0 AND YEAR(HD.ngayLapHoaDon) = @Year)
               OR (MONTH(HD.ngayLapHoaDon) = @Month AND YEAR(HD.ngayLapHoaDon) = @Year))
        GROUP BY
            NV.maNV, NV.tenNV
        ORDER BY ThanhTien DESC
    END;

    IF (@Option = 2)
    BEGIN
        -- Lấy top 5 doanh thu theo nhân viên và tháng năm, sắp xếp tăng dần
        SELECT TOP 5
            NV.maNV,
            NV.tenNV,
            COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
            SUM((CH.soLuong * SP.gia)) AS TongTien,
            SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
            SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
        FROM
            HoaDon HD
            JOIN NhanVien NV ON HD.maNV = NV.maNV
            JOIN KhachHang KH ON HD.maKH = KH.maKH
            JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
            JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
            LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
       WHERE ((@Month = 0 AND YEAR(HD.ngayLapHoaDon) = @Year)
               OR (MONTH(HD.ngayLapHoaDon) = @Month AND YEAR(HD.ngayLapHoaDon) = @Year))
        GROUP BY
            NV.maNV, NV.tenNV
        ORDER BY ThanhTien ASC
    END;
END;
GO
CREATE PROCEDURE [dbo].[DoanhThuNhanVienTuyChinh]
	@StartDate DATE = NULL,
    @EndDate DATE = NULL,
	@Option INT = NULL,
	@maNV varchar(10) = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		IF (@Option = 0)
		BEGIN 
			SELECT
			NV.maNV,
			NV.tenNV,
			COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
			SUM((CH.soLuong * SP.gia)) AS TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
       
			FROM
				HoaDon HD
				JOIN NhanVien NV ON HD.maNV = NV.maNV
				JOIN KhachHang KH ON HD.maKH = KH.maKH
				JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
				JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
				LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
			WHERE NV.maNV LIKE  '%'+@maNV+'%'
			GROUP BY
				NV.maNV, NV.tenNV
		END;
		IF (@Option = 1) 
		BEGIN
			SELECT
			TOP 5
			NV.maNV,
			NV.tenNV,
			COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
			SUM((CH.soLuong * SP.gia)) AS TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
			FROM
				HoaDon HD
				JOIN NhanVien NV ON HD.maNV = NV.maNV
				JOIN KhachHang KH ON HD.maKH = KH.maKH
				JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
				JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
				LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
			GROUP BY
				NV.maNV, NV.tenNV
			ORDER BY ThanhTien DESC
		END;
		IF (@Option = 2) 
		BEGIN
			SELECT
			TOP 5
			NV.maNV,
			NV.tenNV,
			COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
			SUM((CH.soLuong * SP.gia)) AS TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
			FROM
				HoaDon HD
				JOIN NhanVien NV ON HD.maNV = NV.maNV
				JOIN KhachHang KH ON HD.maKH = KH.maKH
				JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
				JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
				LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
			GROUP BY
				NV.maNV, NV.tenNV
			ORDER BY ThanhTien ASC
		END;
	END;
		--Trường hợp có ngày tháng năm đầ đủ
	ELSE
	BEGIN
		IF (@Option = 0)
		BEGIN 
			SELECT
			NV.maNV,
			NV.tenNV,
			COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
			SUM((CH.soLuong * SP.gia)) AS TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
      
			FROM
				HoaDon HD
				JOIN NhanVien NV ON HD.maNV = NV.maNV
				JOIN KhachHang KH ON HD.maKH = KH.maKH
				JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
				JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
				LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
			WHERE NV.maNV LIKE  '%'+@maNV+'%' and (HD.ngayLapHoaDon BETWEEN @StartDate AND @EndDate)
			GROUP BY
				NV.maNV, NV.tenNV
		END;
		IF (@Option = 1) 
		BEGIN
			SELECT
			TOP 5
			NV.maNV,
			NV.tenNV,
			COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
			SUM((CH.soLuong * SP.gia)) AS TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
			FROM
				HoaDon HD
				JOIN NhanVien NV ON HD.maNV = NV.maNV
				JOIN KhachHang KH ON HD.maKH = KH.maKH
				JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
				JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
				LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
			WHERE (HD.ngayLapHoaDon BETWEEN @StartDate AND @EndDate)
			GROUP BY
				NV.maNV, NV.tenNV
			ORDER BY ThanhTien DESC
		END;
		IF (@Option = 2) 
		BEGIN
			SELECT
			TOP 5
			NV.maNV,
			NV.tenNV,
			COUNT(DISTINCT HD.maHoaDon) AS soDonHang,
			SUM((CH.soLuong * SP.gia)) AS TongTien,
			SUM((CH.soLuong * SP.gia) * COALESCE(KM.phanTramKhuyenMai / 100, 0)) AS GiamGia,
			SUM((CH.soLuong * SP.gia) * COALESCE(1 - KM.phanTramKhuyenMai / 100, 1)) AS ThanhTien
			FROM
				HoaDon HD
				JOIN NhanVien NV ON HD.maNV = NV.maNV
				JOIN KhachHang KH ON HD.maKH = KH.maKH
				JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon
				JOIN SanPham SP ON CH.maSanPham = SP.maSanPham
				LEFT JOIN KhuyenMai KM ON HD.maKhuyenMai = KM.maKhuyenMai
			WHERE (HD.ngayLapHoaDon BETWEEN @StartDate AND @EndDate)
			GROUP BY
				NV.maNV, NV.tenNV
			ORDER BY ThanhTien ASC
		END;
	END;
END;
GO
CREATE PROCEDURE [dbo].[CheckPhanCa]
    @MaNV varchar(50),
    @MaCaLamViec varchar(50),
    @Ngay date,
	@ThongBao int output
AS
BEGIN
    -- Kiểm tra xem nhân viên đã có ca làm việc trong ngày hôm đó hay chưa
    IF NOT EXISTS (SELECT * FROM LichLamViec WHERE maNV = @MaNV AND ngay = @Ngay)
    BEGIN
        -- Kiểm tra xem ca làm việc đã được phân cho nhân viên khác trong ngày đó hay chưa
        IF NOT EXISTS (SELECT * FROM LichLamViec WHERE maCaLamViec = @MaCaLamViec AND ngay = @Ngay)
        BEGIN
           SET @ThongBao = 1
        END
        ELSE
        BEGIN
            SET @ThongBao = 2
        END
    END
    ELSE
    BEGIN
       SET @ThongBao = 3
    END
END;

-------------------------------------------------------------------------------------------------------------------san pham da ban
GO
CREATE PROCEDURE SanPhamTuyChinh
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS DoanhThu
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
	END;
	ELSE
	BEGIN
	   SELECT  SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
	   FROM SanPham
	   JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
	   JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
	   WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
	   GROUP BY SanPham.maSanPham, SanPham.tenSanPham
	END;
END;

GO
CREATE PROCEDURE SanPhamThangNam
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
	   SELECT SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
	   FROM SanPham
	   JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
	   JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
	   WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
	   GROUP BY SanPham.maSanPham, SanPham.tenSanPham
	   
    END
    ELSE
    BEGIN
	   SELECT SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
	   FROM SanPham
	   JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
	   JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
	   WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
	   GROUP BY SanPham.maSanPham, SanPham.tenSanPham
    END
END;

---------------------------------------------------------------------------------------------------------------------- top 5 san pham ban chay
GO
CREATE PROCEDURE SanPhamTuyChinhBanNhieu
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan DESC;
	END;
	ELSE
	BEGIN
	    SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan DESC;
	END;
END;

GO
CREATE PROCEDURE SanPhamThangNamBanNhieu
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
		 SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan DESC;
    END
    ELSE
    BEGIN
		 SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan DESC;
    END
END;

--------------------------------------------------------------------------------------------------------------------------- top 5 san pham ban it
GO
CREATE PROCEDURE SanPhamTuyChinhBanIt
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan ASC;
	END;
	ELSE
	BEGIN
	    SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan ASC;
	END;
END;

GO
CREATE PROCEDURE SanPhamThangNamBanIt
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
		 SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan ASC;
    END
    ELSE
    BEGIN
		 SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY TongSoLuongBan ASC;
    END
END;

--------------------------------------------------------------------------------------------------------------------------- top 5 san pham co doanh thu cao nhat
GO
CREATE PROCEDURE SanPhamTuyChinhDoanhThuNhieu
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien DESC;
	END;
	ELSE
	BEGIN
	    SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien DESC;
	END;
END;

GO
CREATE PROCEDURE SanPhamThangNamDoanhThuNhieu
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien DESC;

    END
    ELSE
    BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien DESC;
    END
END;

--------------------------------------------------------------------------------------------------------------------------- top 5 san pham co doanh thu it nhat
GO
CREATE PROCEDURE SanPhamTuyChinhDoanhThuIt
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
        SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
        SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien ASC;
	END;
	ELSE
	BEGIN
	    SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien ASC;
	END;
END;

GO
CREATE PROCEDURE SanPhamThangNamDoanhThuIt
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien ASC;

    END
    ELSE
    BEGIN
		SELECT TOP 5 SanPham.maSanPham, SanPham.tenSanPham, 
       SUM(ChiTietHoaDon.soLuong) AS TongSoLuongBan, 
       SUM(ChiTietHoaDon.soLuong * SanPham.gia) AS ThanhTien
		FROM SanPham
		JOIN ChiTietHoaDon ON SanPham.maSanPham = ChiTietHoaDon.maSanPham
		JOIN HoaDon ON ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
		GROUP BY SanPham.maSanPham, SanPham.tenSanPham
		ORDER BY ThanhTien ASC;
    END
END;

-------------------------------------------------------------------------------------------------------------------khách hàng đã mua hàng
GO
CREATE PROCEDURE KhachHangTuyChinh
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT 
    KhachHang.maKH, 
    KhachHang.tenKH, 
    KhachHang.soDienThoai, 
    KhachHang.gioiTinh, 
    KhachHang.ngayDangKy,
    COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
    SUM(
        CASE
            WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
            ELSE
                chiTietTongTien.TongTien
        END
    ) AS tongTien,
    SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham -- Đây là cột số lượng sản phẩm
FROM KhachHang
JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
LEFT JOIN (
    SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
    FROM ChiTietHoaDon
    GROUP BY ChiTietHoaDon.maHoaDon
) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy;

	END;
	ELSE
	BEGIN
	   SELECT 
    KhachHang.maKH, 
    KhachHang.tenKH, 
    KhachHang.soDienThoai, 
    KhachHang.gioiTinh, 
    KhachHang.ngayDangKy,
    COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
    SUM(
        CASE
            WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
            ELSE
                chiTietTongTien.TongTien
        END
    ) AS tongTien,
    SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham -- Đây là cột số lượng sản phẩm
FROM KhachHang
JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
LEFT JOIN (
    SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
    FROM ChiTietHoaDon
    GROUP BY ChiTietHoaDon.maHoaDon
) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy;
	END;
END;

GO
CREATE PROCEDURE KhachHangThangNam
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN

		SELECT 
    KhachHang.maKH, 
    KhachHang.tenKH, 
    KhachHang.soDienThoai, 
    KhachHang.gioiTinh, 
    KhachHang.ngayDangKy,
    COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
    SUM(
        CASE
            WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
            ELSE
                chiTietTongTien.TongTien
        END
    ) AS tongTien,
    SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham -- Đây là cột số lượng sản phẩm
FROM KhachHang
JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
LEFT JOIN (
    SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
    FROM ChiTietHoaDon
    GROUP BY ChiTietHoaDon.maHoaDon
) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy;
	   
    END
    ELSE
    BEGIN
	   SELECT 
    KhachHang.maKH, 
    KhachHang.tenKH, 
    KhachHang.soDienThoai, 
    KhachHang.gioiTinh, 
    KhachHang.ngayDangKy,
    COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
    SUM(
        CASE
            WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
            ELSE
                chiTietTongTien.TongTien
        END
    ) AS tongTien,
    SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham -- Đây là cột số lượng sản phẩm
FROM KhachHang
JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
LEFT JOIN (
    SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
    FROM ChiTietHoaDon
    GROUP BY ChiTietHoaDon.maHoaDon
) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy;	   
    END
END;

---------------------------------------------------------------------------------------------------------------------- Top 5 khách hàng tổng chi cao nhất
GO
CREATE PROCEDURE KhachHangTuyChinhTongChiCaoNhat
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien DESC; 
	   
	END;
	ELSE
	BEGIN
	   SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien DESC; 
	END;
END;

GO
CREATE PROCEDURE KhachHangThangNamTongChiCaoNhat
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
	SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien DESC;
    END
    ELSE
    BEGIN
	 SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien DESC; 
    END
END;

---------------------------------------------------------------------------------------------------------------------- Top 5 khách hàng tổng chi thấp nhất
GO
CREATE PROCEDURE KhachHangTuyChinhTongChiThapNhat
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien ASC; 
	END;
	ELSE
	BEGIN
	   SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien ASC; 
	END;
END;

GO
CREATE PROCEDURE KhachHangThangNamTongChiThapNhat
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
	SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien ASC;
    END
    ELSE
    BEGIN
	 SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY tongTien ASC; 
    END
END;
---------------------------------------------------------------------------------------------------------------------- Top 5 khách hàng mua hàng nhiều nhất
GO
CREATE PROCEDURE KhachHangTuyChinhMuaHangNhieuNhat
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) DESC; 
	   
	END;
	ELSE
	BEGIN
	   SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) DESC; 
	END;
END;

GO
CREATE PROCEDURE KhachHangThangNamMuaHangNhieuNhat
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
	SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) DESC; 
    END
    ELSE
    BEGIN
	 SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) DESC;  
    END
END;

---------------------------------------------------------------------------------------------------------------------- Top 5 khách hàng mua hàng  ít nhất
GO
CREATE PROCEDURE KhachHangTuyChinhMuaHangItNhat
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) ASC; 
	END;
	ELSE
	BEGIN
	   SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) ASC; 
	END;
END;

GO
CREATE PROCEDURE KhachHangThangNamMuaHangItNhat
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
	SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) ASC; 
    END
    ELSE
    BEGIN
	 SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY SUM(chiTietTongTien.TongSoLuong) ASC;  
    END
END;
---------------------------------------------------------------------------------------------------------------------- Top 5 khách hàng thường xuyên mua hàng nhất
GO
CREATE PROCEDURE KhachHangTuyChinhThuongXuyenMuaHang
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang DESC; 
	END;
	ELSE
	BEGIN
	   SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang DESC; 
	END;
END;

GO
CREATE PROCEDURE KhachHangThangNamThuongXuyenMuaHang
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
	SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang DESC; 
    END
    ELSE
    BEGIN
	 SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang DESC;  
    END
END;
---------------------------------------------------------------------------------------------------------------------- Top 5 khách hàng không thường xuyên mua hàng nhất
GO
CREATE PROCEDURE KhachHangTuyChinhKhongThuongXuyenMuaHang
	@StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
	IF (@StartDate IS NULL OR @EndDate IS NULL )
	BEGIN
		SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang ASC; 
	END;
	ELSE
	BEGIN
	   SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE HoaDon.ngayLapHoaDon BETWEEN @StartDate AND @EndDate
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang ASC; 
	END;
END;

GO
CREATE PROCEDURE KhachHangThangNamKhongThuongXuyenMuaHang
    @Month int,
    @Year int
AS
BEGIN
    IF @Month = 0
    BEGIN
	SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE YEAR(HoaDon.ngayLapHoaDon ) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang ASC;  
    END
    ELSE
    BEGIN
	 SELECT TOP 5 
            KhachHang.maKH, 
            KhachHang.tenKH, 
            KhachHang.soDienThoai, 
            KhachHang.gioiTinh, 
            KhachHang.ngayDangKy,
            COUNT(DISTINCT HoaDon.maHoaDon) AS soLuongDonHang, 
            SUM(
                CASE
                    WHEN HoaDon.maKhuyenMai IS NOT NULL THEN
                        chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0)
                    ELSE
                        chiTietTongTien.TongTien
                END
            ) AS tongTien,
            SUM(chiTietTongTien.TongSoLuong) AS tongSoLuongSanPham
        FROM KhachHang
        JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH
        LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai
        LEFT JOIN (
            SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien, SUM(soLuong) AS TongSoLuong
            FROM ChiTietHoaDon
            GROUP BY ChiTietHoaDon.maHoaDon
        ) chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon
		WHERE MONTH(HoaDon.ngayLapHoaDon) = @Month AND YEAR(HoaDon.ngayLapHoaDon) = @Year
        GROUP BY KhachHang.maKH, KhachHang.tenKH, KhachHang.soDienThoai, KhachHang.gioiTinh, KhachHang.ngayDangKy
        ORDER BY soLuongDonHang ASC;  
    END
END;
GO
GO
CREATE PROCEDURE TimKhachHang
    @maKH varchar(50) = NULL,
	@tenKH nvarchar(255) = NULL,
	@email varchar(50) = NULL,
	@soDienThoai varchar(12) = NULL,
	@gioiTinh nvarchar(10) =  NULL,
	@theVip nvarchar(30) = NULL

AS
BEGIN
    SELECT *
    FROM [dbo].[KhachHang]
    WHERE 
        (@maKH IS NULL OR maKH LIKE '%'+@maKH+'%')
        AND (@tenKH IS NULL OR tenKH LIKE '%'+@tenKH+'%')
		 AND (@email IS NULL OR email LIKE '%'+@email+'%' )
        AND (@soDienThoai IS NULL OR soDienThoai LIKE '%'+@soDienThoai+'%' )
		AND (@gioiTinh IS NULL OR gioiTinh LIKE '%'+@gioiTinh+'%' )
		AND (@theVip IS NULL OR theVip LIKE '%'+@theVip+'%' );
END;
