package stepdefinitions.common;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DemoASPAwesemoPage;
import pages.NavigateTo;
import pages.common.CommonPage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommonStepDef extends PageObject {

    public Actor dheo;
    public CommonPage commonPage;
    public DemoASPAwesemoPage demoASPAwesemoPage;
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    public String mainwindow;
    public Set<String> s1;
    public Iterator<String> i1;

    public void generatedSwitchHandler() {
        logger.info("generatedSwitchHandler ");
        mainwindow = this.getDriver().getWindowHandle();
        s1 = this.getDriver().getWindowHandles();
        i1 = s1.iterator();
    }

    public void switchToMainWindow(String windowHandle) {
        logger.info("switchToMainWindow ");
        this.getDriver().switchTo().window(windowHandle);
    }
    public void switchToParentFrame() {
        logger.info("switchToParentFrame ");
        this.getDriver().switchTo().parentFrame();
        this.getDriver().switchTo().frame(0);
        this.getDriver().switchTo().defaultContent();
    }

    public void verifyVisibilityofElement(WebElementFacade element) {
        logger.info(String.format("I Verify the Visibility of the element %s in the page", element));
        logger.info(String.format("the element %s is %s", element, element.isDisplayed()));
        shouldBeVisible(element);
    }

    public void verifyPresenceofElement(WebElementFacade element) {
        logger.info(String.format("I Verify the Presence of the element %s in the page", element));
        logger.info(String.format("the element %s is %s", element, element.isDisplayed()));
        element.isPresent();
    }

    public void clickElement(WebElementFacade element) {
        waitFor(element);
        verifyVisibilityofElement(element);
        element.click();
    }

    @Given("{actor} navigate to {}")
    public void iNavigateTo(Actor actor, String page) {
        dheo = actor;
        dheo.attemptsTo(NavigateTo.thePage(page));
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

    @When("I verify the element navigation search box in the page")
    public void iTheElementNavigation_search_txtboxInThePage() {
        verifyVisibilityofElement(demoASPAwesemoPage.NAVIGATION_SEARCH_TXTBOX);
    }

    @And("I verify the following text in the page :")
    public void iVerifyTheFollowingTextInThePage(DataTable dataTable) {
        List<String> expectedElementTextList = dataTable.asList();
        logger.info(String.format("I verify the following text in the page :", expectedElementTextList));
        for (String expectedElementText : expectedElementTextList) {
            verifyVisibilityofElement(commonPage.PAGE_CONTROL_LABEL(expectedElementText));
        }
    }
}
