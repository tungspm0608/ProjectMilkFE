/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tung
 */
public class XuatXu {
    private int maXuatXu;
    private String tenXuatXu;
    private String ghiChu;
    private int trangThai;

    public XuatXu() {
    }

    public XuatXu(int maXuatXu, String tenXuatXu, String ghiChu, int trangThai) {
        this.maXuatXu = maXuatXu;
        this.tenXuatXu = tenXuatXu;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getMaXuatXu() {
        return maXuatXu;
    }

    public void setMaXuatXu(int maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public String getTenXuatXu() {
        return tenXuatXu;
    }

    public void setTenXuatXu(String tenXuatXu) {
        this.tenXuatXu = tenXuatXu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenXuatXu;
    }
    
    
}
