package org.bebka.jdbc;

import org.bebka.jdbc.config.DataBaseConfig;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
String sql = "CREATE TABLE IF NOT EXISTS users (" +
        "id SERIAL PRIMARY KEY," +
        "name VARCHAR(100)," +
        "email VARCHAR(100))";
        try {
            Connection connection = DriverManager.getConnection(DataBaseConfig.DATABASE_URL,
                    DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Tablo oluşturuldu");

            //preparedstatement
            String insertSql = "INSERT INTO users(name,email) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1,"Ali");
            preparedStatement.setString(2,"ali@mail.com");
            preparedStatement.executeUpdate();
            System.out.println("Veri başarıyla eklendi");

            //resultset ile veri ekleme
            String selectSql = "SELECT * FROM users";
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectSql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email =resultSet.getString("email");
                System.out.println("ID: " + id + "Ad: " + name + "Email: " + email);
            }
            resultSet.close();
            selectStatement.close();
            preparedStatement.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}