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

      public Properties prop;
     public configReader config;


    @Before(order = 0)
    public  void selectBrowser(){

        String env = System.getenv("ENV");
        if(env==null || env.isEmpty()){
            env="dev";
        }
        configReader config = null;
        try{
            config = new configReader(env);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        String dbbrowser= config.getBrowser();

        Initializing_Driver init_driver = new Initializing_Driver();
        ldriver = init_driver.ini_driver(dbbrowser);

    }



    @After(order = 0)
     public void teardown(){
          ldriver.quit();
    }


    }




