package com.globant.tests;

import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup(); // Automatically manage the ChromeDriver version
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterTest
    public void after() {
        if (driver != null) {
            //driver.quit();
        }
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }
}