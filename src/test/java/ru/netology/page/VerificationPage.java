package ru.netology.page;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage() {

        codeField.shouldBe(visible);
    }

    public OfficePage validVerify(String verificationCode ) {
        codeField.setValue(verificationCode);
        verifyButton.click();
        return new OfficePage();
    }
}
