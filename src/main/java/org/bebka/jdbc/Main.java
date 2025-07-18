package org.bebka.jdbc;

import org.bebka.jdbc.config.DataBaseConfig;
import org.bebka.jdbc.config.DataBaseConnectorConfig;
import org.bebka.jdbc.dao.UserDAOImpl;
import org.bebka.jdbc.user.User;

import java.sql.*;
import java.util.concurrent.Callable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//String sql = "CREATE TABLE IF NOT EXISTS users (" +
//        "id SERIAL PRIMARY KEY," +
//        "name VARCHAR(100)," +
//        "email VARCHAR(100))";
//        try {
//            Connection connection = DriverManager.getConnection(DataBaseConfig.DATABASE_URL,
//                    DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//            System.out.println("Tablo oluşturuldu");
//
//            //preparedstatement
//            String insertSql = "INSERT INTO users(name,email) VALUES (?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
//            preparedStatement.setString(1,"Ali");
//            preparedStatement.setString(2,"ali@mail.com");
//            preparedStatement.executeUpdate();
//            System.out.println("Veri başarıyla eklendi");
//
//            //resultset ile veri ekleme
//            String selectSql = "SELECT * FROM users";
//            Statement selectStatement = connection.createStatement();
//            ResultSet resultSet = selectStatement.executeQuery(selectSql);
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String email =resultSet.getString("email");
//                System.out.println("ID: " + id + "Ad: " + name + "Email: " + email);
//            }
//
//            //update and delete
//            String updateSql = "UPDATE users SET name = ? WHERE id = ?";
//            PreparedStatement updateStatement = connection.prepareStatement(updateSql);
//            updateStatement.setString(1,"Veli");
//            updateStatement.setInt(2,1);
//            int updateCount = updateStatement.executeUpdate();
//            System.out.println(updateCount + "kayıt güncellendi");
//            String deleteSql = "DELETE FROM users WHERE id = ?";
//            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
//            deleteStatement.setInt(1,2);
//            int deleteCount = deleteStatement.executeUpdate();
//            System.out.println(deleteCount + "kayıt silindi.");
//
//            updateStatement.close();
//            deleteStatement.close();
//            resultSet.close();
//            selectStatement.close();
//            preparedStatement.close();
//            statement.close();
//            connection.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
        try {

            DataBaseConnectorConfig.setConnection();
            Connection connection = DataBaseConnectorConfig.getConnection();
            UserDAOImpl userDAO = new UserDAOImpl(connection);
            //userDAO.createTable();
            User user= new User(0,"Bahar","bahar@gmail.com");
            userDAO.saveUser(user);






        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



