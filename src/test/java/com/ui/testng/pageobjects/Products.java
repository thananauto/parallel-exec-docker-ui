package com.ui.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {

WebDriver driver;
    public Products(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(.,'Add to cart')]")
    WebElement addToCart;

    @FindBy(css = ".inventory_item_img")
    WebElement anyImg;

    @FindBy(css = ".shopping_cart_link")
    WebElement basket;

    public void clickAnyAddToCart(){
        addToCart.click();
    }

    public void clickAnyProdImg(){
        anyImg.click();
    }

    public void viewBasket(){
        basket.click();
    }
}
