package steplibraries;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.WikipediaMainPage;

public class Verification {

    WikipediaMainPage wikipediaMainPage;

    @Step()
    public boolean verifyLanguageOnWikipediaPage(String title) {
        return wikipediaMainPage.verifyLanguageOnUI(title);
    }

    @Step
    public void verifyCelebrityName(String celebrityName) {
        String actualCelebrityName = wikipediaMainPage.getCelebrityNameOnInfoBox();
        Assert.assertTrue("Celebrity Name is correct", actualCelebrityName.trim().equalsIgnoreCase(celebrityName.trim()));
    }
}
