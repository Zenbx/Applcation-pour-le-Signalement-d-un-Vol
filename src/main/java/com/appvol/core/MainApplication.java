package com.appvol.core;

import java.sql.Connection; 

import com.appvol.control.bd.DataBaseConnection;

public class MainApplication {
        public static void main(String[] args) {
            Connection conn = DataBaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Connexion réussie à la base de données !");
            } else {
                System.out.println("Échec de la connexion.");
            }
            
        }
    }
