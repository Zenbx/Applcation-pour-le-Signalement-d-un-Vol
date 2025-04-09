package com.appvol.ui.view;

import com.appvol.control.controllers.AnnonceController;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PublicationCreationUI {

    private Stage primaryStage;

    // Constructor to initialize the primary stage
    public PublicationCreationUI(@SuppressWarnings("exports") Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Method to display the UI for creating a new announcement
    public void display() {

        // Title for the publication creation page
        Label titleLabel = new Label("Créer une Annonce");
        titleLabel.getStyleClass().add("title-label");

        // Input fields for announcement details
        TextField codeField = new TextField();
        codeField.setPromptText("Code de l'annonce");

        TextField nomField = new TextField();
        nomField.setPromptText("Nom de l'objet");

        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Description de l'objet");
        descriptionField.setWrapText(true);

        DatePicker dateVolField = new DatePicker();
        dateVolField.setPromptText("Date du vol");

        TextField typeField = new TextField();
        typeField.setPromptText("Type de l'objet");

        DatePicker datePublicationField = new DatePicker();
        datePublicationField.setPromptText("Date de publication");

        TextField lieuField = new TextField();
        lieuField.setPromptText("Lieu de l'objet");

        // Image placeholder (replace with actual ImageView selection)
        ImageView photoImageView = new ImageView();
        photoImageView.setFitHeight(100);
        photoImageView.setFitWidth(100);
        // You can add an actual file picker here to select an image

        // Buttons for submitting and canceling the creation
        Button submitButton = new Button("Publier l'annonce");
        submitButton.getStyleClass().add("submit-button");

        Button cancelButton = new Button("Annuler");
        cancelButton.getStyleClass().add("cancel-button");

        // Create layout containers
        VBox formLayout = new VBox(10);
        formLayout.setAlignment(Pos.CENTER);
        formLayout.getChildren().addAll(
                titleLabel, codeField, nomField, descriptionField, dateVolField, 
                typeField, datePublicationField, lieuField, photoImageView, submitButton, cancelButton
        );

        // Handle form submission
        submitButton.setOnAction(e -> {
            String code = codeField.getText();
            String nom = nomField.getText();
            String description = descriptionField.getText();
            LocalDate dateVol = dateVolField.getValue();
            String type = typeField.getText();
            LocalDate datePublication = datePublicationField.getValue();
            String lieu = lieuField.getText();

            // Ensure all fields are filled
            if (code.isEmpty() || nom.isEmpty() || description.isEmpty() || dateVol == null || type.isEmpty() || datePublication == null || lieu.isEmpty()) {
                showAlert("Erreur", "Tous les champs doivent être remplis.");
                return;
            }

            // Call the controller to save the new annonce
            AnnonceController annonceController = new AnnonceController();
            annonceController.createAnnonce(code, nom, description, dateVol, photoImageView, type, datePublication, lieu);

            // Show success message
            showAlert("Succès", "Annonce publiée avec succès!");

            // Clear form fields after submission
            clearForm(codeField, nomField, descriptionField, dateVolField, typeField, datePublicationField, lieuField);
        });

        // Handle cancel button
        cancelButton.setOnAction(e -> {
            clearForm(codeField, nomField, descriptionField, dateVolField, typeField, datePublicationField, lieuField);
        });

        // Create the scene and set it on the primary stage
        Scene scene = new Scene(formLayout, 600, 400);
        scene.getStylesheets().add(getClass().getResource("styles/PublicationCreationUI.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Utility method to show an alert with a given title and message
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Utility method to clear all the form fields
    private void clearForm(TextField codeField, TextField nomField, TextArea descriptionField, DatePicker dateVolField,
                           TextField typeField, DatePicker datePublicationField, TextField lieuField) {
        codeField.clear();
        nomField.clear();
        descriptionField.clear();
        dateVolField.setValue(null);
        typeField.clear();
        datePublicationField.setValue(null);
        lieuField.clear();
    }
}

