package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WishListPage {

    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickOnGiftCardLink()
    {
      return driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[7]/a[1]"));
    }

    public WebElement selectACard()
    {
        return driver.findElement(By.xpath("//a[contains(text(),'$25 Virtual Gift Card')]"));
    }

    public WebElement recipientName()
    {
        return driver.findElement(By.id("giftcard_2_RecipientName"));
    }

    public WebElement recipientEmail()
    {
        return driver.findElement(By.id("giftcard_2_RecipientEmail"));
    }

    public WebElement clickOnAddWishButton()
    {
        return driver.findElement(By.id("add-to-wishlist-button-2"));
    }

    public WebElement checkAddedCardToWishList()
    {
        return driver.findElement(By.id("bar-notification"));
    }


    public WebElement clickOnWishListLink()
    {
        return driver.findElement(By.linkText("Wishlist"));
    }


    public WebElement selectAProductToRemove()
    {
        return driver.findElement(By.xpath("//input[@type=\"checkbox\"][@name=\"removefromcart\"]"));
    }

    public WebElement hitUpdateWishlistButton()
    {
        return driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Update wishlist\"]"));
    }


    public WebElement checkRemovedProdukt()
    {
        return driver.findElement(By.xpath("//div[contains(text(),'The wishlist is empty!')]"));
    }


}
