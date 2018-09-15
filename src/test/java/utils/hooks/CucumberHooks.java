package utils.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.selenium.DriverController;

import java.net.MalformedURLException;

public class CucumberHooks {

    @Before("@Nexus5xOreoChrome")
    public void beforeNexus5xOreoChrome() throws MalformedURLException {
        DriverController.instance.startNexus5xOreoChrome();
    }

    @Before("@Iphone8Safari")
    public void beforeIphone8Safari() throws MalformedURLException {
        DriverController.instance.startIphone8Safari();
    }

    @Before("@Chrome")
    public void beforeChrome(){
        DriverController.instance.startChrome("--disable-extensions");
    }

    @Before("@Firefox")
    public void beforeFirefox() {
        DriverController.instance.startFirefox("--disable-extensions");
    }

    @Before("@HeadlessChrome")
    public void beforeChromeHeadless() {
        DriverController.instance.startChrome("--headless");
    }

    @Before("@HeadlessFirefox")
    public void beforeHeadlessFirefox() {
        DriverController.instance.startFirefox("--headless");
    }

    @After
    public void stopWebDriver() {
        DriverController.instance.stopWebDriver();
    }
}