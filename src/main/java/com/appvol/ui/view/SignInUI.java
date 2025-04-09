package com.appvol.ui.view;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class SignInUI {

    private Scene scene;
    private Stage stage;

    public TextField nameField = new TextField();
    public TextField prenomField = new TextField();
    public TextField emailField = new TextField();
    public TextField telField = new TextField();
    public PasswordField passwordField = new PasswordField();
    public PasswordField confirmPasswordField = new PasswordField();
    public Button signInButton = new Button("S'inscrire");
    public Button backButton = new Button("< Retour");

    
    public SignInUI(Stage stage) {
        this.stage = stage;
    }

    public void display(){
        VBox signInBox = new VBox(15);
        signInBox.setAlignment(Pos.CENTER);
        signInBox.getStyleClass().add("sign-in-box");

        Label signInLabel = new Label("Inscription");
        signInLabel.getStyleClass().add("sign-in-title");

        nameField.setPromptText("Nom");
        prenomField.setPromptText("Prénom");
        emailField.setPromptText("Email");
        telField.setPromptText("Téléphone");
        passwordField.setPromptText("Mot de passe");
        confirmPasswordField.setPromptText("Confirmer mot de passe");
        signInButton.getStyleClass().add("sign-in-button");
        backButton.getStyleClass().add("back-button");

        signInBox.getChildren().addAll(backButton, signInLabel,nameField, prenomField, emailField, telField, passwordField, confirmPasswordField, signInButton);

        BorderPane root = new BorderPane();
        root.getStyleClass().add("border-pane");
        root.setCenter(signInBox);
        scene = new Scene(root, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("styles/SignInUI.css").toExternalForm());

        stage.setScene(scene);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getSignInButton() { return signInButton; }
    public Button getBackButton() { return backButton; }
}
