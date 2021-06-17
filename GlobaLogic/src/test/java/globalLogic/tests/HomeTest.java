package globalLogic.tests;

import java.io.IOException;

import globalLogic.data.CharacteristicName;
import globalLogic.data.PriceList;
import globalLogic.webpages.AboutDesktopPage;
import globalLogic.webpages.DesktopPage;
import globalLogic.webpages.HomePage;
import globalLogic.webpages.ShoppingCartItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest{
    public HomeTest() throws IOException {
    }
    @Test
    public void selectDesktop() throws IOException{
        Integer desktopCount=4;
        String price="Price: High to Low";
        Integer elementNumber=1;
        HomePage homePage=new HomePage(driver);
        homePage.moveToComputer();
        DesktopPage desktopPage= homePage.selectDesktop();
        desktopPage.selectDesktopCount(desktopCount);
        Integer itemCount=desktopPage.getItemCount();
        assertThat(itemCount,is((desktopCount)));
        desktopPage.sortProducts(price);
        AboutDesktopPage aboutDesktopPage= desktopPage.addToCardItem(elementNumber);
        Integer elementCount=Integer.parseInt(aboutDesktopPage.getCountShoppingCard());
        aboutDesktopPage.addToCardItem();
        aboutDesktopPage.alertClose();
        Integer elementNewCount=Integer.parseInt(aboutDesktopPage.getCountShoppingCard());
        assertThat(elementNewCount,is((elementCount+1)));

    }
    @Test
    public void buildExpensiveComputer() throws IOException, InterruptedException {
        Double price=0.0;
        String Url="http://demowebshop.tricentis.com/build-your-own-expensive-computer-2";
        AboutDesktopPage aboutDesktopPage= new AboutDesktopPage(driver);
        aboutDesktopPage.goToDesktopPage(Url);
        aboutDesktopPage.selectFastProcessor();
        price+= PriceList.PROCESSOR.get(CharacteristicName.Fast);
        aboutDesktopPage.selectEightRam();
        price+= PriceList.RAM.get(CharacteristicName.Eight);
        aboutDesktopPage.selectImageSoftware();
        price+= PriceList.SOFTWARE.get(CharacteristicName.Image);
        aboutDesktopPage.selectOfficeSuiteSoftware();
        price+=PriceList.SOFTWARE.get(CharacteristicName.OfficeSuite);
        aboutDesktopPage.selectOtherOfficeSuiteSoftware();
        price+=PriceList.SOFTWARE.get(CharacteristicName.OtherOfficeSuite);
        Integer elementCount=Integer.parseInt(aboutDesktopPage.getCountShoppingCard());
        aboutDesktopPage.addToCardItem();
        aboutDesktopPage.alertClose();
        Integer elementNewCount=Integer.parseInt(aboutDesktopPage.getCountShoppingCard());
        assertThat(elementNewCount,is((elementCount+1)));
        price+=Double.parseDouble(aboutDesktopPage.getPrice());
        ShoppingCartItems shoppingCartItems=aboutDesktopPage.goToShoppingCartItems();
        Double totalPrice=Double.parseDouble(shoppingCartItems.getPrice());
        assertThat(price,is(totalPrice));
        boolean existItem=shoppingCartItems.existItem();
        assertThat(existItem,is(true));
        shoppingCartItems.removeItem();
        shoppingCartItems.saveChange();
        elementNewCount=Integer.parseInt(aboutDesktopPage.getCountShoppingCard());
        assertThat(elementNewCount,is((elementCount)));
    }


}
