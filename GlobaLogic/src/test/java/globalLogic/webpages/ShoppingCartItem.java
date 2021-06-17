package globalLogic.webpages;

import globalLogic.locators.ShoppingCartItemLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ShoppingCartItem extends BasePage{
@FindBy(css = ShoppingCartItemLocator.CSS_PRICE_ITEM)
    WebElement price;
@FindBy(css = ShoppingCartItemLocator.CSS_REMOVE)
    WebElement removeCheck;
@FindBy(css = ShoppingCartItemLocator.CSS_SAVE_CHANGE)
    WebElement saveChangeBtn;
    public ShoppingCartItem(WebDriver driver) throws IOException {
        super(driver);
    }
    protected String getPrice(){
       return getText(price);
    }
    protected boolean existItem(){
        By item= By.cssSelector(ShoppingCartItemLocator.CSS_ITEM);
        return isVisible(item);
    }
    protected ShoppingCartItem removeItem() throws IOException {
        click(removeCheck);
        return new ShoppingCartItem(driver);
    }
    protected ShoppingCartItem saveChange() throws IOException {
        click(saveChangeBtn);
        return new ShoppingCartItem(driver);
    }
}
