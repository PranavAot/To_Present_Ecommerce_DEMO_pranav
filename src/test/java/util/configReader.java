package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    private Properties properties;
    private FileInputStream fileInputStream;
    public Properties readEnviroment(String environment) throws IOException {
//        String environment = System.getProperty("env");

        if (environment == null) {throw new IllegalArgumentException("Environment is not provided");
        }

        String propertiesFilePath = "src/main/resources/Properties/" + environment + "-config.properties";

        File propertiesFile = new File(propertiesFilePath);
        if (!propertiesFile.exists()) {
            throw new FileNotFoundException("Properties file not found for environment: " + environment);
        }

        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(propertiesFile);
            properties.load(fileInputStream);
        } catch (IOException e) {
            try {
                throw new IOException("Unable to load properties file for environment: " + environment, e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }

        return properties;


    }
}