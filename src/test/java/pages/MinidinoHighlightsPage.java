package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinidinoHighlightsPage extends AbstractPage{


    @FindBy(css = "div.category-item-description__title")
    private WebElement nameOfProductInHighlights;

    protected MinidinoHighlightsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfNameOfProductInHighlights() {
        waitForPresenceOfElementLocatedBy(driver, By.cssSelector("div.category-item-description__title"));
        return nameOfProductInHighlights.getText();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
