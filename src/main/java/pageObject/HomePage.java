package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
    WebDriver ldriver;
    public HomePage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement SiginInLink;

    public void ClickOnSiginInLink(){                           //method ka name tum khud apne man se do

        SiginInLink.click();                                       //Action webElement pe hoga
    }


    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement CreateAccountLink;

    public void ClickOnCreateAccountLink(){
        CreateAccountLink.click();
    }
}

