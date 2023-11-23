create database DuAnBanSua_MilkFE
go

use DuAnBanSua_MilkFE
go

create table XuatXu
(
    maXuatXu int identity(1,1) not null,
    tenXuatXu nvarchar(50) not null,
    ghiChu nvarchar(max)  null,
    trangThai bit not null,
    primary key(maXuatXu)
)
go

create table DonViTinh
(
    maDonViTinh int identity(1,1) not null,
    tenDonViTinh nvarchar(50) not null,
    ghiChu nvarchar(max)  null,
    trangThai bit not null,
    primary key(maDonViTinh)
)
go

create table ThuongHieu
(
    maThuongHieu int identity(1,1) not null,
    tenThuongHieu nvarchar(50) not null,
    ghiChu nvarchar(max) null,
    trangThai bit not null,
    primary key(maThuongHieu)
)
go

create table LoaiHang
(
    maLoaiHang int identity(1,1) not null,
    tenLoaiHang nvarchar(50) not null,
    ghiChu nvarchar(max) null,
    trangThai bit not null,
    primary key(maLoaiHang)
)
go

create table DongSanPham
(
    maDongSanPham int identity(1,1) not null,
    tenDongSanPham nvarchar(50) not null,
    ghiChu nvarchar(max) null,
    trangThai bit not null,
    primary key(maDongSanPham)
)
go

create table SanPham
(
    maSanPham nvarchar(20) not null,
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
    maSanPham nvarchar(20) not null,
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
    ghiChu nvarchar(max) null,
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
    ghiChu nvarchar(max) null,
    ngayDangKy date not null,
    primary key(maKhachHang)
)
go


create table KhuyenMai
(
    maKhuyenMai varchar(15) not null,
    tenChuongTrinh nvarchar(50) not null,
    ngayBatDau date not null,
    ngayKetThuc date not null,
    moTa nvarchar(255) not null,
    trangThai bit ,
	donViGiam varchar(15) not null,
	giaTriGiam int not null,
    primary key(maKhuyenMai)
)
go
create table KhuyenMaiSanPham
(
    maKhuyenMaiSanPham int identity(1,1) not null,
    maKhuyenMai varchar(15) not null,
    maSanPhamChiTiet int null,
	trangThai bit,
    primary key(maKhuyenMaiSanPham),
    foreign key (maSanPhamChiTiet) references SanPhamChiTiet(maSanPhamChiTiet),
    foreign key (maKhuyenMai) references KhuyenMai(maKhuyenMai)
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
    trangThai bit null,
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

INSERT INTO XuatXu (tenXuatXu,ghiChu,trangThai)
VALUES  ('Vietnam','x',1),
		('United States','x',1),
		('China','x',1),
		('Germany','x',0),
		('Japan','x',0),
		('Brazil','x',0),
		('USA','x',1),
		('Albania','x',0),
		('Algeria','x',0),
		('Argentina','x',0),
		('Australia','x',0),
		('Canada','x',0),
		('Colombia','x',0),
		('Croatia','x',0),
		('Cuba','x',0),
		('France','x',0),
		('India','x',0),
		('Indonesia','x',0),
		('Iran','x',0),
		('Iraq','x',0),
		('Israel','x',0),
		('Italy','x',0),
		('Mexico','x',0),
		('New Zealand','x',0),
		('Nigeria','x',0),
		('Pakistan','x',0),
		('Philippines','x',0),
		('Poland','x',0),
		('Russia','x',0),
		('Spain','x',0),
		('South Korea','x',0),
		('Laos','x',0),
		('Campuchia','x',0),
		('Thái Lan','x',0),
		('Singapore','x',0),
		('Chile','x',0),
		('Brunei','x',0),
		('Ecuador','x',0),
		('Ghana','x',0),
		('Hungary','x',0),
		('Iceland','x',0),
		('Jamaica','x',0),
		('Jordan','x',0),
		('Kazakhstan','x',0),
		('Liberia','x',0)
go

INSERT INTO DonViTinh (tenDonViTinh, ghiChu, trangThai)
VALUES
    (N'Hộp giấy', N'Description for Hộp', 1),
    (N'Chai', N'Description for Chai', 1),
    (N'Lọ', N'Description for Lọ', 1),
    (N'Túi', N'Description for Túi', 1),
    (N'Gói', N'Description for Gói', 1),
    (N'Hộp thiếc', N'Description for Cái', 1)
go

INSERT INTO ThuongHieu (tenThuongHieu, ghiChu, trangThai)
VALUES
    ('Vinamilk', 'Description for Vinamilk', 1),
    ('Nestle', 'Description for Nestle', 1),
    ('Dutch Lady', 'Description for Dutch Lady', 1),
    ('Mead Johnson', 'Description for Mead Johnson', 1),
    ('Abbott', 'Description for Abbott', 1),
    ('Friso', 'Description for Friso', 1),
	('Nutifood', 'Description for Nutifood', 1),
	('TH true milk', 'Description for TH true milk', 1)
go

    
    

INSERT INTO LoaiHang (tenLoaiHang, ghiChu,trangThai)
VALUES (N'Cho trẻ em', 'Fresh cow milk',1),
(N'Cho người già', 'Fresh cow milk',1),
(N'Cho bà bầu', 'Fresh cow milk',1),
(N'Mọi lứa tuổi', 'Fresh cow milk',1),
(N'Cho người loãng xương', 'Fresh cow milk',1),
(N'Cho người bệnh', 'Fresh cow milk',1)
go

INSERT INTO DongSanPham (tenDongSanPham, ghiChu, trangThai)
VALUES
    (N'Sữa bột', N'Mô tả cho sữa bột', 1),
    (N'Sữa tươi', N'Mô tả cho sữa tươi', 1),
    (N'Sữa không đường', N'Mô tả cho sữa không đường', 1),
    (N'Sữa hạt', N'Mô tả cho sữa hạt', 1),
	(N'Sữa ít đường', N'Mô tả cho ít đường', 1)
go
INSERT INTO SanPham (maSanPham,tenSanPham, moTa, trangThai, maThuongHieu, maLoaiHang, maDongSanPham, maXuatXu)
VALUES
    ('SP01',N'Sữa bột Vinamilk Colos Gold', N'Mô tả cho Sữa Vinamilk', 1, 1, 1, 1, 7),
    ('SP02',N'Sữa tươi Vinamlik không đường ', N'Mô tả cho Sữa Vinamilk', 1, 1, 4, 3, 2),
    ('SP03',N'Sữa bột Vinamilk Yoko Gold', N'Mô tả cho Sữa Vinamilk', 1, 1, 1, 1, 3),
    ('SP04',N'Sữa tuôi tiệt trùng Vinamilk 100% hương dâu', N'Mô tả cho Sữa Vinamilk', 1, 1, 4, 2, 5),
    ('SP05',N'Sữa tươi tiệt trùng có đường Cô Gái Hà Lan', N'Mô tả cho Sữa Dutch Lady', 1, 3, 4, 2, 1),
    ('SP06',N'Sữa bột DUTCH LADY nguyên kem', N'Mô tả cho Sữa Dutch Lady', 1, 3, 4, 1, 11),
	('SP07',N'Sữa tươi tiệt trùng Cô Gái Hà Lan vị Socola', N'Mô tả cho Sữa Dutch Lady', 1, 3, 4, 2, 29),
	('SP08',N'Sữa bột Grow Plus hộp đỏ', N'Mô tả cho Sữa Nutifood', 1, 7, 1, 1, 35),
	('SP09',N'Sữa Enplus Gold 900g', N'Mô tả cho Sữa Nutifood', 1, 7, 2, 1, 7),
    ('SP10',N'Sữa Famna số 4 850g', N'Mô tả cho Sữa Nutifood', 1, 7, 1, 1, 2),
    ('SP11',N'Sữa Nuvi Grow 900g', N'Mô tả cho Sữa Nutifood', 1, 7, 1, 1, 3),
    ('SP12',N'Thức Uống Lúa Mạch Nestlé MILO Sữa 3 Trong 1', N'Mô tả cho Sữa Nestle', 1, 2, 4, 2, 1),
    ('SP13',N'Sữa tươi NutriStrong', N'Mô tả cho Sữa Nestle', 1, 2, 4, 3, 5),
    ('SP14',N'Sữa Enfamama A+ DHA hương vani cho mẹ bầu', N'Mô tả cho Sữa Mead Johnson', 1, 4, 3, 1, 11),
	('SP15',N'Sữa bột Frisolac Gold số 4 850g', N'Mô tả cho Sữa Friso', 1, 6, 1, 1, 29),
	('SP16',N'Sữa bột Abbott Grow 3 900g', N'Mô tả cho Sữa Abbott', 1, 5, 1, 1, 35),
	('SP17',N'Sữa bột pha sẵn PediaSure socola 237ml', N'Mô tả cho Sữa Abbott', 1, 5, 1, 1, 7),
    ('SP18',N'Sữa hạt óc chó TH true nut 180ml ', N'Mô tả cho Sữa TH True Milk', 1, 8, 4, 4, 2),
    ('SP19',N'Sữa tươi tiệt trùng trùng ít đường TH true milk', N'Mô tả cho Sữa TH True Milk', 1, 8, 4, 5, 3),
    ('SP20',N'Sữa trái cây TH True Milk vị dâu 300ml', N'Mô tả cho Sữa TH True Milk', 1, 8, 4, 2, 1)
    
	
go
select * from SanPhamChiTiet
select * from DonViTinh
INSERT INTO SanPhamChiTiet (maSanPham, maDonViTinh, AnhSanPham, hanSuDung, soLuong, giaNhap, donGia, khoiLuong, donViTinhKhoiLuong, ngaySanXuat, barcode, trangThai)
VALUES	
    ('SP01', 6, 'SP01.jpg', '2026-12-31', 50, 330000, 411000, 0.8, 'kg', '2023-01-01', '8934673001137', 1),
    ('SP02', 1, 'SP02.png', '2025-12-31', 80, 28000, 35000, 1, 'L', '2023-01-15', '8934673576390', 1),
    ('SP03', 6, 'SP03.png', '2026-12-31', 60, 195000, 225000, 0.35, 'kg', '2023-02-01', '8934673000284', 1),
    ('SP04', 1, 'SP04.jpg', '2025-12-31', 40, 3200, 5000, 0.11, 'L', '2023-02-15', '8934673574327', 1),
    ('SP05', 1, 'SP05.jpg', '2026-12-31', 70, 25000, 30000, 1, 'L', '2023-03-01', '8718182063103', 1),
	('SP06', 1, 'SP06.jpg', '2025-12-31', 30, 72000, 91000, 0.4, 'kg', '2023-03-20', '8936036771862', 1),
    ('SP07', 1, 'SP07.png', '2026-12-31', 20, 6000, 8000, 0.18, 'L', '2023-04-01', '18934841901877', 1),
    ('SP08', 6, 'SP08.png', '2025-12-31', 40, 280000, 360000, 0.9, 'kg', '2023-04-11', '8935049002345', 1),
    ('SP09', 6, 'SP09.jpg', '2026-12-31', 90, 380000, 480000, 0.9, 'kg', '2023-04-15', '8935049001676', 1),
    ('SP10', 6, 'SP010.jpg', '2025-12-31', 70, 350000, 410000, 0.85, 'kg', '2023-05-01', '7350107130609', 1),
	('SP11', 6, 'SP011.jpg', '2026-12-31', 50, 230000, 290000, 0.9, 'kg', '2023-05-21', '8935049014010', 1),
    ('SP12', 4, 'SP012.png', '2025-12-31', 80, 45000, 58000, 0.33, 'kg', '2023-06-15', '8934804040783', 1),
    ('SP13', 1, 'SP013.png', '2026-12-31', 60, 5000, 8000, 0.18, 'L', '2023-07-01', '8934804033051', 1),
    ('SP14', 6, 'SP014.jpg', '2025-12-31', 40, 380000, 480000, 0.83, 'kg', '2023-07-15', '0300875132203>', 1),
    ('SP15', 6, 'SP015.jpg', '2025-12-31', 70, 380000, 480000, 0.85, 'kg', '2023-08-01', '8936036774658', 1),
    ('SP16', 6, 'SP016.jpg', '2026-12-31', 30, 230000, 280000, 0.9, 'kg', '2023-08-15', '5099864008739', 1),
    ('SP17', 2, 'SP017.jpg', '2026-12-31', 50, 26000, 38000, 0.237, 'L', '2023-09-01', '07007412005', 1),
    ('SP18', 1, 'SP018.jpg', '2026-12-31', 80, 11000, 15000, 0.18, 'kg', '2023-09-15', '893521746414', 1),
    ('SP19', 4, 'SP019.jpg', '2025-12-31', 60, 6000, 9000, 0.22, 'L', '2023-10-01', '8935217400393', 1),
    ('SP20', 2, 'SP020.jpg', '2026-12-31', 40, 9000, 13000, 0.3, 'L', '2023-12-15', '8936127794107', 1)
go

INSERT INTO NhanVien (maNhanVien, matKhau, hoTen, gioiTinh, ngaySinh, soDienThoai, email, hinhAnh, VaiTro, trangThai, ghiChu)
VALUES
	
    ('NV001', '123456', N'Nguyễn Văn An', 1, '1990-01-15', '0999999999', 'nvA@gmail.com', 'avatar_A.jpg', 1, 1, N'Ghi chú cho Nhân viên An'),
    ('NV002', '123456', N'Trần Thị Bình', 0, '1995-03-20', '0988888888', 'nvB@gmail.com', 'avatar_B.jpg', 0, 1, N'Ghi chú cho Nhân viên Bình'),
    ('NV003', '123456', N'Lê Văn Cường', 1, '1988-07-10', '0987777777', 'nvC@gmail.com', 'avatar_C.jpg', 1, 1, N'Ghi chú cho Nhân viên Cường'),
    ('NV004', '123456', N'Phạm Thị Duyên', 0, '1992-05-02', '0987666666', 'nvD@gmail.com', 'avatar_D.jpg', 0, 1, N'Ghi chú cho Nhân viên Duyên'),
	('NV005', '123456', N'Hoàng Mạnh Chức', 1, '2000-08-10', '0987655555', 'hmE@gmail.com', 'avatar_E.jpg', 0, 0, N'Ghi chú cho Nhân viên Chức'),
	('NV006', '123456', N'Ngô Gia Pháp', 1, '1995-02-10', '0987654444', 'ngF@gmail.com', 'avatar_F.jpg', 0, 1, N'Ghi chú cho Nhân viên Pháp')
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

INSERT INTO KhuyenMai (maKhuyenMai,tenChuongTrinh, ngayBatDau, ngayKetThuc, moTa, trangThai, giaTriGiam, donViGiam)
VALUES ('KM01','Khuyến mãi mùa hè', '2023-06-01', '2023-06-30', N'Giảm giá cho sản phẩm mùa hè', 1, 5000, 'VND'),
		('KM02','Khuyen mai ngay hoi Tre em', '2023-05-20', '2023-06-02', N'Giảm giá cho sản phẩm sữa cho trẻ', 1, 50000, 'VND'),
		('KM03','Khuyen mai ngay Tet Doc lap', '2023-08-25', '2023-09-05', N'Giảm giá cho sản phẩm sữa', 1, 30000, 'VND'),
		('KM04','Khuyen mai ngay Tet Nguyen Dan', '2024-01-15', '2024-01-30', N'Giảm giá cho sản phẩm sữa', 1, 25000, 'VND'),
		('KM05','Khuyen mai Back Friday', '2023-06-13', '2024-06-30', N'Giảm giá cho sản phẩm sữa', 1, 30, '%'),
		('KM06','Khuyen mai Noel', '2023-12-10', '2024-12-31', N'Giảm giá cho sản phẩm sữa', 1, 45000, 'VND')

INSERT INTO KhuyenMaiSanPham(maKhuyenMai, maSanPhamChiTiet,trangThai)
VALUES ('KM01',1 ,1),
		('KM02',3,1),
		('KM03',6,0),
		('KM04',5,0),
		('KM04',3,1)

insert into HinhThucThanhToan (tenHinhThucThanhToan) values (N'Tiền mặt'),
															(N'Chuyển khoản')



insert into DonHang values 
(1,'NV001',1,1,'','2023/01/03',23000,560000,N'Bán tại quầy','0123456789',N'TP Hà Nội'),
(null,'NV001',1,1,'','2023/03/10',0,660000,N'Bán tại quầy','0132456789',N'Hoài Đức - Hà Nội'),
(2,'NV002',2,1,'','2023/06/24',10000,980000,N'Đặt hàng','0124356789',N'Nam Từ Liêm - Hà Nội'),
(3,'NV002',1,1,'','2023/11/21',20000,1060000,N'Bán tại quầy','0321456789',N'TP Hà Nội'),
(null,'NV002',2,0,'','2023/02/08',20000,820000,N'Đặt hàng','0123546789',N'Phúc Thọ - Hà Nội'),
(6,'NV003',1,1,'','2023/10/05',23000,500000,N'Bán tại quầy','0123457689',N'Phú Xuyên - Hà Nội'),
(10,'NV003',1,1,'','2023/09/03',5000,120000,N'Bán tại quầy','0123456987',N'Hà Đông Hà Nội'),
(null,'NV004',2,1,'','2023/12/12',33000,620000,N'Đặt hàng','0123475689',N'TP Hà Nội'),
(15,'NV004',2,1,'','2023/05/23',3000,560000,N'Đặt hàng','0123456009',N'Cầu Giấy Hà Nội'),
(18,'NV004',1,0,'','2023/01/30',13000,1260000,N'Bán tại quầy','0963456789',N'Thường Tín - Hà Nội'),
(7,'NV004',2,1,'','2023/04/10',25000,900000,N'Đặt hàng','0363456789',N'Hoàng Mai - Hà Nội'),
(4,'NV004',2,1,'','2023/07/25',26000,560000,N'Đặt hàng','0366666689',N'TP Hà Nội')

select * from XuatXu
select * from ThuongHieu
select * from LoaiHang
select * from DongSanPham
select * from NhanVien
select * from KhachHang
select * from HinhThucThanhToan
select * from KhuyenMai
select * from KhuyenMaiSanPham
select * from SanPham
select * from SanPhamChiTiet
 



