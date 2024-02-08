package com.cucumber.stepdefinitions;

import com.cucumber.objects.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySteps {

    @Given("I am on the Store page")
    public void iAmOnTheStorePage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("A");
        //throw new io.cucumber.java.PendingException();
    }
    @When("I add a {product} in the Cart")
    public void iAddAInTheCart(Product product) {
        // Write code here that turns the phrase above into concrete actions
        //Product product = new Product(productName);
        System.out.println(product.getName());
        //throw new io.cucumber.java.PendingException();
    }
    @Then("I see {int} {product} in the Cart")
    public void iSeeInTheCart(Integer int1, Product product) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(product.getName());
        //throw new io.cucumber.java.PendingException();
    }
}
