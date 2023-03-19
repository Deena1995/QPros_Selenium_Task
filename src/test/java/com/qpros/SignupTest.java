package com.qpros;

import com.qpros.Pages.HomePage;
import com.qpros.Pages.SignupPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.qpros.Utils.Randomizer.generateRandomizedNumber;

public class SignupTest extends BaseClass{

    SignupPage signupPage;
    HomePage homePage;
    SoftAssert softAssert;

    String usernameExist = "test2";
    String passwordExist = "test2";


    @BeforeClass
    public void Intialize(){
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }


    @Test(priority = 1)
    public void signupNewUser() {
        signupPage = homePage.navigate_signUp();
        signupPage.signUP("userName"+generateRandomizedNumber(),"Password"+generateRandomizedNumber());
        softAssert.assertEquals(signupPage.readFromPrompt(),"Sign up successful.","Signup Failed ");
        signupPage.dismissPrompt();
        softAssert.assertAll();
    }

    @Test( priority = 2)
    public void userExists() {
        signupPage = homePage.navigate_signUp();
        signupPage.signUP(usernameExist,passwordExist);
        softAssert.assertEquals(signupPage.readFromPrompt(),"This user already exist.","signup Failed");
        signupPage.dismissPrompt();
        signupPage.closeForm();
        softAssert.assertAll();
    }
    @Test( dataProvider = "FailedRegister",priority = 3)
    public void failedSignUp(String userName, String passWord, String Status) {
        signupPage = homePage.navigate_signUp();
        signupPage.signUP(userName,passWord);
        softAssert.assertEquals(signupPage.readFromPrompt(),Status,"signup Failed");
        signupPage.dismissPrompt();
        signupPage.closeForm();
        softAssert.assertAll();
    }


        @DataProvider(name = "FailedRegister")
        public Object[][] wrongDataProvider() {
            return new Object[][]{
                    {"", "", "Please fill out Username and Password."},
                    {"test2", "", "Please fill out Username and Password."},
                    {"", "test2", "Please fill out Username and Password."},
            };
        }

}

