package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class BackPackProductPage extends BasePage {
    @AndroidFindBy (accessibility = "Add To Cart button") private WebElement addToCartButton;
    @AndroidFindBy (accessibility = "blue circle") private WebElement blueCircle;

    public BackPackProductPage(AppiumDriver driver) {
        super(driver);
    }
    public BackPackProductPage chooseBlueCircle() {
        clickElement(blueCircle);
        return this;
    }
    public BackPackProductPage clickAddToCartButton() {
        clickElement(addToCartButton);
        return this;
    }


}
