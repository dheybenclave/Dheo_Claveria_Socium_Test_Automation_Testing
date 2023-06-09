package pages.AmaysimPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import pages.common.CommonPage;

@DefaultUrl("https://accounts.amaysim.com.au/identity/login")
public class LoginPage extends CommonPage {

    public WebElementFacade USERNAME_TXTBOX() { return $("//input[@id='username']");}
    public WebElementFacade PASSWORD_TXTBOX() { return $("//input[@id='password']"); }
    public WebElementFacade LOGIN_BUTTON() { return $("//button[text()='Login' and @data-disable-with='logging in']"); }

}