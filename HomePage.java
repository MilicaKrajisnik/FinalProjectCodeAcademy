package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver){
        super(driver);
    }

    By homePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By menuButtonBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By numberOfProductsBy = By.className("inventory_item");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bike-light");
    By shoopingCartBadgeBy = By.xpath("//*[@id='shopping_cart_container']/a");

    public HomePage verifySuccessfulLogin (String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage clickOnMenuButton (){
        click(menuButtonBy);
        return this;
    }

    public HomePage clickOnLogoutButton (){
        click(logoutButtonBy);
        return this;
    }

    public HomePage verifyNumberOfAllProducts (int expectedNumberOfProducts){
        int actualNumberOfProducts = countProducts(numberOfProductsBy);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public HomePage verifyProductsAddedToCart (){
        click(addToCartButton1By);
        click(addToCartButton2By);
        waitVisability(shoopingCartBadgeBy);
        return this;
    }

    public HomePage clickOnShoppingCartBadge (){
        click(shoopingCartBadgeBy);
        return this;
    }

}
