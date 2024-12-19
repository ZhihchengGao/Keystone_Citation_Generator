package com.example.kcg_intellij;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class MainNewCitation extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("KCG_New.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New Citation");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
}