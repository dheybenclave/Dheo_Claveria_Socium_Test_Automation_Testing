package stepdefinitions.DemoASPAwesome;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.ResolvableElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DemoASPAwesemoPage;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;

public class GridStepDef extends PageObject {


    public Actor dheo;
    public pages.common.CommonPage CommonPage;
    public DemoASPAwesemoPage demoASPAwesemoPage;
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    @Then("I verify the grid filter using parent control element")
    public void verifyGridFilteringParentControl() {

        AbstractBooleanAssert<?> isHeaderDisplayed = assertThat(demoASPAwesemoPage.HEADER.isVisible()).isTrue();
        logger.info(String.format("I verify the grid filter using parent control elements is %s ", isHeaderDisplayed), isHeaderDisplayed);
        demoASPAwesemoPage.FILER_GRID_USING_PARENT_CONTROL_GRID().isDisplayed();
    }

    @And("^I filter the grid using the following :$")
    public void filterGridFilteringParentControl(DataTable dataTable) {

        List<Map<String, String>> dataTableList = dataTable.asMaps(String.class, String.class);
        logger.info(String.format("dataTableList %s", dataTableList));

        for (Map<String, String> e : dataTableList) {
            WebElementFacade currentControl = null;
            logger.info(String.format("dataTableList | Control : %s | Field : %s | Value : %s", e.get("control"), e.get("field"), e.get("value")));
            String currValue = String.valueOf(e.get("value"));
            switch (e.get("field")) {
                case "person":
                    currentControl = demoASPAwesemoPage.SEARCH_PERSON_TXTBOX();
                    break;
                case "food":
                    currentControl = demoASPAwesemoPage.SEARCH_FOOD_TXTBOX();
                    break;
                case "country":
                    selectFilterCountry(currValue);
                    break;
                default:
                    break;
            }
            if (currentControl != null) {
                assertThat(currentControl.isVisible()).isTrue();
                currentControl.typeAndTab(currValue);
                waitABit(1000);
                Assert.assertEquals(currentControl.getValue(), currValue);
            }
        }
        waitABit(2000);
    }

    public void selectFilterCountry(String selectCountry) {
        logger.info(String.format("selectFilterCountry | Value: %s", selectCountry));
        demoASPAwesemoPage.SEARCH_COUNTRY_DRPDOWN().click();
        demoASPAwesemoPage.SEARCH_COUNTRY_DRPDOWN_ITEM().typeAndEnter(selectCountry);
    }

    @Then("^I validate the grid result using the following :$")
    public void iValidateTheGridResultUsingTheFollowing(DataTable dataTable) {
        List<String> actualResultList = getGridResult();
        List<List<String>> expectedResultList = dataTable.asLists();

        Assert.assertEquals(String.format("The Expected(%s) and Actual(%s) Result size in Grid List is not the same ", expectedResultList.size() - 1, actualResultList.size()), expectedResultList.size() - 1, actualResultList.size());

        for (int i = 0; i < actualResultList.size(); i++) {

            if (i == 0) continue;
            String currExpectedList = expectedResultList.get(i).toString().replaceAll("\\[|\\]|,", "");
            String currActualList = actualResultList.get(i);
            logger.info(String.format("currExpectedList %s | currActualList %s", currExpectedList, actualResultList.get(i)));

            Assert.assertEquals(currActualList, currExpectedList);
        }
    }

    public List<String> getGridResult() {
        return demoASPAwesemoPage.FILER_GRID_USING_PARENT_CONTROL_GRID_ROW().stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}


