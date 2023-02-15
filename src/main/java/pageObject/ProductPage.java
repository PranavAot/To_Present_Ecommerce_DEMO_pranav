package pageObject;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver ldriver;
    public ProductPage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }
    @FindBy(xpath = "//div[@class ='swatch-opt-1316']/div[1]/div[1]/div[1]")
    WebElement size;

    public void dressSize(){
        size.click();
    }

    @FindBy(xpath = "//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]")
    WebElement colour;

    public void SelectColour(){
        colour.click();
    }

    @FindBy(xpath = "//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[1]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]")
    WebElement addToCartButton;

    public void addToCart(){
        addToCartButton.click();
    }


    @FindBy(xpath = "//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")
    WebElement size1;

    public void selectSize1(){
        size1.click();
    }

    @FindBy(xpath = "//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]")
    WebElement clour1;

    public void Selectcolour1(){
        clour1.click();
    }
     @FindBy(xpath ="//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[2]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]")
    WebElement Addtocart1 ;
    public void Addtocart1() {
        Addtocart1.click();
    }

    @FindBy(xpath = "//header/div[2]/div[1]/a[1]")
            WebElement shoppingicon;
    public void ShoppingCartIcon(){
        shoppingicon.click();
    }


    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    WebElement proccedTOCheckoutBtton;
    public  void proccedTOCheckout(){
        proccedTOCheckoutBtton.click();
    }


}
