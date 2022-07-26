package org.example.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DigitField {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public DigitField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public DigitField getText() {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//" +
                "ancestor::div[contains(@class,'label-inline')]//lightning-formatted-number[@slot='outputField']", label));
        driver.findElement(fullLocator).getText();
        return this;
    }
}
