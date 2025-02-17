package com.example.kcg_intellij;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class MainNewCitationController {

    public boolean citation_isOnline = false;
    public boolean citation_hasOtherAuthor = false;
    public boolean citation_hasPageNo = false;

    @FXML
    private TextField txtAccessedDay;

    @FXML
    private VBox areaMNJ;

    @FXML
    private VBox areaZ;

    @FXML
    private HBox areaMain;

    @FXML
    private CheckBox checkHasOtherAuthor;

    @FXML
    private CheckBox checkHasPageNumber;

    @FXML
    private CheckBox checkOnline;

    @FXML
    private MenuButton mnubtnCitationType;

    @FXML
    private TextField txtAccessedMonth;

    @FXML
    private TextField txtAccessedYear;

    @FXML
    private TextField txtEndingPage;

    @FXML
    private TextField txtEnterAuthor;

    @FXML
    private TextField txtEnterPublishedPlace;

    @FXML
    private TextField txtEnterURL;

    @FXML
    private TextField txtEnterPublisher;

    @FXML
    private TextField txtEnterTitle;

    @FXML
    private TextField txtInterviewDay;

    @FXML
    private TextField txtInterviewMonth;

    @FXML
    private TextField txtInterviewYear;

    @FXML
    private TextField txtInterviewer;

    @FXML
    private TextField txtIssueNumber;

    @FXML
    private TextField txtOtherAuthor;

    @FXML
    private TextField txtPublishDay;

    @FXML
    private TextField txtPublishMonth;

    @FXML
    private TextField txtPublishYear;

    @FXML
    private TextField txtStartingPage;

    @FXML
    private TextField txtVolumeNumber;

    @FXML
    private TextField txtInterviewee;

    @FXML
    private Text puretxtPublisher;

    @FXML
    private Button btnConfirm;

    private String citationType = null;
    
    private MainController mainController; // Reference to the main controller
    private ActionEvent event;

    // Setter method to receive the main controller
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        areaMNJ.setVisible(false);
        areaZ.setVisible(false);
        areaMain.setVisible(false);
        btnConfirm.setDisable(true);
    }

    @FXML
    void handleAccessedDay(ActionEvent event) {

    }

    @FXML
    void handleAccessedMonth(ActionEvent event) {

    }

    @FXML
    void handleAccessedYear(ActionEvent event) {

    }

    @FXML
    void handleEndingPage(ActionEvent event) {

    }

    @FXML
    void handleHasOtherAuthor(ActionEvent event) {

    }

    @FXML
    void handleHasPageNumber(ActionEvent event) {

    }

    @FXML
    void handleInterviewDay(ActionEvent event) {

    }

    @FXML
    void handleInterviewMonth(ActionEvent event) {

    }

    @FXML
    void handleInterviewYear(ActionEvent event) {

    }

    @FXML
    void handleIssueNumber(ActionEvent event) {

    }

    @FXML
    void handleOnline(ActionEvent event) {

    }

    @FXML
    void handleOtherAuthor(ActionEvent event) {

    }

    @FXML
    void handlePublishMonth(ActionEvent event) {

    }

    @FXML
    void handlePublishYear(ActionEvent event) {

    }

    @FXML
    void handleSelectD(ActionEvent event) {
        citationType = "D";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(false);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("论文[D]");

        checkOnline.setSelected(false);
        checkHasOtherAuthor.setDisable(false);
        checkHasPageNumber.setDisable(false);
        checkOnline.setDisable(false);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(false);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(true);
        txtPublishMonth.setDisable(true);
        txtAccessedMonth.setDisable(true);
        txtAccessedYear.setDisable(true);
        txtAccessedDay.setDisable(true);
        txtEnterURL.setDisable(true);

        puretxtPublisher.setText("发布者");

        checkOnline.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtAccessedMonth.setDisable(false);
                txtAccessedYear.setDisable(false);
                txtAccessedDay.setDisable(false);
                txtEnterURL.setDisable(false);
                citation_isOnline = true;
            } else { // Checkbox is not selected
                txtAccessedMonth.setDisable(true);
                txtAccessedYear.setDisable(true);
                txtAccessedDay.setDisable(true);
                txtEnterURL.setDisable(true);
                citation_isOnline = false;
            }
        });
    }

    @FXML
    void handleSelectDBOL(ActionEvent event) {
        citationType = "DBOL";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(false);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("数据库[DB/OL]");

        checkHasOtherAuthor.setDisable(false);
        checkHasPageNumber.setDisable(false);
        checkOnline.setSelected(true);
        checkOnline.setDisable(true);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(false);
        txtPublishMonth.setDisable(false);
        txtAccessedMonth.setDisable(false);
        txtAccessedYear.setDisable(false);
        txtAccessedDay.setDisable(false);
        txtEnterURL.setDisable(false);

        puretxtPublisher.setText("发布者");

    }

    @FXML
    void handleSelectEBOL(ActionEvent event) {
        citationType = "EBOL";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(false);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("网页[EB/OL]");

        checkHasOtherAuthor.setDisable(false);
        checkHasPageNumber.setDisable(false);
        checkOnline.setSelected(true);
        checkOnline.setDisable(true);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(false);
        txtPublishMonth.setDisable(false);
        txtAccessedMonth.setDisable(false);
        txtAccessedYear.setDisable(false);
        txtAccessedDay.setDisable(false);
        txtEnterURL.setDisable(false);

        puretxtPublisher.setText("发布者");

    }

    @FXML
    void handleSelectJ(ActionEvent event) {
        this.event = event;
        citationType = "J";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(true);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("期刊[J]");

        checkOnline.setSelected(false);
        checkHasPageNumber.setSelected(false);
        checkHasOtherAuthor.setSelected(false);
        checkHasOtherAuthor.setDisable(true);
        checkHasPageNumber.setDisable(false);
        checkOnline.setDisable(false);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(true);
        txtPublishMonth.setDisable(true);
        txtAccessedMonth.setDisable(true);
        txtAccessedYear.setDisable(true);
        txtAccessedDay.setDisable(true);
        txtEnterURL.setDisable(true);
        txtStartingPage.setDisable(true);
        txtEndingPage.setDisable(true);
        txtOtherAuthor.setDisable(true);
        txtVolumeNumber.setDisable(false);
        txtIssueNumber.setDisable(false);

        puretxtPublisher.setText("出版社");

        checkOnline.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtAccessedMonth.setDisable(false);
                txtAccessedYear.setDisable(false);
                txtAccessedDay.setDisable(false);
                txtEnterURL.setDisable(false);
                citation_isOnline = true;
            } else { // Checkbox is not selected
                txtAccessedMonth.setDisable(true);
                txtAccessedYear.setDisable(true);
                txtAccessedDay.setDisable(true);
                txtEnterURL.setDisable(true);
                citation_isOnline = false;
            }
        });

        checkHasOtherAuthor.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtOtherAuthor.setDisable(false);
                citation_hasOtherAuthor = true;
            } else { // Checkbox is not selected
                txtOtherAuthor.setDisable(true);
                citation_hasOtherAuthor = false;
            }
        });

        checkHasPageNumber.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                txtStartingPage.setDisable(false);
                txtEndingPage.setDisable(false);
                citation_hasPageNo = true;
            } else {
                txtStartingPage.setDisable(true);
                txtEndingPage.setDisable(true);
                citation_hasPageNo = false;
            }
        });
    }

    @FXML
    void handleSelectM(ActionEvent event) {
        citationType = "M";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(true);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("普通图书[M]");

        checkHasOtherAuthor.setDisable(false);
        checkHasOtherAuthor.setSelected(false);
        checkHasPageNumber.setDisable(true);
        checkHasPageNumber.setSelected(true);
        checkOnline.setDisable(false);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(false);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(true);
        txtPublishMonth.setDisable(true);
        txtAccessedMonth.setDisable(true);
        txtAccessedYear.setDisable(true);
        txtAccessedDay.setDisable(true);
        txtEnterURL.setDisable(true);
        txtStartingPage.setDisable(false);
        txtEndingPage.setDisable(false);
        txtOtherAuthor.setDisable(true);
        txtVolumeNumber.setDisable(true);
        txtIssueNumber.setDisable(true);

        puretxtPublisher.setText("出版社");


        checkOnline.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtAccessedMonth.setDisable(false);
                txtAccessedYear.setDisable(false);
                txtAccessedDay.setDisable(false);
                txtEnterURL.setDisable(false);
                citation_isOnline = true;
            } else { // Checkbox is not selected
                txtAccessedMonth.setDisable(true);
                txtAccessedYear.setDisable(true);
                txtAccessedDay.setDisable(true);
                txtEnterURL.setDisable(true);
                citation_isOnline = false;
            }
        });

        checkHasOtherAuthor.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtOtherAuthor.setDisable(false);
                citation_hasOtherAuthor = true;
            } else { // Checkbox is not selected
                txtOtherAuthor.setDisable(true);
                citation_hasOtherAuthor = false;
            }
        });
        checkOnline.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtAccessedMonth.setDisable(false);
                txtAccessedYear.setDisable(false);
                txtAccessedDay.setDisable(false);
                txtEnterURL.setDisable(false);
                citation_isOnline = true;
            } else { // Checkbox is not selected
                txtAccessedMonth.setDisable(true);
                txtAccessedYear.setDisable(true);
                txtAccessedDay.setDisable(true);
                txtEnterURL.setDisable(true);
                citation_isOnline = false;
            }
        });

        checkHasOtherAuthor.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtOtherAuthor.setDisable(false);
                citation_hasOtherAuthor = true;
            } else { // Checkbox is not selected
                txtOtherAuthor.setDisable(true);
                citation_hasOtherAuthor = false;
            }
        });

        checkHasPageNumber.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                txtStartingPage.setDisable(false);
                txtEndingPage.setDisable(false);
                citation_hasPageNo = true;
            } else {
                txtStartingPage.setDisable(true);
                txtEndingPage.setDisable(true);
                citation_hasPageNo = false;
            }
        });
    }

    @FXML
    //
    void handleSelectN(ActionEvent event) {
        citationType = "N";
        btnConfirm.setDisable(false);
        // Basic fields that needs to be shown for 'NEWS' entry
        areaMNJ.setVisible(true);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("报纸[N]"); // Set the menu button to show selected type

        // Basic attributes that needs to be shown for 'NEWS' entry

        checkHasOtherAuthor.setSelected(false);
        checkHasPageNumber.setSelected(false);
        checkHasOtherAuthor.setDisable(true);
        checkHasPageNumber.setDisable(false);
        checkOnline.setDisable(false);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(true);
        txtPublishMonth.setDisable(true);
        txtAccessedMonth.setDisable(true);
        txtAccessedYear.setDisable(true);
        txtAccessedDay.setDisable(true);
        txtEnterURL.setDisable(true);
        txtStartingPage.setDisable(true);
        txtEndingPage.setDisable(true);
        txtOtherAuthor.setDisable(true);
        txtVolumeNumber.setDisable(false);
        txtIssueNumber.setDisable(false);
        checkOnline.setSelected(false);

        puretxtPublisher.setText("出版社");


        // Listener to actively check if the checkbox is selected or not
        checkOnline.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Check if 'Online' is selected => show attributes for online sources
                txtAccessedMonth.setDisable(false);
                txtAccessedYear.setDisable(false);
                txtAccessedDay.setDisable(false);
                txtEnterURL.setDisable(false);
                citation_isOnline = true;
            } else { // If Checkbox 'Online' is not selected => hide attributes for online sources
                txtAccessedMonth.setDisable(true);
                txtAccessedYear.setDisable(true);
                txtAccessedDay.setDisable(true);
                txtEnterURL.setDisable(true);
                citation_isOnline = false;
            }
        });
        // Listener to actively check if the checkbox is selected or not
        checkHasOtherAuthor.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Check if 'Has another author' is selected => show attributes for online
                            // sources
                txtOtherAuthor.setDisable(false);
                citation_hasOtherAuthor = true;
            } else { // Has another author is not selected => show attributes for online sources
                txtOtherAuthor.setDisable(true);
                citation_hasOtherAuthor = false;
            }
        });
        // Listener to actively check if the checkbox is selected or not
        checkHasPageNumber.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Check if 'has page number' is selected => show attributes for online sources
                txtStartingPage.setDisable(false);
                txtEndingPage.setDisable(false);
                citation_hasPageNo = true;
            } else { // 'Has page number' is not selected => show attributes for online sources
                txtStartingPage.setDisable(true);
                txtEndingPage.setDisable(true);
                citation_hasPageNo = false;
            }
        });
    }

    @FXML
    void handleSelectR(ActionEvent event) {
        citationType = "R";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(false);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("调查报告[R]");

        checkOnline.setSelected(false);
        checkOnline.setDisable(false);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(false);
        txtPublishMonth.setDisable(false);
        txtAccessedMonth.setDisable(true);
        txtAccessedYear.setDisable(true);
        txtAccessedDay.setDisable(true);
        txtEnterURL.setDisable(true);

        puretxtPublisher.setText("发布者");

        checkOnline.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtAccessedMonth.setDisable(false);
                txtAccessedYear.setDisable(false);
                txtAccessedDay.setDisable(false);
                txtEnterURL.setDisable(false);
                citation_isOnline = true;
            } else { // Checkbox is not selected
                txtAccessedMonth.setDisable(true);
                txtAccessedYear.setDisable(true);
                txtAccessedDay.setDisable(true);
                txtEnterURL.setDisable(true);
                citation_isOnline = false;
            }
        });

    }

    @FXML
    void handleSelectZ_Forum(ActionEvent event) {
        citationType = "ZF";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(false);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("论坛帖子[Z/OL]");

        checkOnline.setSelected(false);
        checkHasOtherAuthor.setDisable(false);
        checkHasPageNumber.setDisable(false);
        checkOnline.setSelected(true);
        checkOnline.setDisable(true);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(false);
        txtPublishMonth.setDisable(false);
        txtAccessedMonth.setDisable(false);
        txtAccessedYear.setDisable(false);
        txtAccessedDay.setDisable(false);
        txtEnterURL.setDisable(false);

        puretxtPublisher.setText("发布者");

    }

    @FXML
    void handleSelectZ_Interview(ActionEvent event) {
        citationType = "ZI";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(false);
        areaZ.setVisible(true);
        areaMain.setVisible(true);
        areaMNJ.setManaged(false);
        mnubtnCitationType.setText("采访[Z]");

        checkOnline.setSelected(false);
        checkHasOtherAuthor.setDisable(false);
        checkHasPageNumber.setDisable(false);
        checkOnline.setSelected(false);
        checkOnline.setDisable(false);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(true);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(true);
        txtPublishDay.setDisable(true);
        txtPublishMonth.setDisable(true);
        txtAccessedMonth.setDisable(false);
        txtAccessedYear.setDisable(false);
        txtAccessedDay.setDisable(false);
        txtEnterURL.setDisable(true);
        txtInterviewee.setDisable(false);
        txtInterviewer.setDisable(false);
        txtInterviewDay.setDisable(false);
        txtInterviewMonth.setDisable(false);
        txtInterviewYear.setDisable(false);

        puretxtPublisher.setText("发布者");


        checkOnline.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Checkbox is selected
                txtAccessedMonth.setDisable(false);
                txtAccessedYear.setDisable(false);
                txtAccessedDay.setDisable(false);
                txtEnterURL.setDisable(false);
                citation_isOnline = true;
            } else { // Checkbox is not selected
                txtAccessedMonth.setDisable(true);
                txtAccessedYear.setDisable(true);
                txtAccessedDay.setDisable(true);
                txtEnterURL.setDisable(true);
                citation_isOnline = false;
            }
        });
    }

    @FXML
    void handleSelectZ_Wechat(ActionEvent event) {
        citationType = "ZW";
        btnConfirm.setDisable(false);
        areaMNJ.setVisible(false);
        areaZ.setVisible(false);
        areaMain.setVisible(true);
        mnubtnCitationType.setText("微信公众号文章[Z/OL]");

        checkHasOtherAuthor.setDisable(false);
        checkHasPageNumber.setDisable(false);
        checkOnline.setSelected(true);
        checkOnline.setDisable(true);
        txtEnterTitle.setDisable(false);
        txtEnterAuthor.setDisable(false);
        txtEnterPublisher.setDisable(false);
        txtEnterPublishedPlace.setDisable(true);
        txtPublishYear.setDisable(false);
        txtPublishDay.setDisable(false);
        txtPublishMonth.setDisable(false);
        txtAccessedMonth.setDisable(false);
        txtAccessedYear.setDisable(false);
        txtAccessedDay.setDisable(false);
        txtEnterURL.setDisable(false);

        puretxtPublisher.setText("发布者");

    }



    @FXML
    void handleStartingPage(ActionEvent event) {

    }

    @FXML
    void handleHelp(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/ZhihchengGao/Keystone_Citation_Generator/wiki/User-Guide#create-a-citation"));
    }

    @FXML
    void handleVolumeNumber(ActionEvent event) {

    }

    @FXML
    void handleInterviewee(ActionEvent event) {

    }

    @FXML
    void handleinterviewer(ActionEvent event) {

    }

    @FXML
    void txtPublishDay(ActionEvent event) {

    }

    private int errorType;

    @FXML
    void handleConfirm(ActionEvent event) {
        List<String> missingFields = new ArrayList<>(); // List to collect missing field names
        List<String> incorrectFields = new ArrayList<>(); // List to collect incorrectly formatted fields

        try {

            validateIntegerField(txtPublishYear, "出版/发布年份", missingFields, incorrectFields);
            validateIntegerField(txtPublishMonth, "出版/发布月份", missingFields, incorrectFields);
            validateIntegerField(txtPublishDay, "出版/发布日期", missingFields, incorrectFields);
            validateStringField(txtEnterPublishedPlace, "出版/发布地点", missingFields);
            validateIntegerField(txtAccessedYear, "访问年份", missingFields, incorrectFields);
            validateIntegerField(txtAccessedMonth, "访问月份", missingFields, incorrectFields);
            validateIntegerField(txtAccessedDay, "访问日期", missingFields, incorrectFields);
            validateStringField(txtEnterTitle, "文献标题", missingFields);
            validateStringField(txtEnterAuthor, "作者名", missingFields);
            validateStringField(txtEnterPublisher, "出版社/发布人", missingFields);
            validateStringField(txtEnterURL, "URL", missingFields);

            if (areaMNJ.isVisible()) {
                validateIntegerField(txtStartingPage, "起始页吗", missingFields, incorrectFields);
                validateIntegerField(txtEndingPage, "结束页码", missingFields, incorrectFields);
                validateIntegerField(txtVolumeNumber, "卷号", missingFields, incorrectFields);
                validateIntegerField(txtIssueNumber, "期号", missingFields, incorrectFields);
                if (citation_hasOtherAuthor) {
                    validateStringField(txtOtherAuthor, "其他作者名", missingFields);
                }
            }

            if (areaZ.isVisible()) {
                validateStringField(txtInterviewee, "被采访者", missingFields);
                validateStringField(txtInterviewer, "采访者", missingFields);
                validateIntegerField(txtInterviewDay, "采访日期", missingFields, incorrectFields);
                validateIntegerField(txtInterviewMonth, "采访月份", missingFields, incorrectFields);
                validateIntegerField(txtInterviewYear, "采访年份", missingFields, incorrectFields);
            }

            // If there are any errors, throw an exception
            if (!missingFields.isEmpty() || !incorrectFields.isEmpty()) {
                StringBuilder errorMessage = new StringBuilder();

                if (!missingFields.isEmpty()) {
                    errorMessage.append("您的文献缺失以下信息:\n");
                    for (String field : missingFields) {
                        errorMessage.append("- ").append(field).append("\n");
                    }
                }

                if (!incorrectFields.isEmpty()) {
                    errorMessage.append("\n以下信息的格式不正确:\n");
                    for (String field : incorrectFields) {
                        errorMessage.append("- ").append(field).append("\n");
                    }
                }

                throw new IllegalArgumentException(errorMessage.toString());
            }

            // If no errors, proceed with the next steps
            // Generate citation
            String newCitation = generateCitation();

            // Send the new citation to the main controller
            if (mainController != null) {
                mainController.addNewCitation(newCitation);
            }

            // Close this window
            ((Stage) txtEnterTitle.getScene().getWindow()).close();
            
        } catch (IllegalArgumentException e) {
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("输入信息有误");
            errorAlert.setHeaderText("请更正以下信息：");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateIntegerField(TextField field, String fieldName, List<String> missingFields,
            List<String> incorrectFields) {
        if (field.isDisabled()) {
            return; // Skip disabled or invisible fields
        }

        if (field.getText().trim().isEmpty()) {
            missingFields.add(fieldName); // Add to missing fields
            return;
        }

        try {
            Integer.parseInt(field.getText().trim()); // Check if the input is a valid integer
        } catch (NumberFormatException e) {
            incorrectFields.add(fieldName); // Add to incorrect fields
        }
    }

    private void validateStringField(TextField field, String fieldName, List<String> missingFields) {
        if (field.isDisabled()) {
            return; // Skip disabled or invisible fields
        }

        if (field.getText().trim().isEmpty()) {
            missingFields.add(fieldName); // Add to missing fields
        }
    }

    private String generateCitation() {

        boolean otherAuthor;
        boolean online;
        boolean page = true;
        String citation = null;

        int publishedYearNo;
        try {
            publishedYearNo = Integer.parseInt(txtPublishYear.getText());
        }catch (Exception e) {
            publishedYearNo = 0;
        }
        
        String accessedDate = txtAccessedYear.getText() + '-' + txtAccessedMonth.getText() + '-'
                + txtAccessedDay.getText();
        String publishedDate = txtPublishYear.getText() + '-' + txtPublishMonth.getText() + '-'
                + txtPublishDay.getText();
        String interviewDate = txtInterviewYear.getText() + '-' + txtInterviewMonth.getText() + '-'
                + txtInterviewDay.getText();

        if (citationType.equals("M")) {
            int startingPageNo = Integer.parseInt(txtStartingPage.getText());
            int endingPageNo = Integer.parseInt(txtEndingPage.getText());
            if (checkOnline.isSelected()) {
                online = true;
            } else {
                online = false;
            }

            if (checkHasOtherAuthor.isSelected()) {
                otherAuthor = true;
            } else {
                otherAuthor = false;
            }

            Book tempBook = new Book(
                    txtEnterAuthor.getText(),
                    otherAuthor,
                    txtOtherAuthor.getText(),
                    txtEnterTitle.getText(),
                    online,
                    txtEnterPublishedPlace.getText(),
                    txtEnterPublisher.getText(),
                    publishedYearNo,
                    startingPageNo,
                    endingPageNo,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateBook(tempBook);

        } else if (citationType.equals("N")) {
            int startingPageNo = 0;
            int endingPageNo = 0;
            int volumeNo = Integer.parseInt(txtVolumeNumber.getText());
            int issueNo = Integer.parseInt(txtIssueNumber.getText());
            if (checkOnline.isSelected()) {
                online = true;
            } else {
                online = false;
            }

            if (checkHasPageNumber.isSelected()) {
                page = true;
                startingPageNo = Integer.parseInt(txtStartingPage.getText());
                endingPageNo = Integer.parseInt(txtEndingPage.getText());
            } else {
                page = false;
            }

            Newspaper tempNews = new Newspaper(
                    txtEnterAuthor.getText(),
                    txtEnterTitle.getText(),
                    online,
                    txtEnterPublisher.getText(),
                    publishedYearNo,
                    volumeNo,
                    issueNo,
                    page,
                    startingPageNo,
                    endingPageNo,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateNewspaper(tempNews);

        } else if (citationType.equals("J")) {
            int startingPageNo = 0;
            int endingPageNo = 0;
            int volumeNo = Integer.parseInt(txtVolumeNumber.getText());
            int issueNo = Integer.parseInt(txtIssueNumber.getText());
            if (checkOnline.isSelected()) {
                online = true;
            } else {
                online = false;
            }

            if (checkHasPageNumber.isSelected()) {
                page = true;
                startingPageNo = Integer.parseInt(txtStartingPage.getText());
                endingPageNo = Integer.parseInt(txtEndingPage.getText());
            } else {
                page = false;
            }

            Journal tempJournal = new Journal(
                    txtEnterAuthor.getText(),
                    txtEnterTitle.getText(),
                    online,
                    txtEnterPublisher.getText(),
                    publishedYearNo,
                    volumeNo,
                    issueNo,
                    page,
                    startingPageNo,
                    endingPageNo,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateJournal(tempJournal);

        } else if (citationType.equals("D")) {
            if (checkOnline.isSelected()) {
                online = true;
            } else {
                online = false;
            }

            Article tempArticle = new Article(
                    txtEnterAuthor.getText(),
                    txtEnterTitle.getText(),
                    online,
                    txtEnterPublishedPlace.getText(),
                    txtEnterPublisher.getText(),
                    publishedYearNo,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateArticle(tempArticle);

        } else if (citationType.equals("R")) {
            if (checkOnline.isSelected()) {
                online = true;
            } else {
                online = false;
            }

            Report tempReport = new Report(
                    txtEnterAuthor.getText(),
                    txtEnterTitle.getText(),
                    online,
                    txtEnterPublisher.getText(),
                    publishedDate,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateReport(tempReport);

        } else if (citationType.equals("DBOL")) {

            OnlineSources tempDB = new OnlineSources(
                    txtEnterAuthor.getText(),
                    "DB",
                    txtEnterTitle.getText(),
                    txtEnterPublisher.getText(),
                    publishedDate,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateOnlineSources(tempDB);

        } else if (citationType.equals("EBOL")) {

            OnlineSources tempEB = new OnlineSources(
                    txtEnterAuthor.getText(),
                    "EB",
                    txtEnterTitle.getText(),
                    txtEnterPublisher.getText(),
                    publishedDate,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateOnlineSources(tempEB);

        } else if (citationType.equals("ZF")) {
            OnlineSources tempZI = new OnlineSources(
                    txtEnterAuthor.getText(),
                    "ZI",
                    txtEnterTitle.getText(),
                    txtEnterPublisher.getText(),
                    publishedDate,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateOnlineSources(tempZI);

        } else if (citationType.equals("ZI")) {
            if (checkOnline.isSelected()) {
                online = true;
            } else {
                online = false;
            }

            Interview tempZI = new Interview(
                    txtInterviewee.getText(),
                    txtInterviewer.getText(),
                    txtEnterTitle.getText(),
                    online,
                    txtEnterPublisher.getText(),
                    interviewDate,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateInterview(tempZI);

        } else if (citationType.equals("ZW")) {

            OnlineSources tempZW = new OnlineSources(
                    txtEnterAuthor.getText(),
                    "ZW",
                    txtEnterTitle.getText(),
                    txtEnterPublisher.getText(),
                    publishedDate,
                    accessedDate,
                    txtEnterURL.getText());

            Sorting_Code generator = Sorting_Code.getSortingCode();
            citation = generator.generateOnlineSources(tempZW);
        }

        return (citation);
    }
}
