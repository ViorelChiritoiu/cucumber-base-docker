package com.cucumber.stepdefinitions;

import com.cucumber.constants.EndPoint;
import com.cucumber.context.TestContext;
import com.cucumber.objects.Product;
import com.cucumber.pages.PageFactoryManager;
import com.cucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
    private final StorePage storePage;
    private final TestContext context;

    public StoreStepDefinitions(TestContext context) {
        this.context = context;
        this.storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }

}
