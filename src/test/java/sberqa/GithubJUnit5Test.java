package sberqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubJUnit5Test {

    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Github.Selenide.Тестируем страницу Soft assertions")
    void softAssertionPageTest() {
//        "Переход на страницу GitHub"
        open("https://github.com/");
//        "Поиск по тексту Selenide в поисковой строке"
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
//        "Результаты поиска.Нажимаем на первую ссылку в списке"
        $$(".repo-list").first().$("a").click();
//        "Selenide.Проверка текста загаловка страницы selenide \ selenide"
        $("#readme").shouldHave(text("Selenide = UI Testing Framework powered by Selenium WebDriver"));
//        "Selenide.Переход на страницу Wiki"
        $("#wiki-tab").click();
//        "Wiki.Перходим на страницу(чаптер) "Soft assertions"
        $(".markdown-body").$(byText("Soft assertions")).click();
//        "Soft assertions. Проверяем наличие информации c разделом JUnit5"
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
