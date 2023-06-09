package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigateTo extends PageObject {
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    public static Performable thePage(String homePage) {

        logger.info(String.format("Navigate Page to %s", homePage));

        Task openURL = null;

        switch (homePage.toUpperCase()) {
            case "DEMOASPAWESOMEPAGE":
                openURL = Task.where("{0} opens the Demo ASP Awesome Application Page", Open.browserOn().thePageNamed("pages.demoaspawesome"));
                break;
            case "WIKIHOMEPAGE":
                openURL = Task.where("{0} opens the Wikipedia Application Page", Open.browserOn().thePageNamed("pages.wiki"));
                break;
            case "AMAYSIMPAGE":
                openURL = Task.where("{0} opens the Amaysim Application Page", Open.browserOn().thePageNamed("pages.amaysim"));
                break;
        }
        return openURL;
    }


}
