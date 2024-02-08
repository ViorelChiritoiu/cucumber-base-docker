package com.cucumber.pages;

import com.cucumber.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class StorePage extends BasePage {

    @FindBy(css = "a[title='View cart']")
    private WebElement viewCartLink;

    @FindBy(css = ".woocommerce-products-header__title.page-title")
    private WebElement title;



    public StorePage(WebDriver driver) {
        super(driver);
    }

    private By getAddToCartBtnElement(String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public void addToCart(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        wait.until(ExpectedConditions.visibilityOf(title));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
