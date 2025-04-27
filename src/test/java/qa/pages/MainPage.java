package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

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

    public BackPackProductPage clickStoreItem() {
        clickElement(storeitem);
        return new BackPackProductPage(driver);
    }

}
