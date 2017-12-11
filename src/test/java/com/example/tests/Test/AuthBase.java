package com.example.tests.Test;

import com.example.tests.Model.AccountData;
import com.example.tests.Util.AppManager;
import org.junit.Assert;
import org.junit.Before;

public class AuthBase extends TestBase {
    @Before
    public void setUp() throws Exception {
        manager = AppManager.getInstance();
        AccountData user = new AccountData(manager.getSetting().getName(), manager.getSetting().getEmail(), manager.getSetting().getPassword());
        manager.getNavigationHelper().openLoginPage();
        manager.getLoginHelper().login(user);
        Assert.assertTrue(manager.getLoginHelper().isLoggedInWithUsername(user.name));
    }
}
