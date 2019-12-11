package com.iworktech.test.Framework.PageObjects;

import com.iworktech.test.Framework.Framework.CommonMethods;
import com.iworktech.test.Framework.POJOModels.InstituteInformation;
import cucumber.api.java.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserRegistration extends CommonMethods {

    public UserRegistration(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "input[name='institutionName']")
    private WebElement nameOfIstitution;

    @FindBy(css = "input[name='country']")
    private WebElement country;

    @FindBy(css="input[name='postalAddress']")
    private WebElement postalAddress;

    @FindBy(css="input[name='City']")
    private WebElement city;

    @FindBy(css="input[name='ZipCode']")
    private WebElement zipCode;

    @FindBy(css="input[name='CountryCode']")
    private WebElement countryCode;

    @FindBy(css="input[name='officialPhoneNumber']")
    private WebElement officialPhoneNumber;

    @FindBy(css="input[name='stakeholderType']")
    private WebElement stakeholderType;

    @FindBy(css="img[src*='website']")
    private WebElement loginWebsite;

    @FindBy(css="a[class='btn theme-btn text-white pull-right'] b[_ngcontent-c2]")
    private List<WebElement>buttonSave;

    public void enterBasicInstitutionDetails(List<InstituteInformation>informations) throws InterruptedException {
        for (InstituteInformation information:informations){
            nameOfIstitution.sendKeys(information.getInstitutionName());
        }
    }

    public void clickSave(){
        buttonSave.get(0).click();
    }

    @After
    public void checkIfThisRuns(){
        System.out.println("Please run re baba");
        webDriver.quit();
        webDriver=null;
    }
}
