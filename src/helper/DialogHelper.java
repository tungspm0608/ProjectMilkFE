/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import service.Auth;

public class DialogHelper {

    /**
     * Hiển thị thông báo cho người dùng
     *
     * @param parent là cửa sổ chứa thông báo
     * @param message là thông báo
     */
    public static void alert(Component parent, String message) {
        String fileName = Auth.HDH == 2?"src/utilities/image/MilkFE_logo.png":"src\\utilities\\image\\MilkFE_logo.png";
        ImageIcon icon = new ImageIcon(fileName);
        JOptionPane.showMessageDialog(parent, message,
                "MilkFE", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    /**
     * Hiển thị thông báo và yêu cầu người dùng xác nhận
     *
     * @param parent là cửa sổ chứa thông báo
     * @param message là câu hỏi yes/no
     * @return là kết quả nhận được true/false
     */
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,
                "MilkFE",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    /**
     * Hiển thị thông báo yêu cầu nhập dữ liệu
     *
     * @param parent là cửa sổ chứa thông báo
     * @param message là thông báo nhắc nhở nhập
     * @return là kết quả nhận được từ người sử dụng nhập vào
     */
    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message,
                "MilkFE", JOptionPane.INFORMATION_MESSAGE);
    }
}
