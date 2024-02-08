package com.cucumber.utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            properties.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("dev.config.properties file not found" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load dev.config.properties file" + e.getMessage());
        }
        return properties;
    }
}
