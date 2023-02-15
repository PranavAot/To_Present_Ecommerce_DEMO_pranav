package diverInit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initializing_Driver {

    public static WebDriver ldriver;

    public WebDriver ini_driver(String browser) {
         WebDriver driver ;

            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                ldriver=driver;
            }


        ldriver.manage().deleteAllCookies();
        ldriver.manage().window().maximize();
        return ldriver;


    }
}


