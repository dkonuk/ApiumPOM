package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.BaseTest;

public class MainPage extends BasePage {
    @AndroidFindBy (accessibility = "open menu") private WebElement openMenu;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

}
