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
public class ContactsPage extends BasePage{

    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;

    public ContactsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        By contactsLocator = By.xpath("//span[@class='slds-var-p-right_x-small']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(contactsLocator));
            log.info("The page {} was opened successfully","Contacts");
            return true;
        } catch (TimeoutException e){
            log.info("The page {} was not opened because of error: {}","Contacts",e.getMessage());
            return false;
        }
    }
    public ContactsPage open() {
        driver.get(baseUrl + "lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    public ContactsPage clickNewButton(){
        newButton.click();
        return this;
    }
}
