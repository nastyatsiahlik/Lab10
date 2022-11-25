/*import org.openqa.selenium.By;
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

public class ZaraTest {
    private static WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\5sem\\Testing\\testing9NewVersion\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\tyahl\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void findByFullProductNameTest(){
        driver.get("https://www.zara.com/by/ru/");
        String inputName = "Платье из бархата с вышивкой";

        WebElement searchIcon = driver.findElement(By.cssSelector("span.layout-header-search-bar__text>span"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        searchIcon.click();

        WebElement searchInput = driver.findElement( By.xpath("//input[@id=\"search-products-form-combo-input\"]"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput.sendKeys(inputName, Keys.ENTER);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.product-link")));
        WebElement productLink = driver.findElement(By.cssSelector("a.product-link"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productLink));
        productLink.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.product-detail-info__header-name")));
        WebElement nameOfProduct = driver.findElement(By.cssSelector("h1.product-detail-info__header-name"));
        String productNameOnPage = nameOfProduct.getText();

        Assert.assertEquals(productNameOnPage.toLowerCase(), inputName.toLowerCase(), "No such product");
    }

   // @AfterTest
  //  public void closeBrowser(){
    //    driver.quit();
    //}
}*/
