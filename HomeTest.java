package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;

    String username = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "PRODUCTS";
    int expectedNumberOfAllProducts = 6;

    @Test
    public void verifySuccessfulLogout (){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(username, password);
        homePage.verifySuccessfulLogin(homePageTitle);
        homePage.clickOnMenuButton();
        homePage.clickOnLogoutButton();
        loginPage.verifySuccessfulLogout();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyNumberOfAllProductsOnHomePage (){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(username, password);
        homePage.verifySuccessfulLogin(homePageTitle);
        homePage.verifyNumberOfAllProducts(expectedNumberOfAllProducts);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifySuccessfulAddedToShoppingCart (){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(username, password);
        homePage.verifySuccessfulLogin(homePageTitle);
        homePage.verifyProductsAddedToCart();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }    
}
