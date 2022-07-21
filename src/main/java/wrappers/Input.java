package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public Input fillInForAccounts(String text) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }

    public Input fillInForContacts(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='Last Name']//" +
                "ancestor::div[@class='slds-form-element__row']//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }
}
