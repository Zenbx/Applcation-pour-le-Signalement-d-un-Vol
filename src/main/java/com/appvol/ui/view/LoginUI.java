package com.appvol.ui.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.appvol.ui.handlers.LoginHandler;

import javafx.geometry.Pos;

public class LoginUI {

    private Scene scene;
    private Stage primaryStage;

    private TextField emailField;
    private PasswordField passwordField;
    private Label errorLabel;
    private Button loginButton;
    private Button backButton;

    public LoginUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display() {
        VBox loginBox = new VBox(15);
        loginBox.getStyleClass().add("login-box");
        loginBox.setAlignment(Pos.CENTER);

        backButton = new Button("<");
        backButton.getStyleClass().add("back-button");
        backButton.setTranslateX(-170);
        backButton.setTranslateY(-90);

        Label loginLabel = new Label("Connexion");
        loginLabel.getStyleClass().add("login-title");

        emailField = new TextField();
        emailField.setPromptText("Email");

        passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        loginButton = new Button("Se connecter");
        loginButton.getStyleClass().add("login-button");

        loginBox.getChildren().addAll(backButton, loginLabel, emailField, passwordField, loginButton, errorLabel);

        BorderPane root = new BorderPane();
        root.setCenter(loginBox);
        root.getStyleClass().add("border-pane");

        scene = new Scene(root, 1000, 500);
        scene.getStylesheets().add(getClass().getResource("styles/LoginUI.css").toExternalForm());

        primaryStage.setScene(scene);

        // On connecte le handler ici
        LoginHandler handler = new LoginHandler(this, primaryStage);
        handler.attachEvents();
    }

    // Getters nécessaires pour le handler
    public TextField getEmailField() { return emailField; }
    public PasswordField getPasswordField() { return passwordField; }
    public Label getErrorLabel() { return errorLabel; }
    public Button getLoginButton() { return loginButton; }
    public Button getBackButton() { return backButton; }
}
