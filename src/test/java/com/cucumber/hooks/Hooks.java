package com.cucumber.hooks;

import com.cucumber.constants.Constants;
import com.cucumber.context.TestContext;
import com.cucumber.factory.DriverManagerFactory;
import com.cucumber.listener.TestListener;
import com.cucumber.utils.Config;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners({TestListener.class})
public class Hooks {

    private WebDriver driver;
    private final TestContext context;
    public static final Logger log = LoggerFactory.getLogger(Hooks.class);

    public Hooks(TestContext context) {
        this.context = context;
    }

    @BeforeAll
    public static void setupConfig() {
        Config.initialize();
    }

    @Before
    public void before() throws MalformedURLException {
        String browser = System.getProperty(Config.get(Constants.BROWSER), Constants.CHROME);
        this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ?
                DriverManagerFactory.getManager(browser).createRemoteDriver() :
                DriverManagerFactory.getManager(browser).createLocalDriver();
        context.driver = driver;
    }

    @After
    public void after() {
        driver.quit();
    }
}
