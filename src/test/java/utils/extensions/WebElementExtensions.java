package utils.extensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.selenium.Driver.browser;
import static utils.selenium.Settings.weHighlightedColour;

public class WebElementExtensions {

    private static int sec = 10;

    public static WebDriverWait weWaitForSeconds() {
        WebDriverWait wait = new WebDriverWait(browser(), sec);
        return wait;
    }

    public static void weElementIsDisplayed(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.visibilityOf(element));
    }

    public static void weElementToBeClickable(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void weHighlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) browser();
        js.executeScript(weHighlightedColour, element);
    }

    public static void weClick(WebElement element) {
        weElementToBeClickable(element);
        weHighlightElement(element);
        element.click();
    }

    public static void weSendKeys(WebElement element, String text, boolean clearFirst) {
        weElementIsDisplayed(element);
        if (clearFirst) weClick(element);
        element.sendKeys(text);
    }

    public static void weElementIsInvisible(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.invisibilityOf(element));
    }

    public static String weGetAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}
