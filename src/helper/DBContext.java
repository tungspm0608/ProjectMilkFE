/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;
import java.sql.*;
/**
 *
 * @author dovan
 */
public class DBContext {

    public static String USERNAME = "";
    public static String PASSWORD = "";
    public static String DATABASENAME = "";


    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DATABASENAME +";encrypt=false;";
            cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
          
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cn;
    }

    public static void closeConnection(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("thanh cong");
        } else {
            System.out.println("That bai");
        }
        closeConnection(connection);
    }
}
