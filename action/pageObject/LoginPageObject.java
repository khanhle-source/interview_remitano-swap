package pageObject;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import pageUIs.SwapPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getPleaseLoginMessage () {
        waitForElementVisible(driver, LoginPageUI.MESSAGE_LOGIN_TO_CONTINUE);
        return getElementText(driver, LoginPageUI.MESSAGE_LOGIN_TO_CONTINUE);
    }
    public void clickBackButton () {
        waitForElementClickable(driver, SwapPageUI.SUBMIT_SWAP_BUTTON);
        clickToElement(driver, SwapPageUI.SUBMIT_SWAP_BUTTON);
    }

}
