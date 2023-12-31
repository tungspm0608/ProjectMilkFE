create database DuAnBanSua_MilkFE;
go
USE [DuAnBanSua_MilkFE]
GO
/****** Object:  Table [dbo].[DongSanPham]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DongSanPham](
	[maDongSanPham] [int] IDENTITY(1,1) NOT NULL,
	[tenDongSanPham] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](max) NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maDongSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[maDonHang] [int] IDENTITY(1,1) NOT NULL,
	[maKhachHang] [int] NULL,
	[maNhanVien] [varchar](50) NULL,
	[maHinhThucThanhToan] [int] NULL,
	[trangThai] [bit] NULL,
	[ghiChu] [nvarchar](max) NULL,
	[ngayTao] [date] NULL,
	[phiKhac] [float] NULL,
	[tienHang] [float] NULL,
	[tienGiam] [float] NULL,
	[tongTien] [float] NULL,
	[loaiDonHang] [int] NULL,
	[dienThoai] [varchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maDonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHangChiTiet]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHangChiTiet](
	[maDonHangChiTiet] [int] IDENTITY(1,1) NOT NULL,
	[maDonHang] [int] NOT NULL,
	[maSanPhamChiTiet] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[giaTriGiam] [float] NOT NULL,
	[donViGiam] [varchar](10) NULL,
	[giaGiam] [float] NULL,
	[tongGia] [float] NOT NULL,
	[trangThai] [bit] NULL,
	[traHang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maDonHangChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonViTinh]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonViTinh](
	[maDonViTinh] [int] IDENTITY(1,1) NOT NULL,
	[tenDonViTinh] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](max) NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maDonViTinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[maHinhThucThanhToan] [int] IDENTITY(1,1) NOT NULL,
	[tenHinhThucThanhToan] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHinhThucThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[soDienThoai] [varchar](20) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[diem] [float] NOT NULL,
	[ghiChu] [nvarchar](max) NULL,
	[ngayDangKy] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKhuyenMai] [varchar](15) NOT NULL,
	[tenChuongTrinh] [nvarchar](50) NOT NULL,
	[ngayBatDau] [date] NOT NULL,
	[ngayKetThuc] [date] NOT NULL,
	[moTa] [nvarchar](255) NOT NULL,
	[trangThai] [bit] NULL,
	[donViGiam] [varchar](15) NOT NULL,
	[giaTriGiam] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMaiSanPham]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMaiSanPham](
	[maKhuyenMaiSanPham] [int] IDENTITY(1,1) NOT NULL,
	[maKhuyenMai] [varchar](15) NOT NULL,
	[maSanPhamChiTiet] [int] NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhuyenMaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiHang]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiHang](
	[maLoaiHang] [int] IDENTITY(1,1) NOT NULL,
	[tenLoaiHang] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](max) NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [varchar](50) NOT NULL,
	[matKhau] [varchar](50) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[soDienThoai] [varchar](20) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[hinhAnh] [varchar](100) NOT NULL,
	[VaiTro] [bit] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[ghiChu] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nvarchar](20) NOT NULL,
	[tenSanPham] [nvarchar](255) NOT NULL,
	[moTa] [nvarchar](255) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[maThuongHieu] [int] NOT NULL,
	[maLoaiHang] [int] NOT NULL,
	[maDongSanPham] [int] NOT NULL,
	[maXuatXu] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPhamChiTiet]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPhamChiTiet](
	[maSanPhamChiTiet] [int] IDENTITY(1,1) NOT NULL,
	[maSanPham] [nvarchar](20) NOT NULL,
	[maDonViTinh] [int] NOT NULL,
	[AnhSanPham] [varchar](100) NOT NULL,
	[hanSuDung] [date] NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaNhap] [float] NOT NULL,
	[donGia] [float] NOT NULL,
	[khoiLuong] [float] NOT NULL,
	[donViTinhKhoiLuong] [nvarchar](20) NOT NULL,
	[ngaySanXuat] [date] NOT NULL,
	[barcode] [varchar](50) NOT NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPhamChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[maThuongHieu] [int] IDENTITY(1,1) NOT NULL,
	[tenThuongHieu] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](max) NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maThuongHieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XuatXu]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XuatXu](
	[maXuatXu] [int] IDENTITY(1,1) NOT NULL,
	[tenXuatXu] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](max) NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maXuatXu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[DongSanPham] ON 

INSERT [dbo].[DongSanPham] ([maDongSanPham], [tenDongSanPham], [ghiChu], [trangThai]) VALUES (1, N'Sữa bột', N'Mô tả cho sữa bột', 1)
INSERT [dbo].[DongSanPham] ([maDongSanPham], [tenDongSanPham], [ghiChu], [trangThai]) VALUES (2, N'Sữa tươi', N'Mô tả cho sữa tươi', 1)
INSERT [dbo].[DongSanPham] ([maDongSanPham], [tenDongSanPham], [ghiChu], [trangThai]) VALUES (3, N'Sữa không đường', N'Mô tả cho sữa không đường', 1)
INSERT [dbo].[DongSanPham] ([maDongSanPham], [tenDongSanPham], [ghiChu], [trangThai]) VALUES (4, N'Sữa hạt', N'Mô tả cho sữa hạt', 1)
INSERT [dbo].[DongSanPham] ([maDongSanPham], [tenDongSanPham], [ghiChu], [trangThai]) VALUES (5, N'Sữa ít đường', N'Mô tả cho ít đường', 1)
SET IDENTITY_INSERT [dbo].[DongSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[DonHang] ON 

INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (1, NULL, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 0, 0, 0, 4, N'', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (2, 1, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 1116000, 100000, 1016000, 4, N'0123456789', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (3, 1, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 889000, 50000, 839000, 4, N'0123456789', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (4, NULL, N'NV001', 2, 1, NULL, CAST(N'2023-12-03' AS Date), 20000, 260600, 0, 280600, 2, N'01235644', N'hà nội')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (5, 2, N'NV001', 2, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 909200, 150000, 759200, 2, N'0987654321', N'nam định')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (6, 3, N'NV001', 2, 1, NULL, CAST(N'2023-12-03' AS Date), 30000, 1510000, 120000, 1420000, 2, N'0345678901', N'Ninh bình')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (7, NULL, N'NV001', 2, 0, NULL, CAST(N'2023-12-03' AS Date), 50000, 413500, 0, 463500, 3, N'051541251', N'Hòa bình')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (8, NULL, N'NV001', 2, 1, NULL, CAST(N'2023-12-03' AS Date), 200000, 556500, 0, 756500, 2, N'06256652', N'Sài gòn')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (9, NULL, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 1551500, 0, 1551500, 4, N'', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (10, NULL, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 696100, 0, 696100, 4, N'', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (11, 1, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 1406000, 41000, 1365000, 4, N'0123456789', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (12, NULL, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 1527000, 0, 1527000, 4, N'', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (13, 4, N'NV001', 2, 1, NULL, CAST(N'2023-12-03' AS Date), 35000, 1330000, 90000, 1275000, 2, N'0765432109', N'Bắc Ninh')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (14, 5, N'NV001', 2, 0, NULL, CAST(N'2023-12-03' AS Date), 33500, 866600, 80000, 820100, 3, N'0123456780', N'Hải dương')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (15, 2, N'NV001', 2, 1, NULL, CAST(N'2023-12-03' AS Date), 50000, 919000, 37000, 932000, 2, N'0987654321', N'Bà rịa Vũng tàu')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (16, NULL, N'NV001', 2, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 1331000, 0, 1331000, 4, N'051256125', N'')
INSERT [dbo].[DonHang] ([maDonHang], [maKhachHang], [maNhanVien], [maHinhThucThanhToan], [trangThai], [ghiChu], [ngayTao], [phiKhac], [tienHang], [tienGiam], [tongTien], [loaiDonHang], [dienThoai], [diaChi]) VALUES (17, NULL, N'NV001', 1, 1, NULL, CAST(N'2023-12-03' AS Date), 0, 3500, 0, 3500, 4, N'', N'')
SET IDENTITY_INSERT [dbo].[DonHang] OFF
GO
SET IDENTITY_INSERT [dbo].[DonHangChiTiet] ON 

INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (1, 1, 3, 1, 225000, 0, N'', 225000, 0, 1, 1)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (2, 1, 2, 1, 35000, 30, N'%', 24500, 0, 1, 1)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (3, 2, 3, 1, 225000, 0, N'', 225000, 225000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (4, 2, 9, 1, 480000, 0, N'', 480000, 480000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (5, 2, 1, 1, 411000, 0, N'', 411000, 411000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (6, 3, 8, 1, 360000, 0, N'', 360000, 360000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (7, 3, 2, 2, 35000, 30, N'%', 24500, 49000, 1, 0)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (8, 3, 9, 1, 480000, 0, N'', 480000, 480000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (12, 4, 7, 1, 8000, 30, N'%', 5600, 5600, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (13, 4, 5, 1, 30000, 0, N'', 30000, 30000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (14, 4, 3, 1, 225000, 0, N'', 225000, 225000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (15, 5, 2, 1, 35000, 30, N'%', 24500, 24500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (16, 5, 5, 1, 30000, 0, N'', 30000, 30000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (17, 5, 9, 1, 480000, 0, N'', 480000, 480000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (18, 5, 8, 1, 360000, 0, N'', 360000, 360000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (19, 5, 4, 1, 5000, 30, N'%', 3500, 3500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (20, 5, 7, 2, 8000, 30, N'%', 5600, 11200, 1, 0)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (21, 6, 2, 2, 35000, 30, N'%', 24500, 49000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (22, 6, 6, 1, 91000, 0, N'', 91000, 91000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (23, 6, 9, 2, 480000, 0, N'', 480000, 960000, 1, 0)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (24, 6, 10, 1, 410000, 0, N'', 410000, 410000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (25, 7, 5, 0, 30000, 0, N'', 30000, 0, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (26, 7, 4, 1, 5000, 30, N'%', 3500, 3500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (27, 7, 10, 1, 410000, 0, N'', 410000, 410000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (28, 8, 1, 1, 411000, 0, N'', 411000, 411000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (29, 8, 2, 1, 35000, 30, N'%', 24500, 24500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (30, 8, 5, 1, 30000, 0, N'', 30000, 30000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (31, 8, 6, 1, 91000, 0, N'', 91000, 91000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (32, 9, 1, 2, 411000, 0, N'', 411000, 822000, 1, 0)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (33, 9, 4, 1, 5000, 30, N'%', 3500, 3500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (34, 9, 10, 1, 410000, 0, N'', 410000, 410000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (35, 9, 3, 1, 225000, 0, N'', 225000, 225000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (36, 9, 6, 1, 91000, 0, N'', 91000, 91000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (37, 10, 1, 1, 411000, 0, N'', 411000, 411000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (38, 10, 2, 1, 35000, 30, N'%', 24500, 24500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (39, 10, 3, 1, 225000, 0, N'', 225000, 225000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (40, 10, 5, 1, 30000, 0, N'', 30000, 30000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (41, 10, 7, 1, 8000, 30, N'%', 5600, 5600, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (42, 11, 1, 1, 411000, 0, N'', 411000, 411000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (43, 11, 3, 1, 225000, 0, N'', 225000, 225000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (44, 11, 8, 1, 360000, 0, N'', 360000, 360000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (45, 11, 10, 1, 410000, 0, N'', 410000, 410000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (46, 12, 1, 2, 411000, 0, N'', 411000, 822000, 1, 0)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (47, 12, 3, 1, 225000, 0, N'', 225000, 225000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (48, 12, 9, 1, 480000, 0, N'', 480000, 480000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (49, 14, 10, 1, 410000, 0, N'', 410000, 410000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (50, 14, 8, 1, 360000, 0, N'', 360000, 360000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (51, 14, 6, 1, 91000, 0, N'', 91000, 91000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (52, 14, 7, 1, 8000, 30, N'%', 5600, 5600, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (53, 13, 4, 1, 5000, 30, N'%', 3500, 3500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (54, 13, 2, 1, 35000, 30, N'%', 24500, 24500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (55, 13, 1, 2, 411000, 0, N'', 411000, 822000, 1, 0)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (56, 13, 9, 1, 480000, 0, N'', 480000, 480000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (57, 15, 2, 1, 35000, 30, N'%', 24500, 24500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (58, 15, 4, 1, 5000, 30, N'%', 3500, 3500, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (59, 15, 9, 1, 480000, 0, N'', 480000, 480000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (60, 15, 1, 1, 411000, 0, N'', 411000, 411000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (61, 16, 1, 1, 411000, 0, N'', 411000, 411000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (62, 16, 5, 1, 30000, 0, N'', 30000, 30000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (63, 16, 10, 1, 410000, 0, N'', 410000, 410000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (64, 16, 9, 1, 480000, 0, N'', 480000, 480000, 1, NULL)
INSERT [dbo].[DonHangChiTiet] ([maDonHangChiTiet], [maDonHang], [maSanPhamChiTiet], [soLuong], [donGia], [giaTriGiam], [donViGiam], [giaGiam], [tongGia], [trangThai], [traHang]) VALUES (65, 17, 4, 1, 5000, 30, N'%', 3500, 3500, 1, NULL)
SET IDENTITY_INSERT [dbo].[DonHangChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[DonViTinh] ON 

INSERT [dbo].[DonViTinh] ([maDonViTinh], [tenDonViTinh], [ghiChu], [trangThai]) VALUES (1, N'Hộp giấy', N'Description for Hộp', 1)
INSERT [dbo].[DonViTinh] ([maDonViTinh], [tenDonViTinh], [ghiChu], [trangThai]) VALUES (2, N'Chai', N'Description for Chai', 1)
INSERT [dbo].[DonViTinh] ([maDonViTinh], [tenDonViTinh], [ghiChu], [trangThai]) VALUES (3, N'Lọ', N'Description for Lọ', 1)
INSERT [dbo].[DonViTinh] ([maDonViTinh], [tenDonViTinh], [ghiChu], [trangThai]) VALUES (4, N'Túi', N'Description for Túi', 1)
INSERT [dbo].[DonViTinh] ([maDonViTinh], [tenDonViTinh], [ghiChu], [trangThai]) VALUES (5, N'Gói', N'Description for Gói', 1)
INSERT [dbo].[DonViTinh] ([maDonViTinh], [tenDonViTinh], [ghiChu], [trangThai]) VALUES (6, N'Hộp thiếc', N'Description for Cái', 1)
SET IDENTITY_INSERT [dbo].[DonViTinh] OFF
GO
SET IDENTITY_INSERT [dbo].[HinhThucThanhToan] ON 

INSERT [dbo].[HinhThucThanhToan] ([maHinhThucThanhToan], [tenHinhThucThanhToan]) VALUES (1, N'Tiền mặt')
INSERT [dbo].[HinhThucThanhToan] ([maHinhThucThanhToan], [tenHinhThucThanhToan]) VALUES (2, N'Chuyển khoản')
SET IDENTITY_INSERT [dbo].[HinhThucThanhToan] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (1, N'Nguyễn Thị Anh', 0, CAST(N'1992-03-12' AS Date), N'0123456789', N'thiAnh@gmail.com', 68, N'Ghi chú cho Khách hàng A', CAST(N'2022-01-05' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (2, N'Trần Văn Bình', 1, CAST(N'1985-05-20' AS Date), N'0987654321', N'vanBinh@gmail.com', 46, N'Ghi chú cho Khách hàng B', CAST(N'2022-02-10' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (3, N'Lê Thị Cam', 0, CAST(N'1990-08-15' AS Date), N'0345678901', N'thiCam@gmail.com', 71, N'Ghi chú cho Khách hàng C', CAST(N'2022-03-18' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (4, N'Phạm Văn Dương', 1, CAST(N'1988-11-02' AS Date), N'0765432109', N'vanDuong@gmail.com', 63, N'Ghi chú cho Khách hàng D', CAST(N'2022-04-25' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (5, N'Trần Thị Em', 0, CAST(N'1995-02-25' AS Date), N'0123456780', N'thiEm@gmail.com', 0, N'Ghi chú cho Khách hàng E', CAST(N'2022-05-30' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (6, N'Nguyễn Văn Khanh', 1, CAST(N'1983-07-10' AS Date), N'0987654321', N'vanKhanh@gmail.com', 110, N'Ghi chú cho Khách hàng F', CAST(N'2022-06-12' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (7, N'Lê Văn Giang', 1, CAST(N'1998-09-28' AS Date), N'0345678901', N'vanGiang@gmail.com', 130, N'Ghi chú cho Khách hàng G', CAST(N'2022-07-20' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (8, N'Phạm Thị Hòa', 0, CAST(N'1991-12-05' AS Date), N'0765432109', N'thiHoa@gmail.com', 95, N'Ghi chú cho Khách hàng H', CAST(N'2022-08-15' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (9, N'Nguyễn Văn Linh', 1, CAST(N'1987-04-18' AS Date), N'0123456789', N'vanIinh@gmail.com', 140, N'Ghi chú cho Khách hàng I', CAST(N'2022-09-22' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (10, N'Trần Thị Kiều', 0, CAST(N'1994-06-30' AS Date), N'0987654321', N'thiKieu@gmail.com', 75, N'Ghi chú cho Khách hàng K', CAST(N'2022-10-05' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (11, N'Lê Văn Lương', 1, CAST(N'1986-08-22' AS Date), N'0345678901', N'vanLuong@gmail.com', 160, N'Ghi chú cho Khách hàng L', CAST(N'2022-11-12' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (12, N'Phạm Thị Minh', 0, CAST(N'1993-10-15' AS Date), N'0765432109', N'thiMinh@gmail.com', 105, N'Ghi chú cho Khách hàng M', CAST(N'2022-12-18' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (13, N'Nguyễn Văn Ngọc', 1, CAST(N'1984-01-28' AS Date), N'0123456780', N'vanNgoc@gmail.com', 125, N'Ghi chú cho Khách hàng N', CAST(N'2023-01-25' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (14, N'Trần Văn Phong', 1, CAST(N'1999-03-03' AS Date), N'0987654321', N'vanPhong@gmail.com', 88, N'Ghi chú cho Khách hàng P', CAST(N'2023-02-28' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (15, N'Lê Thị Qúy', 0, CAST(N'1990-05-18' AS Date), N'0345678901', N'thiQuy@gmail.com', 115, N'Ghi chú cho Khách hàng Q', CAST(N'2023-03-15' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (16, N'Phạm Văn Rong', 1, CAST(N'1988-08-01' AS Date), N'0765432109', N'vanRong@gmail.com', 135, N'Ghi chú cho Khách hàng R', CAST(N'2023-04-22' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (17, N'Trần Thị Sắn', 0, CAST(N'1995-09-15' AS Date), N'0123456789', N'thiSan@gmail.com', 99, N'Ghi chú cho Khách hàng S', CAST(N'2023-05-10' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (18, N'Nguyễn Văn Tuấn', 1, CAST(N'1983-11-28' AS Date), N'0987654321', N'vanTuan@gmail.com', 120, N'Ghi chú cho Khách hàng T', CAST(N'2023-06-18' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (19, N'Lê Thị Uông', 0, CAST(N'1998-02-10' AS Date), N'0345678901', N'thiUong@gmail.com', 80, N'Ghi chú cho Khách hàng U', CAST(N'2023-07-25' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [diem], [ghiChu], [ngayDangKy]) VALUES (20, N'Phạm Văn Viên', 1, CAST(N'1987-04-25' AS Date), N'0765432109', N'vanVien@gmail.com', 155, N'Ghi chú cho Khách hàng V', CAST(N'2023-08-30' AS Date))
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenChuongTrinh], [ngayBatDau], [ngayKetThuc], [moTa], [trangThai], [donViGiam], [giaTriGiam]) VALUES (N'KM01', N'Khuyến mãi mùa hè', CAST(N'2023-06-01' AS Date), CAST(N'2023-06-30' AS Date), N'Giảm giá cho sản phẩm mùa hè', 1, N'VND', 5000)
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenChuongTrinh], [ngayBatDau], [ngayKetThuc], [moTa], [trangThai], [donViGiam], [giaTriGiam]) VALUES (N'KM02', N'Khuyen mai ngay hoi Tre em', CAST(N'2023-05-20' AS Date), CAST(N'2023-06-02' AS Date), N'Giảm giá cho sản phẩm sữa cho trẻ', 1, N'VND', 50000)
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenChuongTrinh], [ngayBatDau], [ngayKetThuc], [moTa], [trangThai], [donViGiam], [giaTriGiam]) VALUES (N'KM03', N'Khuyen mai ngay Tet Doc lap', CAST(N'2023-08-25' AS Date), CAST(N'2023-09-05' AS Date), N'Giảm giá cho sản phẩm sữa', 1, N'VND', 30000)
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenChuongTrinh], [ngayBatDau], [ngayKetThuc], [moTa], [trangThai], [donViGiam], [giaTriGiam]) VALUES (N'KM04', N'Khuyen mai ngay Tet Nguyen Dan', CAST(N'2024-01-15' AS Date), CAST(N'2024-01-30' AS Date), N'Giảm giá cho sản phẩm sữa', 1, N'VND', 25000)
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenChuongTrinh], [ngayBatDau], [ngayKetThuc], [moTa], [trangThai], [donViGiam], [giaTriGiam]) VALUES (N'KM05', N'Khuyen mai Back Friday', CAST(N'2023-06-13' AS Date), CAST(N'2024-06-30' AS Date), N'Giảm giá cho sản phẩm sữa', 1, N'%', 30)
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenChuongTrinh], [ngayBatDau], [ngayKetThuc], [moTa], [trangThai], [donViGiam], [giaTriGiam]) VALUES (N'KM06', N'Khuyen mai Noel', CAST(N'2023-12-10' AS Date), CAST(N'2024-12-31' AS Date), N'Giảm giá cho sản phẩm sữa', 1, N'VND', 45000)
GO
SET IDENTITY_INSERT [dbo].[KhuyenMaiSanPham] ON 

INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (1, N'KM01', 1, 0)
INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (2, N'KM02', 3, 1)
INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (3, N'KM03', 6, 0)
INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (4, N'KM04', 5, 0)
INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (5, N'KM04', 3, 1)
INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (6, N'KM05', 2, 1)
INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (7, N'KM05', 4, 1)
INSERT [dbo].[KhuyenMaiSanPham] ([maKhuyenMaiSanPham], [maKhuyenMai], [maSanPhamChiTiet], [trangThai]) VALUES (8, N'KM05', 7, 1)
SET IDENTITY_INSERT [dbo].[KhuyenMaiSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[LoaiHang] ON 

INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang], [ghiChu], [trangThai]) VALUES (1, N'Cho trẻ em', N'Fresh cow milk', 1)
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang], [ghiChu], [trangThai]) VALUES (2, N'Cho người già', N'Fresh cow milk', 1)
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang], [ghiChu], [trangThai]) VALUES (3, N'Cho bà bầu', N'Fresh cow milk', 1)
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang], [ghiChu], [trangThai]) VALUES (4, N'Mọi lứa tuổi', N'Fresh cow milk', 1)
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang], [ghiChu], [trangThai]) VALUES (5, N'Cho người loãng xương', N'Fresh cow milk', 1)
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang], [ghiChu], [trangThai]) VALUES (6, N'Cho người bệnh', N'Fresh cow milk', 1)
SET IDENTITY_INSERT [dbo].[LoaiHang] OFF
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [matKhau], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [hinhAnh], [VaiTro], [trangThai], [ghiChu]) VALUES (N'NV001', N'123456', N'Nguyễn Văn An', 1, CAST(N'1990-01-15' AS Date), N'0999999999', N'nvA@gmail.com', N'avatar_A.jpg', 1, 1, N'Ghi chú cho Nhân viên An')
INSERT [dbo].[NhanVien] ([maNhanVien], [matKhau], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [hinhAnh], [VaiTro], [trangThai], [ghiChu]) VALUES (N'NV002', N'123456', N'Trần Thị Bình', 0, CAST(N'1995-03-20' AS Date), N'0988888888', N'nvB@gmail.com', N'avatar_B.jpg', 0, 1, N'Ghi chú cho Nhân viên Bình')
INSERT [dbo].[NhanVien] ([maNhanVien], [matKhau], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [hinhAnh], [VaiTro], [trangThai], [ghiChu]) VALUES (N'NV003', N'123456', N'Lê Văn Cường', 1, CAST(N'1988-07-10' AS Date), N'0987777777', N'nvC@gmail.com', N'avatar_C.jpg', 1, 1, N'Ghi chú cho Nhân viên Cường')
INSERT [dbo].[NhanVien] ([maNhanVien], [matKhau], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [hinhAnh], [VaiTro], [trangThai], [ghiChu]) VALUES (N'NV004', N'123456', N'Phạm Thị Duyên', 0, CAST(N'1992-05-02' AS Date), N'0987666666', N'nvD@gmail.com', N'avatar_D.jpg', 0, 1, N'Ghi chú cho Nhân viên Duyên')
INSERT [dbo].[NhanVien] ([maNhanVien], [matKhau], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [hinhAnh], [VaiTro], [trangThai], [ghiChu]) VALUES (N'NV005', N'123456', N'Hoàng Mạnh Chức', 1, CAST(N'2000-08-10' AS Date), N'0987655555', N'hmE@gmail.com', N'avatar_E.jpg', 0, 0, N'Ghi chú cho Nhân viên Chức')
INSERT [dbo].[NhanVien] ([maNhanVien], [matKhau], [hoTen], [gioiTinh], [ngaySinh], [soDienThoai], [email], [hinhAnh], [VaiTro], [trangThai], [ghiChu]) VALUES (N'NV006', N'123456', N'Ngô Gia Pháp', 1, CAST(N'1995-02-10' AS Date), N'0987654444', N'ngF@gmail.com', N'avatar_F.jpg', 0, 1, N'Ghi chú cho Nhân viên Pháp')
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP01', N'Sữa bột Vinamilk Colos Gold', N'Mô tả cho Sữa Vinamilk', 1, 1, 1, 1, 7)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP011', N'Sữa Nuvi Grow 900g', N'Mô tả cho Sữa Vinamilk', 1, 7, 1, 1, 3)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP012', N' Thức Uống Lúa Mạch Nestlé MILO Sữa 3 Trong 1', N'Mô tả cho Sữa Vinamilk', 1, 2, 4, 2, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP013', N'Sữa tươi NutriStrong', N'Mô tả cho Sữa Vinamilk', 1, 2, 4, 3, 5)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP02', N'Sữa tươi Vinamlik không đường ', N'Mô tả cho Sữa Vinamilk', 1, 1, 4, 3, 2)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP021', N'Sữa Nuvi Grow 900g', N'Mô tả cho Sữa Vinamilk', 1, 7, 1, 1, 3)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP022', N' Thức Uống Lúa Mạch Nestlé MILO Sữa 3 Trong 1', N'Mô tả cho Sữa Vinamilk', 1, 2, 4, 2, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP023', N'Sữa tươi NutriStrong', N'Mô tả cho Sữa Vinamilk', 1, 7, 2, 3, 7)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP024', N'Sữa tươi NutriStrong', N'Mô tả cho Sữa Vinamilk', 1, 5, 1, 1, 2)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP025', N'Sữa tươi NutriStrong', N'Mô tả cho Sữa Vinamilk', 1, 5, 4, 2, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP026', N'Sữa tươi NutriStrong', N'Mô tả cho Sữa Vinamilk', 1, 1, 1, 5, 3)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP03', N'Sữa bột Vinamilk Yoko Gold', N'Mô tả cho Sữa Vinamilk', 1, 1, 1, 1, 3)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP04', N'Sữa tuôi tiệt trùng Vinamilk 100% hương dâu', N'Mô tả cho Sữa Vinamilk', 1, 1, 4, 2, 5)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP05', N'Sữa tươi tiệt trùng có đường Cô Gái Hà Lan', N'Mô tả cho Sữa Dutch Lady', 1, 3, 4, 2, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP06', N'Sữa bột DUTCH LADY nguyên kem', N'Mô tả cho Sữa Dutch Lady', 1, 3, 4, 1, 11)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP07', N'Sữa tươi tiệt trùng Cô Gái Hà Lan vị Socola', N'Mô tả cho Sữa Dutch Lady', 1, 3, 4, 2, 29)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP08', N'Sữa bột Grow Plus hộp đỏ', N'Mô tả cho Sữa Nutifood', 1, 7, 1, 1, 35)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP09', N'Sữa Enplus Gold 900g', N'Mô tả cho Sữa Nutifood', 1, 7, 2, 1, 7)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP10', N'Sữa Famna số 4 850g', N'Mô tả cho Sữa Nutifood', 1, 7, 1, 1, 2)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP11', N'Sữa Nuvi Grow 900g', N'Mô tả cho Sữa Nutifood', 1, 7, 1, 1, 3)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP12', N'Thức Uống Lúa Mạch Nestlé MILO Sữa 3 Trong 1', N'Mô tả cho Sữa Nestle', 1, 2, 4, 2, 1)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP13', N'Sữa tươi NutriStrong', N'Mô tả cho Sữa Nestle', 1, 2, 4, 3, 5)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP14', N'Sữa Enfamama A+ DHA hương vani cho mẹ bầu', N'Mô tả cho Sữa Mead Johnson', 1, 4, 3, 1, 11)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP15', N'Sữa bột Frisolac Gold số 4 850g', N'Mô tả cho Sữa Friso', 1, 6, 1, 1, 29)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP16', N'Sữa bột Abbott Grow 3 900g', N'Mô tả cho Sữa Abbott', 1, 5, 1, 1, 35)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP17', N'Sữa bột pha sẵn PediaSure socola 237ml', N'Mô tả cho Sữa Abbott', 1, 5, 1, 1, 7)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP18', N'Sữa hạt óc chó TH true nut 180ml ', N'Mô tả cho Sữa TH True Milk', 1, 8, 4, 4, 2)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP19', N'Sữa tươi tiệt trùng trùng ít đường TH true milk', N'Mô tả cho Sữa TH True Milk', 1, 8, 4, 5, 3)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [moTa], [trangThai], [maThuongHieu], [maLoaiHang], [maDongSanPham], [maXuatXu]) VALUES (N'SP20', N'Sữa trái cây TH True Milk vị dâu 300ml', N'Mô tả cho Sữa TH True Milk', 1, 8, 4, 2, 1)
GO
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] ON 

INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (1, N'SP01', 6, N'SP01.jpg', CAST(N'2026-12-31' AS Date), 38, 330000, 411000, 0.800000011920929, N'kg', CAST(N'2023-01-01' AS Date), N'8934673001137', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (2, N'SP02', 1, N'SP02.jpg', CAST(N'2025-12-31' AS Date), 70, 28000, 35000, 1, N'L', CAST(N'2023-01-15' AS Date), N'8934673576390', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (3, N'SP03', 6, N'SP03.jpg', CAST(N'2026-12-31' AS Date), 53, 195000, 225000, 0.34999999403953552, N'kg', CAST(N'2023-02-01' AS Date), N'8934673000284', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (4, N'SP04', 1, N'SP04.jpg', CAST(N'2025-12-31' AS Date), 34, 3200, 5000, 0.10999999940395355, N'L', CAST(N'2023-02-15' AS Date), N'8934673574327', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (5, N'SP05', 1, N'SP05.jpg', CAST(N'2026-12-31' AS Date), 65, 25000, 30000, 1, N'L', CAST(N'2023-03-01' AS Date), N'8718182063103', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (6, N'SP06', 1, N'SP06.jpg', CAST(N'2025-12-31' AS Date), 26, 72000, 91000, 0.40000000596046448, N'kg', CAST(N'2023-03-20' AS Date), N'8936036771862', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (7, N'SP07', 1, N'SP07.jpg', CAST(N'2026-12-31' AS Date), 15, 6000, 8000, 0.18000000715255737, N'L', CAST(N'2023-04-01' AS Date), N'18934841901877', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (8, N'SP08', 6, N'SP08.jpg', CAST(N'2025-12-31' AS Date), 36, 280000, 360000, 0.89999997615814209, N'kg', CAST(N'2023-04-11' AS Date), N'8935049002345', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (9, N'SP09', 6, N'SP09.jpg', CAST(N'2026-12-31' AS Date), 81, 380000, 480000, 0.89999997615814209, N'kg', CAST(N'2023-04-15' AS Date), N'8935049001676', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (10, N'SP10', 6, N'SP010.jpg', CAST(N'2025-12-31' AS Date), 64, 350000, 410000, 0.85000002384185791, N'kg', CAST(N'2023-05-01' AS Date), N'7350107130609', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (11, N'SP11', 6, N'SP011.jpg', CAST(N'2026-12-31' AS Date), 50, 230000, 290000, 0.9, N'kg', CAST(N'2023-05-21' AS Date), N'8935049014010', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (12, N'SP12', 4, N'SP012.jpg', CAST(N'2025-12-31' AS Date), 80, 45000, 58000, 0.33, N'kg', CAST(N'2023-06-15' AS Date), N'8934804040783', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (13, N'SP13', 1, N'SP013.jpg', CAST(N'2026-12-31' AS Date), 60, 5000, 8000, 0.18, N'L', CAST(N'2023-07-01' AS Date), N'8934804033051', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (14, N'SP14', 6, N'SP014.jpg', CAST(N'2025-12-31' AS Date), 40, 380000, 480000, 0.83, N'kg', CAST(N'2023-07-15' AS Date), N'0300875132203', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (15, N'SP15', 6, N'SP015.jpg', CAST(N'2025-12-31' AS Date), 70, 380000, 480000, 0.85, N'kg', CAST(N'2023-08-01' AS Date), N'8936036774658', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (16, N'SP16', 6, N'SP016.jpg', CAST(N'2026-12-31' AS Date), 30, 230000, 280000, 0.9, N'kg', CAST(N'2023-08-15' AS Date), N'5099864008739', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (17, N'SP17', 2, N'SP017.jpg', CAST(N'2026-12-31' AS Date), 50, 26000, 38000, 0.237, N'L', CAST(N'2023-09-01' AS Date), N'07007412005', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (18, N'SP18', 1, N'SP018.jpg', CAST(N'2026-12-31' AS Date), 80, 11000, 15000, 0.18, N'kg', CAST(N'2023-09-15' AS Date), N'893521746414', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (19, N'SP19', 4, N'SP019.jpg', CAST(N'2025-12-31' AS Date), 60, 6000, 9000, 0.22, N'L', CAST(N'2023-10-01' AS Date), N'8935217400393', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (20, N'SP20', 2, N'SP020.jpg', CAST(N'2026-12-31' AS Date), 40, 9000, 13000, 0.3, N'L', CAST(N'2023-12-15' AS Date), N'8936127794107', 1)
INSERT [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet], [maSanPham], [maDonViTinh], [AnhSanPham], [hanSuDung], [soLuong], [giaNhap], [donGia], [khoiLuong], [donViTinhKhoiLuong], [ngaySanXuat], [barcode], [trangThai]) VALUES (47, N'SP01', 6, N'SP01.jpg', CAST(N'2026-12-31' AS Date), 38, 330000, 411000, 0.800000011920929, N'kg', CAST(N'2023-01-01' AS Date), N'8934673001137', 1)
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] ON 

INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (1, N'Vinamilk', N'Description for Vinamilk', 1)
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (2, N'Nestle', N'Description for Nestle', 1)
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (3, N'Dutch Lady', N'Description for Dutch Lady', 1)
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (4, N'Mead Johnson', N'Description for Mead Johnson', 1)
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (5, N'Abbott', N'Description for Abbott', 1)
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (6, N'Friso', N'Description for Friso', 1)
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (7, N'Nutifood', N'Description for Nutifood', 1)
INSERT [dbo].[ThuongHieu] ([maThuongHieu], [tenThuongHieu], [ghiChu], [trangThai]) VALUES (8, N'TH true milk', N'Description for TH true milk', 1)
SET IDENTITY_INSERT [dbo].[ThuongHieu] OFF
GO
SET IDENTITY_INSERT [dbo].[XuatXu] ON 

INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (1, N'Vietnam', N'x', 1)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (2, N'United States', N'x', 1)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (3, N'China', N'x', 1)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (4, N'Germany', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (5, N'Japan', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (6, N'Brazil', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (7, N'USA', N'x', 1)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (8, N'Albania', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (9, N'Algeria', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (10, N'Argentina', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (11, N'Australia', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (12, N'Canada', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (13, N'Colombia', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (14, N'Croatia', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (15, N'Cuba', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (16, N'France', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (17, N'India', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (18, N'Indonesia', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (19, N'Iran', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (20, N'Iraq', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (21, N'Israel', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (22, N'Italy', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (23, N'Mexico', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (24, N'New Zealand', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (25, N'Nigeria', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (26, N'Pakistan', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (27, N'Philippines', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (28, N'Poland', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (29, N'Russia', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (30, N'Spain', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (31, N'South Korea', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (32, N'Laos', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (33, N'Campuchia', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (34, N'Thái Lan', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (35, N'Singapore', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (36, N'Chile', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (37, N'Brunei', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (38, N'Ecuador', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (39, N'Ghana', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (40, N'Hungary', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (41, N'Iceland', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (42, N'Jamaica', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (43, N'Jordan', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (44, N'Kazakhstan', N'x', 0)
INSERT [dbo].[XuatXu] ([maXuatXu], [tenXuatXu], [ghiChu], [trangThai]) VALUES (45, N'Liberia', N'x', 0)
SET IDENTITY_INSERT [dbo].[XuatXu] OFF
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([maHinhThucThanhToan])
REFERENCES [dbo].[HinhThucThanhToan] ([maHinhThucThanhToan])
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[DonHangChiTiet]  WITH CHECK ADD FOREIGN KEY([maDonHang])
REFERENCES [dbo].[DonHang] ([maDonHang])
GO
ALTER TABLE [dbo].[DonHangChiTiet]  WITH CHECK ADD FOREIGN KEY([maSanPhamChiTiet])
REFERENCES [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet])
GO
ALTER TABLE [dbo].[KhuyenMaiSanPham]  WITH CHECK ADD FOREIGN KEY([maKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([maKhuyenMai])
GO
ALTER TABLE [dbo].[KhuyenMaiSanPham]  WITH CHECK ADD FOREIGN KEY([maSanPhamChiTiet])
REFERENCES [dbo].[SanPhamChiTiet] ([maSanPhamChiTiet])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maDongSanPham])
REFERENCES [dbo].[DongSanPham] ([maDongSanPham])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maLoaiHang])
REFERENCES [dbo].[LoaiHang] ([maLoaiHang])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([maThuongHieu])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maXuatXu])
REFERENCES [dbo].[XuatXu] ([maXuatXu])
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD FOREIGN KEY([maDonViTinh])
REFERENCES [dbo].[DonViTinh] ([maDonViTinh])
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
/****** Object:  StoredProcedure [dbo].[doanhThuTheoNgay]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- Create the stored procedure in the specified schema
CREATE PROCEDURE [dbo].[doanhThuTheoNgay]
-- add more stored procedure parameters here
@doanhThu float output,
@donHangThanhCong int output,
@donHangThatBai int output
AS
BEGIN
    -- body of the stored procedure
    set @doanhThu = (
    SELECT
        SUM(DonHang.tongTien) 
    FROM
        DonHang
    where 
        ngayTao = CAST(GETDATE() as date)
    AND
        DonHang.trangThai = 1
    ) - 
    (
    SELECT
        SUM(SanPhamChiTiet.giaNhap * (DonHangChiTiet.soLuong + DonHangChiTiet.traHang))
    FROM
        DonHang
    INNER JOIN
        DonHangChiTiet ON DonHang.maDonHang = DonHangChiTiet.maDonHang
    INNER JOIN
        SanPhamChiTiet ON DonHangChiTiet.maSanPhamChiTiet = SanPhamChiTiet.maSanPhamChiTiet
    where 
        ngayTao = CAST(GETDATE() as date)
    AND
        DonHang.trangThai = 1
    AND
        DonHangChiTiet.trangThai = 1
    )
    print @doanhThu
    set @donHangThanhCong = (select count(maDonHang) from DonHang where trangThai = 1 and ngayTao = CAST(GETDATE() as date));
    set @donHangThatBai = (select count(maDonHang) from DonHang where trangThai = 0 and ngayTao = CAST(GETDATE() as date));
END
GO
/****** Object:  StoredProcedure [dbo].[doanhThuTheoThang]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- Create the stored procedure in the specified schema
CREATE PROCEDURE [dbo].[doanhThuTheoThang]
@doanhThu float output,
@donHangThanhCong int output,
@donHangThatBai int output
AS
BEGIN
    -- body of the stored procedure
    set @doanhThu = (
    SELECT
        SUM(DonHang.tongTien) 
    FROM
        DonHang
     where 
        MONTH(ngayTao) = MONTH(GETDATE()) 
    AND 
        YEAR(ngayTao) = YEAR(GETDATE())
    AND
        DonHang.trangThai = 1
    ) - 
    (
    SELECT
        SUM(SanPhamChiTiet.giaNhap * (DonHangChiTiet.soLuong + DonHangChiTiet.traHang))
    FROM
        DonHang
    INNER JOIN
        DonHangChiTiet ON DonHang.maDonHang = DonHangChiTiet.maDonHang
    INNER JOIN
        SanPhamChiTiet ON DonHangChiTiet.maSanPhamChiTiet = SanPhamChiTiet.maSanPhamChiTiet
    where 
        MONTH(ngayTao) = MONTH(GETDATE()) 
    AND 
        YEAR(ngayTao) = YEAR(GETDATE())
    AND
        DonHang.trangThai = 1
    AND
        DonHangChiTiet.trangThai = 1
    )
    set @donHangThanhCong = (select count(maDonHang) from DonHang where trangThai = 1 and MONTH(ngayTao) = MONTH(GETDATE()) 
    AND 
        YEAR(ngayTao) = YEAR(GETDATE()));
    set @donHangThatBai = (select count(maDonHang) from DonHang where trangThai = 0 and MONTH(ngayTao) = MONTH(GETDATE()) 
    AND 
        YEAR(ngayTao) = YEAR(GETDATE()));
END
GO
/****** Object:  StoredProcedure [dbo].[doanhThuTheoThangChiTiet]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[doanhThuTheoThangChiTiet]
    @Year INT
AS
BEGIN
      -- Tạo biến bảng tạm thời
    DECLARE @TongTienTable TABLE (
        Thang INT,
        TongTien DECIMAL(18, 2)
    );

    -- Thêm dữ liệu vào biến bảng tạm thời từ truy vấn SELECT
    INSERT INTO @TongTienTable (Thang, TongTien)
    SELECT
        MONTH(DonHang.ngayTao) AS Thang,
        SUM(DonHang.tongTien) AS TongTien
    FROM
        DonHang
    WHERE
        YEAR(DonHang.ngayTao) = @Year
        AND DonHang.trangThai = 1
    GROUP BY
        MONTH(DonHang.ngayTao)
    ORDER BY
        Thang;
    
    
    -- Tạo biến bảng tạm thời
    DECLARE @ChiPhiTable TABLE (
        Thang INT,
        SoDonHang int,
        ChiPhi DECIMAL(18, 2)
    );

    -- Thêm dữ liệu vào biến bảng tạm thời từ truy vấn SELECT
    INSERT INTO @ChiPhiTable (Thang, SoDonHang, ChiPhi)
    SELECT
        MONTH(DonHang.ngayTao) AS Thang,
        COUNT(DISTINCT DonHang.maDonHang) AS SoDonHang,
        SUM(SanPhamChiTiet.giaNhap * (DonHangChiTiet.soLuong + DonHangChiTiet.traHang)) AS ChiPhi
    FROM
        DonHang
    INNER JOIN
        DonHangChiTiet ON DonHang.maDonHang = DonHangChiTiet.maDonHang
    INNER JOIN
        SanPhamChiTiet ON DonHangChiTiet.maSanPhamChiTiet = SanPhamChiTiet.maSanPhamChiTiet
    WHERE
        YEAR(DonHang.ngayTao) = @Year
    AND
        DonHang.trangThai = 1
    GROUP BY
        MONTH(DonHang.ngayTao)
    ORDER BY
        Thang;

    -- Kết hợp hai bảng tạm thời dựa trên cột Thang
    SELECT
        TT.Thang as Thang,
        TT.TongTien - CP.ChiPhi AS DoanhThu,
        CP.SoDonHang AS SoDonHang,
        (TT.TongTien - CP.ChiPhi)/ EOMONTH(DATEFROMPARTS(@Year, TT.Thang, 1)) AS DoanhThuTrungBinh
    FROM
        @TongTienTable TT
    INNER JOIN
        @ChiPhiTable CP ON TT.Thang = CP.Thang;
END;
GO
/****** Object:  StoredProcedure [dbo].[donHangTheoThang]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[donHangTheoThang]
    @Year INT
AS
BEGIN
    SELECT
        MONTH(ngayTao) AS Thang,
        SUM(CASE WHEN loaiDonHang = 4 AND trangThai = 1 THEN 1 ELSE 0 END) AS TaiQuayThanhCong,
        SUM(CASE WHEN loaiDonHang = 2 AND trangThai = 1 THEN 1 ELSE 0 END) AS OnlineThanhCong,
        SUM(CASE WHEN trangThai = 0 THEN 1 ELSE 0 END) AS BiHuy
    FROM
        DonHang
    WHERE
        YEAR(ngayTao) = 2023
    GROUP BY
        MONTH(ngayTao)
    ORDER BY
        Thang;
END;
GO
/****** Object:  StoredProcedure [dbo].[KhachHangTheoDoTuoi]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[KhachHangTheoDoTuoi]
AS
BEGIN
    DECLARE @Tu18Den30 INT, @Tu30Den50 INT, @Tu50TroLen INT;

    -- Gán giá trị cho biến
    Set
        @Tu18Den30 = (select COUNT(*) FROM KhachHang WHERE DATEDIFF(YEAR, ngaySinh, GETDATE()) BETWEEN 18 AND 30);

    Set
        @Tu30Den50 = (select COUNT(*) FROM KhachHang WHERE DATEDIFF(YEAR, ngaySinh, GETDATE()) BETWEEN 30 AND 50);

    Set
        @Tu50TroLen = (select COUNT(*) FROM KhachHang WHERE DATEDIFF(YEAR, ngaySinh, GETDATE()) >= 50);

    -- Trả kết quả
    SELECT
        tu18den30 = @Tu18Den30,
        tu30den50 = @Tu30Den50,
        tu50trolen = @Tu50TroLen;
END;
GO
/****** Object:  StoredProcedure [dbo].[KhachHangTheoGioiTinh]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[KhachHangTheoGioiTinh]
AS
BEGIN
    DECLARE @Nam INT, @Nu INT;

    -- Gán giá trị cho biến
    Set
        @Nam = (select COUNT(*) FROM KhachHang WHERE gioiTinh = 1);

    SEt
        @Nu = (select COUNT(*) FROM KhachHang WHERE gioiTinh = 0);

    -- Trả kết quả
    SELECT
        SLNam = @Nam,
        SLNu = @Nu;
END;
GO
/****** Object:  StoredProcedure [dbo].[SanPhamTheoLuotBan]    Script Date: 12/3/2023 10:52:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SanPhamTheoLuotBan]
    @MaLoaiHang INT = NULL,
    @MaDongSanPham INT = NULL,
    @MaThuongHieu INT = NULL,
    @StartDate DATE = NULL,
    @EndDate DATE = NULL
AS
BEGIN
    SELECT
        spct.maSanPhamChiTiet,
        sp.tenSanPham,
        dt.tenDonViTinh,
        spct.trangThai,
        spct.soLuong,
        lh.tenLoaiHang,
        dsp.tenDongSanPham,
        th.tenThuongHieu,
        LuotBan = (
            SELECT SUM(ISNULL(dhct.soLuong, 0))
            FROM DonHangChiTiet dhct
            LEFT JOIN DonHang dh ON dhct.maDonHang = dh.maDonHang
            WHERE spct.maSanPhamChiTiet = dhct.maSanPhamChiTiet
                AND (@StartDate IS NULL OR dh.ngayTao >= @StartDate)
                AND (@EndDate IS NULL OR dh.ngayTao <= @EndDate)
        ),
        spct.donGia
    FROM
        SanPhamChiTiet spct
    INNER JOIN
        SanPham sp ON spct.maSanPham = sp.maSanPham
    INNER JOIN
        DonViTinh dt ON spct.maDonViTinh = dt.maDonViTinh
    INNER JOIN
        LoaiHang lh ON sp.maLoaiHang = lh.maLoaiHang
    INNER JOIN
        DongSanPham dsp ON sp.maDongSanPham = dsp.maDongSanPham
    INNER JOIN
        ThuongHieu th ON sp.maThuongHieu = th.maThuongHieu
    WHERE
        (@MaLoaiHang IS NULL OR sp.maLoaiHang = @MaLoaiHang) AND
        (@MaDongSanPham IS NULL OR sp.maDongSanPham = @MaDongSanPham) AND
        (@MaThuongHieu IS NULL OR sp.maThuongHieu = @MaThuongHieu)
    ORDER BY
        LuotBan DESC;
END;

GO
