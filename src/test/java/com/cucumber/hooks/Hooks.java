package com.cucumber.hooks;

import com.cucumber.constants.DriverType;
import com.cucumber.context.TestContext;
import com.cucumber.factory.DriverManagerFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void before() {
        String browser = System.getProperty("browser", String.valueOf(DriverType.CHROME));
        driver = DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver();
        context.driver = driver;
    }

    @After
    public void after() {
        driver.quit();
    }
}
