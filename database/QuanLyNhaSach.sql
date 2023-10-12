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
	moTa nvarchar(255) NULL,
	tacGia nvarchar(50) NULL,
	soTrang int NULL,
	namXuatBan int NULL,
	nhaXuatBan nvarchar(100) NULL,

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

INSERT INTO SanPham (maSanPham, tenSanPham, danhMuc, maNhaCC, gia, donViTinh, soLuong, moTa, tacGia, soTrang, namXuatBan, nhaXuatBan)
VALUES ('9781234567890', N'Sách 1', N'Danh mục 1', 'NCC001', 25.99, N'Quyển', 100, N'Sách số 1', N'Tác giả A', 200, 2022, N'NXB A'),
       ('9786049201417', N'SPhương pháp luận Nghiên cứu Khoa học', N'Sách', 'NCC002', 35000.00, N'Quyển', 200, N'Sách số 2', N'Nguyễn Thị Thu Trang', 194, 2021, N'Đại Học Công Nghiệp TPHCM'),
	   ('9781234567891', N'Harry Potter and the Sorcerer''s Stone', N'Sách', 'NCC001', 29.99, N'Quyển', 50, N'Harry Potter series - Book 1', N'J.K. Rowling', 320, 1997, N'Scholastic'),
	   ('9786049201418', N'Lord of the Rings: The Fellowship of the Ring', N'Sách', 'NCC002', 42.00, N'Quyển', 100, N'Lord of the Rings series - Book 1', N'J.R.R. Tolkien', 432, 1954, N'Houghton Mifflin Harcourt'),
	   ('9781234567892', N'To Kill a Mockingbird', N'Sách', 'NCC003', 35.99, N'Quyển', 70, N'Classic American Novel', N'Harper Lee', 281, 1960, N'J.B. Lippincott & Co.'),
	   ('9786049201419', N'The Great Gatsby', N'Sách', 'NCC004', 48.00, N'Quyển', 90, N'F. Scott Fitzgerald''s Masterpiece', N'F. Scott Fitzgerald', 218, 1925, N'Scribner'),
	   ('9781234567893', N'Pride and Prejudice', N'Sách', 'NCC005', 45.99, N'Quyển', 60, N'Classic English Literature', N'Jane Austen', 432, 1813, N'T. Egerton'),
	   ('9786049201420', N'1984', N'Sách', 'NCC001', 55.00, N'Quyển', 110, N'Dystopian Novel', N'George Orwell', 328, 1949, N'Secker and Warburg');
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

INSERT INTO KhachHang (maKH, tenKH, soDienThoai, email, ngaySinh, diaChi, gioiTinh)
VALUES ('KH001', N'Khách hàng 1', '123456789', 'kh1@example.com', '1990-01-01', N'Địa chỉ khách hàng 1', N'Nam'),
       ('KH002', N'Khách hàng 2', '987654321', 'kh2@example.com', '1995-03-15', N'Địa chỉ khách hàng 2', N'Nữ'),
	   ('KH003', N'Khách hàng 3', '123456789', 'kh3@example.com', '1992-05-10', N'Địa chỉ khách hàng 3', N'Nam'),
	   ('KH004', N'Khách hàng 4', '987654321', 'kh4@example.com', '1988-03-18', N'Địa chỉ khách hàng 4', N'Nữ'),
	   ('KH005', N'Khách hàng 5', '555555555', 'kh5@example.com', '1997-08-21', N'Địa chỉ khách hàng 5', N'Nam');
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

INSERT INTO HoaDon (maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon)
VALUES ('HD001', 'KH001', 'NV001', 'KM001', N'Tiền mặt', '2023-10-11'),
       ('HD002', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2023-10-12'),
	   ('HD003', 'KH003', 'NV003', 'KM002', N'Tiền mặt', '2023-10-16'),
	   ('HD004', 'KH004', 'NV004', 'KM003', N'Thẻ tín dụng', '2023-10-17'),
	   ('HD005', 'KH005', 'NV005', 'KM004', N'Tiền mặt', '2023-10-18'),
	   ('HD006', 'KH001', 'NV001', 'KM001', N'Tiền mặt', '2021-01-19'),
	   ('HD007', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2021-02-20'),
	   ('HD008', 'KH003', 'NV003', NULL, N'Tiền mặt', '2021-03-21'),
	   ('HD009', 'KH004', 'NV004', 'KM002', N'Thẻ tín dụng', '2021-04-22'),
	   ('HD010', 'KH005', 'NV005', 'KM003', N'Tiền mặt', '2021-05-23'),
	   ('HD011', 'KH001', 'NV001', 'KM004', N'Tiền mặt', '2022-06-19'),
	   ('HD012', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2022-07-20'),
	   ('HD013', 'KH003', 'NV003', NULL, N'Tiền mặt', '2022-08-21'),
	   ('HD014', 'KH004', 'NV004', 'KM001', N'Thẻ tín dụng', '2022-09-22'),
	   ('HD015', 'KH005', 'NV005', 'KM002', N'Tiền mặt', '2022-10-23'),
	   ('HD016', 'KH001', 'NV001', 'KM004', N'Tiền mặt', '2023-05-10'),
	   ('HD017', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2023-06-15'),
	   ('HD018', 'KH003', 'NV003', NULL, N'Tiền mặt', '2023-07-20'),
	   ('HD019', 'KH004', 'NV004', 'KM001', N'Thẻ tín dụng', '2023-08-25'),
	   ('HD020', 'KH005', 'NV005', 'KM002', N'Tiền mặt', '2023-09-30'),
	   ('HD021', 'KH001', 'NV001', 'KM003', N'Thẻ tín dụng', '2023-10-05'),
	   ('HD022', 'KH002', 'NV002', 'KM004', N'Thẻ tín dụng', '2023-11-04'),
	   ('HD023', 'KH003', 'NV003', NULL, N'Tiền mặt', '2023-11-05'),
	   ('HD024', 'KH004', 'NV004', 'KM001', N'Thẻ tín dụng', '2023-11-06'),
	   ('HD025', 'KH005', 'NV005', 'KM002', N'Tiền mặt', '2023-11-07');
GO

INSERT INTO ChiTietHoaDon (maHoaDon, maSanPham, soLuong, gia)
VALUES ('HD001', '9781234567890', 2, 25.99),
       ('HD001', '9786049201417', 1, 19.99),
       ('HD002', '9786049201417', 3, 40000),
	   ('HD006', '9781234567890', 2, 25.99),
('HD006', '9786049201417', 1, 19.99),
('HD006', '9781234567891', 1, 29.99),
('HD006', '9786049201418', 2, 42.00),
('HD006', '9781234567892', 3, 35.99),
('HD006', '9786049201419', 4, 48.00),
('HD006', '9781234567893', 1, 45.99),
('HD006', '9786049201420', 2, 55.00),
('HD007', '9781234567890', 3, 25.99),
('HD007', '9786049201417', 2, 19.99),
('HD007', '9781234567891', 2, 29.99),
('HD007', '9786049201418', 3, 42.00),
('HD007', '9781234567892', 1, 35.99),
('HD007', '9786049201419', 4, 48.00),
('HD007', '9781234567893', 3, 45.99),
('HD008', '9781234567890', 1, 25.99),
('HD008', '9786049201417', 4, 19.99),
('HD008', '9781234567891', 3, 29.99),
('HD008', '9786049201418', 2, 42.00),
('HD008', '9781234567892', 4, 35.99),
('HD008', '9786049201419', 2, 48.00),
('HD009', '9781234567890', 2, 25.99),
('HD009', '9786049201417', 1, 19.99),
('HD009', '9781234567891', 2, 29.99),
('HD009', '9786049201418', 3, 42.00),
('HD009', '9781234567892', 3, 35.99),
('HD010', '9781234567890', 4, 25.99),
('HD010', '9786049201417', 2, 19.99),
('HD010', '9781234567891', 1, 29.99),
('HD010', '9786049201418', 4, 42.00),
('HD011', '9781234567890', 1, 25.99),
('HD011', '9786049201417', 3, 19.99),
('HD011', '9781234567891', 4, 29.99),
('HD011', '9786049201418', 2, 42.00),
('HD011', '9781234567892', 3, 35.99),
('HD011', '9786049201419', 1, 48.00),
('HD012', '9781234567890', 2, 25.99),
('HD012', '9786049201417', 1, 19.99),
('HD012', '9781234567891', 2, 29.99),
('HD012', '9786049201418', 3, 42.00),
('HD013', '9781234567890', 1, 25.99),
('HD013', '9786049201417', 4, 19.99),
('HD013', '9781234567891', 2, 29.99),
('HD014', '9781234567890', 4, 25.99),
('HD014', '9786049201417', 3, 19.99),
('HD015', '9781234567890', 2, 25.99),
('HD016', '9786049201418', 5, 42.00),
('HD016', '9781234567892', 3, 35.99),
('HD016', '9786049201419', 2, 48.00),
('HD017', '9786049201420', 1, 55.00),
('HD017', '9781234567893', 4, 45.99),
('HD017', '9786049201417', 2, 19.99),
('HD018', '9781234567892', 3, 35.99),
('HD018', '9786049201419', 2, 48.00),
('HD019', '9781234567892', 4, 35.99),
('HD019', '9786049201420', 1, 55.00),
('HD019', '9781234567893', 2, 45.99),
('HD020', '9786049201418', 2, 42.00),
('HD020', '9781234567890', 1, 25.99),
('HD020', '9786049201417', 3, 19.99),
('HD021', '9781234567893', 1, 45.99),
('HD021', '9786049201420', 3, 55.00),
('HD021', '9781234567890', 2, 25.99),
('HD022', '9786049201419', 2, 48.00),
('HD022', '9781234567891', 4, 29.99),
('HD023', '9786049201418', 3, 42.00),
('HD023', '9781234567892', 2, 35.99),
('HD024', '9781234567891', 1, 29.99),
('HD024', '9786049201419', 4, 48.00);
GO