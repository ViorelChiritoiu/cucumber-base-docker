package com.cucumber.utils;

import com.cucumber.constants.Constants;
import com.cucumber.constants.EnvType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final Logger log = LoggerFactory.getLogger(Config.class);
    private static Properties properties;

    public static void initialize() {
        //load environment properties
        String env = System.getProperty("env", String.valueOf(EnvType.DEV));
        switch (EnvType.valueOf(env)) {
            case DEV:
                properties = loadProperties(Constants.DEV_PROPERTIES);
                break;
            case STAGE:
                properties = loadProperties(Constants.STG_PROPERTIES);
                break;
            default:
                log.error("Invalid environment type {}",  env);
        }
        //check for any override
        for (String key: properties.stringPropertyNames()) {
            if (System.getProperties().containsKey(key)) {
                properties.setProperty(key, System.getProperty(key));
            }
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    private static Properties loadProperties(String envProperties) {
        //String env = System.getProperty("env", String.valueOf(EnvType.DEV));
        Properties properties = new Properties();
        try (InputStream stream = ResourceLoader.getResource(envProperties)) {
            properties.load(stream);
        } catch (IOException e) {
            log.error("Unable to read property file {}", envProperties, e);
        }
        return properties;
    }

    public static String getBaseUrl() {
        String prop = properties.getProperty("app.url");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property baseUrl is not specified in the prod.dev.config.properties file");
        }
    }


}
