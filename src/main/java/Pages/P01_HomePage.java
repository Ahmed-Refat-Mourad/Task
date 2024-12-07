package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P01_HomePage {
    private final By countryDropdown= By.xpath("//div/a[@id='country-btn']");
    private final By selectEgypt=By.id("eg");
    private final By selectLebanon = By.id("lb");
    private final By selectUAE = By.id("ae");
    private final By toEnglish=By.id("translation-btn");
    private final WebDriver driver ;

    public P01_HomePage(WebDriver driver){
        this.driver=driver;
    }
    public P01_HomePage toEnglish(){
        Utility.clickElement(driver , toEnglish);
        return this;
    }

    public P02_SubscriptionPage chooseCountry(String country) {
        Utility.clickElement(driver, countryDropdown); // Open country selector

        switch (country.toLowerCase()) {
            case "egypt":
                Utility.clickElement(driver, selectEgypt);
                break;
            case "lebanon":
                Utility.clickElement(driver, selectLebanon);
                break;
            case "uae":
                Utility.clickElement(driver, selectUAE);
                break;
            default:
                throw new IllegalArgumentException("Country not supported: " + country);
        }

        return new P02_SubscriptionPage(driver);
    }


}
