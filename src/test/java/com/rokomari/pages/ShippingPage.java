package com.rokomari.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage {

    private By shippingPageButton = By.xpath("//button[contains(text(),'Proceed to Shipping')]");
    private By nameField = By.id("name");
    private By addressField = By.id("address");
    private By phoneField = By.id("phone");

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void goToShippingPage() {
        driver.findElement(shippingPageButton).click();
    }

    public void fillShippingDetails(String name, String address, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneField).sendKeys(phone);
    }
}
