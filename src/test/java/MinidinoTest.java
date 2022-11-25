import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MinidinoTest {

    private static WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void browserSetup() {
       // System.setProperty("webdriver.chrome.driver", "D:\\5sem\\Testing\\testing9NewVersion\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "..\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\tyahl\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void findByFullProductNameTest(){
        driver.get("https://минидино.рф/");
        String inputName = "Шапка трикотажная ушки фламинго";

        WebElement searchIcon = driver.findElement(By.className("header-main-menu-search"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        searchIcon.click();

        WebElement searchInput = driver.findElement( By.xpath("/html/body/div[1]/div/header/div[2]/div[5]/div/div[3]/form/label/div/div/div/input"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput.sendKeys(inputName, Keys.ENTER);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.category-item-description__title")));
        WebElement nameOfProduct = driver.findElement(By.cssSelector("div.category-item-description__title"));

        String productNameOnPage = nameOfProduct.getText();

        Assert.assertEquals(productNameOnPage.toLowerCase(), inputName.toLowerCase(), "No such product");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
