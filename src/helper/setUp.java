/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.io.FileInputStream;
import java.io.IOException;
import service.Auth;

/**
 *
 * @author phungvantung
 */
public class setUp {

    public static void setUp() {
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

        FileInputStream fin = null;
        try {
            String filePath = "setUpVariable.txt";
            fin = new FileInputStream(filePath);
            int data = fin.read();
            StringBuilder line = new StringBuilder();
            int lineNumber = 1; // Biến đếm số thứ tự dòng

            while (data != -1) {
                if ((char) data == '\n' || (char) data == '\r' || (char) data == ' ') {
                    System.out.println(lineNumber);
                    System.out.println(line.toString());
                    switch (lineNumber) {
                        case 1:
                            DBContext.USERNAME = line.toString();
                            System.out.println(-1);
                            break;
                        case 2:
                            DBContext.PASSWORD = line.toString();
                            System.out.println(-2);
                            break;
                        case 3:
                            DBContext.DATABASENAME = line.toString();
                            System.out.println(-3);
                            break;
                        case 4:
                            System.out.println(-4);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    line.delete(0, line.length());
                    lineNumber++;
                } else {
                    line.append((char) data);

                }

                data = fin.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
