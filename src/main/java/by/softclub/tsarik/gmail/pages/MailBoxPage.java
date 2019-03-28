package by.softclub.tsarik.gmail.pages;

import by.softclub.tsarik.gmail.data.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailBoxPage extends AbstractPage {
    private static final By ACCOUNT_GOOGLE_BUTTON_LOCATOR = By.xpath("//a[contains(@aria-label,'" + DataProvider.USERNAME_STRING + "')]");
    private static final By GMAIL_LOGO_LOCATOR = By.xpath("//img[contains(@src, 'logo_gmail')]");
    private static final By SIGN_OUT_BUTTON_LOCATOR = By.xpath("//a[contains(@href, 'Logout')]");
    private static final By COMPOSE_NEW_MESSAGE_BUTTON_LOCATOR = By.xpath("//div[@class='z0']/div");
    private static final By INBOX_MESSAGE_ITEM_LOCATOR = By.xpath("//div[@class='UI']//tbody/tr/td[6]//div/div/div/span/span[contains(text(), '" + DataProvider.SUBJECT + "')]");

    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogined() {
        return (isElementPresent(ACCOUNT_GOOGLE_BUTTON_LOCATOR) && isElementPresent(GMAIL_LOGO_LOCATOR));
    }

    public MailBoxPage clickAccountGoogleButton() {
        waitForElementEnabled(ACCOUNT_GOOGLE_BUTTON_LOCATOR);
        driver.findElement(ACCOUNT_GOOGLE_BUTTON_LOCATOR).click();
        return this;
    }

    public LoginPage clickSignOutButton() {
        waitForElementEnabled(SIGN_OUT_BUTTON_LOCATOR);
        driver.findElement(SIGN_OUT_BUTTON_LOCATOR).click();
        return new LoginPage(driver);
    }

    public MessagePage clickComposeButton() {
        waitForElementPresent(COMPOSE_NEW_MESSAGE_BUTTON_LOCATOR);
        driver.findElement(COMPOSE_NEW_MESSAGE_BUTTON_LOCATOR).click();
        return new MessagePage(driver);
    }

    public boolean isSentMessagePresentsInbox() {
        waitForElementPresent(INBOX_MESSAGE_ITEM_LOCATOR);
        return isElementPresent(INBOX_MESSAGE_ITEM_LOCATOR);
    }
}