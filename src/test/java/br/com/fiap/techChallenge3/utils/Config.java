package br.com.fiap.techChallenge3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String PROPERTIES_FILE = "config.properties";

    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLocalhostUrl() {
        return properties.getProperty("localhost.url");
    }

    public static int getLocalhostPort() {
        return Integer.parseInt(properties.getProperty("localhost.port"));
    }
}

