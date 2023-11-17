/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author dovan
 */
public class FileChoose {
    public static String chooseFile(){
        JFileChooser fileChooser = new JFileChooser();
        File deFile = new File("C:\\Users\\dovan\\OneDrive\\Desktop\\images\\");
        fileChooser.setSelectedFile(deFile);
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File sFile = fileChooser.getSelectedFile();
            String paString = sFile.getPath();
            int last = paString.lastIndexOf("\\");
            String path = paString.substring(last+1);
             System.out.println("file : ");
            System.out.println(path);
            return path;
//            Image orImage = new ImageIcon(paString).getImage();
//            Image resize = orImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//            txtanh.setIcon(new ImageIcon(resize));
        }
        return null;
    }
}
