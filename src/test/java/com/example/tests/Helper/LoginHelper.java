package com.example.tests.Helper;

import com.example.tests.Util.AppManager;
import com.example.tests.Model.AccountData;
import org.openqa.selenium.*;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager manager) {
        super(manager);
    }

    public void login(AccountData user) {
        if (isLoggedIn()) {
            if (isLoggedInWithUsername(user.name)) {
                return;
            }
        }
        fillTheFieldByName("email", user.email);
        fillTheFieldByName("password", user.password);
        driver.findElement(By.id("login-submit")).click();
    }

    public void logout() {
        if (isLoggedIn()) {
            driver.findElement(By.linkText("Ленар")).click();
            driver.findElement(By.linkText("Выход")).click();
        }
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.className("hidden-xs"));
    }
    public boolean isLoggedInWithUsername(String name) {
        return isLoggedIn() && driver.findElement(By.className("hidden-xs")).getText().equals(name);
    }
}
