package org.bebka.jdbc.dao;

import org.bebka.jdbc.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO {
    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS userss (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tablo oluşturuldu");
        } catch (SQLException e) {
            throw new RuntimeException("Tablo oluşturulmadı");
        }
    }

    @Override
    public void saveUser(User user) {
        String sql="INSERT INTO userss(name,email) VALUES(?,?)";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Kayıt tamamlandı");
        } catch (SQLException e) {
            throw new RuntimeException("Kayıtta problem");
        }

        }

    }

