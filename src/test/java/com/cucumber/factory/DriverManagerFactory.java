package com.cucumber.factory;

import com.cucumber.constants.Constants;
import com.cucumber.constants.DriverType;

public class DriverManagerFactory {
    public static DriverManager getManager(String driverType) {
        switch (driverType) {
            case Constants.CHROME:
                return new ChromeDriverManager();
            case Constants.FIREFOX:
                return new FirefoxDriverManager();
            default:
                throw new IllegalStateException("Invalid driver: " + driverType);
        }

    }
}
