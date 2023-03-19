package com.qpros.Pages;
import com.qpros.ElementsRepo.HomePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qpros.Utils.Randomizer.randomFromMaxNum;

public class HomePage extends NavigationBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignupPage navigate_signUp() {
        clickButton(HomePageObjects.SIGN_UP_BUTTON);
        return new SignupPage(driver);
    }

    public LoginPage navigate_login() {
        clickButton(HomePageObjects.LOGIN_BUTTON);
        return new LoginPage(driver);
    }

    public ItemDetailsPage click_Random_product() {
        waitUntilElementIsVisible(HomePageObjects.ITEM_TITTLE);
        int num = driver.findElements(By.xpath(HomePageObjects.ITEM_TITTLE)).size() - 1;
        int random = randomFromMaxNum(num);
        driver.findElements(By.xpath(HomePageObjects.ITEM_TITTLE)).get(random).click();
        return new ItemDetailsPage(driver);
    }

    public void navigate_home() {
        clickButton(HomePageObjects.HOME_BUTTON);
    }

    public void clickOnPhones() {
        forceClickButton(HomePageObjects.PHONE_BUTTON);
    }

    public void clickOnLaptops() {
        forceClickButton(HomePageObjects.LAPTOP_BUTTON);
    }

    public void clickOnMonitors() {
        forceClickButton(HomePageObjects.MONITORS_BUTTON);
    }

    public Boolean hasItems() {
        waitUntilElementIsVisible(HomePageObjects.ITEM_TITTLE);
        return driver.findElements(By.xpath(HomePageObjects.ITEM_TITTLE)).isEmpty();
    }
}
