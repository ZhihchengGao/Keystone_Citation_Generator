package com.example.kcg_intellij;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.util.Objects;

public class MainEditCitation extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("KCG_Edit.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Edit Citation List");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
}