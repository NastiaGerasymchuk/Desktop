package globalLogic.webpages;

import globalLogic.locators.AboutDesktopNavLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AboutDesktopNav extends BasePage{
    public AboutDesktopNav(WebDriver driver) throws IOException {
        super(driver);
    }
    @FindBy(css = AboutDesktopNavLocator.CSS_SHOPPING_CART_SPAN)
    WebElement shoppingCart;
    @FindBy(css = AboutDesktopNavLocator.CSS_SHOPPING_CART)
    WebElement shoppingCartButton;
    public String getCountShoppingCard(){
        String res= getText(shoppingCart);
        return res.replaceAll("[\\[\\]()]","");
    }
    public ShoppingCartItems goToShoppingCart() throws IOException {
        click(shoppingCartButton);
        return new ShoppingCartItems(driver);
    }
}
