package org.bebka.jdbc;

import org.bebka.jdbc.config.DataBaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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

            preparedStatement.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}