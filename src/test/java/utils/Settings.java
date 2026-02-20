package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Objects;

public class Settings {

    private static final String BROWSER = "browser.type";
    private static final String URL = "rooter.url";

    private static Config conf;

    private static void loadConfig() {
        if(Objects.isNull(conf)) {
            conf = ConfigFactory.load("local.config.properties")
                    .withFallback(ConfigFactory.load("config.properties"));
        }
    }

    public static String getBrowser() {
        loadConfig();
        return conf.getString(BROWSER);
    }

    public static String getRooterURL() {
        loadConfig();
        return conf.getString(URL);
    }
}
