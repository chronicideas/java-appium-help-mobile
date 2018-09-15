package utils.drivers.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeWebDriver {

    private static RemoteWebDriver driver;

    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public static RemoteWebDriver loadChromeDriver(String chromeArgument) {
        setupChromeDriver();

        ChromeDriverService driverService = ChromeDriverService.createDefaultService();

        ChromeOptions options = new ChromeOptions();
        options.addArguments(chromeArgument);

        driver = new ChromeDriver(driverService, options);
        return driver;
    }
}