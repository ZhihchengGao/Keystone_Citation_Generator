module com.example.kcg_intellij {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires pinyin4j;


    opens com.example.kcg_intellij to javafx.fxml;
    exports com.example.kcg_intellij;
}