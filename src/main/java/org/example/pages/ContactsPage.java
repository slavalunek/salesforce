package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage{

    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;

    public ContactsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        By contactsLocator = By.xpath("//span[@class='slds-var-p-right_x-small']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(contactsLocator));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }
    public ContactsPage open() {
        driver.get("https://d8d000005ce1yeaw.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    public ContactsPage clickNewButton(){
        newButton.click();
        return this;
    }
}
