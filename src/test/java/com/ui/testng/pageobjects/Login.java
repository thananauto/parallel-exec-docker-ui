package com.ui.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "#user-name")
    WebElement userName;

    @FindBy(css = "#password")
    WebElement passWord;

    @FindBy(css = "#login-button")
    WebElement login;

    @FindBy(css = "#react-burger-menu-btn")
    WebElement burgMenu;

    @FindBy(linkText = "Logout")
    WebElement lnkLogOut;

    public void login(String username, String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
        login.click();
    }


    public void logOut(){
        burgMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lnkLogOut));
        lnkLogOut.click();
    }

}
