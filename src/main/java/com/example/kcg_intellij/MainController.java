package com.example.kcg_intellij;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

public class MainController {

    @FXML
    private TextArea txtCitation;

    private Sorting_Code sortingCode;

    public void setSortingCode(Sorting_Code sortingCode) {this.sortingCode = sortingCode;}

    @FXML
    public void initialize() throws IOException {
        if (sortingCode == null) {
            sortingCode = Sorting_Code.getSortingCode(); // Ensure it's initialized
        }
        retreiveStorage();
    }

    public void addNewCitation(String newCitation) throws IOException {
        setSortingCode(Sorting_Code.getSortingCode());
        sortingCode.getCitationEntries().add(newCitation);
        sortingCode.outputCitations(sortingCode.getCitationEntries());
        txtCitation.setText(sortingCode.getCitationOutput()); // Update the display
        updateStorage();
    }

    public void deleteCitation(ArrayList<Integer> indexes) throws IOException {
        setSortingCode(Sorting_Code.getSortingCode());
        ArrayList<Integer> citationIndexes = new ArrayList<>();
        citationIndexes = indexes;
        Collections.sort(citationIndexes, Collections.reverseOrder());
        for (int i = 0, j = citationIndexes.size(); i < j; i++) {
            int removeno = citationIndexes.get(i);
            sortingCode.getCitationEntries().remove(removeno-1);
        }
        sortingCode.outputCitations(sortingCode.getCitationEntries());
        txtCitation.setText(sortingCode.getCitationOutput());
        updateStorage();
    }

    public void updateStorage() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt"));
        for(String entries : sortingCode.getCitationEntries()){
            writer.write(entries + "\n");
        }
        writer.close();
    }

    public void retreiveStorage() throws IOException {
        boolean retreived = false;
        BufferedReader reader = new BufferedReader(new FileReader("storage.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            sortingCode.getCitationEntries().add(line);
            retreived = true;
        }
        sortingCode.outputCitations(sortingCode.getCitationEntries());
        txtCitation.setText(sortingCode.getCitationOutput());
        reader.close();

        if (retreived) {
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Citation Retrieved");
                alert.setHeaderText(null);
                alert.setContentText("We retrieved the citation entries from the storage.");
                alert.initModality(Modality.APPLICATION_MODAL); // Ensures it stays on top
                alert.showAndWait();
            });
        }
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
    void handleEditCitation(ActionEvent event) {
        OpeningController open = new OpeningController();
        // Pass the MainController instance to OpeningController
        open.setMainController(this);
        // Open the new citation window
        open.openEditCitation();
    }


    @FXML
    void handleAbout(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("鼎石中文参考文献生成器");
        alert.setContentText("开发者: Richard Gao | 高靖博 \n当前版本：v1.0rc1 \n \n开源地址:\n github.com/ZhihchengGao/Keystone_Citation_Generator \n \n如有问题，请联系：richardgao2006@gmail.com");
        alert.setTitle("鼎石参考文献生成器");
        alert.showAndWait();
    }

    @FXML
    void handlemnuRefreg(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/ZhihchengGao/Keystone_Citation_Generator/wiki/User-Guide"));
    }
}
