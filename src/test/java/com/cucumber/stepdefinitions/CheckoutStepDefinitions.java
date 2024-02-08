package com.cucumber.stepdefinitions;

import com.cucumber.constants.EndPoint;
import com.cucumber.context.TestContext;
import com.cucumber.pages.CheckoutPage;
import com.cucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class CheckoutStepDefinitions {
    private final CheckoutPage checkoutPage;
    private final TestContext context;


    public CheckoutStepDefinitions(TestContext context) {
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @And("I am on the Checkout Page")
    public void iAmOnTheCheckoutPage() {
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }

    @And("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
    }
}
