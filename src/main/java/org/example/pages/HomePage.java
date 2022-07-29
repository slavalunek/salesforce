package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HomePage extends BasePage{

    @FindBy(xpath = "//span[text()='Quarterly Performance']")
    private WebElement quarterlyPerformance;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        By accountsLocator = By.xpath("//span[text()='Quarterly Performance']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
            log.info("The page {} was opened successfully","Home");
            return true;
        } catch (TimeoutException e){
            log.info("The page {} was not opened because of error: {}","Home",e.getMessage());
            return false;
        }
    }

    public String getQuarterlyPerformance(){
        return quarterlyPerformance.getText();
    }
}
