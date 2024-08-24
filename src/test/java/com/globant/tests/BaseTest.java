package com.globant.tests;

import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"url"})
    @BeforeTest
    public void before(String url) {
        WebDriverManager.chromedriver().setup(); // Automatically manage the ChromeDriver version
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @AfterTest
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }
}