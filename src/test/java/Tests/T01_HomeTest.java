package Tests;

import Pages.P01_HomePage;
import Pages.P02_SubscriptionPage;
import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class T01_HomeTest {
   @BeforeMethod(alwaysRun = true)
   public void setup() throws IOException {
       setupDriver(DataUtils.getPropertyValue("environment","Browser"));
       getDriver().get(DataUtils.getPropertyValue("environment","BASE_URL"));

       getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }

     @Test(groups = {"group1", "group2"})
     public void validateSubscriptionDetailsForEgypt() throws IOException {
     new P01_HomePage(getDriver()).toEnglish().chooseCountry("egypt").checkTheCountrySubscription("Egypt");
    }
    @Test(groups = {"group1"})
    public void validateSubscriptionDetailsForLebanon() throws IOException {
        new P01_HomePage(getDriver()).toEnglish().
        chooseCountry("lebanon").checkTheCountrySubscription("Lebanon");
    }

    @Test(groups = {"group2"})
    public void validateSubscriptionDetailsForUAE() throws IOException {
        new P01_HomePage(getDriver()).toEnglish().chooseCountry("uae").checkTheCountrySubscription("UAE");
    }

 @AfterMethod(alwaysRun = true)
  public void quit(){
       quitDriver();
     }
}
