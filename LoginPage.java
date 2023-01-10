package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    String baseUrl = "https://www.saucedemo.com/";
    By usernameFieldBy = By.id("user-name");
    By passwordFieldBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorMessageContainerBy = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage basePage (){
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login (String username, String password){
        writeText(usernameFieldBy, username);
        writeText(passwordFieldBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin (String expectedText){
        String actualText = readText(errorMessageContainerBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public LoginPage verifySuccessfulLogout (){
        waitVisability(usernameFieldBy);
        return this;
    }

}
