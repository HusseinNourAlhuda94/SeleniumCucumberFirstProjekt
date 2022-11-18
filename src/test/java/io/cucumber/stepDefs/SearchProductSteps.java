package io.cucumber.stepDefs;

import io.cucumber.java.en.*;
import io.cucumber.pages.AccountPage;
import io.cucumber.pages.AddProductsToCartPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import qa.factory.DriverFactory;

import java.util.List;

public class SearchProductSteps {


    AccountPage accountPage = new AccountPage(DriverFactory.getDriver());
    AddProductsToCartPage addProductsToCartPage = new AddProductsToCartPage(DriverFactory.getDriver());
    @When("user give product name in search field")
    public void user_give_product_name_in_search_field() {
        accountPage.getProductName().sendKeys("14.1-inch Laptop");
    }
    @And("user hits search button")
    public void user_hits_search_button() {
        accountPage.getSearchButton().click();
    }
    @And("user select the product")
    public void user_select_the_product() {
        accountPage.getSelectedProduct().click();
    }
    @And("user add the product to the cart")
    public void user_add_the_product_to_the_cart() throws InterruptedException {
        accountPage.getAddToCart().click();
        Thread.sleep(500);
    }
    @Then("product should be added to shopping cart")
    public void product_should_be_added_to_shopping_cart() {
        Assert.assertTrue(accountPage.getMassageAddedToCart().isEnabled());
    }

    //Add Products To Shopping Card
    @When("user clicks on Books")
    public void user_clicks_on_books() {
        addProductsToCartPage.getBooksLink().click();
    }
    @When("user adds book to cart")
    public void user_adds_book_to_cart() throws InterruptedException {
        addProductsToCartPage.getBookFirstItem().click();
        Thread.sleep(500);
    }
    @When("user adds another book to cart")
    public void user_adds_another_book_to_cart() {
        addProductsToCartPage.getBookSecondItem().click();
    }
    @Then("the selected books will be added to shopping cart")
    public void the_selected_books_will_be_added_to_shopping_cart() {
        addProductsToCartPage.getShoppingCard().click();
        List<WebElement> allProducts = addProductsToCartPage.getAddedBooksList();
        for (int i = 0; i < allProducts.size(); i++) {
            String productName = allProducts.get(i).getText();
            if (productName.equals("Computing and Internet") || productName.equals("Fiction")) {
                System.out.println(productName + " Added");
            }

        }
    }

}
