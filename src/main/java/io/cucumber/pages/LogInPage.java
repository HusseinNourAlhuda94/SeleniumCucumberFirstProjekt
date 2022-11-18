package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }


// 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public WebElement enterEmail() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement enterPassword() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement clickOnLogin() {
       return driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Log in\"]"));
    }

    public WebElement hitLoginLink() {
        return driver.findElement(By.linkText("Log in"));
    }

    public boolean checkLogin() {
        return true;
    }

    public AccountPage doLogin(String email, String password)
    {
        this.enterEmail().sendKeys(email);
        this.enterPassword().sendKeys(password);
        this.clickOnLogin().click();
        return new AccountPage(driver);
    }


    public WebElement checkUnsuccessfulLogin()
    {
        return driver.findElement(By.xpath("//li[contains(text(), 'No customer account found')]"));
    }

    public AccountPage hasAlreadyLoggedOut()
    {
        driver.findElement(By.linkText("Log in")).isDisplayed();
        return new AccountPage(driver);
    }


}
