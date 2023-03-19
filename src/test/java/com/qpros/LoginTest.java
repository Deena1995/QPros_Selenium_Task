package com.qpros;

import com.qpros.Pages.HomePage;
import com.qpros.Pages.LoginPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class LoginTest extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;
    SoftAssert softAssert;
    String login_username = "test2";
    String login_password = "test2";

    @BeforeClass
    public void Intialize() {
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }


    @Test(priority = 1)
    public void SuccessfulLogin() {
        loginPage = homePage.navigate_login();
        loginPage.Login(login_username, login_password);
        softAssert.assertTrue(loginPage.isLogoutDisplayed());
        softAssert.assertTrue(loginPage.isLoggedInUsernameDisplayed());
        softAssert.assertAll();
        loginPage.logOut();
    }


    @Test(dataProvider = "FailedLogin", priority = 2)
    public void failedLogin(String userName, String passWord, String Status) {
        homePage.navigate_home();
        loginPage = homePage.navigate_login();
        loginPage.Login(userName, passWord);
        softAssert.assertEquals(loginPage.readFromPrompt(), Status, "Login Failed");
        loginPage.dismissPrompt();
        loginPage.closeForm();
        softAssert.assertAll();
    }

    @DataProvider(name = "FailedLogin")
    public Object[][] wrongDataProvider() {
        return new Object[][]{
                {"", "", "Please fill out Username and Password."},
                {"test2", "", "Please fill out Username and Password."},
                {"", "test2", "Please fill out Username and Password."},
                {"test2", "x", "Wrong password."},
                {"x", "test2", "Wrong password."},
                {"Test1995", "Test1995", "User does not exist."},};
    }
}
