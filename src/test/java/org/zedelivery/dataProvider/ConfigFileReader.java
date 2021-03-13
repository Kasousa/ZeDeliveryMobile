package org.zedelivery.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private static ConfigFileReader configReader;

    private ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/properties/configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigFileReader getInstance( ) {
        if(configReader == null) {
            configReader = new ConfigFileReader();
        }
        return configReader;
    }

    public String getappiumPort() {
        String appiumPort = properties.getProperty("appiumPort");
        if(appiumPort != null) return appiumPort;
        else throw new RuntimeException("appiumPort not specified in the Configuration.properties file.");
    }

    public String getapkName() {
        String apkName = properties.getProperty("apkName");
        if(apkName != null) return apkName;
        else throw new RuntimeException("apkName not specified in the Configuration.properties file.");
    }

    public String gettimeoutElements() {
        String timeoutElements = properties.getProperty("timeoutElements");
        if(timeoutElements != null) return timeoutElements;
        else throw new RuntimeException("timeoutElements not specified in the Configuration.properties file.");
    }
}