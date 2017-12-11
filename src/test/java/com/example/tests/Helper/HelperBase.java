package com.example.tests.Helper;

import com.example.tests.Util.AppManager;
import org.openqa.selenium.*;

public class HelperBase {

    protected AppManager appManager;
    protected WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public HelperBase(AppManager manager) {
        this.appManager = manager;
        this.driver = manager.driver;
    }

    public void fillTheFieldById(String id, String value) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void fillTheFieldByName(String name, String value) {
        driver.findElement(By.name(name)).clear();
        driver.findElement(By.name(name)).sendKeys(value);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
