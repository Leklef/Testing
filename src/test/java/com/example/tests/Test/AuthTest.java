package com.example.tests.Test;

import com.example.tests.Model.AccountData;
import org.junit.Assert;
import org.junit.Test;

public class AuthTest extends TestBase {
    @Test
    public void loginWithValidDate() {
        AccountData user = new AccountData("Ленар","lenar2005@mail.ru", "12345678");
        manager.getNavigationHelper().openHomePage();
        manager.getNavigationHelper().openLoginPage();
        manager.getLoginHelper().login(user);
        Assert.assertTrue(manager.getLoginHelper().isLoggedInWithUsername(user.name));
    }

    @Test
    public void loginWithInvalidDate() {
        AccountData user = new AccountData("Ленар","lenar2005@mail.ru", "87654321");
        manager.getNavigationHelper().openHomePage();
        manager.getNavigationHelper().openLoginPage();
        manager.getLoginHelper().login(user);
        Assert.assertTrue(manager.getLoginHelper().isLoggedInWithUsername(user.name));
    }
}
