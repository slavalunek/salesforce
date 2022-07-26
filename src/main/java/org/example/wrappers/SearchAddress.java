package org.example.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchAddress {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public SearchAddress(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SearchAddress fillSearchAddress(String text) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//" +
                "ancestor::fieldset[contains(@class,'uiInput')]//span[text()='Search Address']", label));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath("//h2[text()='Address Search']//" +
                "ancestor::div[contains(@class,'modal-container')]//input")).sendKeys(text);
        driver.findElement(By.xpath("//h2[text()='Address Search']//" +
                "ancestor::div[contains(@class,'modal-container')]//input")).click();
        By locator = By.xpath("//div[@class='option']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        return this;
    }
}
