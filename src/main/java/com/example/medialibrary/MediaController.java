package com.example.medialibrary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MediaController {

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

    private Media media;

    public void setData(Media media){
        this.media = media;
        nameLabel.setText(media.getName());
        authorLabel.setText(media.getAuthor());
        genreLabel.setText(media.getGenre());
        yearLabel.setText(media.getYear());
        //Image image = new Image(getClass().getResourceAsStream(media.getImg("dada")));
        Img.setImage(new Image("resources/Drivers/pictures.jpg"));

    }
}
