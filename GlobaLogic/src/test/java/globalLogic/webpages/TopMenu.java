package globalLogic.webpages;

import globalLogic.enums.ComputerTypeEnum;
import globalLogic.enums.TopMenuEnum;
import globalLogic.locators.TopMenuLocator;
import globalLogic.locators.TopMenuNavElementLocator;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TopMenu extends BasePage{

    public TopMenu(WebDriver driver){
        super(driver);
    }
    public TopMenu moveToComputer(){
        TopMenuLocator topMenuLocator=new TopMenuLocator();
        this.selectNavItem(TopMenuEnum.COMPUTERS, topMenuLocator);
        return this;
    }
    public TopMenu selectDesktop(){
        TopMenuNavElementLocator topMenuNavElementLocator=new TopMenuNavElementLocator();
        this.selectMultipleNavItem(TopMenuEnum.COMPUTERS,ComputerTypeEnum.DESKTOPS, topMenuNavElementLocator);
        return this;
    }

}
