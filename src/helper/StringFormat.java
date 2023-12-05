/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.text.DecimalFormat;

/**
 *
 * @author dovan
 */
public class StringFormat {

    public static boolean isValidMoneyFormat(String str) {
        // Biểu thức chính quy để kiểm tra định dạng tiền   
        String moneyRegex = "\\d{1,3}([.,]?\\d{3})*(\\.\\d{1,2})?( VND)?";

        // Sử dụng phương thức matches với biểu thức chính quy
        return str.matches(moneyRegex);
    }

    public static boolean isValidNumberFormat(String str) {
        // Sử dụng phương thức matches với biểu thức chính quy "\\d+\\.\\d+"
        return str.matches("\\d+(\\.\\d+)?");
    }

    public static boolean containsDigit(String str) {
        // Biểu thức chính quy "\\d" kiểm tra một chữ số
        return str.matches(".*\\d.*");
    }

    public static boolean isValidEmail(String email) {
        // Biểu thức chính quy để kiểm tra định dạng email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Sử dụng phương thức matches với biểu thức chính quy
        return email.matches(emailRegex);
    }

    public static String changeMoneyFormat(String scientificNotation) {
         double number = Double.parseDouble(scientificNotation);

        // Sử dụng DecimalFormat để định dạng số thành tiền Việt Nam đồng
        DecimalFormat decimalFormat = new DecimalFormat("###,###,### VND");
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
    }
}
