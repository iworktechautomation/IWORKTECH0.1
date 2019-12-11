package com.iworktech.test.Framework.PageObjects;

import com.iworktech.test.Framework.Framework.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage extends CommonMethods {

    public AdminLoginPage(){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(css = "input[name='emailid']")
    private WebElement emailID;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(css = "button[class='btn btn-login theme-btn']")
    private WebElement buttonSignIn;

    public void login(String email, String passwordDetails){
        waitTillElementVisible(emailID).sendKeys(email);
        waitTillElementVisible(password).sendKeys(passwordDetails);
        waitTillElementVisible(buttonSignIn).click();
    }

}
