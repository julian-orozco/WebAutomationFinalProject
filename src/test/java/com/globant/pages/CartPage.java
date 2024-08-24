package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackPackBtn;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    private WebElement removeFleeceBtn;

    @FindBy(id = "remove-sauce-labs-onesie")
    private WebElement removeOneiseBtn;

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

    public void clickRemoveBackPackBtn(){
        this.isElementDisplayed(this.removeBackPackBtn);
        this.removeBackPackBtn.click();
    }

    public void clickRemoveFleeceBtn(){
        this.isElementDisplayed(this.removeFleeceBtn);
        this.removeFleeceBtn.click();
    }

    public void clickRemoveOneiseBtn(){
        this.isElementDisplayed(this.removeOneiseBtn);
        this.removeOneiseBtn.click();
    }

    public boolean getShoppingCartBadge() {
        return !this.driver.findElements(By.xpath("//span[@class=\"shopping_cart_badge\"]")).isEmpty();
    }

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
