package com.example.passwordvalidator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    static TextField textFieldPassword = new TextField();
    static Label labelLowercase = new Label("Minimum two lowercase letters");
    static Label labelCapital = new Label("Minimum two capital letters");
    static Label labelNumber = new Label("Minimum two numbers");
    static Label labelNonAlphanumeric = new Label("Minimum two non-alphanumeric characters");
    static Label labelLimit = new Label("Minimum twelve characters");

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        BorderPane borderPane = new BorderPane();
        Lector l = new Lector();
        l.start();
        Label labelPassword = new Label();
        labelPassword.setText("Put the password");
        textFieldPassword.setPromptText("Password");

        labelLowercase.setStyle("-fx-text-fill: red;");
        labelCapital.setStyle("-fx-text-fill: red;");
        labelNumber.setStyle("-fx-text-fill: red;");
        labelNonAlphanumeric.setStyle("-fx-text-fill: red;");
        labelLimit.setStyle("-fx-text-fill: red;");

        VBox centerContainer = new VBox();
        centerContainer.getChildren().addAll(labelPassword, textFieldPassword, labelLowercase,
                labelCapital, labelNumber, labelNonAlphanumeric, labelLimit);

        borderPane.setCenter(centerContainer);

        Scene scene = new Scene(borderPane, 320, 240);
        stage.setTitle("VALIDADOR DE CONTRASEÑAS");
        stage.setScene(scene);
        stage.show();


    }

    static public void setValidation(Label validator){

        validator.setStyle("-fx-text-fill: green;");
    }

}
