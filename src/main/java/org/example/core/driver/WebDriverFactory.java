package org.example.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.Browsers;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.getBROWSER();
        return getDriver(Browsers.valueOf(browserType.toUpperCase()));

    }

    public static WebDriver getDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case OPERA:
                return getOperaDriver();
            case SAFARI:
                return getSafariDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Wrong browser was chosen");

        }
    }


    public static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().clearResolutionCache().setup();
           // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getSafariDriver() {
        if (driver == null) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        return driver;
    }

    public static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver getOperaDriver() {
        if (driver == null) {
            WebDriverManager.operadriver().driverVersion("112.0.5615.165").setup();
            driver = new OperaDriver();
        }
        return driver;
    }

}
