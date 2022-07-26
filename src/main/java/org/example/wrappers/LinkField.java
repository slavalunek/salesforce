package org.example.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinkField {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public LinkField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LinkField getTextLink() {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'label-inline')]//" +
                "a[@href='https://www.clare-veum.biz']", label));
        driver.findElement(fullLocator).getText();
        return this;
    }
}
