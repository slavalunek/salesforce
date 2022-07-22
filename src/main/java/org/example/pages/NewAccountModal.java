package org.example.pages;

import org.example.dto.Account;
import org.example.wrappers.DropDown;
import org.example.wrappers.Input;
import org.example.wrappers.InputSearch;
import org.example.wrappers.Textarea;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountModal extends BasePage {

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveAccountButton;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveContactButton;

    public NewAccountModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public NewAccountModal fillInNewAccountModal(Account account) {
        new InputSearch(driver,"Account Name").fillSearchForAccounts(account.getAccountName(),"//div[@title='Ddc I Inc']");
        new InputSearch(driver,"Parent Account").fillSearchForAccounts("","//div[@title='вапар']");
        if (account.getWebsite() != null){
            new Input(driver, "Website").fillInForAccounts(account.getWebsite());
        }

        if (account.getType1() != null){
            new Input(driver, "Type").fillInForAccounts(account.getType1());
        }

        if (account.getType2() != null){
            new Input(driver, "Industry").fillInForAccounts(account.getType2());
        }

        if (account.getEmployees() != null){
            new Input(driver, "Employees").fillInForAccounts(account.getEmployees());
        }


//        new Input(driver, "Billing City").fillInForAccounts(billingCity);
//        new Input(driver, "Billing Zip/Postal Code").fillInForAccounts(billingZip);
//        new Input(driver, "Billing State/Province").fillInForAccounts(province);
//        new Input(driver, "Billing Country").fillInForAccounts(billingCountry);
//        new Input(driver, "Shipping City").fillInForAccounts(shippingCity);
//        new Input(driver, "Shipping Zip/Postal Code").fillInForAccounts(shippingZip);
//        new Input(driver, "Shipping State/Province").fillInForAccounts(shippingState);
//        new Input(driver, "Shipping Country").fillInForAccounts(shippingCountry);
//        new Textarea(driver, "Description").fillForAccounts(description);
//        new Textarea(driver, "Billing Street").fillForAccounts(billingStreet);
//        new Textarea(driver, "Shipping Street").fillForAccounts(shippingStreet);
        return this;
    }

//    public NewAccountModal fillInNewAccountModal(String dd, String website, String phone,
//                                                 String type1, String type2, String employees, String billingCity,
//                                                 String billingZip, String province, String billingCountry,
//                                                 String shippingCity, String shippingZip, String shippingState,
//                                                 String shippingCountry, String description, String billingStreet,
//                                                 String shippingStreet) {
//        new InputSearch(driver,"Account Name").fillSearchForAccounts(dd,"//div[@title='Ddc I Inc']");
//        new InputSearch(driver,"Parent Account").fillSearchForAccounts("","//div[@title='вапар']");
//        new Input(driver, "Website").fillInForAccounts(website);
//        new Input(driver, "Phone").fillInForAccounts(phone);
//        new DropDown(driver, "Type").selectForAccounts(type1);
//        new DropDown(driver,"Industry").selectForAccounts(type2);
//        new Input(driver, "Employees").fillInForAccounts(employees);
//        new Input(driver, "Billing City").fillInForAccounts(billingCity);
//        new Input(driver, "Billing Zip/Postal Code").fillInForAccounts(billingZip);
//        new Input(driver, "Billing State/Province").fillInForAccounts(province);
//        new Input(driver, "Billing Country").fillInForAccounts(billingCountry);
//        new Input(driver, "Shipping City").fillInForAccounts(shippingCity);
//        new Input(driver, "Shipping Zip/Postal Code").fillInForAccounts(shippingZip);
//        new Input(driver, "Shipping State/Province").fillInForAccounts(shippingState);
//        new Input(driver, "Shipping Country").fillInForAccounts(shippingCountry);
//        new Textarea(driver, "Description").fillForAccounts(description);
//        new Textarea(driver, "Billing Street").fillForAccounts(billingStreet);
//        new Textarea(driver, "Shipping Street").fillForAccounts(shippingStreet);
//        return this;
//    }

    public NewAccountModal saveAccount() {
        saveAccountButton.click();
        return this;
    }

    public NewAccountModal fillInNewContactModal(String salutation, String lastName, String accountName,String mailingStreet){
        new DropDown(driver,"Salutation").selectForContacts(salutation);
        new Input(driver,"Last Name").fillInForContacts(lastName);
        new InputSearch(driver,"Account Name").fillSearchForContacts(accountName);
        new Textarea(driver,"Mailing Street").fillForContacts(mailingStreet);
        return this;
    }

    public NewAccountModal saveContact() {
        saveContactButton.click();
        return this;
    }
}