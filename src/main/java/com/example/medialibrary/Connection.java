package com.example.medialibrary;

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
    public void FillMedia(name, author, genre, year, description){
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String Query = "SELECT Name,Author FROM Media;" +
                    "SELECT Year, Genre, Description FROM MediaDetails;";
            PreparedStatement statement = conn.prepareStatement(Query);
            ResultSet rs = statement.executeQuery();

            name = rs.getString("Name");

            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }
}
