package ru.rrenat358.configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {

    public static final String COFIG_PROPERTIES = "config.properties";

    private Properties properties;


    private Config() {
        properties = new Properties();
        loadProperties(COFIG_PROPERTIES);
    }


    private void loadProperties(String fileName)  {
        try {
            InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Error during file reading " + fileName);
            throw new RuntimeException(e);
        }
    }


    public String getProperties(String key) {
        return Config.getInstance().properties.getProperty(key);
    }








    private static class SingletonHelper {
        private static final Config INSTANCE = new Config();
    }

    public static Config getInstance() {
        return SingletonHelper.INSTANCE;
    }

}
