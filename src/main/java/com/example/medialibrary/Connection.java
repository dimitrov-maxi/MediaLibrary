package com.example.medialibrary;

import javafx.scene.image.Image;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.medialibrary.StaticVariables.dbURL;

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
    public static boolean checkAdmins(String email, String password) {
        try {
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);
            String query = "SELECT * FROM AdminInfo WHERE email = ? and password = ?;";
            PreparedStatement loginCheck = conn.prepareStatement(query);
            loginCheck.setString(1, email);
            loginCheck.setString(2, password);
            ResultSet result = loginCheck.executeQuery();

            if (result.next()) {
                return true;
            }
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
        return false;

    }
    public static void insertUser(String addUserQuery) {
        try {
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);
            PreparedStatement InsertUser = conn.prepareStatement(addUserQuery);
            InsertUser.executeUpdate();
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }

    public static void insertAdmin(String addAdminQuery) {
        try {
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);
            PreparedStatement InsertUser = conn.prepareStatement(addAdminQuery);
            InsertUser.executeUpdate();
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }

//    public void FillMedia(){
//        try {
//            Media book = new Media();
//            java.sql.Connection conn = DriverManager.getConnection(dbURL);
//            String Query = "SELECT Name, Author,Year, Genre, Description, Picture\n" +
//                    "FROM Media m \n" +
//                    "Left JOIN MediaDetails md \n" +
//                    "ON m.ID = md.ID;";
//            PreparedStatement statement = conn.prepareStatement(Query);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()) {
//                book.setName(rs.getString("Name"));
//                book.setAuthor(rs.getString("Author"));
//                book.setGenre(rs.getString("Genre"));
//                book.setYear(rs.getString("Year"));
//                book.setDescription(rs.getString("Description"));
//                book.setImg((Image) rs.getBlob("Picture"));
//            }
//            conn.close();
//        } catch (Exception ConnErr) {
//            System.out.print("Did not connect to DB - Error: " + ConnErr);
//        }
//
//    }
}
