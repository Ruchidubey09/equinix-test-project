package steplibraries;

import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.WikipediaMainPage;

public class Search {
    private static Logger logger = LoggerFactory.getLogger("record-log");
    WikipediaMainPage wikipediaMainPage;

    @Step()
    public void searchForCelebrity(String celebrityName) {
        wikipediaMainPage.enterCelebrityNameandClickSearchIcon(celebrityName);
    }

    @Step
    public void logCelebrityDetails() {
        logger.info("Celebrity name->" + wikipediaMainPage.getCelebrityNameOnInfoBox() + ", Date of Birth->"
                + wikipediaMainPage.getCelebrityBirthDateOnInfoBox() + ", Partner/Spouse-> "
                + wikipediaMainPage.getSpouseOrPartnerInfo());
    }
}
