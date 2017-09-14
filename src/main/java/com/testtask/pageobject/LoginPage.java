package com.testtask.pageobject;

import com.testtask.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.testtask.utils.Selenium.waitUntilElementIsDisplayed;

/**
 * Created by O. Korniev on 14.09.2017.
 */

public class LoginPage {
    private final WebDriver webdriver;

    public LoginPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void login() {
        waitUntilElementIsDisplayed(alreadyHaveAnAccountLink);
        alreadyHaveAnAccountLink.click();
        waitUntilElementIsDisplayed(userEmailField);
        userEmailField.click();
        userEmailField.sendKeys(ConfigProperties.getProperty("email"));
        waitUntilElementIsDisplayed(getStartedButton);
        getStartedButton.click();
        waitUntilElementIsDisplayed(userPasswordField);
        userPasswordField.click();
        userPasswordField.sendKeys(ConfigProperties.getProperty("password"));
        waitUntilElementIsDisplayed(signInButton);
        signInButton.click();
        waitUntilElementIsDisplayed(helpButtonOnMainPage);
    }

    @FindBy (xpath = "//rx-welcome-to-redkix/div/div/div/div[2]")
    public WebElement alreadyHaveAnAccountLink;

    @FindBy (id = "getStartedWorkEmail")
    public WebElement userEmailField;

    @FindBy (id = "getStartedButton")
    public WebElement getStartedButton;

    @FindBy (id = "exchangePassword")
    public WebElement userPasswordField;

    @FindBy (id = "exchangeSignInButton")
    public WebElement signInButton;

    @FindBy (xpath = "//div[@id='settingsButton']/button[2]/img")
    public WebElement helpButtonOnMainPage;

    //MainPageElement
    @FindBy(xpath = "//a[@id='count-customer-procesed']/div")
    public WebElement clientsButton;
}
