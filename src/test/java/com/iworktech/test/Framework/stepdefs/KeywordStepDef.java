package com.iworktech.test.Framework.stepdefs;

import com.iworktech.test.Framework.Framework.BuilderURL;
import com.iworktech.test.Framework.PageObjects.AdminKeywords;
import com.iworktech.test.Framework.PageObjects.AdminLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class KeywordStepDef {
    private AdminLoginPage adminLoginPage;
    private AdminKeywords adminKeywords;

    public KeywordStepDef(AdminLoginPage adminLoginPage, AdminKeywords adminKeywords) {
        this.adminLoginPage = adminLoginPage;
        this.adminKeywords = adminKeywords;
    }

    @Given("^user is on the MELP admin page$")
    public void user_is_on_the_MELP_admin_page() throws IOException {
        BuilderURL.openURL();
    }

    @When("^user loggs in into the admin portal using Email Id \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void user_loggs_in_into_the_admin_portal_using_Email_Id_and_Password(String email, String password) throws Throwable {
        adminLoginPage.login(email, password);
    }

    @When("^proceeds to create the keyword$")
    public void proceeds_to_create_the_keyword() throws InterruptedException {
        adminKeywords.createKeyWord();
    }

    @Then("^record should be successfully created$")
    public void record_should_be_successfully_created() {
        Assert.assertTrue(adminKeywords.displaySuccessMessage());
    }
}

