package org.example.steps;

import org.example.dto.Account;
import org.example.pages.AccountsPage;
import org.example.pages.NewAccountModal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsSteps {

    WebDriver driver;
    AccountsPage accountsPage;
    String accountName = "Oberbrunner-Keeling";
    WebDriverWait wait;

    public AccountsSteps(WebDriver driver) {
        this.driver = driver;
        this.accountsPage = new AccountsPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AccountsPage createNewAccount(Account account) {
        NewAccountModal modal = accountsPage.open().clickNewButton();
        return modal.fillInNewAccountModal(account)
                    .saveAccount();
    }

    public void createParentAccount() {
        new AccountsPage(driver).open()
                                .clickNewButton();

        Account account1 = new Account(accountName);
        new NewAccountModal(driver).fillInNewAccountModal(account1)
                                   .saveAccount();
    }

    public void deleteAccount() {
        driver.get("https://d8d000005ce1yeaw.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        By locator1 = By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]");
        driver.findElement(locator1).click();
        WebElement element1 = driver.findElement(By.xpath("//div[@title='Delete']"));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", element1);
        driver.findElement(By.xpath("//button[@aria-live='off']//span[text()='Delete']")).click();
        By locator = By.xpath("//div[@role='alertdialog']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
        driver.findElement(locator1).click();
        WebElement element2 = driver.findElement(By.xpath("//div[@title='Delete']"));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", element2);
        driver.findElement(By.xpath("//button[@aria-live='off']//span[text()='Delete']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}