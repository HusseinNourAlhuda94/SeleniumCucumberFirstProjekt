package io.cucumber.stepDefs;

import io.cucumber.java.en.*;
import io.cucumber.pages.WishListPage;
import org.junit.Assert;
import qa.factory.DriverFactory;

public class WishListSteps {


        private WishListPage wishListPage = new WishListPage(DriverFactory.getDriver());
    @When("user moves to gift card in the bar menu")
    public void user_moves_to_gift_card_in_the_bar_menu() {
        wishListPage.clickOnGiftCardLink().click();
    }
    @When("user select a card")
    public void user_select_a_card() {
        wishListPage.selectACard().click();
    }
    @When("user should give Recipient's Name and email")
    public void user_should_give_recipient_s_name_and_email() {
        wishListPage.recipientName().sendKeys("Ahmad");
        wishListPage.recipientEmail().sendKeys("Ahmad@gmail.com");
    }
    @When("user click on button add to wishlist")
    public void user_click_on_button_add_to_wishlist() {
        wishListPage.clickOnAddWishButton().click();
    }
    @And("selected card is added to wishlist successfully")
    public void selected_card_is_added_to_wishlist_successfully() {
       boolean bool = wishListPage.checkAddedCardToWishList().isEnabled();
        Assert.assertTrue(bool);

    }

    @And("user moves to wishlist")
    public void user_moves_to_wishlist() {
        wishListPage.clickOnWishListLink().click();

    }
    @And("user select product to remove")
    public void user_select_product_to_remove() {
       wishListPage.selectAProductToRemove().click();
    }
    @And("user hit update wishlist button")
    public void user_hit_update_wishlist_button() {
        wishListPage.hitUpdateWishlistButton().click();
    }
    @Then("selected product should be removed")
    public void selected_product_should_be_removed() {
        boolean bool = wishListPage.checkRemovedProdukt().isEnabled();
        Assert.assertTrue(bool);
    }

}
