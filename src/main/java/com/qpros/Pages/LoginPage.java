package com.qpros.Pages;

import com.qpros.ElementsRepo.LoginPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends NavigationBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String username, String password) {
        InsertData(LoginPageObjects.LOGIN_USERNAME_FIELD, username);
        InsertData(LoginPageObjects.LOGIN_PASSWORD_FIELD, password);
        clickButton(LoginPageObjects.LOGIN_CONFIRMATION_BUTTON);
    }

    public void closeForm() {
        clickButton(LoginPageObjects.LOGIN_CLOSE_BUTTON);
    }

    public void logOut() {
        clickButton(LoginPageObjects.LOGOUT_BUTTON);
    }

    public Boolean isLogoutDisplayed() {
        waitUntilElementIsVisible(LoginPageObjects.LOGOUT_BUTTON);
        return driver.findElement(By.xpath(LoginPageObjects.LOGOUT_BUTTON)).isDisplayed();
    }

    public Boolean isLoggedInUsernameDisplayed() {
        waitUntilElementIsVisible(LoginPageObjects.USER_NAME_TITTLE);
        return driver.findElement(By.xpath(LoginPageObjects.USER_NAME_TITTLE)).isDisplayed();
    }


}
