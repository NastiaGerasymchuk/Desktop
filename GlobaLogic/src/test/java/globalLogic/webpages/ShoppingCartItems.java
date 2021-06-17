package globalLogic.webpages;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ShoppingCartItems extends BasePage{
    private ShoppingCartItem shoppingCartItem;
    public ShoppingCartItems(WebDriver driver) throws IOException {
        super(driver);
        shoppingCartItem=new ShoppingCartItem(driver);
    }
    public String getPrice(){
        return shoppingCartItem.getPrice();
    }
    public boolean existItem(){
        return shoppingCartItem.existItem();
    }
    public ShoppingCartItems removeItem() throws IOException {
        shoppingCartItem.removeItem();
        return new ShoppingCartItems(driver);
    }
    public ShoppingCartItems saveChange() throws IOException {
        shoppingCartItem.saveChange();
        return new ShoppingCartItems(driver);
    }
}
