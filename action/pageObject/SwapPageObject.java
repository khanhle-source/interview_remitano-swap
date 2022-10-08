package pageObject;

import common.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageUIs.SwapPageUI;

public class SwapPageObject extends BasePage {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;



    public SwapPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopup () {
        waitForElementClickable(driver, SwapPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, SwapPageUI.CLOSE_POPUP_BUTTON);
    }

    public void clickToMarketPriceRadioButton() {
        waitForElementClickable(driver, SwapPageUI.MARKET_PRICE_RADIO_BUTTON);
        clickToElement(driver, SwapPageUI.MARKET_PRICE_RADIO_BUTTON);
    }

    public void clickToYourPriceRadioButton() {
        waitForElementClickable(driver, SwapPageUI.YOUR_PRICE_RADIO_BUTTON);
        clickToElement(driver, SwapPageUI.YOUR_PRICE_RADIO_BUTTON);
    }

    public void inputToSourceAmountTextbox(String sourceAmount) {
        waitForElementVisible(driver, SwapPageUI.SOURCE_AMOUNT_TEXTBOX);
        sendKeyToElement(driver, SwapPageUI.SOURCE_AMOUNT_TEXTBOX, sourceAmount);
    }

    public void inputToDestinationAmountTextbox (String destinationAmount) {
        waitForElementVisible(driver, SwapPageUI.DESTINATION_AMOUNT_TEXTBOX);
        sendKeyToElement(driver, SwapPageUI.DESTINATION_AMOUNT_TEXTBOX, destinationAmount);
    }

    public void inputPrice (String price) {
        waitForElementVisible(driver, SwapPageUI.PRICE);
        sendKeyToElement(driver, SwapPageUI.PRICE, price);
    }

    public String getErrorMessageAtSourceAmount() {
        waitForElementVisible(driver, SwapPageUI.ERROR_MESSAGE_SOURCE_AMOUNT);
        return getElementText(driver, SwapPageUI.ERROR_MESSAGE_SOURCE_AMOUNT);
    }

    public String getErrorMessageAtDestinationAmount() {
        waitForElementVisible(driver, SwapPageUI.ERROR_MESSAGE_DESTINATION_AMOUNT);
        return getElementText(driver, SwapPageUI.ERROR_MESSAGE_DESTINATION_AMOUNT);
    }

    public String getAmountofUSDT() {
        waitForElementVisible(driver, SwapPageUI.AMOUNT_MINUS_FEE);
        return getElementAttribute(driver, SwapPageUI.AMOUNT_MINUS_FEE, SwapPageUI.AMOUNT_ATTRIBUTE);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver,locator));
    }

    public void clickSubmitSwapButton () {
        //clickToElementByJS(SwapPageUI.SUBMIT_SWAP_BUTTON);
        waitForElementClickable(driver, SwapPageUI.SUBMIT_SWAP_BUTTON);
        clickToElement(driver, SwapPageUI.SUBMIT_SWAP_BUTTON);
    }

    public void clickIconChart () {
        waitForElementClickable(driver, SwapPageUI.ICON_CHART);
        clickToElement(driver, SwapPageUI.ICON_CHART);
    }

    public void click24hChart () {
        waitForElementClickable(driver, SwapPageUI.H_CHART);
        clickToElement(driver, SwapPageUI.H_CHART);
    }

    public void click1WChart () {
        waitForElementClickable(driver, SwapPageUI.W_CHART);
        clickToElement(driver, SwapPageUI.W_CHART);
    }

    public void click1MChart () {
        waitForElementClickable(driver, SwapPageUI.M_CHART);
        clickToElement(driver, SwapPageUI.M_CHART);
    }

    public void click1YChart () {
        waitForElementClickable(driver, SwapPageUI.Y_CHART);
        clickToElement(driver, SwapPageUI.Y_CHART);
    }

    public String getCurrencyInChart() {
        waitForElementVisible(driver, SwapPageUI.CURRENCY_CHART);
        return getElementText(driver, SwapPageUI.CURRENCY_CHART);
    }


}
