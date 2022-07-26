package org.example.steps;

import org.example.dto.Account;
import org.example.pages.AccountsPage;
import org.example.pages.NewAccountModal;
import org.openqa.selenium.WebDriver;

public class AccountsSteps {

    WebDriver driver;
    AccountsPage accountsPage;

    public AccountsSteps(WebDriver driver) {
        this.driver = driver;
        this.accountsPage = new AccountsPage(driver);
    }

    public AccountsPage createNewAccount(Account account){
        NewAccountModal modal = accountsPage.clickNewButton();
        return modal.fillInNewAccountModal(account)
                    .saveAccount();
    }
}
