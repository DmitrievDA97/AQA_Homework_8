package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class OfficePage {
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public OfficePage() {
        heading.shouldBe(visible).shouldHave(text("Личный кабинет"));
    }
}
