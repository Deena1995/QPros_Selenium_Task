package com.qpros;

import com.qpros.Pages.AddToCartPage;
import com.qpros.Pages.HomePage;
import com.qpros.Pages.ItemDetailsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartTest extends BaseClass{
    HomePage homePage;
    AddToCartPage addToCartPage;
    ItemDetailsPage itemDetailsPage;
    SoftAssert softAssert;

    String username = "testuser";
    String cardname = "12345";



    @BeforeClass
    public void Intialize(){
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test(priority = 1)
    public void addToCart() {
        homePage.clickOnPhones();
        itemDetailsPage = homePage.click_Random_product();
        itemDetailsPage.clickOnAddToCart();
        softAssert.assertEquals(itemDetailsPage.readFromPrompt(),"Product added");
        itemDetailsPage.dismissPrompt();
        addToCartPage = itemDetailsPage.navigate_cart();
        addToCartPage.clickOnPurchase();
        addToCartPage.purchaseItemFromCart(username,cardname);
        softAssert.assertTrue(addToCartPage.isConfirmationVisible());
        softAssert.assertEquals(addToCartPage.getPurchase_confirmation(),"Thank you for your purchase!");
        addToCartPage.clickOnConfirmPurchase();
        softAssert.assertAll();
    }


    @Test(priority = 2)
    public void deleteFromCart() throws InterruptedException {
        homePage.clickOnPhones();
        itemDetailsPage = homePage.click_Random_product();
        itemDetailsPage.clickOnAddToCart();
        itemDetailsPage.dismissPrompt();
        addToCartPage = itemDetailsPage.navigate_cart();
        addToCartPage.removeFromChart();
        softAssert.assertTrue(addToCartPage.hasItemsInCart());
        softAssert.assertAll();
    }



}

