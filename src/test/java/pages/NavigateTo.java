package pages;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.common.CommonPage;

public class NavigateTo {
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    CommonPage commonPage;
    Actor dheo;

    public static Performable theWikipediaHomePage() {
        return Task.where("{0} opens the Wikipedia home page",
                Open.browserOn().the(WikipediaHomePage.class));
    }

    public static Performable thePage(String homePage) {

        logger.info(String.format("Navigate Page to %s", homePage));

        Task openURL = null;

        switch (homePage.toUpperCase()) {
            case "DEMOASPAWESOMEPAGE":
                openURL = Task.where("{0} opens the Demo ASP Awesome Page", Open.browserOn().the(DemoASPAwesemoPage.class));
                break;
            case "WIKIHOMEPAGE":
                openURL = Task.where("{0} opens the Wikipedia Page", Open.browserOn().the(WikipediaHomePage.class));
                break;
        }

        return openURL;


    }


}
