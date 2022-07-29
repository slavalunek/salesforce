import org.example.pages.*;
import org.example.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTest extends BaseTest {

    @Test
    public void loginUser() {
        Properties properties = PropertiesLoader.loadProperties();
        new LoginPage(driver).open()
                             .fillInUserName(properties.getProperty("username"))
                             .fillInPassword(properties.getProperty("password"))
                             .submitForm();
        Assert.assertEquals(homePage.getQuarterlyPerformance(), "Quarterly Performance", "the user is not logged in");
    }
}