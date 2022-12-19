package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinidinoSearchResultPage extends AbstractPage{

    @FindBy(css = "div.category-item-description__title")
    private WebElement nameOfProduct;

    protected MinidinoSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfNameOfProduct() {
        waitForPresenceOfElementLocatedBy(driver,By.cssSelector("div.category-item-description__title"));
        return nameOfProduct.getText();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
