package com.food.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url =
            "jdbc:mysql://localhost:3306/food_delivery_application";

    private static final String username = "root";
    private static final String password = "root";

    private static Connection connection = null;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection is created");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}