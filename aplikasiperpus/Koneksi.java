    package com.mycompany.aplikasiperpus;


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/dbperpus";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("✅ Koneksi berhasil!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Koneksi gagal: " + e.getMessage());
        }
    }
 }



