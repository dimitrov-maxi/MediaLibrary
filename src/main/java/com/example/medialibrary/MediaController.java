package com.example.medialibrary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MediaController {
    @FXML
    private Label Name,Author,Genre,Year;
    @FXML
    private ImageView Pic;

    private Media media;

    public void setData(Media media){
        this.media = media;
        Name.setText(media.getName());
        Author.setText(media.getAuthor());
        Genre.setText(media.getGenre());
        Year.setText(media.getYear());
        Image image = new Image(getClass().getResourceAsStream(media.getImg()));
        Pic.setImage(image);

    }
}
