package com.ui.testng.test;

import com.ui.testng.pageobjects.Login;
import com.ui.testng.pageobjects.Products;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UiTest2 extends Base{

    @BeforeMethod
    public void launchUrl(){
        getDriver().get("https://www.saucedemo.com/");
    }

    @Test(description = "Login and safe logout from the application")
    public void loginAndLogout2(){

        Login login = new Login(getDriver());
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(getDriver().getTitle().contains("Swag Labs"));
        login.logOut();
        Assert.assertTrue(getDriver().getTitle().contains("Swag Labs"));
    }

    @Test(description = "click any item image and click basket")
    public void clickAndAddItem2(){

        Login login = new Login(getDriver());
        login.login("problem_user", "secret_sauce");
        Products products = new Products(getDriver());
        products.clickAnyAddToCart();
        products.viewBasket();
        login.logOut();
        Assert.assertTrue(getDriver().getTitle().contains("Swag Labs"));
    }
}
