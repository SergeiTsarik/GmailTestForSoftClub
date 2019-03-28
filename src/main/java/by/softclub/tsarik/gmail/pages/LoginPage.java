package by.softclub.tsarik.gmail.pages;

import by.softclub.tsarik.gmail.data.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private static final By USERNAME_INPUT_LOCATOR = By.name("identifier");
    private static final By NEXT_ONE_BUTTON_LOCATOR = By.id("identifierNext");
    private static final By PASSWORD_INPUT_LOCATOR = By.name("password");
    private static final By NEXT_TWO_BUTTON_LOCATOR = By.id("passwordNext");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(DataProvider.URL);
        return this;
    }

    public boolean isLoginPageLoaded() {
        return (isElementPresent(USERNAME_INPUT_LOCATOR) || isElementPresent(PASSWORD_INPUT_LOCATOR));
    }

    public LoginPage fillUsernameInput() {
        waitForElementEnabled(USERNAME_INPUT_LOCATOR);
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(DataProvider.USERNAME_STRING);
        return this;
    }

    public LoginPage clickNextOneButton() {
        waitForElementEnabled(NEXT_ONE_BUTTON_LOCATOR);
        driver.findElement(NEXT_ONE_BUTTON_LOCATOR).click();
        return this;
    }

    public LoginPage fillPasswordInput() {
        waitForElementEnabled(PASSWORD_INPUT_LOCATOR);
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(DataProvider.PASSWORD_STRING);
        return this;
    }

    public MailBoxPage clickNextTwoButton() {
        waitForElementEnabled(NEXT_TWO_BUTTON_LOCATOR);
        driver.findElement(NEXT_TWO_BUTTON_LOCATOR).click();
        return new MailBoxPage(driver);
    }
}
