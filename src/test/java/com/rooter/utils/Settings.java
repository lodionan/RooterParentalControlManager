package com.rooter.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Objects;

public class Settings {

    private static final String BROWSER = "browser.type";
    private static final String URL = "rooter.url";
    private static final String USER = "admin.user";
    private static final String PASS = "admin.password";

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

    public static String getUser() {
        loadConfig();
        return conf.getString(USER);
    }

    public static String getPassword() {
        loadConfig();
        return conf.getString(PASS);
    }
}
