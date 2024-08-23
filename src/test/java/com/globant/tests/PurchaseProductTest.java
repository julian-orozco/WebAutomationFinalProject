package com.globant.tests;

import com.globant.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchaseProductTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Parameters({"loginPage-title", "user", "password", "badge-1", "cartPage-title", "checkout-title", "firstName", "lastName", "postalCode", "checkout2-title", "checkoutComplete-title" })
    @Test
    public void CorrectPurchaseProduct(String loginTitle, String user, String password, String badge, String cartTitle, String checkoutTitle, String firstName, String lasName, String postalCode, String checkoout2Title, String checkoutCompleteTitle) {

        LoginPage loginPage = getLoginPage();

        softAssert.assertEquals(loginPage.getTitle(), loginTitle);

        loginPage.setUsernameTxt(user);
        loginPage.setPasswordTxt(password);

        HomePage homePage = loginPage.clickSubmitBtn();
        homePage.clickBackPackBtn();

        softAssert.assertEquals(homePage.getShoppingCartBadge(), badge);

        CartPage cartPage = homePage.clickCartBtn();

        softAssert.assertEquals(cartPage.getTitleText(), cartTitle);

        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();

        softAssert.assertEquals(checkoutPage.getTile(), checkoutTitle);

        checkoutPage.setFirstNameTxt(firstName);
        checkoutPage.setLastNameTxt(lasName);
        checkoutPage.setPostalCodeTxt(postalCode);

        CheckoutSecondPage checkoutSecondPage = checkoutPage.clickContinueBtn();

        softAssert.assertEquals(checkoutSecondPage.getTitleText(), checkoout2Title);

        CheckoutCompletePage checkoutCompletePage = checkoutSecondPage.clickFinishBtn();

        softAssert.assertEquals(checkoutCompletePage.getCompleteTitleText(), checkoutCompleteTitle);

        //checkoutCompletePage.clickBackBtn();

        softAssert.assertAll();
    }
}
