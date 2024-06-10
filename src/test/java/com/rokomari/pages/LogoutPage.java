package com.rokomari.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {

    private By accountDropdown = By.cssSelector("selector-for-account-dropdown");
    private By logoutButton = By.cssSelector("selector-for-logout-button");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        driver.findElement(accountDropdown).click();
        driver.findElement(logoutButton).click();
    }
}
