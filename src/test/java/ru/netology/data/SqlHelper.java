package ru.netology.data;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.sql.DriverManager.getConnection;

public class SqlHelper {
    private final static QueryRunner runner = new QueryRunner();
    private final static Connection conn = getConnection();

    @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bd", "denis", "12345");
    }

    @SneakyThrows
     public static String getVerificationCode(String user) {

        val idUser = "SELECT id FROM users WHERE login = '" + user + "'";
        String id = runner.query(conn, idUser, new ScalarHandler<>());
        val code = "SELECT code FROM auth_codes WHERE user_id = '" + id + "' ORDER BY created DESC";
        return runner.query(conn, code, new ScalarHandler<>());
    }


}
