package com.softeem.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceUtil {

    private static final DataSource dataSource;

    static {
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        properties.setProperty("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");

        dataSource = new HikariDataSource(new HikariConfig(properties)); // Hikari
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void quietlyClose(Connection connection) {
        if (connection == null)
            return;

        try {
            if (connection.isClosed())
                return;

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void quietlyClose(ResultSet resultSet) {
        if (resultSet == null)
            return;

        try {
            if (resultSet.isClosed())
                return;

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void quietlyClose(PreparedStatement preparedStatement) {
        if (preparedStatement == null)
            return ;

        try {
            if (preparedStatement.isClosed())
                return ;

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
