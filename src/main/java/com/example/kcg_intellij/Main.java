package com.example.kcg_intellij;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application
{
    private static Stage mainStage;
    public static Stage getMainStage(){
        return mainStage;
    }
    @Override
    public void start(Stage stage) throws Exception
    {
        mainStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("KCG_Main.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Kylin Citation Generator");
        stage.setScene(scene);

        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}