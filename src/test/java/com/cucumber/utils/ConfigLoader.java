package com.cucumber.utils;

import com.cucumber.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String env = System.getProperty("env", String.valueOf(EnvType.DEV));
        switch (EnvType.valueOf(env)) {
            case DEV:
                properties = PropertyUtils.propertyLoader("src/test/resources/dev.config.properties");
                break;
            case STAGE:
                properties = PropertyUtils.propertyLoader("src/test/resources/stg.config.properties");
                break;
            default:
                throw new IllegalStateException("Invalid env type:" + env);
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property baseUrl is not specified in the prod.dev.config.properties file");
        }
    }
}
