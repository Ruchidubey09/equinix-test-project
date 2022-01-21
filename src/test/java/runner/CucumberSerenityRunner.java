package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/Scenario1.feature",
                "src/test/resources/features/Scenario2.feature"},
        glue = {"stepdefinitions"},
        dryRun = false
)

public class CucumberSerenityRunner {

}
