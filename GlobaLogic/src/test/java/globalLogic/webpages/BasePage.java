package globalLogic.webpages;

import globalLogic.configure.ConfigurePath;
import globalLogic.locators.BaseNav;
import globalLogic.locators.BaseNavMultiple;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class BasePage{
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static String PAGE_URL;
    protected static Integer SECONDS_WAITING;

    static {
        SECONDS_WAITING =Integer.parseInt(BasePage.setConfigure(ConfigurePath.BROWSER_CONFIGURE,"SECONDS_WANTINGS"));
        PAGE_URL=setConfigure(ConfigurePath.SITE_CONFIGURE,"URL");
    }

    private static String setConfigure(String url,String property)  {
        try{
            Properties prop = new Properties();
            FileInputStream fi = new FileInputStream(url);
            prop.load(fi);
            return prop.getProperty(property);
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }

    }

        public BasePage(WebDriver driver){
            super();
            this.driver=driver;
            this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.SECONDS_WAITING));
            PageFactory.initElements(this.driver, this);

        }
        private void waitForElementToBeDisplayed(WebElement element) {
            ExpectedCondition<Boolean> elementIsDisplayed = arg0 -> element.isDisplayed();
            wait.until(elementIsDisplayed);
        }
        protected void click(WebElement webElement){
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }
        protected Integer getElementsCount(By locator){
            List<WebElement> webElements= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            return webElements.size();

        }
        protected String getAttribute(WebElement webElement, String attribute){
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.getAttribute(attribute);

        }
        protected String getText(WebElement webElement){
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.getText();
        }
        protected   void sendKeys(WebElement webElement ,String number){
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.sendKeys(number);

        }

        protected boolean isVisible(By locator){
            try {
                WebElement webElement= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                return webElement.isDisplayed();
            }
            catch (TimeoutException exception){
                return false;
            }

        }
        protected boolean isEnabled(By locator){
            try {
                WebElement webElement= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                return webElement.isEnabled();
            }
            catch (TimeoutException exception){
                return false;
            }

        }
    public By navListItem(Integer child, BaseNav baseLocator)
    {
        String itemLocator=baseLocator.getItemLocator(child);
        return By.cssSelector(itemLocator);
    }
    protected void selectNavItem(Enum item, BaseNav baseLocator){
        By el=navListItem(item.ordinal()+1,baseLocator);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(el));

        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();;
    }
    public By navMultipleListItem(Integer navItem,Integer child, BaseNavMultiple baseLocator)
    {
        String itemLocator=baseLocator.getItemMultipleLocator(navItem,child);
        return By.cssSelector(itemLocator);
    }
    protected void selectMultipleNavItem(Enum parent,Enum child, BaseNavMultiple baseLocator){
        By el=navMultipleListItem(parent.ordinal()+1,child.ordinal()+1,baseLocator);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(el));
        element.click();
    }
    protected void selectElement(String text,WebElement webElement){
        Select list= new Select(wait.until(ExpectedConditions.visibilityOf(webElement)));
        list.selectByVisibleText(text);
    }
}


