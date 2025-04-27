package qa.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage  {
    @AndroidFindBy (accessibility = "container header") private WebElement containerheader;
    @AndroidFindBy (accessibility = "open menu") private WebElement openMenu;
    @AndroidFindBy (accessibility = "menu item log in") private WebElement loginButton;
    @AndroidFindBy (accessibility = "Username input field") private WebElement usernamefield;
    @AndroidFindBy (accessibility = "Password input field") private WebElement passwordfield;
    @AndroidFindBy (accessibility = "Login button") private WebElement loginbutton;

    public LoginPage(AppiumDriver driver) {
        // Initialize elements using PageFactory
        super(driver);
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
        clickElement(loginButton);
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
        return new MainPage(driver);
    }
    public LoginPage clearInputFields() {
        clearInputField(usernamefield);
        clearInputField(passwordfield);
        return this;
    }
}

