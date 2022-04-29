package com.example.medialibrary;

import java.sql.DriverManager;

import static com.example.medialibrary.StaticVariables.dbURL;
import static com.example.medialibrary.StaticVariables.dbUser;
import static com.example.medialibrary.StaticVariables.dbPass;

public class Connection {
    public static void connect() {
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPass);
            System.out.println("Connection successful!");

            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }
}
