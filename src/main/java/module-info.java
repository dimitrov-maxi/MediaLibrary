module com.example.medialibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.medialibrary to javafx.fxml;
    exports com.example.medialibrary;
}