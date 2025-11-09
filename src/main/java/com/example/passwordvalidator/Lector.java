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
                    limitValidation();
                });
                Thread.sleep(100); // Verificar cada 300ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void lowerCaseValidation(){
        char l;
        int val = 0;
        for(int i = 0; i<chain.length; i++){
            l=chain[i];
            if(l)
        }
    }

    public void limitValidation(){
        if (chain.length >= 12) {
            HelloApplication.labelLimit.setStyle("-fx-text-fill: green;");
        } else HelloApplication.labelLimit.setStyle("-fx-text-fill: red;");
    }

}
