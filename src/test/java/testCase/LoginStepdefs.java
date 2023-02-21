package testCase;

import ReuseableFunction.schronyzationScript;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UserAccount;
import util.JsonDataReader;
import util.configReader;

import java.io.IOException;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;



public class LoginStepdefs {



    public LoginPage lp = new LoginPage(ldriver);
    HomePage hp= new HomePage(ldriver);
    Properties pro = new Properties();
    configReader cr = new configReader();
    schronyzationScript ss = new schronyzationScript(ldriver);
    UserAccount ua = new UserAccount(ldriver);
    @Given("user is on landing page")
    public void userIsOnLandingPage() throws IOException {

        pro =cr.readEnviroment("prod");
        String url =pro.getProperty("Url");
        ldriver.get(url);

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
        ss.waitForLoad(4);
        boolean ifdisplay= ua.getUserProfile();
        Assert.assertTrue( ifdisplay);



    }



}
