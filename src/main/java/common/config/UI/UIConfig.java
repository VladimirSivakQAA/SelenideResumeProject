package common.config.UI;
import org.aeonbits.owner.Config;


@Config.Sources("classpath:config/ui.properties")
public interface UIConfig extends Config {
    @Key("ui.url")
    String url();

    @Key("ui.selenide.timeout")
    Long selenideTimeout();

    @Key("ui.browser.size")
    String size();

    @Key("ui.selenide.pageLoadTimeout")
    Long pageLoadTime();
}
