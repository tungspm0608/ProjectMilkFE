/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tung
 */
public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private String moTa;
    private int trangThai; // kinh doanh or ngung kinh doanh
    private ThuongHieu thuongHieu;
    private LoaiHang loaiHang;
    private DongSanPham dongSanPham;
    private XuatXu xuatXu;
    private SanPhamChiTiet spct;
    private String ghiChu;
    

    public SanPham() {
    }

    public SanPham(int maSanPham, String tenSanPham, String moTa, int trangThai, ThuongHieu thuongHieu, LoaiHang loaiHang, DongSanPham dongSanPham, XuatXu xuatXu, SanPhamChiTiet spct, String ghiChu) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.thuongHieu = thuongHieu;
        this.loaiHang = loaiHang;
        this.dongSanPham = dongSanPham;
        this.xuatXu = xuatXu;
        this.spct = spct;
        this.ghiChu = ghiChu;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public ThuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public LoaiHang getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHang loaiHang) {
        this.loaiHang = loaiHang;
    }

    public DongSanPham getDongSanPham() {
        return dongSanPham;
    }

    public void setDongSanPham(DongSanPham dongSanPham) {
        this.dongSanPham = dongSanPham;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public SanPhamChiTiet getSpct() {
        return spct;
    }

    public void setSpct(SanPhamChiTiet spct) {
        this.spct = spct;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
