package com.qpros.Pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NavigationBase {

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    Actions actions;

    public NavigationBase(WebDriver driver) {
        this.driver = driver;
        wait = (new WebDriverWait(driver, 5));
        actions = new Actions(driver);
    }


    public void waitUntilElementIsClickable(String detailIdentifier) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(detailIdentifier)));
        } catch (Exception e) {
            System.out.println("Element is not Clickable");
        }
    }

    public void waitUntilElementIsVisible(String detailIdentifier) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(detailIdentifier)));
        } catch (Exception e) {
        }
    }


    public void clickButton(String Idetifier) {
        waitUntilElementIsClickable(Idetifier);
        driver.findElement(By.xpath(Idetifier)).click();
    }

    public void forceClickButton(String Idetifier) {
        actions.moveToElement(driver.findElement(By.xpath(Idetifier))).click().perform();
    }


    public void InsertData(String Xpath, String text) {
        waitUntilElementIsVisible(Xpath);
        driver.findElement(By.xpath(Xpath)).clear();
        driver.findElement(By.xpath(Xpath)).sendKeys(text);
    }


    public String readFromPrompt() {
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        return alert.getText(); // get text from prompt
    }

    public void dismissPrompt() {
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public String getTextFromIdentifier(String identifier) {
        waitUntilElementIsVisible(identifier);
        return  driver.findElement(By.xpath(identifier)).getText();
    }
}
