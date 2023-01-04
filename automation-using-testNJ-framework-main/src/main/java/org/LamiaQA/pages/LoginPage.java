package org.LamiaQA.pages;

import org.LamiaQA.base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends CommonAPI {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //objects
    @FindBy(css = "#user-name")
    WebElement usernameField;
    @FindBy(css ="#password" )
    WebElement passwordField;
    @FindBy(css ="#login-button" )
    WebElement loginBtn;
    @FindBy(css =".error-message-container.error" )
    WebElement errorMessage;

    //reusable steps //(relative à des actions)

    public boolean usernameFieldIsDisplayed(){
        return  isDisplayed(usernameField);
    }
    public boolean passwordFieldIsDisplayed(){
        return isDisplayed(passwordField);
    }
    public boolean loginBtnIsDisplayed(){
        return isDisplayed(loginBtn);
    }

    public void typeUsername(String username){
        type(usernameField, username);
    }
    public void typePassword( String password){
        type(passwordField, password);
    }
    public void clickOnLoginButton(){
        clickOn(loginBtn);
    }
    public String getErrorMessage(){
        return getWebElementText(errorMessage);
    }
    public void login(String username, String password){
        typeUsername(username);
        typePassword(password);
        clickOnLoginButton();
        System.out.println("login process success");
    }
}
