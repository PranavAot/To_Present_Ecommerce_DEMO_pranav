package ReuseableFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class schronyzationScript {

    WebDriver ldriver;
    public schronyzationScript(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    public void waitForPageLoad(long Seconds)  {
       try {
        Thread.sleep(Seconds*1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    public void waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
