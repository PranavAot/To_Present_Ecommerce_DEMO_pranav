package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    public WebElement size(){
        return size;
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

    @FindBy(xpath ="//span[contains(text(),'57.00')]")
    WebElement item_price;

    public String itemPrice(){
        return item_price.getText();
    }

    @FindBy(xpath = "//span[contains(text(),'$59.00')]")
    WebElement item_price1;

    public WebElement getItem_price1(){
        return item_price1;
    }


    @FindBy(xpath = "//div[@class ='page-title-wrapper']/h1[1]/span[1]")
    WebElement searchedPage;

    public WebElement SearchedPageResult(){
       return  searchedPage;

    }
    @FindBy(xpath="//div[@id ='store.menu']/nav[1]/ul[1]/li[3]/a[1]")
    WebElement MenOption;

    public void mensOption(){
        MenOption.click();

    }

    @FindBy(xpath="//div[@class ='content']/dl[1]/dd[1]/ol[1]/li[1]/a[1]")
    WebElement mensTop;

    public void MenTop(){
        mensTop.click();
    }
    @FindBy(xpath ="//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[4]/select[1]")
    WebElement ChooseOption;

    public void chooseoption() {
        Select se = new Select(ChooseOption);
        se.selectByVisibleText("Price");
    }
    @FindBy(xpath ="//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[4]/a[1]")
    WebElement ShortBy;

    public void selectShortBy(){
        ShortBy.click();

    }

    @FindBy(xpath="//span[@id = 'product-price-318']/span[1]")
    WebElement Orion_Two_Tone_Fitted_Jacket;

    public String Price1(){
        return Orion_Two_Tone_Fitted_Jacket.getText();
    }

    @FindBy(xpath="//span[@id = 'product-price-254']/span[1]")
    WebElement Argus_All_Weather_Tank_Price;
    public String Price2(){
          return Argus_All_Weather_Tank_Price.getText();

    }
    @FindBy(xpath="//span[@id = 'product-price-78']/span[1]")
    WebElement Rocco_Gym_Tank;

    public String Price3(){
        return Rocco_Gym_Tank.getText();
    }


    @FindBy(xpath="//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]")

    WebElement Push_It_Messenger_Bag;

    public void Push_It_Messenger_BagButton(){
        Push_It_Messenger_Bag.click();
    }

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchArea;

    public void search(){
        searchArea.sendKeys("Bag");
    }


}

