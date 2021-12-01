package com.example.leaveapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Db {
    public static Connection getConnecection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =DriverManager.getConnection("jdbc:mysql://localhost/Leave", "root", "");
            System.out.println("Connection succeed");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return null;

    }

}
