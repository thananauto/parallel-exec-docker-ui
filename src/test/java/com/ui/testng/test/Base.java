package com.ui.testng.test;

import com.ui.testng.config.ConfigFileFactory;
import com.ui.testng.config.Configuration;
import com.ui.testng.drivers.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class Base {

    public Configuration config;
    protected static
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
        config = ConfigFileFactory.config;
        WebDriver driver = BrowserManager.doBrowserSetup(browser);
        //set driver
        threadLocalDriver.set(driver);
        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());

    }

    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }


    @AfterMethod
    public void tearDown(){
        getDriver().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
    }
}
