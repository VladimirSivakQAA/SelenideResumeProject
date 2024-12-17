package tests._base;

import com.codeborne.selenide.logevents.SelenideLogger;
import common.config.ConfigRep;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.AutoRuMainPage;
import utils.SelenideUtils;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class _BaseTest {

    /**
     * Сетап драйвера перед каждым тестом и подключение allure listener
     */
    @BeforeEach
    public void setup() {
        SelenideUtils.createDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterEach
    public void close() {
        closeWebDriver();
    }

    public void openStartPage() {
        open(ConfigRep.UI.CONFIG.url());
        new AutoRuMainPage().setGeoPosition("Россия");
    }
}
