package io.cucumber.stepDefs;

import io.cucumber.java.en.*;
import io.cucumber.pages.LogInPage;
import org.junit.Assert;
import qa.factory.DriverFactory;

public class LogInSteps {

    private LogInPage logInPage = new LogInPage(DriverFactory.getDriver());

    @Given("user navigate to chrome browser running")
    public void user_navigate_to_chrome_browser_running() {
        DriverFactory.getDriver().get("https://demowebshop.tricentis.com");
        String s = logInPage.getLoginPageTitle();
        System.out.println(s);

    }
    @When("user hit on login link")
    public void user_hit_on_login_link() {
       logInPage.hitLoginLink().click();
    }
    @When("user enters email as {string}")
    public void user_enters_email_as(String email) {
        logInPage.enterEmail().sendKeys(email);
    }
    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        logInPage.enterPassword().sendKeys(password);
    }
    @When("user click on log in button")
    public void user_click_on_log_in_button() {
        logInPage.clickOnLogin().click();
    }
    @Then("login should be successful")
    public void login_should_be_successful() {
        logInPage.checkLogin();
    }

    @Then("login should be unsuccessful")
    public void login_should_be_unsuccessful() {
        boolean bool= logInPage.checkUnsuccessfulLogin().isDisplayed();
        Assert.assertTrue(bool);
    }


}