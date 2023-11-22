/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import model.SanPham;
import model.SanPhamChiTiet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dovan
 */
public class ImportExcell {

    public static ArrayList<SanPham> importExcelDataSP(File file) {
        ArrayList<SanPham> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                SanPham product = new SanPham();
                product.setMaSanPham(getStringCellValue(row.getCell(0)));
                product.setTenSanPham(getStringCellValue(row.getCell(1)));
                product.setMoTa(getStringCellValue(row.getCell(2)));
                product.setMaThuongHieu(getma(getStringCellValue(row.getCell(3))));
                product.setMaLoaiHang(getma(getStringCellValue(row.getCell(4))));
                product.setMaDongSanPham(getma(getStringCellValue(row.getCell(5))));
                product.setMaXuatXu(getma(getStringCellValue(row.getCell(6))));
                data.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static ArrayList<SanPhamChiTiet> importExcelDataSPCT(File file) {
        ArrayList<SanPhamChiTiet> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSanPham(getStringCellValue(row.getCell(0)));
                x.setMaDonViTinh(getma(getStringCellValue(row.getCell(7))));
                long exceldate = Long.valueOf(getStringCellValue(row.getCell(9)));
                x.setHanSuDung(XDate.toString(convertExcelDateToJavaDate(exceldate), "dd-MM-yyyy"));
                x.setSoLuong((int) row.getCell(10).getNumericCellValue());
                x.setGiaNhap((float) row.getCell(11).getNumericCellValue());
                x.setDonGia((float) row.getCell(12).getNumericCellValue());
                x.setKhoiLuong((float) row.getCell(13).getNumericCellValue());
                x.setDonViTinhKhoiLuong(getStringCellValue(row.getCell(14)));
                exceldate = Long.valueOf(getStringCellValue(row.getCell(15)));
                x.setNgaySanXuat(XDate.toString(convertExcelDateToJavaDate(exceldate), "dd-MM-yyyy"));
                x.setBarcode(getStringCellValue(row.getCell(16)));
                x.setTrangThai((int) row.getCell(17).getNumericCellValue() == 1 ? true : false);
                x.setAnhSanPham(getStringCellValue(row.getCell(8)));
                data.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Date convertExcelDateToJavaDate(double excelValueDate) {
        long javaDateValue = (long) ((excelValueDate - 25569) * 86400 * 1000);
        return new Date(javaDateValue);
    }

    public static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            default:
                return null;
        }
    }

    public static int getma(String input) {
        // Tìm vị trí của dấu "-" trong chuỗi
        int dashIndex = input.indexOf("-");

        // Kiểm tra xem có dấu "-" trong chuỗi không
        if (dashIndex != -1 && dashIndex < input.length() - 1) {
            // Sử dụng substring để lấy phần sau dấu "-"
            String numberPart = input.substring(dashIndex + 1);

            // Chuyển đổi chuỗi số thành kiểu dữ liệu số nguyên (nếu cần)
            int number = Integer.parseInt(numberPart);

            // In ra số đã trích xuất
            return number;
        }
        return 1;
    }
}
