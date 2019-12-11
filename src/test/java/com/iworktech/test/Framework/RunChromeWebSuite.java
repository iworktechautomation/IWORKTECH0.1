package com.iworktech.test.Framework;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources", tags = {"@failed"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/",
        "json:target/cucumber-report/cucumber.json",
        "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html"
        },
        glue = "com.iworktech.test.Framework")
public class RunChromeWebSuite extends AbstractTestNGCucumberTests {
}