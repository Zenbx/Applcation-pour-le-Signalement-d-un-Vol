package com.appvol.control.controllers;

import com.appvol.repository.AnnonceRepository;

import java.time.LocalDate;
import java.util.List;

import com.appvol.core.Annonce;

import javafx.scene.image.ImageView;

public class AnnonceController {

    private final AnnonceRepository annonceRepository = new AnnonceRepository();

    // Méthode pour créer une annonce
    public void createAnnonce(String code, String nom, String description, LocalDate dateVol, 
                              ImageView photo, String type, LocalDate datePublication, String lieu) {
        // Créer une annonce
        Annonce annonce = new Annonce(code, nom, description, dateVol, photo, type, datePublication, lieu);
        
        // Ajouter l'annonce à la base de données
        annonceRepository.save(annonce);
    }

    // Méthode pour récupérer toutes les annonces
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    // Méthode pour supprimer une annonce
    public void deleteAnnonce(String code) {
        Annonce annonce = annonceRepository.findByCode(code);
        if (annonce != null) {
            annonceRepository.delete(annonce);
        }
    }
}
