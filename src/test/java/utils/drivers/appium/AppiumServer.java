package utils.drivers.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    public static void startAppiumServer() {
        service.start();
    }

    public static void stopAppiumServer() {
        service.stop();
    }
}
