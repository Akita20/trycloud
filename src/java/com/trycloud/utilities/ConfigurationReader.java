package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static{

        try {// read file
            String path= "configuration.properties";
            // read the file into java,
            FileInputStream file= new FileInputStream(path);
            // create a properties and send the key
            properties = new Properties();
            // load the value from the  file , properties object
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
