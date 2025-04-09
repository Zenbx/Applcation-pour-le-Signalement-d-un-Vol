package com.appvol.ui.handlers;

import java.io.IOException;

import com.appvol.core.Utilisateur;
import com.appvol.repository.UserRepositoryImpl;
import com.appvol.ui.view.SignInUI;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class SignInHandler {

    private final SignInUI view;
    private final Stage stage;
    private final UserRepositoryImpl repo = new UserRepositoryImpl();

    public SignInHandler(SignInUI view, Stage stage) {
        this.view = view;
        this.stage = stage;
        attachEvents();
    }

    private void attachEvents() {
        view.getSignInButton().setOnAction(e -> {
            try {
                handleSignIn();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        view.getBackButton().setOnAction(e -> {
            try {
                handleBack();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
    }

    private void handleSignIn() throws IOException {
        String nom = view.nameField.getText();
        String prenom = view.prenomField.getText();
        String email = view.emailField.getText();
        String password = view.passwordField.getText();
        String confirm = view.confirmPasswordField.getText();

        int tel;

        try {
            tel = Integer.parseInt(view.telField.getText());
        } catch (NumberFormatException e) {
            showAlert("Numéro de téléphone invalide.");
            return;
        }

        if (!password.equals(confirm)) {
            showAlert("Les mots de passe ne correspondent pas.");
            return;
        }

        Utilisateur u = new Utilisateur(null, nom, prenom, password, email, tel);
        repo.save(u);
        showAlert("Inscription réussie !");
        handleBack();
    }

    private void handleBack() throws IOException {
        // Navigation vers la page principale
        new com.appvol.ui.view.App().start(stage);
    }

    private void showAlert(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK).showAndWait();
    }
}
