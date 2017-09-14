package com.testtask;

import com.testtask.pageobject.LoginPage;
import com.testtask.pageobject.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.testtask.Hostname.loginPageLink;
import static com.testtask.utils.Selenium.*;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by O. Korniev on 14.09.2017.
 */
public class Redkix {
    private LoginPage loginPage;
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void before() {
        System.setProperty(ConfigProperties.getProperty("chrome"), ConfigProperties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.get(loginPageLink());
        loginPage.login();
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    // Done - User should be able to click on a help icon in the sidebar to open the help menu
    // Done - Items in the help menu should open a new tab/window in the users default browser
    // Done - Clicking on the ‘Chat with Patrick from Redkix’ should open Patricks DM in the sidebar
    //      In progress - and mark it as favorite.
    //              In progress - Avatar should update if Patrick changes his avatar
    //              In progress - Avatar should show the online status of Patrick always as ‘online’

    @Test
    public void clickToHelpAndOpenPatrickChat(){
        mainPage.clickToHelpButton();
        mainPage.chatWithPatrick.click();
        assertTrue(mainPage.conversationUserIs.getText().equals("Patrick W"));
    }

    //	Done - Clicking on the “Getting Your Team Onboard” item should open the invite view modal

    @Test
    public void gettingYourTeamOnboardShouldOpen(){
        mainPage.clickToHelpButton();
        mainPage.gettingYourTeamOnboard.click();
        assertTrue(driver.getPageSource().contains("To unlock all the features of Redkix, " +
                "invite the people you work with the most and centralize all your team's " +
                "communications. You'll also be able to see who's online, typing, " +
                "and collaborate in real-time"));
    }

    // In progress - Remove the settings button and instead make the users avatar clickable to open settings
    // In progress - ? Icon is always green to stand out

    // Done - Items in the menu should have hover states (gray background),
    //      In progress - the same as our other popover menus

    @Test
    public void checkLeftMenuPadding(){
        assertTrue(mainPage.leftMenu.getCssValue("background-color").equals("rgba(24, 25, 52, 1)"));
    }

    // In progress - There should be a 8px padding on the top and bottom around the first and last menu item in each section


    @AfterMethod
    public void after(){
        driver.close();
    }
}
