package stepdefinitions.Amaysim.AccountPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AmaysimPage.AccountPage.ReferAFriendPage;
import stepdefinitions.common.CommonStepDef;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ReferAFriendDef extends PageObject {
    public static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    public CommonStepDef commonStepDef;
    public ReferAFriendPage referafriendPage;
    List<By> referAFriendElements = new ArrayList<>();

    /**
     * @Note : This method will switch to Refer A Friend Iframe, and it will NOT return to PARENT FRAME,
     * You can use the "commonStepDef.switchToParentFrame()"
     */
    public void switchToReferAFriendFrame() {
        logger.info("switchToReferAFriendFrame");
        commonStepDef.getDriver().switchTo().frame("fb-ed73e7d5-f48b-45f0-b558-4cbecd0a4caf");
    }

    @Then("I verify the refer a friend page")
    public void verifyReferAFriendPageELements() {
        waitFor(referafriendPage.PAGE_HEADER());
        switchToReferAFriendFrame();

        referAFriendElements.add(referafriendPage.URL_TXTBOX);
        referAFriendElements.add(referafriendPage.COPY_BUTTON);
        referAFriendElements.add(referafriendPage.SEND_TO_TXTBOX);
        referAFriendElements.add(referafriendPage.MESSAGE_INPUT_TXTAREA);
        referAFriendElements.add(referafriendPage.SEND_FRIEND_REMINDER_CHCKBOX);
        referAFriendElements.add(referafriendPage.SHARE_BUTTON);
        referAFriendElements.add(referafriendPage.MESSENGER_BUTTON);
        referAFriendElements.add(referafriendPage.FACEBOOK_BUTTON);
        referAFriendElements.add(referafriendPage.TWITTER_BUTTON);

        logger.info(String.format("verifyReferAFriendPageELements %s", referAFriendElements));
        for (By referAFriendElement : referAFriendElements) {
            Assert.assertTrue(commonStepDef.getDriver().findElement(referAFriendElement).isDisplayed());
        }
    }

    @Then("I verify the visible label in the refer a friend page :")
    public void verifyVisibleLabelReferAFriendPage(DataTable dataTable) {
        List<String> expectedElementTextList = dataTable.asList();
        waitFor(referafriendPage.PAGE_HEADER());
        switchToReferAFriendFrame();
        logger.info(String.format("verifyVisibleLabelReferAFriendPage:", expectedElementTextList));
        for (String expectedElementText : expectedElementTextList) {
            commonStepDef.verifyVisibilityofElement(referafriendPage.WIDGET_SCREEN_LABEL(expectedElementText));
        }
    }

    @Then("I validate and Verify the Referral Section")
    public void iValidateAndVerifyTheReferralCopyLink() throws AWTException, InterruptedException {

        waitFor(referafriendPage.PAGE_HEADER());
        switchToReferAFriendFrame();

        List<By> referralElements = new ArrayList<>();
        referralElements.add(referafriendPage.URL_TXTBOX);
        referralElements.add(referafriendPage.COPY_BUTTON);

        logger.info(String.format("iValidateAndVerifyTheReferralCopyLink %s", referralElements));
        for (By referralElement : referralElements) {

            logger.info(String.format("Will Click the Referral Link from %s to copy the link", referralElement));
            commonStepDef.getDriver().findElement(referralElement).click();
            Thread.sleep(2000);

            WebElement MESSAGE_INPUT_TXTAREA = commonStepDef.getDriver().findElement(referafriendPage.MESSAGE_INPUT_TXTAREA);
            MESSAGE_INPUT_TXTAREA.click(); MESSAGE_INPUT_TXTAREA.clear();
            MESSAGE_INPUT_TXTAREA.sendKeys(String.format("Before Pasting the Link from %s", referralElement));
            Thread.sleep(2000);
            MESSAGE_INPUT_TXTAREA.clear(); MESSAGE_INPUT_TXTAREA.click();
            Thread.sleep(2000);

            logger.info(String.format("Will Paste the Referral Link copied in the Referral %s ", referralElement));
            Actions actions = new Actions(commonStepDef.getDriver());
            actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
            Thread.sleep(2000);

            String pastedTextLink = getDriver().findElement(referafriendPage.URL_TXTBOX).getText();
            boolean isValue= pastedTextLink.contains(MESSAGE_INPUT_TXTAREA.getAttribute("value"));
            Assert.assertTrue(String.format("Expected Verification of PastedText from Element %s is %s ", referralElement, isValue), isValue);
        }
    }

    @Then("I validate and Verify the Share Section")
    public void iValidateAndVerifyTheShare() {
        logger.info("iValidateAndVerifyTheShare");

        waitFor(referafriendPage.PAGE_HEADER());
        switchToReferAFriendFrame();

        WebElement MESSAGE_INPUT_TXTAREA = commonStepDef.getDriver().findElement(referafriendPage.MESSAGE_INPUT_TXTAREA);
        WebElement SHARE_BUTTON = commonStepDef.getDriver().findElement(referafriendPage.SHARE_BUTTON);
        WebElement SEND_TO_TXTBOX = commonStepDef.getDriver().findElement(referafriendPage.SEND_TO_TXTBOX);
        WebElement SEND_FRIEND_REMINDER_CHCKBOX = commonStepDef.getDriver().findElement(referafriendPage.SEND_FRIEND_REMINDER_CHCKBOX);

        logger.info("iValidateAndVerifyTheShare - Validate MESSAGE_INPUT_TXTAREA");
        MESSAGE_INPUT_TXTAREA.click(); MESSAGE_INPUT_TXTAREA.clear();
        MESSAGE_INPUT_TXTAREA.sendKeys("Greetings from the Automation Testing");

        logger.info("iValidateAndVerifyTheShare - Validate and Verify SHARE_BUTTON and RECEIPIENT_ERROR_LABEL ");
        SHARE_BUTTON.click();
        WebElement RECEIPIENT_ERROR_LABEL = commonStepDef.getDriver().findElement(referafriendPage.RECEIPIENT_ERROR_LABEL);
        shouldBeVisible(RECEIPIENT_ERROR_LABEL);
        SEND_FRIEND_REMINDER_CHCKBOX.click();
//        SEND_TO_TXTBOX.sendKeys("testing@mailinator.com");
//        String getValue = SEND_TO_TXTBOX.getAttribute("value");
//        Assert.assertEquals("Verify the Email Account Inputted", "testing@mailinator.com", getValue);
    }

    @Then("I validate and Verify the {} Social Media")
    public void iValidateAndVerifyTheSocialMedia(String socialMedia) {
        logger.info("iValidateAndVerifyTheShare");


        waitFor(referafriendPage.PAGE_HEADER());
        switchToReferAFriendFrame();
        WebElement SOCIAL_MEDIA_BUTTON = null;

        switch (socialMedia) {
            case "Messenger":
                SOCIAL_MEDIA_BUTTON = commonStepDef.getDriver().findElement(referafriendPage.MESSENGER_BUTTON);
                break;
            case "Facebook":
                SOCIAL_MEDIA_BUTTON = commonStepDef.getDriver().findElement(referafriendPage.FACEBOOK_BUTTON);
                break;
            case "Twitter":
                SOCIAL_MEDIA_BUTTON = commonStepDef.getDriver().findElement(referafriendPage.TWITTER_BUTTON);
                break;
        }

        if (SOCIAL_MEDIA_BUTTON != null) {
            logger.info("iValidateAndVerifyTheSocialMedia");
            SOCIAL_MEDIA_BUTTON.click();

            waitFor(5000);
            commonStepDef.generatedSwitchHandler();
            while (commonStepDef.i1.hasNext()) {
                String ChildWindow = commonStepDef.i1.next();
                if (!commonStepDef.mainwindow.equalsIgnoreCase(ChildWindow)) {
                    logger.info("iValidateAndVerifyTheSocialMedia  > Window > " + ChildWindow);
                    commonStepDef.getDriver().switchTo().window(ChildWindow);
                    commonStepDef.getDriver().close();
                }
            }
            commonStepDef.switchToMainWindow(commonStepDef.mainwindow);
        }
    }

    @And("I click the Share Again button")
    public void iClickTheShareAgainButton() {
        logger.info("iClickTheShareAgainButton");
        waitFor(referafriendPage.PAGE_HEADER());
        switchToReferAFriendFrame();
        commonStepDef.getDriver().findElement(referafriendPage.SHARE_AGAIN_BUTTON).click();
    }
}
    
