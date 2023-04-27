package com.ui.testng.drivers;

import com.ui.testng.config.ConfigFileFactory;
import com.ui.testng.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserManager {
    protected static Configuration config = ConfigFileFactory.config;
    public static WebDriver doBrowserSetup(String browserName) throws MalformedURLException {

        WebDriver driver = null;
        DesiredCapabilities capabilities = null;
        if (browserName.equalsIgnoreCase("chrome")){
            //steup chrome browser
            //WebDriverManager.chromedriver().setup();
            //Add options for --headed or --headless browser launch
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("-headed");
            chromeOptions.addArguments("--remote-allow-origins=*");
            //initialize driver for chrome
           // driver = new ChromeDriver(chromeOptions);
             capabilities = new DesiredCapabilities();
           // capabilities.setCapability("browserName", "chrome");
            capabilities.setBrowserName("chrome");
           capabilities.setVersion("112.0");

        }else if(browserName.equalsIgnoreCase("firefox")){
           // WebDriverManager.firefoxdriver().setup();

           // driver = new FirefoxDriver();
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            //capabilities.setVersion("93.0");
        }else if(browserName.equalsIgnoreCase("edge")){
            //WebDriverManager.firefoxdriver().setup();

            // driver = new FirefoxDriver();
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("MicrosoftEdge");
           // capabilities.setVersion("93.0");
        }
        driver = new RemoteWebDriver(config.gridUrl(), capabilities);
       //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(30));


        return driver;
    }
}
