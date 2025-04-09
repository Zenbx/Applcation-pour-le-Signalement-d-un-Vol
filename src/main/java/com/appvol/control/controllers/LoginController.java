package com.appvol.control.controllers;

import com.appvol.core.Utilisateur;
import com.appvol.repository.UserRepositoryImpl;

public class LoginController {
    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    public boolean login(String email, String password) {
        Utilisateur user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}