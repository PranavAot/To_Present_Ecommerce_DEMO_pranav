package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


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

    public void Company(String c){
       String com =c;
        Company.sendKeys(com);

    }
    @FindBy(xpath = "//*[@class='input-text'][@name='street[0]']")
    WebElement StreetAddress;

    public void StreetAddress(String add){
        StreetAddress.sendKeys(add);

    }
    @FindBy(xpath = "//*[@class='input-text'][@name='city']")
    WebElement city;

    public void city(String town){
        city.sendKeys(town);

    }
    @FindBy(xpath = "//*[@class='input-text'][@name='region']")
    WebElement state;

    public void State(){
        Select provinance = new Select(state);
        provinance.selectByIndex(4);
    }
    @FindBy(xpath = "//*[@class='input-text'][@name='postcode']")
    WebElement zip;

    public void zip(String code){
        zip.sendKeys(code);
    }

    @FindBy(xpath = "//*[@class='input-text'][@name='country_id']")
    WebElement Countryid;

    public void Countryid() {
        Select country = new Select(Countryid);
        country.selectByIndex(2);
    }

    @FindBy(xpath = "//*[@class='input-text'][@name='telephone']")
    WebElement Contact;

    public void Contact(String ph) {
        Contact.sendKeys(ph);

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

    public void placeorder(){
        placeOrder.click();

    }





}
