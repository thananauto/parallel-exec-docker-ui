package com.ui.testng.config;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Check {
    public Configuration config;

    public void cook(){
        config = ConfigFileFactory.config;
    }
    @Test
    public void test(){
        Configuration propertyReader = ConfigFactory.create(Configuration.class);
        System.out.println(propertyReader.gridUrl());

    }
}
