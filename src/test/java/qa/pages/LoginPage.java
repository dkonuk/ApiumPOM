package qa.pages;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.BaseTest;

public class LoginPage extends BaseTest {


    @AndroidFindBy (accessibility = "container header") private WebElement containerheader;
    @AndroidFindBy (accessibility = "open menu") private WebElement openMenu;
    @AndroidFindBy (accessibility = "loginButton") private WebElement loginButton;
    @AndroidFindBy (accessibility = "Username input field") private WebElement usernamefield;
    @AndroidFindBy (accessibility = "Password input field") private WebElement passwordfield;
    @AndroidFindBy (accessibility = "Login button") private WebElement loginbutton;

    public LoginPage() {
        // Initialize elements using PageFactory
        if (driver != null) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            throw new IllegalStateException("Driver not initialized. Check your BaseTest setup.");
        }
    }


    public LoginPage waitForVisibilityofmainpage() {
        waitForVisibility(containerheader);
        return this;
    }
    public LoginPage pressmenubutton() {
        clickElement(openMenu);
        return this;
    }
    public LoginPage pressloginpage() {
        clickElement(openMenu);
        return this;
    }
    public LoginPage enterUserName(String username) {
        sendKeys(usernamefield, username);
        return this;
    }
    public LoginPage enterPassword(String password) {
        sendKeys(passwordfield, password);
        return this;
    }
    public MainPage clickLoginButton() {
        clickElement(loginbutton);
        return new MainPage();
    }
}

