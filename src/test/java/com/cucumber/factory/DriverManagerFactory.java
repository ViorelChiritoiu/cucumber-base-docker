package com.cucumber.factory;

import com.cucumber.constants.DriverType;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();
            default:
                throw new IllegalStateException("Invalid driver: " + driverType);
        }

    }
}
