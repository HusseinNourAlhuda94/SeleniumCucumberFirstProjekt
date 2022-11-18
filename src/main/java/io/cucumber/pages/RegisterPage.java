package io.cucumber.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    WebDriver driver;

    Faker faker  = new Faker();
    String randomEmail = faker.internet().emailAddress();
    String randomPassword = faker.internet().password();

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }


    //Register Test With Valid Input
    public WebElement userClickOnRegisterLink()
    {
        return driver.findElement(By.linkText("Register"));
    }

    public WebElement userGivesFirstName()
    {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement userGivesLastName()
    {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement userGivesEmail()
    {
        return driver.findElement(By.id("Email"));
    }

    public WebElement userGivesPassword()
    {
        return driver.findElement(By.id("Password"));
    }

    public WebElement userGivesConfirmPassword()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement userClicksOnRegisterButton()
    {
        return driver.findElement(By.id("register-button"));
    }

    public WebElement userGetRegistrationCompleted()
    {
        return driver.findElement(By.xpath("//div[@class='result']"));
    }


    public WebElement userHitsOnContinueButton()
    {
        return driver.findElement(By.xpath("//input[@type=\"button\"][@value=\"Continue\"]"));
    }

    public WebElement userHasSuccessfulRegistered()
    {
        return driver.findElement(By.linkText("Log out"));
    }



    //Register Test With Invalid Email Input
    public WebElement userGivesInvalidEmail()
    {
        return driver.findElement(By.id("Email"));
    }

    public WebElement checkMassageWrongEmail()
    {
        return driver.findElement(By.xpath("//span[contains(text(),'Wrong email')]"));
    }


    //Register Test with Confirmation Of Password That dose Not Match

    public WebElement userGivesDifferentConfirmPassword()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement checkPasswordDoNotMatch()
    {
        return driver.findElement(By.xpath("//span[contains(text(),'The password and confirmation password do not match.')]"));
    }

    // Register Test With Existing Email

    public WebElement checkErrorMessageEmailAlreadyExist(){
        return driver.findElement(By.xpath("//li[contains(text(), 'The specified email already exists')]"));
    }

}
