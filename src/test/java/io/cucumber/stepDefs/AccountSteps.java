package io.cucumber.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.pages.AccountPage;
import io.cucumber.pages.LogInPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import qa.factory.DriverFactory;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class AccountSteps {

    private LogInPage logInPage = new LogInPage(DriverFactory.getDriver());
    private AccountPage accountPage;
    @Given("User has already logged in to Application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {

        List<Map<String, String>> list =dataTable.asMaps();
        String email =list.get(0).get("email");
        String password =list.get(0).get("password");
        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/login");
        accountPage = logInPage.doLogin(email,password);

    }
    @Given("user is on account page")
    public void  user_is_on_account_page() {
        boolean bool =accountPage.checkUserOnAccountPage();
        Assert.assertTrue(bool);
    }
    @When("user hits the Log out button")
    public void user_hits_the_log_out_button() {
        accountPage.doLogOut().click();
    }
    @Then("user should be logged out")
    public void user_should_be_logged_out() {
      accountPage = logInPage.hasAlreadyLoggedOut();
    }


    @When("user enters an email address in the Subscribe field")
    public void user_enters_an_email_address_in_the_subscribe_field() {

        accountPage.enterEmailInSubscribeField().sendKeys("test@test.test");
    }
    @When("user hits the Subscribe button for newsletters")
    public void user_hits_the_subscribe_button_for_newsletters() {
        accountPage.hitSubscribeButton().click();
    }
    @Then("user should be subscribed and get message Thank you for signing up!")
    public void user_should_be_subscribed_and_get_message_thank_you_for_signing_up() {
        boolean bool =accountPage.checkSubscribeMessage().isDisplayed();
        Assert.assertTrue(bool);
    }


    @Given("{string} is visible")
    public void is_visible(String string) {
        List<WebElement> myMenuBarList = accountPage.getMenuBar();
        for (WebElement s : myMenuBarList)
        {
            String text =s.getText();
            if(text.equals(string)){
                System.out.println(text + " is available");
                break;
            }
        }
    }

}
