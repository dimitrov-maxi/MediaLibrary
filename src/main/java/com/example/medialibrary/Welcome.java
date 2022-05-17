package com.example.medialibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView Img;

    @FXML
    private Label authorLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;

    private static List<Media> media = new ArrayList<>();

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

//    private void setChosenMedia(Media media) {
//        nameLabel.setText(media.getName());
//        authorLabel.setText(media.getAuthor());
//        genreLabel.setText(media.getGenre());
//        yearLabel.setText(media.getYear());
//        //Img = new Image(getClass().getResourceAsStream(media.getImg());
//
//    }

//    public static void printMedia(){
//        for (int i = 0; i < media.size();i++)
//        {
//            System.out.println(media.get(i).toString());
//        }
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        media.addAll(getData());
//        if (media.size() > 0) {
//            setChosenMedia(media.get(0));
//        }
        int column = 0;
        int row = 1;

        try{
        for (int i = 0; i < media.size(); i++) {
            System.out.println(media.get(i).toString());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Media.fxml"));
            AnchorPane anchor = loader.load();

            MediaController mediaController = loader.getController();
            mediaController.setData(media.get(i));

            if (column==3){
                column=0;
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
