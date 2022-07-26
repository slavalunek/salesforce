package org.example.pages;

import org.example.dto.Account;
import org.example.wrappers.DigitField;
import org.example.wrappers.FieldParentAccount;
import org.example.wrappers.LinkField;
import org.example.wrappers.TextField;
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

    public Account getAccountDetails(){
        Account account = new Account(getAccountName());
        account.setType1(getType());
        account.setType2(getIndustry());
        account.setWebsite(getWebsite());
        account.setParentAccount(getParentAccount());
        account.setEmployees(getEmployees());
        return account;
    }

    public String getAccountName(){
       return new TextField(driver, "Account Name").getText();
    }

    public String getType(){
       return  new TextField(driver, "Type").getText();
    }

    public String getIndustry(){
       return new TextField(driver, "Industry").getText();
    }

    public String getWebsite(){
       return new LinkField(driver, "Website").getTextLink();
    }

    public String getParentAccount(){
       return new FieldParentAccount(driver, "Parent Account").getText();
    }
    public String getEmployees(){
       return new DigitField(driver, "Employees").getText();
    }
}
