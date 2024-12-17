package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.Car;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AutoRUListingPage {

    String buttonMark = "//span[@class='Button__text' and contains(text(), '%s')]";
    SelenideElement buttonSearch = $x("//div[@class='ButtonWithLoader__inner']");
    SelenideElement fieldPriceFrom = $x("//input[@name='price_from']");
    SelenideElement fieldPriceTo = $x("//input[@name='price_to']");

    ElementsCollection linksCollection = $$x("//a[@class='Link ListingItemTitle__link']");

    @Step("Проверка, что страница открыта")
    public AutoRUListingPage checkMarkOnPageIsVisible(Car expectedMark) {
        $x(buttonMark.formatted(expectedMark.toString())).shouldBe(Condition.visible);
        return this;
    }

    @Step("Установить цену от {0}")
    public AutoRUListingPage setFieldPriceFrom(String price1) {
        fieldPriceFrom.click();
        fieldPriceFrom.setValue(price1);
        return this;
    }

    @Step("Установить цену до {0}")
    public AutoRUListingPage setFieldPriceTo(String price2) {
        fieldPriceTo.click();
        fieldPriceTo.setValue(price2);
        return this;
    }

    @Step("Нажать на кнопку поиска")
    public AutoRUListingPage clickSearchButton() {
        buttonSearch.click();
        return this;
    }

    @Step("Проверка, что список содержит марку автомобиля {0}")
    public AutoRUListingPage checkListingLinks(Car text) {
        // проверяем коллекцию на наличие текста 'БМВ' в ссылке
        // преобразуем коллекцию в фиксированный  iterable для работы с ней при помощи Stream API
        // преобразуем коллекцию в поток
        boolean isHasText = linksCollection.asFixedIterable().stream()
                // используем map для получения каждого элемента коллекции
                .map(SelenideElement::innerText)
                // проверяем, что каждый элемент содержит нужное значение
                .allMatch(e -> e.contains(text.toString()));
        // проверка результата
        Assertions.assertTrue(isHasText);
        return this;
    }
}
