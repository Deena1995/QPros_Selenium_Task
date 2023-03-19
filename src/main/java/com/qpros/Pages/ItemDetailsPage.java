package com.qpros.Pages;

import com.qpros.ElementsRepo.HomePageObjects;
import com.qpros.ElementsRepo.ItemDetailsPageObjects;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends NavigationBase {

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }


    public String get_item_name_text() {
        return getTextFromIdentifier(ItemDetailsPageObjects.ITEM_NAME);
    }

    public void clickOnAddToCart() {
        clickButton(ItemDetailsPageObjects.ADD_TO_CART_BUTTON);
    }

    public AddToCartPage navigate_cart() {
        clickButton(HomePageObjects.CART_BUTTON);
        return new AddToCartPage(driver);
    }


}
