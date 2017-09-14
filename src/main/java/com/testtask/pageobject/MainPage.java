package com.testtask.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.testtask.utils.Selenium.waitUntilElementIsDisplayed;

/**
 * Created by O. Korniev on 14.09.2017.
 */
public class MainPage {

    private final WebDriver webdriver;

    public MainPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void clickToHelpButton() {
        waitUntilElementIsDisplayed(helpButton);
        //need to change to exp. wait!!
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        helpButton.click();
        waitUntilElementIsDisplayed(chatWithPatrick);
    }

    @FindBy(xpath = "//a[@id='count-customer-procesed']/div")
    public WebElement clientsButton;

    @FindBy(xpath = "//div[@id='settingsButton']/button[2]/img")
    public WebElement helpButton;

    @FindBy(xpath = "//div[5]/div[2]")
    public WebElement chatWithPatrick;

    @FindBy(id = "navigation-list-scroll-container")
    public WebElement leftMenu;

    @FindBy(id = "conversationSubjectHeader")
    public WebElement conversationUserIs;

    @FindBy(xpath = "//div/div[3]")
    public WebElement gettingYourTeamOnboard;
}
