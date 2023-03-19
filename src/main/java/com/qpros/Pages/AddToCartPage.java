package com.qpros.Pages;

import com.qpros.ElementsRepo.AddToCartPageObjects;
import com.qpros.ElementsRepo.HomePageObjects;
import com.qpros.ElementsRepo.ItemDetailsPageObjects;
import com.qpros.ElementsRepo.SignupPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends NavigationBase {

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }


//    public String get_item_name_text() {
//        return getTextFromIdentifier(AddToCartPageObjects.CARD_ITEM_NAME);
//    }

    public String getPurchase_confirmation() {
        waitUntilElementIsVisible(AddToCartPageObjects.PURCHASE_ORDER_CONFIRMATION);
        return  getTextFromIdentifier(AddToCartPageObjects.PURCHASE_ORDER_CONFIRMATION);
    }

    public void clickOnPurchase() {
        waitUntilElementIsVisible(AddToCartPageObjects.CARD_ITEM_NAME);
        clickButton(AddToCartPageObjects.PLACE_ORDER_BUTTON);
    }

    public void clickOnConfirmPurchase() {
        waitUntilElementIsVisible(AddToCartPageObjects.PURCHASE_ORDER_OK);
        clickButton(AddToCartPageObjects.PURCHASE_ORDER_OK);
    }

    public Boolean isConfirmationVisible() {
      waitUntilElementIsVisible(AddToCartPageObjects.PURCHASE_ORDER_CONFIRMATION);
        return driver.findElement(By.xpath(AddToCartPageObjects.PURCHASE_ORDER_CONFIRMATION)).isDisplayed();
    }

    public void removeFromChart() {
        clickButton(AddToCartPageObjects.REMOVE_ITEM_BUTTON);
    }

    public Boolean hasItemsInCart() throws InterruptedException {
       Thread.sleep(5000);
       return driver.findElements(By.xpath(AddToCartPageObjects.CARD_ITEM_NAME)).isEmpty();
    }
    public void purchaseItemFromCart(String username , String card_number) {
        waitUntilElementIsVisible(AddToCartPageObjects.PURCHASE_ORDER_FORM_TITTLE);
        InsertData(AddToCartPageObjects.PURCHASE_ORDER_USER_NAME_FIELD,username);
        InsertData(AddToCartPageObjects.PURCHASE_ORDER_CARD_NUMBER_FIELD,card_number);
        clickButton(AddToCartPageObjects.PURCHASE_ORDER_BUTTON);
    }




}
