package pages.AmaysimPage;

import org.openqa.selenium.By;
import pages.common.CommonPage;

public class HelpPage extends CommonPage {

    String HELP_SELECTOR_PARENT= "//div[@id='container-5843095876']";

    public By HEADER_LABEL = By.xpath("//*[@id='title-45454b6f99']");
    public By HELP_SCREEN_LABEL(String labelText) {
        return By.xpath(String.format("%s//*[text()='%s']", HELP_SELECTOR_PARENT, labelText));
    }
}