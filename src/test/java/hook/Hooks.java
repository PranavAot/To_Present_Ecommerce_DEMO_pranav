package hook;

import diverInit.Initializing_Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.configReader;

import java.io.IOException;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;

public class Hooks {

     public Initializing_Driver init_driver;

      public Properties pro = new Properties();
     public configReader cr;


    @Before(order = 0)
    public  void selectBrowser() throws IOException {

        cr= new configReader();
        pro =cr.readEnviroment("prod");
        String browser =  pro.getProperty("Browser");
        init_driver = new Initializing_Driver();
        ldriver = init_driver.ini_driver(browser);

    }



    @After(order = 0)
     public void teardown(){
          ldriver.quit();
    }


    }




