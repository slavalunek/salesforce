package org.example.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Textarea {
    WebDriver driver;
    String label;

    public Textarea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public Textarea fillForAccounts(String text) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//textarea", label));
        driver.findElement(fullLocator).sendKeys(text);
        String locator = String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//textarea", label);
        log.info("the element will be found by xpath locator {}",locator);
        return this;
    }

    public Textarea fillForContacts(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//" +
                "ancestor::div[@class='slds-form-element__row']//textarea", label));
        driver.findElement(fullLocator).sendKeys(text);
        String locator = String.format("//label[text()='%s']//" +
                "ancestor::div[@class='slds-form-element__row']//textarea", label);
        log.info("the element will be found by xpath locator {}",locator);
        return this;
    }
}
