package com.appvol.repository;

import com.appvol.core.Utilisateur;;

public interface IUserRepository {

    void save(Utilisateur user);
    Utilisateur findByEmail(String email);

}
