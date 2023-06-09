package stepdefinitions.Amaysim;

import io.cucumber.java.en.Then;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AmaysimPage.HelpPage;
import stepdefinitions.common.CommonStepDef;

public class HelpStepDef extends PageObject {
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    public CommonStepDef commonStepDef;
    public HelpPage helpPage;

    @Then("I verify the help page")
    public void verifyAccountPageELements() {
        logger.info("verifyAccountPageELements ");

        waitFor(5000);
        commonStepDef.generatedSwitchHandler();

        while (commonStepDef.i1.hasNext()) {
            String ChildWindow = commonStepDef.i1.next();
            if (!commonStepDef.mainwindow.equalsIgnoreCase(ChildWindow)) {
                logger.info("verifyAccountPageELements  > Window > " + ChildWindow);
                commonStepDef.getDriver().switchTo().window(ChildWindow);
                Assert.assertTrue(commonStepDef.getDriver().findElement(helpPage.HEADER_LABEL).isDisplayed());
                commonStepDef.getDriver().close();
            }
        }
        commonStepDef.switchToMainWindow(commonStepDef.mainwindow);
    }


}
    
