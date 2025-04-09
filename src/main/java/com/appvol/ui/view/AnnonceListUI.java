package com.appvol.ui.view;

import com.appvol.control.controllers.AnnonceController;
import com.appvol.core.Annonce;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AnnonceListUI {

    private Scene scene;
    private Stage primaryStage;
    private final AnnonceController annonceController = new AnnonceController();

    @SuppressWarnings("exports")
    public AnnonceListUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void display() {
        // Création du header
        HBox header = new HBox(15);
        header.getStyleClass().add("header");
        header.setAlignment(Pos.CENTER);

        Button searchButton = new Button("🔍");
        searchButton.getStyleClass().add("search-button");
       
        Button backButton = new Button("⬅");
        backButton.getStyleClass().add("back-button");
        backButton.setOnAction(e -> showMainAppUI());

        Label appLabel = new Label("IFound");
        appLabel.getStyleClass().add("app-label");

        // Champ de recherche
        TextField searchField = new TextField();
        searchField.setPromptText("Rechercher un objet");

        Button accueilButton = new Button("🏠 Accueil");
        accueilButton.getStyleClass().add("accueil-button");
        accueilButton.setOnAction(e -> showMainAppUI());

        Button compteButton = new Button("Mon Compte");
        compteButton.getStyleClass().add("compte-button");
        compteButton.setTranslateX(43);
        compteButton.setOnAction(e -> showInfoCompteUi());

        header.getChildren().addAll(backButton, appLabel, searchField, searchButton, accueilButton, compteButton);

        // Création de la zone d'annonces
        VBox annonceZone = new VBox(15);
        List<Annonce> annonces = annonceController.getAllAnnonces(); // Récupérer les annonces depuis le contrôleur

        // Ajout des annonces dans la zone d'affichage
        for (Annonce annonce : annonces) {
            VBox annonceItem = new VBox(10);
            annonceItem.setAlignment(Pos.CENTER);
            
            Label titreLabel = new Label(annonce.getNom());
            Label descriptionLabel = new Label(annonce.getDescription());
            Label lieuLabel = new Label("Lieu: " + annonce.getLieu());
            Label dateVolLabel = new Label("Date du vol: " + annonce.getDateVol().toString());
            
            annonceItem.getChildren().addAll(titreLabel, descriptionLabel, lieuLabel, dateVolLabel);

            Button contactButton = new Button("Contacter");
            // Logique pour contacter l'utilisateur en fonction de l'annonce
            contactButton.setOnAction(e -> contacterUtilisateur(annonce));
            annonceItem.getChildren().add(contactButton);

            annonceZone.getChildren().add(annonceItem);
        }

        // Création du scroll pane pour les annonces
        ScrollPane annoncePane = new ScrollPane(annonceZone);

        // Structure de la fenêtre
        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(annoncePane);
        root.getStyleClass().add("border-pane");

        scene = new Scene(root, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("styles/AnnonceListUI.css").toExternalForm());
        primaryStage.setScene(scene);
    }

    // Méthode pour contacter l'utilisateur
    private void contacterUtilisateur(Annonce annonce) {
        // Logique pour contacter l'utilisateur (par exemple, ouvrir une fenêtre de message)
    }

    public void showMainAppUI() {
        App appUI = new App();
        try {
            appUI.start(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showInfoCompteUi() {
        InfoCompteUI infoCompteUI = new InfoCompteUI(primaryStage);
        infoCompteUI.display();
    }

    @SuppressWarnings("exports")
    public Scene getScene() {
        return scene;
    }
}
