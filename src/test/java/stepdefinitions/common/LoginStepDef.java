package stepdefinitions.common;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AmaysimPage.DashboardPage;
import pages.AmaysimPage.LoginPage;
import pages.NavigateTo;
import utils.UserCredentials;

public class LoginStepDef extends PageObject {
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public CommonStepDef commonStepDef;
    String _username = "";
    String _password = "";

    @Given("{actor} login in the application {} as {}")
    public void LoginUser(Actor actor, String page, String userType) {
        commonStepDef.dheo = actor;
        commonStepDef.dheo.attemptsTo(NavigateTo.thePage(page));
        commonStepDef.iNavigateTo(actor, page);

        logger.info(String.format("I login in the application as %s", userType));

        switch (userType) {
            case "Customer":
                _username = UserCredentials.Customer.getUsername();
                _password = UserCredentials.Customer.getPassword();
                break;
            case "Admin":
                _username = UserCredentials.Admin.getUsername();
                _password = UserCredentials.Admin.getPassword();
                break;
            default:
                break;
        }
        waitABit(2000);
        commonStepDef.verifyVisibilityofElement(loginPage.USERNAME_TXTBOX());
        loginPage.USERNAME_TXTBOX().typeAndTab(_username);
        loginPage.PASSWORD_TXTBOX().type(_password);
        loginPage.LOGIN_BUTTON().click();
        waitABit(2000);
    }


}
