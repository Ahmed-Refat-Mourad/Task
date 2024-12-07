package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class P02_SubscriptionPage {
    private SoftAssert softAssert;
    private final WebDriver driver;
    By lite= By.id("name-lite");
    By classic=By.id("name-classic");
    By premium = By.id("name-premium");
    By litePrice= By.xpath("//div[@id='currency-lite']/b");
    By classicPrice= By.xpath("//div[@id='currency-classic']/b");
    By premiumPrice= By.xpath("//div[@id='currency-premium']/b");
    By premiumCurrency = By.xpath("//div[@id='currency-premium']/i");
    By classicCurrency = By.xpath("//div[@id='currency-classic']/i");
    By liteCurrency = By.xpath("//div[@id='currency-lite']/i");

    public P02_SubscriptionPage(WebDriver driver){
        this.driver=driver;
    }

     public P02_SubscriptionPage checkTheCountrySubscription(String country) throws FileNotFoundException {
         softAssert=new SoftAssert();
         softAssert.assertEquals(Utility.getText(driver,lite),DataUtils.getJsonData("ValidData", country+".plan1"));

         softAssert.assertEquals(Utility.getText(driver,litePrice),DataUtils.getJsonData("ValidData", country+".price1"));
         softAssert.assertEquals(Utility.getText(driver,liteCurrency),DataUtils.getJsonData("ValidData", country+".currency"));
         softAssert.assertEquals(Utility.getText(driver,classic),DataUtils.getJsonData("ValidData", country+".plan2"));
         softAssert.assertEquals(Utility.getText(driver,classicPrice),DataUtils.getJsonData("ValidData", country+".price2"));
         softAssert.assertEquals(Utility.getText(driver,classicCurrency),DataUtils.getJsonData("ValidData", country+".currency"));
         softAssert.assertEquals(Utility.getText(driver,premium),DataUtils.getJsonData("ValidData", country+".plan3"));
         softAssert.assertEquals(Utility.getText(driver,premiumPrice),DataUtils.getJsonData("ValidData", country+".price3"));
         softAssert.assertEquals(Utility.getText(driver,premiumCurrency),DataUtils.getJsonData("ValidData", country+".currency"));

         softAssert.assertAll();
         return this;
     }

}
