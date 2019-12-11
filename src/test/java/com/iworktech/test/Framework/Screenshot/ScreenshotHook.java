package com.iworktech.test.Framework.Screenshot;

import com.iworktech.test.Framework.Framework.SetBrowser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ScreenshotHook {

    WebDriver driver = SetBrowser.getWebDriver();
    private static final Logger LOG = LoggerFactory.getLogger(ScreenshotHook.class);

    //Not Execute for any api tests
    @After
    public void embedScreenshot(Scenario scenario) {
        System.out.println("ScreenshotHook YASH");
        List<String> tags = (List<String>) scenario.getSourceTagNames();
        //Do not continue if it is irrelevant to webdriver
        for (String tag : tags) {
            if (tag.toLowerCase().contains("api")) {
                return;
            }
        }

        //WebDriver after method handler
        try {
            Map<String, Object> screenShots = ScreenshotHelper.getScreenShotsForCurrentTest();
            for (Map.Entry<String, Object> screenShot : screenShots.entrySet()) {
                scenario.write(screenShot.getKey());
                scenario.embed((byte[]) screenShot.getValue(), "image/png");
            }

            ScreenshotHelper.tidyUpAfterTestRun();

            if (scenario.isFailed()) {
                scenario.write(driver.getCurrentUrl());
                scenario.write(Instant.now().toString());
                byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            }

        } catch (WebDriverException | ClassCastException wde) {
            LOG.error(wde.getMessage());
        } finally {
            /** TODO: Needs a workaround to close mobile scripts when ran on emulator but should not close when ran on Motel **/
            if (tags.contains("@desktop") || tags.contains("@mobile-desktop")) {
                driver.quit();
                driver = null;
            }
        }
    }
}
