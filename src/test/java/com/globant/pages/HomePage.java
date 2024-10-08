package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backPackAddToCartBtn;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement onesieAddToCartBtn;

    @FindBy(name = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement fleeceAddToCartBtn;

    @FindBy(xpath= "//a[@class=\"shopping_cart_link\"]")
    private WebElement shoopingCartBtn;

    @FindBy(xpath = "//span[@class=\"shopping_cart_badge\"]")
    private WebElement shoopingCartBadge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutBtn;

    public void clickBackPackBtn() {
        this.isElementDisplayed(this.backPackAddToCartBtn);
        this.backPackAddToCartBtn.click();
    }

    public void clickOnesieBtn() {
        this.isElementDisplayed(this.onesieAddToCartBtn);
        this.onesieAddToCartBtn.click();
    }

    public void clickFleecetBtn() {
        this.isElementDisplayed(this.fleeceAddToCartBtn);
        this.fleeceAddToCartBtn.click();
    }

    public CartPage clickCartBtn() {
        this.isElementDisplayed(this.shoopingCartBtn);
        this.shoopingCartBtn.click();
        return new CartPage(this.driver);
    }

    public String getShoppingCartBadge() {
        this.isElementDisplayed(this.shoopingCartBadge);
        return this.shoopingCartBadge.getText();
    }

    public void clickBurgerMenuBtn(){
        this.isElementDisplayed(this.burgerMenuBtn);
        this.burgerMenuBtn.click();
    }

    public LoginPage clicklogoutBtn(){
        this.isElementDisplayed(this.logoutBtn);
        this.logoutBtn.click();
        return new LoginPage(this.driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}