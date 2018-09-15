package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import pages.BasePage;

public class SendKeysSteps extends BaseSteps {

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchTerm) throws Throwable {
        instanceOf(BasePage.class).searchFor(searchTerm);
    }
}
