package org.LamiaQA.pages;

import org.LamiaQA.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {
   public HomePage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }
    @FindBy(css =".title")
    WebElement productsHeader; //locator
    @FindBy(css = ".product_sort_container")
    WebElement filterDropdown;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> itemsPrice;

    public boolean productsHeaderIsDisplayed(){
        System.out.println("products header is displayed");
        return isDisplayed(productsHeader);
    }
    public void selectLowerToHigherFromFilter(){ //cette méthode n'est pas général elle est pour trier les prix  en mode croissant
        selectFromDropdown(filterDropdown, "Price (low to high)");
        System.out.println("price low to high select success");
    }
    public void selectFromFilter(String option){ //on peut donner l'option qu'on veut
        selectFromDropdown(filterDropdown, option);
        System.out.println(option + "select success");
    }
    public List<String> getItemsPrice() {
        List<String> prices = new ArrayList<String>();
        for (WebElement itemPrice : itemsPrice) {
            prices.add(itemPrice.getText().replace("$", ""));
        }
        return prices;
    }
}
//pom est un concept incontournable