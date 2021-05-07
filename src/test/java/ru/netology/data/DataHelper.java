package ru.netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }
    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }
}
