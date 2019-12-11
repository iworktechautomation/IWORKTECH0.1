package com.iworktech.test.Framework.stepdefs;

import com.iworktech.test.Framework.Framework.BuilderURL;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class testMe {

    BuilderURL builderURL;

    public testMe(BuilderURL builderURL) throws IOException {
    this.builderURL = builderURL;
    }

    @When("^user is on the site$")
    public void user_is_on_the_site() throws Throwable {
        BuilderURL.openURL();
    }

    @Then("^the added product \"([^\"]*)\" should be successfully getting added into the basket$")
    public void the_added_product_should_be_successfully_getting_added_into_the_basket(String arg1) throws Throwable {
        Assert.assertEquals(5/0,58);
    }
}
