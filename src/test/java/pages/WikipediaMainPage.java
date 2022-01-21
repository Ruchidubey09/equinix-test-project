package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://en.wikipedia.org/wiki/Main_Page")
public class WikipediaMainPage extends PageObject {

    @FindBy(name = "search")
    WebElementFacade searchTextBox;

    @FindBy(id = "searchButton")
    WebElementFacade searchIcon;

    @FindBy(id = "firstHeading")
    WebElementFacade wikipediaPageTitle;

    @FindBy(xpath = "//span[@class='bday']")
    WebElementFacade birthdaySpan;

    @FindBy(xpath = "//th[text()='Born']/..//td")
    WebElementFacade birthDateInfo;

    @FindBy(xpath = "//span[contains(text(),'Spouse')]/../..//a")
    WebElementFacade spouseInfo;

    @FindBy(xpath = "//span[contains(text(),'Partner')]/../..//a")
    WebElementFacade partnerInfo;

    public WikipediaMainPage(WebDriver driver) {
        super(driver);
    }

    public void clicksOnAParticularLanguageLink(String link) {
        List<WebElementFacade> languagesLinks = withTimeoutOf(10, TimeUnit.SECONDS).findAll("//li[contains(@class,'interlanguage-link')]//span");
        WebElementFacade matchingElement = null;
        for (WebElementFacade webElementFacade : languagesLinks) {
            if (webElementFacade.getText().equalsIgnoreCase(link)) {
                matchingElement = webElementFacade;
                break;
            }
        }
        matchingElement.click();
    }

    public boolean verifyLanguageOnUI(String title) {
        WebElementFacade actualTitle = findBy("//div[@id='p-logo']//a[@title='" + title + "']");
        if (actualTitle.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void enterCelebrityNameandClickSearchIcon(String celebrityName) {
        waitFor(ExpectedConditions.visibilityOf(searchTextBox));
        searchTextBox.type(celebrityName);
        searchIcon.click();
    }

    public String getCelebrityNameOnInfoBox() {
        String celebrityName = wikipediaPageTitle.getText();
        return celebrityName;
    }

    public String getCelebrityBirthDateOnInfoBox() {
        if (birthdaySpan.isPresent()) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            return (js.executeScript("return arguments[0].childNodes[2].textContent;", birthDateInfo)).toString();
        }
        return "NA";
    }

    public String getSpouseOrPartnerInfo() {
        if (spouseInfo.isPresent()) {
            return spouseInfo.getText();
        } else if (partnerInfo.isPresent()) {
            return partnerInfo.getText();
        }
        return "NA";
    }
}
