package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(id = "first-name")
    private WebElement firstNameTxt;

    @FindBy(id = "last-name")
    private WebElement lastNameTxt;

    @FindBy(id = "postal-code")
    private WebElement postalCodeTxt;

    @FindBy(name = "continue")
    private WebElement continueBtn;

    public String getTile(){
        this.isElementDisplayed(this.title);
        return  this.title.getText();
    }

    public void setFirstNameTxt(String firstName){
        this.isElementDisplayed(this.firstNameTxt);
        this.firstNameTxt.sendKeys(firstName);
    }

    public void setLastNameTxt(String lastName){
        this.isElementDisplayed(this.lastNameTxt);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void setPostalCodeTxt(String postalCode){
        this.isElementDisplayed(this.postalCodeTxt);
        this.postalCodeTxt.sendKeys(postalCode);
    }

    public CheckoutSecondPage clickContinueBtn(){
        this.isElementDisplayed(this.continueBtn);
        this.continueBtn.click();
        return new CheckoutSecondPage(this.driver);
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
