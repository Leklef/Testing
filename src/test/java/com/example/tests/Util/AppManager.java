package com.example.tests.Util;

import com.example.tests.Helper.LoginHelper;
import com.example.tests.Helper.NavigationHelper;
import com.example.tests.Helper.ProgramsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AppManager {

    public WebDriver driver;
    public String baseUrl;
    protected boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private Setting setting;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private ProgramsHelper programsHelper;

    public static String file = "/Users/lenar/Downloads/Testing-master/src/test/java/com/example/tests/Util/setting.xml";

    private static ThreadLocal<AppManager> threadLocal = new ThreadLocal<AppManager>();

    public AppManager() throws JAXBException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this);
        programsHelper = new ProgramsHelper(this);
        File file = new File(AppManager.file);
        JAXBContext readCtx = JAXBContext.newInstance(Setting.class);
        Unmarshaller um = readCtx.createUnmarshaller();
        setting = (Setting) um.unmarshal(file);
        baseUrl = setting.getBaseURL();
    }

    public Setting getSetting() {
        return setting;
    }

    public void stop() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public static AppManager getInstance() throws Exception {
        if (threadLocal.get() == null) {
            AppManager newInstance = new AppManager();
            newInstance.navigationHelper.openHomePage();
            threadLocal.set(newInstance);
        }
        return threadLocal.get();
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ProgramsHelper getProgramsHelper() {
        return programsHelper;
    }

    /**
     * destructor
     */
    public void finalize() throws Exception {
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }
}
