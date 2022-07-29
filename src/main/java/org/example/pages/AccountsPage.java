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
public class AccountsPage extends BasePage {

    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;
    @FindBy(xpath = "//lightning-icon[contains(@class,'slds-icon-utility-success')]")
    private WebElement confirmationMessage;

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        By accountsLocator = By.xpath("//div[@title='New']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
            log.info("The page {} was opened successfully","Account");
            return true;
        } catch (TimeoutException e){
            log.info("The page {} was not opened because of error: {}","Account",e.getMessage());
            return false;
        }
    }

    public AccountsPage open() {
        driver.get(baseUrl + "lightning/o/Account/list?filterName=Recent");
        return this;
    }

    public NewAccountModal clickNewButton() {
        newButton.click();
        return new NewAccountModal(driver);
    }

    public Boolean isConfirmationMessageDisplayed(){
        By element = By.xpath ("//lightning-icon[contains(@class,'slds-icon-utility-success')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return confirmationMessage.isDisplayed();
    }
}