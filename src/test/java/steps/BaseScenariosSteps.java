package steps;

import cucumber.api.java.en.Given;
import pages.BasePage;

public class BaseScenariosSteps extends BaseSteps {

    @Given("^I navigate to the base URL")
    public void iNavigateToTheBaseURL() {
        instanceOf(BasePage.class).navigateBaseUrl();
    }
}