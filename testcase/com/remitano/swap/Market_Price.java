package com.remitano.swap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.LoginPageObject;
import pageObject.SwapPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Market_Price {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    private SwapPageObject swapPage;
    private LoginPageObject loginPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser name is not valid");
                break;
        }

        swapPage = new SwapPageObject(driver);
        loginPage = new LoginPageObject(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://remitano.com/swap/vn-en");
        driver.manage().window().maximize();
    }

    @Test
    public void Swap001_Market_Price_Without_Login() {
        System.out.println("Swap Page - Step 01: Close Popup");
        swapPage.closePopup();

        System.out.println("Swap Page - Step 02: Click to Market Price option");
        swapPage.clickToMarketPriceRadioButton();

        System.out.println("Swap Page - Step 03: Input Source Amount ");
        swapPage.inputToSourceAmountTextbox("1");

        System.out.println("Swap Page - Step 04: Click Submit swap button");
        swapPage.clickSubmitSwapButton();

        Assert.assertEquals(loginPage.getPleaseLoginMessage(), "Please register or login to continue");

    }

    @Test
    public void Swap002_Market_Price_Source_Amount_Equal_0() {
        System.out.println("Swap Page - Step 01: Close Popup");
        swapPage.closePopup();

        System.out.println("Swap Page - Step 02: Click to Market Price option");
        swapPage.clickToMarketPriceRadioButton();

        System.out.println("Swap Page - Step 03: Input Source Amount ");
        swapPage.inputToSourceAmountTextbox("0");

        Assert.assertEquals(swapPage.getErrorMessageAtSourceAmount(), "Amount must be bigger than 0.000000");

    }

    @Test
    public void Swap002_Market_Price_Destination_Amount_Equal_0() {
        System.out.println("Swap Page - Step 01: Close Popup");
        swapPage.closePopup();

        System.out.println("Swap Page - Step 02: Click to Market Price option");
        swapPage.clickToMarketPriceRadioButton();

        System.out.println("Swap Page - Step 03: Input Destination Amount ");
        swapPage.inputToDestinationAmountTextbox("0");

        Assert.assertEquals(swapPage.getErrorMessageAtDestinationAmount(), "Amount must be bigger than 0.00");

    }

    @Test
    public void Swap002_Market_Price_View_Chart() {
        System.out.println("Swap Page - Step 01: Close Popup");
        swapPage.closePopup();

        System.out.println("Swap Page - Step 02: Click to Market Price option");
        swapPage.clickToMarketPriceRadioButton();

        System.out.println("Swap Page - Step 03: View chart");
        swapPage.clickIconChart();

        Assert.assertEquals(swapPage.getCurrencyInChart(), "BTC/USDT");

        System.out.println("Swap Page - Step 04: Click 24h");
        swapPage.click24hChart();

        System.out.println("Swap Page - Step 05: Click 1W");
        swapPage.click1WChart();

        System.out.println("Swap Page - Step 06: Click 1M");
        swapPage.click1MChart();

        System.out.println("Swap Page - Step 07: Click 1Y");
        swapPage.click1YChart();
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
