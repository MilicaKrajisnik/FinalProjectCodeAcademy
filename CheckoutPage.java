package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage (WebDriver driver) {
        super(driver);
    }

    By checkoutButtonBy = By.id("checkout");
    By firstNameFieldBy = By.id("first-name");
    By lastNameFieldBy = By.id("last-name");
    By zipCodeFieldBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    By itemTotalFieldBy = By.className("summary_subtotal_label");
    By taxFieldBy = By.className("summary_tax_label");
    By totalFieldBy = By.className("summary_total_label");
    By finishButtonBy = By.id("finish");
    By messageForSuccessfulOrder = By.xpath("//*[@id='checkout_complete_container']/h2");

    public CheckoutPage clickOnCheckoutButton (){
        waitVisability(checkoutButtonBy);
        click(checkoutButtonBy);
        return this;
    }

    public CheckoutPage personalInformation (String firstName, String lastName, String zipCode){
        writeText(firstNameFieldBy, firstName);
        writeText(lastNameFieldBy, lastName);
        writeText(zipCodeFieldBy, zipCode);
        return this;
    }

    public CheckoutPage clickOnContinueButton (){
        waitVisability(continueButtonBy);
        click(continueButtonBy);
        return this;
    }

    public CheckoutPage verifyThatTotalPriceIsDisplayedProperly (){
        double itemTotal = Double.parseDouble(readText(itemTotalFieldBy).substring(13));
        double taxField = Double.parseDouble(readText(taxFieldBy).substring(6));
        double totalField = Double.parseDouble(readText(totalFieldBy).substring(8));
        double expectedPrice = itemTotal + taxField;
        assertDoubleEquals(expectedPrice, totalField);
        return this;
    }

    public CheckoutPage clickOnFinishButton (){
        waitVisability(finishButtonBy);
        click(finishButtonBy);
        return this;
    }

    public CheckoutPage verifyMessageForSuccessfulOrder (String expectedText){
        String actualText = readText(messageForSuccessfulOrder);
        assertTextEquals(expectedText, actualText);
        return this;
    }
    
}
