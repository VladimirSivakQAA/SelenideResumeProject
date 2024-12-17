package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import utils.ComparisonUtility;

import java.nio.file.Files;
import java.util.List;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;


public class AutoRuMainTopMenu {
    SelenideElement switcherTomMenu = $x("//div[@class='Dropdown__switcher HeaderBurger__switcher']");
    ElementsCollection itemsTopMenu = $$(".HeaderDropdownMenu.HeaderBurger__menuContent .HeaderSitemap__itemLink");

    @Step("Проверяем, что верхнее меню отображается")
    public AutoRuMainTopMenu isTopMenuVisible() {
        switcherTomMenu.shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что верхнее меню кликабельно")
    public AutoRuMainTopMenu isTopMenuClickable() {
        switcherTomMenu.shouldBe(clickable);
        return this;
    }


    @Step("Проверяем, что все элементы верхнего меню существуют и соответствуют ожидаемому результату")
    @SneakyThrows
    public AutoRuMainTopMenu isTopMenuItemsExists() {
        switcherTomMenu.hover();
        // Получаем отсортированный список текстов из файла
        List<String> expectedText = Files.readAllLines(ComparisonUtility.getFileFromResources("text_files/header_actual.txt")
                        .toPath())
                .stream().sorted().toList();
        // Извлекаем текст из каждого элемента коллекции
        List<String> actualText = itemsTopMenu.filter(visible).asFixedIterable()
                .stream()
                .map(SelenideElement::getText) // Получаем текст из каждого элемента
                .sorted().toList();
        // Сравниваем два списка
        Assertions.assertEquals(expectedText, actualText, "Тексты элементов на странице не совпадают с ожиданиями");

        return this;
    }

}
