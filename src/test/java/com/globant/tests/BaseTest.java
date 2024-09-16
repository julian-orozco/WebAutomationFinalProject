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
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Añadir las opciones necesarias para entorno CI
        options.addArguments("start-maximized");
        options.addArguments("--headless"); // Ejecutar Chrome en modo headless
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");

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