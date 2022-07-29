package org.example.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class SearchAddress {

    WebDriver driver;
    String label;
    WebDriverWait wait;
    WebElement element = driver.findElement(By.xpath("//h2[text()='Address Search']//" +
            "ancestor::div[contains(@class,'modal-container')]//input"));

    public SearchAddress(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SearchAddress fillSearchAddress(String text) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//" +
                "ancestor::fieldset[contains(@class,'uiInput')]//span[text()='Search Address']", label));
        driver.findElement(fullLocator).click();
        element.sendKeys(text);
        element.click();
        By locator = By.xpath("//div[@class='option']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        String locator1 = String.format("//span[text()='%s']//" +
                "ancestor::fieldset[contains(@class,'uiInput')]//span[text()='Search Address']", label);
        log.info("the element will be found by xpath locator {}",locator1);
        return this;
    }
}
