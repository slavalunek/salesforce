package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsDetailsPage extends BasePage{

    public AccountsDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        By accountsLocator = By.xpath("//li[@data-label='Details']//a[@aria-selected='true']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public AccountsDetailsPage open() {
        driver.findElement(By.xpath("//li[@data-label='Details']//a[@aria-selected='false']")).click();
        return this;
    }
}
