ALTER LOGIN sa WITH PASSWORD = 'A1a2345678';

create database DuAnBanSua1
go

use DuAnBanSua1
go

create table XuatXu
(
    maXuatXu int identity(1,1) not null,
    tenXuatXu nvarchar(50) not null,
    ghiChu nvarchar(max) null,
    trangThai bit not null,
    primary key(maXuatXu)
)
go

create table DonViTinh
(
    maDonViTinh int identity(1,1) not null,
    tenDonViTinh nvarchar(50) not null,
    ghiChu nvarchar(max) not null,
    trangThai bit not null,
    primary key(maDonViTinh)
)
go

create table ThuongHieu
(
    maThuongHieu int identity(1,1) not null,
    tenThuongHieu nvarchar(50) not null,
    ghiChu nvarchar(max) not null,
    trangThai bit not null,
    primary key(maThuongHieu)
)
go

create table LoaiHang
(
    maLoaiHang int identity(1,1) not null,
    tenLoaiHang nvarchar(50) not null,
    ghiChu nvarchar(max) not null,
    trangThai bit not null,
    primary key(maLoaiHang)
)
go

create table DongSanPham
(
    maDongSanPham int identity(1,1) not null,
    tenDongSanPham nvarchar(50) not null,
    ghiChu nvarchar(max) not null,
    trangThai bit not null,
    primary key(maDongSanPham)
)
go

create table SanPham
(
    maSanPham int identity(1,1) not null,
    tenSanPham nvarchar(255) not null,
    moTa nvarchar(255) not null,
    trangThai bit not null,
    maThuongHieu int not null,
    maLoaiHang int not null,
    maDongSanPham int not null,
    maXuatXu int not null,
    primary key(maSanPham),
    foreign key (maThuongHieu) references ThuongHieu(maThuongHieu),
    foreign key (maLoaiHang) references LoaiHang(maLoaiHang),
    foreign key (maDongSanPham) references DongSanPham(maDongSanPham),
    foreign key (maXuatXu) references XuatXu(maXuatXu),
)
go

create table SanPhamChiTiet
(
    maSanPhamChiTiet int identity(1,1) not null,
    maSanPham int not null,
    maDonViTinh int not null,
    AnhSanPham varchar(100) not null,
    hanSuDung date not null,
    soLuong int not null,
    giaNhap float not null,
    donGia float not null,
    khoiLuong float not null,
    donViTinhKhoiLuong nvarchar(20) not null,
    ngaySanXuat date not null,
    barcode varchar(50) not null,
    trangThai bit not null,
    primary key(maSanPhamChiTiet),
    foreign key (maSanPham) references SanPham(maSanPham),
    foreign key (maDonViTinh) references DonViTinh(maDonViTinh),
)
go

create table NhanVien
(
    maNhanVien varchar(50) not null,
    matKhau varchar(50) not null,
    hoTen nvarchar(50) not null,
    gioiTinh bit not null,
    ngaySinh date not null,
    soDienThoai varchar(20) not null,
    email varchar(50) not null,
    hinhAnh varchar(100) not null,
    VaiTro bit not null,
    trangThai bit not null,
    ghiChu nvarchar(max) not null,
    primary key(maNhanVien)
)
go

create table KhachHang
(
    maKhachHang int identity(1,1) not null,
    hoTen nvarchar(50) not null,
    gioiTinh bit not null,
    ngaySinh date not null,
    soDienThoai varchar(20) not null,
    email varchar(50) not null,
    diem float not null,
    ghiChu nvarchar(max) not null,
    ngayDangKy date not null,
    primary key(maKhachHang)
)
go

create table KhuyenMai
(
    maKhuyenMai int identity(1,1) not null,
    tenChuongTrinh nvarchar(50) not null,
    ngayBatDau date not null,
    ngayKetThuc date not null,
    moTa nvarchar(255) not null,
    trangThai bit not null,
    primary key(maKhuyenMai)
)
go

create table KhuyenMaiChiTiet
(
    maKhuyenMaiChiTiet int not null,
    maSanPhamChiTiet int null,
    giaGiamGia int not null,
    donViGiam nvarchar(50) not null,
    primary key(maKhuyenMaiChiTiet),
    foreign key (maSanPhamChiTiet) references SanPhamChiTiet(maSanPhamChiTiet)
)
go

create table HinhThucThanhToan
(
    maHinhThucThanhToan int identity(1,1) not null,
    tenHinhThucThanhToan nvarchar(50) not null,
    primary key(maHinhThucThanhToan)
)
go

create table DonHang
(
    maDonHang int identity(1,1) not null,
    maKhachHang int null,
    maNhanVien varchar(50) null,
    maHinhThucThanhToan int null,
    trangThai bit not null,
    ghiChu nvarchar(max) null,
    ngayTao date null,
    phiKhac float null,
    tongTien float null,
    loaiDonHang nvarchar(50) null,
    dienThoai varchar(50) null,
    diaChi nvarchar(50) null,
    primary key(maDonHang),
    foreign key (maKhachHang) references KhachHang(maKhachHang),
    foreign key (maNhanVien) references NhanVien(maNhanVien),
    foreign key (maHinhThucThanhToan) references HinhThucThanhToan(maHinhThucThanhToan)
)
go

create table DonHangChiTiet
(
    maDonHangChiTiet int identity(1,1) not null,
    maDonHang int not null,
    maSanPhamChiTiet int not null,
    soLuong int not null,
    donGia float not null,
    giaGiam float not null,
    tongGia float not null,
    trangThai bit  null,
    primary key(maDonHangChiTiet),
    foreign key (maDonHang) references DonHang(maDonHang),
    foreign key (maSanPhamChiTiet) references SanPhamChiTiet(maSanPhamChiTiet)
)
go

INSERT INTO XuatXu (tenXuatXu, trangThai)
VALUES
('Vietnam',	1),
	('United States',	1),
(	'China	 	',1),
(	'Germany		',0),
(	'Japan		',0),
(	'Brazil	',0),
(	'USA		',1)
go

INSERT INTO DonViTinh (tenDonViTinh, ghiChu, trangThai)
VALUES
    (N'Hộp', 'Description for Hộp', 1),
    (N'Chai', 'Description for Chai', 1),
    (N'Lọ', 'Description for Lọ', 1),
    (N'Túi', 'Description for Túi', 1),
    (N'Gói', 'Description for Gói', 1),
    (N'Cái', 'Description for Cái', 1)
go

INSERT INTO ThuongHieu (tenThuongHieu, ghiChu, trangThai)
VALUES
    ('Vinamilk', 'Description for Vinamilk', 1),
    ('Nestle', 'Description for Nestle', 1),
    ('Dutch Lady', 'Description for Dutch Lady', 1),
    ('Mead Johnson', 'Description for Mead Johnson', 1),
    ('Abbott', 'Description for Abbott', 1),
    ('Friso', 'Description for Friso', 1)
go

    

INSERT INTO LoaiHang (tenLoaiHang, ghiChu,trangThai)
VALUES (N'Cho trẻ em', 'Fresh cow milk',1),
(N'Cho người già', 'Fresh cow milk',1),
(N'Cho bà bầu', 'Fresh cow milk',1),
(N'Mọi lứa tuổi', 'Fresh cow milk',1)
go

INSERT INTO DongSanPham (tenDongSanPham, ghiChu, trangThai)
VALUES
    (N'Sữa bột', 'Mô tả cho Sữa Vinamilk', 1),
    (N'Sữa tươi', 'Mô tả cho Sữa Nestle', 1),
    (N'Sữa không đường', 'Mô tả cho Sữa Dutch Lady', 1),
    (N'Sữa hạt', 'Mô tả cho Sữa Mead Johnson', 1)
go


INSERT INTO SanPham (tenSanPham, moTa, trangThai, maThuongHieu, maLoaiHang, maDongSanPham, maXuatXu)
VALUES
    (N'Sữa Vinamilk 1', 'Mô tả cho Sữa Vinamilk 1', 1, 1, 1, 1, 1),
    (N'Sữa Nestle 1', 'Mô tả cho Sữa Nestle 1', 1, 2, 1, 2, 2),
    (N'Sữa Dutch Lady 1', 'Mô tả cho Sữa Dutch Lady 1', 1, 3, 1, 3, 3),
    (N'Sữa Mead Johnson 1', 'Mô tả cho Sữa Mead Johnson 1', 1, 4, 1, 4, 4),
    (N'Sữa Abbott 1', 'Mô tả cho Sữa Abbott 1', 1, 5, 1, 3, 5),
    (N'Sữa Friso 1', 'Mô tả cho Sữa Friso 1', 1, 6, 1, 4, 6)
go

INSERT INTO SanPhamChiTiet (maSanPham, maDonViTinh, AnhSanPham, hanSuDung, soLuong, giaNhap, donGia, khoiLuong, donViTinhKhoiLuong, ngaySanXuat, barcode, trangThai)
VALUES
    (1, 1, 'SP01.jpg', '2023-12-31', 50, 20000, 25000, 0.5, 'kg', '2023-01-01', 'SPCT0001', 1),
    (2, 2, 'SP02.png', '2023-12-31', 80, 35000, 45000, 1, 'L', '2023-01-15', 'SPCT0002', 1),
    (3, 3, 'SP03.png', '2023-12-31', 60, 28000, 35000, 0.75, 'L', '2023-02-01', 'SPCT0003', 1),
    (4, 4, 'SP05.jpg', '2023-12-31', 40, 32000, 38000, 0.8, 'L', '2023-02-15', 'SPCT0004', 1),
    (5, 5, 'SP06.jpg', '2023-12-31', 70, 38000, 42000, 0.9, 'L', '2023-03-01', 'SPCT0005', 1),
    (6, 6, 'anh_san_pham_6.jpg', '2023-12-31', 30, 30000, 32000, 0.7, 'L', '2023-03-15', 'SPCT0006', 1),
    (1, 1, 'anh_san_pham_7.jpg', '2023-12-31', 50, 20000, 25000, 0.5, 'kg', '2023-01-01', 'SPCT0007', 1),
    (2, 2, 'anh_san_pham_8.jpg', '2023-12-31', 80, 35000, 45000, 1, 'L', '2023-01-15', 'SPCT0008', 1),
    (3, 3, 'anh_san_pham_9.jpg', '2023-12-31', 60, 28000, 35000, 0.75, 'L', '2023-02-01', 'SPCT0009', 1),
    (4, 4, 'anh_san_pham_10.jpg', '2023-12-31', 40, 32000, 38000, 0.8, 'L', '2023-02-15', 'SPCT0010', 1),
    (5, 5, 'anh_san_pham_11.jpg', '2023-12-31', 70, 38000, 42000, 0.9, 'L', '2023-03-01', 'SPCT0011', 1),
    (6, 6, 'anh_san_pham_12.jpg', '2023-12-31', 30, 30000, 32000, 0.7, 'L', '2023-03-15', 'SPCT0012', 1)
go

INSERT INTO NhanVien (maNhanVien, matKhau, hoTen, gioiTinh, ngaySinh, soDienThoai, email, hinhAnh, VaiTro, trangThai, ghiChu)
VALUES
    ('NV001', 'password1', 'Nguyễn Văn A', 1, '1990-01-15', '0123456789', 'nvA@gmail.com', 'avatar_A.jpg', 1, 1, 'Ghi chú cho Nhân viên A'),
    ('NV002', 'password2', 'Trần Thị B', 0, '1995-03-20', '0987654321', 'nvB@gmail.com', 'avatar_B.jpg', 0, 1, 'Ghi chú cho Nhân viên B'),
    ('NV003', 'password3', 'Lê Văn C', 1, '1988-07-10', '0345678901', 'nvC@gmail.com', 'avatar_C.jpg', 1, 1, 'Ghi chú cho Nhân viên C'),
    ('NV004', 'password4', 'Phạm Thị D', 0, '1992-05-02', '0765432109', 'nvD@gmail.com', 'avatar_D.jpg', 0, 1, 'Ghi chú cho Nhân viên D')
go

INSERT INTO KhachHang (hoTen, gioiTinh, ngaySinh, soDienThoai, email, diem, ghiChu, ngayDangKy)
VALUES
    (N'Nguyễn Thị A', 0, '1992-03-12', '0123456789', 'thiA@gmail.com', 100, N'Ghi chú cho Khách hàng A', '2022-01-05'),
    (N'Trần Văn B', 1, '1985-05-20', '0987654321', 'vanB@gmail.com', 150, N'Ghi chú cho Khách hàng B', '2022-02-10'),
    (N'Lê Thị C', 0, '1990-08-15', '0345678901', 'thiC@gmail.com', 120, N'Ghi chú cho Khách hàng C', '2022-03-18'),
    (N'Phạm Văn D', 1, '1988-11-02', '0765432109', 'vanD@gmail.com', 90, N'Ghi chú cho Khách hàng D', '2022-04-25'),
    (N'Trần Thị E', 0, '1995-02-25', '0123456780', 'thiE@gmail.com', 80, N'Ghi chú cho Khách hàng E', '2022-05-30'),
    (N'Nguyễn Văn F', 1, '1983-07-10', '0987654321', 'vanF@gmail.com', 110, N'Ghi chú cho Khách hàng F', '2022-06-12'),
    (N'Lê Văn G', 1, '1998-09-28', '0345678901', 'vanG@gmail.com', 130, N'Ghi chú cho Khách hàng G', '2022-07-20'),
    (N'Phạm Thị H', 0, '1991-12-05', '0765432109', 'thiH@gmail.com', 95, N'Ghi chú cho Khách hàng H', '2022-08-15'),
    (N'Nguyễn Văn I', 1, '1987-04-18', '0123456789', 'vanI@gmail.com', 140, N'Ghi chú cho Khách hàng I', '2022-09-22'),
    (N'Trần Thị K', 0, '1994-06-30', '0987654321', 'thiK@gmail.com', 75, N'Ghi chú cho Khách hàng K', '2022-10-05'),
    (N'Lê Văn L', 1, '1986-08-22', '0345678901', 'vanL@gmail.com', 160, N'Ghi chú cho Khách hàng L', '2022-11-12'),
    (N'Phạm Thị M', 0, '1993-10-15', '0765432109', 'thiM@gmail.com', 105, N'Ghi chú cho Khách hàng M', '2022-12-18'),
    (N'Nguyễn Văn N', 1, '1984-01-28', '0123456780', 'vanN@gmail.com', 125, N'Ghi chú cho Khách hàng N', '2023-01-25'),
    (N'Trần Văn P', 1, '1999-03-03', '0987654321', 'vanP@gmail.com', 88, N'Ghi chú cho Khách hàng P', '2023-02-28'),
    (N'Lê Thị Q', 0, '1990-05-18', '0345678901', 'thiQ@gmail.com', 115, N'Ghi chú cho Khách hàng Q', '2023-03-15'),
    (N'Phạm Văn R', 1, '1988-08-01', '0765432109', 'vanR@gmail.com', 135, N'Ghi chú cho Khách hàng R', '2023-04-22'),
    (N'Trần Thị S', 0, '1995-09-15', '0123456789', 'thiS@gmail.com', 99, N'Ghi chú cho Khách hàng S', '2023-05-10'),
    (N'Nguyễn Văn T', 1, '1983-11-28', '0987654321', 'vanT@gmail.com', 120, N'Ghi chú cho Khách hàng T', '2023-06-18'),
    (N'Lê Thị U', 0, '1998-02-10', '0345678901', 'thiU@gmail.com', 80, N'Ghi chú cho Khách hàng U', '2023-07-25'),
    (N'Phạm Văn V', 1, '1987-04-25', '0765432109', 'vanV@gmail.com', 155, N'Ghi chú cho Khách hàng V', '2023-08-30')
go


INSERT INTO KhuyenMai (tenChuongTrinh, ngayBatDau, ngayKetThuc, moTa, trangThai)
VALUES (N'Khuyến mãi mùa hè', '2023-06-01', '2023-06-30', N'Giảm giá cho sản phẩm mùa hè', 1);

-- Chèn vào bảng KhuyenMaiChiTiet
INSERT INTO KhuyenMaiChiTiet (maKhuyenMaiChiTiet, maSanPhamChiTiet, giaGiamGia, donViGiam)
VALUES (1, 1, 5000, 'VND');




select tenSanPham,tenThuongHieu,tenLoaiHang,tenDongSanPham from SanPham
inner join SanPhamChiTiet on SanPham.maSanPham = SanPhamChiTiet.maSanPham
inner join ThuongHieu on ThuongHieu.maThuongHieu = SanPham.maThuongHieu
inner join LoaiHang on LoaiHang.maLoaiHang = SanPham.maLoaiHang
inner join DongSanPham on DongSanPham.maDongSanPham = SanPham.maDongSanPham
select * from SanPhamChiTiet








