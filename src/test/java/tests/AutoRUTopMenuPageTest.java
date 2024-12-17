package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.AutoRuMainTopMenu;
import tests._base._BaseTest;

@Epic("UI")
@Owner("Sivak")
@Feature("Top Menu")
public class AutoRUTopMenuPageTest extends _BaseTest {

    @Test
    @DisplayName("Проверка аттрибутов Top Menu")
    public void topMenuItemsExistTest() {
        openStartPage();
        new AutoRuMainTopMenu()
                .isTopMenuItemsExists();
        AutoRuMainTopMenu autoRuMainTopMenu = new AutoRuMainTopMenu();
        Assertions.assertAll(
                autoRuMainTopMenu::isTopMenuVisible,
                autoRuMainTopMenu::isTopMenuClickable,
                autoRuMainTopMenu::isTopMenuItemsExists
        );
    }

}
