package globalLogic.tests;

import globalLogic.configure.ConfigurePath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected  static WebDriver driver;

    protected static String setConfigure(String url,String property) throws IOException {
        Properties prop = new Properties();
        FileInputStream fi = new FileInputStream(url);
        prop.load(fi);
        return prop.getProperty(property);
    }
    public BaseTest() throws IOException {
    }

    @BeforeAll
    public static   void setup() throws IOException {
        String BROWSER_NAME=BaseTest.setConfigure(ConfigurePath.BROWSER_CONFIGURE,"BROWSER_NAME");
        String DESKTOP_PATH=BaseTest.setConfigure(ConfigurePath.BROWSER_CONFIGURE,"DESKTOP_PATH");
        System.setProperty(BROWSER_NAME, DESKTOP_PATH);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certifcate-errors");
        chromeOptions.addArguments("test-type");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }


    @AfterAll
    public static void TearDown(){
        driver.close();
    }
}
