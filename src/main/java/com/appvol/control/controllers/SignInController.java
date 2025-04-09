package com.appvol.control.controllers;

import java.util.UUID;

import com.appvol.core.Utilisateur;
import com.appvol.repository.UserRepositoryImpl;

public class SignInController {

    private final UserRepositoryImpl utilisateurRepository = new UserRepositoryImpl();

    public String register(String nom, String prenom, String email, String tel, String password, String confirmPassword) {
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || tel.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return "Tous les champs sont requis.";
        }

        if (!password.equals(confirmPassword)) {
            return "Les mots de passe ne correspondent pas.";
        }

        try {
            Integer.parseInt(tel);  // Vérification que le téléphone est bien un entier
        } catch (NumberFormatException e) {
            return "Le téléphone doit être un nombre entier.";
        }

        if (utilisateurRepository.findByEmail(email) != null) {
            return "Cet email est déjà utilisé.";
        }

        String code = UUID.randomUUID().toString(); // Génération unique d’un ID

        Utilisateur u = new Utilisateur(code, nom, prenom, password ,email, Integer.parseInt(tel));
        utilisateurRepository.save(u);

        return "success";
    }
}

