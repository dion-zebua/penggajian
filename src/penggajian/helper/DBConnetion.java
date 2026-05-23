/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dion
 */
public class DBConnetion {
    // Konfigurasi URL database MySQL murni
    private static final String URL = "jdbc:mysql://localhost:3306/penggajian?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Registrasi Driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Membuat koneksi ke database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            // Muncul jika library MySQL JDBC driver belum dimasukkan ke Libraries project
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Driver MySQL tidak ditemukan!\nSilakan tambahkan MySQL JDBC Driver di folder Libraries NetBeans Anda.", 
                    "Driver Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // Muncul jika XAMPP/MySQL mati, atau nama database 'reservasi_hotel' salah/tidak ada
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Koneksi ke Database Gagal!\nDetail Error: " + e.getMessage(), 
                    "Database Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
