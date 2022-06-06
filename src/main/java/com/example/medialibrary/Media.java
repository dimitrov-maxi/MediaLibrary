package com.example.medialibrary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Blob;

public class Media {

    private String name,author,genre,year,description, quantity;
    private Image img;

    public Media(String name, String author, String genre, String year, String description, String quantity/*, Blob picture*/) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
//    @Override
//    public String toString() {
//        return "Media{" +
//                "name='" + name + '\'' +
//                ", author='" + author + '\'' +
//                ", genre='" + genre + '\'' +
//                ", year='" + year + '\'' +
//                ", description='" + description + '\'' +
//                ", img=" + img +
//                '}';
//    }
}
