package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
    private static final String FAILED_READ_PROPERTIES_ERROR_MESSAGE = "Failed to read properties";
    private static Properties properties;
    public static final String PATH_TO_PROPERTIES = "resources/application.properties";

    private PropertiesHandler() {
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream inputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println(FAILED_READ_PROPERTIES_ERROR_MESSAGE + e.getMessage());
            //throw new ServiceException(FAILED_READ_PROPERTIES_ERROR_MESSAGE, e);
        }
    }
}
