package qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.BaseTest;

public class MainPage extends BaseTest {
    @AndroidFindBy (accessibility = "open menu") private WebElement openMenu;

    public MainPage() {
        // Initialize elements using PageFactory
        if (driver != null) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            throw new IllegalStateException("Driver not initialized. Check your BaseTest setup.");
        }
    }

}
