package com.testtask.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by O. Korniev on 14.09.2017.
 */

public class Selenium {

    public static final byte WAIT_TIME = 10;

    public static void waitForElementVisible(WebElement webElement, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilElementIsDisplayed(WebElement webElement){
        int i = 0;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!webElement.isDisplayed()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == 5 * WAIT_TIME){
                break;
            }
        }
    }

    public static void findTextAndClick(String string, WebDriver driver) throws InterruptedException {
        int i = 0;
        Thread.sleep(200);
        while (!driver.findElement(By.xpath("//a[contains(text(),('" + string + "'))]")).isDisplayed()) {
            Thread.sleep(200);
            i++;
            if (i == 5 * WAIT_TIME){
                break;
            }
        }
        driver.findElement(By.xpath("//a[contains(text(),('" + string + "'))]")).click();
    }
}
