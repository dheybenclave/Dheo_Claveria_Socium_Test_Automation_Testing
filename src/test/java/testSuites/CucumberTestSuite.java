package testSuites;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepdefinitions"},
        tags= "@Page_Scenario_1",
        features = "src/test/resources/features"
)
public class CucumberTestSuite {}

//net.serenitybdd.cucumber.cli.Main
//io.cucumber.core.cli.Main

