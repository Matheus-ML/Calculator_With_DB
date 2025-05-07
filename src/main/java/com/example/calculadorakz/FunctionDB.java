package com.example.calculadorakz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FunctionDB {
    public static void input(String nr_calc, String nr_expression) {
        String sqlInput = "INSERT INTO historic (nr_calc,nr_expression) VALUES (?, ?)";

        try (Connection conectar = ConnectionDB.conectar()) {
            assert conectar != null;
            try (PreparedStatement stmt = conectar.prepareStatement(sqlInput)) {

                stmt.setString(1, nr_calc);
                stmt.setString(2, nr_expression);
                stmt.executeUpdate();

            }
        } catch (SQLException e) {
            HelloController.alert("Error","Erro ao inserir: " + e.getMessage());
        }
    }

    public static void getHistoric(){
        String getHistoricSQL = "SELECT nr_calc, nr_expression FROM historic GROUP BY cd_historic" ;

        try(Connection conectar = ConnectionDB.conectar()){
            assert conectar != null;
            try(PreparedStatement stmt = conectar.prepareStatement(getHistoricSQL)){

                StringBuilder historic = new StringBuilder();
                historic.append(stmt);
                System.out.println(historic);

            }
        }catch (SQLException e){
            HelloController.alert("Error","Erro ao inserir: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        getHistoric();
    }

}
