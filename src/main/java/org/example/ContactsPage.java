package org.example;

import org.openqa.selenium.By;
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

    public ContactsPage open() {
        driver.get("https://d8d000005ce1yeaw.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        By contactsLocator = By.xpath("//span[@class='slds-var-p-right_x-small']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactsLocator));
        return this;
    }

    public ContactsPage clickNewButton(){
        newButton.click();
        return this;
    }
}
