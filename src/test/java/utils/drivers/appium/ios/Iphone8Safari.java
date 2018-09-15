package utils.drivers.appium.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.drivers.appium.AppiumServer;
import java.net.MalformedURLException;
import java.net.URL;

public class Iphone8Safari {

    private static IOSDriver driver;

    public static IOSDriver loadIphone8Safari() throws MalformedURLException {
        AppiumServer.startAppiumServer(); //start the Appium server

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformVersion", "11.4"); // set the iOS simulator version to iOS 11.4
        cap.setCapability("deviceName", "iPhone 8"); // set the name of the device to be launched
        cap.setBrowserName("Safari"); // set the mobile browser that should be launched on the device

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); //set the IOSDriver to an Appium session with the above DesiredCapabilities
        return driver;
    }
}