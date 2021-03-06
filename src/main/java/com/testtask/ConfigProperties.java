package com.testtask;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by O. Korniev on 14.09.2017.

 */

public class ConfigProperties {
    public static Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        URL props = ClassLoader.getSystemResource("config.properties");
        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }

}
