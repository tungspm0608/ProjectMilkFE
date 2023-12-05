/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.io.BufferedReader;
import java.io.FileReader;
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

        BufferedReader reader = null;
        try {
            String filePath = "setUpVariable.txt";
            reader = new BufferedReader(new FileReader(filePath));

            String line;
            int lineNumber = 1; // Biến đếm số thứ tự dòng

            while (lineNumber != 4) {
                line = reader.readLine();
                System.out.println(lineNumber);
                System.out.println(line);
                switch (lineNumber) {
                    case 1:
                        DBContext.USERNAME = line;
                        break;
                    case 2:
                        DBContext.PASSWORD = line;
                        break;
                    case 3:
                        DBContext.DATABASENAME = line;
                        break;
                    default:
                        throw new AssertionError();
                }

                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}