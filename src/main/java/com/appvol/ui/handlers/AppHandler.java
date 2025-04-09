package com.appvol.ui.handlers;

import com.appvol.ui.view.LoginUI;
import com.appvol.ui.view.SignInUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class AppHandler {

    // Gérer l'action du bouton "Login"
    public EventHandler<ActionEvent> handleLoginButton(Stage primaryStage) {
        return e -> showLoginUi(primaryStage);
    }

    // Gérer l'action du bouton "Sign In"
    public EventHandler<ActionEvent> handleSignInButton(Stage primaryStage) {
        return e -> showSignInUi(primaryStage);
    }

    // Afficher l'interface de connexion (Login)
    private void showLoginUi(Stage primaryStage) {
        LoginUI loginUI = new LoginUI(primaryStage);
        loginUI.display();
    }

    // Afficher l'interface d'inscription (Sign In)
    private void showSignInUi(Stage primaryStage) {
        SignInUI signInUI = new SignInUI(primaryStage);
        signInUI.display();
    }
}
