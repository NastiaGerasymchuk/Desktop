package globalLogic.webpages;

import globalLogic.enums.*;
import globalLogic.locators.AboutDesktopLocator;
import globalLogic.locators.AboutDesktopNavLocator;
import globalLogic.locators.DesktopCharacteristicLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class AboutDesktopPage extends BasePage{
    @FindBy(id= AboutDesktopLocator.ID_ADD_TO_CARD_ITEM)
    WebElement addToCard;
    @FindBy(css= AboutDesktopNavLocator.CSS_ALERT_ELEMENT_ADDED_CLOSE)
    WebElement alertClose;
    @FindBy(css= DesktopCharacteristicLocator.CSS_DESKTOP_PRICE)
    WebElement price;
    private AboutDesktopNav aboutDesktopNav;
    public AboutDesktopPage(WebDriver driver) throws IOException {
        super(driver);
        aboutDesktopNav=new AboutDesktopNav(driver);
    }
    public AboutDesktopPage addToCardItem() throws IOException {
        click(addToCard);
        return this;

    }
    public String getCountShoppingCard(){
        return aboutDesktopNav.getCountShoppingCard();
    }
    public ShoppingCartItems goToShoppingCartItems() throws IOException {
        return aboutDesktopNav.goToShoppingCart();
    }
    public AboutDesktopPage alertClose() throws IOException {
        click(alertClose);
        return this;
    }
    public AboutDesktopPage goToDesktopPage(String url) throws IOException {
        this.driver.get(url);
        return new AboutDesktopPage(driver);

    }
    private AboutDesktopPage selectProcessor(Integer type) throws IOException {
        DesktopCharacteristicLocator desktopCharacteristicLocator = new DesktopCharacteristicLocator();
        WebElement processorType = driver.findElement(By.xpath(desktopCharacteristicLocator.getItemMultipleLocator(ComputerCharacteristicEnum.PROCESSOR.ordinal()+1,type)));
        click(processorType);
        return new AboutDesktopPage(driver);
    }
    private AboutDesktopPage selectRam(Integer type) throws IOException {
        DesktopCharacteristicLocator desktopCharacteristicLocator = new DesktopCharacteristicLocator();
        WebElement processorType = driver.findElement(By.xpath(desktopCharacteristicLocator.getItemMultipleLocator(ComputerCharacteristicEnum.RAM.ordinal()+1,type)));
        click(processorType);
        return new AboutDesktopPage(driver);
    }
    public AboutDesktopPage selectSlowProcessor() throws IOException {
        return selectProcessor(ProcessorEnum.SLOW.ordinal()+1);
    }
    public AboutDesktopPage selectMediumProcessor() throws IOException {
        return selectProcessor(ProcessorEnum.MEDIUM.ordinal()+1);
    }
    public AboutDesktopPage selectFastProcessor() throws IOException {
        return selectProcessor(ProcessorEnum.FAST.ordinal()+1);
    }
    public AboutDesktopPage selectEightRam() throws IOException {
        return selectRam(RamEnum.EIGHT.ordinal()+1);
    }
    private AboutDesktopPage selectSoftWare(Integer type) throws IOException {
        DesktopCharacteristicLocator desktopCharacteristicLocator = new DesktopCharacteristicLocator();
        WebElement processorType = driver.findElement(By.xpath(desktopCharacteristicLocator.getItemMultipleLocator(ComputerCharacteristicEnum.SOFTWARE.ordinal()+1,type)));
        click(processorType);
        return new AboutDesktopPage(driver);
    }
    public AboutDesktopPage selectImageSoftware() throws IOException {
        return selectSoftWare(SoftWareEnum.IMAGE.ordinal()+1);
    }
    public AboutDesktopPage selectOfficeSuiteSoftware() throws IOException {
        return selectSoftWare(SoftWareEnum.OFFICE_SUITE.ordinal()+1);
    }
    public AboutDesktopPage selectOtherOfficeSuiteSoftware() throws IOException {
        return selectSoftWare(SoftWareEnum.OTHER_OFFICE_SUITE.ordinal()+1);
    }
    public String getPrice(){
        return getText(price);
    }
}
