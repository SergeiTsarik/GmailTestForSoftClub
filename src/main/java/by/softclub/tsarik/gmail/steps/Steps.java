package by.softclub.tsarik.gmail.steps;

import by.softclub.tsarik.gmail.pages.*;
import by.softclub.tsarik.gmail.webdriver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class Steps {
    private WebDriver driver;

    public void initDriver() {
        driver = WebDriverSingleton.getDriver();
    }

    public void closeDriver() {
        WebDriverSingleton.removeDriver();
    }

    public void loginGmail() {
        new LoginPage(driver).open().fillUsernameInput().clickNextOneButton().fillPasswordInput().clickNextTwoButton();
    }

    public boolean isGmailLogin() {
        return new MailBoxPage(driver).isLogined();
    }

    public void logoutGmail() {
        new MailBoxPage(driver).clickAccountGoogleButton().clickSignOutButton();
    }

    public boolean isGmailLogout() {
        return new LoginPage(driver).isLoginPageLoaded();
    }

    public void composeNewMessageAndSend(){
        new MailBoxPage(driver).clickComposeButton();
        new MessagePage(driver).fillToInput().fillSubjectInput().fillBodyInput().clickSendButton();
    }

    public boolean isSentMessagePresentInbox(){
        return new MailBoxPage(driver).isSentMessagePresentsInbox();
    }
}