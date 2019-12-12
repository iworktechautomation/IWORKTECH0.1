package com.iworktech.test.Framework.PageObjects;

import com.iworktech.test.Framework.Framework.CommonMethods;
import com.iworktech.test.Framework.Utils.RandomStringGenerators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class AdminKeywords extends CommonMethods {

    public AdminKeywords() {
        PageFactory.initElements(webDriver, this);
    }

    String randomKeyword;

    @FindBy(css = "a[ng-reflect-router-link*='add-keyword']")
    private WebElement textKeyWords;

    @FindBy(css = "div[class='home-header mt-2 col-md-6']")
    private WebElement elementKeyWord;

    @FindBy(css = "button[class='btn theme-btn float-right']")
    private WebElement buttonAddKeyWord;

    @FindBy(css = "input[name='Tabkeyword.keyword']")
    private WebElement textKeyWord;

    @FindBy(css = "input[id='file']")
    private WebElement selectImage;

    @FindBy(css = "button[class='btn theme-btn']")
    private WebElement buttonSaveKeyWord;

    @FindBy(css = "div[id='toast-container']")
    private WebElement messageRecordSave;

    public void createKeyWord() throws InterruptedException {

        Thread.sleep(5000);
        clickElement(textKeyWords);
        Thread.sleep(2000);
        if (getURL().contains("keyword") && ifElementVisible(elementKeyWord)) {
            clickElement(buttonAddKeyWord);
            randomKeyword = RandomStringGenerators.getRandomText(10);
            System.out.println("The randomly generated string is..."+randomKeyword);
            textKeyWord.sendKeys(randomKeyword);
            selectImage.sendKeys("D:\\Automation\\MELP\\MELP AUtomation\\src\\main\\resources\\Images\\fa18-1.png");
            clickElement(buttonSaveKeyWord);
        }
    }

    public boolean displaySuccessMessage() {
        return ifElementVisible(messageRecordSave);
    }

}
