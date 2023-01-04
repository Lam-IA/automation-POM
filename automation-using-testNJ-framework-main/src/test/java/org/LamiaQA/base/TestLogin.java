package org.LamiaQA.base;

import org.LamiaQA.pages.HomePage;
import org.LamiaQA.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends CommonAPI{

    @Test
    public void loginWithValidCredentials () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");

        //enter username
        loginPage.typeUsername("standard_user");
        System.out.println("enter username success");
        //enter password
        loginPage.typePassword("secret_sauce");
        System.out.println("enter password success");

        //click login button
        loginPage.clickOnLoginButton();
        System.out.println("login button click success");
        boolean productHeaderIsDisplayed = homePage.productsHeaderIsDisplayed();
        Assert.assertTrue(productHeaderIsDisplayed);
        System.out.println("Products header is displayed success");
    }
    @Test
    // negative test
    public void LoginAttemptWithoutUsername () {
        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");

        //enter username

        loginPage.typeUsername("");

        //enter password
        loginPage.typePassword("secret_sauce");
        System.out.println("enter password is success");

        //click login button
        loginPage.clickOnLoginButton();
        System.out.println("login button click success");
        String textError = loginPage.getErrorMessage();
        System.out.println("error message"+textError);
        Assert.assertEquals("Epic sadface: Username is required",textError);
        System.out.println("error message validation success");
    }
    @Test
    public void LoginAttemptWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = "Swag Labs";
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");

        //enter username
        loginPage.typeUsername("standard_user");
        System.out.println("enter username success");

        //enter password
        loginPage.typePassword("");
        //waitFor(3);

        //click login button
        loginPage.clickOnLoginButton();
        System.out.println("login button click success");
        String textError = loginPage.getErrorMessage();
        System.out.println("error message:"+textError);
        Assert.assertEquals("Epic sadface: Password is required",textError);
        System.out.println("error message validation success");
    }
}
