package pages.common;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CommonPage extends PageObject {

    @FindBy(xpath = "//div[@data-g='Menu']//*[@class='awe-ce-ico']/parent::*")
    public static WebElementFacade NAVIGATE_MODULE_PARENT;

    public WebElementFacade NAVIGATE_MODULE_SUB(String groupName) {
        WebElementFacade selector = $("(//div[@data-g='Menu']//*[contains(@class,'awe-cbc')]/following::*[text()='" + groupName + "'])[1]");
        return selector;
    }

    public WebElementFacade PAGE_CONTROL_LABEL(String labelText) {
        return $(String.format("//*[contains(text(),'%s')]", labelText));

    }

}

