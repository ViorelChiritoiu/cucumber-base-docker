package com.cucumber.stepdefinitions;

import com.cucumber.apis.CartApi;
import com.cucumber.context.TestContext;
import com.cucumber.objects.Product;
import com.cucumber.pages.CartPage;
import com.cucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class CartStepDefinitions {
    private final CartPage cartPage;
    private final TestContext context;

    public CartStepDefinitions(TestContext context) {
        this.context =context;
        this.cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        assertEquals(product.getName(), cartPage.getProductName());
        assertEquals(quantity, cartPage.getProductQuantity());
    }

    @And("I have {int} {product} in the Cart")
    public void iHaveInTheCart(int quantity, Product product) {
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }

}
