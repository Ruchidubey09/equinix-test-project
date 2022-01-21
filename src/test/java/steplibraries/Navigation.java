package steplibraries;

import net.thucydides.core.annotations.Step;
import pages.WikipediaMainPage;

public class Navigation {

    WikipediaMainPage wikipediaMainPage;

    @Step("Wikipedia page is opened")
    public void navigatesToWikipediaPage() {
        wikipediaMainPage.open();
    }

    @Step()
    public void clickOnSelectedLanguage(String languageLink) {
        wikipediaMainPage.clicksOnAParticularLanguageLink(languageLink);
    }
}
