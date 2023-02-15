package testCase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObject.HomePage;
import pageObject.LoginPage;
import util.JsonDataReader;
import util.configReader;

import java.io.IOException;

import static diverInit.Initializing_Driver.ldriver;



public class LoginStepdefs {



    public LoginPage lp = new LoginPage(ldriver);
    HomePage hp= new HomePage(ldriver);

    @Given("user is on landing page")
    public void userIsOnLandingPage() throws IOException {

        configReader cr = new configReader("dev");

        String debUrl = cr.getUrl();
        ldriver.get(debUrl);
    }

    @And("user proceeds to Login link")
    public void userProceedsToLoginLink() {

        hp.ClickOnSiginInLink();

    }

    @When("user provides {string} and {string}")
    public void userProvidesAnd(String file, String key) {
        JSONObject object = JsonDataReader.readJsonFile(file,key);
        lp.EmailIdTextArea(object.get("username").toString());
        lp.PasswordTextArea(object.get("password").toString());
        lp.ClickOnsignInButton();
    }


    @Then("user is on HomePage")
    public void userIsOnHomePage() {
        try {
            Thread.sleep(3000);

        String Actualmessage = ldriver.findElement(By.xpath("//span[@class = 'base']")).getText();
        System.out.println(Actualmessage);
        String ExpectedName = "Home Page";


        Assert.assertEquals(ExpectedName, Actualmessage);
        System.out.println("TC_02 passed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }



}
