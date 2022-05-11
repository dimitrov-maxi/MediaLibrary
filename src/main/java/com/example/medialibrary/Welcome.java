package com.example.medialibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Welcome implements Initializable{

    @FXML
    private Label Name,Author,Genre,Year;
    private ImageView Pic;
    private ScrollPane Scroll;
    private GridPane Grid;

    private List<Media> media = new ArrayList<>();

    private List<Media> getData(){
        List<Media> media = new ArrayList<>();
        Media book;

        for (int i = 0; i < 5; i++) {
            book = new Media();
            book.setName("If it Bleeds");
            book.setAuthor("Stephen King");
            book.setGenre("Horror");
            book.setYear("2020");
            book.setImg(new Image("resources/Drivers/pictures.jpg"));
            media.add(book);
        }
        return media;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        media.addAll(getData());
        int column = 0;
        int row = 0;

        try{
        for (int i = 0; i < media.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Media.fxml"));

            AnchorPane anchor = loader.load();


            Media media = loader.getController();
            //media.setData(media.get(i));

            if (column==3){
                column =0;
                row++;
            }

            Grid.add(anchor,column++,row);
            //GridPane.setMargin();
        }
    }catch(IOException mediaERR){
            System.out.println("Error: " + mediaERR);
        }
    }
}
