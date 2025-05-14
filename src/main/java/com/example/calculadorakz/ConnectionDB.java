package com.example.calculadorakz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/calculator?useUnicode=true&characterEncoding=utf8mb4";

        String user = "root";
        String password = "";

        try {
            Connection conectar = DriverManager.getConnection(url, user, password);
            return conectar;
        } catch (SQLException e) {
            System.out.println("Não foi possível: " + e.getMessage());
            return null;
        }
    }

}
