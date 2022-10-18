package ru.kpfu.itis.selyantsev.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;


public class PostgresConnectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostgresConnectionUtil.class);
    private static Connection connection;
    public static Connection getConnection() {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("resources/db.properties");
            property.load(fis);

            String url = property.getProperty("db.url");
            String username = property.getProperty("db.username");
            String password = property.getProperty("db.password");

            if (connection == null) {
                connection = DriverManager.getConnection(
                        url,
                        username,
                        password
                );
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
