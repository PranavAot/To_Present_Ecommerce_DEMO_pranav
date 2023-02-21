package testCase;

import ReuseableFunction.schronyzationScript;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pageObject.ProductPage;
import pageObject.UserAccount;
import pageObject.shoppingCart;
import util.configReader;

import java.io.IOException;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;

public class totalPriceOfCart {
    private UserAccount ua = new UserAccount(ldriver);
    private ProductPage pp = new ProductPage(ldriver);
    private Properties pro = new Properties();
    private configReader cr = new configReader();
    private shoppingCart sc = new shoppingCart(ldriver);

    schronyzationScript ss = new schronyzationScript(ldriver);

    double total_Item = 0, totalPrice = 0;
    @Given("user at  landing page")
    public void user_at_landing_page() {

        try {
            pro =cr.readEnviroment("prod");
            String url =pro.getProperty("Url");
            ldriver.get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @When("user search for product")
    public void user_search_for_product() {
        ua.SearchTextArea();
        ua.SearchButton();
    }
    @When("User add items to the cart")
    public void user_add_items_to_the_cart() {
        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollBy(0,250)", "");
        ss.waitForLoad(7);
        pp.dressSize();
        pp.SelectColour();
        pp.addToCart();

        String s = pp.itemPrice().substring(1);
        totalPrice+= Double.parseDouble(s);
        System.out.println(totalPrice);
        total_Item +=1;
        ss.waitForLoad(3);
        pp.selectSize1();
        pp.Selectcolour1();
        pp.Addtocart1();

        String s1 = pp.getItem_price1().getText().substring(1);
        totalPrice += Double.parseDouble(s1);

        total_Item +=1;


    }
    @When("user click on Shopping cart")
    public void user_click_on_shopping_cart() {
        ss.waitForLoad(3);
        pp.ShoppingCartIcon();
        ss.waitForLoad(3);
    }
    @Then("user validates the price and quantity")
    public void user_validates_the_price_and_quantity() {
        try {

            String expectedString = sc.getExcpeted().getText().substring(1);
            Double expectedTotalPrice = Double.parseDouble(expectedString);
            Assert.assertEquals(expectedTotalPrice, totalPrice, 0);
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
