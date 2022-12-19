package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MinidinoHomePage;
import pages.MinidinoItemPage;


public class MinidinoTest {
    public static String inputName = "Шапка трикотажная ушки фламинго";
    public static String expectedName = "Юбка Школа серая клетка";

    private WebDriver driver;

    @BeforeTest
    public void browserSetup() {
            driver = DriverSingleton.getDriver();
    }

    @Test
    public void findByFullProductNameTest() {
        String productNameOnPage = new MinidinoHomePage(driver)
                .openPage()
                .searchForFullProductName(inputName)
                .getTextOfNameOfProduct();
        Assert.assertEquals(productNameOnPage.toLowerCase(), inputName.toLowerCase(), "No such product");
    }

    @Test
    public void addProductToHighlights() {
        String nameOfProductInHighlights = new MinidinoItemPage(driver)
                .openItemPage()
                .addProductToHighlights()
                .getTextOfNameOfProductInHighlights();
        Assert.assertEquals(expectedName, nameOfProductInHighlights, "Highlights does not work correct");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
