package com.iworktech.test.Framework.stepdefs;

import com.iworktech.test.Framework.Framework.BuilderURL;
import com.iworktech.test.Framework.POJOModels.InstituteInformation;
import com.iworktech.test.Framework.PageObjects.UserRegistration;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;

import java.util.List;

public class memberRegistrationStepDef {

    private UserRegistration userRegistration;
    private BuilderURL builderURL;

    public memberRegistrationStepDef(UserRegistration userRegistration, BuilderURL builderURL){
        this.userRegistration = userRegistration;
        this.builderURL = builderURL;
    }

    @When("^user enters basic information$")
    public void user_enters_basic_information(List<InstituteInformation>institute) throws Throwable {
        userRegistration.enterBasicInstitutionDetails(institute);
    }

    @When("^clicks save button$")
    public void clicks_save_button() throws Throwable {

    }

    @Then("^the Institutional Expertise page should open$")
    public void the_Institutional_Expertise_page_should_open() throws Throwable {
        //Assert.assertEquals();

    }


    @Given("^The user is on the selfRidges Homepage$")
    public void the_user_is_on_the_selfRidges_Homepage() throws Throwable {

    }

    @When("^I fill user details with the below data$")
    public void i_fill_user_details_with_the_below_data(DataTable arg1) throws Throwable {

    }

    @When("^I click on Continue to delivery button$")
    public void i_click_on_Continue_to_delivery_button() throws Throwable {

    }

    @When("^I click on Delivery Radio Button$")
    public void i_click_on_Delivery_Radio_Button() throws Throwable {

    }

    @Then("^I should see the delivery details pre-populated with the user information entered on the your personal details section$")
    public void i_should_see_the_delivery_details_pre_populated_with_the_user_information_entered_on_the_your_personal_details_section() throws Throwable {

    }

    @After
    public void pleaserun(){
    }

}
