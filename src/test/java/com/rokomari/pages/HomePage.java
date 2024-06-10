package com.rokomari.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//button[normalize-space()='Google']")
    private WebElement googleSignInButton;

    @FindBy(xpath = "//button[normalize-space()='Facebook']")
    private WebElement FaceBookSignInButton;

    @FindBy(xpath = "//input[@placeholder='Email or phone']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement passwordNextButton;

    @FindBy(xpath = "//input[@placeholder='OTP']")
    private WebElement otpField;

    @FindBy(xpath = "//form[@id='otp-login-form']//button[@type='submit'][normalize-space()='Login']")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void signUpWithGoogle(String email, String otp) {
        // Click on the sign-in button
        click(signInButton);


        // Click on the Google sign-in button
        click(googleSignInButton);

        // Switch to the Google sign-in popup window
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Enter the email and click next
        type(emailField, email);
        click(nextButton);

        // Wait for the password field to be visible
        waitForVisibility(passwordField);

        // Enter the OTP (acting as a password in this example) and click next
        type(passwordField, otp);
        click(passwordNextButton);

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Enter OTP in the OTP field on the main site and click login
        type(otpField, otp);
        click(loginButton);
    }
    public void clickSignIn() {
        click(signInButton);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterOTP(String otp) {
        type(otpField, otp);
        click(loginButton);
    }
}
