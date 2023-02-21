package testCase;

import ReuseableFunction.schronyzationScript;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.UserAccount;
import util.JsonDataReader;
import util.configReader;

import java.io.IOException;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;


public class SearchFunctionStepDef {

    LoginPage lp = new LoginPage(ldriver);
    UserAccount ua = new UserAccount(ldriver);
    ProductPage pp = new ProductPage(ldriver);
    Properties pro = new Properties();

    configReader cr = new configReader();
    HomePage hp = new HomePage(ldriver);
    schronyzationScript ss = new schronyzationScript(ldriver);


    @Then("user  login into website {string}and {string}")
    public void userLoginIntoWebsiteAnd(String file, String key) {
        try {
            pro =cr.readEnviroment("prod");
            String url =pro.getProperty("Url");
            ldriver.get(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        hp.ClickOnSiginInLink();
        JSONObject object = JsonDataReader.readJsonFile(file,key);
        lp.EmailIdTextArea(object.get("username").toString());
        lp.PasswordTextArea(object.get("password").toString());
        lp.ClickOnsignInButton();
    }

    @When("user searches for particular product")
    public void userSearchesForParticularProduct() {
        ua.SearchTextArea();
        ss.waitForLoad(3);
        ua.SearchButton();

    }
    @Then("Results shown are matches with the  product page and product searched")
    public void resultsShownAreMatchesWithTheProductPageAndProductSearched() {
        WebElement result = pp.SearchedPageResult();
        assert result.isDisplayed();
        System.out.println("Testcase Passed");

    }
}
