package org.example.steps;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class LoginSteps {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    public void loginStandardUser() {
        Properties properties = PropertiesLoader.loadProperties();
        loginPage.open()
                 .fillInUserName(properties.getProperty("username"))
                 .fillInPassword(properties.getProperty("password"))
                 .submitForm();
        Assert.assertEquals(homePage.getQuarterlyPerformance(), "Quarterly Performance", "the user is not logged in");
    }
}
