package org.example;

import org.example.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vendas");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String produto = resultSet.getString("produto");
                Double valor = resultSet.getDouble("valor");
                int qdeDisponivel = resultSet.getInt("qdeDisponivel");

                System.out.printf("ID: %d, produto: %s, valor: %.2f, qdeDisponivel: %d \n",
                        id, produto, valor, qdeDisponivel);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}