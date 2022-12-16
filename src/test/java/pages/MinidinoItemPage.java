package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinidinoItemPage extends AbstractPage{

    public static String MINIDINO_ITEM_PAGE_URL = "https://минидино.рф/catalog/odezhda/platya_yubki/yubka_shkola_seraya_kletka/?offer_id=51509";

    @FindBy(css = "div.product-detail-icons__favorites")
    private WebElement iconAddToHighlights;

    @FindBy(css = " div.header-main-menu-item__icon--favorites")
    private WebElement highlightsIcon;

    public MinidinoItemPage(WebDriver driver) {
        super(driver);
    }

    public MinidinoItemPage openItemPage() {
        driver.get(MINIDINO_ITEM_PAGE_URL);
        new WebDriverWait(driver, wait)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.product-detail-icons__favorites")));
        return this;
    }

    public MinidinoHighlightsPage addProductToHighlights() {
        new WebDriverWait(driver, wait)
                .until(ExpectedConditions.elementToBeClickable(iconAddToHighlights));
        iconAddToHighlights.click();
        new WebDriverWait(driver, wait)
                .until(ExpectedConditions.elementToBeClickable(highlightsIcon));
        highlightsIcon.click();

        return new MinidinoHighlightsPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
