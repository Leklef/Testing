package com.example.tests.Test;

import com.example.tests.Util.AppManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    public AppManager manager;

    @Before
    public void setUp() throws Exception {
        manager = AppManager.getInstance();
    }

    @After
    public void turnDown() throws Exception {
        AppManager.getInstance().finalize();
    }

}
