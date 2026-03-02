package com.rooter.utils;

import com.rooter.model.Device;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;

import java.util.Objects;

@Slf4j
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

    public static String getAction() {
        return System.getProperty("action", "list");
    }

    @DataProvider(name = "devices")
    public static Object[][] getDevices() {
        String devicesParam = System.getProperty("devices", "");

        if(devicesParam.isEmpty()) {
            log.info("No devices to add, remove or list, please add the devices and try again");
        }

        String[] devicesArray = devicesParam.split(",");
        Object[][] result = new Object[devicesArray.length][1];

        for(int i = 0; i < devicesArray.length; i++) {
            String[] parts = devicesArray[i].split(";");
            result[i][0] = new Device(parts[0], parts[1]);
        }
        return result;
    }
}
