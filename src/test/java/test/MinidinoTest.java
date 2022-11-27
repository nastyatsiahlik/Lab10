package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MinidinoHomePage;
import pages.MinidinoItemPage;

import java.time.Duration;

public class MinidinoTest {
    public static String inputName = "Шапка трикотажная ушки фламинго";
    String expectedName = "Юбка Школа серая клетка";

    private WebDriver driver;

    @BeforeTest
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\tyahl\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
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
