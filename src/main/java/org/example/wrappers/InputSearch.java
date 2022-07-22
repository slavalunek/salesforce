package org.example.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputSearch {

    WebDriver driver;
    String label;

    WebDriverWait wait;

    public InputSearch(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public InputSearch fillSearchForAccounts(String text, String locator) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        driver.findElement(fullLocator).click();
        By element = By.xpath(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
        return this;
    }

    public InputSearch fillSearchForContacts(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//ancestor::lightning-grouped-combobox//input", label));
        driver.findElement(fullLocator).click();
        By element1 = By.xpath("//div[contains(@class, 'slds-listbox')]//*[contains(text(), 'Recent Accounts')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
        By element2 = By.xpath(String.format("//span[text()='%s']",text));
        driver.findElement(element2).click();
        return this;
    }


}
