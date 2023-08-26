USE [master]
CREATE DATABASE BookStoreManagement;
GO

USE BookStoreManagement;
GO

-- Nhà cung cấp
CREATE TABLE Suppliers
(
	supplier_id VARCHAR(50) PRIMARY KEY,
	supplier_name NVARCHAR(100) NOT NULL,
	"address" NVARCHAR(255) NOT NULl,
	contact_person NVARCHAR(50) NOT NULL, -- Người liên hệ
	phone VARCHAR(20) NOT NULL,
	email NVARCHAR(50) NOT NULL,
	bank_account_information NVARCHAR(50) NULL -- Thông tin ngân hàng 
)
GO

-- Loại sản phẩm
CREATE TABLE ProductTypes
(
	product_type_id VARCHAR(50) PRIMARY KEY,
	product_type_name NVARCHAR(100) NOT NULL,
	"description" NVARCHAR(255) NULL
)
GO

-- Sản phẩm
CREATE TABLE Products
(
	product_id VARCHAR(50) PRIMARY KEY,
	product_name NVARCHAR(100) NOT NULL,
	product_type_id VARCHAR(50) NOT NULL,
	supplier_id VARCHAR(50) NOT NULL,
	quantity INT NOT NULL,
	unit NVARCHAR(50) NOT NULL, -- Đơn vị tính
	price FLOAT NOT NULL,
	"status" NVARCHAR(50) NULL, 
	image_link VARCHAR(255) NULL

	CONSTRAINT FK_SuppliersProducts FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id),
	CONSTRAINT FK_ProductsTypeProducts FOREIGN KEY (product_type_id) REFERENCES ProductTypes(product_type_id)
)
GO

-- Loại sách
CREATE TABLE Categories
(
	category_id VARCHAR(50) PRIMARY KEY,
	category_name NVARCHAR(100) NOT NULL,
	"description" NVARCHAR(255) NULL
)
GO

-- Tác giả
CREATE TABLE Authors
(
	author_id VARCHAR(50) PRIMARY KEY,
	author_name NVARCHAR(100) NOT NULL,
	date_of_birth DATE NULL,
	date_of_death DATE NULL,
	country NVARCHAR(50) NULL
)
GO

-- Sách
CREATE TABLE Books
(
	product_id VARCHAR(50) PRIMARY KEY,
	category_id VARCHAR(50) NOT NULL,
	author_id VARCHAR(50) NOT NULL,
	publisher NVARCHAR(50) NOT NULL,  -- Nhà xuất bản
	publication_year INT NOT NULL,
	page_count INT NOT NULL 

	CONSTRAINT FK_ProductBook FOREIGN KEY (product_id) REFERENCES Products (product_id),
	CONSTRAINT FK_CategoryBook FOREIGN KEY (category_id) REFERENCES Categories (category_id),
	CONSTRAINT FK_AuthorBook FOREIGN KEY (author_id) REFERENCES Authors (author_id)
)
GO

-- Tài khoản
CREATE TABLE Accounts(
    account_id VARCHAR(50) PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
	"role" NVARCHAR(100) NOT NULL, -- Quyền
    "status" BIT NOT NULL
)
GO

-- Nhân viên
CREATE TABLE Employees
(
	employee_id VARCHAR(50) PRIMARY KEY,
	fullName NVARCHAR(100) NOT NULL,
	gender NVARCHAR(20) NULL,
	email NVARCHAR(50) NOT NULL,
	"address" NVARCHAR(255) NOT NULL,
	account_id VARCHAR(50) NOT NULL,
	dayOfBirth DATE NOT NULL,
	phone VARCHAR(20) NOT NULL,
	position NVARCHAR(50) NOT NULL, -- Chức vụ
	hire_date DATE NOT NULL, -- Ngày vào làm
	"status" NVARCHAR(50) NULL

	CONSTRAINT FK_AccountsEmployees FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
)
GO

-- Ca làm việc
CREATE TABLE WorkShifts 
(
	shift_id VARCHAR(50) PRIMARY KEY,
	employee_id VARCHAR(50) NOT NULL,
	shift_date DATE NOT NULL, -- Ngày làm việc của ca
	start_time DATE NOT NULL, -- Thời gian bắt đầu ca làm việc
	end_time DATE NOT NULL,
	salary FLOAT NULL

	CONSTRAINT FK_EmployeesWorkShifts FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
)
GO

-- Khách hàng
CREATE TABLE Customers 
(
	customer_id VARCHAR(50) PRIMARY KEY,
	fullName NVARCHAR(100) NOT NULL,
	gender NVARCHAR(20) NOT NULL,
	email NVARCHAR(50) NOT NULL,
	"address" NVARCHAR(255) NULL,
	dayOfBirth DATE NOT NULL,
	phone VARCHAR(20) NOT NULL,
	country NVARCHAR(50) NOT NULL,
)
GO

-- Giảm giá
CREATE TABLE Discounts
(
    discount_id VARCHAR(50) PRIMARY KEY,
    "discount_name" NVARCHAR(255) NULL,
    discount_type NVARCHAR(50) NULL, -- Loại chương trình
	"start_date" DATE NOT NULL,
	"end_date" DATE NOT NULL,
	discount_percentage FLOAT NULL, -- Phần trăm giảm giá
	discount_amount FLOAT NULL -- Số tiền giảm giá
)
GO

-- Mua hàng (nhập hàng)
CREATE TABLE Purchases 
(
	purchase_id VARCHAR(50) PRIMARY KEY,
	supplier_id VARCHAR(50) NOT NULL,
	order_date DATE NOT NULL, -- Ngày đặt hàng
	invoice_date DATE NOT NULL, -- Ngày tạo hóa đơn nhập hàng
	expected_arrival_date DATE NULL, -- Ngày dự kiến hàng đến
	actual_arrival_date DATE NULL, -- Ngày thực tế hàng đến
	total_amount FLOAT NOT NULL,
	"status" NVARCHAR(50) NOT NULL,
	notes NVARCHAR(255) NULL

	CONSTRAINT FK_SuppliersPurchases FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id),
)
GO

-- Chi tiết Mua hàng (nhập hàng)
CREATE TABLE PurchaseDetails 
(
	purchase_id VARCHAR(50) NOT NULL,
	product_id VARCHAR(50) NOT NULL,
	quantity INT NOT NULL,
	unitprice FLOAT NOT NULL

	PRIMARY KEY (purchase_id, product_id),
	CONSTRAINT FK_PurchasesPurchaseDetails FOREIGN KEY (purchase_id) REFERENCES Purchases(purchase_id),
	CONSTRAINT FK_ProductsPurchaseDetails FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
GO

CREATE TABLE Orders
(
	order_id VARCHAR(50) PRIMARY KEY,
	customer_id VARCHAR(50) NOT NULL,
	employee_id VARCHAR(50) NOT NULL,
	order_date DATE NOT NULL,
	total_amount FLOAT NOT NULL,
	"status" NVARCHAR(50) NOT NULL,
	payment_method NVARCHAR(100) NOT NULL,
	payment_status NVARCHAR(50) NOT NULL,
	note NVARCHAR(255) NULL

	CONSTRAINT FK_CustomersOrders FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
	CONSTRAINT FK_EmployeesOrders FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
)
GO

CREATE TABLE OrderDetails
(
	order_id VARCHAR(50) NOT NULL,
	product_id VARCHAR(50) NOT NULL,
	unit_price FLOAT NOT NULL,
	quantity INT NOT NULL,
	discount FLOAT NULL

	PRIMARY KEY (order_id, product_id),
	CONSTRAINT FK_OrdersOrderDetails FOREIGN KEY (order_id) REFERENCES Orders(order_id),
	CONSTRAINT FK_ProductsOrderDetails FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
GO

CREATE TABLE OrderDiscounts
(
	order_discount_id VARCHAR(50) PRIMARY KEY,
	order_id VARCHAR(50) NOT NULL,
	discount_id VARCHAR(50) NOT NULL

	CONSTRAINT FK_Orders_OrderDiscounts FOREIGN KEY (order_id) REFERENCES Orders(order_id),
	CONSTRAINT FK_Discounts_OrderDiscounts FOREIGN KEY (discount_id) REFERENCES Discounts(discount_id)
)
GO

























