package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.BaseTest;

public class MainPage extends BasePage {
    @AndroidFindBy (accessibility = "open menu") private WebElement openMenu;
    @AndroidFindBy (accessibility = "container header") private WebElement containerheader;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='store item'][1]//android.widget.ImageView") private WebElement storeitem;


    public MainPage(AppiumDriver driver) {
        super(driver);
    }
    public MainPage waitForVisibilityofmainpage() {
        waitForVisibility(containerheader);
        return this;
    }

    public MainPage clickStoreItem() {
        clickElement(storeitem);
        return this;
    }

}
