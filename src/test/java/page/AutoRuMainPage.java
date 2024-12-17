package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.Car;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AutoRuMainPage {

    String buttonMark = "//div[@class='IndexMarks__item-name' and contains(text(), '%s')]";

    SelenideElement buttonCurrentCity = $x("//div[@class ='GeoSelectPopup__regions']/button[contains (@class, 'Button_color_blue')]");
    SelenideElement buttonGeoPos = $x("//span[contains(@class, 'GeoSelect')]");
    SelenideElement buttonRelease = $x("//span[@class='Button__text' and contains (text(), 'Показать')]");
    SelenideElement inputSaveGeo = $x("//span[@class = 'Button__text' and contains (text(), 'Сохранить')]");
    SelenideElement inputSetGeo = $x("//div[contains(text(), 'Регион, город')]/following-sibling::div[@class='TextInput__inputWrap']//input[@class='TextInput__control']");

    ElementsCollection brands = $$x("//div[@class='IndexMarks__item-name']");

    @Step("Проверка видимости кнопки 'Показать'")
    public AutoRuMainPage isButtonReleaseVisible() {
        buttonRelease.shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости брендов и их количества")
    public AutoRuMainPage isMarkVisible() {
        // фильтруем только отображаемые элементы
        ElementsCollection visibleBrands = brands.filter(visible);
        // выводим колличество элементов
        // сравниваем с ожидаемым результатом
        visibleBrands.shouldHave(size(34));
        return this;
    }

    @Step("Нажатие на марку автомобиля '{0}' и переход на страницу с результатами поиска")
    public AutoRUListingPage clickMarkToChangePage(Car car) {
        $x(buttonMark.formatted(car)).click();
        return new AutoRUListingPage();
    }

    @Step("Установка геопозиции '{0}'")
    public AutoRuMainPage setGeoPosition(String country) {
        if (buttonGeoPos.exists()) {
            // Открываем меню настройки геолокации
            buttonGeoPos.click();

            // Убираем геопозицию
            if (buttonCurrentCity.isDisplayed()) {
                buttonCurrentCity.click();
            }

            inputSetGeo.click();
            inputSetGeo.setValue(country);
            inputSaveGeo.click();
        }
        return this;
    }
}
