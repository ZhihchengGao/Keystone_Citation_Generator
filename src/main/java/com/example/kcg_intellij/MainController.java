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

    public void addNewCitation(String newCitation) throws IOException, URISyntaxException {
        setSortingCode(Sorting_Code.getSortingCode());
        sortingCode.getCitationEntries().add(newCitation);
        sortingCode.outputCitations(sortingCode.getCitationEntries());
        txtCitation.setText(sortingCode.getCitationOutput()); // Update the display
        updateStorage();
    }

    public void deleteCitation(ArrayList<Integer> indexes) throws IOException, URISyntaxException {
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

    /**
     * Updates the storage file with the sorted list of citation entries.
     * The citations are written to a file named "DO NOT DELETE KCG storage.txt"
     * located in the user's home directory.
     */
    public void updateStorage() throws IOException, URISyntaxException {
        // Define the path to the storage file in the user's home directory.
        File storageFile = new File(System.getProperty("user.home"), "DO NOT DELETE KCG storage.txt");

        // Create a BufferedWriter for writing to the file.
        BufferedWriter writer = new BufferedWriter(new FileWriter(storageFile));

        // Check if the file doesn't exist and create it if necessary.
        if (!storageFile.exists()) {
            storageFile.createNewFile();
        }

        // Iterate through the sorted citation entries and write each to the file.
        for (String entries : sortingCode.getCitationEntries()) {
            writer.write(entries + "\n");
        }

        // Close the BufferedWriter to release system resources.
        writer.close();
    }

    /**
     * Retrieves citation entries from the storage file.
     * Reads citations from "DO NOT DELETE KCG storage.txt" in the user's home directory.
     * Updates the internal storage and outputs the citations.
     */
    public void retreiveStorage() throws IOException {
        // Define the path to the storage file in the user's home directory.
        File storageFile = new File(System.getProperty("user.home"), "DO NOT DELETE KCG storage.txt");

        // Boolean flag to track if citations were successfully retrieved.
        boolean retreived = false;

        // Check if the file exists before attempting to read it.
        if (storageFile.exists()) {
            // Create a BufferedReader for reading the file content.
            BufferedReader reader = new BufferedReader(new FileReader(storageFile));
            String line;

            // Read each line from the file and add it to the citation entries list.
            while ((line = reader.readLine()) != null) {
                sortingCode.getCitationEntries().add(line);
                retreived = true;
            }

            // Output the sorted citations and update the UI text field.
            sortingCode.outputCitations(sortingCode.getCitationEntries());
            txtCitation.setText(sortingCode.getCitationOutput());

            // Close the BufferedReader to release system resources.
            reader.close();
        } else {
            // If the file does not exist, create a new empty file.
            System.out.println("用于存储的文件不存在，现创建新的文件");
            storageFile.createNewFile();
        }

        // If citations were retrieved, display a success message using an alert dialog.
        if (retreived) {
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("参考文献已恢复");
                alert.setHeaderText(null);
                alert.setContentText("我们恢复了您的参考文献");
                alert.initModality(Modality.APPLICATION_MODAL); // Ensures it stays on top.
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
        alert.setContentText("参考文献已复制到剪贴板");
        alert.setTitle("已复制");
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
        alert.setContentText("开发者: Richard Gao | 高靖博 别骂了这是我的CS IA\n当前版本：v1.0.0 \n \n开源地址:\n github.com/ZhihchengGao/Keystone_Citation_Generator \n \n如有问题，请联系：richardgao2006@gmail.com");
        alert.setTitle("鼎石参考文献生成器");
        alert.showAndWait();
    }

    @FXML
    void handlemnuRefreg(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/ZhihchengGao/Keystone_Citation_Generator/wiki/User-Guide"));
    }

    @FXML
    void handleHelp(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/ZhihchengGao/Keystone_Citation_Generator/wiki/User-Guide#user-manual"));
    }
}
