package testCase;

import ReuseableFunction.schronyzationScript;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObject.*;
import util.configReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;

public class addTocartStepDef {

    public configReader cr = new configReader();

    public LoginPage lp = new LoginPage(ldriver);
    public UserAccount ua = new UserAccount(ldriver);
    public ProductPage pp = new ProductPage(ldriver);
    public HomePage hp =new HomePage(ldriver);

    public Properties pro = new Properties();
    public schronyzationScript ss = new schronyzationScript(ldriver);
    public shoppingCart sc = new shoppingCart(ldriver);


    @Given("user is at landing page")
    public void user_is_at_landing_page() {
        try {
            pro = cr.readEnviroment("prod");
            String url = pro.getProperty("Url");
            ldriver.get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("user proceed to Login link")
    public void user_proceed_to_login_link() {
        hp.ClickOnSiginInLink();
    }


    @When("User Search for Product")
    public void user_search_for_product() {
        ua.SearchTextArea();
        ua.SearchButton();
    }
    @When("User adds items to the cart")
    public void user_adds_items_to_the_cart() {
        ss.waitForLoad(3);
        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollBy(0,250)", "");

        pp.dressSize();
        pp.SelectColour();
        pp.addToCart();
        ss.waitForLoad(2);
        pp.selectSize1();
        pp.Selectcolour1();
        pp.Addtocart1();

    }
    @When("user clicks on Shopping cart")
    public void user_clicks_on_shopping_cart() {
        ss.waitForLoad(2);
        pp.ShoppingCartIcon();

    }
    @Then("Valadating items number")
    public void valadating_items_number() {
        List<WebElement> addeditems = sc.listOfProduct();
        ArrayList<String> str = new ArrayList<>();
        for (WebElement listItems : addeditems) {
            String s = listItems.getText();
            str.add(s);
        }

        String stt = sc.NumOfItems();
        int number = Integer.parseInt(stt);

        int i = str.size();
        Assert.assertEquals(i,number );
        System.out.println("TC_03 passed");
        System.out.println("Number of item added:"+ i);

    }

}
