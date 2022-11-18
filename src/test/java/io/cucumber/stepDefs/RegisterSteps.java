package io.cucumber.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.cucumber.pages.RegisterPage;
import org.junit.Assert;
import qa.factory.DriverFactory;

public class RegisterSteps {


    RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());

    Faker faker  = new Faker();
    String randomEmail = faker.internet().emailAddress();
    String randomPassword = faker.internet().password();

    //Register Test With Valid Input
    @When("user clicks on register link")
    public void user_clicks_on_register_link() {
        registerPage.userClickOnRegisterLink().click();
    }

    @And("user gives first name")
    public void user_gives_first_name() {
        registerPage.userGivesFirstName().sendKeys("testFirst");
    }
    @And("user gives last name")
    public void user_gives_last_name() {
        registerPage.userGivesLastName().sendKeys("testLast");
    }
    @And("user gives email")
    public void user_gives_email() {
        registerPage.userGivesEmail().sendKeys(randomEmail);
    }
    @And("user gives Password")
    public void user_gives_password() {
        registerPage.userGivesPassword().sendKeys(randomPassword);
    }
    @And("user gives confirm password")
    public void user_gives_confirm_password() {
        registerPage.userGivesConfirmPassword().sendKeys(randomPassword);
    }

    @And("user clicks on register button")
    public void user_clicks_on_register_button() {
        registerPage.userClicksOnRegisterButton().click();
    }
    @Then("user should get message your registration completed")
    public void user_should_get_message_your_registration_completed() {
        String text = registerPage.userGetRegistrationCompleted().getText();
        Assert.assertEquals(text, "Your registration completed");
    }
    @And("user clicks on continue button")
    public void user_clicks_on_continue_button() {
        registerPage.userHitsOnContinueButton().click();
    }
    @Then("user should be successfully registered")
    public void user_should_be_successfully_registered() {
       boolean bool = registerPage.userHasSuccessfulRegistered().isEnabled();
       Assert.assertTrue(bool);
    }


    //Register Test With Invalid Email Input
    @When("user gives invalid email format")
    public void user_gives_invalid_email_format() {
        registerPage.userGivesInvalidEmail().sendKeys("sdda@");
    }
    @Then("user should get massage Wrong email")
    public void user_should_get_massage_wrong_email() {
        String text =  registerPage.checkMassageWrongEmail().getText();
        Assert.assertEquals(text, "Wrong email");
    }


    //Register Test with Confirmation Of Password That dose Not Match
    @And("user gives a different confirm password")
    public void user_gives_a_different_confirm_password() {
        registerPage.userGivesDifferentConfirmPassword().sendKeys("sad221");
    }
    @Then("user should get a message The password and confirmation password do not match")
    public void user_should_get_a_message_the_password_and_confirmation_password_do_not_match() {

       String text= registerPage.checkPasswordDoNotMatch().getText();
       Assert.assertEquals(text, "The password and confirmation password do not match.");

    }


    // Register user with existing Email

    @When("user gives existing email")
    public void user_gives_existing_email() {
        registerPage.userGivesEmail().sendKeys("HusseinNour20@gmail.com");
    }
    @Then("user should get message The specified email already exists")
    public void user_should_get_message_the_specified_email_already_exists() {
        Assert.assertTrue(registerPage.checkErrorMessageEmailAlreadyExist().isDisplayed());
    }


}
