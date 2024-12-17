package tests;

import common.Car;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.AutoRuMainPage;
import tests._base._BaseTest;

@Epic("UI")
@Owner("Sivak")
@Feature("Main Page")
public class AutoRUMainPageTest extends _BaseTest {

    @Test
    @DisplayName("Отображение кнопок на главной странице")
    public void mainPageButtonVisibilityTest() {
        openStartPage();
        AutoRuMainPage autoRuMainPage = new AutoRuMainPage();
        Assertions.assertAll(
                autoRuMainPage::isButtonReleaseVisible,
                autoRuMainPage::isMarkVisible
        );

    }


}
