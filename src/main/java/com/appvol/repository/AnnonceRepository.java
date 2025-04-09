package com.appvol.repository;

import com.appvol.core.Annonce;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnonceRepository {

    private Connection connection;

    // Constructor to initialize the database connection
    public AnnonceRepository() {
        try {
            // Setup the connection (update the credentials as necessary)
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/annonces_db", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to save an annonce to the database
    public void save(Annonce annonce) {
        String sql = "INSERT INTO Annonce (code, nom, description, date_vol, photo, type, date_publication, lieu) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, annonce.getCode());
            statement.setString(2, annonce.getNom());
            statement.setString(3, annonce.getDescription());
            statement.setDate(4, Date.valueOf(annonce.getDateVol()));
            statement.setString(5, annonce.getPhoto().toString());  // Assuming photo is stored as a file path
            statement.setString(6, annonce.getType());
            statement.setDate(7, Date.valueOf(annonce.getDatePublication()));
            statement.setString(8, annonce.getLieu());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all annonces from the database
    public List<Annonce> findAll() {
        List<Annonce> annonces = new ArrayList<>();
        String sql = "SELECT * FROM Annonce";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Annonce annonce = new Annonce(
                        resultSet.getString("code"),
                        resultSet.getString("nom"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_vol").toLocalDate(),
                        null,  // For simplicity, we leave the photo as null
                        resultSet.getString("type"),
                        resultSet.getDate("date_publication").toLocalDate(),
                        resultSet.getString("lieu")
                );
                annonces.add(annonce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonces;
    }

    // Method to find an annonce by its code
    public Annonce findByCode(String code) {
        String sql = "SELECT * FROM Annonce WHERE code = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, code);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Annonce(
                            resultSet.getString("code"),
                            resultSet.getString("nom"),
                            resultSet.getString("description"),
                            resultSet.getDate("date_vol").toLocalDate(),
                            null,  // For simplicity, leave the photo as null
                            resultSet.getString("type"),
                            resultSet.getDate("date_publication").toLocalDate(),
                            resultSet.getString("lieu")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to delete an annonce from the database
    public void delete(Annonce annonce) {
        String sql = "DELETE FROM Annonce WHERE code = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, annonce.getCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Closing the database connection
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
