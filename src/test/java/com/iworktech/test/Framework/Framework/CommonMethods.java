package com.iworktech.test.Framework.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public class CommonMethods {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    private Long DRIVER_WAIT = 30L;
    private static Logger log;


    public CommonMethods() {
        webDriver = SetBrowser.getWebDriver();
        webDriverWait =new WebDriverWait(webDriver,DRIVER_WAIT);
    }

    public void clickElement(By elementName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(elementName))).click();
    }

    public void clickElement(WebElement elementName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(elementName)).click();
    }

    public WebElement waitTillElementVisible(WebElement element)  {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean ifElementVisible(WebElement element)  {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public boolean areElementsPresent(By elements) {
        return webDriver.findElements(elements).size() > 0;
    }

    public void clickOnElementUsingJavaScript(By by) {
        WebElement element = webDriver.findElement(by);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);
    }

    public void clickOnElementUsingJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void hoverOnElement(By by) {
        Actions action = new Actions(webDriver);
        action.moveToElement(webDriver.findElement(by)).build().perform();
    }

    public void hoverOnElement(WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).build().perform();
    }

    public void scrollToView(WebElement element) {
        if (webDriver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        }
    }

    public String getURL(){
        return webDriver.getCurrentUrl();
    }




    //-------------------------------------------------------------------------------------------------------------------\

    // Need to check below elements

    public void selectValueFromDropDownByWebElement(WebElement ele, String text) {
        //LOG.info("Running : selectValueFromDropDownByWebElement");
        Select dropdown = new Select(ele);
        dropdown.selectByVisibleText(text);
    }

}
