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

CREATE TABLE LichLamViec
(
	maLichLamViec varchar(50) PRIMARY KEY,
	caLamViec varchar(10) NULL,
	ngay date NULL,
) 
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

CREATE TABLE TaiKhoan
(
	maTK varchar(50) PRIMARY KEY,
	tenDangNhap varchar(100) NULL,
	matKhau varchar(255) NULL,
	quyen varchar(50) NULL,
	trangThaiTaiKhoan nvarchar(50) NULL,
)
GO

CREATE TABLE NhanVien
(
	maNV varchar(50) PRIMARY KEY,
	tenNV nvarchar(255) NULL,
	soDienThoai varchar(12) NULL,
	email varchar(50) NULL,
	ngaySinh date NULL,
	maLichLamViec varchar(50) NULL,
	maTK varchar(50) NULL,
	diaChi nvarchar(255) NULL,
	gioiTinh nvarchar(10) NULL,
	chucVu nvarchar(50) NULL,
	trangThai nvarchar(50) NULL,

	CONSTRAINT FK_TaiKhoan_NhanVien FOREIGN KEY (maTK) REFERENCES TaiKhoan(maTK),
	CONSTRAINT FK_LichLamViec_NhanVien FOREIGN KEY (maLichLamViec) REFERENCES LichLamViec(maLichLamViec)
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
	loaiHoaDon nvarchar(50) NULL,
	trangThai nvarchar(50) NULL,
	ghiChu nvarchar(255) NULL

	
	CONSTRAINT FK_KhachHang_HoaDon FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
	CONSTRAINT FK_NhanVien_HoaDon FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
	CONSTRAINT FK_KhuyenMai_HoaDon FOREIGN KEY (maKhuyenMai) REFERENCES KhuyenMai(maKhuyenMai)

)
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
       ('9786049201417', N'Phương pháp luận Nghiên cứu Khoa học',          N'Sách',       'NCC002', 35000, N'Quyển', 200, N'Giáo trình', N'Nguyễn Thị Thu Trang', 194, 2021, N'Đại Học Công Nghiệp TPHCM', ' ', 0),
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

INSERT INTO LichLamViec (maLichLamViec, caLamViec, ngay)
VALUES ('LLV001', N'Ca sáng', '2023-10-11'),
       ('LLV002', N'Ca chiều', '2023-10-12');
GO

INSERT INTO KhuyenMai (maKhuyenMai, tenChuongTrinh, phanTramKhuyenMai, ngayBatDau, ngayKetThuc, moTa)
VALUES ('KM001', N'Khuyến mãi A', 10, '2023-10-11', '2023-10-20', N'Khuyến mãi đầu thu'),
	   ('KM002', N'Khuyến mãi B', 15, '2023-10-14', '2023-10-23', N'Khuyến mãi cuối thu'),
	   ('KM003', N'Khuyến mãi C', 20, '2023-10-15', '2023-10-24', N'Khuyến mãi cuối năm'),
	   ('KM004', N'Khuyến mãi D', 12, '2023-10-16', '2023-10-25', N'Khuyến mãi đầu năm');
GO

INSERT INTO KhachHang (maKH, tenKH, soDienThoai, email, ngaySinh, diaChi, gioiTinh, theVip, ngayDangKy)
VALUES ('KH001', N'Khách hàng 1', '123456789', 'kh1@example.com', '1990-01-01', N'Địa chỉ khách hàng 1', N'Nam',N'Đồng','2000-01-01'),
       ('KH002', N'Khách hàng 2', '987654321', 'kh2@example.com', '1995-03-15', N'Địa chỉ khách hàng 2', N'Nữ',N'Bạc','2003-01-01'),
	   ('KH003', N'Khách hàng 3', '123456789', 'kh3@example.com', '1992-05-10', N'Địa chỉ khách hàng 3', N'Nam',N'Vàng','2006-01-01'),
	   ('KH004', N'Khách hàng 4', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ',N'Kim cương','1990-01-01'),
	   ('KH005', N'Khách hàng 5', '555555555', 'kh5@example.com', '1997-08-21', N'Địa chỉ khách hàng 5', N'Nam',N'Ruby','1990-01-01');
GO

INSERT INTO TaiKhoan (maTK, tenDangNhap, matKhau, quyen, trangThaiTaiKhoan)
VALUES ('TK001', 'NV001', 'anhyeuem', N'User', N'Đang hoạt động'),
       ('TK002', 'NV002', 'emtheodaigia', N'User', N'Tạm khóa'),
	   ('TK003', 'NV003', '3rdAccount', N'User', N'Đang hoạt động'),
	   ('TK004', 'NV004', '4thAccount', N'User', N'Đang hoạt động'),
	   ('TK005', 'NV005', '5thAccount', N'User', N'Đang hoạt động');
GO

INSERT INTO NhanVien (maNV, tenNV, soDienThoai, email, ngaySinh, maLichLamViec, maTK, diaChi, gioiTinh, chucVu, trangThai)
VALUES ('NV001', N'Nhân viên 1', '123456789', 'nv1@example.com', '1990-02-15', 'LLV001', 'TK001', N'Địa chỉ NV1', N'Nam', N'Nhân viên bán hàng', N'Active'),
       ('NV002', N'Nhân viên 2', '987654321', 'nv2@example.com', '1995-05-20', 'LLV002', 'TK002', N'Địa chỉ NV2', N'Nữ', N'Nhân viên bán hàng', N'Active'),
	   ('NV003', N'Nhân viên 3', '123456789', 'nv3@example.com', '1992-07-20', 'LLV001', 'TK003', N'Địa chỉ NV3', N'Nam', N'Nhân viên bán hàng', N'Active'),
	   ('NV004', N'Nhân viên 4', '987654321', 'nv4@example.com', '1988-10-15', 'LLV002', 'TK004', N'Địa chỉ NV4', N'Nữ', N'Nhân viên bán hàng', N'Active'),
   	   ('NV005', N'Nhân viên 5', '555555555', 'nv5@example.com', '1997-12-25', 'LLV001', 'TK005', N'Địa chỉ NV5', N'Nam', N'Nhân viên bán hàng', N'Active');
GO

INSERT INTO HoaDon (maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon, loaiHoaDon, trangThai, ghiChu)
VALUES ('HD001', 'KH001', 'NV001', 'KM001', N'Tiền mặt', '2023-10-11', N'Bán hàng', N'Đã thanh toán', ''),
       ('HD002', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2023-10-12', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD003', 'KH003', 'NV003', 'KM002', N'Tiền mặt', '2023-10-16', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD004', 'KH004', 'NV004', 'KM003', N'Thẻ tín dụng', '2023-10-17', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD005', 'KH005', 'NV005', 'KM004', N'Tiền mặt', '2023-10-18', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD006', 'KH001', 'NV001', 'KM001', N'Tiền mặt', '2021-01-19', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD007', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2021-02-20', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD008', 'KH003', 'NV003', NULL, N'Tiền mặt', '2021-03-21', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD009', 'KH004', 'NV004', 'KM002', N'Thẻ tín dụng', '2021-04-22', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD010', 'KH005', 'NV005', 'KM003', N'Tiền mặt', '2021-05-23', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD011', 'KH001', 'NV001', 'KM004', N'Tiền mặt', '2022-06-19', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD012', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2022-07-20', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD013', 'KH003', 'NV003', NULL, N'Tiền mặt', '2022-08-21', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD014', 'KH004', 'NV004', 'KM001', N'Thẻ tín dụng', '2022-09-22', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD015', 'KH005', 'NV005', 'KM002', N'Tiền mặt', '2022-10-23', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD016', 'KH001', 'NV001', 'KM004', N'Tiền mặt', '2023-05-10', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD017', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2023-06-15', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD018', 'KH003', 'NV003', NULL, N'Tiền mặt', '2023-07-20', N'Bán hàng', N'Đã thanh toán', ''),
	   ('HD019', 'KH004', 'NV004', 'KM001', N'Thẻ tín dụng', '2023-08-25', N'Đặt hàng', N'Đã thanh toán', ''),
	   ('HD020', 'KH005', 'NV005', 'KM002', N'Tiền mặt', '2023-09-30', N'Bán hàng', N'Chờ thanh toán', ''),
	   ('HD021', 'KH001', 'NV001', 'KM003', N'Thẻ tín dụng', '2023-10-05', N'Đặt hàng', N'Đang giao', '');	   
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

('HD020', '8935002913231', 20, 196000);

GO

