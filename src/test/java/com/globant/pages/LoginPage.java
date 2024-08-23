package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(className = "login_logo")
    private WebElement title;

    @FindBy(id = "user-name")
    private WebElement usernameTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(name = "login-button")
    private WebElement submitBtn;

    public String getTitle(){
        return this.title.getText();
    }

    public void setUsernameTxt(String username) {
        this.usernameTxt.sendKeys(username);
    }

    public void setPasswordTxt(String password) {
        this.passwordTxt.sendKeys(password);
    }

    public HomePage clickSubmitBtn() {
        this.submitBtn.click();
        return new HomePage(this.driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}