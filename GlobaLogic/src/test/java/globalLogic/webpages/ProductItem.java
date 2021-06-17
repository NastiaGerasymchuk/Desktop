package globalLogic.webpages;

import globalLogic.locators.DesktopLocator;
import globalLogic.locators.ProductItemLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class ProductItem extends BasePage{
    public ProductItem(WebDriver driver) throws IOException {
        super(driver);
    }
    public Integer getItemCount(){
        By item=By.cssSelector(ProductItemLocator.CSS_ITEM_BOX);
        return this.getElementsCount(item);
    }
    public DesktopPage addToCardItem(Integer itemNumber) throws IOException {
        String itemLocator=ProductItemLocator.getItemLocator(itemNumber);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(itemLocator)));
        click(element);
        return new DesktopPage(driver);
    }
}
