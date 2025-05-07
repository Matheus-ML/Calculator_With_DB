package com.example.calculadorakz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static String getHistoric(){
        String getHistoricSQL = "SELECT cd_historic, nr_expression, nr_calc FROM historic ORDER BY cd_historic" ;
        StringBuilder historic = new StringBuilder();
        try(Connection conectar = ConnectionDB.conectar()){
            assert conectar != null;
            try(PreparedStatement stmt = conectar.prepareStatement(getHistoricSQL);ResultSet rs = stmt.executeQuery()){

                while(rs.next()){
                    String cd =rs.getString("cd_historic");
                    String calc = rs.getString("nr_calc");
                    String expression = rs.getString("nr_expression");

                    historic.append(cd).append("|  ").append(expression).append(" ").append(calc).append("\n");
                }


            }
        }catch (SQLException e){
            HelloController.alert("Error","Erro ao inserir: " + e.getMessage());
        }
        return historic.toString();
    }

    public static void main(String[] args) {
        getHistoric();
    }

}
