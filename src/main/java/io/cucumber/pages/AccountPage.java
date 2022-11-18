package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage {

    WebDriver driver;


    public AccountPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getAccountPageTitle()
    {
        return driver.getTitle();
    }

    public WebElement doLogOut()
    {
        return driver.findElement(By.linkText("Log out"));
    }

    public boolean checkUserOnAccountPage(){
        return driver.findElement(By.linkText("Log out")).isDisplayed();
    }


    public WebElement enterEmailInSubscribeField()
    {
        return driver.findElement(By.id("newsletter-email"));
    }

    public WebElement hitSubscribeButton()
    {
        return driver.findElement(By.id("newsletter-subscribe-button"));
    }

    public WebElement checkSubscribeMessage()
    {
        return driver.findElement(By.id("newsletter-result-block"));
    }


    public List<WebElement> getMenuBar()
    {
        List<WebElement> navBar=driver.findElements(By.cssSelector(".top-menu >li"));
        return navBar;
    }

    public WebElement getProductName()
    {
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement getSearchButton()
    {
        return driver.findElement(By.xpath(" //input[@type= \"submit\"][@value=\"Search\"]"));
    }

    public WebElement getSelectedProduct()
    {
        return driver.findElement(By.linkText( "14.1-inch Laptop"));
    }

    public WebElement getAddToCart()
    {
        return driver.findElement(By.id("add-to-cart-button-31"));
    }

    public WebElement getMassageAddedToCart()
    {
        return driver.findElement(By.xpath("//a[contains(text() , 'shopping cart')]"));
    }
}
