package com.example.kcg_intellij;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class MainController {

    @FXML
    private ComboBox<?> boxProjectSelection;

    @FXML
    private Button btnViewReg;

    @FXML
    private Button btnDownloadCitation;

    @FXML
    private Button btnNewCitation;

    @FXML
    private TextArea txtCitation;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnEditCitation;
    
    private Sorting_Code sortingCode = new Sorting_Code(); // Maintain citations

    public void addNewCitation(String newCitation) {
        sortingCode.getCitationEntries().add(newCitation);
        sortingCode.outputCitations(sortingCode.getCitationEntries());
        txtCitation.setText(sortingCode.getCitationOutput()); // Update the display
    }

    @FXML
    void handleDownloadCitation(ActionEvent event) {
        StringSelection stringSelection = new StringSelection(sortingCode.getCitationOutput());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Citation Copied to Clipboard");
        alert.setTitle("Copied to Clipboard");
        alert.showAndWait();
    }

    @FXML
    void handleNewCitation(ActionEvent event) {
        OpeningController open = new OpeningController();
        // Pass the MainController instance to OpeningController
        open.setMainController(this);
        // Open the new citation window
        open.openNewCitation();
    }

    @FXML
    void handleProjectSelection(ActionEvent event) {

    }

    @FXML
    void handleViewReg(ActionEvent event) {

    }

    @FXML
    void handleRefresh(ActionEvent event) {
        Sorting_Code output = new Sorting_Code();
        String citation_output = output.getSampleCitationOutput();
        
        // Debug print to verify output
        System.out.println("Generated Citations:\n" + citation_output);
        
        // Update GUI
        txtCitation.setText(citation_output);
    }


    @FXML
    void handleEditCitation(ActionEvent event) {

    }
}
