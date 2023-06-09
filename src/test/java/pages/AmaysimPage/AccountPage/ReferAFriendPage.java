package pages.AmaysimPage.AccountPage;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.common.CommonPage;

//@DefaultUrl("https://accounts.amaysim.com.au/identity/login")
public class ReferAFriendPage extends CommonPage {
    String WIDGET_SCREEN_SELECTOR_PARENT = "//div[@id='Widget-Screen']";
    public WebElementFacade PAGE_HEADER() {
        return $("//div[@class='widget-page-heading']");
    }
    public WebElementFacade WIDGET_SCREEN_LABEL(String labelText) {
        return $(String.format("//div[@id=\"Widget-Screen\"]//*[contains(text(),\"%s\")]", labelText));
    }
    public By URL_TXTBOX = By.xpath("//div[@id='Widget-Screen']//div[@id='r']");
    public By COPY_BUTTON = By.xpath("//div[@id='Widget-Screen']//div[@id='s']");
    public By SEND_TO_TXTBOX = By.xpath("//div[@id='Widget-Screen']//div[@id='s']");
    public By MESSAGE_INPUT_TXTAREA = By.xpath("//div[@id='Widget-Screen']//textarea[@id='b']");
    public By SEND_FRIEND_REMINDER_CHCKBOX = By.xpath("//div[@id='Widget-Screen']//div[contains(@class,'Checkbox-container')]");
    public By RECEIPIENT_ERROR_LABEL = By.xpath("//div[@id=\"recipients-Error\"]");
    public By SHARE_BUTTON = By.xpath("//div[@id='Widget-Screen']//button[@id='c']");
    public By SHARE_AGAIN_BUTTON = By.xpath("//div[@id='Widget-Screen']//button[@id='w']");
    public By MESSENGER_BUTTON = By.xpath("//div[@id='Widget-Screen']//div[@id='o']");
    public By FACEBOOK_BUTTON = By.xpath("//div[@id='Widget-Screen']//div[@id='p']");
    public By TWITTER_BUTTON = By.xpath("//div[@id='Widget-Screen']//div[@id='q']");

}

