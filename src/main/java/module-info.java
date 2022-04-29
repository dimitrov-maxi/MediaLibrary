module com.example.medialibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.medialibrary to javafx.fxml;
    exports com.example.medialibrary;
}