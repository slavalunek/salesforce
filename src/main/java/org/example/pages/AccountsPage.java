package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;
    @FindBy(xpath = "//lightning-icon[contains(@class,'slds-icon-utility-success')]")
    private WebElement conformation;

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        By accountsLocator = By.xpath("//div[contains(@class,'slds-breadcrumb__item')]//span[text()='Accounts']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public AccountsPage open() {
        driver.get("https://d8d000005ce1yeaw.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        return this;
    }

    public NewAccountModal clickNewButton() {
        newButton.click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
        return new NewAccountModal(driver);
    }

    public Boolean conformationRegistration(){
        By element = By.xpath ("//lightning-icon[contains(@class,'slds-icon-utility-success')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return conformation.isDisplayed();
    }
}