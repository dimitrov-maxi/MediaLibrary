package com.example.medialibrary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static com.example.medialibrary.StaticVariables.dbURL;

public class BookPage implements Initializable {

    @FXML
    private Stage stage;


    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TableView<Media> Books;

    @FXML
    private TableColumn<Media, String> AuthorCol;

    @FXML
    private TableColumn<Media, String> GenreCol;

    @FXML
    private TableColumn<Media, String> NameCol;

//    @FXML
//    private TableColumn<Media, Boolean> OrderCol;

//    @FXML
//    private TableColumn<Media, Image> PicCol;

    @FXML
    private TableColumn<Media, Integer> YearCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Media> MediaList = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection successful!");
            String Query = """
                    SELECT Name, Author,Year, Genre, Description, Picture, Quantity
                    FROM Media m\s
                    Left JOIN MediaDetails md\s
                    ON m.ID = md.ID;""";
            PreparedStatement statement = conn.prepareStatement(Query);
            ResultSet rs = statement.executeQuery();

            MediaList = FXCollections.observableArrayList();
            while(rs.next()) {
                System.out.println(rs.getString("Name") + "||" + rs.getString("Author"));
                MediaList.add(new Media(
                        rs.getString("Name"),
                        rs.getString("Author"),
                        rs.getString("Genre"),
                        rs.getString("Year"),
                        rs.getString("Description"),
                        rs.getString("Quantity")
                        /*rs.getBlob("Picture")*/));
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }

        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        AuthorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        GenreCol.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        //PicCol.setCellValueFactory(new PropertyValueFactory<>("Picture"));
        YearCol.setCellValueFactory(new PropertyValueFactory<>("Year"));


        //Books.setItems(null);
        Books.setItems(MediaList);
    }
}
