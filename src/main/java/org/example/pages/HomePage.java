package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(xpath = "//span[text()='Quarterly Performance']")
    private WebElement quarterlyPerformance;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        By accountsLocator = By.xpath("//span[text()='Quarterly Performance']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public String getQuarterlyPerformance(){
        return quarterlyPerformance.getText();
    }
}
