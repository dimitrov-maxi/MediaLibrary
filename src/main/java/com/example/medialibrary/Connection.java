package com.example.medialibrary;

import javafx.scene.image.Image;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.medialibrary.StaticVariables.dbURL;
//import static com.example.medialibrary.StaticVariables.dbUser;
//import static com.example.medialibrary.StaticVariables.dbPass;

public class Connection {
    public static void connect() {
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection successful!");


            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }
    public void FillMedia(){
        try {
            Media book = new Media();
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String Query = "SELECT Name,Author FROM Media" +
                    "INNER JOIN" +
                    "Year, Genre, Picture, Description FROM MediaDetails" +
                    "ON ID = ID;";
            PreparedStatement statement = conn.prepareStatement(Query);
            ResultSet rs = statement.executeQuery();
            book.setName(rs.getString("Name"));
            book.setAuthor(rs.getString("Author"));
            book.setGenre(rs.getString("Genre"));
            book.setYear(rs.getString("Year"));
            book.setDescription(rs.getString("Description"));
            book.setImg((Image) rs.getBlob("Picture"));

            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }

    }
}
