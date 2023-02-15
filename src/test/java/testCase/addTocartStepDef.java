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
import java.util.ArrayList;
import java.util.List;

import static diverInit.Initializing_Driver.ldriver;

public class addTocartStepDef {

    public configReader cr;

    public LoginPage lp = new LoginPage(ldriver);
    public UserAccount ua = new UserAccount(ldriver);
    public ProductPage pp = new ProductPage(ldriver);
    public HomePage hp =new HomePage(ldriver);


    @Given("user is at landing page")
    public void user_is_at_landing_page() {

        try {
            cr = new configReader("dev");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String devUrl = cr.getUrl();
        ldriver.get(devUrl);

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
        try {
            JavascriptExecutor js = (JavascriptExecutor) ldriver;
            js.executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(4000);
            pp.dressSize();
            pp.SelectColour();
            pp.addToCart();
            Thread.sleep(5000);
            pp.selectSize1();
            pp.Selectcolour1();
            pp.Addtocart1();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("user clicks on Shopping cart")
    public void user_clicks_on_shopping_cart() {
        try {
            Thread.sleep(3000);
            pp.ShoppingCartIcon();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Then("Valadating items number")
    public void valadating_items_number() {
        List<WebElement> addeditems = ldriver.findElements(By.xpath("//*[contains(@data-bind,'attr: {href: product_url}, html: product_name')]"));
        ArrayList<String> str = new ArrayList<>();
        for (WebElement listItems : addeditems) {
            String s = listItems.getText();
            str.add(s);
        }
        WebElement noOfItems= ldriver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]"));
        String stt = noOfItems.getText();
        int number = Integer.parseInt(stt);

        int i = str.size();
        Assert.assertEquals(i,number );
        System.out.println("TC_03 passed");
        System.out.println(str.get(0));
        System.out.println(str.get(1));
    }

}
