package testCase;

import ReuseableFunction.schronyzationScript;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import pageObject.ProductPage;

import static diverInit.Initializing_Driver.ldriver;

public class ShortingStepDef {

    ProductPage pp = new ProductPage(ldriver);
    schronyzationScript ss = new schronyzationScript(ldriver);
    @Then("user choose the product category")
    public void userChooseTheProductCategory() {
        pp.mensOption();
        pp.MenTop();

    }
    @When("user chooses the shorting option")
    public void userChoosesTheShortingOption() {
        pp.chooseoption();
        pp.selectShortBy();

    }
    @Then("products are shorted in selected order")
    public void productsAreShortedInSelectedOrder() {

        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollBy(0,350)", "");
        ss.waitForLoad(5);
        String s1= pp.Price1().substring(1);

        Float price1 = Float.parseFloat(s1);

        String s2 =pp.Price2().substring(1);

        Float price2 = Float.parseFloat(s2);;

        String s3 = pp.Price3().substring(1);

        Float price3 = Float.parseFloat(s3);

        float [] arr = new float[]{price1,price2,price3};
        for (int i=0; i<arr.length;i++){
            for (int j= i+1; j<arr.length;j++){
                if(arr[i]<arr[j]){
                    float temp = arr[i];
                     arr[i]= arr[j];
                     arr[j]=temp;
                }
            }


        }

        for (int i=0; i<arr.length;i++){
         System.out.println(arr[i]);


        }


    }
}
