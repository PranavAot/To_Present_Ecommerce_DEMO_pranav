package testCase;

import ReuseableFunction.schronyzationScript;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObject.*;
import util.JsonDataReader;
import util.configReader;

import java.io.IOException;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;

public class OrderShippingStepDef {

    private Properties pro = new Properties();
    private configReader cr = new configReader();
    private HomePage hp = new HomePage(ldriver);
    private UserAccount ua = new UserAccount(ldriver);
    private LoginPage lp = new LoginPage(ldriver);
    private ProductPage pp = new ProductPage(ldriver);
    private schronyzationScript ss = new schronyzationScript(ldriver);
    private shippingPage sp = new shippingPage(ldriver);
    private shoppingCart sc = new shoppingCart(ldriver);
    private  JsonDataReader jr = new JsonDataReader();
    @Then("user provides credential using {string} and {string}")
    public void userProvidesCredentialUsingAnd(String file , String key) {
        try {
            pro =cr.readEnviroment("prod");
            String url =pro.getProperty("Url");
            ldriver.get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        hp.ClickOnSiginInLink();
        JSONObject object = jr.readJsonFile(file,key);
        lp.EmailIdTextArea(object.get("username").toString());
        lp.PasswordTextArea(object.get("password").toString());
        lp.ClickOnsignInButton();

    }
    @Then("user selects the products")
    public void userSelectsTheProducts() throws InterruptedException {
        ua.SearchTextArea();
        ua.SearchButton();
        ss.waitForLoad(3);
        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollBy(0,250)", "");
        pp.dressSize();
        pp.SelectColour();
        pp.addToCart();
    }



    @And("user Proceeds to shopping cart and checkout")
    public void userProceedsToShoppingCartAndCheckout() {
        ss.waitForLoad(2);
        pp.ShoppingCartIcon();

    }

    @When("user  fills neccessary details for shipping")
    public void userFillsNeccessaryDetailsForShippingAnd()  {
        sc.ProceedToCheckoutButton();
        ss.waitForLoad(5);
        sp.ShippingMethod();
        sp.NextButton();

    }

    @Then("Orderid should be displayed")
    public void orderidShouldBeDisplayed() {
        ss.waitForLoad(6);
        sp.placeorder().click();
        ss.waitForLoad(5);
        WebElement orderid = sp.Orderid();

        Assert.assertEquals(true,orderid.isDisplayed());

        }
    }




