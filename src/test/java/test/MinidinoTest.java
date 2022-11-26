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

import java.time.Duration;

public class MinidinoTest {
    public static String inputName = "Шапка трикотажная ушки фламинго";

    private WebDriver driver;

    @BeforeTest
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\tyahl\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void findByFullProductNameTest() {
        String productNameOnPage = new MinidinoHomePage(driver)
                .openPage()
                .searchForFullProductName(inputName)
                .getTextOfNameOfProduct();
        Assert.assertEquals(productNameOnPage.toLowerCase(), inputName.toLowerCase(), "No such product");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
