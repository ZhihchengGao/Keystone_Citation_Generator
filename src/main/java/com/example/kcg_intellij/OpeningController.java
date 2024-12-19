package com.example.kcg_intellij;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpeningController {

    private MainController mainController; // Add a field to hold the MainController instance

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void openNewCitation() {
        MainNewCitation open = new MainNewCitation();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KCG_New.fxml"));
            Parent root = loader.load();
            // Get the MainNewCitationController instance
            MainNewCitationController controller = loader.getController();
            // Pass the MainController instance to the MainNewCitationController
            controller.setMainController(mainController);
            // Open the new citation window in a new Stage
            Stage stage = new Stage();
            stage.setTitle("New Citation");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}