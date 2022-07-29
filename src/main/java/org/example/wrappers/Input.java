package org.example.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        String locator = String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//input", label);
        log.info("the element will be found by xpath locator {}",locator);
        return this;
    }

    public Input fillInForContacts(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='Last Name']//" +
                "ancestor::div[@class='slds-form-element__row']//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        String locator = String.format("//label[text()='Last Name']//" +
                "ancestor::div[@class='slds-form-element__row']//input", label);
        log.info("the element will be found by xpath locator {}",locator);
        return this;
    }
}
