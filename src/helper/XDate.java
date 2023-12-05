/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dovan
 */
public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {
        if (pattern.isEmpty()) {
            pattern = "dd-MM-yyyy";
        }
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException();
        }
    }
    // chuyển đổi string sang date
    //date là string cần chuyển
    //pattern là định dạng thời gian
    //return date kết quả

    public static String toString(Date date, String pattern) {
        if (pattern.isEmpty()) {
            pattern = "dd-MM-yyyy";
        }
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    public static Date now() {
        return new Date();
    }
    // chuyển đổi string sang date
    //date thời gian hiện có
    //days số ngày cần bổ sung vào date
    //return Date kết quả

    public static Date addDays(Date date, Long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static boolean checkDataDay(Date date) {
        Date ngayBatDau = new Date(2022 - 1900, 0, 1);
        if (date.after(XDate.now()) || ngayBatDau.after(date)) {
            DialogHelper.alert(null, "Thời gian vượt ngoài khoảng thời gian hoạt động");
            return false;
        }
        return true;
    }

    public static boolean checkDataYear(int year) {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        // Lấy năm hiện tại từ đối tượng LocalDate
        int currentYear = currentDate.getYear();
        if (year > currentYear || year < 2022) {
            DialogHelper.alert(null, "Thời gian vượt ngoài khoảng thời gian hoạt động");
            return false;
        }
        return true;
    }

    public static boolean isValidDateRange(String input) {
        // Định dạng ngày cần kiểm tra
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            // Parse chuỗi thành LocalDate
            LocalDate date = LocalDate.parse(input, dateFormatter);

            // Lấy ngày hôm nay
            LocalDate currentDate = LocalDate.now();

            // Kiểm tra xem ngày có lớn hơn 1900 và nhỏ hơn ngày hôm nay hay không
            return date.isAfter(LocalDate.of(1900, 1, 1)) && date.isBefore(currentDate);
        } catch (DateTimeParseException e) {
            return false; // Nếu có lỗi, ngày không hợp lệ
        }
    }
    
    public static boolean isValidExpiryDate(String input) {
        // Định dạng ngày cần kiểm tra
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            // Parse chuỗi thành LocalDate
            LocalDate expiryDate = LocalDate.parse(input, dateFormatter);

            // Lấy ngày hiện tại
            LocalDate currentDate = LocalDate.now();

            // Kiểm tra xem ngày hết hạn có lớn hơn ngày hiện tại hay không
            return expiryDate.isAfter(currentDate);
        } catch (DateTimeParseException e) {
            return false; // Nếu có lỗi, ngày không hợp lệ
        }
    }
}
