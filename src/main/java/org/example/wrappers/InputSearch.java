package org.example.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class InputSearch {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public InputSearch(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public InputSearch fillSearchForNameAccount(String text) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        driver.findElement(fullLocator).click();
        return this;
    }

    public InputSearch fillSearchForParentAccount() {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//input", label));
        driver.findElement(fullLocator);
        driver.findElement(fullLocator).click();
        By element = By.xpath("//div[@title='Oberbrunner-Keeling']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
        String locator = String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//input", label);
        log.info("the element will be found by xpath locator {}",locator);
        return this;
    }

    public InputSearch fillSearchForContacts(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//ancestor::lightning-grouped-combobox//input", label));
        driver.findElement(fullLocator).click();
        By element1 = By.xpath("//div[contains(@class, 'slds-listbox')]//*[contains(text(), 'Recent Accounts')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
        By element2 = By.xpath(String.format("//span[text()='%s']",text));
        driver.findElement(element2).click();
        String locator = String.format("//label[text()='%s']//ancestor::lightning-grouped-combobox//input", label);
        log.info("the element will be found by xpath locator {}",locator);
        return this;
    }


}
