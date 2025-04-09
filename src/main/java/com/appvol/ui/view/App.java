package com.appvol.ui.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.appvol.ui.handlers.AppHandler;

public class App extends Application {

    private static Scene scene;
    private final AppHandler appHandler = new AppHandler();

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) throws IOException {

        Label bienvenueLabel = new Label("Bienvenue sur IFound");
        bienvenueLabel.getStyleClass().add("label");

        Button loginButton = new Button("Login");
        Button signInButton = new Button("Sign In");

        // Associer les actions des boutons avec le Handler
        loginButton.setOnAction(appHandler.handleLoginButton(primaryStage));
        signInButton.setOnAction(appHandler.handleSignInButton(primaryStage));

        HBox buttonsZone = new HBox(10, loginButton, signInButton);
        VBox buttonLabelZone = new VBox(10, bienvenueLabel, buttonsZone);

        BorderPane imagePane = new BorderPane();
        imagePane.getStyleClass().add("image-pane");

        BorderPane buttonPane = new BorderPane();
        buttonPane.getStyleClass().add("button-pane");

        buttonPane.setCenter(buttonLabelZone);

        BorderPane root = new BorderPane();
        root.setCenter(imagePane);
        root.setRight(buttonPane);

        scene = new Scene(root, 1000, 500);
        
        scene.getStylesheets().add(getClass().getResource("styles/App.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @SuppressWarnings("exports")
    public Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}
