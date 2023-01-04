package org.LamiaQA.base;

import com.google.common.collect.Ordering;
import org.LamiaQA.pages.HomePage;
import org.LamiaQA.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestFilter extends CommonAPI{
    @Test
    public void filterFromLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.productsHeaderIsDisplayed()); //c'est déja une validation car c'est une insertion
        homePage.selectLowerToHigherFromFilter();
        //List<String> prices= homePage.getItemsPrice();
        //System.out.println(prices);
        //System.out.println(Ordering.<String> natural().isOrdered(prices));
        System.out.println("list of prices"+ homePage.getItemsPrice());
        double[] finalPrices = Utility.listToArrayOfDoubles(homePage.getItemsPrice());
        Assert.assertTrue(Utility.isSorted(finalPrices));
        System.out.println("items sorted success");

    }
}
