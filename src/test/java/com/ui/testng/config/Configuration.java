package com.ui.testng.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:runner.properties",
        "system:properties"})
public interface Configuration extends Config {


    @Key("grid.url")
    URL gridUrl();

    @Key("webdriver.timeout")
    int timeOut();

    @Key("app.url")
    String appUrl();
}
