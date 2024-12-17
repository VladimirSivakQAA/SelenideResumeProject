package common.config;

import common.config.UI.UIConfig;
import org.aeonbits.owner.ConfigFactory;

/**
 * Единый доступ к уже проинициализированным конфигам
 */
public class ConfigRep {

public static class UI {
    public final static UIConfig CONFIG = ConfigFactory.create(UIConfig.class);
}

}
