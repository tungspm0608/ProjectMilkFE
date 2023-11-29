package service;
import model.NhanVien;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author sang
 */
public class Auth {
    //đối tượng chứ thông tin khi đăng nhập
    public static NhanVien user = null;
    public static int HDH = -1;

    static {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            Auth.HDH = 0;
            System.out.println("Hệ điều hành: Windows");
        } else if (os.contains("mac")) {
            Auth.HDH = 1;
            System.out.println("Hệ điều hành: macOS");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("uni")) {
            Auth.HDH = 2;
            System.out.println("Hệ điều hành: Linux/Unix");
        } else {
            Auth.HDH = -1;
            System.out.println("Không xác định được hệ điều hành.");
        }
        System.out.println(Auth.HDH);
    }
    
    //xóa thông tin của người dung có yêu cầu đăng xuất
    public static void clear(){
        Auth.user=null;
    }
    // kiểm tra xem đang nhập hay chưa
    //@return đăng nhập hay chưa
    public static boolean isLogin(){
        return Auth.user != null;
    }
    public static boolean isManager(){
        return Auth.isLogin() && Auth.user.getVaiTro().equalsIgnoreCase("Quản lý") ;
    }
}
