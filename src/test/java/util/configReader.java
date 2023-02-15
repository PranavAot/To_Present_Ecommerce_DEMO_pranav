package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private Properties properties;

    public configReader(String env)throws IOException{

        properties = new Properties();

        String fileName = env + "-config.properties";

        try(FileInputStream input = new FileInputStream(fileName)){
            properties.load(input);
        } catch (IOException e) {

            System.err.println("Could not read"+fileName+",fallling back to dev-config.properties");

            String filename =  "C:\\Users\\PRANACHO\\Desktop\\automation project\\Intilij\\Ecommerce_DEMO_pranav\\src\\main\\resources\\Properties\\dev-config.properties";
            try(FileInputStream input = new FileInputStream(filename)) {
                properties.load(input);
            }
        }
    }

    public String getBrowser(){
        return properties.getProperty("Browser");

    }
    public String getUrl(){
        return properties.getProperty("Url");

    }


}
