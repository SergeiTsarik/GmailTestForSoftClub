package by.softclub.tsarik.gmail;

import by.softclub.tsarik.gmail.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestGmailLogin {
    private Steps steps = new Steps();

    @BeforeClass(description = "Start Browser")
    public void initBrowser() {
        steps.initDriver();
    }

    @Test(description = "Test Gmail Login")
    public void loginGmail() {
        steps.loginGmail();
        Assert.assertTrue(steps.isGmailLogin(), "Gmail Login is failed!");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}