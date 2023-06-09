package stepdefinitions.Search;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DemoASPAwesemoPage;
import pages.NavigateTo;
import pages.common.CommonPage;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;
//import static actors.ActorList.*;

public class SearchStepDefinitions extends PageObject {

    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    Actor user;
    CommonPage CommonPage;
    DemoASPAwesemoPage demoASPAwesemoPage;

    @Given("{actor} researching things on the internet")
    public void researchingThings(Actor actor) {
        user = actor;
        user.wasAbleTo(NavigateTo.thePage("WIKIHOMEPAGE"));
    }

    @When("I looks up {string}")
    public void searchesFor(String term) {
        user.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("I should see information about {string}")
    public void should_see_information_about(String term) {
        user.attemptsTo(Ensure.that(WikipediaArticle.HEADING).hasText(term)
        );
    }

}
