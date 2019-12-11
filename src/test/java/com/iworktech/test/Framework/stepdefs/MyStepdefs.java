package com.iworktech.test.Framework.stepdefs;

import com.iworktech.test.Framework.Framework.BuilderURL;
import com.iworktech.test.Framework.Framework.SetBrowser;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;



public class MyStepdefs {


    @And("^sdsd$")
    public void sdsd() {

    }

    @When("^user is on the site sdsdsd$")
    public void user_is_on_the_site_sdsdsd() throws Throwable {
       BuilderURL.openURL();
    }

/*    @After
    public void closeAll(){
        System.out.println("yash is here");
        SetBrowser.tearDown();
    }*/
}
