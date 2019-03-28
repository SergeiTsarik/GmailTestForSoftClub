package by.softclub.tsarik.gmail.pages;

import by.softclub.tsarik.gmail.data.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePage extends AbstractPage {
    private static final By NEW_MESSAGE_TO_INPUT_LOCATOR = By.name("to");
    private static final By NEW_MESSAGE_SUBJECT_INPUT_LOCATOR = By.name("subjectbox");
    private static final By NEW_MESSAGE_BODY_INPUT_LOCATOR = By.xpath("//div[contains(@aria-label, 'Message Body')]");
    private static final By SEND_BUTTON_LOCATOR = By.xpath("//div[contains(@aria-label, 'Send') and @role='button']");

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    public MessagePage fillToInput() {
        waitForElementEnabled(NEW_MESSAGE_TO_INPUT_LOCATOR);
        driver.findElement(NEW_MESSAGE_TO_INPUT_LOCATOR).sendKeys(DataProvider.EMAIL);
        return this;
    }

    public MessagePage fillSubjectInput() {
        waitForElementEnabled(NEW_MESSAGE_SUBJECT_INPUT_LOCATOR);
        driver.findElement(NEW_MESSAGE_SUBJECT_INPUT_LOCATOR).sendKeys(DataProvider.SUBJECT);
        return this;
    }

    public MessagePage fillBodyInput() {
        waitForElementEnabled(NEW_MESSAGE_BODY_INPUT_LOCATOR);
        driver.findElement(NEW_MESSAGE_BODY_INPUT_LOCATOR).sendKeys(DataProvider.MEASSAGE_TEXT);
        return this;
    }

    public MailBoxPage clickSendButton() {
        waitForElementEnabled(SEND_BUTTON_LOCATOR);
        driver.findElement(SEND_BUTTON_LOCATOR).click();
        return new MailBoxPage(driver);
    }
}