package testSuites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"stepdefinitions"},
		tags= "@Page_Scenario_1",
		features = "src/test/resources/features"
	)
	

//AND
//@CucumberOptions(features="feature", glue={"cucumber/steps"})
//OR
//@CucumberOptions(features="feature/Boutiqaat.feature", glue={"cucumber/steps"})
//OR
//@CucumberOptions(features="feature/Boutiqaat.feature", glue={"classpath:src/test/java/cucumber/steps"})

public class SerenityTestRunner {}
