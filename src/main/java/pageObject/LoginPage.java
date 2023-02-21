package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
   public WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);


    }


    @FindBy(xpath = "//input[@id='email']")
    WebElement EmailIdTextArea;

    public void EmailIdTextArea(String email) {
        EmailIdTextArea.sendKeys(email);

    }

    @FindBy(xpath = "//input[@name ='login[password]']")
    WebElement PasswordTextArea;

    public void PasswordTextArea(String password) {

        PasswordTextArea.sendKeys(password);
    }

    @FindBy(xpath = "//button[@class ='action login primary']/span[text()='Sign In']")
    WebElement SignInButton;

    public  void ClickOnsignInButton(){
        SignInButton.click();
    }


}












