package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;

        String url= "jdbc:mysql://localhost:3306/examModule3?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "sysadmin1234$";

        try {
            // load Driver
            Class.forName("com.mysql.jdbc.Driver");

            // create connection
            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connected successfully");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error connection " + ex);
        }

        // create connection
        return conn;
    }

    public static void main(String[] args) {
        DBConnection.getConnection();
    }
}
