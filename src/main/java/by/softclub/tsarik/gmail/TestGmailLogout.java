package by.softclub.tsarik.gmail;

import by.softclub.tsarik.gmail.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestGmailLogout {
    private Steps steps = new Steps();

    @BeforeClass(description = "Start Browser")
    public void initBrowser() {
        steps.initDriver();
    }

    @BeforeMethod(description = "Gmail Login")
    public void loginGmail() {
        steps.loginGmail();
    }

    @Test(description = "Test Gmail Logout")
    public void logoutGmail() {
        steps.logoutGmail();
        Assert.assertTrue(steps.isGmailLogout(), "Gmail Logout is failed!");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}