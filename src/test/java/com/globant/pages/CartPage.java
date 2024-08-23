package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public String getTitleText(){
        this.isElementDisplayed(this.title);
        return this.title.getText();
    }

    public CheckoutPage clickCheckoutBtn(){
        this.isElementDisplayed(this.checkoutBtn);
        this.checkoutBtn.click();
        return new CheckoutPage(this.driver);
    }

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
