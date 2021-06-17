package globalLogic.webpages;
import globalLogic.enums.ComputerCharacteristicEnum;
import globalLogic.locators.DesktopCharacteristicLocator;
import globalLogic.locators.DesktopLocator;
import globalLogic.locators.ProductItemLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class DesktopPage extends BasePage {
    @FindBy(id = DesktopLocator.ID_SELECT_DESKTOP_COUNT)
    WebElement desktopCount;
    @FindBy(id = DesktopLocator.ID_PRODUCTS_ORDER_BY)
    WebElement productsOrderBy;
    private ProductItem productItem;

    public DesktopPage(WebDriver driver) throws IOException {
        super(driver);
        productItem = new ProductItem(driver);
    }

    public void selectDesktopCount(Integer count) throws IOException {

        this.selectElement(count.toString(), desktopCount);

    }

    public Integer getItemCount() {
        return this.productItem.getItemCount();
    }

    public void sortProducts(String text) throws IOException {
        this.selectElement(text, productsOrderBy);

    }

    public AboutDesktopPage addToCardItem(Integer itemNumber) throws IOException {
        productItem.addToCardItem(itemNumber);
        return new AboutDesktopPage(driver);
    }



}






