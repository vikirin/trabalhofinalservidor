package com.example.trabalhofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PrincipalVerCliente extends Application {

    public static Stage stage;
    public static Stage getStage(){
        return stage;
    }
    public static void setStage(Stage stage){
        PrincipalVerCliente.stage = stage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("verCliente.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
