package com.example.kcg_intellij;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainEditCitationController implements Initializable {

    @FXML
    private TableColumn<TableView_Citations, String> columnCitationColumn;

    @FXML
    void handleHelp(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/ZhihchengGao/Keystone_Citation_Generator/wiki/User-Guide#delete-a-citation"));

    }

    @FXML
    private TableView<TableView_Citations> tableCitationTable;

    @FXML
    void handleCitationTable(ActionEvent event) {
    }

    @FXML
    void handleDeleteThisCitation(ActionEvent event) {
        deletingCitation(tableCitationTable.getSelectionModel().getSelectedItems().toString());
        tableCitationTable.getItems().removeAll(tableCitationTable.getSelectionModel().getSelectedItems());
    }

    private Sorting_Code sortingCode;
    public void setSortingcode(Sorting_Code sortingCode) {this.sortingCode = sortingCode;}

    @FXML
    void handleConfirm(ActionEvent event) throws IOException, URISyntaxException {
        if (mainController != null) {
            mainController.deleteCitation(getDeletedCitationNo());
        }
        ((Stage) tableCitationTable.getScene().getWindow()).close();
    }

    // ObservableList to back the TableView
    private final ObservableList<TableView_Citations> List = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSortingcode(Sorting_Code.getSortingCode());
        columnCitationColumn.setCellValueFactory(new PropertyValueFactory<>("columnCitation"));
        tableCitationTable.setItems(List);
        ArrayList<String> listCitations = sortingCode.getCitationEntries();
        int Amount = 0;
        for (String entry : listCitations){
            Amount ++;
            TableView_Citations citation = new TableView_Citations(entry);
            List.add(citation);
        }
        createArray(Amount);
    }

    public Object[][]Citations;
    private void createArray(int Amount){
        int i = 1;
        Citations = new Object[Amount][2];
        for(TableView_Citations citation : List){
            Citations[i-1][0] = i;
            Citations[i-1][1] = tableCitationTable.getItems().get(i-1);
            i++;
        }
    }

    private MainController mainController; // Reference to the main controller

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    ArrayList<Integer> deletedCitationNo = new ArrayList<>();

    public void deletingCitation(String deletedCode){
        int tempCode = 0;
        for (int i = 1; i <= Citations.length; i++){
            String tempTest = "[" + (Citations[i-1][1].toString()) + "]";
            if(tempTest.equals(deletedCode)){
                tempCode = i-1;
            }
        }
        deletedCitationNo.add((Integer) Citations[tempCode][0]);
    }

    public ArrayList<Integer> getDeletedCitationNo() {
        return deletedCitationNo;
    }
}