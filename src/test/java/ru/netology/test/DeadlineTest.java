package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class DeadlineTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }



    @Test
    void shouldValidUser() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        String verificationCode = SqlHelper.getVerificationCode(authInfo.getLogin());
        verificationPage.validVerify(verificationCode);

    }

}
