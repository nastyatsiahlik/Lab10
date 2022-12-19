package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected final Duration wait = Duration.ofSeconds(20);
    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement waitForPresenceOfElementLocatedBy (WebDriver driver, By by){
        return new WebDriverWait(driver, Duration.ofMillis(8000))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable (WebDriver driver, WebElement webElement){
        return new WebDriverWait(driver, Duration.ofMillis(8000))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}