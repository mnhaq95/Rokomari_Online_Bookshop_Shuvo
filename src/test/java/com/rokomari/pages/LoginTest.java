package com.rokomari.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rokomari.com/book");

        homePage = new HomePage(driver);
    }

    @Test
    @Feature("Login")
    @Description("Test to verify login with OTP")
    public void testLoginWithOTP() {
        homePage.clickSignIn();
        homePage.enterEmail("braunlara20@gmail.com");
        //homePage.clickNextButton(); // Click the Next button after entering the email
        driver.findElement(By.xpath("//button[@id='js--btn-next']")).click();
        // Add a sleep to wait for OTP generation (this is not a good practice, use a better wait mechanism in real scenarios)
        try {
            Thread.sleep(10000); // Wait for OTP
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.enterOTP("1665"); // The OTP would be fetched dynamically in a real test
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}