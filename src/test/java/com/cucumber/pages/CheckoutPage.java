package com.cucumber.pages;

import com.cucumber.base.BasePage;
import com.cucumber.objects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing_first_name")
    private WebElement billingFirstnameFld;
    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameFld;

    @FindBy(id = "billing_country")
    private WebElement billingCountryDropDown;
    @FindBy(id = "billing_address_1")
    private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city")
    private WebElement billingCityFld;
    @FindBy(id = "billing_state")
    private WebElement billingStateDropDown;
    @FindBy(id = "billing_postcode")
    private WebElement billingZipFld;
    @FindBy(id = "billing_email")
    private WebElement billingEmailFld;
    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeTxt;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstnameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingCountry(String billingCountryName){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingCountryDropDown)));
        select.selectByVisibleText(billingCountryName);
        return this;
    }
    public CheckoutPage selectBillingState(String billingStateName){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        select.selectByVisibleText(billingStateName);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterBillingAddressLineOne(billingDetails.getBillingAddressOne()).
                enterBillingCity(billingDetails.getBillingCity()).
                selectBillingState(billingDetails.getBillingStateName()).
                enterBillingZip(billingDetails.getBillingZip()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckoutPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }
}
