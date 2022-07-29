package org.example.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        String locator = String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//a", label);
        log.info("the element will be found by xpath locator {}",locator);

        driver.findElement(By.xpath(String.format("//div[contains(@class, 'visible')]//a[@title='%s']", option))).click();

        String locator1 = String.format("//div[contains(@class, 'visible')]//a[@title='%s']", label);
        log.info("the element will be found by xpath locator {}",locator1);
        return this;
    }

    public DropDown selectForContacts(String option) {
        By fullLocator = By.xpath(String.format("//label[text()='Salutation']//" +
                "ancestor::records-record-layout-input-name[@slot='inputField']//button", label));
        driver.findElement(fullLocator).click();
        String locator = String.format("//label[text()='Salutation']//" +
                "ancestor::records-record-layout-input-name[@slot='inputField']//button", label);
        log.info("the element will be found by xpath locator {}",locator);
        driver.findElement(By.xpath(String.format("//span[text()='%s']", option))).click();
        String locator1 = String.format("//span[text()='%s']", label);
        log.info("the element will be found by xpath locator {}",locator1);
        return this;
    }
}
