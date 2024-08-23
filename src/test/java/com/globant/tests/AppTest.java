package com.globant.tests;

import com.globant.pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    @Test
    public void shouldAnswerWithTrue() {

        LoginPage loginPage = getLoginPage();
        softAssert.assertEquals(loginPage.getTitle(), "Swag Labs");
        loginPage.setUsernameTxt("standard_user");
        loginPage.setPasswordTxt("secret_sauce");

        HomePage homePage = loginPage.clickSubmitBtn();
        homePage.clickBackPackBtn();
        softAssert.assertEquals(homePage.getShoppingCartBadge(), "1");

        CartPage cartPage = homePage.clickCartBtn();
        softAssert.assertEquals(cartPage.getTitleText(), "Your Cart");

        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        softAssert.assertEquals(checkoutPage.getTile(), "Checkout: Your Information");
        checkoutPage.setFirstNameTxt("Pepito");
        checkoutPage.setLastNameTxt("Gonzalez");
        checkoutPage.setPostalCodeTxt("00000");

        CheckoutSecondPage checkoutSecondPage = checkoutPage.clickContinueBtn();
        softAssert.assertEquals(checkoutSecondPage.getTitleText(), "Checkout: Overview");

        CheckoutCompletePage checkoutCompletePage = checkoutSecondPage.clickFinishBtn();
        softAssert.assertEquals(checkoutCompletePage.getCompleteTitleText(),"Thank you for your order!");
        checkoutCompletePage.clickBackBtn();
        softAssert.assertAll();
    }
}