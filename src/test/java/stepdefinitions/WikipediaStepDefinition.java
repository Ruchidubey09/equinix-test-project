package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import steplibraries.Navigation;
import steplibraries.Search;
import steplibraries.Verification;

public class WikipediaStepDefinition {
    @Steps
    Navigation navigation;

    @Steps
    Verification verification;

    @Steps
    Search search;

    @Given("^User is on the Wikipedia Page$")
    public void user_is_on_the_wikipedia_page() {
        navigation.navigatesToWikipediaPage();
    }

    @When("^User clicks on language (.*)$")
    public void user_clicks_on_language(String language) {
        navigation.clickOnSelectedLanguage(language);
    }

    @Then("^User should see Wikipedia logo title as (.*)$")
    public void user_should_see_wikipedia_language_as(String title) {
        Assert.assertTrue("UI is rendered with correct language", verification.verifyLanguageOnWikipediaPage(title));
    }

    @When("^User searches for the celebrity (.*)$")
    public void user_searches_for_the_celebrity(String celebrityName) {
        search.searchForCelebrity(celebrityName);
    }

    @Then("^User should see celebrity name (.*) on the page$")
    public void user_should_see_celebrity_name_on_the_page(String celebrityName) {
        verification.verifyCelebrityName(celebrityName);
    }

    @And("^User logs birth and spouse details in a log file$")
    public void user_logs_birth_and_spouse_details_in_a_log_file() {
        search.logCelebrityDetails();   // See target/records.log file for the details
    }
}
