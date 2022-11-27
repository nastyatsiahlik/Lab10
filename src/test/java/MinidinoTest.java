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
        System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\tyahl\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void findByFullProductNameTest(){
        /*driver.get("https://минидино.рф/");
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

        Assert.assertEquals(productNameOnPage.toLowerCase(), inputName.toLowerCase(), "No such product");*/

        driver.get("https://минидино.рф/catalog/odezhda/platya_yubki/yubka_shkola_seraya_kletka/?offer_id=51509");

        String expectedName = "Юбка Школа серая клетка";
        String expectedColor = "серая клетка";
        String expectedSize = "134";
        String expectedPrice = "999";

        //div.product-detail-icons__favorites
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.product-detail-icons__favorites")));
        WebElement iconAddToHighlights = driver.findElement(By.cssSelector("div.product-detail-icons__favorites"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(iconAddToHighlights));

        iconAddToHighlights.click();

        //div.header-main-menu-item__icon--favorites
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header-main-menu-item__icon--favorites")));
        WebElement highlightsIcon = driver.findElement(By.cssSelector("div.header-main-menu-item__icon--favorites"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(highlightsIcon));

        highlightsIcon.click();

        //div.category-item-description__title
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.category-item-description__title")));
        WebElement nameOfProductInHighLights = driver.findElement(By.cssSelector("div.category-item-description__title"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nameOfProductInHighLights));

        String nameOfProductInHighLightsText = nameOfProductInHighLights.getText();

        Assert.assertEquals(expectedName, nameOfProductInHighLightsText);



    }

   // @AfterTest
   // public void closeBrowser(){
    //    driver.quit();
  //  }
}
