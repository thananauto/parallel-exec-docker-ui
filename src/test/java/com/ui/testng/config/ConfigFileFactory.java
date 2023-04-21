package com.ui.testng.config;

import org.aeonbits.owner.ConfigCache;

import java.util.Objects;


public class ConfigFileFactory {
    public static Configuration config;
    static {
            config = ConfigCache.getOrCreate(Configuration.class);
    }
}
