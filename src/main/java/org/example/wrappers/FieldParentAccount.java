package org.example.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class FieldParentAccount {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public FieldParentAccount(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getText() {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//" +
                "ancestor::div[contains(@class,'slds-form-element')]//span[text()='Oberbrunner-Keeling']", label));
        String locator = String.format("//span[text()='%s']//" +
                "ancestor::div[contains(@class,'slds-form-element')]//span[text()='Oberbrunner-Keeling']", label);
        log.info("the element will be found by xpath locator {}",locator);
        return driver.findElement(fullLocator).getText();
    }
}
