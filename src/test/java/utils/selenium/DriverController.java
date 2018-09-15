package utils.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.drivers.appium.android.Nexus5xOreoChrome;
import utils.drivers.appium.ios.Iphone8Safari;
import utils.drivers.selenium.ChromeWebDriver;
import utils.drivers.selenium.FirefoxWebDriver;

import java.net.MalformedURLException;

public class DriverController {

    public static DriverController instance = new DriverController();

    RemoteWebDriver webDriver;

    private static Logger log = LogManager.getLogger();

    public void startNexus5xOreoChrome() throws MalformedURLException {
        if (instance.webDriver != null) return;
        instance.webDriver = Nexus5xOreoChrome.loadNexus5xOreoChrome();
    }

    public void startIphone8Safari() throws MalformedURLException {
        if (instance.webDriver != null) return;
        instance.webDriver = Iphone8Safari.loadIphone8Safari();
    }

    public void startChrome(String arg) {
        if(instance.webDriver != null) return;
        instance.webDriver = ChromeWebDriver.loadChromeDriver(arg);
    }

    public void startFirefox(String arg) {
        if(instance.webDriver != null) return;
        instance.webDriver = FirefoxWebDriver.loadFirefoxDriver(arg);
    }

    public void stopWebDriver() {
        if (instance.webDriver == null) return;

        try
        {
            instance.webDriver.quit();
            instance.webDriver.close();
        }
        catch (Exception e)
        {
            log.info(e + "::WebDriver stop error");
        }

        instance.webDriver = null;
        log.info(":: WebDriver stopped");
    }
}