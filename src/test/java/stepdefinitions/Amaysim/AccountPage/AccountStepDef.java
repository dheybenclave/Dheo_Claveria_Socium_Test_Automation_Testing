package stepdefinitions.Amaysim.AccountPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AmaysimPage.AccountPage.AccountPage;
import stepdefinitions.common.CommonStepDef;

import java.util.ArrayList;
import java.util.List;

public class AccountStepDef extends PageObject {
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    public AccountPage accountPage;
    public CommonStepDef commonStepDef;

    @Then("I verify the account page")
    public void verifyAccountPageELements() {

        List<WebElementFacade> accountElements = new ArrayList<>();
        accountElements.add(accountPage.SERVICE_NAME_LABEL());
        accountElements.add(accountPage.SERVICE_PLAN_LABEL());
        accountElements.add(accountPage.LOGOUT_BUTTON());
        accountElements.add(accountPage.HELP_US_BUTTON());

        logger.info(String.format("verifyAccountPageELements %s", accountElements));
        accountElements.forEach(WebElementState::shouldBeVisible);
    }

    @And("I cancel the authentication dialog if exists")
    public void iCancelTheAuthenticationDialog() {
        logger.info("iVerifyTheFollowingElementInTheDashboardPage");

        waitFor(5000);
        if (accountPage.AUTHORIZATION_DIALOG().isDisplayed()) {
            commonStepDef.getDriver().switchTo().frame("authorization-options-iframe");
            commonStepDef.getDriver().findElement(accountPage.AUTHORIZATION_DIALOG_EXIT_BUTTON).click();
            commonStepDef.getDriver().findElement(accountPage.AUTHORIZATION_DIALOG_YES_BUTTON).click();
            commonStepDef.switchToParentFrame();
        }
    }

    @And("I click the Menu Item {}")
    public void iClickTheMenuItemReferAFriend(String menuItem) {
        logger.info("iClickTheMenuItemReferAFriend");
        commonStepDef.clickElement(accountPage.MAIN_MENU_ITEM(menuItem));
    }
}
    
