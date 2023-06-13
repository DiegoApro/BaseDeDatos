package com.example.BBVA2.Config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class AppConfig implements ApplicationRunner {

    private final static String url = "jdbc:h2:~/test";
    private final static String user = "sa";
    private final static String pass = "";

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // dropTable();


    }


    public void dropTable() {
        try (var connection = DriverManager.getConnection(url, user, pass);
             var preparedStatment = connection.prepareStatement("DROP TABLE IF EXISTS users")) {

            preparedStatment.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
