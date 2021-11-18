package sberqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("herokuapp.Тестируем Drag n Drop")
    void dragNDropTest() {
//        "Открываем страницу с заданием по Drag n Drop"
        open("https://the-internet.herokuapp.com/drag_and_drop");
//        "Проверяем что страница открылась"
        $("h3").shouldHave(text("Drag and Drop"));
//        "Осуществляем DragNDrop из колонки А в колону B"
        $("#column-a").dragAndDropTo($("#column-b"));
//        "Проверяем результат"
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
