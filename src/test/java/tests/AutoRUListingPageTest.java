package tests;

import common.Car;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.AutoRuMainPage;
import tests._base._BaseTest;


@Epic("UI")
@Owner("Sivak")
@Feature("Listing Page")
public class AutoRUListingPageTest extends _BaseTest {

    @Test
    @DisplayName("Провка отображния марки на странице поиска")
    public void listingPageTest() {
        String priceFrom = "1000000";
        String priceTo = "2000000";

        openStartPage();
        new AutoRuMainPage()
                .clickMarkToChangePage(Car.BMW)
                .checkMarkOnPageIsVisible(Car.BMW)
                .checkListingLinks(Car.BMW)
                .setFieldPriceFrom(priceFrom)
                .setFieldPriceTo(priceTo)
                .clickSearchButton()
                .checkListingLinks(Car.BMW);
    }
}
