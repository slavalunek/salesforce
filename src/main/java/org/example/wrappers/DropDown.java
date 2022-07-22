package org.example.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {

    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public DropDown selectForAccounts(String option) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//a", label));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath(String.format("//div[contains(@class, 'visible')]//a[@title='%s']", option))).click();
        return this;
    }

    public DropDown selectForContacts(String option) {
        By fullLocator = By.xpath(String.format("//label[text()='Salutation']//" +
                "ancestor::records-record-layout-input-name[@slot='inputField']//button", label));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath(String.format("//span[text()='%s']", option))).click();
        return this;
    }
}
