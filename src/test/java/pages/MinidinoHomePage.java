package pages;

import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinidinoHomePage extends AbstractPage{
    public static String MINIDINO_HOME_PAGE_URL = "https://минидино.рф/";

    @FindBy(className = "header-main-menu-search")
    private WebElement searchIcon;

    @FindBy(xpath = "//div[@class='header-main-menu-list']//input[@type = \"search\"]")
    private WebElement searchInput;

    public MinidinoHomePage(WebDriver driver) {
        super(driver);
    }

    public MinidinoHomePage openPage() {
        driver.get(MINIDINO_HOME_PAGE_URL);
        new WebDriverWait(driver, wait)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("header-main-menu-search")));
        return this;
    }

    public MinidinoSearchResultPage searchForFullProductName(String inputName) {
        new WebDriverWait(driver, wait)
                .until(ExpectedConditions.elementToBeClickable(searchIcon));
        searchIcon.click();
        new WebDriverWait(driver, wait)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-main-menu-list']//input[@type = \"search\"]")));
        new WebDriverWait(driver, wait)
                .until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.sendKeys(inputName, Keys.ENTER);
        return new MinidinoSearchResultPage(driver);
    }
}
