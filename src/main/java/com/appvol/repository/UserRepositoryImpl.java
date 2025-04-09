package com.appvol.repository;

import com.appvol.core.Utilisateur;
import com.appvol.control.bd.DataBaseConnection;

import java.sql.*;

public class UserRepositoryImpl implements IUserRepository {

    @Override
    public void save(Utilisateur user) {
        String sql = "INSERT INTO Utilisateur (code, nom, prenom, password, email, tel) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getCode());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getPrenom());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setInt(6, user.getTel());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateur findByEmail(String email) {
        String sql = "SELECT * FROM Utilisateur WHERE email = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Utilisateur(
                    rs.getString("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getInt("tel")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
