package org.example.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextField {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public TextField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public TextField getText() {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//" +
                "ancestor::div[contains(@class,'label-inline')]//lightning-formatted-text[@slot='outputField']", label));
        driver.findElement(fullLocator).getText();
        return this;
    }
}
