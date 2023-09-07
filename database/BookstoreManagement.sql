IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = N'BookStoreManagement')
begin
	CREATE DATABASE [BookStoreManagement];
end;

USE [BookStoreManagement];

CREATE SCHEMA [dbo];

CREATE TABLE [dbo].[Accounts] (
	[account_id] VARCHAR(50) NOT NULL,
	[username] VARCHAR(50) NOT NULL,
	[password] VARCHAR(255) NOT NULL,
	[role] NVARCHAR(100) NOT NULL,
	[status] BIT NOT NULL,
	CONSTRAINT [PK__Accounts__46A222CDB75B4322] PRIMARY KEY CLUSTERED ([account_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[Authors] (
	[author_id] VARCHAR(50) NOT NULL,
	[author_name] NVARCHAR(100) NOT NULL,
	[date_of_birth] DATE,
	[date_of_death] DATE,
	[country] NVARCHAR(50),
	CONSTRAINT [PK__Authors__86516BCF6D0B69B8] PRIMARY KEY CLUSTERED ([author_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[Suppliers] (
	[supplier_id] VARCHAR(50) NOT NULL,
	[supplier_name] NVARCHAR(100) NOT NULL,
	[address] NVARCHAR(255) NOT NULL,
	[contact_person] NVARCHAR(50) NOT NULL,
	[phone] VARCHAR(20) NOT NULL,
	[email] NVARCHAR(50) NOT NULL,
	[status] BIT,
	CONSTRAINT [PK__Supplier__6EE594E8276B395F] PRIMARY KEY CLUSTERED ([supplier_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[ProductTypes] (
	[product_type_id] VARCHAR(50) NOT NULL,
	[product_type_name] NVARCHAR(100) NOT NULL,
	[description] NVARCHAR(255),
	CONSTRAINT [PK__ProductT__6EED3ED64B908407] PRIMARY KEY CLUSTERED ([product_type_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[Products] (
	[product_id] VARCHAR(50) NOT NULL,
	[product_name] NVARCHAR(100) NOT NULL,
	[product_type_id] VARCHAR(50) NOT NULL,
	[supplier_id] VARCHAR(50) NOT NULL,
	[quantity] INT NOT NULL,
	[unit] NVARCHAR(50) NOT NULL,
	[price] FLOAT NOT NULL,
	[status] NVARCHAR(50),
	[image_link] VARCHAR(255),
	CONSTRAINT [PK__Products__47027DF5BB11770F] PRIMARY KEY CLUSTERED ([product_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_SuppliersProducts] FOREIGN KEY ([supplier_id]) REFERENCES [dbo].[Suppliers] ([supplier_id])  ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT [FK_ProductsTypeProducts] FOREIGN KEY ([product_type_id]) REFERENCES [dbo].[ProductTypes] ([product_type_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[Categories] (
	[category_id] VARCHAR(50) NOT NULL,
	[category_name] NVARCHAR(100) NOT NULL,
	[description] NVARCHAR(255),
	CONSTRAINT [PK__Categori__D54EE9B4A0BB5858] PRIMARY KEY CLUSTERED ([category_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[Books] (
	[product_id] VARCHAR(50) NOT NULL,
	[category_id] VARCHAR(50) NOT NULL,
	[author_id] VARCHAR(50) NOT NULL,
	[publisher] NVARCHAR(50) NOT NULL,
	[publication_year] INT NOT NULL,
	[page_count] INT NOT NULL,
	CONSTRAINT [PK__Books__47027DF57AC8DD18] PRIMARY KEY CLUSTERED ([product_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_ProductBook] FOREIGN KEY ([product_id]) REFERENCES [dbo].[Products] ([product_id])  ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT [FK_CategoryBook] FOREIGN KEY ([category_id]) REFERENCES [dbo].[Categories] ([category_id])  ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT [FK_AuthorBook] FOREIGN KEY ([author_id]) REFERENCES [dbo].[Authors] ([author_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[Customers] (
	[customer_id] VARCHAR(50) NOT NULL,
	[fullName] NVARCHAR(100) NOT NULL,
	[phone] VARCHAR(20) NOT NULL,
	[email] NVARCHAR(50) NOT NULL,
	[gender] NVARCHAR(20) NOT NULL,
	[total_spending] INT,
	[dayOfBirth] DATE NOT NULL,
	[address] NVARCHAR(255),
	[country] NVARCHAR(50) NOT NULL,
	CONSTRAINT [PK__Customer__CD65CB859D163666] PRIMARY KEY CLUSTERED ([customer_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[Discounts] (
	[discount_id] VARCHAR(50) NOT NULL,
	[program_name] NVARCHAR(255),
	[program_type] NVARCHAR(50),
	[start_date] DATE NOT NULL,
	[end_date] DATE NOT NULL,
	CONSTRAINT [PK__Discount__BDBE9EF9B2BDEA89] PRIMARY KEY CLUSTERED ([discount_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[Employees] (
	[employee_id] VARCHAR(50) NOT NULL,
	[fullName] NVARCHAR(100) NOT NULL,
	[gender] NVARCHAR(20),
	[email] NVARCHAR(50) NOT NULL,
	[address] NVARCHAR(255) NOT NULL,
	[account_id] VARCHAR(50) NOT NULL,
	[dayOfBirth] DATE NOT NULL,
	[phone] VARCHAR(20) NOT NULL,
	[position] NVARCHAR(50) NOT NULL,
	[hire_date] DATE NOT NULL,
	[status] NVARCHAR(50),
	CONSTRAINT [PK__Employee__C52E0BA8CD59B27B] PRIMARY KEY CLUSTERED ([employee_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_AccountsEmployees] FOREIGN KEY ([account_id]) REFERENCES [dbo].[Accounts] ([account_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[Orders] (
	[order_id] VARCHAR(50) NOT NULL,
	[customer_id] VARCHAR(50) NOT NULL,
	[employee_id] VARCHAR(50) NOT NULL,
	[order_date] DATE NOT NULL,
	[total_amount] FLOAT NOT NULL,
	[status] NVARCHAR(50) NOT NULL,
	[payment_method] NVARCHAR(100) NOT NULL,
	[payment_status] NVARCHAR(50) NOT NULL,
	[note] NVARCHAR(255),
	CONSTRAINT [PK__Orders__4659622963239E9E] PRIMARY KEY CLUSTERED ([order_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_EmployeesOrders] FOREIGN KEY ([employee_id]) REFERENCES [dbo].[Employees] ([employee_id])  ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT [FK_CustomersOrders] FOREIGN KEY ([customer_id]) REFERENCES [dbo].[Customers] ([customer_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[OrderDetails] (
	[order_id] VARCHAR(50) NOT NULL,
	[product_id] VARCHAR(50) NOT NULL,
	[unit_price] FLOAT NOT NULL,
	[quantity] INT NOT NULL,
	[discount] FLOAT,
	CONSTRAINT [PK__OrderDet__022945F602C67956] PRIMARY KEY CLUSTERED ([order_id] ASC, [product_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_ProductsOrderDetails] FOREIGN KEY ([product_id]) REFERENCES [dbo].[Products] ([product_id])  ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT [FK_OrdersOrderDetails] FOREIGN KEY ([order_id]) REFERENCES [dbo].[Orders] ([order_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[OrderDiscounts] (
	[order_discount_id] VARCHAR(50) NOT NULL,
	[order_id] VARCHAR(50) NOT NULL,
	[discount_id] VARCHAR(50) NOT NULL,
	CONSTRAINT [PK__OrderDis__93C1FE8B8E2A7202] PRIMARY KEY CLUSTERED ([order_discount_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_Discounts_OrderDiscounts] FOREIGN KEY ([discount_id]) REFERENCES [dbo].[Discounts] ([discount_id])  ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT [FK_Orders_OrderDiscounts] FOREIGN KEY ([order_id]) REFERENCES [dbo].[Orders] ([order_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[Purchases] (
	[purchase_id] VARCHAR(50) NOT NULL,
	[supplier_id] VARCHAR(50) NOT NULL,
	[order_date] DATE NOT NULL,
	[invoice_date] DATE NOT NULL,
	[expected_arrival_date] DATE,
	[actual_arrival_date] DATE,
	[total_amount] FLOAT NOT NULL,
	[status] NVARCHAR(50) NOT NULL,
	[notes] NVARCHAR(255),
	CONSTRAINT [PK__Purchase__87071CB99D33DDB2] PRIMARY KEY CLUSTERED ([purchase_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_SuppliersPurchases] FOREIGN KEY ([supplier_id]) REFERENCES [dbo].[Suppliers] ([supplier_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[PurchaseDetails] (
	[purchase_id] VARCHAR(50) NOT NULL,
	[product_id] VARCHAR(50) NOT NULL,
	[quantity] INT NOT NULL,
	[unitprice] FLOAT NOT NULL,
	CONSTRAINT [PK__Purchase__C3773B666882AE70] PRIMARY KEY CLUSTERED ([product_id] ASC, [purchase_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_ProductsPurchaseDetails] FOREIGN KEY ([product_id]) REFERENCES [dbo].[Products] ([product_id])  ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT [FK_PurchasesPurchaseDetails] FOREIGN KEY ([purchase_id]) REFERENCES [dbo].[Purchases] ([purchase_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE [dbo].[sysdiagrams] (
	[diagram_id] INT IDENTITY(1, 1) NOT NULL,
	[name] NVARCHAR(128) NOT NULL,
	[principal_id] INT NOT NULL,
	[version] INT,
	[definition] VARBINARY(MAX),
	CONSTRAINT [PK__sysdiagr__C2B05B618167E274] PRIMARY KEY CLUSTERED ([diagram_id] ASC) ON [PRIMARY],
	CONSTRAINT [UK_principal_name] UNIQUE NONCLUSTERED ([name] ASC, [principal_id] ASC) ON [PRIMARY]
);

CREATE TABLE [dbo].[WorkShifts] (
	[shift_id] VARCHAR(50) NOT NULL,
	[employee_id] VARCHAR(50) NOT NULL,
	[shift_date] DATE NOT NULL,
	[start_time] DATE NOT NULL,
	[end_time] DATE NOT NULL,
	[salary] FLOAT,
	CONSTRAINT [PK__WorkShif__7B2672205D1814ED] PRIMARY KEY CLUSTERED ([shift_id] ASC) ON [PRIMARY],
	CONSTRAINT [FK_EmployeesWorkShifts] FOREIGN KEY ([employee_id]) REFERENCES [dbo].[Employees] ([employee_id])  ON DELETE NO ACTION ON UPDATE NO ACTION
);