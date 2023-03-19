package com.qpros;

import com.qpros.Pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckItemsTest extends BaseClass {

    HomePage homePage;
    SoftAssert softAssert;

    @BeforeClass
    public void Intialize() {
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }


    @Test
    public void checkItems() {

        homePage.clickOnPhones();
        softAssert.assertFalse(homePage.hasItems());

        homePage.clickOnMonitors();
        softAssert.assertFalse(homePage.hasItems());

        homePage.clickOnLaptops();
        softAssert.assertFalse(homePage.hasItems());

        softAssert.assertAll();
    }

}
