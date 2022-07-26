package org.example.pages;

import org.example.dto.Account;
import org.example.wrappers.DigitField;
import org.example.wrappers.FieldParentAccount;
import org.example.wrappers.LinkField;
import org.example.wrappers.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreatedAccountModel extends BasePage {


    public CreatedAccountModel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public CreatedAccountModel getTextAccountModal(Account account) {
        new TextField(driver, "Account Name").getText();
        new TextField(driver, "Type").getText();
        new TextField(driver, "Industry").getText();
        new LinkField(driver, "Website").getTextLink();
        new FieldParentAccount(driver, "Parent Account").getText();
        new DigitField(driver, "Employees").getText();
        return this;
    }
}
