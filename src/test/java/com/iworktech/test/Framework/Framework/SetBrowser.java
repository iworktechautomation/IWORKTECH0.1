package com.iworktech.test.Framework.Framework;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class SetBrowser extends EventFiringWebDriver {



    private static String FILE_SEPARATOR = System.getProperty("file.separator");
    private static RemoteWebDriver webDriver = null;
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            if (webDriver != null) {
                webDriver.quit();
                webDriver = null;
            }
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SetBrowser(WebDriver driver) {
        super(driver);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }


    public static void selectBrowserDriver(String browserName){

        if(browserName.equals("Chrome")){
            setChromeDriverPath();
            initializeChromeDriver();
        }
        else if (browserName.equals("FireFox")) {
            setFireFoxDriverPath();
            initializeFireFoxDriver();
        }
    }

    private static void setChromeDriverPath(){
        System.setProperty("webdriver.chrome.driver",returnChromeDriverPath());
    }

    private static void setFireFoxDriverPath(){
        System.setProperty("webdriver.gecko.driver",returnFirefoxDriverPath());
    }

    private static String returnChromeDriverPath(){
        return "tools" + FILE_SEPARATOR + "chromedriver" + FILE_SEPARATOR + "chromedriver.exe";
    }

    private static String returnFirefoxDriverPath(){
        return "tools" + FILE_SEPARATOR + "geckodriver" + FILE_SEPARATOR +"win32"+FILE_SEPARATOR+ "geckodriver.exe";
    }

    private static void initializeChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
    }

    private static void initializeFireFoxDriver(){
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("incognito");
        options.addArguments("start-maximized");
        webDriver = new FirefoxDriver(options);
    }


    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }

}
