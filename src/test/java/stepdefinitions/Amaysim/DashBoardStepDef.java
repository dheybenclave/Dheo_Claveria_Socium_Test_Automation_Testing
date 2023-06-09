package stepdefinitions.Amaysim;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AmaysimPage.DashboardPage;
import stepdefinitions.common.CommonStepDef;

import java.util.ArrayList;
import java.util.List;

public class DashBoardStepDef extends PageObject {
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    public DashboardPage dashboardPage;
    public CommonStepDef commonStepDef;

    @Then("I verify the dashboard page")
    public void verifyDasboardPageELements() {

        List<WebElementFacade> dashboardElements = new ArrayList<>();
        dashboardElements.add(dashboardPage.WELCOME_HEADER());
        dashboardElements.add(dashboardPage.SERVICES_BUTTON());
        dashboardElements.add(dashboardPage.ACCOUNT_BUTTON());
        dashboardElements.add(dashboardPage.HELP_BUTTON());
        dashboardElements.add(dashboardPage.LOGOUT_BUTTON());

        logger.info(String.format("iVerifyTheFollowingElementInTheDashboardPage %s", dashboardElements));
        dashboardElements.forEach(WebElementState::shouldBeVisible);
    }

    @And("I click on the {} Tab")
    public void clickTab(String tabName) {
        WebElementFacade element = null;
        switch (tabName.toLowerCase()) {
            case "services":
                element = dashboardPage.SERVICES_BUTTON();
                break;
            case "account":
                element = dashboardPage.ACCOUNT_BUTTON();
                break;
            case "help":
                element = dashboardPage.HELP_BUTTON();
                break;
        }
        commonStepDef.clickElement(element);
    }
}
