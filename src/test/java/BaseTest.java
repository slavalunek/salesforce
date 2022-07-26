import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.AccountsPage;
import org.example.pages.CreatedAccountModel;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    AccountsPage accountsPage;
    CreatedAccountModel createdAccountModel;

    @BeforeMethod()
    public void setUp() {
        //Initialize web driver and create driver instance
        WebDriverManager.chromedriver().setup();
        //Disable notifications
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Set up driver settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        createdAccountModel = new CreatedAccountModel(driver);
    }

    //@AfterMethod(alwaysRun = true)
    //public void tearDown() {
        //if (driver != null) {
            //driver.quit();
        //}
    //}
}