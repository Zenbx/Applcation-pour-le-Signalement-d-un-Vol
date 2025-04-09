package com.appvol.ui.handlers;

import com.appvol.control.controllers.LoginController;
import com.appvol.ui.view.App;
import com.appvol.ui.view.AnnonceListUI;
import com.appvol.ui.view.LoginUI;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginHandler {

    private final LoginUI loginUI;
    private final Stage stage;

    public LoginHandler(LoginUI loginUI, Stage stage) {
        this.loginUI = loginUI;
        this.stage = stage;
    }

    public void attachEvents() {
        loginUI.getLoginButton().setOnAction(e -> {
            String email = loginUI.getEmailField().getText();
            String password = loginUI.getPasswordField().getText();
            LoginController controller = new LoginController();

            boolean success = controller.login(email, password);
            if (success) {
                AnnonceListUI annonceListUI = new AnnonceListUI(stage);
                annonceListUI.display();
            } else {
                loginUI.getErrorLabel().setText("Email ou mot de passe incorrect !");
            }
        });

        loginUI.getBackButton().setOnAction(e -> {
            try {
                new App().start(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
