package com.globant.tests;

import com.globant.pages.CartPage;
import com.globant.pages.HomePage;
import com.globant.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    @Parameters({"loginPage-title", "user", "password"})
    @Test
    public void CorrectLogout(String loginTitle, String user, String password) {

        LoginPage loginPage = getLoginPage();

        softAssert.assertEquals(loginPage.getTitle(), loginTitle);

        loginPage.setUsernameTxt(user);
        loginPage.setPasswordTxt(password);

        HomePage homePage = loginPage.clickSubmitBtn();

        homePage.clickBurgerMenuBtn();
        LoginPage loginPage1 = homePage.clicklogoutBtn();

        softAssert.assertEquals(loginPage1.getTitle(), loginTitle);

        softAssert.assertAll();
    }
}
