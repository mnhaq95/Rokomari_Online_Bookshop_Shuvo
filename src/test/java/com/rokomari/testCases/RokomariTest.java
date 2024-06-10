package com.rokomari.testCases;

import com.rokomari.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RokomariTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        // Set the path to your WebDriver executable
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rokomari.com/book");
        homePage = new HomePage(driver);
    }



    @Test
    public void testSignUpWithGoogle() {
        homePage.signUpWithGoogle("braunlara20@gmail.com", "1665");
        // Add further assertions and steps for the test
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
