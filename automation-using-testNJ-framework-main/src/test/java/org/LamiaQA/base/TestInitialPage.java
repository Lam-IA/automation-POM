package org.LamiaQA.base;
import org.LamiaQA.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInitialPage extends CommonAPI{

    @Test
    public void validateLandingPage () {
        String expected = "Swag Labs";
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
    }
    @Test
    public void validateLoginPageElements () {
        LoginPage loginPage = new LoginPage(driver);
        String expected = "Swag Labs";
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("page title validation success");
        //username
        boolean userNameIsDisplayed= loginPage.usernameFieldIsDisplayed();
        Assert.assertTrue(userNameIsDisplayed);
        System.out.println("username field is displayed");
        //password
        boolean passwordIsDisplayed=loginPage.passwordFieldIsDisplayed();
        Assert.assertTrue(passwordIsDisplayed);
        System.out.println("password field is displayed");
        //login button
        boolean loginButtonISDisplayed=loginPage.loginBtnIsDisplayed();
        Assert.assertTrue(loginButtonISDisplayed);
        System.out.println("login button is displayed");
    }
}
