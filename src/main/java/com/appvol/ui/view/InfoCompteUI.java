package com.appvol.ui.view;

import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.geometry.Pos;

public class InfoCompteUI {

    private Scene scene;
    private Stage primaryStage;

    public InfoCompteUI(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display(){
        VBox mainBox = new VBox(15);

        HBox buttonZone = new HBox(15);

        HBox infoBox = new HBox(15);
        infoBox.getStyleClass().add("info-box");
        infoBox.setAlignment(Pos.CENTER);

        VBox usernameBox = new VBox();
        VBox detailsBox = new VBox();
        Region spacerInfoBox = new Region();
        HBox.setHgrow(spacerInfoBox, Priority.ALWAYS);
        Region spacerButtonBox = new Region();
        HBox.setHgrow(spacerButtonBox, Priority.ALWAYS);


        Button backButton = new Button("<");
        backButton.getStyleClass().add("back-button");
        backButton.setOnAction(e -> showAnnonceListUi());

        Button menuButton = new Button("---");
        menuButton.getStyleClass().add("back-button");

        buttonZone.getChildren().addAll(backButton, spacerButtonBox,menuButton);

        Label usernameLabel = new Label("Nom d'Utilisateur");
        usernameLabel.getStyleClass().add("username-label");

        Label statLabel = new Label("5 ❌  4 ❕ 6 ❓");

        Label detailsLabel = new Label("Details");
        
        usernameBox.getChildren().addAll(usernameLabel, statLabel);
        detailsBox.getChildren().addAll(detailsLabel);

        infoBox.getChildren().addAll(usernameBox, spacerInfoBox, detailsBox);
        mainBox.getChildren().addAll(buttonZone, infoBox);

        Button loginButton = new Button("Se connecter");
        loginButton.getStyleClass().add("login-button");
        loginButton.setOnAction(e -> showAnnonceListUi());

        TitledPane annonceLancePane = new TitledPane("Annonces Lancées",loginButton);
        annonceLancePane.setCollapsible(false);
        TitledPane annonceAboutiPane = new TitledPane("Annonces Traitées",loginButton);
        annonceAboutiPane.setCollapsible(false);

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(annonceLancePane,annonceAboutiPane);

        Button ajouterAnnonceButton = new Button("Ajouter une nouvelle annonce");
        ajouterAnnonceButton.setTranslateX(320);
        ajouterAnnonceButton.setTranslateY(120);


        VBox contentBox = new VBox(15);

        StackPane contentStackPane = new StackPane();

        contentBox.getChildren().addAll(accordion);

        contentStackPane.getChildren().addAll(contentBox, ajouterAnnonceButton);

        BorderPane root = new BorderPane();
        root.setTop(mainBox);
        root.setCenter(contentStackPane);
        root.getStyleClass().add("border-pane");

        scene = new Scene(root, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("styles/InfoCompteUI.css").toExternalForm());

        primaryStage.setScene(scene);

    }

    @SuppressWarnings("exports")
    public Scene getScene() {
        return scene;
    }

    public void showMainAppUI(){
        App appUI = new App();
        try {
            appUI.start(primaryStage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showAnnonceListUi(){
        AnnonceListUI annonceListUI = new AnnonceListUI(primaryStage);
        annonceListUI.display();

    }
}

