package stepdefinitions.Search;

import io.cucumber.java.en.*;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DemoASPAwesemoPage;
import pages.NavigateTo;
import pages.common.CommonPage;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;

import static org.hamcrest.MatcherAssert.assertThat;
//import static actors.ActorList.*;

public class SearchStepDefinitions extends PageObject {

    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    Actor user;
    CommonPage CommonPage;
    DemoASPAwesemoPage demoASPAwesemoPage;

    @Given("{actor} researching things on the internet")
    public void researchingThings(Actor actor) {
        user = actor;
        user.wasAbleTo(NavigateTo.theWikipediaHomePage());
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
