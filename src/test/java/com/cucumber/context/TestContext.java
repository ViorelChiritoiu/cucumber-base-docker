package com.cucumber.context;

import com.cucumber.objects.BillingDetails;
import com.cucumber.objects.Cookies;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;

    public TestContext() {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }
}
