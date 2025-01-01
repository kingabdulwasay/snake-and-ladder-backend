package com.hawm.snakeandladder.repositories;
import java.sql.*;



public class DatabaseConnection {
    public static Connection connectDB() {
        String url = "jdbc:mysql://localhost:3306/snakeandladder";
        String user = "root";
        String password = "abdulwasayrais@@123";

        try {
             return DriverManager.getConnection(url, user, password);
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
            return null;

    }
}


