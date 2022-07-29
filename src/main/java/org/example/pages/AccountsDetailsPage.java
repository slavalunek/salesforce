package org.example.pages;

import lombok.extern.log4j.Log4j2;
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

@Log4j2
public class AccountsDetailsPage extends BasePage {

    public AccountsDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        By accountsLocator = By.xpath("//li[@data-label='Details']//a[@aria-selected='true']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
            log.info("The page {} was opened successfully","Account Details");
            return true;
        } catch (TimeoutException e) {
            log.info("The page {} was not opened because of error: {}","Account Details",e.getMessage());
            return false;
        }
    }

    public AccountsDetailsPage open() {
        driver.findElement(By.xpath("//li[@data-label='Details']//a[@aria-selected='false']")).click();
        return this;
    }

    public Account getAccountDetails() {
        Account account = Account.builder()
                                 .accountName(getAccountName())
                                 .type1(getType())
                                 .type2(getIndustry())
                                 .website(getWebsite())
                                 .parentAccount(getParentAccount())
                                 .employees(getEmployees())
                                 .build();
        return account;
    }

    public String getAccountName() {
        return new TextField(driver, "Account Name").getText();
    }

    public String getType() {
        return new TextField(driver, "Type").getText();
    }

    public String getIndustry() {
        return new TextField(driver, "Industry").getText();
    }

    public String getWebsite() {
        return new LinkField(driver, "Website").getTextLink();
    }

    public String getParentAccount() {
        return new FieldParentAccount(driver, "Parent Account").getText();
    }

    public String getEmployees() {
        return new DigitField(driver, "Employees").getText();
    }
}
