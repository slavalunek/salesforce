package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        By accountsLocator = By.xpath("//span[text()='Salesforce']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
            log.info("The page {} was opened successfully","Home");
            return true;
        } catch (TimeoutException e) {
            log.info("The page {} was not opened because of error: {}","Login",e.getMessage());
            return false;
        }
    }

    public LoginPage open() {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage fillInUserName(String userName) {
        userNameInput.sendKeys(userName);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage submitForm() {
        loginButton.submit();
        By locator = By.xpath("//span[text()='Quarterly Performance']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return new HomePage(driver);
    }
}