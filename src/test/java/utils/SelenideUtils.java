package utils;

import com.codeborne.selenide.Configuration;
import common.config.ConfigRep;

//класс - конфигуратор настроек
public class SelenideUtils {
    public static void createDriver(){
        Configuration.baseUrl = ConfigRep.UI.CONFIG.url();
        Configuration.timeout = ConfigRep.UI.CONFIG.selenideTimeout();
        Configuration.pageLoadTimeout = ConfigRep.UI.CONFIG.pageLoadTime();
        Configuration.browserSize = ConfigRep.UI.CONFIG.size();
    }
}
