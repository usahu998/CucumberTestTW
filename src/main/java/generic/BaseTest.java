package generic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import static generic.IAutoConstant.*;

public class BaseTest {
    public WebDriver driver;

    static {
        System.setProperty(CHROME_KEY, CHROME_VALUE);
    }

    @BeforeTest
    public void setUp() {

        if ((Library.getProperty(CONFIG_PATH, "browser")).equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
            String url = Library.getProperty(CONFIG_PATH, "URL");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
            String ITO = Library.getProperty(CONFIG_PATH, "ImplicitTimeOut");
            int timeoutPeriod = Integer.parseInt(ITO);
            driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
        } else if ((Library.getProperty(CONFIG_PATH, "browser")).equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            String url = Library.getProperty(CONFIG_PATH, "URL");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
        }
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

