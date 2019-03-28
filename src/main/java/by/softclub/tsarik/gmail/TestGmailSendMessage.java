package by.softclub.tsarik.gmail;

import by.softclub.tsarik.gmail.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestGmailSendMessage {
    private Steps steps = new Steps();

    @BeforeClass(description = "Start Browser")
    public void initBrowser() {
        steps.initDriver();
    }

    @BeforeMethod(description = "Gmail Login")
    public void loginGmail() {
        steps.loginGmail();
    }

    @Test(description = "Test Message Compose and Send")
    public void messageComposeAndSend(){
        steps.composeNewMessageAndSend();
        Assert.assertTrue(steps.isSentMessagePresentInbox(),"There is no sent message in Inbox folder!" );
    }

    @AfterMethod(description = "Gmail Logout")
    public void logoutGmail() {
        steps.logoutGmail();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
