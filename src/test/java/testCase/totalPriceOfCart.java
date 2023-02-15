package testCase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.UserAccount;
import util.configReader;

import java.io.IOException;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;

public class totalPriceOfCart {
    public LoginPage lp = new LoginPage(ldriver);
    public UserAccount ua = new UserAccount(ldriver);
    public ProductPage pp = new ProductPage(ldriver);
    public HomePage hp =new HomePage(ldriver);

    public Properties prop;
    public configReader cr;

    double total_Item = 0, totalPrice = 0;
    @Given("user at  landing page")
    public void user_at_landing_page() {

        try {
            cr = new configReader("dev");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String devUrl = cr.getUrl();
        ldriver.get(devUrl);
    }


    @When("user search for product")
    public void user_search_for_product() {
        ua.SearchTextArea();
        ua.SearchButton();
    }
    @When("User add items to the cart")
    public void user_add_items_to_the_cart() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) ldriver;
            js.executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(4000);
            pp.dressSize();
            pp.SelectColour();
            pp.addToCart();
            WebElement item_price = ldriver.findElement(By.xpath("//span[contains(text(),'57.00')]"));
            String s = item_price.getText().substring(1);
            //System.out.println(s);

            totalPrice+= Double.parseDouble(s);
            System.out.println(totalPrice);
            total_Item +=1;
            Thread.sleep(5000);
            pp.selectSize1();
            pp.Selectcolour1();
            pp.Addtocart1();
            WebElement item_price1 = ldriver.findElement(By.xpath("//span[contains(text(),'$59.00')]"));
            String s1 = item_price1.getText().substring(1);
            totalPrice += Double.parseDouble(s1);
          //  System.out.println(totalPrice);
            total_Item +=1;
          //  System.out.println(total_Item);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("user click on Shopping cart")
    public void user_click_on_shopping_cart() {
        try {
            Thread.sleep(3000);
            pp.ShoppingCartIcon();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("user validates the price and quantity")
    public void user_validates_the_price_and_quantity() {
        try {
            WebElement excpeted = ldriver.findElement(By.xpath("//span[contains(text(),'$116.00')]"));
            String expectedString = excpeted.getText().substring(1);
            Double expectedTotalPrice = Double.parseDouble(expectedString);
            Assert.assertEquals(expectedTotalPrice, totalPrice, 0);
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
