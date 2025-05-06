package com.example.calculadorakz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FunctionDB {
    public static void input(String nr_calc, String nr_expression) {
        String sqlInput = "INSERT INTO historic (nr_calc,nr_expression) VALUES (?, ?)";

        try (Connection conn = ConnectionDB.conectar()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sqlInput)) {

                stmt.setString(1, nr_calc);
                stmt.setString(2, nr_expression);
                stmt.executeUpdate();

            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public static void getHistoric(){

    }

}
