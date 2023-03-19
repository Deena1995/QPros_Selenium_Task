package com.qpros.Pages;
import com.qpros.ElementsRepo.SignupPageObjects;
import org.openqa.selenium.WebDriver;


public class SignupPage extends NavigationBase {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void signUP(String username, String password) {
        InsertData(SignupPageObjects.SIGN_USERNAME_FIELD, username);
        InsertData(SignupPageObjects.SIGN_PASSWORD_FIELD, password);
        clickButton(SignupPageObjects.SIGN_UP_CONFIRMATION_BUTTON);
    }

    public void closeForm() {
        clickButton(SignupPageObjects.SIGN_UP_CLOSE_BUTTON);
    }

}
