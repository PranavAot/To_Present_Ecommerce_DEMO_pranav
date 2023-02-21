package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccount {

    WebDriver ldriver;
    public UserAccount(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchTextArea;

    public void SearchTextArea() {
        searchTextArea.sendKeys("jacket");

    }

    @FindBy(xpath = "//header/div[2]/div[2]/div[2]/form[1]/div[2]/button[1]")
    WebElement searchButton;

    public  void SearchButton(){
        try {
            searchButton.click();
        }catch(Exception e){
            e.getMessage();
            System.out.println(e.getMessage());
        }
    }
    @FindBy(xpath ="//div[@class='panel header']/ul[1]/li[1]/span[1]")
    WebElement userProfile;

    public boolean getUserProfile(){
        return userProfile.isDisplayed();
    }




}


