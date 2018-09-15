package utils.drivers.appium.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.drivers.appium.AppiumServer;
import java.net.MalformedURLException;
import java.net.URL;

public class Nexus5xOreoChrome {

    private static AndroidDriver driver;

    public static AndroidDriver loadNexus5xOreoChrome() throws MalformedURLException {
        AppiumServer.startAppiumServer(); // start the Appium Server programmatically

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("avd", "Nexus5xOreoChrome"); // set the AVD (Android Virtual Device) to be launched
        cap.setCapability("deviceName", "Nexus5xOreoChrome"); // set the name of the device to be launched (should be same as AVD)
        cap.setBrowserName("Chromium"); // set the mobile browser that should be launched on the device

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-first-run"); // ensure Chrome skips any first run Welcome screens when launched
        cap.setCapability("chromeOptions", options);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); //set the AndroidDriver to an Appium session with the above DesiredCapabilities
        return driver;
    }
}