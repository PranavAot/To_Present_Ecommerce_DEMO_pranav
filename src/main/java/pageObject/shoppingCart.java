package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class shoppingCart {
    WebDriver ldriver;

    public shoppingCart(WebDriver driver) {

        this.ldriver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[contains(@data-bind,'attr: {href: product_url}, html: product_name')]")
    List<WebElement> listOfProduct;

    public List<WebElement> listOfProduct() {
        return listOfProduct;
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


    @FindBy(xpath = "//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")
    WebElement noOfItems;

    public String NumOfItems(){
        return noOfItems.getText();
    }


    @FindBy(xpath = "//span[contains(text(),'$116.00')]")
    WebElement excpeted;

    public WebElement getExcpeted(){
        return excpeted;
    }


    @FindBy(xpath ="//button[@id ='top-cart-btn-checkout']")
    WebElement ProceedToCheckout;

    public void ProceedToCheckoutButton(){
        ProceedToCheckout.click();


    }

}