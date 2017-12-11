package com.example.tests.Helper;

import com.example.tests.Util.AppManager;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(AppManager manager) {
        super(manager);
    }

    public void openHomePage() {
        driver.get(appManager.baseUrl + "/");
    }

    public void openLoginPage() {
        driver.findElement(By.linkText("Войти")).click();
    }

    public void openPrograms() {
        driver.findElement(By.xpath("//div[@id='sidebar-nav']/ul/li[2]/a/span")).click();
    }
}
