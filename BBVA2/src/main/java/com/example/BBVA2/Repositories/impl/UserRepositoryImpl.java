package com.example.BBVA2.Repositories.impl;

import com.example.BBVA2.DoMain.User;
import com.example.BBVA2.Repositories.UserRepository;
import org.springframework.stereotype.Repository;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final static String url = "jdbc:h2:~/test";
    private final static String user = "sa";
    private final static String pass = "";

    @Override
    public Optional<User> findByNameAndPassword(String name, String aPass) {
        try (var connection = DriverManager.getConnection(url, user, pass);
             var preparedStatment = connection.prepareCall("SELECT * FROM users WHERE name = ? AND pass = ?")) {
            preparedStatment.setString(1, name);
            preparedStatment.setString(2, aPass);
            var resultSet = preparedStatment.executeQuery();
            if (resultSet.next()){
                return Optional.of(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("pass"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public User create(User anUser) {
        try (var connection = DriverManager.getConnection(url, user, pass);
             var preparedStatment = connection.prepareCall("INSERT INTO users (name, pass, surname, age) values (?,?,?,?)"))
        {
            preparedStatment.setString(1, anUser.name());
            preparedStatment.setString(2, anUser.pass());
            preparedStatment.setString(3, anUser.surname());
            preparedStatment.setInt(4, anUser.age());
            preparedStatment.executeUpdate();
            return anUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}