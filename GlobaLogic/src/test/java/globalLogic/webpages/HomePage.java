package globalLogic.webpages;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends BasePage{
    private TopMenu topMenu;
    public HomePage(WebDriver driver) throws IOException {
        super(driver);
        this.driver.get(PAGE_URL);
        topMenu=new TopMenu(driver);
    }
    public HomePage moveToComputer() throws IOException {
        topMenu.moveToComputer();
        return this;
    }
    public DesktopPage selectDesktop() throws IOException {
        topMenu.selectDesktop();
        return new DesktopPage(driver);
    }

}
