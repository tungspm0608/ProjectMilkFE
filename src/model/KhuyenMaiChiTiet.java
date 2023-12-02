
package model;

/**
 *
 * @author Admin
 */
public class KhuyenMaiChiTiet {
    private int maKhuyenMaiChiTiet;
    private String maKhuyenMai;
    private int maSanPhamChiTiet;
    private int trangThai;

    public KhuyenMaiChiTiet() {
    }

    public KhuyenMaiChiTiet(int maKhuyenMaiChiTiet, String maKhuyenMai, int maSanPhamChiTiet, int trangThai) {
        this.maKhuyenMaiChiTiet = maKhuyenMaiChiTiet;
        this.maKhuyenMai = maKhuyenMai;
        this.maSanPhamChiTiet = maSanPhamChiTiet;
        this.trangThai = trangThai;
    }

    public int getMaKhuyenMaiChiTiet() {
        return maKhuyenMaiChiTiet;
    }

    public void setMaKhuyenMaiChiTiet(int maKhuyenMaiChiTiet) {
        this.maKhuyenMaiChiTiet = maKhuyenMaiChiTiet;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getMaSanPhamChiTiet() {
        return maSanPhamChiTiet;
    }

    public void setMaSanPhamChiTiet(int maSanPhamChiTiet) {
        this.maSanPhamChiTiet = maSanPhamChiTiet;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getStatusTrangThai(){
        if (getTrangThai() == 1) {
            return "Đang hoạt động";
        } else if (getTrangThai() == 0) {
            return "Đã kết thúc";
        }else{
            return "Chưa bắt đầu";
        }
    }


   

    
   
   
}
