package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSecondPage extends BasePage{

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement title;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public String getTitleText(){
        this.isElementDisplayed(this.title);
        return this.title.getText();
    }

    public CheckoutCompletePage clickFinishBtn(){
        this.isElementDisplayed(this.finishBtn);
        this.finishBtn.click();
        return new CheckoutCompletePage(this.driver);
    }

    public CheckoutSecondPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
