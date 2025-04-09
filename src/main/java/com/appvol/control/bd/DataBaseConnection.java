package com.appvol.control.bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/APPVOL";
    private static final String USER = "root";  // Change selon ton utilisateur MySQL
    private static final String PASSWORD = "jeff@14022003";  // Mets ton mot de passe MySQL

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connexion à MySQL réussie !");
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion à MySQL !");
            e.printStackTrace();
        }
        return conn;
    }
}
