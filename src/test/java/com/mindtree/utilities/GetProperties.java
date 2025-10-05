package com.mindtree.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {

    public static Properties get;

    public static void loadProperties() throws IOException {
        if (get == null) {
            get = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            get.load(fis);
        }
    }

    public static String getProperty(String key) throws IOException {
        if (get == null) loadProperties();
        return get.getProperty(key);
    }
}
