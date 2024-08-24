package com.globant.tests;

import com.globant.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RemoveElementsTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Parameters({"loginPage-title", "user", "password", "badge-3", "cartPage-title", "checkout-title", "firstName", "lastName", "postalCode", "checkout2-title", "checkoutComplete-title" })
    @Test
    public void CorrectRemoveProducts(String loginTitle, String user, String password, String badge3, String cartTitle, String checkoutTitle, String firstName, String lasName, String postalCode, String checkoout2Title, String checkoutCompleteTitle) {

        LoginPage loginPage = getLoginPage();

        softAssert.assertEquals(loginPage.getTitle(), loginTitle);

        loginPage.setUsernameTxt(user);
        loginPage.setPasswordTxt(password);

        HomePage homePage = loginPage.clickSubmitBtn();
        homePage.clickBackPackBtn();
        homePage.clickFleecetBtn();
        homePage.clickOnesieBtn();

        softAssert.assertEquals(homePage.getShoppingCartBadge(), badge3);

        CartPage cartPage = homePage.clickCartBtn();

        softAssert.assertEquals(cartPage.getTitleText(), cartTitle);

        cartPage.clickRemoveBackPackBtn();
        cartPage.clickRemoveFleeceBtn();
        cartPage.clickRemoveOneiseBtn();

        softAssert.assertEquals(cartPage.getShoppingCartBadge(),false);

        softAssert.assertAll();
    }
}
