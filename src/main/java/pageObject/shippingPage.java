package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class shippingPage {

    WebDriver ldriver;
    public shippingPage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }
    @FindBy(name ="firstname")
    WebElement FirstName;

    public void FName(String name){
      try {
          FirstName.sendKeys(name);
          System.out.println(name);
      }catch(Exception e){
          e.printStackTrace();
      }
    }
    @FindBy(xpath = "//*[@class='input-text'][@name='lastname']")
    WebElement LastName;

    public void LastName(String lname){
        LastName.sendKeys(lname);


    }
    @FindBy(xpath = "//*[@class='input-text'][@name='company']")
    WebElement Company;

    public void company(String company){
        Company.sendKeys(company);

    }
    @FindBy(xpath = "//*[@class='input-text'][@name='street[0]']")
    WebElement StreetAddress;

    public void StreetAddress(String Address){
         StreetAddress.sendKeys(Address);

    }
    @FindBy(xpath = "//*[@class='input-text'][@name='city']")
    WebElement city;

    public WebElement city(String city){
        return city(city);

    }
    @FindBy(xpath = "//*[@class='input-text'][@name='region']")
    WebElement state;

    public WebElement State(){
        return state;
    }
    @FindBy(xpath = "//*[@class='input-text'][@name='postcode']")
    WebElement zip;

    public void zip(String code){
        zip.sendKeys(code);
    }

    @FindBy(xpath = "//*[@class='input-text'][@name='country_id']")
    WebElement Countryid;

    public WebElement Countryid() {
        return Countryid;
    }

    @FindBy(xpath = "//*[@class='input-text'][@name='telephone']")
    WebElement Contact;

    public WebElement Contact() {
        return Contact;


    }
    @FindBy(xpath = "//*[@class='radio'][@name='ko_unique_2']")
    WebElement BestMethod;

    public void ShippingMethod() {
        BestMethod.click();

    }

    @FindBy(xpath="//button[@class='button action continue primary']")
    WebElement NextButton;

    public void NextButton(){
        NextButton.click();

    }
    @FindBy(xpath="//*[@class='action primary checkout'][@title='Place Order']")
    WebElement placeOrder;

    public WebElement placeorder(){
        return placeOrder;

    }

    @FindBy(xpath ="//a[@class ='order-number']/strong[1]")
    WebElement orderid;

    public WebElement Orderid(){
        return orderid;
    }




}
