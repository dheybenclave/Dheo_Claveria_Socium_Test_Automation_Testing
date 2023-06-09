package pages.AmaysimPage;

import net.serenitybdd.core.pages.WebElementFacade;
import pages.common.CommonPage;

//@DefaultUrl("https://accounts.amaysim.com.au/identity/login")
public class DashboardPage extends CommonPage {

    public WebElementFacade WELCOME_HEADER() {
        return $("//span[@id='WelcomeMessage']");
    }
    public WebElementFacade SERVICES_BUTTON() {
        return $("//div[@class='sc-kfGgVZ jxuMAt']//*[text()='services']");
    }
    public WebElementFacade ACCOUNT_BUTTON() {
        return $("//div[@class='sc-kfGgVZ jxuMAt']//*[text()='account']");
    }
    public WebElementFacade HELP_BUTTON() {
        return $("//div[@class='sc-kfGgVZ jxuMAt']//*[text()='help']");
    }
    public WebElementFacade LOGOUT_BUTTON() {return $("//a[@class='sc-kIPQKe dEzPVF' and text()='Logout']");}
    public WebElementFacade MANAGE_PLAN_LINKS() {return $("//section[@data-automation-id='mobile']//div[@id='service_tile_mobile']//a[text()='Manage plan']");}

}