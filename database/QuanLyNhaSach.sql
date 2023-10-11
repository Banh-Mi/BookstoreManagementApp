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
       ('NCC002', N'Công ty B', 1, N'Địa chỉ B', 'emailb@example.com', '987654321', N'Người B');
GO

INSERT INTO SanPham (maSanPham, tenSanPham, danhMuc, maNhaCC, gia, donViTinh, soLuong, moTa, tacGia, soTrang, namXuatBan, nhaXuatBan)
VALUES ('9781234567890', N'Sách 1', N'Danh mục 1', 'NCC001', 25.99, N'Quyển', 100, N'Sách số 1', N'Tác giả A', 200, 2022, N'NXB A'),
       ('9786049201417', N'SPhương pháp luận Nghiên cứu Khoa học', N'Sách', 'NCC002', 35000.00, N'Quyển', 200, N'Sách số 2', N'Nguyễn Thị Thu Trang', 194, 2021, N'Đại Học Công Nghiệp TPHCM');
GO   

INSERT INTO LichLamViec (maLichLamViec, caLamViec, ngay)
VALUES ('LLV001', N'Ca sáng', '2023-10-11'),
       ('LLV002', N'Ca chiều', '2023-10-12');
GO

INSERT INTO KhuyenMai (maKhuyenMai, tenChuongTrinh, phanTramKhuyenMai, ngayBatDau, ngayKetThuc, moTa)
VALUES ('KM001', N'Khuyến mãi A', 10, '2023-10-11', '2023-10-20', N'Khuyến mãi đầu thu');
GO

INSERT INTO KhachHang (maKH, tenKH, soDienThoai, email, ngaySinh, diaChi, gioiTinh)
VALUES ('KH001', N'Khách hàng 1', '123456789', 'kh1@example.com', '1990-01-01', N'Địa chỉ khách hàng 1', N'Nam'),
       ('KH002', N'Khách hàng 2', '987654321', 'kh2@example.com', '1995-03-15', N'Địa chỉ khách hàng 2', N'Nữ');
GO

INSERT INTO TaiKhoan (maTK, tenDangNhap, matKhau, quyen, trangThaiTaiKhoan)
VALUES ('TK001', 'NV001', 'anhyeuem', N'User', N'Đang hoạt động'),
       ('TK002', 'NV002', 'emtheodaigia', N'User', N'Tạm khóa');
GO

INSERT INTO NhanVien (maNV, tenNV, soDienThoai, email, ngaySinh, maLichLamViec, maTK, diaChi, gioiTinh, chucVu, trangThai)
VALUES ('NV001', N'Nhân viên 1', '123456789', 'nv1@example.com', '1990-02-15', 'LLV001', 'TK001', N'Địa chỉ NV1', N'Nam', N'Nhân viên bán hàng', N'Active'),
       ('NV002', N'Nhân viên 2', '987654321', 'nv2@example.com', '1995-05-20', 'LLV002', 'TK002', N'Địa chỉ NV2', N'Nữ', N'Nhân viên bán hàng', N'Active');
GO

INSERT INTO HoaDon (maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon)
VALUES ('HD001', 'KH001', 'NV001', 'KM001', N'Tiền mặt', '2023-10-11'),
       ('HD002', 'KH002', 'NV002', NULL, N'Thẻ tín dụng', '2023-10-12');
GO

INSERT INTO ChiTietHoaDon (maHoaDon, maSanPham, soLuong, gia)
VALUES ('HD001', '9781234567890', 2, 25.99),
       ('HD001', '9786049201417', 1, 19.99),
       ('HD002', '9786049201417', 3, 40000);
GO