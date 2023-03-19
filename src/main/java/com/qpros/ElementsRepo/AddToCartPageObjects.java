package com.qpros.ElementsRepo;

public class AddToCartPageObjects {
    public static final String PLACE_ORDER_BUTTON = ".//button[contains(text(),'Place Order')]";
    public static final String REMOVE_ITEM_BUTTON = ".//a[contains(text(),'Delete')]";
    public static final String CARD_ITEM_NAME = "//*[@id='tbodyid']/tr/td[2]";
    public static final String PURCHASE_ORDER_USER_NAME_FIELD = "//input[@id='name']";
    public static final String PURCHASE_ORDER_CARD_NUMBER_FIELD = "//input[@id='card']";
    public static final String PURCHASE_ORDER_FORM_TITTLE = "//h5[@id='orderModalLabel']";
    public static final String PURCHASE_ORDER_BUTTON = ".//button[contains(text(),'Purchase')]";
    public static final String PURCHASE_ORDER_CONFIRMATION = "//div[@class='sweet-alert  showSweetAlert visible']/h2";
    public static final String PURCHASE_ORDER_OK = ".//button[contains(text(),'OK')]";
}
