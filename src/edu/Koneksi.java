package edu;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Koneksi {

    private static Connection connection1;

    public static Connection configDB() throws Exception {
        if (connection1 == null || connection1.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomofocus", "root", "");
        }
        return connection1;
    }

    public static void main(String[] args) {
        try {
            configDB();
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
        }
    }
}


