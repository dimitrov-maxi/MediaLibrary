package com.example.medialibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Welcome implements Initializable{

//    @FXML
//    private Label Name,Author,Genre,Year;
//    private ImageView Pic;

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;

    private List<Media> media = new ArrayList<>();

    public Welcome() {
    }

    private List<Media> getData(){
        List<Media> media = new ArrayList<>();
        Media book;

        //for (int i = 0; i < 5; i++) {
            book = new Media();
            book.setName("If it Bleeds");
            book.setAuthor("Stephen King");
            book.setGenre("Horror");
            book.setYear("2020");
            book.setImg(new Image("resources/Drivers/pictures.jpg"));
            media.add(book);

            book = new Media();
            book.setName("If it Bleeds");
            book.setAuthor("Stephen King");
            book.setGenre("Horror");
            book.setYear("2020");
            book.setImg(new Image("resources/Drivers/pictures.jpg"));
            media.add(book);

            book = new Media();
            book.setName("If it Bleeds");
            book.setAuthor("Stephen King");
            book.setGenre("Horror");
            book.setYear("2020");
            book.setImg(new Image("resources/Drivers/pictures.jpg"));
            media.add(book);

            book = new Media();
            book.setName("If it Bleeds");
            book.setAuthor("Stephen King");
            book.setGenre("Horror");
            book.setYear("2020");
            book.setImg(new Image("resources/Drivers/pictures.jpg"));
            media.add(book);

        //  }
        return media;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        media.addAll(getData());
        int column = 0;
        int row = 1;

        try{
        for (int i = 0; i < media.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Media.fxml"));

            AnchorPane anchor = loader.load();


            MediaController mediaController = loader.getController();
            mediaController.setData(media.get(i));

            if (column==3){
                column =0;
                row++;
            }

            grid.add(anchor,column++,row);
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_PREF_SIZE);

            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_PREF_SIZE);

            GridPane.setMargin(anchor, new Insets(10, 10, 10, 10));
        }
    }catch(IOException mediaERR){
            System.out.println("Error: " + mediaERR);
        }
    }
}
