package pages;

import net.serenitybdd.core.annotations.findby.*;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.pages.PageObject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.FindAll;
import pages.common.CommonPage;

@DefaultUrl("https://demo.aspnetawesome.com/")
public class DemoASPAwesemoPage extends CommonPage {

    static String PARENT_HEADER = "//div[@id='demoPage']//*[@class='conthead']";
    @FindBy(xpath = "//div[@id='demoMenu']//input[@id='msearch']")
    public WebElementFacade NAVIGATION_SEARCH_TXTBOX;

    @FindBy(xpath = "//div[@id='demoPage']//*[@class='conthead']")
    public WebElementFacade HEADER;

    public WebElementFacade FILER_GRID_USING_PARENT_CONTROL_GRID() {
        return $(PARENT_HEADER + "/following::*[@id='Grid1']");
    }
    public ListOfWebElementFacades FILER_GRID_USING_PARENT_CONTROL_GRID_ROW() {
        String selector =PARENT_HEADER + "//*/following::*[@id='Grid1']//div[@class='awe-content awe-tablc']//tbody/tr";
        return findAll(By.xpath(selector));
    }
    public WebElementFacade SEARCH_PERSON_TXTBOX() {
        return $(PARENT_HEADER + "/following::*[@id='txtPerson-awed']");
    }

    public WebElementFacade SEARCH_FOOD_TXTBOX() {
        return $(PARENT_HEADER + "/following::*[@id='txtFood-awed']");
    }

    public WebElementFacade SEARCH_COUNTRY_DRPDOWN() {
        return $(PARENT_HEADER + "/following::*[@id='selCountry']/..");
    }

    public WebElementFacade SEARCH_COUNTRY_DRPDOWN_ITEM() {
        //*[@id="selCountry-dropmenu"]//input[@class="o-src awe-txt"]
        return $("//*[@id='selCountry-dropmenu']//input[@class='o-src awe-txt']");
    }


}