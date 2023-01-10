package tests;
import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;

    String username = "standard_user";
    String password = "secret_sauce";
    String badUsername = "milica";
    String badPassword = "milica";
    String errorMesaggeBadUsernameAndBadPassword = "Epic sadface: Username and password do not match any user in this service";
    String emptyUsernameField = "";
    String errorMesaggeEmptyUsernameField = "Epic sadface: Username is required";
    String homePageTitle = "PRODUCTS";

    @Test
    public void verifySuccessfulLogin (){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(username, password);
        homePage.verifySuccessfulLogin(homePageTitle);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccessfulLoginWithBadUsername (){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(badUsername, password);
        loginPage.verifyUnsuccessfulLogin(errorMesaggeBadUsernameAndBadPassword);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccessfulLoginWithBadPassword (){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(username, badPassword);
        loginPage.verifyUnsuccessfulLogin(errorMesaggeBadUsernameAndBadPassword);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccessfulLoginWithEmptyUsernameField (){
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(emptyUsernameField, password);
        loginPage.verifyUnsuccessfulLogin(errorMesaggeEmptyUsernameField);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
