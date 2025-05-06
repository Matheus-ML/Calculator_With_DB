package com.example.calculadorakz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/calculator";
        String user = "root";
        String password = "";

        try {
            Connection conectar = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
            return conectar;
        } catch (SQLException e) {
            System.out.println("Não foi possível: " + e.getMessage());
            return null;
        }
    }

}
