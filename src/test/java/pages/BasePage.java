package pages;

import static utils.selenium.Driver.browser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.selenium.Settings;
import java.util.List;

import static utils.extensions.WebElementExtensions.*;

public class BasePage extends Page {

    public WebDriver driver = browser();
    private String getTitle() { return driver.getTitle(); }
    private String getUrl() {return driver.getCurrentUrl(); }
    private String getPageSource() {return driver.getPageSource(); }

    @FindBy(how = How.NAME, using = "q")
    public WebElement searchField;

    public SearchResultsPage searchFor(String searchTerm) {
        weSendKeys(searchField, searchTerm + Keys.RETURN, true);
        return instanceOf(SearchResultsPage.class);
    }

    public void navigateBaseUrl() {
        String baseUrl = Settings.baseUrl;
        browser().navigate().to(baseUrl);
        System.out.println("Welcome to Product - Selenium Automation Framework");
    }

    public void validatePageTitle(String expectedTitle) {
        Assert.assertTrue(getTitle().contains(expectedTitle));
        System.out.println(":: The title of the site is: " + getTitle());
    }

    public void validatePageUrl(String expectedUrl) {
        Assert.assertTrue(getUrl().contains(expectedUrl));
        System.out.println(":: The page Url is: " + getUrl());
    }

    public void validatePageSource(String expectedPageSource) {
        Assert.assertTrue(getPageSource().contains(expectedPageSource));
        System.out.println(":: The page source is: " + getPageSource());
    }

    public void validateMultipleInPageSource(List<String> table) {
        for (String row : table) {
            Assert.assertTrue(getPageSource().contains(row));
            System.out.println("The text " + row + " is in the PageSource");
        }
    }
}