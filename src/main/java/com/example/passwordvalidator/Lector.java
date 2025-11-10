package com.example.passwordvalidator;

import javafx.application.Platform;

public class Lector extends Thread{

    char[] chain = new char[0];
    String text;

    @Override
    public void run() {
        while (HelloApplication.textFieldPassword.isEditable()) {
            try {
                text = HelloApplication.textFieldPassword.getText();
                chain = text.toCharArray();
                Platform.runLater(()->{
                    lowerCaseValidation();
                    capitalValidation();
                    numberValidation();
                    nonAlphanumeric();
                    limitValidation();
                });
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void lowerCaseValidation(){
        int val = 0;
        for (char c : chain) {
            if (Character.isLowerCase(c))
                val++;
        }

        if(val>=2){
            HelloApplication.labelLowercase.setStyle("-fx-text-fill: green;");
        } else HelloApplication.labelLowercase.setStyle("-fx-text-fill: red;");

    }

    public void capitalValidation(){
        int val = 0;
        for (char c : chain) {
            if (Character.isUpperCase(c))
                val++;
        }

        if(val>=2){
            HelloApplication.labelCapital.setStyle("-fx-text-fill: green;");
        } else HelloApplication.labelCapital.setStyle("-fx-text-fill: red;");
    }

    public void numberValidation(){
        int val = 0;
        for (char c : chain) {
            if (Character.isDigit(c))
                val++;
        }

        if(val>=2){
            HelloApplication.labelNumber.setStyle("-fx-text-fill: green;");
        } else HelloApplication.labelNumber.setStyle("-fx-text-fill: red;");
    }

    public void nonAlphanumeric(){
        int val = 0;
        for (char c : chain) {
            if (!Character.isLetterOrDigit(c)){
                val++;
            }

        }

        if(val>=2){
            HelloApplication.labelNonAlphanumeric.setStyle("-fx-text-fill: green;");
        } else HelloApplication.labelNonAlphanumeric.setStyle("-fx-text-fill: red;");
    }

    public void limitValidation(){
        if (chain.length >= 12) {
            HelloApplication.labelLimit.setStyle("-fx-text-fill: green;");
        } else HelloApplication.labelLimit.setStyle("-fx-text-fill: red;");
    }

}
