package utils.extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.selenium.Driver.browser;
import static utils.selenium.Settings.wdHighlightedColour;

public class WebDriverExtensions {

    private static int sec = 10;

    public static Object wdHighlight(By locator) {
        WebDriver driver = browser();
        WebElement myLocator = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(wdHighlightedColour, myLocator);
    }

    public static Object wdElementIsDisplayed(By locator) {
        wdHighlight(locator);
        WebDriverWait wait = new WebDriverWait(browser(), sec);
        return wait.until(ExpectedConditions.visibilityOf((WebElement) locator));
    }

    public static void wdElementToDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(browser(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement wdFindElement(By locator) {
        wdElementIsDisplayed(locator);
        return browser().findElement(locator);
    }

    public static void wdClick(By locator) {
        wdFindElement(locator).click();
    }

    public static void wdSendKeys(By locator, String text, boolean clearFirst) {
        if (clearFirst) wdClick(locator);
        wdFindElement(locator).sendKeys(text);
    }
}
