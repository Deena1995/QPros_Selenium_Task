package com.qpros.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemPropertiesReader {


    public static String getSystemPropertyFile() {
        return "/system.properties";
    }


    public static String getSystemFileProperty(String property) {
        return System.getProperty(property, getPropFromPropertiesFile(getSystemPropertyFile(), property));
    }


    public static String getPropFromPropertiesFile(String fileName, String propertyName) {
        Properties conf = new Properties();
        InputStream fs = SystemPropertiesReader.class.getResourceAsStream(fileName);

        try {
            conf.load(fs);
            fs.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return conf.getProperty(propertyName);
    }


    public static String getBaseUrl() {
        return getSystemFileProperty("BaseUrl");
    }

    public static Boolean getHeadlessState() {
        return Boolean.valueOf(getSystemFileProperty("Headless"));
    }


}
