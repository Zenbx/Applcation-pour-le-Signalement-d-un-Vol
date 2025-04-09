package com.appvol.service;

import com.appvol.core.Utilisateur;
import com.appvol.repository.IUserRepository;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String name, String prenom, String email, int tel, String password) {
        if (userRepository.findByEmail(email) != null) {
            return false; // déjà inscrit
        }
        Utilisateur user = new Utilisateur(name, prenom, password, email, tel);
        userRepository.save(user);
        return true;
    }
}