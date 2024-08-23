package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage{

    @FindBy(xpath = "//h2[@class=\"complete-header\"]")
    private WebElement completeTitle;

    @FindBy(name = "back-to-products")
    private WebElement backBtn;

    public String getCompleteTitleText(){
        this.isElementDisplayed(this.completeTitle);
        return this.completeTitle.getText();
    }

    public void clickBackBtn(){
        this.isElementDisplayed(this.backBtn);
        this.backBtn.click();
    }

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
