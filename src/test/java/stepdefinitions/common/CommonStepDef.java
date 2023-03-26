package stepdefinitions.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DemoASPAwesemoPage;
import pages.NavigateTo;
import pages.common.CommonPage;
import pages.DemoASPAwesemoPage;

public class CommonStepDef extends PageObject {

    public Actor dheo;
    public CommonPage commonPage;
    public DemoASPAwesemoPage demoASPAwesemoPage;
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    @Given("{actor} navigate to {}")
    public void iNavigateTo(Actor actor, String page) {
        dheo = actor;
        dheo.wasAbleTo(NavigateTo.thePage(page));
        Ensure.thatTheCurrentPage().currentUrl();
    }

    @Given("I go to {} > {} > {} modules")
    public void iNavigateToSubGroup(String group, String subPage, String subPageItem) {

        if (!group.isEmpty()) {
            logger.info(String.format("I the element %s in the page", group));
            commonPage.NAVIGATE_MODULE_PARENT.click();
        }
        if (!subPage.isEmpty()) {
            logger.info(String.format("I the element %s in the page", subPage));
            commonPage.NAVIGATE_MODULE_SUB(subPage).click();
        }
        if (!subPageItem.isEmpty()) {
            logger.info(String.format("I the element %s in the page", subPageItem));
            commonPage.NAVIGATE_MODULE_SUB(subPageItem).click();
        }

    }
    @When("I verify the element {} in the page")
    public void iTheElementNavigation_search_txtboxInThePage(String element) {

        logger.info(String.format("I the element %s in the page", element));
        logger.info(String.format("the element %s is %s", element, demoASPAwesemoPage.NAVIGATION_SEARCH_TXTBOX.isDisplayed()));
        shouldBeVisible(demoASPAwesemoPage.NAVIGATION_SEARCH_TXTBOX);
    }
}
