package pages.AmaysimPage.AccountPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import pages.common.CommonPage;

//@DefaultUrl("https://accounts.amaysim.com.au/identity/login")
public class AccountPage extends CommonPage {

    public WebElementFacade SERVICE_NAME_LABEL() { return $("//div[@class='service-primary-heading']");}
    public WebElementFacade SERVICE_PLAN_LABEL() {return $("//div[@class='service-secondary-heading']");}
    public WebElementFacade LOGOUT_BUTTON() {return $("//a[@id='logout-link']");}

    public WebElementFacade MAIN_MENU_ITEM(String meneItemName) {
        return $(String.format("//ul[@id='menu_list']//li[contains(@class,'ama-menu-item') or contains(@class,'ama-submenu-item')]//*[text()='%s']", meneItemName));
    }

// ================================================START FOR AUTHORIZATION DIALOG======================================================//
    public WebElementFacade AUTHORIZATION_DIALOG() {return $("//div[@data-authorization-options-path]//iframe");}
    public By AUTHORIZATION_DIALOG_EXIT_BUTTON = By.xpath("//div[@id='__next']//a[@class='css-908td8']");
    public By AUTHORIZATION_DIALOG_YES_BUTTON = By.xpath("//button[@id='cancelMfaYes']");
    public By AUTHORIZATION_DIALOG_NO_BUTTON = By.xpath("//button[@id='cancelMfaNo']");

// ================================================END FOR AUTHORIZATION DIALOG======================================================//

// ==========================================================START HELP US IMPROVE ==================================================//
    public WebElementFacade HELP_US_BUTTON() {return $("//div[@aria-label='Usabilla Feedback Button']");}
    public WebElementFacade HELP_US_INPROVE_DIALOG() {return $("//iframe[@id='generatedIframe929960180392866']");}
    public By HELP_US_INPROVE_DIALOG_EXIT_BUTTON = By.xpath("//div[@id='contents']//*[@class='close']");
    public By HELP_US_INPROVE_DIALOG_LABEL(String labelText) {
        return By.xpath(String.format("//div[@id='contents']//*[text()='%s']", labelText));
    }

// ==========================================================END HELP US IMPROVE ====================================================//


// ==========================================================START FOOTER ===========================================================//


// ==========================================================END FOOTER =============================================================//

}


