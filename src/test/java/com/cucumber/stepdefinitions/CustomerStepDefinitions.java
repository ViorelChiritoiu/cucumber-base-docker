package com.cucumber.stepdefinitions;

import com.cucumber.constants.Constants;
import com.cucumber.context.TestContext;
import com.cucumber.objects.BillingDetails;
import com.cucumber.pages.PageFactoryManager;
import com.cucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CustomerStepDefinitions {
    private final StorePage storePage;
    private final TestContext context;


    public CustomerStepDefinitions(TestContext context) {
        this.context = context;
        this.storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        storePage.load(Constants.STORE);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }
}
