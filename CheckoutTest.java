package tests;

import org.junit.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {
    
    public LoginPage loginPage;
    public HomePage homePage;
    public CheckoutPage checkoutPage;

    String username = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "PRODUCTS";
    String firstName = "Milica";
    String lastName = "Krajisnik";
    String zipCode = "21209";
    String messageForSuccesfulOrder = "THANK YOU FOR YOUR ORDER";

    @Test
    public void verifySuccessfulOrder (){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.basePage();
        loginPage.login(username, password);
        homePage.verifySuccessfulLogin(homePageTitle);
        homePage.verifyProductsAddedToCart();
        homePage.clickOnShoppingCartBadge();
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.personalInformation(firstName, lastName, zipCode);
        checkoutPage.clickOnContinueButton();
        checkoutPage.verifyThatTotalPriceIsDisplayedProperly();
        checkoutPage.clickOnFinishButton();
        checkoutPage.verifyMessageForSuccessfulOrder(messageForSuccesfulOrder);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
